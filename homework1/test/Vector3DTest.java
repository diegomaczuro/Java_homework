import org.junit.*;
import org.junit.Test;


public class Vector3DTest extends Assert {

    @Before
    public void setUp() {
        //Запускается перед каждым тестом
    }

    @After
    public void tearDown() {
        //Запускается после каждого теста
    }

    @Test
    public void testSample() {
        assertEquals(10,10);
    }

    @Test
    public void testConstructor() {
        Vector3D vec = new Vector3D(10,20,30);

        assertEquals(10,vec.getX(), 0.0001);
        assertEquals(20,vec.getY(), 0.0001);
        assertEquals(30,vec.getZ(), 0.0001);
    }

    @Test
    public void testAdd() {
        Vector3D vec1 = new Vector3D(1,2,3);
        Vector3D vec2 = new Vector3D(5,6,7);
        //Vector3D vec3 = vec1.add(vec2);

        //assertEquals(6, vec3.getX(), 0.0001);
        //assertEquals(8, vec3.getY(), 0.0001);
        //assertEquals(10, vec3.getZ(), 0.0001);

        Vector vec3 = vec1.add(vec2);
        assertEquals(6, vec3.getComponent(1), 0.0001);
        assertEquals(8, vec3.getComponent(2), 0.0001);
        assertEquals(10,vec3.getComponent(3), 0.0001);
    }
    @Test
    public void testSub(){
        Vector3D vec1 = new Vector3D(1,2,3);
        Vector3D vec2 = new Vector3D(5,6,7);
        /*Vector3D vec3 = vec1.sub(vec2);

        assertEquals(-4, vec3.getX(), 0.0001);
        assertEquals(-4, vec3.getY(), 0.0001);
        assertEquals(-4, vec3.getZ(), 0.0001);*/
        Vector vec3 = vec1.sub(vec2);

        assertEquals(-4, vec3.getComponent(1), 0.0001);
        assertEquals(-4, vec3.getComponent(2), 0.0001);
        assertEquals(-4, vec3.getComponent(3), 0.0001);

    }

    @Test
    public void testLen(){
        Vector3D vec1 = new Vector3D(1,0,0);
        assertEquals(1, vec1.len(), 0.0001);

        Vector3D vec2 = new Vector3D(3,0,4);
        assertEquals(5, vec2.len(), 0.0001);

        Vector3D vec3 = new Vector3D(0,0,0);
        assertEquals(0, vec3.len(), 0.0001);
    }

    @Test
    public void testMultiply(){
        Vector3D vec1 = new Vector3D(1,0,0);
        Vector3D vec3 = new Vector3D(4,0,0);
        /*Vector3D vec2 = vec1.multiply(4);
        assertEquals(vec3.getX(), vec2.getX(), 0.0001);
        assertEquals(vec3.getY(), vec2.getY(), 0.0001);
        assertEquals(vec3.getZ(), vec2.getZ(), 0.0001);

        Vector3D vec11 = new Vector3D(1,-2,3);
        Vector3D vec13 = new Vector3D(-6, 12,-18);
        Vector3D vec12 = vec11.multiply(-6);
        assertEquals(vec13.getX(), vec12.getX(), 0.0001);
        assertEquals(vec13.getY(), vec12.getY(), 0.0001);
        assertEquals(vec13.getZ(), vec12.getZ(), 0.0001);*/

        Vector vec2 = vec1.multiply(4);
        assertEquals(vec3.getX(), vec2.getComponent(1), 0.0001);
        assertEquals(vec3.getY(), vec2.getComponent(2), 0.0001);
        assertEquals(vec3.getZ(), vec2.getComponent(3), 0.0001);
        Vector3D vec11 = new Vector3D(1,-2,3);
        Vector3D vec13 = new Vector3D(-6, 12,-18);
        Vector vec12 = vec11.multiply(-6);
        assertEquals(vec13.getX(), vec12.getComponent(1), 0.0001);
        assertEquals(vec13.getY(), vec12.getComponent(2), 0.0001);
        assertEquals(vec13.getZ(), vec12.getComponent(3), 0.0001);


    }




}