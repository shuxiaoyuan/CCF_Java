package _2017._12._1;

import java.util.Arrays;
import java.util.Scanner;

// 最小差值
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 10000;
        for(int i = 0; i < n-1; i++) {
            int diff = nums[i+1] - nums[i];
            if(diff < res) {
                res = diff;
            }
        }
        System.out.println(res);
    }

}
