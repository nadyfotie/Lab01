import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {
    @Test
    void testConstructor() {
        Scanner scanner = new Scanner("Hello");
        SafeInputObj input = new SafeInputObj(scanner);

        assertNotNull(input);
    }

    @Test
    void getNonZeroLenString() {
        Scanner scanner = new Scanner("Nady");
        SafeInputObj input = new SafeInputObj(scanner);

        String result = input.getNonZeroLenString("Enter a name");

        assertEquals("Nady", result);

    }

    @Test
    void getRangedInt() {
        Scanner scanner = new Scanner("25\n");
        SafeInputObj input = new SafeInputObj(scanner);

        int result = input.getRangedInt("Enter a number", 1, 50);

        assertEquals(25, result);
    }

    @Test
    void getDouble() {
        Scanner scanner = new Scanner("19.75\n");
        SafeInputObj input = new SafeInputObj(scanner);

        double result = input.getDouble("Enter a double");

        assertEquals(19.75, result);

    }

    @Test
    void getYNConfirm() {
        Scanner scanner = new Scanner("Y\n");
        SafeInputObj input = new SafeInputObj(scanner);

        boolean result = input.getYNConfirm("Are you done?");

        assertTrue(result);
    }

    @Test
    void getRegExString() {
        Scanner scanner = new Scanner("Nady123\n");
        SafeInputObj input = new SafeInputObj(scanner);

        String result = input.getRegExString("Enter your username", "[A-Za-z0-9]+");

        assertEquals("Nady123", result);
    }

    @Test
    void getInt() {
        Scanner scanner = new Scanner("42\n");
        SafeInputObj input = new SafeInputObj(scanner);

        int result = input.getInt("Enter an integer");

        assertEquals(42, result);
    }

    @Test
    void getRangedDouble() {
        Scanner scanner = new Scanner("25.5\n");
        SafeInputObj input = new SafeInputObj(scanner);

        double result = input.getRangedDouble("Enter a number", 1, 50);

        assertEquals(25.5, result);
    }
}