package object;

public class GeometricTest {


    public static void main(String[] args) {

        GeometricTest oo = new GeometricTest();
        MyCircle c1 = new MyCircle("white",1,3);
        oo.displayGeometricObject(c1);
        MyCircle c2 = new MyCircle("black",2,4);
        oo.displayGeometricObject(c2);
        System.out.println(oo.equalsGeometricTest(c1,c2));

        MyRectangle t1  = new MyRectangle("blue",1,1,1);
        MyRectangle t2  = new MyRectangle("blue",2,2,2);
        oo.displayGeometricObject(t1);
        oo.displayGeometricObject(t2);
        System.out.println(oo.equalsGeometricTest(t1,t2));

    }

    public void displayGeometricObject(GeometricObject o1) {
        System.out.println(o1.findArea());
    }


    public boolean equalsGeometricTest(GeometricObject o1,GeometricObject o2) {
        return o1.findArea() ==o2.findArea();
    }
}


class GeometricObject{
    String color;
    double weight;


    public boolean equals(Object obj) {
        if (this ==obj) {
            return true;
        }
        if (obj instanceof GeometricObject) {
            GeometricObject geometricObject = (GeometricObject)obj;
            return geometricObject.color.equals(this.color) && geometricObject.weight ==this.weight;
        }
        return false;
    }

    public GeometricObject(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public  double findArea(){
        return 1;
    }

}

class MyCircle extends  GeometricObject{

    double radius;

    public MyCircle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI*radius*radius;
    }
}

class MyRectangle extends GeometricObject{
    double width;
    double height;

    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea() {
        return width*height;
    }
}