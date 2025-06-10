CREATE SEQUENCE corridas_seq start with 1 increment by 1;

CREATE TABLE corridas (
    int BIGINT PRIMARY KEY DEFAULT nextval('corridas_seq'),
    nome VARCHAR(100) NOT NULL,
    local VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    status VARCHAR(255) NOT NULL
);