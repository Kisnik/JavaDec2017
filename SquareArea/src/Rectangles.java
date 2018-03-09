import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.sort;


/**
 * Created by Kisnik on 30.01.2018.
 */
public class Rectangles {
    private double[] corr1;
    private double[] corr2;

    public void setCorr1(double[] corr1) {
        this.corr1 = corr1;
    }

    public void setCorr2(double[] corr2) {
        this.corr2 = corr2;
    }

    public double rectanglesArea() { //Area of one rectangle

        return abs(corr1[0] - corr2[0]) * abs(corr1[1] - corr2[1]);
    }

    public double rectanglesCrossSection(Rectangles num1, Rectangles num2) { //Area of cross section
        double[] arrX = {num1.corr1[0], num1.corr2[0], num2.corr1[0], num2.corr2[0]}; //array of X-corrs of both rectangles
        sort(arrX);
        double[] arrY = {num1.corr1[1], num1.corr2[1], num2.corr1[1], num2.corr2[1]}; //array of X-corrs of both rectangles
        sort(arrY);
        if (min(num1.corr1[0], num1.corr2[0]) > max(num2.corr1[0], num2.corr2[0]))
            return 0; //compare min X of the 1st rect with max X of the 2nd rect
        if (max(num1.corr1[0], num1.corr2[0]) < min(num2.corr1[0], num2.corr2[0]))
            return 0; //compare max X of the 1st rect with min X of the 2nd rect
        if (min(num1.corr1[1], num1.corr2[1]) > max(num2.corr1[1], num2.corr2[1]))
            return 0; //compare min Y of the 1st rect with max Y of the 2nd rect
        if (max(num1.corr1[1], num1.corr2[1]) < min(num2.corr1[1], num2.corr2[1]))
            return 0; //compare max Y of the 1st rect with min Y of the 2nd rect
        else
            return abs((arrX[1] - arrX[2]) * (arrY[1] - arrY[2])); // count the area of the cross section if it is not a zero
    }
}
