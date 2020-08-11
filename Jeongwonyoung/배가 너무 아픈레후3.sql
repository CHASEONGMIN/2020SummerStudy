create user academicManager@localhost identified by 'academicManager';
grant all on 학사DB.* to academicManager@localhost with grant option;
show grants for academicManager@localhost;

CREATE USER 'student'@'%' IDENTIFIED BY 'studentpassword' ;

grant select on 학사DB.course TO 'student'@'%';
grant select on 학사DB.student TO 'student'@'%';
grant select on 학사DB.course_taken TO 'student'@'%';
grant select on 학사DB.department TO 'student'@'%';
grant select on 학사DB.instructor TO 'student'@'%';

show grants for student;

create user 'professor'@'%' identified by 'professor';
grant SELECT on 학사DB.* to 'professor'@'%';
grant INSERT, UPDATE on 학사DB.course_taken to 'professor'@'%';

show grants for professor;

drop user academicManager@localhost;
drop user 'student'@'%';
