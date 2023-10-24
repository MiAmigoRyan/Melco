#include <iostream>
#include <vector>
#include <cmath>

class Point {
private:
    int x;
    int y;
public:
    //Constructor
    Point(int x, int y) {
        this->x = x;
        this->y = y;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
};

//Functioin to rasterize a line between two points, this line is the thread that is laid between two needle punctures
std::vector<Point> rasterize(Point start, Point end) {
    
    std::vector<Point> points;

    //Correction for outer corners
    // If the end point is higher than the start point, decrement y corr of the start point.
    //If the end point is lower, increment y corr of the end point. 
    if (end.getY() < start.getY()) {
        start = Point(start.getX(), start.getY() - 1);
    } else {
        end = Point(end.getX(), end.getY() - 1);
    }

    int dx = end.getX() - start.getX();
    int dy = end.getY() - start.getY();
    
    int steps = std::max(std::abs(dx), std::abs(dy));

    // Case of both points being the same or steps == 0
    if (steps == 0) {
        points.push_back(start);
        return points;
    }

    // Calculate the incrment(or decrment)between points- or slope
    double xIncrement = dx / steps;
    double yIncrement = dy / steps;

    // Rasterize and store in vector
    double x = start.getX();
    double y = start.getY();
        for (int i=0; i<= steps; i++){
            points.push_back(Point(std::round(x),std::round(y)));
            x+= xIncrement;
            y+= yIncrement;
        }

   
    return points;
}

int main() {
    // First set of test points
    Point start(1, 2);
    Point end(4, 5);
    std::vector<Point> rasterizedPoints = rasterize(start, end);
    std::cout << "\nRasterized points for start (1,2) and end (4,5):" << std::endl;
    for (Point point : rasterizedPoints) {
        std::cout << point.getX() << "," << point.getY() << std::endl;
    }
    
    // Second set of test points
    Point start2(4, 5);
    Point end2(1, 2);
    std::vector<Point> rasterizedPoints2 = rasterize(start2, end2);
    std::cout << "\nRasterized points for start (4,5) and end (1,2):" << std::endl;
    for (Point point : rasterizedPoints2) {
        std::cout << point.getX() << "," << point.getY() << std::endl;
    }

    return 0;
}
    

