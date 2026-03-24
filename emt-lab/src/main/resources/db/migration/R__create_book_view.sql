create or replace view book_view as
select
    b.id as id,
    b.name as name,
    b.category as category,
    b.state as state,
    b.available_copies as available_copies,
    a.name || ' ' || a.surname as author_full_name,
    c.name as country_name
from books as b
         join authors as a on b.author_id=a.id
         join countries as c on a.country_id=c.id