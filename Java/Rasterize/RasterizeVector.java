package Rasterize;

import java.util.ArrayList;
import java.util.List;

public class RasterizeVector {

	public static void main(String[] args) {
		Point start = new Point(1, 2);
		Point end = new Point(4, 5);
		List<Point> rasterizedPoints = rasterize(start, end);

		// Print the rasterized points
		System.out.println("Rasterized line of Start (1,2) End (4,5)");
		for (Point point : rasterizedPoints) {
			System.out.println(point.getX() + "," + point.getY());
		}
		Point start2 = new Point(4, 5);
		Point end2 = new Point(1, 2);
		List<Point> rasterizedPoints2 = rasterize(start2, end2);

		// Print the rasterized points for reversed start and end
		System.out.println("Rasterized line of Start (4,5) End (1,2)");
		for (Point point : rasterizedPoints2) {
			System.out.println(point.getX() + "," + point.getY());
		}
	}

	// Rasterizes a vector between two points and returns a list of integer
	// coordinate points. start The starting point of the vector. end The ending
	// point of the vector.

	public static List<Point> rasterize(Point start, Point end) {
		List<Point> points = new ArrayList<>();

		// Correction for outer corners
        // If the end point is higher than the start point, decrement y corr of the start point.
        // If the end point is lower, increment y corr of the end point.
        if (end.getY() < start.getY()) {
            start = new Point(start.getX(), start.getY() - 1);
        } else {
            end = new Point(end.getX(), end.getY() - 1);
        }

		double x = start.getX();
		double y = start.getY();

		// change "d" in x or y
		// use absolute value for x or y per Enhanced solution
		int dx = end.getX() - start.getX();
		int dy = end.getY() - start.getY();

		// finds the larger value between dx and dy so that steps is the maximum number
		// of values to be traversed
		// from start to end
		int steps = Math.max(dx, dy);

		// use ternary to set xIncrement and yIncrement to 0 if dx or dy is 0 : avoids
		// dividing by zero
		double xIncrement =  dx / steps;
		double yIncrement =  dy / steps;

		// Reversing the result of inputs

		for (int i = 0; i <= steps; i++) {
			points.add(new Point((int) Math.round(x), (int) Math.round(y)));
			x += xIncrement;
			y += yIncrement;
		}

		return points;
	}

}
