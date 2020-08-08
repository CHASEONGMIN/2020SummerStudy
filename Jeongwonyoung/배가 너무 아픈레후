delimeter $$
create procedure ADDcourserecord
(sname char(20), cname char(20), p_grade int, out IsError integer)
begin
  declare vsid char(10);
  declare vcid char(10);
  declare CONTINUE HANDLER for sqlexception SET IsError = 3;
  
  set IsError = 0;
  select id into vsid
  from student
  where name = sname;
  select vsid;
  select id into vcid
  from course
  where name = cname;
  select vcid;
  if vsid is null then
    set IsError = 1;
  elseif vcid is null
   then
      set IsError = 2;
  else
    insert into course_taken(sid, cid, grade, year_taken)
    values ( vsid, vcid, p_grade, year(now()) );
  end if;
  
end $$
delimeter  ;
