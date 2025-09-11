package com.dev.costumer_service.repository;

import com.dev.costumer_service.entity.Costumer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long>  {

    Optional<Costumer> findByCostumerId(UUID costumerId);

    @Modifying
    @Transactional
    @Query("UPDATE Costumer c SET c.isDeleted = :isDeleted WHERE c.costumerId = :costumerId")
    void softDeleteById(UUID costumerId, Boolean isDeleted);


}
