package net.lecnam.ussi2a.tp5;

import org.w3c.dom.css.Rect;

import javax.naming.NamingEnumeration;
import java.util.Scanner;

public class Exec {

    static Dessin dessin = new Dessin();

    public static void main(String[] args) {

       Rectangle rect1 = new Rectangle(25, 30, 10, 12);
       Rectangle rect2 = new Rectangle(55, 12, 65, 42);
       Disque disc1 = new Disque(1, 1, 500);
       Disque disc2 = new Disque(30, 35, 10);

       dessin.ajout(rect1);
       dessin.ajout(rect2);
       dessin.ajout(disc1);
       dessin.ajout(disc2);

       System.out.println("Toutes les surfaces : " + dessin.retourneSurfaceTotale());

       System.out.println("La plus grande figure : " + dessin.retournePlusGrand());

       if (dessin.contient(new Point(346, 35))) {
           System.out.println("Le point est dans une figure");
       }

    }


}
