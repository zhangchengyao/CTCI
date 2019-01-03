package chapter16_Moderate;

public class Q13_BisectSquares {
    class Point{
        double x;
        double y;
        Point(double _x, double _y){
            x = _x;
            y = _y;
        }
    }
    class Line{
        double slope;
        double yIntercept;
        Double x;
        Line(Point a, Point b){
            if(a.x==b.x){
                x = a.x;
            } else {
                x = null;
                slope = (b.y-a.y) / (b.x-a.x);
                yIntercept = b.y - slope*b.x;
            }
        }
    }
    class Square{
        double length;
        Point middle;

        Square(Point p1, Point p2, Point p3, Point p4){
            length = p2.x-p1.x;
            middle = new Point((p1.x+p2.x)/2, (p2.y+p3.y)/2);
        }

        Point[] getIntersection(Line line){
            Point[] res = new Point[2];
            double top = middle.y + length/2;
            double bottom = middle.y - length/2;
            double left = middle.x - length/2;
            double right = middle.x + length/2;
            if(Math.abs(line.slope)>=1){
                res[0] = new Point((top-line.yIntercept)/line.slope, top);
                res[1] = new Point((bottom-line.yIntercept)/line.slope, bottom);
            } else {
                res[0] = new Point(left, line.slope*left+line.yIntercept);
                res[1] = new Point(right, line.slope*right+line.yIntercept);
            }
            return res;
        }
    }

    /* return the leftmost and rightmost intersection of the line and two squares */
    Point[] cut(Square a, Square b){
        if(a.middle.x==b.middle.x){
            double x = a.middle.x;
            return new Point[]{new Point(x, Math.max(a.middle.y+a.length/2, b.middle.y+b.length/2)),
                        new Point(x, Math.min(a.middle.y-a.length/2, b.middle.y-b.length/2))};
        } else if(a.middle.y==b.middle.y){
            double y = a.middle.y;
            return new Point[]{new Point(Math.min(a.middle.x-a.length/2, b.middle.x-b.length/2), y),
                        new Point(Math.max(a.middle.x+a.length/2, b.middle.x+b.length/2), y)};
        }

        Line line = new Line(a.middle, b.middle);
        Point[] intersection1 = a.getIntersection(line);
        Point[] intersection2 = b.getIntersection(line);

        Point left1 = intersection1[0].x<intersection1[1].x?intersection1[0]:intersection1[1];
        Point right1 = intersection1[0].x<intersection1[1].x?intersection1[1]:intersection1[0];
        Point left2 = intersection2[0].x<intersection2[1].x?intersection2[0]:intersection2[1];
        Point right2 = intersection2[0].x<intersection2[1].x?intersection2[1]:intersection2[0];

        Point leftmost = left1.x<left2.x?left1:left2;
        Point rightmost = right1.x<right2.x?right2:right1;

        return new Point[]{leftmost, rightmost};
    }
}
