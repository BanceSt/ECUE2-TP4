package net.lecnam.ussi2a.tp5;

public class RectangleIncline extends Rectangle{
    double angles;

    public RectangleIncline(double longueur, double largeur, double x, double y, double angles) {
        super(longueur, largeur, x, y);
        this.angles = angles;
    }

    public RectangleIncline(double longueur, double largeur, Point point, double angles) {
        super(longueur, largeur, point);
        this.angles = angles;
    }
}
