package ie.setu.models

import ie.setu.roundTwoDecimals

//Used for Object that stores employees
class Employee (
    var fname : String,
    var sname : String,
    var gender : Char,
    var empid : Int,
    var salary : Double,
    var paye : Double,
    var prsi : Double,
    var bonus : Double,
    var deduction : Double
){
    fun monthlySal() = roundTwoDecimals(salary / 12)
    fun monthlyBonus() = roundTwoDecimals(bonus / 12)
    fun fullName() = when (gender){
        'm', 'M' -> "Mr. ${fname} ${sname}"
        'f', 'F' -> "Ms.  ${fname} ${sname}"
        else ->  "${fname} ${sname}"
    }

    //Calculations for payslip simplicity
    fun monthlyPrsi() = roundTwoDecimals((salary/12)*(prsi/100))
    fun monthlyPaye() = roundTwoDecimals((salary/12)*(paye/100))
    fun grossSalary() = roundTwoDecimals(((salary + bonus)/12))
    fun totalDeduction() = roundTwoDecimals(((deduction+salary*(paye/100)+salary*(prsi/100))/12))
    fun netPay() = roundTwoDecimals((((salary+bonus)-(deduction+salary*(paye/100)+salary*(prsi/100)))/12))

    //Creates a payslip of monthly earning calculations
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
                                             Cycle To Work: ${deduction}          
      _____________________________________________________________________
              Gross: ${grossSalary()}                 Total Deductions: ${totalDeduction()}     
      _____________________________________________________________________
                                Net Pay: ${netPay()}                           
      _____________________________________________________________________
      """

    //Displays object information in a clean way
    override fun toString(): String {
        return """Employee: $fname $sname,
            Gender: $gender,
            Employee ID:$empid, 
            Salary: $salary, 
            PAYE: $paye, 
            PRSI: $prsi, 
            Bonus: $bonus, 
            Deduction: $deduction
            """
    }

}