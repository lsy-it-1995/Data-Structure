#include <iostream>
#include <stdlib.h>
#include <stack>
#include <cmath>

using namespace std;

struct Point{
    int x, y;
};

Point p0;

void printOnlyPoint(Point *p){
    cout<<"("<<p->x<<", "<<p->y<<")"<<endl;
}

Point nextToTop(stack<Point>& s){
    Point top = s.top();
    s.pop();
    Point second_top = s.top();
    s.push(top);
    return second_top;
}

int distance_sqaure(Point a, Point b){
    return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
}


//https://www.geeksforgeeks.org/orientation-3-ordered-points/
// 0 --> p, q and r are colinear 
// 1 --> Clockwise 
// 2 --> Counterclockwise

int orientation(Point a, Point b, Point c){
    int x1 = a.x, x2 = b.x, x3 = c.x,
        y1 = a.y, y2 = b.y, y3 = c.y;
    int value = (y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1);
    return (value == 0)? 0: ((value > 0)? 1: 2); //if 0, return 0; if > 0, return 1; else 2
}


// A function used by library function qsort() to sort an array of 
// points with respect to the first point 
int compare(const void* v1, const void* v2){
    Point *p1 = (Point*) v1, 
          *p2 = (Point*) v2;   
    int val = orientation(p0, *p1, *p2); 
    /*
    if  val = 0, colinear
        val = 1, clockwise
        val = 2, counterclockwise  this is what we need
    */

    /*
    return value on qsort according compare function
    <0	The element pointed to by p1 goes before the element pointed to by p2
    =0	The element pointed to by p1 is equivalent to the element pointed to by p2
    >0	The element pointed to by p1 goes after the element pointed to by p2

    */
    if(val == 0){
        return (distance_sqaure(p0, *p2) >= distance_sqaure(p0, *p1))? -1: 1;
    }
    return (val == 2)? -1: 1;
}

void swap(Point& a, Point& b){
    Point temp = a;
    a = b;
    b = temp;
}

void print_point(Point point[], int n){
    for(int i = 0; i < n; i++){
        cout<<"("<<point[i].x<<", "<<point[i].y<<")"<<endl;
    }
}

void convexHull(Point point[], int n){

    //find the lowest point on through the array
    Point lowest = point[0]; //assume the first element is the lowest
    int min = 0; //index
    for(int i = 1; i < n; i++){
        if(point[i].y < lowest.y || (point[i].y == lowest.y && point[i].x < lowest.x)){
            lowest = point[i];
            min = i;
        }
    }
    //put the lowest point on the first element of array
    swap(point[0], point[min]);
    p0 = point[0];
    qsort(&point[1], n - 1, sizeof(Point),  compare);
    int valid_points = 1;
   
    for(int i = 1; i < n; i++){
        while(i < n - 1 &&
              orientation(p0, point[i], point[i + 1]) == 0){//remove the same angel points
            
            i++;
        }
        
        //record the valid points
        point[valid_points] = point[i];
        valid_points++;
    }
    if(valid_points < 3) return; //its not going to be a convex hull

    
    stack<Point> convex_points;
    convex_points.push(point[0]);
    convex_points.push(point[1]);
    convex_points.push(point[2]);

    for(int i = 3; i < valid_points; i++){
        while(convex_points.size() > 1 && 
              orientation(nextToTop(convex_points), convex_points.top(), point[i]) != 2){
                  convex_points.pop();
              }
        convex_points.push(point[i]);
    }
    //print stack
    while(!convex_points.empty()){
        Point p = convex_points.top();
        cout<<"("<<p.x<<", "<<p.y<<")"<<endl;
        convex_points.pop();
    }
}

int main()
{
    
    Point point[] = {
        {0,3}, {1,1}, {2,2}, {4,4}, {0,0}, {1,2}, {3,1}, {3,3}
    };
    int n = sizeof(point)/sizeof(point[0]);//array size! 64/8
    convexHull(point,n);
    return 0;
}

 