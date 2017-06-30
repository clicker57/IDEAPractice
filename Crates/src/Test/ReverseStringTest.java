package Test;

import org.junit.Assert;
import practice.strings.ReverseString;

/**
 * Created by Philip on 6/23/16.
 */
public class ReverseStringTest {
    @org.junit.Test
    public void testDoReverse() throws Exception {
//        String strTest = new String();
        System.out.println("reversed str : " + "");
        Assert.assertSame("".equals(ReverseString.doReverse("")), true);
        System.out.println("reversed str : " + "abc123");
        Assert.assertSame("test ok!", "321cba".equals(ReverseString.doReverse("abc123")), true);
        System.out.println("reversed str : " + "e");
        Assert.assertSame("test ok!", "e".equals(ReverseString.doReverse("e")), true);
    }
}