create materialized view materialized_book_view as
select b.category as category,
       count(b.id) as total_books,
       sum(b.available_copies) as total_copies,
       count(case when b.state!='GOOD' then 1 end) as total_bad_books
from books as b
group by b.category;

