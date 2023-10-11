INSERT INTO client (id,name, surname, date_of_birth, mobile_number, email_address, created_timestamp,updated_timestamp				  )
VALUES
    (1,'Tshepo', 'Maema', '1990-02-19', '0767957651', 'tshepo@momentum.com', now(),now()),
    (2,'Tom', 'Maema', '1915-05-15', '0112234455', 'tom@gmail.com', now(),now());

--	select * from products
	INSERT INTO products (id, type, name, balance)
VALUES
   ('0001', 'RETIREMENT', 'Retirement Income Option', 500000),
   ('0002', 'RETIREMENT', 'Retirement Annuity Option', 500000),
   ('0003', 'SAVINGS', 'Flexible Investment Option', 36000),
   ('0004', 'SAVINGS', 'Flexible Endowment Option', 36000);

--   select * from client_product_item

   INSERT INTO public.client_product_item(
	id, amount, created_timestamp, updated_timestamp, client_id, product_id)
	VALUES (6, 20000, now(),now(), 1, 0004),
	(2, 20000, now(),now(), 1, 0002),
	(3, 20000, now(),now(), 2, 0003),
	(4, 20000, now(),now(), 2, 0001),
	(5, 20000, now(),now(), 2, 0004);

--	select * from withdrawal_process_audit
--
--	select * from revinfo



