package graph;

import java.io.*;
import java.util.*;

class Point{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class grahamScan{
    public static void print(ArrayList<Point> list){
        for(Point p: list){
            System.out.println("("+ p.x + ", " + p.y+")");
        }
    }

    public static void swap(ArrayList<Point> list, int first, int second){
        Point temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public static int dist_sq(Point a, Point b){
        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
    }

    public static int orientation(Point a, Point b, Point c){
        int x1 = a.x, x2 = b.x, x3 = c.x,
                y1 = a.y, y2 = b.y, y3 = c.y;

        int val = (y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1);
        if(val == 0){
            return 0;
        }
        return (val > 0)? 1: 2;
    }

    public static int compare(Point p0, Point a, Point b){
        int val = orientation(p0, a, b);
        if(val == 0){
            return (dist_sq(p0, b) >= dist_sq(p0, a))? -1: 1;
        }
        return (val == 2)? -1: 1;
    }

    public static void polarBubbleSort(ArrayList<Point> list){
        for(int i = 1; i < list.size(); i++){
            for(int j = 1; j < list.size() - 1; j++){
                int val = compare(list.get(0), list.get(j), list.get(j + 1));
                if(val == 1){
                    swap(list, j, j + 1);
                }
            }
        }
    }
    public static Point nextToTop(Stack<Point> list){
        Point p = list.peek();
        list.pop();
        Point res = list.peek();
        list.push(p);
        return res;
    }

    public static void convexHull(ArrayList<Point> list){

        Point lowest = list.get(0);
        int lowest_index = 0;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).y < lowest.y ||
                    list.get(i).y == lowest.y && list.get(i).x < list.get(lowest_index).x){
                lowest_index = i;
                lowest = list.get(i);
            }
        }
        swap(list, 0, lowest_index);
        polarBubbleSort(list);

        int valid_points = 1;
        for(int i = 1; i < list.size(); i++){
            while(i < list.size() - 1 &&
                    orientation(list.get(0), list.get(i), list.get(i+1)) == 0){//remove the same angel points
                i++;
            }
            list.set(valid_points, list.get(i));
            valid_points++;
        }
        if(valid_points < 3)
            return;

        Stack<Point> s = new Stack<>();
        s.push(list.get(0));
        s.push(list.get(1));
        s.push(list.get(2));

        for(int i = 3; i < valid_points; i++){
            while(s.size() > 1 &&
                    orientation(nextToTop(s), s.peek(), list.get(i)) != 2){
                s.pop();
            }
            s.push(list.get(i));
        }
        while(!s.empty()){
            Point p = s.peek();
            System.out.println("("+p.x+ ", "+p.y+")");
            s.pop();
        }
        return;
    }

    public static void main(String[] args){
        int[][] points = {{0, 3}, {1, 1}, {2, 2}, {4, 4},
                {0, 0}, {1, 2}, {3, 1}, {3, 3}};

        ArrayList<Point> list = new ArrayList<>();

        for(int i = 0; i < points.length; i++){
            list.add(new Point(points[i][0], points[i][1]));
        }

        convexHull(list);
    }
}