--To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp where JOB IN ('MANAGER','ANALYST');
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || emprec.job); 
    end loop;
    close mycur;
end;
/

--Write PL/SQL code in Cursor to display employee names and aalary

set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp;
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.sal ); 
    end loop;
    close mycur;
end;
/

--Write PL/SQL code in Procedure to find the Reverse of the  number

set serveroutput on;
DECLARE
Num NUMBER;
Reverse_Num NUMBER := 0;
BEGIN
Num := 98765;
WHILE Num > 0
LOOP
Reverse_Num := (Reverse_Num * 10) + mod(Num, 10);
Num := Trunc(Num/10);
END LOOP;
DBMS_OUTPUT.put_line('Reversed Number is : ' || Reverse_Num);
END;
/



--Parameter list
set serveroutput on;
declare
emprec emp%rowtype;
cursor mycur(role varchar) is select * from emp where job in(role);
begin
open mycur('MANAGER');
loop
fetch mycur into emprec;
exit when mycur%NOTFOUND;
dbms_output.put_line(emprec.ename || '' || emprec.sal);
end loop;
close mycur;
open mycur('ANALYST');
loop
fetch mycur into emprec;
exit when mycur%NOTFOUND;
dbms_output.put_line(emprec.ename || ' ' || emprec.sal);
end loop;
close mycur;
end;
/

