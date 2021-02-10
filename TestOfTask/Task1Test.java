import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class Task1Test {
    @Test
    public void test1() {
        assertEquals(5,new Task1().add(3,2));
    }
    @Test
    public void test2() {
        Map<String, String> inPut = new HashMap() {{
            put("1", " улицы1дом1квартиры1");
            put("2", " улицы2дом2квартиры2");
            put("4", " улицы4дом4квартиры4");
        }};
        Map<String, String> addOrChange = new HashMap() {{
            put("1", " улицы2дом2квартиры2");
            put("3", " улицы3дом3квартиры3");
        }};
        List<String> delect = List.of("2");
        Map<String, String> get = new HashMap() {{
            put("1", " улицы2дом2квартиры2");
            put("3", " улицы3дом3квартиры3");
            put("4", " улицы4дом4квартиры4");
        }};
        assertEquals(get,new Task1().bookOfAdress(inPut,addOrChange,delect));
    }
    @Test
    public void test3(){
        Map<String, String> bookAdress = new HashMap() {{
            put("1", "улицы2дом2квартиры2");
            put("3", "улицы2дом2квартиры2");
            put("4", "улицы4дом4квартиры4");
        }};
        assertEquals("this person 1 live in улицы2дом2квартиры2",new Task1().search("1",bookAdress));
        assertEquals("1 3 ",new Task1().search("улицы2дом2квартиры2",bookAdress));
        assertEquals("information of this person/adress not found",new Task1().search("5",bookAdress));
    }
}