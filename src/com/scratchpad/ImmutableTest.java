package com.scratchpad;

/**
 * Created by dhanetwa on 9/16/2018.
 * 0. set values of instance variables through constructor
 * 1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * 2. Make all fields final and private.
 * 3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * If the instance fields include references to mutable objects, don't allow those objects to be changed:
 * Don't provide methods that modify the mutable objects.
 * Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 */
public class ImmutableTest {
    public static void main(String[] args) {
        Contrast contrast = new Contrast();
        contrast.setHue(78);
        CompleteImmutableClass completeImmutableClass = new CompleteImmutableClass(2, contrast);
        System.out.println("before modification " + completeImmutableClass.getContrast().getHue());
        contrast.setHue(82);
        System.out.println("after modification " + completeImmutableClass.getContrast().getHue());
        completeImmutableClass.getContrast().setHue(94);
        System.out.println("after 2nd modification " + completeImmutableClass.getContrast().getHue());
    }
}

final class CompleteImmutableClass {
    final private int colorNo;
    final private Contrast contrast;

    public CompleteImmutableClass(int colorNo, Contrast contrast) {
        this.colorNo = colorNo;
        Contrast cloneContrast = new Contrast();
        cloneContrast.setHue(contrast.getHue());
        this.contrast = cloneContrast;
    }

    public int getColor() {
        return colorNo;
    }

    public Contrast getContrast() {
        Contrast cloneContrast = new Contrast();
        cloneContrast.setHue(this.contrast.getHue());
        return cloneContrast;
    }
}
//Passing Mutable Objects to Immutable Class

class Contrast {
    private int hue;

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }
}