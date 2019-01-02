package chapter16_Moderate;

public class Q3_Intersection {
    class Line{
        double slope;
        double intercept;

        Line(Point a, Point b){
            slope = (b.y-a.y) / (b.x-a.x);
            intercept = b.y - slope*b.x;
        }
    }

    class Point{
        double x;
        double y;
        Point(double _x, double _y){
            x = _x;
            y = _y;
        }

        boolean isBefore(Point p){
            return x <= p.x;
        }

        boolean isBetween(Point a, Point b){
            boolean xBetween, yBetween;
            if(a.x<=b.x) xBetween = a.x<=x && x<=b.x;
            else xBetween = b.x<=x && x<=a.x;

            if(a.y<=b.y) yBetween = a.y<=x && x<=b.y;
            else yBetween = b.y<=x && x<=a.y;

            return xBetween && yBetween;
        }
    }

    Point getIntersection(Point start1, Point end1, Point start2, Point end2){
        if(end1.isBefore(start1)) swap(start1, end1);
        if(end2.isBefore(start2)) swap(start2, end2);
        if(start2.isBefore(start1)){
            swap(start1, start2);
            swap(end2, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if(line1.slope==line2.slope){
            if(line1.intercept==line2.intercept && start2.isBetween(start1, end1)){
                return start2;
            }
            return null;
        }

        double x = (line2.intercept-line1.intercept) / (line1.slope-line2.slope);
        double y = line1.slope*x + line1.intercept;
        Point intersect = new Point(x, y);

        if(intersect.isBetween(start1, end1) && intersect.isBetween(start2, end2)){
            return intersect;
        }
        return null;
    }


    private void swap(Point a, Point b){
        double x = a.x;
        double y = a.y;
        a.x = b.x;
        a.y = b.y;
        b.x = x;
        b.y = y;
    }
}
