package com.fang.algorithm2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Laura on 2017/11/23.
 * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
 * 碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。
 * 现在给出两条碱基链，允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 * 输入描述:
 *  输入包括一行： 包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50。
 * 输出描述:
 *  输出一个整数，即最少需要多少次让两条碱基链配对成功
 * 示例1
 *  输入 ACGT TGCA    输出 0
 */
public class Dna {
    private static Map<Character,Character> map = new HashMap<>();
    static{
        map.put('A','T');
        map.put('T','A');
        map.put('C','G');
        map.put('G','C');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str1 = sc.next();
//        String str2 = sc.next();
        String str1 = "GAGCACTTGACGTTCCTAACCTGCCCTCGCCAATATTCT";
        String str2 = "CGCCCACCAATGATGGCTGCAATCCTTCATGCTTGTTTC";
        System.out.println(compound(str1,str2));

    }

    public static int compound(String str1, String str2){
        int result = 0;
        if( str1 == null || str2 == null
                || str1.length() != str2.length() || str1.length() > 50)
            throw new RuntimeException("error param");
        int len = str1.length();
        char c1, c2;
        for (int i = 0; i < len; i++) {
            c1 = str1.charAt(i);
            c2 = str2.charAt(i);
            if(map.get(c1) == null || map.get(c2) == null)
                throw new RuntimeException("error param");
            if( c1 == map.get(c2)) continue;
            else result++;
        }
        return result;
    }
}
