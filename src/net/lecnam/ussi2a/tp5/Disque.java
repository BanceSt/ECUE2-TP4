package net.lecnam.ussi2a.tp5;

public class Disque extends Figure {

    Point center;
    Double rayon;

    public Disque(Point center, Double rayon) {
        this.center = center;
        this.rayon = rayon;
    }

    public void translate(double x, double y) {
        center.x += x;
        center.y += y;
    }

    public double retourneSurface() {
        return Math.PI * Math.pow(rayon, 2);
    }

    public double retournePerimetre() {
        return 2 * Math.PI * rayon;
    }

    public boolean contient(Point ptn) {
        return rayon >= center.retourneDistance(ptn);
    }

    @Override
    public String toString() {
        return String.format("rayon : %f, centre : %s", rayon, center);
    }
}
