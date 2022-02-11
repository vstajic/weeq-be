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

    customer_id      BIGINT,
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



CREATE TABLE IF NOT EXISTS brand
(
    id               BIGSERIAL PRIMARY KEY,

    name             TEXT        NOT NULL,
    description      TEXT,

    created_at       TIMESTAMPTZ NOT NULL,
    updated_at       TIMESTAMPTZ NOT NULL,
    created_by       TIMESTAMPTZ NOT NULL,
    last_modified_by TIMESTAMPTZ,
    version          INTEGER     NOT NULL
);
COMMENT ON TABLE brand IS 'Defines a product being offered at the store.';



CREATE TABLE IF NOT EXISTS product
(
    id                BIGSERIAL PRIMARY KEY,

    brand_id          BIGINT,
    FOREIGN KEY (brand_id) REFERENCES brand (id),

    name              TEXT        NOT NULL,
    alias             TEXT        NOT NULL,
    short_description TEXT        NOT NULL,
    full_description  TEXT        NOT NULL,
    technical_details TEXT        NOT NULL,
    enabled           BOOLEAN     NOT NULL DEFAULT TRUE,
    available         BOOLEAN     NOT NULL DEFAULT TRUE,

    created_at        TIMESTAMPTZ NOT NULL,
    updated_at        TIMESTAMPTZ NOT NULL,
    created_by        TIMESTAMPTZ NOT NULL,
    last_modified_by  TIMESTAMPTZ,
    version           INTEGER     NOT NULL
);
COMMENT ON TABLE product IS 'Defines a product being offered at the store.';
CREATE INDEX IF NOT EXISTS idx_product_id ON product (id);
CREATE INDEX IF NOT EXISTS idx_product_name ON product (name);
CREATE INDEX IF NOT EXISTS idx_product_about ON product (short_description);



CREATE TABLE IF NOT EXISTS price_model
(
    id               BIGSERIAL PRIMARY KEY,

    product_id       BIGINT,
    FOREIGN KEY (product_id) REFERENCES product (id),

    price            BIGINT      NOT NULL,
    batch_price      BIGINT,
    currency         TEXT        NOT NULL,

    created_at       TIMESTAMPTZ NOT NULL,
    updated_at       TIMESTAMPTZ NOT NULL,
    created_by       TIMESTAMPTZ NOT NULL,
    last_modified_by TIMESTAMPTZ,
    version          INTEGER     NOT NULL
);
COMMENT ON TABLE price_model IS 'Data that determines prices of current products.';
CREATE INDEX IF NOT EXISTS idx_price_model_lottery ON price_model (product_id);



CREATE TABLE IF NOT EXISTS basket_items
(
    id               BIGSERIAL PRIMARY KEY,

    customer_id      BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer (id),

    product_id       BIGINT,
    FOREIGN KEY (product_id) REFERENCES product (id),

    quantity         INTEGER     NOT NULL,

    created_at       TIMESTAMPTZ NOT NULL,
    updated_at       TIMESTAMPTZ NOT NULL,
    created_by       TIMESTAMPTZ NOT NULL,
    last_modified_by TIMESTAMPTZ,
    version          INTEGER     NOT NULL
);
COMMENT ON TABLE basket_items IS 'Defines a product being offered at the store.';
CREATE INDEX IF NOT EXISTS idx_basket_items_product_customer ON basket_items (product_id, customer_id);
CREATE INDEX IF NOT EXISTS idx_basket_items_product ON basket_items (product_id);
CREATE INDEX IF NOT EXISTS idx_basket_items_customer ON basket_items (customer_id);