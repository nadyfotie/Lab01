import java.util.Objects;
public class Product {
    // Creating the fields of the product class
    private String ID;
    private String Name;
    private String Description;
    private Double Cost;
// Contructor
    public Product(String ID, String description, String name, Double cost) {
        this.ID = ID;
        Description = description;
        Name = name;
        Cost = cost;
    }
    //Setters and Getters


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost=" + Cost +
                '}';
    }
    public String toCSV(){
        String ret = this.ID + "," + this.Name +  "," + this.Description +  "," + this.Cost +  ",";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getID(), product.getID()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getCost(), product.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getDescription(), getCost());
    }
}
