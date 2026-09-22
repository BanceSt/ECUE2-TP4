package net.lecnam.ussi2a.tp5;

public abstract class Figure {

    public abstract void translate(double x, double y);
    public abstract boolean contient(Point ptn);
    public abstract double retournePerimetre();
    public abstract double retourneSurface();
}
