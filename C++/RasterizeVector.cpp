#include <iostream>
#include <vector>
#include <cmath>

class Point {
private:
    int x;
    int y;

public:
    // Constructor
    Point(int x, int y) : x(x), y(y) {}

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }
};

// Bresenham's rasterize algo.
std::vector<Point> rasterize(Point start, Point end) {
    std::vector<Point> points;

    int x1 = start.getX();
    int y1 = start.getY();
    int x2 = end.getX();
    int y2 = end.getY();

    // differences in x and y 
    int dx = std::abs(x2 - x1);
    // Negate dy to handle negative slopes
    int dy = -std::abs(y2 - y1);  
    // x-axis step direction
    int sx = x1 < x2 ? 1 : -1;    
    // y-axis step direction
    int sy = y1 < y2 ? 1 : -1;    
    // Initial error value, e_xy 
    int err = dx + dy;            

    // Loop until the start and end points are reached
    while (true) {
        // Add the current point to the list of rasterized points
        points.push_back(Point(x1, y1));

        // If current point is end point break
        if (x1 == x2 && y1 == y2) {
            break;
        }

        // Doubled error value
        int e2 = 2 * err;

        // Update corrd. and error if error is greater than or equal to change
        if (e2 >= dy) {
            err += dy;
            x1 += sx;
        }
        if (e2 <= dx) {
            err += dx;
            y1 += sy;
        }
    }

    return points;
}



int main() {
    //create a vector to store test cases
    std::vector<std::pair<Point, Point>> testCases = {
        {Point(1, 2), Point(4, 5)},
        {Point(4, 5), Point(1, 2)},
        // Add more test cases here as needed
    };

    // loop through testCases and implement rasterize()
    for (size_t i = 0; i < testCases.size(); ++i) {
        const Point &start = testCases[i].first;
        const Point &end = testCases[i].second;

        std::vector<Point> rasterizedPoints = rasterize(start, end);
        //print results
        std::cout << "\nRasterized points for start (" << start.getX() << "," << start.getY()
                  << ") and end (" << end.getX() << "," << end.getY() << "):" << std::endl;

        for (const Point &point : rasterizedPoints) {
            std::cout << point.getX() << "," << point.getY() << std::endl;
        }
    }

    return 0;
}

 