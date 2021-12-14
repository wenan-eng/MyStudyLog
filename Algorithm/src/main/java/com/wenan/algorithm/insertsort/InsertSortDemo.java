package com.wenan.algorithm.insertsort;

/**
 * 描述：    InsertSortDemo
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        int[] numbers = {5,4,2,6,7,3,8,9};
        InsertSort insertSort = new InsertSort(numbers);
        System.out.println("排序之前:");
        insertSort.sortList();
        int[] sorted = insertSort.sorted();
        System.out.println("排序之后");
        insertSort.sortList();
    }
}

/**
 * 插入排序类
 */

class InsertSort {
    private int[] list;

    InsertSort(int[] list) {
        this.list = list;
    }

    public int[] sorted() {
        // 从第二个元素开始遍历
        for (int i = 1; i < list.length; i++) {
            // 记录要插入的元素
            int tamp = list[i];

            // 要插入的元素和前一个元素比较
            for (int m = i-1; m >= 0; m--) {
                // 如果右边的元素小于左边的元素，则两边交换位置
                if (list[m] > list[i]) {
                    list[i] = list [m];
                    list[m] = tamp;
                    i--;
                }
            }
        }
        return list;
    }

    public void sortList() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
