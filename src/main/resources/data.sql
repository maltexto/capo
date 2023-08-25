INSERT INTO product (barcode, name, minimum_quantity, initial_balance) VALUES
('1234567890', 'Pen', 10, 100),
('9876543210', 'Pencil', 20, 200);

INSERT INTO movement (product_id, movement_type, quantity, date, reason, document) VALUES
(1, 'ENTRY', 10, '2023-08-18', 'BUY', '123456789'),
(1, 'EXIT', 5, '2023-08-19', 'SELL', '987654321'),
(1, 'INITIAL_BALANCE', 100, '2023-08-18', null, null),
(1, 'ENTRY_ADJUSTMENT', 5, '2023-08-19', null, null),
(1, 'EXIT_ADJUSTMENT', 2, '2023-08-20', null, null);