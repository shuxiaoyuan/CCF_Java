package _2018._03._2;

import java.util.Scanner;

// 球类
class Ball {
    public int pos;        // 位置
    public int direction;  // 方向
}

// 碰撞的小球
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lineOne = sc.nextLine().split(" ");
        String[] lineTwo = sc.nextLine().split(" ");
        int n = Integer.parseInt(lineOne[0]);   // 小球个数
        int L = Integer.parseInt(lineOne[1]);   // 线段长度
        int t = Integer.parseInt(lineOne[2]);   // 运动秒数
        // 每个位置球的数量
        int[] ball_nums = new int[L+1];
        for(int i = 0; i < L+1; i++) {
            ball_nums[i] = 0;
        }
        // 创建并初始化球的数组
        Ball[] balls = new Ball[n];
        for(int i = 0; i < n; i++) {
            balls[i] = new Ball();
            balls[i].pos = Integer.parseInt(lineTwo[i]);
            ball_nums[balls[i].pos] = 1;    // 直接赋值为 1 就行，不用写成 ++
            if(balls[i].pos == L) {
                balls[i].direction = -1;
            }
            else {
                balls[i].direction = 1;
            }
        }
        
        // 运动 t s 后各球的位置
        for(int i = 0; i < t; i++) {
            // 运动只改变位置
            for(int j = 0; j < n; j++) {
                ball_nums[balls[j].pos]--;          // 当前位置球的数量减一
                balls[j].pos += balls[j].direction; // 球运动，改变位置
                ball_nums[balls[j].pos]++;          // 运动后的位置球的数量加一
            }
            // 检查只改变方向
            for(int j = 0; j < n; j++) {
                if(balls[j].pos == L && balls[j].direction == 1) {
                    balls[j].direction = -1;
                }
                else if(balls[j].pos == 0 && balls[j].direction == -1) {
                    balls[j].direction = 1;
                }
                else if(ball_nums[balls[j].pos] == 2) {
                    balls[j].direction *= -1;
                }
            }
        }
        
        // 打印结果
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                System.out.print(" ");
            }
            System.out.print(balls[i].pos);
        }
        System.out.println();
        sc.close();
    }

}
