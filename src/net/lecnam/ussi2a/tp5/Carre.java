package net.lecnam.ussi2a.tp5;

public class Carre extends Rectangle {


    public Carre(double cote, Point point) {
        super(cote, cote, point);
    }

    public Carre(double cote, double x, double y) {
        super(cote, cote, x, y);
    }

    @Override
    public String toString() {
        return "Carré{" +
                "cote =" + longueur +
                ", point=" + point +
                ", surface=" + this.retourneSurface() +
                '}';
    }
}
