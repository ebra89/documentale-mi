-- Protocolli
INSERT INTO protocol (validation_user, is_valid, type, state, create_date, create_user, update_date, update_user) 
VALUES ('Alice Bianchi', 1, 'typeA', 'ok', '2024-10-12', 'admin', '2024-10-13', 'admin');

INSERT INTO protocol (validation_user, is_valid, type, state, create_date, create_user, update_date, update_user) 
VALUES (NULL, 0, 'typeB', 'wait_revision', '2024-10-10', 'Luca Verdi', NULL, 'Luca Verdi');

-- Documenti
INSERT INTO document (ref_number, owner, type, state, location, doc_date, create_date, create_user, update_date, update_user, protocol_id) 
VALUES ('D0001', 'Giovanni', 'TA', 'received', 'MI', '2024-10-12', '2024-10-12', 'admin', '2024-10-12', 'admin', 1);

INSERT INTO document (ref_number, owner, type, state, location, doc_date, create_date, create_user, update_date, update_user, protocol_id) 
VALUES ('D0004', 'Chiara', 'TB', 'received', 'MI', '2024-10-12', '2024-10-12', 'Mario Rossi', '2024-10-12', 'Mario Rossi', 2);

INSERT INTO document (ref_number, owner, type, state, location, doc_date, create_date, create_user, update_date, update_user, protocol_id) 
VALUES ('D0006', 'Giovanni', 'TB', 'verify', 'MI', '2024-10-13', '2024-10-13', 'Luca Verdi', '2024-10-14', 'Mario Rossi', 2);

INSERT INTO document (ref_number, owner, type, state, location, doc_date, create_date, create_user, update_date, update_user, protocol_id) 
VALUES ('D0007', 'Anna', 'TA', 'archived', 'MI', '2024-10-13', '2024-10-13', 'Mario Rossi', '2024-10-13', 'Luca Verdi', 1);

INSERT INTO document (ref_number, owner, type, state, location, doc_date, create_date, create_user, update_date, update_user, protocol_id) 
VALUES ('D0008', 'Anna', 'TB', 'archived', 'MI', '2024-10-14', '2024-10-14', 'Alice Bianchi', '2024-10-14', 'Luca Verdi', 1);