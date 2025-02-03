public class SalaryWorker extends Worker {
    //Fields
    private double annualSalary;
    //Constructor
    /**
     *  Initializes a salary worker object
     * @param ID Salary worker's ID number
     * @param firstName Salary worker's First Name
     * @param lastName Salary worker's Last Name
     * @param Title Salary worker's Title ie: Mr. or Mrs.
     * @param YOB Salary worker's year of birth
     * @param hourlyPayRate Salary worker's hourly wage
     * @param annualSalary Salary worker's annual salary
     */
    public SalaryWorker(String ID,String firstName, String lastName,String Title,int YOB,double hourlyPayRate, double annualSalary) {
        super(ID,firstName,lastName,Title,YOB,hourlyPayRate);
        this.annualSalary = annualSalary;
    }
    /**
     * gets the annual salary of a salary worker
     * @return Salary Workers annual salary
     */
    //Getters
    public double getAnnualSalary() {
        return annualSalary;
    }
    //Setters
    /**
     * sets the annual salary to a new value
     * @param annualSalary how much the annual salary makes in a year
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    //Methods and Special Ops

    /**
     * Calculates the amount of pay for a certain week
     * @param HoursWorked The number of hours worked within a week
     * @return pay for a week
     */
    public double calculateWeeklyPay(double HoursWorked){
        return annualSalary/52;
    }

    /**
     *  Returns a tabular display of the pay for the week
     * @param HoursWorked Number of hours worked for the week
     */
    public void DisplayWeeklyPay(double HoursWorked){
        double weeklyPay = calculateWeeklyPay(HoursWorked);
        double OTHours = 0;
        if (HoursWorked > 40)
            OTHours = HoursWorked - 40;
        double OTpay = 0;
        double TotalPay = weeklyPay + OTpay;
        System.out.printf("%12.2f |%12.2f |%12.2f |%12s |%12s\n",HoursWorked,weeklyPay,OTHours,OTpay,annualSalary);
    }

    //Exports

    /**
     * Returns Salary Worker info as a string for csv
     * @return CSV formatted string
     */
    public String toCSV(){
        return super.toCSV() + "," + annualSalary;
    }

    /**
     * Returns Salary Worker info as a string for JSON
     * @return JSON formatted string
     */
    public String toJson(){
        String Replacement  = String.format(",\"Annual Salary\" : \"%s\"}", annualSalary);
        return super.toJson().replace("}",Replacement);
    }

    /**
     * Returns Salary Worker info as a string for XML
     * @return XML formatted string
     */
    public String toXML(){
        return "<SalaryWorker>" +
                super.toXML().replace("<Worker>","").replace("</Worker>","")
                + "<AnnualSalary>" + annualSalary + "</AnnualSalary>"
                + "</SalaryWorker>";
    }


}
