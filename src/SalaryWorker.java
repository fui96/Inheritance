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
        System.out.printf("%6s,%6s",weeklyPay,annualSalary);
    }
}
