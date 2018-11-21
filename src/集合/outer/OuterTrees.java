package 集合.outer;


import java.util.*;

/**
 * @author wilder
 * @date 18-11-21 下午7:09
 * description leetcode 587
 */
public class OuterTrees {
    static List<Point> result = new LinkedList<>();

    public List<Point> solution(Point[] points){
        List<Point> pointList = new LinkedList<>();
        for (Point point : points) {
            pointList.add(point);
        }
        int n = points.length;

        //按照横坐标排序，横坐标相同按照纵坐标排序
        Collections.sort(pointList, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                 if (point.x == t1.x){
                    return point.y - t1.y;
                }
                return point.x - t1.x;
            }
        });
        d(pointList.get(0), pointList.get(n-1), pointList);
        return result;
    }

    private void d(Point p1, Point p2, List<Point> s){
        if (s.isEmpty()){
            result.add(p1);
            result.add(p2);
            return;
        }
        //s集合不为空，寻找Pmax
        double area = 0;
        double maxArea = 0;
        int index = 0;
        Point pMax = null;
        for (int i =1;i<s.size()-1;i++){
            area = direction(p1, p2, s.get(i));
            if (area >= maxArea){
                pMax = s.get(i);
                maxArea = area;
                index = i;
            }
        }
        //继续分治法分出p1-pMax, pMax-p2
        List<Point> left = new LinkedList<>();
        List<Point> right = new LinkedList<>();
        Point p3 = null;
        for (int i =1 ;i<s.size()-1;i++){
            p3 = s.get(i);
            if (direction(p1, pMax, p3) > 0){
                //这个点属于左边
                left.add(p3);
            }else if (direction(pMax, p2, p3) >= 0){
                //这个点属于右边
                right.add(p3);
            }
        }
        d(p1, pMax, left);
        d(pMax, p2, right);
    }

    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(1, 2);
        points[1] = new Point(2, 2);
        points[2] = new Point(4, 2);
//        points[3] = new Point(2, 4);
//        points[4] = new Point(3, 3);
//        points[5] = new Point(4, 2);

        for (Point point : new OuterTrees().solution(points)) {
            System.out.println(point);
        }
    }
//    public List<Point> solution(Point[] points) {
//        List<Point> pointList = new LinkedList<>();
//        List<Point> result = new LinkedList<>();
//        for (Point point : points) {
//            pointList.add(point);
//        }
//        int n = points.length;
//
//        //按照横坐标排序，横坐标相同按照纵坐标排序
//        Collections.sort(pointList, new Comparator<Point>() {
//            @Override
//            public int compare(Point point, Point t1) {
//                 if (point.x == t1.x){
//                    return point.y - t1.y;
//                }
//                return point.x - t1.x;
//            }
//        });
//
//        //取收尾两个点，肯定是集合的凸包顶点
//        Point firstPoint = pointList.get(0);
//        Point lastPoint = pointList.get(n-1);
//        result.add(firstPoint);
//        result.add(lastPoint);
//
//        Point nextPoint = pointList.get(0);
//        float maxValue = 0;
//        //构造上包，找和边缘点构成面积最大的点
//        for (int i = 1; i < pointList.size()-1; i++) {
//            float value = direction(firstPoint, lastPoint, pointList.get(i));
//            if (value >= maxValue){
//                maxValue = value;
//                nextPoint = pointList.get(i);
//            }
//        }
//        result.add(nextPoint);
//        //移除非闭包的点
//        for (int i = 1; i< pointList.size() - 1;i++){
//            if (direction(firstPoint, nextPoint, pointList.get(i)) > 0 || direction(nextPoint, lastPoint, pointList.get(i)) > 0){
//                result.add(pointList.get(i));
//            }
//        }
//
//    }

    public static double direction(Point point1, Point point2, Point point3) {
        return point1.x * point2.y + point3.x * point1.y + point2.x * point3.y -
                point3.x * point2.y - point2.x * point1.y - point1.x * point3.y;
    }


}
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}