public class Vector2D implements  Vector{
    private final double x, y;

    public Vector2D(double a, double b){
        x = a;
        y = b;
    }
    public String toString() {
        return "x=" + x  + " y=" + y;
    }
    //public final Class<Vector3D> getClass(){};

    public int dimension(){return 3;}             // размерность

    public  double getComponent(int i){// возвращает компоненту вектора
        if (i==1){return x;}
        else {return y;}
    }

    double getX(){return x;}

    double getY(){return y;}


    public double scalar(Vector v){/*скалярное произведение векторов*/
        return (x*v.getComponent(1) + y*v.getComponent(2));}

    public  double len(){/*длина вектора*/return Math.sqrt(x*x + y*y);}


    public Vector add(Vector v){ // сложение векторов
        double a = x + v.getComponent(1);
        double b = y + v.getComponent(2);
        return  new Vector2D(a,b);
    }
    public Vector sub(Vector v){ // вычитание векторов
        double a = x - v.getComponent(1);
        double b = y - v.getComponent(2);
        return  new Vector2D(a,b);
    }

    public Vector multiply(double factor){ 	// умножение на число
        double a = x*factor;
        double b = y*factor;
        return  new Vector2D(a,b);
    }
}

