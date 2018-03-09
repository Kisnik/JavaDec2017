/*
 * Created by Kisnik on 30.01.2018.
 */

import java.util.*;

public class AreaTest {
    public static void main(String[] args) {
        Rectangles a = new Rectangles(); //creation of rectangle
        double[] a1 = {0, 3}; //corrs  of the first point
        double[] a2 = {3, 4}; //corrs  of the second point
        a.setCorr1(a1);
        a.setCorr2(a2);
        double S1 = a.rectanglesArea(); //area of rectangle
        System.out.println("The area of the first rectangle is: " + S1);
        Rectangles b = new Rectangles();
        double[] b1 = {0, 0}; //corrs  of the first point (second rectangle)
        double[] b2 = {4, 2}; //corrs  of the second point (second rectangle)
        b.setCorr1(b1);
        b.setCorr2(b2);
        double S2 = b.rectanglesArea();
        System.out.println("The area of the second rectangle is: " + S2);
        double S3 = b.rectanglesCrossSection(a, b);
        System.out.println("The area of the cross section of rectangles is: " + S3);
    }
}

