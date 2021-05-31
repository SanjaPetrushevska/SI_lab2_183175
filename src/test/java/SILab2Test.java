import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    SILab2 main = new SILab2();

    @Test
    public void multipleCondition() {

    }

    @Test
    public void everyBranch() {
        List<Time> timeList = new ArrayList<>();
        timeList.add(new Time(10, 0, 0));
        timeList.add(new Time(24, 0, 0));
        timeList.add(new Time(10, 59, 0));
        timeList.add(new Time(10, 59, 59));

        List<Integer> results = main.function(timeList);

        assertEquals(results.get(0), 10*60*60);
        assertEquals(results.get(1), 24*60*60);
        assertEquals(results.get(2), 10*60*60 + 59*60 + 0);
        assertEquals(results.get(3), 10*60*60 + 59*60 + 59);

        timeList.add(new Time(-1, 0, 0));
        Exception exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(4, 5));
        });
        String expectedMessage = "The hours are smaller than the minimum";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(25, 0, 0));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(5, 6));
        });
        expectedMessage = "The hours are grater than the maximum";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(23, -1, 0));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(6, 7));
        });
        expectedMessage = "The minutes are not valid!";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(23, 60, 0));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(7, 8));
        });
        expectedMessage = "The minutes are not valid!";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(23, 59, -1));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(8, 9));
        });
        expectedMessage = "The seconds are not valid";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(23, 59, 60));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(9, 10));
        });
        expectedMessage = "The seconds are not valid";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

        timeList.add(new Time(24, 59, 60));
        exception = assertThrows(RuntimeException.class, () -> {
            main.function(timeList.subList(10, 11));
        });
        expectedMessage = "The time is greater than the maximum";
        actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

    }
}
