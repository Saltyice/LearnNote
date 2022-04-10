package array;

public class ArrayExer {
    //随便加个注释
    //123再来随便来点
    ///1234567890
    public static void main(String[] args) {
        System.out.println("???");
        int [] arr = new int[]{2,3,5,7,11,13,17,19};
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        //不能称作数组的复制，两个数组变量指向同一个内存地址
        int[] arr1 = arr;


        for (int i=0; i<arr1.length;i++) {
            if (arr1[i] % 2 == 0) {
                arr1[i] = i;
            }
        }

        for (int i=0; i<arr.length;i++) {
            System.out.print(arr[i]+ "\t");
        }
        System.out.println();
        System.out.println(arr);
        System.out.println(arr1);

        /**
         * 拓展实现对数组 arr的复制
         */
        int [] arr2 = new int[arr.length];
        for (int i=0;i<arr2.length;i++) {
            arr2[i] = arr[i];
        }
        //不再指向相同的内存地址
        System.out.println(arr2);

        /**
         *  数组的反转操作 将数组元素反转
         *  将前半数组与后半数组进行交换
         */
        for (int i=0;i<arr2.length/2;i++) {
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length-i-1];
            arr2[arr2.length-i-1]= temp;
        }
        for (int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+"\t");
        }

        /**
         * 线性查找
         */
        int dest =19;
        boolean flag  = false;
        for (int i=0;i<arr2.length;i++) {
            if (dest == arr2[i]){
                System.out.println("找到了，下标是:"+i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("找不到");

        }

        exer1();
    }

    /**
     * 二分法查找:前提是查找的数组要有序
     * 先找到中位数，查找的数大于中位数的就往后半查找，小于就往前半查找
     */
    private static void exer1() {
        int[] arr =  new int[]{1,3,5,7,8,9,10,23,34,56,78,120,232,233,256,299,512};
        int dest = 78;
        //起始
        int start = 0;
        //结束
        int end = arr.length-1;
        boolean  flag =  false;
        while(end>start) {
            int middle  = (start+end)/2;
            if (dest == arr[middle]  ){
                flag = true;
                System.out.println("xiabiao:"+middle);
                break;
            } else if (arr[middle]>dest) {
                end = middle-1;
            } else if (arr[middle]<dest) {
                start = middle+1;
            }
        }
        if (!flag) {
            System.out.println("找不到");
        }
    }
}
