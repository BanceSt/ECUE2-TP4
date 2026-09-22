package net.lecnam.ussi2a.tp5;

public class Dessin {

    Figure[] figures = new Figure[100];
    int nbFigures = 0;

    void ajout(Figure figure){
        figures[nbFigures]=figure;
        nbFigures++;
    }

    double retourneSurfaceTotale(){
        double total = 0;
        for (Figure fig: figures) {
            if (fig == null) {
                break;
            }
            total += fig.retourneSurface();
        }
        return total;
    }

    double retournePerimetreTotale(){
        double total = 0;
        for (Figure fig: figures) {
            if (fig == null) {
                break;
            }
            total += fig.retournePerimetre();
        }
        return total;
    }

    void translate(double x, double y){

        for (Figure fig : figures) {
            if (fig == null) {
                break;
            }
            fig.translate(x, y);
        }

    }


    boolean contient(Point p){

        for (Figure fig : figures) {
            if (fig == null) {
                break;
            }
            if (fig.contient(p)) {
                return true;
            }
        }
        return false;

    }


    Figure retournePlusGrand(){
        Figure plusGrand = null;
        for (Figure fig : figures){
            if (fig == null) {
                break;
            }
            if(plusGrand == null || plusGrand.retourneSurface() < fig.retourneSurface()){
                plusGrand = fig;
            }
        }
        return plusGrand;
    }


}
