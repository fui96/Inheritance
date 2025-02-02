public class Worker extends Person {
    //Field
    private double HourlyPayRate;

    //Constructor

    /**
     *
     * @param ID Worker's ID Number
     * @param FirstName Worker's First Name
     * @param LastName Worker's Last Name
     * @param Title Worker's Title
     * @param YOB Worker's YOB
     * @param HourlyPayRate Worker's Hourly Wage
     */
    public Worker(String ID, String FirstName, String LastName,String Title,int YOB, double HourlyPayRate) {
        super(ID, FirstName, LastName, Title, YOB);
        this.HourlyPayRate = HourlyPayRate;
    }
    //Getters
    /**
     * Gets and returns the workers hourly pay rate
     * @return Hourly Pay Rate
     */
    public double getHourlyPayRate() {
        return HourlyPayRate;
    }
    //Setters
    /**
     * Sets and updates the worker's hourly pay rate
     * @param hourlyPayRate Sets the hourly pay rate
     */
    public void setHourlyPayRate(double hourlyPayRate) {
        HourlyPayRate = hourlyPayRate;
    }
    //Methods and Special Ops

    /**
     * Returns the weekly pay based on number of hours worked
     * @param HoursWorked The number of hours worked within a week
     * @return Returns
     */
    public double calculateWeeklyPay(double HoursWorked){
        double PayTotal = 0;
        if (HoursWorked > 40){
            double OverTimeHours = HoursWorked - 40;
            PayTotal += (HoursWorked - OverTimeHours) * HourlyPayRate;
            PayTotal += OverTimeHours * (HourlyPayRate * 1.5);
            return PayTotal;
        }
        else{
            PayTotal += HoursWorked * HourlyPayRate;
            return PayTotal;
        }
    }

    public void DisplayWeeklyPay(double HoursWorked){
        double OTPay = 0;
        double PayTotal = 0;
        double RegPay = 0;
        double OTHours = 0;
        if (HoursWorked > 40){
            OTHours = HoursWorked - 40;
            OTPay += HoursWorked * (HourlyPayRate * 1.5);
            RegPay += (HoursWorked - OTHours) * HourlyPayRate;
            PayTotal += RegPay + OTPay;
            System.out.printf("%5s,%5s,%5s",RegPay,OTPay,PayTotal);
        }
        else{
            RegPay += HoursWorked * HourlyPayRate;
            PayTotal += OTPay + RegPay;
            System.out.printf("%5s,%5s,%5s",RegPay,OTPay,PayTotal);
        }
    }

    public String toCSV(){
        return super.toCSV() + "," + HourlyPayRate;
    }
    public String toJson() {
        String Replacement = String.format(",\"Hourly Wage\" : \"%s\"}", HourlyPayRate);

        return super.toJson().replace("\"}",Replacement);
    }
    public String toXML(){
        return  "<Worker>" +
                super.toXML().replace("<Person>","") .replace("</Person>","")
                +"<HourlyPayRate>" + HourlyPayRate + "</HourlyPayRate>"
                + "</Worker>";


    }
}
