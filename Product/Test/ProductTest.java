import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    Product p = new Product("apples", "good", "000001", 2.15);

    @Test
    public void testToString() {
        assertEquals("Product{name='apples', description='good', id='000001', cost=2.15}", p.toString());
    }

    @Test
    public void setName() {
        p.setName("sandwich");
        assertEquals("sandwich", p.getName());
    }

    @Test
    public void setDescription() {
        p.setDescription("healthy");
        assertEquals("healthy", p.getDescription());
    }

    @Test
    public void setId() {
        p.setId("000003");
        assertEquals("000003", p.getId());
    }

    @Test
    public void setCost() {
        p.setCost(5.5);
        assertEquals(5.5, p.getCost(), 0.04);
    }

    @Test
    public void toCSVDataRecord() {
        assertEquals("apples,good,000001,2.15", p.toCSVDataRecord());
    }

    @Test
    public void toJSONRecord() {
        char DQ = '\u0022';
        assertEquals(
                "{" +
                        DQ + "name" + DQ + ":" + DQ + "apples" + DQ + "," +
                        DQ + "description" + DQ + ":" + DQ + "good" + DQ + "," +
                        DQ + "id" + DQ + ":" + DQ + "000001" + DQ + "," +
                        DQ + "cost" + DQ + ":" + DQ + "2.15" + DQ + "," +
                        "}",
                p.toJSONRecord());
    }

    @Test
    public void toXMLRecord() {
        assertEquals(
                "<Product>" +
                        "<name>apples</name>" +
                        "<description>good</description>" +
                        "<id>000001</id>" +
                        "<cost>2.15</cost>" +
                        "</Product>",
                p.toXMLRecord());
    }
}