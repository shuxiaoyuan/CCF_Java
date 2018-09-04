package _2018._03._1;

import java.util.Scanner;

// 跳一跳
public class Main {

    public static void main(String[] args) {
        int sum = 0;            // 总分
        int centerTimes = 0;    // 跳到中心的次数  
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            if(num == 0) {
                System.out.println(sum);
                return;
            }
            else if(num == 1) {
                sum++;
                centerTimes = 0;
            }
            else if(num == 2) {
                centerTimes++;
                sum += centerTimes * 2;
            }
        }
    }
}
