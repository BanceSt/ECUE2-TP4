package net.lecnam.ussi2a.tp5;

public class Dessin {

    Rectangle[] figures = new Rectangle[100];
    int nbFigures = 0;

    void ajout(Rectangle figure){
        figures[nbFigures]=figure;
        nbFigures++;
    }

    double retourneSurfaceTotale(){
        double total = 0;
        for (Rectangle fig: figures) {
            if (fig == null) {
                break;
            }
            total += fig.retourneSurface();
        }
        return total;
    }

    double retournePerimetreTotale(){
        double total = 0;
        for (Rectangle fig: figures) {
            if (fig == null) {
                break;
            }
            total += fig.retournePerimetre();
        }
        return total;
    }

    void translate(double x, double y){

        for (Rectangle fig : figures) {
            if (fig == null) {
                break;
            }
            fig.translate(x, y);
        }

    }


    boolean contient(Point p){

        for (Rectangle fig : figures) {
            if (fig == null) {
                break;
            }
            if (fig.contient(p)) {
                return true;
            }
        }
        return false;

    }


    Rectangle retournePlusGrand(){
        Rectangle plusGrand = null;
        for (Rectangle fig : figures){
            if (fig == null) {
                break;
            }
            if(plusGrand == null || plusGrand .retourneSurface() < fig.retourneSurface()){
                plusGrand = fig;
            }
        }
        return plusGrand;
    }


}
