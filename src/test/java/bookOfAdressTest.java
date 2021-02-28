import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class bookOfAdressTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addNameAndAdress() {
        bookOfAdress testFirst = new bookOfAdress();
        assertTrue(testFirst.addNameAndAdress("1","1/1"));
        assertFalse(testFirst.addNameAndAdress("1","1/2"));
    }

    @Test
    public void removeName() {
        bookOfAdress testSecond = new bookOfAdress();
        assertTrue(testSecond.addNameAndAdress("1","1/1"));
        assertTrue(testSecond.addNameAndAdress("2","2/2"));
        assertTrue(testSecond.removeName("1"));
        assertFalse(testSecond.removeName("1"));
    }

    @Test
    public void changeAdress() {
        bookOfAdress testTrid = new bookOfAdress();
        assertTrue(testTrid.addNameAndAdress("1","1/1"));
        assertTrue(testTrid.addNameAndAdress("2","2/2"));
        assertFalse(testTrid.changeAdress("1","1/1"));
        assertFalse(testTrid.changeAdress("3","3/3"));
        assertTrue(testTrid.changeAdress("1","2/2"));
    }

    @Test
    public void getAdress() {
        bookOfAdress testFouth= new bookOfAdress();
        assertTrue(testFouth.addNameAndAdress("1","1/1"));
        assertTrue(testFouth.addNameAndAdress("2","2/2"));
        assertEquals("not found",testFouth.getAdress("3"));
        assertEquals("2/2",testFouth.getAdress("2"));
        assertTrue(testFouth.changeAdress("2","3/2"));
        assertEquals("3/2",testFouth.getAdress("2"));
    }

    @Test
    public void getName() {
        bookOfAdress testFifth = new bookOfAdress();
        assertTrue(testFifth.addNameAndAdress("1","1/1"));
        assertTrue(testFifth.addNameAndAdress("2","2/2"));
        List<String> compare = new ArrayList<String>();
        compare.add("1");
        assertEquals(compare,testFifth.getName("1/1"));
        compare.add("2");
        assertTrue(testFifth.changeAdress("2","1/2"));
        assertEquals(compare,testFifth.getName("1"));
    }
}