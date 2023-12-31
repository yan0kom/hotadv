INSERT INTO addresses (id, zip_code, city, street, house, apartment) VALUES 
	(1, '191023', 'Санкт-Петербург', 'наб.р. Фонтанки', '59, БЦ «Лениздат»', 'оф.521'),
	(2, '127002', 'Москва', 'Перова', '23', '8'),
	(3, '127003', 'Москва', 'Перова', '23', '8'),
	(4, '127004', 'Москва', 'Перова', '23', '8'),
	(5, '127005', 'Москва', 'Перова', '23', '8'),
	(6, '127006', 'Москва', 'Перова', '23', '8'),
	(7, '127007', 'Москва', 'Перова', '23', '8'),
	(8, '127008', 'Москва', 'Перова', '23', '8'),
	(9, '127009', 'Москва', 'Перова', '23', NULL),
	(10, NULL, 'Москва', 'Авиамоторная', '14 корп. 2', '40а');
	
INSERT INTO companies (id, name, legal_form, address_id) VALUES
    (1, 'HotelAdvisors', 'ООО', 1),
	(2, 'Компания 2', 'ООО', 2),
	(3, 'Компания 3', 'АО', 3);
	
INSERT INTO branches (id, name, company_id , address_id) VALUES
	(1, 'Филиал 1 компании 2', 2, 5),
	(2, 'Филиал 2 компании 2', 2, 6),
	(3, 'Филиал 1 компании 3', 3, 7);
