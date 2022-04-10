package array;

public class ArrayTest2 {
    public static void main(String[] args) {
        /**
         *  二维数组的声名和初始化
         *  调用二维数组的指定位置元素
         *  获取数组长度
         *  遍历数组
         *  数组元素默认初始化赋值
         *  数组的内存解析
         */

        //静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
        //静态初始化2 3
        int[] array4[]=new int[][]{{1,2,3},{4,5},{6,7,8}};
        int[] array5[]={{1,2,3},{4,5},{6,7,8}};

        //动态初始化1
        String[][] arr2 = new String[3][2];
        //动态初始化2
        String[][] arr3 = new String[3][];
        //类型推断
        int[] arry6 ={1,2,3,4,5,6};

        //调用数组指定位置的元素
        System.out.println(arr1[0][1]);
        System.out.println(arr2[1][1]);
        arr3[1] =new String[1];
        System.out.println(arr3[1][0]);

        //获取数组的长度
        System.out.println(array4.length);
        System.out.println(array4[1].length);

        //遍历二维数组
        for (int i=0;i<array4.length;i++) {
            for (int j = 0;j<array4[i].length;j++) {
                System.out.println(array4[i][j]);
            }
        }
/**      数组元素的初始化赋值
        二维数组分为外层数组的元素 内层数组的元素
        int [] arr = new int [4][3];
        外层元素 arr[0] 内层元素arr[0][1]
        初始化方式一：int [] arr = new int [4][3];
        外层元素的初始化值是 地址值
        内层元素的初始化值与一维初始化情况相同
        初始化方式一：int [] arr = new int [4][];
        外层元素的初始化值是 null
        内层元素的初始化 为无
        */

        float[][] arr = new float[1][3];
        System.out.println(arr[0][0]);
        System.out.println(arr[0]); //会输出地址值(hex)
        System.out.println(arr);//会输出地址值(HEX)

        exec3();

    }

    /**
     * 打印杨辉三角
     */
    private static void exec() {
        //1.声明二维数组
        int[][] arr = new int[10][];
        //给数组元素赋值
        for (int i=0;i< arr.length;i++) {
            arr[i] = new int[i+1];
            //
            arr[i][0]=arr[i][i]=1;
            //
                    for (int l=1;l<arr[i].length-1;l++) {
                        arr[i][l]= arr[i-1][l-1] + arr[i-1][l];
                    }
        }
        //3.遍历二维数组
        for (int i=0;i< arr.length;i++){
            for (int j =0; j<arr[i].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    /**
     * 元素不同数组
     */
    private void exec2() {
        int[] arr = new int[6];
        for (int i=0;i< arr.length;i++) {
            arr[i] = (int)(Math.random()*30)+1;
            for (int j=0; j<i;i++) {
                if (arr[i] ==arr[j]) {
                    i--;
                    break;
                }
            }
        }
       for (int i=0;i<arr.length;i++) {
           System.out.println(arr[i]);
       }
    }
    /**
     * 定义一个int型数组，包含十个元素，分别赋一些随机整数，然后求出所有元素的最大值
     * 最小值 总和 平均数 所有随机数要求是两位数
     */
    private static void exec3() {
        int[] arr =  new int[10];
        int max=0,min=100,sum=0;
        for (int i=0;i<arr.length;i++) {
            arr[i] = (int) (Math.random()*(99-10+1))+10;
            if (arr[i]>max) {
                max= arr[i];
            }
            if (min>arr[i]) {
                min = arr[i];
            }
            sum +=arr[i];
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);

        System.out.println(Double.valueOf(sum)/arr.length);
    }
}
