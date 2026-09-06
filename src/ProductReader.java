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
public class ProductReader {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean continueReading = SafeInput.getYNConfirm(input, "Do you want to select the product file?");
        if (continueReading){
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
                    System.out.printf("%-8s%-15s%-30s%10s%n",
                            "ID#", "Name", "Description", "Cost");
                    System.out.println("=========================================================");
                    while (reader.ready()) {
                        rec = reader.readLine();
                        String[] fields = rec.split(",");
                        if (fields.length == 5) {
                            String ID = fields[0].trim();
                            String Name = fields[1].trim();
                            String Description = fields[2].trim();
                            Double Cost = Double.parseDouble(fields[3].trim());
                            System.out.printf("%-8s%-15s%-30s%10.1f%n",
                                    ID, Name, Description, Cost);


                        }else{
                                System.out.println("Found a record that may be corrupt");
                                System.out.println(rec);
                        }
                    }
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    ;
                }
            }
        }
    }
}

