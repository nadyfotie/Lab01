//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
/*a. ID (a String)
b. FirstName
c. LastName
d. Title (a string like Mr., Mrs., Ms., Dr., etc.)
e. YearOfBirth (an int */
    Person aPerson;
    Scanner in = new Scanner(System.in);
    ArrayList<Person> folks = new ArrayList<>(); //store the person's object as it is created
    String ID = "";
    String firstName ="";
    String lastName = "";
    String title = "";
    int YOB = 0;

    boolean done = false;
    //input loop

    do{
        ID = SafeInput.getNonZeroLenString(in,"Enter the ID [6 Digits]");
        firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
        lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
        title = SafeInput.getNonZeroLenString(in, "Enter the titel");
        YOB = SafeInput.getInt(in , "Enter the birth");

        //  create the person object with the data
        // and save it to the folks array list
        aPerson = new Person(ID, firstName, lastName, title, YOB);
        folks.add(aPerson);


        done = SafeInput.getYNConfirm(in, "Are you done?");

    }while(!done);

    // Previously we created a CSV record for this person's data
    // Write the object data to disk
    //loop though the array list and call the toCSV for each object

    for (Person p: folks){

    }

    System.out.println(aPerson.toCSV() + "Age: " + aPerson.getAge());
// need to print csv
}
