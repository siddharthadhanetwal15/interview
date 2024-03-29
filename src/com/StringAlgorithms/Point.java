package com.StringAlgorithms;

/**
 * Created by dhanetwa on 9/2/2018.
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point l1 = new Point(0, 10);
        Point r1 = new Point(10, 0);
        Point l2 = new Point(15, 15);
        Point r2 = new Point(25, 5);
        Rectangle first = new Rectangle(l1, r1);
        Rectangle second = new Rectangle(l2, r2);
        if (first.isOverLapping(second)) {
            System.out.println("Yes, two rectangles are intersecting with each other");
        } else {
            System.out.println("No, two rectangles are not overlapping with each other");
        }
    }

}

class Rectangle {
    private final Point topLeft;
    private final Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    /**
     * Java method to check if two rectangle are intersecting to each other. * * @param other * @return true if two rectangle overlap with each other
     */
    public boolean isOverLapping(Rectangle other) {
        if (this.topLeft.x > other.bottomRight.x // R1 is right to R2
                || this.bottomRight.x < other.topLeft.x // R1 is left to R2
                || this.topLeft.y < other.bottomRight.y // R1 is above R2
                || this.bottomRight.y > other.topLeft.y)// R1 is below R2
        {
            return false;
        }
        return true;
    }
}

