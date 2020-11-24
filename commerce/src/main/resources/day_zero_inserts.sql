INSERT INTO `users` (`id`, `created_at`, `email`, `firstname`, `lastname`, `password`, `updated_at`, `username`)
VALUES
	(1, '2020-11-24 02:56:46', 'francissujai@gmail.com', 'Sujai', 'Francis', '$2a$10$HB5wIfBek1uEasb/C7C3cuVcCMgsU6rcZe19e2QAoMQLTR3RB2uJC', '2020-11-24 02:56:46', 'sujai'),
	(2, '2020-11-24 03:05:51', 'francissujai01@gmail.com', 'Sujai', 'Francis', '$2a$10$Y3cjhZNrTSNsc7s0OVug5u.ivyy3mnIt6pfNxxstQasCUPq/WoP5S', '2020-11-24 03:05:51', 'sujai01'),
	(3, '2020-11-24 03:05:55', 'francissujai02@gmail.com', 'Sujai', 'Francis', '$2a$10$KQlOAqpK.NzCjq.kwCyfV.x.KoXD6yqoyv3oAg.i17pt3N3XrLg3K', '2020-11-24 03:05:55', 'sujai02'),
	(4, '2020-11-24 03:05:58', 'francissujai03@gmail.com', 'Sujai', 'Francis', '$2a$10$65lhREiOYG2x0KWW0I8y9OXlUySSXeQ.vHr0f1QGCQVRltCZKBtS.', '2020-11-24 03:05:58', 'sujai03'),
	(5, '2020-11-24 03:06:02', 'francissujai04@gmail.com', 'Sujai', 'Francis', '$2a$10$60tdVpReeo2mM71AXR3fcu4mGnIEkDcJRoBSKRQb.n0IIdf/UQdwi', '2020-11-24 03:06:02', 'sujai04'),
	(6, '2020-11-24 03:06:06', 'francissujai05@gmail.com', 'Sujai', 'Francis', '$2a$10$tZ1a9MFnTRAIhoZ8HuYvqOj6ipNb/I8Sk6IELerH3sZgr01IDl2wq', '2020-11-24 03:06:06', 'sujai05'),
	(7, '2020-11-24 03:06:09', 'francissujai06@gmail.com', 'Sujai', 'Francis', '$2a$10$snWOdUv.y2GPUeo6TVFWNOHKdU6mJPb7BJN6muEp5FWUpUG/w7pE.', '2020-11-24 03:06:09', 'sujai06'),
	(8, '2020-11-24 03:06:13', 'francissujai07@gmail.com', 'Sujai', 'Francis', '$2a$10$ata8FqhZU4ZSh01jNpnFxucytMjcb95S3bL.r9Rm86Lfm61oo5cJq', '2020-11-24 03:06:13', 'sujai07'),
	(9, '2020-11-24 03:06:17', 'francissujai08@gmail.com', 'Sujai', 'Francis', '$2a$10$qxY4r.KKKrGCjenT5shtPuggUUdx7df9vjjxhDNssSOWaY3nOcgAW', '2020-11-24 03:06:17', 'sujai08'),
	(10, '2020-11-24 03:06:21', 'francissujai09@gmail.com', 'Sujai', 'Francis', '$2a$10$9i1dQrQay6PgfeHsJUrNdewtQUYcz0VSCxRi/2Imau756vPVDqsei', '2020-11-24 03:06:21', 'sujai09');


INSERT INTO `categories` (`id`, `description`, `name`)
VALUES
	(1, 'All Electronics products including TVs, Mobiles, Household items', 'Electronics'),
	(2, 'All apparels including mens wear, womens, kids and sports wear.', 'Apparels'),
	(3, 'All kitchen appliances including cookwares.', 'Kitchen Aplicances');


INSERT INTO `products` (`id`, `category_id`, `description`, `item_on_sale`, `last_updated`, `name`, `num_of_reviews`, `rating`, `product_id`)
VALUES
	(1, 1, '75inch UHD Smart TV', 1, '2020-11-24 02:59:02', 'LG Smart', 10, 4.119999999999999, NULL),
	(2, 1, '55inch QLED TV', NULL, '2020-11-24 02:56:48', 'Sony Bravia', 10, 4.02, NULL),
	(3, 1, '13.3 Inch Macbook Pro', NULL, '2020-11-24 02:56:48', 'APple Macbook', 10, 3.5, NULL),
	(4, 2, 'Sweat shirt', NULL, '2020-11-24 02:56:48', 'Nike', 10, 3.8, NULL),
	(5, 2, 'Running shorts', NULL, '2020-11-24 02:56:48', 'Reebok', 10, 4.2, NULL),
	(6, 2, 'Running shoes', 1, '2020-11-24 02:59:35', 'New Balance', 10, 4.7, NULL),
	(7, 3, 'Samsung food processor', NULL, '2020-11-24 02:56:48', 'Samsung', 10, 3.5, NULL),
	(8, 3, 'Microwave Owen', 1, '2020-11-24 02:59:54', 'Kitchenaid', 10, 4.5, NULL),
	(9, 3, 'Egg Beater', NULL, '2020-11-24 02:56:48', 'Panasonic', 10, 4.4, NULL);



INSERT INTO `favourites` (`id`, `product_id`, `user_id`)
VALUES
	(1, 8, 1),
	(2, 3, 1),
	(3, 5, 1);