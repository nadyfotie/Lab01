import java.util.Objects;
/**
 *
 * @author Nady Fotie fotienn@mail.uc.edu
 */
public class Product {
    // Creating the fields of the product class
    private String ID;
    private String Name;
    private String Description;
    private Double Cost;
// Contructor
    /**
     * Constructs a product object with the specified information.
     *
     * @param ID the product's identification number
     * @param description the product's last name
     * @param name the product's title
     * @param cost the product's year of birth
     */
    public Product(String ID, String name , String description, Double cost) {
        this.ID = ID;
        this.Description = description;
        this.Name = name;
        this.Cost = cost;
    }
    //Setters and Getters

    /**
     * Gets the product's ID.
     *
     * @return the product's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the product's Name.
     *
     * @return the porduct's Name
     */
    public String getName() {
        return Name;
    }
    /**
     * Sets the product's ID.
     *
     * @param name the product's ID
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * Gets the product's Description.
     *
     * @return the product's Description
     */
    public String getDescription() {
        return Description;
    }
    /**
     * Sets the product 's Description.
     *
     * @param description the product's Description.
     */
    public void setDescription(String description) {
        Description = description;
    }
    /**
     * Gets the product's Cost.
     *
     * @return the product's Cost
     */
    public Double getCost() {
        return Cost;
    }
    /**
     * Sets the product 's Cost.
     *
     * @param cost the product's Cost.
     */
    public void setCost(Double cost) {
        Cost = cost;
    }
    /**
     * Returns a string representation of the Product object.
     * @return  a string containing the person's information
     */
    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost=" + Cost +
                '}';
    }
    /**
     * Returns the product's data as a comma-separated value record.
     *
     * @return the product's data in CSV format
     */
    public String toCSV(){
        String ret = this.ID + ", " + this.Name +  ", " + this.Description +  ", " + this.Cost;
        return ret;
    }
    /**
     * Returns the product's data in JSON format.
     *
     * @return the product's data in JSON format
     */
    public String toJSON(){
        String ret = "{";
        ret += "\"ID\":\"" + this.ID + "\"";
        ret += ", \"Name\":\"" + this.Name + "\"";
        ret += ", \"Description\":\"" + this.Description + "\"";
        ret += ", \"Cost\":" + this.Cost;
        ret += "}";
        return ret;
    }
    /**
     * Returns the product's data in XML format.
     *
     * @return the product's data in XML format
     */
    public String toXML()
    {
        String ret = "<Product>";
        ret += "<ID>" + this.ID + "</ID>";
        ret += "<Name>" + this.Name + "</Name>";
        ret += "<Description>" + this.Description + "</Description>";
        ret += "<Cost>" + this.Cost + "</Cost>";
        ret += "</Product>";
        return ret;
    }
    /**
     * Compares this product object with another object to determine if they are equal.
     *
     * @param o the object to compare with this product
     * @return true if the product objects contain the same information, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getID(), product.getID()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getCost(), product.getCost());
    }
    /**
        * Returns a hash code for this product object.
            *
            * @return the hash code for this Person
     */
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getDescription(), getCost());
    }
}
