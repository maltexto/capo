INSERT INTO product (barcode, name, minimum_quantity, initial_balance) VALUES
('1234567890', 'Caneta', 10, 100),
('9876543210', 'Lápis', 20, 200);

INSERT INTO movement (product_id, movement_type, quantity, date, reason, document) VALUES
(1, 'ENTRADA', 10, '2023-08-18', 'Compra', 'NF-123456789'),
(1, 'SAÍDA', 5, '2023-08-19', 'Venda', 'NF-987654321'),
(1, 'INITIAL_BALANCE', 100, '2023-08-18', 'Estoque inicial', null),
(1, 'ENTRY_ADJUSTMENT', 5, '2023-08-19', 'Ajuste de entrada', null),
(1, 'EXIT_ADJUSTMENT', 2, '2023-08-20', 'Ajuste de saída', null);