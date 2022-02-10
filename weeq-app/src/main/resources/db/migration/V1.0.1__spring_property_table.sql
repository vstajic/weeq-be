CREATE TABLE IF NOT EXISTS spring_property
(
    id          BIGSERIAL PRIMARY KEY,
    application TEXT      NOT NULL,
    key         TEXT      NOT NULL,
    value       TEXT      NOT NULL,
    profile     TEXT
);
COMMENT ON TABLE spring_property IS 'Configuration read by spring based applications.';
CREATE UNIQUE INDEX IF NOT EXISTS idx_spring_property_app_key_profile ON spring_property (application, key, profile);