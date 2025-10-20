import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void arrayCount9() {
    }

    @org.junit.Test
    public void main() {
        assertEquals(1, new CodingBat().arrayCount9(new int [] {1, 2, 9}));
        assertEquals(2, new CodingBat().arrayCount9(new int [] {1, 9, 9}));
        assertEquals(3, new CodingBat().arrayCount9(new int [] {1, 9, 9, 3, 9}));
        assertEquals(0, new CodingBat().arrayCount9(new int []{}));
        assertEquals(0, new CodingBat().arrayCount9(new int []{4, 2, 4, 3, 1}));
        assertEquals(1, new CodingBat().arrayCount9(new int [] {9, 2, 4, 3, 1}));

    }
}