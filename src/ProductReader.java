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
public class ProductReader {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Product> product = new ArrayList<>();

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
                    System.out.println("================================================================");
                    while (reader.ready()) {
                        rec = reader.readLine();
                        String[] fields = rec.split(",");
                        if (fields.length == 4) {
                            String ID = fields[0].trim();
                            String Name = fields[1].trim();
                            String Description = fields[2].trim();
                            Double Cost = Double.parseDouble(fields[3].trim());
                            Product aProduct = new Product(ID, Name, Description, Cost);
                            product.add(aProduct);
                            //System.out.printf("%-8s%-15s%-30s%10.1f%n",
                                    //ID, Name, Description, Cost);


                        }else{
                                System.out.println("Found a record that may be corrupt");
                                System.out.println(rec);
                        }
                    }
                    for (Product p : product) {
                        System.out.printf("%-8s%-15s%-30s%10.1f%n",
                                p.getID(), p.getName(), p.getDescription(), p.getCost());
                    }
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }
}

