public class SalaryWorker extends Worker {
    //Fields
    private double annualSalary;
    //Constructor
    /**
     *
     * @param ID
     * @param firstName
     * @param lastName
     * @param Title
     * @param YOB
     * @param hourlyPayRate
     * @param annualSalary
     */
    public SalaryWorker(String ID,String firstName, String lastName,String Title,int YOB,double hourlyPayRate, double annualSalary) {
        super(ID,firstName,lastName,Title,YOB,hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    /**
     *
     * @return
     */
    //Getters
    public double getAnnualSalary() {
        return annualSalary;
    }
    //Setters

    /**
     *
     * @param annualSalary
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    //Methods and Special Ops

    /**
     *
     * @param HoursWorked The number of hours worked within a week
     * @return
     */
    public double calculateWeeklyPay(double HoursWorked){
        return annualSalary/52;
    }

    /**
     *
     * @param HoursWorked
     */
    public void DisplayWeeklyPay(double HoursWorked){
        double weeklyPay = calculateWeeklyPay(HoursWorked);
        double OTpay = 0;
        double TotalPay = weeklyPay + OTpay;
        System.out.printf("%15.2f |%15s |%15s\n",weeklyPay,OTpay,annualSalary);
    }

    //Exports
    /*
    public String toCSV(){

    }
    public String toJson(){

    }
    public String toXML(){

    }
     */

}
