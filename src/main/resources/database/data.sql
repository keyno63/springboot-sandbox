INSERT INTO
    book
    (id, book_category_id, `name`)
VALUES
   (1, 3, 'rashomon'),
   (2, 1, 'blue beard'),
   (3, 2, 'it');

INSERT INTO
    book_category (id, `name`)
VALUES
   (1, 'foreign fairy tale'),
   (2, 'foreign horror'),
   (3, 'novel');

INSERT INTO
    `user` (id, `password`, `first_name`, `last_name`)
VALUES
    ('user1', '1234', 'taro', 'yamada'),
    ('user2', '5678', 'hanako', 'yamada'),
    ('user3', 'pass', 'ichiro', 'suzuki'),
    ('user4', 'Pass', 'sakura', 'tanaka')
