CREATE TABLE PUBLIC.product
  (
     id      BIGSERIAL NOT NULL,
     code VARCHAR(10) NOT NULL,
     name VARCHAR NULL,
     price_eur NUMERIC(12,2) NULL,
     price_usd NUMERIC(12,2) NULL,
     is_available boolean NOT NULL,
     CONSTRAINT product_pk PRIMARY KEY (id),
     CONSTRAINT product_uq UNIQUE (code)
  );