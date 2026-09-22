package net.lecnam.ussi2a.tp5;

import org.w3c.dom.css.Rect;

import javax.naming.NamingEnumeration;
import java.util.Scanner;

public class Exec {

    static Dessin dessin = new Dessin();

    public static void main(String[] args) {

       Rectangle rect1 = new Rectangle(25, 30, 10, 12);
       Rectangle rect2 = new Rectangle(55, 12, 65, 42);
       Disque disc1 = new Disque(1, 1, 10);
       Disque disc2 = new Disque(30, 35, 10);

       Triangle trig1 = new Triangle(20, 35, 56, 55, 78, 980);
       Triangle trig2 = new Triangle(0, 35, 89, 78, 15, 51);
       Triangle trig3 = new Triangle(29, 3, 6, 5, 45, 55);

       RectangleIncline rectI1 = new RectangleIncline(500, 20, 52, 69, 30);
       RectangleIncline rectI2 = new RectangleIncline(50, 29, 32, 6958, 32);




       dessin.ajout(rect1);
       dessin.ajout(rect2);
       dessin.ajout(disc1);
       dessin.ajout(disc2);
       dessin.ajout(trig1);
       dessin.ajout(trig2);
       dessin.ajout(trig3);
       dessin.ajout(rectI1);
       dessin.ajout(rectI2);

       System.out.println("Toutes les surfaces : " + dessin.retourneSurfaceTotale());

       System.out.println("La plus grande figure : " + dessin.retournePlusGrand());

       if (dessin.contient(new Point(346, 35))) {
           System.out.println("Le point est dans une figure");
       }

    }


}
