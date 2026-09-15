import java.util.Scanner;
/**
 *
 * @author Nady Fotie fotienn@mail.uc.edu
 */

/**
 * Provides safe methods for receiving validated user input.
 * The class stores a Scanner object and uses it to read input.
 */
public class SafeInputObj {


    private Scanner pipe;

    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner) {
        pipe = scanner;
    }
    /**
     * Gets a String from the user and ensures that it is not empty.
     *
     * @param prompt The message displayed to the user.
     * @return A non-empty String entered by the user.
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    /**
     * Gets an integer from the user within a specified range.
     *
     * @param prompt The message displayed to the user.
     * @param low The lowest acceptable integer.
     * @param high The highest acceptable integer.
     * @return An integer entered by the user that is within the specified range.
     */
    public  int getRangedInt( String prompt, int low, int high)
    {
    int retVal = 0;
    String trash = "";
    boolean done = false;

    do {
        System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");

        if (pipe.hasNextInt()) {
            retVal = pipe.nextInt();
            pipe.nextLine();

            if (retVal >= low && retVal <= high) {
                done = true;
            } else {
                System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
            }
        } else {
            trash = pipe.nextLine();
            System.out.println("\nYou must enter a valid integer: " + trash);
        }

    } while (!done);

    return retVal;
}
    /**
     * Gets a double value from the user.
     *
     * @param prompt The message displayed to the user.
     * @return A valid double entered by the user.
     */
    public  double getDouble(String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;
    }
    /**
     * Gets a yes or no response from the user.
     *
     * @param prompt The message displayed to the user.
     * @return true if the user enters Y, or false if the user enters N.
     */
    public  boolean getYNConfirm(String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answere [Y/N]! " + response );
            }

        }while(!gotAVal);

        return retVal;
    }
    /**
     * Gets a String from the user that matches a specified regular expression pattern.
     *
     * @param prompt The message displayed to the user.
     * @param regExPattern The regular expression pattern the input must match.
     * @return A String entered by the user that matches the specified pattern.
     */
    public  String getRegExString(String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        }while(!gotAVal);

        return response;
    }
    /**
     * Gets an integer from the user.
     *
     * @param prompt The message displayed to the user.
     * @return A valid integer entered by the user.
     */
    public  int getInt(String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        }while(!done);

        return retVal;
    }
    /**
     * Gets a double from the user within a specified range.
     *
     * @param prompt The message displayed to the user.
     * @param low The lowest acceptable value.
     * @param high The highest acceptable value.
     * @return A double entered by the user that is within the specified range.
     */
    public  double getRangedDouble(String prompt, int low, int high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;
    }



}