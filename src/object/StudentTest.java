package object;

public class StudentTest {
    public static void main(String[] args) {
       Student[] arr = new Student[20];
       for (int i=0;i<arr.length;i++){
           arr[i] = new Student();
           arr[i].number=i+1;
           arr[i].state = (int)(Math.random()*(6-1+1)+1);
           arr[i].score = (int)(Math.random()*(100-0+1)+1);
       }
       //遍历学生数组
//        for(int i=0;i< arr.length;i++){
//            System.out.println(arr[i].info());
//        }
        //打印三年级的学生
//        for(int i=0;i<arr.length;i++){
//            if (arr[i].state ==3) {
//                System.out.println(arr[i].info());
//            }
//        }
        //冒泡排序学生成绩
        for(int i=0;i<arr.length-1;i++) {
            for (int j=0;j<arr.length-i-1;j++) {
                if (arr[j].score>arr[j+1].score){
                    Student temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i=0;i<arr.length-1;i++) {
            System.out.println(arr[i].info());
        }


    }
}

class Student{
    int number;
    int state;
    int score;

    public String info(){
        return state+" "+number+" "+score;
    }
}