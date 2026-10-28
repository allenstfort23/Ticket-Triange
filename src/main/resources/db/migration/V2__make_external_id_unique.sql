ALTER TABLE tickets
ADD CONSTRAINT uq_tickets_external_id UNIQUE (external_id);