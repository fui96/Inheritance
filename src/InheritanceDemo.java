import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        SafeInputObj si = new SafeInputObj();
        ArrayList<Worker> Workers = new ArrayList<>();
        boolean mainCont = true;
        int i = 1;

        do {
            boolean Cont = true;
            String type = si.getNonZeroLenString("Would you like to create a Salary Worker or Worker");
            String ID = String.format("%06d", i);
            String First = si.getNonZeroLenString("Please enter the First Name");
            String Last = si.getNonZeroLenString("Please enter the Last Name");
            String Title = si.getNonZeroLenString("Please enter the Title");
            int YOB = si.getInt("Please enter the YOB");
            double payRate = si.getDouble("Please enter the Pay Rate");
            if(type.trim().toUpperCase().contains("SALARY")) {
                double Salary = si.getDouble("Please enter the Salary");
                Workers.add(new SalaryWorker(ID, First, Last, Title, YOB, payRate,Salary));
            }
            else{
                Workers.add(new Worker(ID, First, Last, Title, YOB, payRate));
            }
            i ++;
            mainCont = si.getYNConfirm("Would you like to add more workers or quit (y/n)");
        }while (mainCont);
        int weeks = 0;
        int[] Hours = {40,50,40};

        do{
            //Salary Worker Summary
            System.out.printf("%16s %16s %16s\n", "Weekly Pay", "OT Pay", "Salary");
            System.out.println("-".repeat(60));
            for(Worker w : Workers){
                if(w instanceof SalaryWorker){
                System.out.println(w.getFirstName());
                w.DisplayWeeklyPay(Hours[weeks]);
                }
            }
            System.out.println();
        //Hourly Worker Summary
            System.out.printf("%16s %16s %16s\n", "Weekly Pay", "OT Pay", "Total Pay");
            System.out.println("-".repeat(60));
            for(Worker w : Workers){
                if(!(w instanceof SalaryWorker)){
                System.out.println(w.getFirstName());
                w.DisplayWeeklyPay(Hours[weeks]);
                }
            }
            System.out.println();
        weeks ++;
        }while(weeks<3);

    }
}
