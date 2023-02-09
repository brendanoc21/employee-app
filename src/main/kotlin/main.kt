import ie.setu.Employee
import kotlin.math.round

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)

fun main(args: Array<String>){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${monthlySal()}")
            2 -> println("Monthly PRSI: ${monthlyPrsi()}")
            3 ->println("Monthly PAYE: ${monthlyPaye()}")
            4 -> println("Monthly Gross Pay: ${grossSalary()}")
            5 -> println("Monthly Total Deductions: ${totalDeduction()}")
            6 -> println("Monthly Net Pay: ${netPay()}")
            7 -> println(getPayslip())
            8 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun monthlySal() = roundTwoDecimals(employee.salary / 12)
fun monthlyBonus() = roundTwoDecimals(employee.bonus / 12)
fun fullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.fname} ${employee.sname}"
    'f', 'F' -> "Ms.  ${employee.fname} ${employee.sname}"
    else ->  "${employee.fname} ${employee.sname}"
}

fun monthlyPrsi() = roundTwoDecimals((employee.salary/12)*(employee.prsi/100))
fun monthlyPaye() = roundTwoDecimals((employee.salary/12)*(employee.paye/100))
fun grossSalary() = roundTwoDecimals(((employee.salary + employee.bonus)/12))
fun totalDeduction() = roundTwoDecimals(((employee.deduction+employee.salary*(employee.paye/100)+employee.salary*(employee.prsi/100))/12))
fun netPay() = roundTwoDecimals((((employee.salary+employee.bonus)-(employee.deduction+employee.salary*(employee.paye/100)+employee.salary*(employee.prsi/100)))/12))
fun getPayslip() = """
      _____________________________________________________________________
                                 Monthly Payslip                           
      _____________________________________________________________________
                                                                           
              Employee Name: ${fullName()}(${employee.gender.uppercase()})     Employee ID: ${employee.empid}             
                                                                           
      _____________________________________________________________________
                                                                           
              Payment Details                Deduction Details             
      _____________________________________________________________________
             Salary: ${monthlySal()}                 PAYE: ${monthlyPaye()}                 
              Bonus: ${monthlyBonus()}                  PRSI: ${monthlyPrsi()}                  
                                             Cycle To Work: ${employee.deduction}          
      _____________________________________________________________________
              Gross: ${grossSalary()}                 Total Deductions: ${totalDeduction()}     
      _____________________________________________________________________
                                Net Pay: ${netPay()}                           
      _____________________________________________________________________
      """
fun menu() : Int {
    print("""
         Employee Menu for ${fullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
           8. Exit
         Enter Option : 
         """)
    return readLine()!!.toInt()
}
fun roundTwoDecimals(number: Double) = round(number * 100) / 100