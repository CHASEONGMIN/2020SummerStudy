delimeter //
CREATE procedure ComputeGPA()
begin

  declare finished boolean;
  declare vsid char(10);
  
  declare Stud_Cursor cursor for select id from student ;
  declare EXIT HANDLER FOR NOT FOUND  SET finished = true;
  
    open Stud_cursor;
   set finished = false;
   
   while NOT finished
   do 
    fetch Stud_Cursor into vsid;
    
    update student
    set gpa =  (
    select avvg(grade)
    from course_taken
    where sid = vsid
    )
    where id = vsid;
   end while;
   close Stud_cursor;
   
 end //
 delimeter  ;
