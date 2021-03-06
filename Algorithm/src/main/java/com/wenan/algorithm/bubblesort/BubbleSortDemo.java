package com.wenan.algorithm.bubblesort;

import javax.xml.transform.Source;
import java.util.List;

/**
 * 描述：    BubbleSortDemo
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 3, 2, 7, 9};
        BubbleSort.out(numbers);
        System.out.println("----排序后------");
        int[] sort = BubbleSort.sort(numbers);
        BubbleSort.out(sort);
    }
}

/**
 * 冒泡排序算法
 */
class BubbleSort {

    public static int[] sort(int[] numbers) {
        // 遍历数组的所有元素，每一个元素都要和他相邻的元素进行比较
        for (int i = 0; i < numbers.length-1; i++) {
            // 从第一个元素开始往后比较
            for (int m = i; m < numbers.length-1; m++) {
                if (numbers[m] > numbers[m + 1]) {
                    int stable = numbers[m];
                    numbers[m] = numbers[m + 1];
                    numbers[m + 1] = stable;
                }
            }
        }
        return numbers;
    }

    public static void out(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
