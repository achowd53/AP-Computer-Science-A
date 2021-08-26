/******************************************************************************
 * Partners: Arib Chowdhury and Vladislav Vostrikov
 *
 *  Compilation:  javac BouncingBallWithTracks.java
 *  Execution:    java BouncingBallWithTracks
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1)
 *  with tracks showing movement.
 *
 *  % java BouncingBallWithTracks
 *
 ******************************************************************************/

public class BouncingBallWithTracks {
    public static void main(String[] args) {

        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // initial values
        double rx = 0.480, ry = 0.860;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;              // radius
        double[][] positions = new double[1000000][2];
        int movement = 0;
        // main animation loop
        while (true)  {
            // bounce off wall according to law of elastic collision
            if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

            // update position and add position to tracks
            positions[movement][0] = rx;
            positions[movement][1] = ry;
            movement++;
            rx = rx + vx;
            ry = ry + vy;

            // clear the background
            StdDraw.clear(StdDraw.GRAY);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            //Draw Tracks
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            for (int x = 0; x < movement; x++){
                StdDraw.filledCircle(positions[x][0],positions[x][1], radius);
            }
            // copy offscreen buffer to onscreen
            StdDraw.show();

            // pause for 20 ms
            StdDraw.pause(20);

        }
    }
}
