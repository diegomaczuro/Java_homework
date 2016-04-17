/*import package.Vector3D;*/

public class mainVector{
public static void main(String[] a){

	Vector3D vec1 = new Vector3D(2,4,4);
	Vector3D vec2 = new Vector3D(1,1,0);
	System.out.println(vec1.getX());
	System.out.println(vec1.getY());
	System.out.println(vec1.getZ());
	
	System.out.println(vec1.scalar(vec2));
	System.out.println(vec1.len());
	System.out.println(vec1.toString());
	
	//Number n = 0;
	//Class<? extends Number> c = n.getClass(); 
	Class<?> v = vec1.getClass();
	//m = vec1.getClass().getConstructors();
	//System.out.println(vec1.getClass().getConstructors());
	//System.out.println(vec1.add(vec2));
	//Vector3D vec3 = vec1.multiply(4);
	//System.out.println(vec3);
//	System.out.println(vec2.add(vec3));
	//System.out.println(vec1.sub(vec2));
	
System.out.println("bllddddllkdfisf");
}


}