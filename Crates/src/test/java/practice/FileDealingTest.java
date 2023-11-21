package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileDealingTest {

    @Test
    public void diveInFile() {
        String startDir = "/Users/Philip/workspaces/IDEAPractice/Crates/src";
        FileDealing obj = new FileDealing();
        obj.diveInFile(new File(startDir));
        Assertions.assertNotEquals(0, obj.getFileCounter());
    }
}