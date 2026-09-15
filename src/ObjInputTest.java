public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("You entered: " + name);
        int age = input.getRangedInt("Enter your age", 1, 100);
        System.out.println("Your age: " + age);
        int number = input.getInt("Enter an integer");
        System.out.println("Your integer: " + number);

        double score = input.getRangedDouble("Enter a score", 0, 100);
        System.out.println("Your score: " + score);

        double price = input.getDouble("Enter a price");
        System.out.println("Your price: " + price);

        boolean done = input.getYNConfirm("Are you done?");
        System.out.println("Done: " + done);

        String username = input.getRegExString("Enter your username", "[A-Za-z0-9]+");
        System.out.println("Your username: " + username);
    }
}