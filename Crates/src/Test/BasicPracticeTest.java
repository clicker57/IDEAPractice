package Test;

import org.junit.Assert;
import org.junit.Test;
import practice.BasicPractice;

/**
 * Created by Philip on 10/11/16.
 */
public class BasicPracticeTest {
    @Test
    public void starOut() throws NullPointerException {
        BasicPractice obj = new BasicPractice();

        String tStr1 = "13ucpodfn0`c30adjf poqwquejl;dqbbbjfqlf0 12u3'A'JSRGHO  U;Hdashg;as-2i30    p3rdmsavja;jd0  x1jjfadfn1 `c";
        Assert.assertTrue(obj.equalIsNot(tStr1));

        String tStr2 = "fqlf0b  b12u3";
        Assert.assertFalse(obj.equalIsNot(tStr2));
    }

}
