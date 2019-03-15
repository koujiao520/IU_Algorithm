package algorithm.design;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author tengjinbao
*
* 二分查找 只适用于顺序排列的数据结构
*
* 2018/4/17
*/
public class BinarySearch {
    /**
     * 判断key是否在数组a,并返回该值在数组中的位置 返回-1 则不存在
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    /**
     * 递归
     * 寻找可能存在的索引 mi
     * n最小索引 max最大索引
     */
    public static int rank(int key, int[] a, int min, int max) {
        if (min > max) return -1;
        int mid = min + (max - min) / 2;
        if (key < a[mid]) return rank(key, a, min, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, max);
        else return mid;
    }

    public static void main(String[] args) {
        while (true) {
            int[] a = {11, 70, 68, 2, 110, 200};
            //升序排列
            Arrays.sort(a);
            //获取控制输入的值
            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();
            System.out.println(rank(key, a));
        }

    }
}
