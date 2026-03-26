CREATE OR REPLACE VIEW popular_books AS
SELECT b.name, COUNT(ra.id) AS rent_count
FROM book_rent_activity ra
         JOIN books b ON b.name = ra.book_name
GROUP BY b.name
ORDER BY rent_count DESC;