package object;

import java.util.Scanner;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        Vector vector = new Vector<>();
        Integer max =0;
        System.out.println("输入数字");
        for(;;){
            Scanner scanner = new Scanner(System.in);
            int score =  scanner.nextInt();
            if (score<0)
                break;
            vector.addElement(score);
        }

        for(int i=0;i<vector.size();i++) {
            if ((Integer)vector.elementAt(i)>max){
                max = (Integer)vector.elementAt(i);
            }
        }

        for(int i=0;i<vector.size();i++) {
            if (max-(Integer)vector.elementAt(i)<10) {
                System.out.println(vector.elementAt(i).toString()+"A");
            } else if (max-(Integer)vector.elementAt(i)<20) {
                System.out.println(vector.elementAt(i).toString()+"B");
            } else if (max-(Integer)vector.elementAt(i)<30) {
                System.out.println(vector.elementAt(i).toString()+"C");
            } else {
                System.out.println(vector.elementAt(i).toString()+"D");
            }
        }

    }

}
