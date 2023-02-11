package ie.setu

import ie.setu.controllers.EmployeeAPI
import ie.setu.models.Employee
import mu.KotlinLogging
import kotlin.math.round

var employees = EmployeeAPI()

val logger = KotlinLogging.logger {}

fun main(args: Array<String>){
    logger.info { "Launching Employee App" }
    start()
}

fun menu() : Int {
    logger.info { "Press enter To return to menu" }
    readLine()!!
    logger.info { "Starting Menu" }
    print(""" 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |   5. Add Dummy Data
         |   6. Delete Employee
         |   0. Exit
         |       
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

fun start() {
    var input: Int
    do {
        input = menu()
        logger.info { "Accepting Input" }
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> dummyData()
            6 -> delete()
            0 -> println("Exiting App")
            else -> println("Invalid Option")
        }
    } while (input != -1)
}

fun list(){
    logger.info { "Printing List" }
    employees.findAll().forEach{println(it)}
}

fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}

internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to ie.setu.search by: ")
    val employeeID = readLine()!!.toInt()
    logger.info { "Finding Employee" }
    return employees.findOne(employeeID)
}

fun paySlip(){
    val employee = getEmployeeById()
    logger.info { "Printing Payslip" }
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
    logger.info { "Adding Dummy Data" }
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}

fun add(){
    print("Enter first name: ")
    val fname = readLine().toString()
    print("Enter surname: ")
    val sname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val empid = readLine()!!.toInt()
    print("Enter gross salary: ")
    val salary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val paye = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsi = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val bonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val deduction= readLine()!!.toDouble()
    logger.info { "Adding Employee" }
    employees.create(Employee(fname, sname, gender, empid, salary, paye, prsi, bonus, deduction))
}

fun delete(){
    print("Enter the employee id of the employee for deletion: ")
    val employeeID = readLine()!!.toInt()
    logger.info { "Deleting Employee" }
    employees.delete(employeeID)
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100