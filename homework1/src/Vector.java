public interface Vector {
    int dimension();             // размерность
    double getComponent(int i);  // возвращает компоненту вектора
    double scalar(Vector v);
    double len();
    Vector multiply(double factor);
    Vector add(Vector v);
    Vector sub(Vector v);

}
