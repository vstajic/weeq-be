CREATE TABLE IF NOT EXISTS customer
(
    id               BIGSERIAL PRIMARY KEY,

    username         TEXT UNIQUE NOT NULL,
    password         TEXT        NOT NULL,
    first_name       TEXT,
    last_name        TEXT,

    created_at       TIMESTAMPTZ NOT NULL,
    updated_at       TIMESTAMPTZ NOT NULL,
    created_by       TIMESTAMPTZ NOT NULL,
    last_modified_by timestamptz,
    version          INTEGER     NOT NULL
);
COMMENT ON TABLE customer IS 'Defines a customer.';



CREATE TABLE IF NOT EXISTS customer_address
(
    id               BIGSERIAL PRIMARY KEY,

    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer (id),

    street           TEXT        NOT NULL,
    street_number    TEXT        NOT NULL,
    city             TEXT        NOT NULL,
    zip_code         TEXT        NOT NULL,
    country          TEXT        NOT NULL,

    created_at       TIMESTAMPTZ NOT NULL,
    updated_at       TIMESTAMPTZ NOT NULL,
    created_by       TIMESTAMPTZ NOT NULL,
    last_modified_by timestamptz,
    version          INTEGER     NOT NULL
);
COMMENT ON TABLE customer IS 'Defines a customer customer address.';
