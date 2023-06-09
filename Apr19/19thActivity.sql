/*1. Create a program to retrieve the number of years of service for a specific employee.
a. Create a stored function called GET_SERVICE_YRS to retrieve the total number of years
of service for a specific employee.
The function should accept the employee ID as a parameter and return the number of years
of service. Add error handling to account for an invalid employee ID.
 
b. Invoke the function. You can use the following data:
EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999))
Hint: The above statement should produce an error message because there is no employee
with employee ID 999.
 
EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||get_service_yrs(7499) || ' years')
Hint: The above statement should be successful and return the number of years of service
for employee with employee ID 7499

2. Make these functions available in a package name EMPPACK

3. Create a stored procedure called UPD_SAL to update the  salaries
for a specific job in the EMP table.
Pass three parameters to the procedure: the job , a new minimum salary, and a new
maximum salary for the job. Add exception handling to account for an invalid job name in the
EMP table. Also, raise an exception if the maximum salary supplied is less than the
minimum salary.*/

--Activity 1 
-- Function to retrieve the total number of years of service for an employee
--select empno,ename, floor(Months_Between(sysdate,hiredate)/12) as experience from emp;
--select FLOOR((to_date(SYSDATE)-to_date(hiredate))/365) from emp


create or replace function GET_SERVICE_YRS(eno in number)
return number
is
      v_error_code number(20);
      v_error_msg varchar2(235);
        expr number;
  begin
   
     select floor(Months_Between(sysdate,hiredate)/12) into expr from emp where empno=eno;
     return expr;
    exception
     when NO_DATA_FOUND then
             dbms_output.put_line('Employee Number Does Not Exist :(');
       when TOO_MANY_ROWS then
            v_error_code:=SQLCODE;
            v_error_msg :=SQLERRM;
             dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg); 
     --end;
     
end GET_SERVICE_YRS;
/
EXECUTE DBMS_OUTPUT.PUT_LINE(GET_SERVICE_YRS(7788))
EXECUTE DBMS_OUTPUT.PUT_LINE(GET_SERVICE_YRS(1000))
EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||GET_SERVICE_YRS(7499) || ' years')

----Activity 2-----------------------------------------
 
  create or replace package EMPPACK
 as
     -- procedure pro12(num in number,enam out varchar2); 
    function GET_SERVICE_YRS(eno in number) return number;
 end;
 / 
 
 create or replace package body emppack
 as
        
function GET_SERVICE_YRS(eno in number)
return number
is
      v_error_code number(20);
      v_error_msg varchar2(235);
        expr number;
  begin
   
     select floor(Months_Between(sysdate,hiredate)/12) into expr from emp where empno=eno;
     return expr;
    exception
     when NO_DATA_FOUND then
             dbms_output.put_line('Employee Number Does Not Exist :(');
       when TOO_MANY_ROWS then
            v_error_code:=SQLCODE;
            v_error_msg :=SQLERRM;
             dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg); 
     --end;
     
end GET_SERVICE_YRS;
end emppack;
 /

select emppack.GET_SERVICE_YRS(7788) from emp;

--------------------Activity 3------------------------------------------------------------------------
/*Create a stored procedure called UPD_SAL to update the  salaries
for a specific job in the EMP table.
Pass three parameters to the procedure: the job , a new minimum salary, and a new
maximum salary for the job. Add exception handling to account for an invalid job name in the
EMP table. Also, raise an exception if the maximum salary supplied is less than the
minimum salary.*/

--create table emp1 as select * from emp;

select * from emp1

    CREATE OR REPLACE PROCEDURE UpdateSal (currjob IN varchar2,minsal IN number,maxsal IN number) 
    IS
    exp_invalid EXCEPTION;
    exp_invalidJob Exception;
    exp_max EXCEPTION;
    curr_sal Number;
    cnt Number;   
   Begin    
    select MAX(sal) into curr_sal from emp1 where job=currjob;
    select count(*) into cnt from emp1 where job=currjob;
    Begin
    if cnt = 0 then raise exp_invalidJob;
    elsif curr_sal < MAXSAL THEN UPDATE EMP1 SET sal = MAXSAL WHERE JOB = CURRJOB;
     ELSIF curr_sal = MAXSAL THEN raise exp_invalid;
    ELSE  raise exp_max;    
    end if;
    
    end; 
    exception
    when exp_invalidJob then
    raise_application_error(-20000,'No such job found');
    when exp_max then
    raise_application_error(-20001,'the maximum salary supplied is less than the minimum salary');
    when exp_invalid then
    raise_application_error(-20000,'No change in new salary,same as old');
    --dbms_output.put_line('the maximum salary supplied is less than the minimum salary');
    end UpdateSal;
    /

show errors

exec UpdateSal('SALESMAN',0,7699);

--select * from emp1 where job='SALESMAN'
 -- select MAX(sal)  from emp1 where job='SALESMAN';


