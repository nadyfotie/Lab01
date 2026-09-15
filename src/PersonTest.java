import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PersonTest {

    @Test

    void testConstructor() {
        Person person = new Person("123456", "Nady", "Fotie", "Ms.", 2007);

    }
    @Test
    void setID() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        person.setID("654321");
        assertEquals("654321", person.getID());

    }

    @Test
    void setFirstName() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        person.setFirstName("Ivan");
        assertEquals("Ivan", person.getFirstName());
    }

    @Test
    void setLastName() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        person.setLastName("Wopiwo");
        assertEquals("Wopiwo", person.getLastName());
    }

    @Test
    void setTitle() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        person.setTitle("Dr");
        assertEquals("Dr", person.getTitle());
    }

    @Test
    void setYOB() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        person.setYOB(2004);
        assertEquals(2004, person.getYOB());
    }

    @Test
    void testToString() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        assertEquals("Person{ ID='123456', firstName='Nady', lastName='Fotie', title='Mr.', YOB=2007}", person.toString());
    }

    @Test
    void getAge() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        assertEquals("19", person.getAge());

    }

    @Test
    void testGetAge() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        assertEquals("13", person.getAge(2020));
    }

    @Test
    void toCSV() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);

        assertEquals("123456, Nady, Fotie, Mr., 2007", person.toCSV());
    }

    @Test
    void toJSON() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);

        assertEquals("{\"ID\":\"123456\", \"firstName\":\"Nady\", \"lastName\":\"Fotie\", \"title\":\"Mr.\", \"YOB\":2007}", person.toJSON());
    }

    @Test
    void toXML() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);

        assertEquals("<Person><ID>123456</ID><firstName>Nady</firstName><lastName>Fotie</lastName><title>Mr.</title><YOB>2007</YOB></Person>", person.toXML());
    }

    @Test
    void testEquals() {
        Person person1 = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        Person person2 = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        assertTrue(person1.equals(person2));
    }

    @Test
    void fullName() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
    assertEquals("Nady Fotie", person.fullName());
    }

    @Test
    void formalName() {
        Person person = new Person("123456", "Nady", "Fotie", "Mr.", 2007);
        assertEquals("Mr. Nady Fotie", person.formalName());
    }
}