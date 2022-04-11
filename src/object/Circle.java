package object;

public class Circle  {
    double radius;


    public double findArea(){
        return Math.PI*radius*radius;
    }

    public static void main(String[] args) {
        PassObject object = new PassObject();
        Circle circle = new Circle();
        object.PrintAreas(circle,10);
        System.out.println("radius is" +circle.radius);
    }
}


class PassObject{
    public void PrintAreas(Circle c, int time){
         for (double i=1;i<=time;i++){
             c.radius = i;
             System.out.println(i+"\t\t"+ c.findArea());
         }
    }
}