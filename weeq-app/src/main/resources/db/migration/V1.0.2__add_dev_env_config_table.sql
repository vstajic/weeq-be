CREATE TABLE IF NOT EXISTS dev_env_configuration
(
    id               BIGSERIAL PRIMARY KEY,

    env_id           TEXT        NOT NULL,
    state            TEXT,
    details          TEXT,

    version          INTEGER     NOT NULL,
    created_at       TIMESTAMPTZ NOT NULL,
    last_modified_at TIMESTAMPTZ NOT NULL,
    created_by       TEXT        NOT NULL,
    last_modified_by TEXT        NOT NULL
);
COMMENT ON TABLE dev_env_configuration IS 'Stores if dev environment preparations have been executed.';
