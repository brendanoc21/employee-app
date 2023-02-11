package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

//Ensures id matches up with arraylist index of object
internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    //Returns all contents of Arraylist
    fun findAll(): List<Employee> {
        return employees
    }

    //Returns specific Object from arraylist by id
    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.empid == id }
    }

    //Returns specific Object from arraylist by name
    fun findName(name: String): Employee? {
        return employees.find { p -> p.fname == name }
    }

    //Adds new employee to arraylist
    fun create(employee: Employee) {
        employee.empid = getId()
        employees.add(employee)
    }

    //Removes employee from arraylist
    fun delete(empid: Int) {
        employees.remove(findOne(empid))
    }

    /*Modifies employee values except employee id as that should continue to line up
      with its previous index position*/
    fun modify(empid: Int) {
        print("Enter new first name: ")
        val fname = readLine().toString()
        print("Enter new surname: ")
        val sname = readLine().toString()
        print("Enter new gender (m/f): ")
        val gender = readLine()!!.toCharArray()[0]
        print("Enter new gross salary: ")
        val salary = readLine()!!.toDouble()
        print("Enter new PAYE %: ")
        val paye = readLine()!!.toDouble()
        print("Enter new PRSI %: ")
        val prsi = readLine()!!.toDouble()
        print("Enter new Annual Bonus: ")
        val bonus= readLine()!!.toDouble()
        print("Enter new Cycle to Work Deduction: ")
        val deduction= readLine()!!.toDouble()
        val newemp = Employee(fname, sname, gender, empid, salary, paye, prsi, bonus, deduction)
        employees.set(empid, newemp)
    }
}
