
	April 6
	Volatile keyword

	April 10
	Activity in EmployeeController to use foreach instead of iterator
	ACtivity to use BiPredicate for username/password validation in MainClass

	
	April 11
	establish connection to DB
	
	April 12
	perform UpdateEmployee
	Perform DeleteEmployee
	
	Apr 13
	Write queries
	No 4:
	10. List the emps who are working under any Manager.
	11. List all the Clerks of Deptno 20.
	12. Display the details of SMITH.
	
	Apr 18
	Write queries using CURSOR
       1.--To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
       2.--Write PL/SQL code in Cursor to display employee names and salary
       3.--Write PL/SQL code  to find the Reverse of the  number
       4. Cursor implementation using parameters
       
       APR 19
       1. Create a program to retrieve the number of years of service for a specific employee.
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
minimum salary.
