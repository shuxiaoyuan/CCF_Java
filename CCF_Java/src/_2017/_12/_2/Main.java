package _2017._12._2;

import java.util.Scanner;

// Person 结点
class Person {
    public int id;
    public Person next = null;
    
    public Person(int id) {
        this.id = id;
    }
    
}

// 游戏
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 建立 Person 的循环链表
        Person persons = new Person(1);
        Person firstp = persons;
        for(int i = 2; i <= n; i++) {
            persons.next = new Person(i);
            persons = persons.next;
        }
        persons.next = firstp;
        
        // 开始游戏
        int num = 1;
        Person pre = persons;
        Person winner = firstp;
        while(winner.next != winner) {
            if(num % k == 0 || num % 10 == k) {
                pre.next = winner.next;
            }
            else {
                pre = pre.next;
            }
            winner = winner.next;
            num++;
        }
        System.out.println(winner.id);
        sc.close();
    }
    
}
