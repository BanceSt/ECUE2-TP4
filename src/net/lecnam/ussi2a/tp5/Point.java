package net.lecnam.ussi2a.tp5;

public class Point {

    double x;
    double y;

     Point(double x, double y) {
        this.x=x;
        this.y=y;
    }

    void translate(double x, double y){
        this.x=x;
        this.y=y;
    }

    double retourneDistance(Point point){
        return Math.sqrt((this.x-point.x)*(this.x-point.x)+(this.y-point.y)*(this.y-point.y));
    }

    @Override
    public boolean equals(Object object){
        Point point = (Point) object;
        return this.x==point.x && this.y==point.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
