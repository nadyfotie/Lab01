import java.util.Objects;
import java.util.Calendar;
/**
 *
 * @author Nady Fotie fotienn@mail.uc.edu
 */
public class Person
{
    private String ID;
    private String firstName;
    private String lastName;
    private String title ;
    private int YOB = 0;

    /**
     * Constructs a Person object with the specified information.
     *
     * @param ID the person's identification number
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param title the person's title
     * @param YOB the person's year of birth
     */
    //Constructor
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    // Setters -Write
    /**
     * Gets the person's ID.
     *
     * @return the person's ID
     */
    public String getID() {
        return ID;
    }
    /**
     * Sets the person's ID.
     *
     * @param ID the person's ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * Gets the person's FirstName.
     *
     * @return the person's FirstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the person's firstName.
     *
     * @param firstName the person's firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the person's lastName.
     *
     * @return the person's lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the person's LastName.
     *
     * @param lastName the person's LastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
        * Gets the person's Title.
        *
        * @return the person's Title
        */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the person's title.
     *
     * @param title the person's title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Gets the person's YOB.
     *
     * @return the person's YOB
     */
    public int getYOB() {
        return YOB;
    }
    /**
     * Sets the person's YOB.
     *
     * @param YOB the person's YOB
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    /**
     * Returns a string representation of the Person object.
     * @return  a string containing the person's information
     */
    @Override
    public String toString() {
        return "Person{ "+
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
    /**
     * Calculates the person's current age using the current year.
     *
     * @return the person's current age as a String
     */
    public String getAge()
    {
        Calendar cal = Calendar.getInstance();
        int Age = cal.get(Calendar.YEAR) - YOB;
        return String.valueOf(Age);
    }
    /**
     * Calculates the person's age for a specified year.
     *
     * @param year the year used to calculate the person's age
     * @return the person's age as a String
     */
    public String getAge(int year){
        int Age = year - YOB;
        return String.valueOf(Age);
    }

    /**
     * Returns the person's data as a comma-separated value record.
     *
     * @return the person's data in CSV format
     */

    public String toCSV() {
        // better to use a StringBuffer to concatenate the CSV record
        String ret = this.ID + ", " + this.firstName + ", " + this.lastName + ", " + this.title + ", " + this.YOB;
        return ret;
    }


    /**
     * Returns the person's data in JSON format.
     *
     * @return the person's data in JSON format
     */

    public String toJSON(){
        String ret = "{";
        ret += "\"ID\":\"" + this.ID + "\"";
        ret += ", \"firstName\":\"" + this.firstName + "\"";
        ret += ", \"lastName\":\"" + this.lastName + "\"";
        ret += ", \"title\":\"" + this.title + "\"";
        ret += ", \"YOB\":" + this.YOB;
        ret += "}";
        return ret;
    }

    /**
     * Returns the person's data in XML format.
     *
     * @return the person's data in XML format
     */

    public String toXML()
    {
        String ret = "<Person>";
        ret += "<ID>" + this.ID + "</ID>";
        ret += "<firstName>" + this.firstName + "</firstName>";
        ret += "<lastName>" + this.lastName + "</lastName>";
        ret += "<title>" + this.title + "</title>";
        ret += "<YOB>" + this.YOB + "</YOB>";
        ret += "</Person>";
        return ret;
    }
    /**
     * Compares this Person object with another object to determine if they are equal.
     *
     * @param o the object to compare with this Person
     * @return true if the Person objects contain the same information, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getYOB() == person.getYOB() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getTitle(), person.getTitle());
    }
    /**
     * Returns a hash code for this Person object.
     *
     * @return the hash code for this Person
     */
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getTitle(), getYOB());
    }
    /**
     * Returns the person's first and last name together.
     *
     * @return the person's full name
     */
    public String fullName(){
        return firstName + " " + lastName;
    }
    /**
     * Returns the person's title followed by their full name.
     *
     * @return the person's formal name
     */
    public String formalName(){
        return title + " " + fullName();
    }
}

