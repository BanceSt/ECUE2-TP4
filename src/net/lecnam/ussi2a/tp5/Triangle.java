package net.lecnam.ussi2a.tp5;

public class Triangle extends Figure{

    Point ptn1;
    Point ptn2;
    Point ptn3;

    public Triangle(Point ptn1, Point ptn2, Point ptn3) {
        this.ptn1 = ptn1;
        this.ptn2 = ptn2;
        this.ptn3 = ptn3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    @Override
    public void translate(double x, double y) {
        ptn1.translate(x, y);
        ptn2.translate(x, y);
        ptn3.translate(x, y);
    }

    @Override
    public boolean contient(Point ptn) {
        double p = retournePerimetre();
        double ab = ptn1.retourneDistance(ptn2);
        double bc = ptn2.retourneDistance(ptn3);
        double ac = ptn3.retourneDistance(ptn1);

        double ma = ptn.retourneDistance(ptn1);
        double mb = ptn.retourneDistance(ptn2);
        double mc = ptn.retourneDistance(ptn3);

        return ((p/2 <= ma + mb + mc) && (ma + mb + mc <= (p - Math.min(ab, Math.min(bc, ac)))));
    }

    @Override
    public double retournePerimetre() {
        return ptn1.retourneDistance(ptn2) + ptn2.retourneDistance(ptn3) + ptn3.retourneDistance(ptn1);
    }

    @Override
    public double retourneSurface() {
        double s = retournePerimetre()/2;
        double distA = ptn1.retourneDistance(ptn2);
        double distB = ptn2.retourneDistance(ptn3);
        double distC = ptn3.retourneDistance(ptn1);

        return Math.sqrt(s * (s - distA) * (s - distB) * (s - distC));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", ptn1, ptn2, ptn3);
    }
}
