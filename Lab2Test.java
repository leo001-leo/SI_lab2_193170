import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lab2Test {

    private List<Time> createList(Integer... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    public void everyBranch(){
        RuntimeException ex;

        //1
        assertEquals(0, SILab2.function(createList()));

        //2
        assertEquals(9650, SILab2.function(createList(2,39,49)));

        //3
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(1,11,9)));
        assertTrue(ex.getMessage().contains("The hours are greater than the maximum"));

        //4
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(29,32,12)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //5
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,0,0)));
        assertTrue(ex.getMessage().contains("The minutes are greater than the maximum"));

        //7
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(19,9,36)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //8
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(19,8,36)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //9
        assertEquals(86400, SILab2.function(createList(24,19,25)));
    }

    @Test
    public void multipleCondition(){
        RuntimeException ex;

        //1
        assertEquals(0, SILab2.function(createList()));

        //2
        assertEquals(9650, SILab2.function(createList(2,40,50)));

        //3
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(28,30,15)));
        assertTrue(ex.getMessage().contains("The hours are greater than the maximum"));

        //4
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(-2,25,12)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //5
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(20,5,70)));
        assertTrue(ex.getMessage().contains("The minutes are greater than the maximum"));

        //7
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(20,65,30)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //8
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,10,12)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //9
        assertEquals(86400, SILab2.function(createList(24,0,0)));
    }
}