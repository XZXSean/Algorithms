package com.pipi.xzx.weeklygame1;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/18 20:43
 **/

public class BigOrSmallPIPI2 {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int n = inScanner.nextInt();
            Person[] persons = new Person[n];
            for (int i = 0; i < n; i++) {
                int weight = inScanner.nextInt();
                int direction = inScanner.nextInt();
                persons[i] = new Person(weight, direction);
            }
            getLeftPersion(persons);
        }
    }

    public static void getLeftPersion(Person[] persons) {
        int cnt = persons.length;
        int high = cnt - 1;
        while (high > 0 && persons[high].direction > 0) {  // 找到从右往左起第一个往左的位置
            high--;
        }
        for (int i = 0; i < high; i++) { // 从第一个开始，只需要判断往右走的
            Person currentPerson = persons[i];
            if (currentPerson.weight == 0) { // 体重为0说明已经被撞没了
                continue;
            }
            if (currentPerson.direction == 1) {
                for (int j = i + 1; j < persons.length; j++) { // 从下一个开始，只寻找与其相反方向的
                    Person tempPerson = persons[j];
                    if (tempPerson.weight != 0 && tempPerson.direction == 0) {
                        if (tempPerson.weight > currentPerson.weight) { // 体重小的被撞没
                            currentPerson.weight = 0;
                            cnt--;
                            break;
                        } else {
                            tempPerson.weight = 0;
                            cnt--;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static class Person {
        int weight;
        int direction; // 0 代表 右 -> 左

        public Person(int weight, int direction) {
            this.weight = weight;
            this.direction = direction;
        }
    }

}
