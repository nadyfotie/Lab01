import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.util.Scanner;
import java.util.ArrayList;
public class PersonReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        boolean continueReading = SafeInput.getYNConfirm(input, "Do you want to select the person file");
        if (continueReading) {

            JFileChooser chooser = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                try {
                    InputStream in = new BufferedInputStream(Files.newInputStream(file));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String rec;
                    System.out.printf("%-8s%-15s%-15s%-10s%6s%n",
                            "ID#", "firstname", "lastName", "title", "YOB");
                    System.out.println("========================================================");
                    while (reader.ready()) {
                        rec = reader.readLine();
                        String[] fields = rec.split(",");
                        if (fields.length == 5) {
                            String ID = fields[0].trim();
                            String firstname = fields[1].trim();
                            String lastName = fields[2].trim();
                            String title = fields[3].trim();
                            int yob = Integer.parseInt(fields[4].trim());

                            Person aPerson = new Person(ID, firstname, lastName, title, yob);
                            people.add(aPerson);

                            //System.out.printf("%-8s%-15s%-15s%-10s%6d%n",
                                  //  ID, firstname, lastName, title, yob);

                        } else {
                            System.out.println("Found a record that may be corrupt");
                            System.out.println(rec);
                        }
                    }
                    for (Person p : people) {
                        System.out.printf("%-8s%-15s%-15s%-10s%6d%n",
                                p.getID(), p.getFirstName(), p.getLastName(),
                                p.getTitle(), p.getYOB());
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
