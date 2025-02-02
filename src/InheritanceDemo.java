import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        SafeInputObj si = new SafeInputObj();
        ArrayList<Worker> Workers = new ArrayList<>();
        boolean Cont = true;
        int i = 1;
        do{
            String ID = String.format("%06d", i);
            String First = si.getNonZeroLenString("Please enter the First Name");
            String Last = si.getNonZeroLenString("Please enter the Last Name");
            String Title = si.getNonZeroLenString("Please enter the Title");
            int YOB = si.getInt("Please enter the YOB");
            double payRate = si.getDouble("Please enter the Pay Rate");
            Workers.add(new Worker(ID,First,Last,Title,YOB,payRate));
            Cont = si.getYNConfirm("Would you like to add more workers or quit (y/n)");

        }while(Cont);

        for(Worker w : Workers){
            System.out.println(w.toCSV());
            System.out.println(w.toJson());
            System.out.println(w.toXML());
        }
    }
}
