package net.lecnam.ussi2a.tp5;


public class Rectangle extends Figure implements Inclinable {

    double longueur;
    double largeur;
    double angle = 0;
    Point point;



    Rectangle(double longueur, double largeur, Point point) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.point = point;
    }

    Rectangle(double longueur, Point point, double largeur, double angle) {
        this(longueur, largeur, point);
        this.angle = angle;
    }

    Rectangle(double longueur, double largeur, double x, double y) {
        this(longueur, largeur, new Point(x, y));
    }

    Rectangle(double longueur, double largeur, double x, double y, double angle) {
        this(longueur, largeur, new Point(x, y));
        this.angle = angle;
    }

    public double retourneSurface(){
        return this.longueur *this.largeur;
    }



    public double retournePerimetre(){
        return 2 * (this.longueur + this.largeur);
    }

    public void translate(double x, double y){
        this.point.translate(x,y);
    }


    public boolean contient(Point point) {
        double a = Math.toRadians(this.angle);
        double dx = point.x - this.point.x;
        double dy = point.y - this.point.y;
        double rotx =  dx * Math.cos(a) + dy * Math.sin(a);
        double roty = -dx * Math.sin(a) + dy * Math.cos(a);
        return 0 <= rotx && rotx <= this.longueur
                && 0 <= roty && roty <= this.largeur;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void pivoter(double degres) {
        angle += degres;
    }

    @Override
    public boolean equals(Object object){
        Rectangle rectangle = (Rectangle) object;
        return this.point.equals(rectangle.point)
                && this.longueur == rectangle.longueur
                && this.largeur == rectangle.largeur
                && this.angle == rectangle.angle;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longeur=" + longueur +
                ", largeur=" + largeur +
                ", point=" + point +
                ", surface=" + this.retourneSurface() +
                ", angle=" + angle +
                '}';
    }


}
