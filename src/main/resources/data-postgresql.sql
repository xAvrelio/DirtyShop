INSERT INTO brands
values (1, 'Samsung'),
       (2, 'Huawei'),
       (3, 'Apple'),
       (4, 'Unbranded'),
       (5, 'Adidas'),
       (6, 'Puma');

INSERT INTO category
values (1, 'Phones', 'Desc Phones', null),
       (2, 'Cellular', 'Desc cellular', 1),
       (3, 'Mobile', 'Desc mobile', 1),
       (4, 'Clothes', 'Best clothes', null),
       (5, 'Shoes', 'Desc shoes', 4),
       (6, 'Belt', 'Desc Belts', 4),
       (7, 'Shirt', 'Desc shirt...', 4),
       (8, 'T-Shirt', 'Desc t-shirt...', 7),
       (9, 'Polo', 'Desc polo...', 7),
       (10, 'Jersey', 'Desc jersey...', 7),
       (11, 'Games', 'Desc game...', null);

INSERT INTO conditions
VALUES (1, 'NEW'),
       (2, 'Used'),
       (3, 'Box Opened');

INSERT INTO return_polices
VALUES (1, 'No return accepted'),
       (2, '14 day for return'),
       (3, '30 day for return');


INSERT INTO warehouse
VALUES (1, 'London', '951 Mill Road London SE67 0UB'),
       (2, 'Paris', '78 Place de la Madeleine'),
       (3, 'Portugal', 'Rua pau da Linha 36'),
       (4, 'Ukraine', 'Chernigov, etc...');

INSERT INTO specifics
VALUES (1, 'Weight', 1),
       (2, 'Size', 1);

INSERT INTO specifics_values
VALUES (1, '100', 1),
       (2, '200', 1),
       (3, '5.5 inch', 2),
       (4, '6 inch', 2);

INSERT INTO category_specifics
VALUES (1, 1),
       (1, 2);

INSERT INTO items
VALUES (1, 'Huawei p30 Lite', '<div>Full Description</div>', true, 200.33, '<span>Short Desc</span>', 2, 1),
       (2, 'Samsung A420', '<div>Full Description</div>', true, 100.33, '<span>Short Desc</span>', 1, 1);

INSERT INTO item_conditions
VALUES (1, 'Some parts with scratches', 2, 2),
       (2, 'Full New', 1, 1);

INSERT INTO item_return_polices
VALUES (1, 'Only if no open we accept', 2, 1),
       (2, 'Product to old no return accept', 1, 1);

INSERT INTO item_warehouse
VALUES (1, 2, 1, 1),
       (2, 20, 2, 2),
       (3, 25, 2, 1);

INSERT INTO item_specs
VALUES (1, 1, 2, 1),
       (2, 1, 3, 2),
       (3, 2, 1, 1),
       (4, 2, 4, 2);


INSERT INTO photos (id, main_url, ord_id, thumb_url, item_id)
VALUES (1, '/img/asd.jpg', 1, '/img/thumb/asd.jpg', 1),
       (2, '/img/asd.jpg', 2, '/img/thumb/asd.jpg', 1),
       (3, '/img/asd.jpg', 3, '/img/thumb/asd.jpg', 1),
       (4, '/img/asd.jpg', 4, '/img/thumb/asd.jpg', 1);




