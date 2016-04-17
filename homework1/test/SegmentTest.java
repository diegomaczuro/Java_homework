import org.junit.*;
import org.junit.Test;

public class SegmentTest extends Assert{

    @Before
    public void setUp() {
        //Запускается перед каждым тестом
    }

    @After
    public void tearDown() {
            //Запускается после каждого теста
    }

    @Test
    public void testGetStart() {
        Vector2D a = new Vector2D(0, 1);
        Vector2D b = new Vector2D(0, 2);
        Segment d = new Segment(a, b);
        assertEquals(a, d.getStart());
    }

    public void testGetEnd() {
        Vector2D a = new Vector2D(0, 1);
        Vector2D b = new Vector2D(0, 2);
        Segment d = new Segment(a, b);
        assertEquals(b, d.getEnd());
    }

    public void testDistanceTo() {
        Vector2D a = new Vector2D(0, 1);
        Vector2D b = new Vector2D(0, 2);
        Segment d = new Segment(a, b);
        Vector2D point = new Vector2D(1.5, 2);
        assertEquals(2, d.distanceTo(point), 0.0001);
    }

}
