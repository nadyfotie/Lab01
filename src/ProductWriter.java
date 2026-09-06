import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;


import java.util.Scanner;
import java.util.ArrayList;

public class ProductWriter {
    public static void main(String[] args){
    Product aProduct;
    Scanner in = new Scanner(System.in);
    ArrayList<Product> products =  new ArrayList<>();
        String ID= "";
        String Name= "";
        String Description= "";
        Double Cost= 0.0;

        boolean done = false;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            Name = SafeInput.getNonZeroLenString(in, "Enter your name ");
            Description= SafeInput.getNonZeroLenString(in, "Enter the description");
            Cost = SafeInput.getDouble(in, "Enter the Cost");

            aProduct = new Product(ID, Name, Description, Cost);
            products.add(aProduct);
            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

        String filename = SafeInput.getNonZeroLenString(in, "Enter the file name");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + filename);

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(out)
                    );
            for (Product p: products){
                writer.write(p.toCSV());
                writer.newLine();

            }
            writer.close();

            System.out.println("Data file written!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
