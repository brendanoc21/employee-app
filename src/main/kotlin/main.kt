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

fun monthlySal() = roundTwoDecimals(salary / 12)
fun monthlyBonus() = roundTwoDecimals(bonus / 12)
fun fullName() = "${fname} ${sname}"
fun monthlyPrsi() = roundTwoDecimals((salary/12)*(prsi/100))
fun monthlyPaye() = roundTwoDecimals((salary/12)*(paye/100))
fun grossSalary() = roundTwoDecimals(((salary + bonus)/12))
fun totalDeduction() = roundTwoDecimals(((deduction+salary*(paye/100)+salary*(prsi/100))/12))
fun netPay() = roundTwoDecimals((((salary+bonus)-(deduction+salary*(paye/100)+salary*(prsi/100)))/12))
fun main(args: Array<String>){
    println("Pay Slip Printer")
    println("""
                _____________________________________________________________________
                |                          Monthly Payslip                          |
                |___________________________________________________________________|
                |                                                                   |
                |       Employee Name: ${fullName()}(${gender.uppercase()})     Employee ID: ${empid}            |
                |                                                                   |
                |___________________________________________________________________|
                |                                                                   |
                |       Payment Details                Deduction Details            |
                |___________________________________________________________________|
                |       Salary: ${monthlySal()}                 PAYE: ${monthlyPaye()}                |
                |       Bonus: ${monthlyBonus()}                  PRSI: ${monthlyPrsi()}                 |
                |                                      Cycle To Work: ${(deduction)}         |
                |___________________________________________________________________|
                |       Gross: ${grossSalary()}                 Total Deductions: ${totalDeduction()}    |
                |___________________________________________________________________|
                |                         Net Pay: ${netPay()}                          |
                |___________________________________________________________________|
                """
    )
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100