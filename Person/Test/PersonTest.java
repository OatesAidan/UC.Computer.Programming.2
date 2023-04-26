import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    Person p = new Person("Aidan", "Oates", "000002", "Mr", 2003);
    @Test
    public void testToString() {
        assertEquals("Person{firstName='Aidan', lastName='Oates', id='000002', title='Mr', yearOfBirth=2003}", p.toString());
    }

    @Test
    public void setFirstName() {
        p.setFirstName("Aidan");
        assertEquals("Aidan", p.getFirstName());
    }

    @Test
    public void setLastName() {
        p.setLastName("Oates");
        assertEquals("Oates", p.getLastName());
    }

    @Test
    public void setId() {
        p.setId("000003");
        assertEquals("000003", p.getId());
    }

    @Test
    public void setTitle() {
        p.setTitle("Mr");
        assertEquals("Mr", p.getTitle());
    }

    @Test
    public void setYearOfBirth() {
        p.setYearOfBirth(2003);
        assertEquals(2003, p.getYearOfBirth());
    }

    @Test
    public void getFullName() {
        assertEquals("Aidan Oates", p.getFullName());
    }

    @Test
    public void getFormalName() {
        assertEquals("Mr Aidan Oates", p.getFormalName());
    }

    @Test
    public void toCSVDataRecord() {
        assertEquals("Aidan,Oates,000002,Mr,2003", p.toCSVDataRecord());
    }
    @Test
    public void toJSONRecord() {
        char DQ = '\u0022';
        assertEquals(
                "{" +
                        DQ + "firstName" + DQ + ":" + DQ + "Aidan" + DQ + "," +
                        DQ + "lastName" + DQ + ":" + DQ + "Oates" + DQ + "," +
                        DQ + "id" + DQ + ":" + DQ + "000002" + DQ + "," +
                        DQ + "title" + DQ + ":" + DQ + "Mr" + DQ + "," +
                        DQ + "yearOfBirth" + DQ + ":" + DQ + "2003" + DQ +
                        "}",
                p.toJSONRecord());
    }

    @Test
    public void toXMLRecord() {
        assertEquals(
                "<Person>" +
                        "<firstName>Aidan</firstName>" +
                        "<lastName>Oates</lastName>" +
                        "<id>000002</id>" +
                        "<title>Mr</title>" +
                        "<yearOfBirth>2003</yearOfBirth>" +
                        "</Person>",
                p.toXMLRecord());
    }
}