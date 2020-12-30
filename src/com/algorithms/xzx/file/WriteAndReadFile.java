package com.algorithms.xzx.file;

import java.io.*;
import java.util.Random;

/**
 * @outhor 智祥
 * @create 2018-08-21 22:37
 */
public class WriteAndReadFile {

    /**
     * 清空文件，重新随机生成数据
     */
    public static void cleanFile() {
        try {
            File file = new File("testFile.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 随机生成100个数据写入文件
     */
    public static void writeToFile() {
        try {
            File file = new File("testFile.txt");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                cleanFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 1; i <= 100; i++) {
                bw.write(new Random().nextInt(100) + " ");
                if (i % 10 == 0)
                    bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取数据，返回数组
     *
     * @return
     */
    public static int[] readFromFile() {

        try {
            StringBuffer sb = new StringBuffer("");
            FileReader input = new FileReader("testFIle.txt");
            BufferedReader reader = new BufferedReader(input);
            String line = null;
            while (null != (line = reader.readLine())) {
                sb.append(line);
            }
            //System.out.println(sb+"**");
            String[] strs = sb.toString().split(" ");
            int[] nums = new int[100];
            for (int i = 0; i < 100; i++) {
                nums[i] = Integer.valueOf(strs[i]);
            }
            reader.close();
            input.close();
            return nums;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void show(int[] nums) {
        for (int i = 0; i < 100; i++) {
            System.out.print(nums[i]);
            System.out.print('\t');
            if ((i + 1) % 10 == 0)
                System.out.println("");
        }
    }

    public static void main(String[] args) {
        writeToFile();
//        readFromFile();
    }
}
