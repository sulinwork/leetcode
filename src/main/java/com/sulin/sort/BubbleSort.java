package com.sulin.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    //private static int count = 0;

    private static void bubbleSort(int[] nums) {
        boolean isChange = true;
        for (int i = 0; i < nums.length - 1 && isChange; i++) {
            isChange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    isChange = true;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        //System.out.println(count);
    }
}
