import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerTest
{
    Worker p1, p2, p3,p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Worker("Bob", "Tester1", "00000A","Mr",1955, 20);
        p2 = new Worker("Sally", "Tester2", "00000B", "Mrs", 1975, 30);
        p3 = new Worker("Jamie", "Tester3", "00000C", "Mrs", 1985, 40);
        p4 = new Worker("Rich", "Tester4", "00000D", "Mr", 2000, 15);
        p5 = new Worker("Phil", "Tester5", "00000E", "Mr", 1993, 10);
        p6 = new Worker("Sydney", "Tester6", "00000F", "Mrs", 1999, 18);

    }

    @Test
    void getIdString()
    {
        assertEquals("00000A", p1.getIdString());
    }
    @Test
    void getFirstName() {
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void getYearOfBirth() {
        assertEquals(1955, p1.getYearOfBirth());
    }

    @Test
    void getHourlyPayRate() {
        assertEquals(20.0, p1.getHourlyPayRate());
    }

    @Test
    void setIdString() {
        p1.setIdString("00000B");
        assertEquals("00000B", p1.getIdString());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Sally");
        assertEquals("Sally", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Tester2");
        assertEquals("Tester2", p1.getLastName());
    }

    @Test
    void setYearOfBirth() {
        p1.setYearOfBirth(1975);
        assertEquals(1975, p1.getYearOfBirth());
    }

    @Test
    void setHourlyPayRate() {
        p1.setHourlyPayRate(30000);
        assertEquals(30000, p1.getHourlyPayRate());
    }
}
