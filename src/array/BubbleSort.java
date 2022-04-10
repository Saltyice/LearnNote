package array;

public class BubbleSort {
    /**
     * 数组冒泡排序的实现
     * @param args
     */
    public static void main(String[] args) {
        //需要排序的数组
        int[]  arr = new int[]{1,6,2,90,888,123,321,16,99,443,5,56,89};
        //第一层循环是用来将冒泡执行多次即可实现将元素按从小到大跑列
        for (int i=0;i<arr.length-1;i++) {
            //第二层循环是将相邻的两位数进行比较数值较大的往后移动一位，执行结果会将最大的数移到数组最后
            for (int j=0;j<arr.length-1-i;j++) {
                //将数组中较大的数往后挪
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

}
