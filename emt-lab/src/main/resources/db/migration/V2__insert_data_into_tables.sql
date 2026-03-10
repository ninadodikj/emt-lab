INSERT INTO countries (name, continent) VALUES
('North Macedonia', 'Europe'),
('USA', 'North America'),
('France', 'Europe'),
('Japan', 'Asia');

INSERT INTO authors (created_at, updated_at, name, surname, country_id) VALUES
(NOW(), NOW(), 'Jon', 'Doe', 1),
(NOW(), NOW(), 'Emily', 'Smith', 2),
(NOW(), NOW(), 'Pierre', 'Dubois', 3),
(NOW(), NOW(), 'Haruki', 'Murakami', 4);


INSERT INTO books (created_at, updated_at, name, category, author_id, state, available_copies) VALUES
(NOW(), NOW(), 'Spring Boot Basics', 'NOVEL', 1, 'GOOD', 5),
(NOW(), NOW(), 'Modern Java', 'HISTORY', 2, 'GOOD', 3),
(NOW(), NOW(), 'French Cooking', 'DRAMA', 3, 'BAD', 2),
(NOW(), NOW(), 'Kafka on the Shore', 'NOVEL', 4, 'GOOD', 4),
(NOW(), NOW(), 'The Great Gatsby', 'CLASSICS', 1, 'GOOD', 6),
(NOW(), NOW(), 'The Hobbit', 'FANTASY', 2, 'GOOD', 5),
(NOW(), NOW(), 'Sherlock Holmes', 'THRILER', 3, 'GOOD', 3),
(NOW(), NOW(), 'Steve Jobs Biography', 'BIOGRAPHY', 4, 'GOOD', 2);