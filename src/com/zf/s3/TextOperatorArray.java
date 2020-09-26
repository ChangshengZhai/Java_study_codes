/*
一维数组复制、插入和合并
 */
package com.zf.s3;
import java.util.Arrays;
import java.util.Scanner;
public class TextOperatorArray {
    public static void copy(){
        int[] a = {1,2,3,4};
        int[] temp1 = Arrays.copyOf(a,a.length);        //深层拷贝
        int[] temp2 = Arrays.copyOf(a,2 * a.length);        //多余的元素在int型数组下被填充为0
        int[] temp3 = a;        //浅层拷贝，两变量temp3和a将引用相同的数组
        // 使用for each打印输出数组
        System.out.println("原始数组a：");
        for (int element : a)
            System.out.print(element+"  ");
        System.out.println("\n复制后的长度相同的数组temp1：");
        for (int element : temp1)
            System.out.print(element+"  ");
        System.out.println("\n复制后的长度不同的数组temp2：");
        for (int element : temp2)
            System.out.print(element+"  ");
        System.out.println("\n浅层拷贝数组temp3（原始数组a修改a[0]=0）:");
        a[0] = 0;
        for (int element : temp3)
            System.out.print(element+"  ");
        System.out.println("\n输出修改后的数组a：");
        for (int element : a)
            System.out.print(element+"  ");
    }


    public static void main(String []args){
        copy();
    }
}
