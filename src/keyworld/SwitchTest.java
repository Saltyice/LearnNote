package keyworld;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args){
 //       int number =1;
        //执行完符合语句后还会继续向下执行下去
        //switch中表达式只能是如下几种类型  byte short char int 枚举enum String
/*
        switch (number) {
            case 3:
                System.out.println(123);
                break;
            default:
        }
        String a="stri";
        switch (a) {
            case "":
            case "1":
            case "12":
        }
*/
/*        int score = 78;
        switch (score/10) {
            case 0:
            case 1:
            case 2:
            case 3:
        }*/
//        从键盘输入 年月日 并判断今天是今年的第几天
        Scanner scan = new Scanner(System.in);
        int mouth = scan.nextInt();
        int day = scan.nextInt();
        int year = scan.nextInt();
        int sumDay =0;

        switch (mouth) {
            case 12: sumDay +=31;
            case 11: sumDay +=31;
            case 10: sumDay +=31;
            case 9: sumDay +=31;
            case 8: sumDay +=31;
            case 7: sumDay +=31;
            case 6: sumDay +=31;
            case 5: sumDay +=31;
            case 4: sumDay +=31;
            case 3: sumDay +=31;
                if((year %4 ==0 && year %100!=0)||year %400==0 ){
                    sumDay+=29;
                }else{
                    sumDay+=28;
                }
            case 2:
                sumDay +=31;
            case 1:
                sumDay +=day;
        }
    }
}
