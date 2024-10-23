import org.junit.Test;
import static org.junit.Assert.*;
public class RBTests {
    @Test
    public void testToString(){
        RBTree rbt = new RBTree();
        rbt.insert(4);
        rbt.insert(8);
        rbt.insert(2);

        String expected = "2 4 8";
        String actual = rbt.toString();

        assertEquals(expected, actual);
    }
    @Test
    public void testInsert(){
        RBTree rbt = new RBTree();
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(4);
        rbt.insert(13);
        rbt.insert(15);

        String expected = "4 5 10 13 15";
        String actual = rbt.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testFind(){
        RBTree rbt = new RBTree();
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(4);

        boolean expected1 = true;
        boolean actual1 = rbt.find(10);

        boolean expected2 = false;
        boolean actual2 = rbt.find(2);
    }

}
