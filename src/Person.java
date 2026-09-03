import java.util.Objects;

public class Person
{
    private String ID;
    private String firstName;
    private String lastName;
    private String title ;
    private int YOB = 0;

    //Constructor
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    // Setters -Write

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{ "+
                "ID='" + ID + '\"' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
    public int getAge()
    {
        int Age = 2026 - YOB;
        return Age;
    }
    public String toCSV() {
        // better to use a StringBuffer to concatenate the CSV record
        String ret = this.ID + ", " + this.firstName + ", " + this.lastName + ", " + this.title + ", " + this.YOB;
        return ret;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getYOB() == person.getYOB() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getTitle(), person.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getTitle(), getYOB());
    }
}
