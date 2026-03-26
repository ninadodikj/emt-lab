CREATE OR REPLACE VIEW popular_authors_view AS
SELECT CONCAT(a.name, ' ', a.surname) AS full_name, COUNT(ra.id) AS rent_count
FROM book_rent_activity ra
         JOIN books b ON b.name = ra.book_name
         JOIN authors a ON a.id = b.author_id
GROUP BY a.id, a.name, a.surname
ORDER BY rent_count DESC;