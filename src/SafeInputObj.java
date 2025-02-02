import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInputObj {
    private Scanner pipe;

    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     *Obtains a nonzero length string from the user
     * @param prompt the question or data prompt that is passed through the method
     * @return returns a nonzero length string
     */
    public String getNonZeroLenString(String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.isEmpty());

        return retString;
    }

    /**
     *returns an integer from the user
     * @param prompt the question or data prompt that is passed through the method
     * @return returns the integer that the user entered
     */
    public int getInt(String prompt){
        int retInt = 0;
        Boolean Valid = false;

        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextInt()){
                retInt = pipe.nextInt();
                pipe.nextLine();
                Valid = true;
            }
            else{
                System.out.println("Invalid input");
                Valid = false;
                pipe.next();
            }
        }while(!Valid);
        return retInt;
    }

    /**
     * Gets a double from the user
     * @param prompt the question or data prompt that is passed through the method
     * @return returns the double the user entered
     */
    public double getDouble(String prompt){
        Double retDouble = 0.0;
        Boolean Valid = false;
        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                Valid = true;
            }
            else{
                System.out.println("Invalid input");
                Valid = false;
                pipe.next();
            }
        }while(!Valid);
        return retDouble;
    }

    /**
     * Gets an integer between a range
     * @param prompt the question or data prompt that is passed through the method
     * @param low the lowest value the integer can be
     * @param high the highest value the integer can be
     * @return returns an integer within the range
     */
    public  int getRangedInt(String prompt, int low , int high){
        int retInt = 0;
        Boolean Valid = false;
        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextInt()){
                int Floatret;
                Floatret = pipe.nextInt();
                pipe.nextLine();
                if (Floatret >= low && Floatret <= high){
                    Valid = true;
                    retInt = Floatret;
                }
                else{
                    System.out.println("Invalid input, please enter a value within the range");
                }
            }
            else{
                System.out.println("Invalid input, please enter an integer");
                pipe.next();
            }
        }while(!Valid);

        return retInt;
    }

    /**
     * Gets a double between a range
     * @param prompt the question or data prompt that is passed through the method
     * @param low the lowest value the double can be
     * @param high the highest value the double can be
     * @return returns a double within the range
     */
    public  Double getRangedDouble(String prompt, double low , double high){
        Double retDouble = 0.0;
        Boolean Valid = false;

        do {
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextDouble()){
                Double FloatRet;
                FloatRet = pipe.nextDouble();
                pipe.nextLine();
                if (FloatRet >= low && FloatRet <= high){
                    Valid = true;
                    retDouble = FloatRet;
                }
                else{
                    System.out.println("Invalid input, please enter a value within the range");
                }
            }
            else{
                System.out.println("Invalid input, please enter a double");
                pipe.next();
            }
        }while(!Valid);

        return retDouble;
    }

    /**
     * Gets a true or false from the user
     * @param prompt the question or data prompt that is passed through the method
     * @return returns a true or a false from the user
     */
    public Boolean getYNConfirm(String prompt){
        Boolean retBool = null;
        String FloatRet;
        boolean Valid = false;
        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNext()){
                FloatRet = pipe.next();
                pipe.nextLine();
                if(FloatRet.toUpperCase().startsWith("Y")){
                    retBool = true;
                    Valid = true;
                }
                else if (FloatRet.toUpperCase().startsWith("N")){
                    retBool = false;
                    Valid = true;
                }
                else{
                    System.out.println("Invalid Input, please enter a valid value");
                    Valid = false;
                }
            }
            else{
                System.out.println("Invalid input, try again");
            }
        }while(!Valid);
        return retBool;
    }

    /**
     * Looks for matches within a string with a given pattern
     * @param prompt the question or data prompt that is passed through the method
     * @param regex the pattern to find in the string
     * @return returns the section of the string that matched the pattern
     */
    public String getRegExString(String prompt, String regex){
        String retString = "";
        String intput = "";
        Boolean Valid = false;
        Pattern pattern = Pattern.compile(regex);
        do{
            System.out.print("\n" +prompt + ": ");
            intput = pipe.nextLine();
            Matcher matcher = pattern.matcher(intput);
            if(matcher.find()){
                Valid = true;
                retString = matcher.group();
            }
            else{
                System.out.println("Invalid input, please enter a valid value");
            }

        }while(!Valid);
        return retString;
    }

    /**
     * Creates a header of width 60 around a string message
     * @param msg the message to be passed through the method
     */
    public void prettyHeader(String msg){
        msg = msg.trim();
        int CenterWidth = msg.length();
        int TotalWidth = 60;
        int SideStars = 3;
        int Padding = (TotalWidth -((SideStars*2) + CenterWidth)) /2 ;
        for( int x = 0 ; x <= TotalWidth; x++){
            System.out.print("*");
        }
        System.out.println();
        for(int x = 0; x < SideStars; x++){
            System.out.print("*");
        }
        for(int x = 0; x <= Padding; x++){
            System.out.print(" ");
        }
        System.out.print(msg);
        for(int x = 0; x <= Padding; x++){
            System.out.print(" ");
        }
        for(int x = 0; x < SideStars; x++){
            System.out.print("*");
        }
        System.out.println();
        for(int x = 0; x <= TotalWidth; x++){
            System.out.print("*");
        }
    }

}
