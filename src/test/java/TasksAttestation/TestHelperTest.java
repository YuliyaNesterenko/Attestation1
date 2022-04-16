package TasksAttestation;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import static org.testng.Assert.*;

public class TestHelperTest {

    @Test
    public void testGetRndLong() {
        long actualResult = TestHelper.GetRndLong();
        assertTrue(actualResult >=
                Long.MIN_VALUE && actualResult
                <= Long.MAX_VALUE);

    }

    @Test
    public void testGetRndLong2() {
        long actualResul1 = TestHelper.GetRndLong();
        long actualResul2 = TestHelper.GetRndLong();
        long actualResul3 = TestHelper.GetRndLong();

        Assert.assertTrue(actualResul1 != actualResul2
                && actualResul1 != actualResul3);

    }

    @Test
    public void testGetRndDate() {
        Date actualResul1 = TestHelper.GetRndDate();
        Date actualResul2 = TestHelper.GetRndDate();
        Date actualResul3 = TestHelper.GetRndDate();

        Assert.assertTrue(actualResul1 != actualResul2
                && actualResul1 != actualResul3);
    }

    @Test
    public void testDateFormat() throws ParseException {
        String str = "02/15/1987";
        String actualResult = TestHelper.DateFormat(str);
        String expectedResult = "15/02/1987";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testGetRndString() {
        String actualResult = TestHelper.GetRndString();
        String regex = " [A-z]+\\s[A-z]+\\s[A-z]+";

        Assert.assertTrue(Boolean.parseBoolean(String.valueOf(actualResult.matches(regex))));

    }

    @Test
    public void testGetDouble() {
        Double actualResult = TestHelper.GetDouble("12");
        Double expectedResult = 12.0;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testReadFile() {
        File file = new File
                ("C:\\Users\\Admin\\IdeaProjects" +
                        "\\Attestation1\\src\\main\\resources\\Input.txt");
        Assert.assertTrue(file.exists(), String.valueOf(true));
    }
}