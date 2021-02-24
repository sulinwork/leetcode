package com.sulin.sort;


import java.util.Arrays;

/**
 * 插入排序 将数组分为两个区域【已排区域，未排区域】 每次从未排区域选择一个插入到已排区域
 * 与冒泡排序对比：
 * 在冒泡排序中，经过每一轮的排序处理后，数组后端的数是排好序的。
 * 在插入排序中，经过每一轮的排序处理后，数组前端的数是排好序的。
 */
public class InsertSort {

    private static void insertionSort(int[] nums) {
        for (int i = 1, j; i < nums.length; i++) {
            //提取出一个未排
            int temp = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];//后移一位
            }
            //得出合适位置插入
            nums[j] = temp;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
