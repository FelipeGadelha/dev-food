ALTER TABLE cities
    ADD COLUMN state_id BIGINT;
ALTER TABLE cities
    ADD CONSTRAINT FK_cities_states
    FOREIGN KEY (state_id) REFERENCES states (id);