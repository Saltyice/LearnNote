package keyworld;

import java.util.Scanner;

public class WhileTest {
    //while 循环可以和 for 循环可以互相转换
    public static void main(String[] args) {
     int i=1;
     int sum =0;
     int count = 0;
//     while(i<=100) {
//         if (i%2==0) {
//             System.out.println(i);
//         }
//         i++;
//     }

        /**
         * do while
         */
//        do {
//             if (i % 2 == 0) {
//                 System.out.println(i);
//                 sum += i;
//                 System.out.println(sum);
//                 count++;
//                 System.out.println(count);
//             }
//             i++;
//        } while (i<=100);

        /**
         *
         */
        Scanner scan = new Scanner(System.in);
        int j=0,k=0;
        for (;;){
            int number = scan.nextInt();
            if (number == 0) {
                break;
            }
            if (number >0) {
                j++;
            } else {
                k++;
            }
        }
        System.out.println(k);
        System.out.println(j);
    }
}
