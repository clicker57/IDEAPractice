package factory;

import org.junit.Test;

import java.util.logging.Logger;

public class addTest {
    private static final Logger logger = Logger.getLogger("addTest");

    @Test
    public void getResult() {
        try {
            ISimpleInstance simple = SimpleFactory.getInstance("*");
            Integer result = simple.getResult(1, 2);
            logger.info("result " + result);

        } catch (Exception e) {
            logger.severe("ERROR: " + e);
        }
    }
}