CREATE TABLE IF NOT EXISTS tabela_logs (
    conta_id INT AUTO_INCREMENT PRIMARY KEY,
    status_antigo VARCHAR(50),
    status_novo VARCHAR(50),
    data_alteracao DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- DELIMITER //
--     CREATE TRIGGER proc_log_status_conta
--   BEFORE UPDATE ON clientes
--   FOR EACH ROW
--   BEGIN
--       IF OLD.status != NEW.status THEN
--         INSERT INTO tabela_logs (conta_id, status_antigo, status_novo, data_alteracao)
--         VALUES (OLD.id, OLD.status, NEW.status, NOW());
--       END IF;
--   END;
--
-- DELIMITER ;