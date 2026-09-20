import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testConstructor() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);

        assertEquals("123456", product.getID());
        assertEquals("Nady", product.getName());
        assertEquals("Cyber girl", product.getDescription());
        assertEquals(30.00, product.getCost());
    }

    @Test
    void setName() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        product.setName("Aisha");
        assertEquals("Aisha", product.getName());
    }

    @Test
    void setDescription() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        product.setDescription("Another Cyber girl");
        assertEquals("Another Cyber girl", product.getDescription());



    }

    @Test
    void setCost() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        product.setCost(40.00);
        assertEquals(40.00, product.getCost());

    }

    @Test
    void testToString() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        assertEquals("Product{ID='123456', Name='Nady', Description='Cyber girl', Cost=30.0}", product.toString());

    }

    @Test
    void toCSV() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        assertEquals("123456, Nady, Cyber girl, 30.0", product.toCSV());


    }

    @Test
    void toJSON() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        assertEquals("{\"ID\":\"123456\", \"Name\":\"Nady\", \"Description\":\"Cyber girl\", \"Cost\":30.0}", product.toJSON());

    }

    @Test
    void toXML() {
        Product product = new Product("123456", "Nady", "Cyber girl", 30.00);
        assertEquals("<Product><ID>123456</ID><Name>Nady</Name><Description>Cyber girl</Description><Cost>30.0</Cost></Product>", product.toXML());

    }

    @Test
    void testEquals() {
        Product product1 = new Product("123456", "Nady", "Cyber girl", 30.00);
        Product product2 = new Product("123456", "Nady", "Cyber girl", 30.00);

        assertTrue(product1.equals(product2));
    }
}