package chapter16_Moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q14_BestLine {
    class Point{
        double x, y;
        Point(double _x, double _y){
            x = _x;
            y = _y;
        }
    }
    class Line{
        static final double epsilon = 0.00001;
        double slope, intercept;
        boolean infiniteSlope;

        Line(Point a, Point b){
            if(Math.abs(a.x-b.x)<epsilon){
                infiniteSlope = true;
                intercept = a.x;
            } else {
                slope = (b.y-a.y) / (b.x-a.x);
                intercept = b.y - slope*b.x;
                infiniteSlope = false;
            }
        }

        double floorToNearestEpsilon(double x){
            int n = (int)(x/epsilon);
            return n*epsilon;
        }

        boolean equals(Line l){
            return Math.abs(slope-l.slope)<epsilon &&
                    Math.abs(intercept-l.intercept)<epsilon &&
                    infiniteSlope==l.infiniteSlope;
        }
    }

    Line findBestLine(Point[] points){
        HashMap<Double, List<Line>> linesBySlope = groupLinesBySlope(points);
        return findBestLine(linesBySlope);
    }

    private HashMap<Double, List<Line>> groupLinesBySlope(Point[] points){
        HashMap<Double, List<Line>> linesBySlope = new HashMap<>();
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                Line line = new Line(points[i], points[j]);
                double slope = line.floorToNearestEpsilon(line.slope);
                linesBySlope.putIfAbsent(slope, new ArrayList<>());
                linesBySlope.get(slope).add(line);
            }
        }
        return linesBySlope;
    }

    private Line findBestLine(HashMap<Double, List<Line>> linesBySlope){
        Line bestLine = null;
        int mostCount = 0;

        for(double slope: linesBySlope.keySet()){
            List<Line> lines = linesBySlope.get(slope);
            for(Line line: lines){
                int count = countEquivalentLines(line, linesBySlope);
                if(count>mostCount){
                    bestLine = line;
                    mostCount = count;
                }
            }
        }

        return bestLine;
    }

    private int countEquivalentLines(Line line, HashMap<Double, List<Line>> linesBySlope){
        double key = line.slope;
        int count = countEquivalentLines(line, linesBySlope.get(key));
        count += countEquivalentLines(line, linesBySlope.get(key-Line.epsilon));
        count += countEquivalentLines(line, linesBySlope.get(key+Line.epsilon));
        return count;
    }

    private int countEquivalentLines(Line line, List<Line> lines){
        int count = 0;
        for(Line l: lines){
            if(l.equals(line)) count++;
        }
        return count;
    }
}
