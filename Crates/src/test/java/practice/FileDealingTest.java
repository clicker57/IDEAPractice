package practice;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileDealingTest {

    @Test
    public void diveInFile() {
        String startDir = "/Users/Philip/workspaces/IDEAPractice/Crates/src";
        FileDealing obj = new FileDealing();
        obj.diveInFile(new File(startDir));
    }
}