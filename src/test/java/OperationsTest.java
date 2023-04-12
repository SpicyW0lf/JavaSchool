import com.digdes.school.operations.Insert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void createValueTest() {
        Insert ins = new Insert();
        Map<String, Object> row = new HashMap<>() {
            {
                put("id", 5);
                put("lastName", "Petrov");
                put("age", 21);
                put("cost", 2.4);
                put("active", true);
            }
        };
        try {
            assertEquals(row, ins.createValue("'id' = 5, 'lastName' = 'Petrov', 'age' = 21, 'cost' = 2.4" +
                    " 'active' = true"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
