package string;

import org.junit.jupiter.api.Test;

public class StringExercise {
    /**
     * 将字符串中指定部分进行反转，比如“abdcefg”变为“abfedcg”
     */
    public String exercise1(String str,int index,int endIndex){
        char[] arr = str.toCharArray();
        for (int i = index,j=endIndex;i <j; i++,j--) {
            char temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return String.valueOf(arr);
    }
    @Test
    public void test11(){
        String str = "zxcvbnm";
        System.out.println(exercise1(str,1,4));
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * @return
     */
    public int exercise2(String searchWord,String str) {
        //数组
        char[] arr =str.toCharArray();
        //数组
        char[] search = searchWord.toCharArray();
        int num=0;
        int index =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search[index] ) {
                if (index==search.length-1){
                    index=0;
                    num++;
                }else{
                    index+=1;
                }
            }
        }
        return num;
    }
    @Test
    public void test2() {
        String str="acsodufacsadfacqwtg ";
        System.out.println(exercise2("acs",str));
    }
    /**
     * 获取两个字符串中最大相同字串
     *
     *
     */
    public String exercise3(String str1,String str2) {
        String maxStr = (str1.length()>=str2.length()?str1:str2);
        String minStr = (str1.length()<str2.length()?str1:str2);
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for(int x=0,y=length-i;y<=length;x++,y++) {
                String subStr = minStr.substring(x,y);
                if(maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }
    @Test
    public void test3() {

    }
}
