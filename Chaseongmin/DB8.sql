select ename, sal
from emp
where (sal >= 30000 and sal <= 40000) or (job = 'manager');