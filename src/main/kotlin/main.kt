import kotlin.math.round

val fname = "Joe"
val sname = "Soap"
val gender = "m"
val empid = 6143
val salary = 67543.21
val paye = 38.5
val prsi = 5.2
val bonus = 1450.50
val deduction = 54.33

var title = ""

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

fun monthlySal() = roundTwoDecimals(salary / 12)
fun monthlyBonus() = roundTwoDecimals(bonus / 12)
fun fullName() =  when (gender) {
    "m", "M" -> "Mr. $fname $sname"
    "f", "F" -> "Ms. $fname $sname"
    else -> "$fname $sname"
}
fun monthlyPrsi() = roundTwoDecimals((salary/12)*(prsi/100))
fun monthlyPaye() = roundTwoDecimals((salary/12)*(paye/100))
fun grossSalary() = roundTwoDecimals(((salary + bonus)/12))
fun totalDeduction() = roundTwoDecimals(((deduction+salary*(paye/100)+salary*(prsi/100))/12))
fun netPay() = roundTwoDecimals((((salary+bonus)-(deduction+salary*(paye/100)+salary*(prsi/100)))/12))
fun getPayslip() = """
      _____________________________________________________________________
                                 Monthly Payslip                           
      _____________________________________________________________________
                                                                           
              Employee Name: ${fullName()}(${gender.uppercase()})     Employee ID: ${empid}             
                                                                           
      _____________________________________________________________________
                                                                           
              Payment Details                Deduction Details             
      _____________________________________________________________________
             Salary: ${monthlySal()}                 PAYE: ${monthlyPaye()}                 
              Bonus: ${monthlyBonus()}                  PRSI: ${monthlyPrsi()}                  
                                             Cycle To Work: ${(deduction)}          
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