-- Esquema aislado de Security Service (MySQL 8.4).
-- Los UUID se almacenan como BINARY(16), formato predeterminado de Hibernate 6 para UUID en MySQL.
CREATE TABLE usuarios (
    id BINARY(16) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'CLIENTE', 'REPARTIDOR') NOT NULL,
    eneable BIT(1) NOT NULL,
    created_date DATETIME(6) NULL,
    last_modified_date DATETIME(6) NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (id),
    CONSTRAINT uk_usuarios_username UNIQUE (username),
    CONSTRAINT uk_usuarios_email UNIQUE (email)
);
