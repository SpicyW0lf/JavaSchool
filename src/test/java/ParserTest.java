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
        assertEquals("'asd' = 1, 'sor' = 2, 'bor' = 'where'", parser.parseValues());
    }

}
