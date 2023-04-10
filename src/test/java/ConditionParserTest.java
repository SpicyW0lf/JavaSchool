import com.digdes.school.parser.ConditionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConditionParserTest {
    @Test
    public void toPostfixTest() {
        String str = "'a' = 5 and ('b' like 'cont' or 'b' like 'pont') ";
        ConditionParser conditionParser = new ConditionParser(str);
        assertEquals("a 5 = b cont like b pont like or and", conditionParser.postfixExpr);
    }
}
