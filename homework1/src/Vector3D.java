public final class  Vector3D implements  Vector{
 	private final double x, y, z;
 	
 	public Vector3D(double a, double b, double c){
 		x = a;
 		y = b;
 		z = c;
 	}
 	public String toString() {
        return "x=" + x  + " y=" + y + " z=" + z;
    }
 	//public final Class<Vector3D> getClass(){};

    public int dimension(){return 3;}             // размерность

    public  double getComponent(int i){// возвращает компоненту вектора
		if (i==1){return x;}
		else if (i==2){return y;}
		else {return z;}}



 	double getX(){return x;}
 	
 	double getY(){return y;}
 		
 	double getZ(){return z;}

 	
 	//double scalar(Vector3D v){/*скалярное произведение векторов*/
 	//	return (x*v.getX() + y*v.getY() + z*v.getZ());}

    public double scalar(Vector v){/*скалярное произведение векторов*/
    	return (x*v.getComponent(1) + y*v.getComponent(2) + z*v.getComponent(3));}

    public  double len(){/*длина вектора*/return Math.sqrt(x*x + y*y + z*z);}

 	//Vector3D multiply(double factor){ 	// умножение на число
 	//	double a = x*factor;
 	//	double b = y*factor;
 	//	double c = z*factor;
 	//	return  new Vector3D(a,b,c);
 	//}

 	/*Vector3D add(Vector3D v){ // сложение векторов
 		double a = x + v.getX();
 		double b = y + v.getY();
 		double c = z + v.getZ();	
 		return  new Vector3D(a,b,c);
 	} 
 	Vector3D sub(Vector3D v){ // вычитание векторов
 		double a = x - v.getX();
 		double b = y - v.getY();
 		double c = z - v.getZ();	
 		return  new Vector3D(a,b,c);
	}*/

    public Vector add(Vector v){ // сложение векторов
        double a = x + v.getComponent(1);
        double b = y + v.getComponent(2);
        double c = z + v.getComponent(3);
        return  new Vector3D(a,b,c);
    }
    public Vector sub(Vector v){ // вычитание векторов
        double a = x - v.getComponent(1);
        double b = y - v.getComponent(2);
        double c = z - v.getComponent(3);
        return  new Vector3D(a,b,c);
    }

    public Vector multiply(double factor){ 	// умножение на число
        double a = x*factor;
        double b = y*factor;
        double c = z*factor;
        return  new Vector3D(a,b,c);
    }
}

