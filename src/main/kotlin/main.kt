import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

val fname = "Joe"
val sname = "Soap"
val gender = "m"
val empid = 6143
val salary = 67543.21
val paye = 38.5
val prsi = 5.2
val bonus = 1450.50
val deduction = 54.33

fun main(args: Array<String>){
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    println("Pay Slip Printer")
    println("""
                _____________________________________________________________________
                |                          Monthly Payslip                          |
                |___________________________________________________________________|
                |                                                                   |
                |       Employee Name: ${fname.uppercase()} ${sname.uppercase()}(${gender.uppercase()})     Employee ID: ${empid}            |
                |                                                                   |
                |___________________________________________________________________|
                |                                                                   |
                |       Payment Details                Deduction Details            |
                |___________________________________________________________________|
                |       Salary: ${df.format(salary/12)}                PAYE: ${df.format((salary/12)*(paye/100))}                |
                |       Bonus: ${df.format(bonus/12)}                  PRSI: ${df.format((salary/12)*(prsi/100))}                 |
                |                                      Cycle To Work: ${df.format(deduction)}         |
                |___________________________________________________________________|
                |       Gross: ${df.format((salary + bonus)/12)}                 Total Deductions: ${df.format((deduction+salary*(paye/100)+salary*(prsi/100))/12)}    |
                |___________________________________________________________________|
                |                         Net Pay: ${df.format(((salary+bonus)-(deduction+salary*(paye/100)+salary*(prsi/100)))/12)}                          |
                |___________________________________________________________________|
                """
    )
}

fun twodecimal(input: Double){
    val short = BigDecimal(input).setScale(2, RoundingMode.HALF_EVEN)
}