package com.example.demo.algorithm;

/**
 * 最大公约数算法 greatest common divisor
 * @author yangkaile
 * @date 2019-06-14 10:36:04
 */
public class GCDTest {
    /**
     * 更相减损术、位移相结合
     * 理论：
     *  当a和b均为偶数，gcb(a,b) = 2*gcb(a/2,b/2) = 2*gcb(a>>1,b>>1)
     *  当a为偶数，b为奇数，gcb(a,b) = gcb(a/2,b) = gcb(a>>1,b)
     *  当a为奇数，b为偶数，gcb(a,b) = gcb(a,b/2) = gcb(a,b>>1)
     *  当a和b均为奇数，利用更相减损术运行一次，gcb(a,b) = gcb(b,a-b)，
     *      此时a-b必然是偶数，又可以继续进行位移运算
     * @param a
     * @param b
     * @return
     */
    public static int gcd4(int a ,int b){
        if(a == b){
            return a;
        }else if(a < b){
            return gcd4(b,a);
        }else {
            if((a&1) == 0 && (b&1) == 0){
                //a和b均为偶数
                return gcd4(a>>1,b>>1) << 1;
            }else if((a&1)==0 && (b&1) ==1){
                //a是偶数,b是技术
                return gcd4(a>>1,b);
            }else if((b&1) == 0 && (a&1) == 1){
                //a是奇数，b是偶数
                return gcd4(a,b>>1);
            }else {
                //a和b均为奇数
                return gcd4(b,a-b);
            }
        }
    }


    /**
     * 更相减损术，出自《九章算术》
     * 原理：两个正整数a和b（a>b)，
     * 它们的最大公约数等于a-b的差值c和较小数b的最大公约数
     * 问题：是一种不稳定的算法，当两数相差悬殊时，时间复杂度接近于O(max(a,b))
     * @param a
     * @param b
     * @return
     */
    public static int gcd3(int a, int b){
        if(a > b){
            return gcd3(a - b , b);
        }else if(a < b){
            return gcd3(b - a, a);
        }else {
            return a;
        }
    }


    /**
     * 辗转相除法，又名欧几里得算法（Euclidean algorithm）
     * 基于定理：两个正整数a和b(a>b),
     * 它们的最大公约数等于a除以b的余数c和b之间的最大公约数
     * 问题：当两个整数较大时，做取模运算的性能会比较低
     * @param a
     * @param b
     * @return
     */
    public static int gcd2(int a, int b){
        if(a > b){
            int remainder = a % b;
            if(remainder == 0){
                return b;
            }else {
                return gcd2(b, remainder);
            }
        }else if(a < b){
            return gcd2(b,a);
        }else {
            return a;
        }
    }


    /**
     * 暴力枚举法 时间复杂度O(min(a,b))
     * 思路：通过循环，暴力尝试每个可能的数字
     * 问题：效率低
     * @param a
     * @param b
     * @return
     */
    public static int gcd1(int a,int b){
        int small = a < b ? a : b;
        int big = a >= b ? a : b;
        if(big % small == 0){
            return small;
        }
        int gcd = 1;
        for(int i = 2 ; i < small / 2 ; i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args){
        int a = 45;
        int b = 54;
        System.out.println(gcd1(a,b));
        System.out.println(gcd2(a,b));
        System.out.println(gcd3(a,b));
        System.out.println(gcd4(a,b));

    }
}
