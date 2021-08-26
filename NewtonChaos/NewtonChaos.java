/******************************************************************************
 *  Compilation:  javac NewtonChaos.java
 *  Execution:    java NewtonChaos n
 *  Dependencies: Picture.java, Complex.java
 *
 *  Creates an n by n picture that takes the complex coordinate of each pixel
 *  and runs it through Newton's method until it either converges to 1, -1, i, 
 *  -i or it goes through 100 iterations, and applies color to that pixel based
 *  what it converges to. The complex coordinate is also constrained in the
 *  interval [-1, 1] for both axis.
 *
 *  % java NewtonChaos 500
 *
 *  By Arib Chowdhury Pd.3 and Jason Chan Pd.8
 *
 ******************************************************************************/

import java.awt.Color;
public class NewtonChaos {
  	public static Color Convergence(Complex z0) {
    	int iter = 100;
    	Complex z = z0;
    	Complex opt1 = new Complex(1,0);
    	Complex opt2 = new Complex(-1,0);
    	Complex opt3 = new Complex(0,1);
    	Complex opt4 = new Complex(0,-1);
    	while (iter > 0) {
      		iter--;
      		z = z.minus(((z.times(z).times(z).times(z)).minus(opt1)).divides(((z.times(z).times(z)).scale(4))));
      		if (z.equals(opt1)) return Color.WHITE;
      		if (z.equals(opt2)) return Color.RED;
      		if (z.equals(opt3)) return Color.GREEN;
      		if (z.equals(opt4)) return Color.BLUE;
    	}
    	return Color.BLACK;
  	}
  	public static void main(String[] args) {
    	int n = Integer.parseInt(args[0]);
    	Picture res = new Picture(n,n);
    	int center = res.width()/2;
    	Complex comCenter = new Complex(center, 0);
    	for (int col = 0; col < res.width(); col++) {
      		for (int row = 0; row < res.height(); row++) {
        		Complex z = new Complex(col-center,row-center);
        		res.set(col,row,Convergence(z.divides(comCenter)));
      		}
    	}
    	res.show();
  	}
}
