package com.example.demo.algorithm;

/**
 * 一些常用的其他算法
 */
public class Others {

    /**
     * 判断一个数是不是2的乘方
     *
     * @param number
     * @return
     */
    public static boolean isPowerOf2(Integer number){
        return (number & number - 1) == 0;
    }

    /**
     * 求出一个正整数转换成二进制后的数字"1"的个数
     * 可以使用右移位、左移位、与运算等方法，本例使用了右移位判断
     * @param number
     * @return
     */
    public static int chargeOnesCountInNum1(int number){
        int count = 0 ;
        while (number != 0){
            if((number & 1) == 1){
                count ++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(isPowerOf2(11));
        System.out.println(chargeOnesCountInNum1(13));
        System.out.println(chargeOnesCountInNum1(15));

    }
}
