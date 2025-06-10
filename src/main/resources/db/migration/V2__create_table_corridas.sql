CREATE TABLE corridas (
    id BIGINT PRIMARY KEY DEFAULT nextval('corridas_seq'),
    nome VARCHAR(100) NOT NULL,
    local VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    status VARCHAR(255) NOT NULL
);