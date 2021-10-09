package com.sulin.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 6, 7, 9, 0};
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l > r) return;
        int temp = arr[l];//基准
        int left = l;
        int right = r;//左右哨兵

        while (left < right) {
            //右边先走
            while (arr[right] >= temp && left < right) right--;
            while (arr[left] <= temp && left < right) left++;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, l, left);
        quickSort(arr, l, left - 1);
        quickSort(arr, right + 1, r);

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
