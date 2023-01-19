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
    println(
                "_____________________________________________________________________\n" +
                "|                          Monthly Payslip                          |\n" +
                "|___________________________________________________________________|\n" +
                "|                                                                   |\n" +
                "|       Employee Name: ${fname.uppercase()}${sname.uppercase()}(${gender})         Employee ID: ${empid}         |\n" +
                "|                                                                   |\n" +
                "|___________________________________________________________________|\n" +
                "|                                                                   |\n" +
                "|       Payment Details                Deduction Details            |\n" +
                "|___________________________________________________________________|\n" +
                "|       Salary: ${df.format(salary/12)}                    PAYE: ${df.format((salary/12)*(paye/100))}          |\n" +
                "|       Bonus: ${df.format(bonus/12)}                       PRSI: ${df.format((salary/12)*(prsi/100))}           |\n" +
                "|                                      Cycle To Work: ${df.format(deduction)}         |\n" +
                "|___________________________________________________________________|\n" +
                "|       Gross: ${df.format((salary + bonus)/12)}       Total Deductions: ${df.format((deduction+salary*(paye/100)+salary*(prsi/100))/12)}            |\n" +
                "|___________________________________________________________________|\n" +
                "|                         Net Pay: ${df.format(((salary+bonus)-(deduction+salary*(paye/100)+salary*(prsi/100)))/12)}                        |\n" +
                "|___________________________________________________________________|\n"
    )
}