CREATE TABLE IF NOT EXISTS book ( id INT NOT NULL, book_category_id INT NOT NULL, `name` text NOT NULL)

CREATE TABLE IF NOT EXISTS book_category (id INT NOT NULL, `name` text NOT NULL)

DROP TABLE IF EXISTS `user`
CREATE TABLE `user` (id text NOT NULL, `password` text NOT NULL, `first_name` text NOT NULL, `last_name` text NOT NULL)
