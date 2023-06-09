import java.time.Year;

public class Product {
    private String name;
    private String description;
    private String id;
    private double cost;

    public Product(String name, String description, String id, double cost) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSVDataRecord() {
        return name + ',' + description + ',' + id + ',' + cost;
    }

    public String toJSONRecord() {
        char DQ = '\u0022';
        return "{" +
                DQ + "name" + DQ + ":" + DQ + name + DQ + "," +
                DQ + "description" + DQ + ":" + DQ + description + DQ + "," +
                DQ + "id" + DQ + ":" + DQ + id + DQ + "," +
                DQ + "cost" + DQ + ":" + DQ + cost + DQ + "," +
                "}";
    }

    public String toXMLRecord() {
        return "<Product>" +
                "<name>" + name + "</name>" +
                "<description>" + description + "</description>" +
                "<id>" + id + "</id>" +
                "<cost>" + cost + "</cost>" +
                "</Product>";
    }
}