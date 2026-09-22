package net.lecnam.ussi2a.tp5;

public class Triangle extends Figure implements Inclinable{

    Point ptn1;
    Point ptn2;
    Point ptn3;
    double angle = 0;

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
        double angleRad = angle * Math.PI/180;
        double xb2 = ptn1.x + (ptn2.x - ptn1.x) * Math.cos(angleRad) - (ptn2.y - ptn1.y) * Math.sin(angleRad);
        double yb2 = ptn1.y + (ptn2.x - ptn1.x) * Math.sin(angleRad) + (ptn2.y - ptn1.y) * Math.cos(angleRad);
        double xb3 = ptn1.x + (ptn3.x - ptn1.x) * Math.cos(angleRad) - (ptn3.y - ptn1.y) * Math.sin(angleRad);
        double yb3 = ptn1.y + (ptn3.x - ptn1.x) * Math.sin(angleRad) + (ptn3.y - ptn1.y) * Math.cos(angleRad);

        Point ptn2bis = new Point(xb2, yb2);
        Point ptn3bis = new Point(xb3, yb3);

        double p = retournePerimetre();
        double ab = ptn1.retourneDistance(ptn2bis);
        double bc = ptn2bis.retourneDistance(ptn3bis);
        double ac = ptn3bis.retourneDistance(ptn1);

        double ma = ptn.retourneDistance(ptn1);
        double mb = ptn.retourneDistance(ptn2bis);
        double mc = ptn.retourneDistance(ptn3bis);

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

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void pivoter(double degres) {
        this.angle = angle;
    }
}
