package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.empid == id }
    }

    fun create(employee: Employee) {
        employee.empid = getId()
        employees.add(employee)
    }

    fun delete(empid: Int) {
        employees.remove(findOne(empid))
    }

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
