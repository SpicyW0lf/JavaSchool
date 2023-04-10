import com.digdes.school.parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void testParse() {
        Parser parser = new Parser("insert saf asdf fwe ascas qssf");
        assertEquals("insert", parser.parseOperation());
    }

    @Test
    public void testValues() {
        Parser parser = new Parser("insert values 'asd' = 1, 'sor' = 2, 'bor' = 'where' where");
        try {
            assertEquals("'asd' = 1, 'sor' = 2, 'bor' = 'where'", parser.parseValues());
        } catch (Exception e) {
            System.out.println("Строка введена некоректно");
        }
    }

    @Test
    public void testWhereFinder() {
        String str = "select 'where'=22 or 'sdf' = 5 where 'a' = 5 and 'b' = 3";
        Parser parser = new Parser(str);
        assertEquals("'a' = 5 and 'b' = 3", parser.parseCondition());
    }

}
