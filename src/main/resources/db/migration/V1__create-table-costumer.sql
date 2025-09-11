CREATE TABLE costumers(
    costumer_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    name VARCHAR NOT NULL,
    birth_date DATE NOT NULL,
    sex VARCHAR(1) NOT NULL,
     CONSTRAINT chk_sex CHECK (sex IN ('F','M')),
    address VARCHAR NOT NULL,
    is_Deleted BOOLEAN DEFAULT FALSE
)