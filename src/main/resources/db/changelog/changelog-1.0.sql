CREATE TABLE IF NOT EXISTS methods (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    class_name VARCHAR(255) NOT NULL,
    method_name VARCHAR(255) NOT NULL
);

CREATE TABLE measurements (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    execution_time BIGINT NOT NULL,
    date TIMESTAMP NOT NULL,
    method_id BIGINT NOT NULL,
    CONSTRAINT fk_method_id FOREIGN KEY (method_id) REFERENCES methods(id)
);