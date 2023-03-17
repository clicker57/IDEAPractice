package practice;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileDealingTest {

    @Test
    public void diveInFile() {
        String startDir = "/Users/Philip/workspaces/IDEAPractice/Crates/src";
        FileDealing obj = new FileDealing();
        obj.diveInFile(new File(startDir));
        Assert.assertNotNull(obj.getFileName());
    }
}