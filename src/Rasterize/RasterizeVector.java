package Rasterize;

import java.util.ArrayList;
import java.util.List;

public class RasterizeVector {

	public static void main(String[] args) {
		Point start = new Point(1, 2);
		Point end = new Point(4, 5);
		List<Point> rasterizedPoints = rasterize(start, end);

		// Print the rasterized points 
		for (Point point : rasterizedPoints) {
			System.out.println(point.getX() + "," + point.getY());
		}
	}

	/**
	 * Rasterizes a vector between two points and returns a list of integer
	 * coordinate points. start The starting point of the vector. end The ending
	 * point of the vector.
	 */
	public static List<Point> rasterize(Point start, Point end) {
		List<Point> points = new ArrayList<>();

		double x = start.getX();
		double y = start.getY();

		// change in x or y
		// use absolute value for x or y per Enhanced solution
		int dx = Math.abs(end.getX() - start.getX());
		int dy = Math.abs(end.getY() - start.getY());

		// finds the larger value between dx and dy so that steps is the maximum number
		// of values to be traversed
		// from start to end
		int steps = Math.max(dx, dy);

		// use ternary to set xIncrement and yIncrement to 0 if dx or dy is 0 : avoids
		// dividing by zero
		double xIncrement = dx == 0 ? 0 : (double) dx / steps;
		double yIncrement = dy == 0 ? 0 : (double) dy / steps;

		// E N H A N C E D
		// Reversing the result of inputs
		if (start.getX() < end.getX()) {
			for (int i = 0; i <= steps; i++) {
				points.add(new Point((int) Math.round(x), (int) Math.round(y)));
				x += xIncrement;
				y += yIncrement;
			}
		} else {
			for (int i = 0; i <= steps; i++) {
				points.add(new Point((int) Math.round(x), (int) Math.round(y)));
				x -= xIncrement;
				y -= yIncrement;
			}
		}

		return points;
	}

}
