public class Segment{
	/*Vector3D x, y;
	Vector3D getStart(){return x;}
	Vector3D getEnd(){return y;}*/
	Vector x, y;
	public Segment(Vector a, Vector b){
		x = a;
		y = b;
	}
	public String toString() {
		return "отрезок [" + x  + ", " + y + "]";
	}
	Vector getStart(){return x;}
	Vector getEnd(){return y;}


	/*double len(){return x.sub(y).len();}
	double distanceTo(Vector3D point){//растояние от точки до отрезка
		// Для нахождения расстояния от точки для отрезка изпользуем формулу Герона площади треугольника
		//и формулу 1/2*основание*высота
		double a = x.sub(y).len();
		double b = x.sub(point).len();
		double c = y.sub(point).len();
		double p = (a + b + c)/2;
		double h = 2*Math.sqrt(p*(p-a)*(p-b)*(p-c))/a;

		return h;
	}*/


	double distanceTo(Vector point){//растояние от точки до отрезка
		// Для нахождения расстояния от точки для отрезка изпользуем формулу Герона площади треугольника
		//и формулу 1/2*основание*высота
		double a = x.sub(y).len();
		double b = x.sub(point).len();
		double c = y.sub(point).len();
		double p = (a + b + c)/2;
		double h = 2*Math.sqrt(p*(p-a)*(p-b)*(p-c))/a;

		return h;
	}

}