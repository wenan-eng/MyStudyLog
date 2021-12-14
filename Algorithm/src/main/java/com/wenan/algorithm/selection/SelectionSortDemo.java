package com.wenan.algorithm.selection;

/**
 * 描述：    SelectionSortDemo
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] numbers = {5,4,2,6,7,3,8,9};
        SelectionSort selectionSort = new SelectionSort(numbers);
        System.out.println("排序前：");
        selectionSort.sortList();
        selectionSort.sorted();
        System.out.println("排序后：");
        selectionSort.sortList();
    }
}

/**
 * 选择排序类
 */
class SelectionSort {
    private int[] list;

    SelectionSort(int[] list) {
        this.list = list;
    }

    public int[] sorted() {
        // 从第一个元素开始遍历直到倒数第二个元素
        for (int i = 0; i < list.length - 1; i++) {
            int min = i; // 假设实现最小值为第i个元素
            // 从第二个元素开始遍历，找到真正的最小值
            for (int k = i + 1; k < list.length; k++) {
                // 如果实际上的最小值不是假设的值，那么交换位置
                if (list[min] > list[k]) {
                    int tamp = list[k];
                    list[k] = list[min];
                    list[min] = tamp;
                }
            }
        }
        return list;
    }

    public void sortList() {
        for (int value : list) {
            System.out.println(value);
        }
    }
}
