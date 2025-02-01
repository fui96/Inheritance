import java.util.Calendar;

public class Person {
    //Fields
    private String ID;
    private String FirstName;
    private String LastName;
    private String Title;
    private int YOB;

    //Constructor
    /**
     * Creates a new person obj with specified ID, FirstName, Last Name, Title, and YOB
     *
     * @param ID Person's ID number
     * @param firstName Person's First Name
     * @param lastName Person's Last Name
     * @param title Person's Title
     * @param yob The year the Person was born
     */
    public Person(String ID, String firstName, String lastName, String title, int yob){
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Title = title;
        this.YOB = yob;

    }
    //Getters
    //Get ID
    /**
     * returns the ID
     * @return ID
     */
    public String getID(){
        return ID;
    }
    //Get FirstName
    /**
     * returns the FirstName
     * @return FirstName
     */
    public String getFirstName(){
        return FirstName;
    }
    //Get LastName
    /**
     * returns the LastName
     * @return LastName
     */
    public String getLastName(){
        return LastName;
    }
    //Get Title
    /**
     * returns the Title
     * @return Title
     */
    public String getTitle(){
        return Title;
    }
    //Get Yob
    /**
     * returns the YOB
     * @return YOB
     */
    public int getYob(){
        return YOB;
    }
     //Full Name
    /**
     * joins the first and the last name to return the full name
     * @return fullName
     */
    public String fullName(){
        return FirstName + " " + LastName;
    }
     //Formal Name
    /**
     * Joins Person's title with fullName to return the formal name
     * @return formalName
     */
    public String formalName(){
        return Title + " " + fullName();
    }
     //Get Age assume current year
    /**
     * gets the current year through the calendar object and subtracts the persons yob to return the age
     * @return Age with assumed current year
     */
    public String getAge(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return String.valueOf(year - this.YOB);
    }
     //Get Age given a year
    /**
     * Users passes a year in to subtract the person's YOB to return the age
     * @param year year entered by the user
     * @return Age when given a year
     */
    public String getAge(int year){
        return String.valueOf(year - this.YOB);
    }
     //Prepare for export to csv
    /**
     *Joins object attributes to create a csv line
     * @return CSV String
     */
    public String toCSV(){
        return String.join(",", ID, FirstName, LastName, Title, Integer.toString(YOB));
    }
     //Prepare for export to Json
    /**
     * Formats a String to create a json record
     * @return JSON String
     */
    public String toJson(){
        return String.format("{\"FirstName\":\"%s\",\"LastName\":\"%s\",\"ID\":\"%s\",\"Title\":\"%s\",\"YOB\":\"%s\"}"
                ,FirstName,LastName,ID,Title,YOB);

    }

    /**
     * Formats a string to create an XML record
     * @return XML String
     */
     //Prepare for export to XML
    public String toXML(){
        return String.format("<Person><FirstName>%s</FirstName><Lastname>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%s</YOB></Person>"
                ,FirstName, LastName, ID, Title, YOB);
    }
    //Setters
    /**
     * Changes the persons first name
     * @param firstName persons first name
     */
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    /**
     * Changes the Last Name
     * @param lastName Person's last name
     */
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    /**
     * sets person's title
     * @param title person's title ie: Mr. or Mrs.
     */
    public void setTitle(String title) {
        this.Title = title;
    }
    /**
     * sets year of birth
     * @param YOB Year of Birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
}