package com.fang.algorithm2;

import java.util.Scanner;

/**
 * 牛牛有两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。
 * 输入描述:
 * 输入为两行字符串（可能包含空格），长度均小于等于50.
 * 输出描述:
 * 输出为一个整数，表示最长公共连续子串的长度。
 * 示例1
 * 输入 abcde abgde
 * 输出 2
 * Created by Laura on 2017/11/24.
 */
public class MaxSubStr {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      String str1 = sc.nextLine();
      String str2 = sc.nextLine();
      System.out.println(longestCommonSubstring_n2_1(str1,str2));
  }
  
  public static int check(String str1, String str2) {
    if (str1 == null || str2 == null)
      return 0;
    int len1 = str1.length();
    int len2 = str2.length();
    if (str1.length() <= 0 || str2.length() <= 0)
      return 0;
    
    // the start position of substring in original string
    int start1 = -1, start2 = -1;
    // the longest length of common substring
    int longest = 0;
    int comparisons = 0;
    
    for (int i = 0; i < len1; ++i) {
      for (int j = 0; j < len2; ++j) {
        int length = 0;
        int m = i, n = j;
        while (m < len1 && n < len2) {
          ++comparisons;
          if (str1.charAt(m) != str2.charAt(n))
            break;
          ++length;
          ++m;
          ++n;
        }
        
        if (longest < length) {
          longest = length;
          start1 = i;
          start2 = j;
        }
      }
    }
    
    return longest;
  }
  
  
  /**
   * 暴力解法 – 所得即所求
   * 考虑每个子串的开始位置就可以，这样可以把复杂度减到O(n3)。
   * @param str1
   * @param str2
   * @return
   */
  public static int longestCommonSubstring_n3(String str1, String str2){  
      char[] charArray1 = str1.toCharArray();
      char[] charArray2 = str2.toCharArray();
      int size1 = charArray1.length;
      int size2 = charArray2.length;
      if (size1 == 0 || size2 == 0) 
        return 0;        
      int start1 = -1, start2 = -1;  // 开始位置    
      int longest = 0;  // 公共子串的最长长度
      int comparisons = 0; //记录 解决方法 进行了对少次对比
   
      for (int i = 0; i < size1; ++i) {
          for (int j = 0; j < size2; ++j) {
              int length = 0; 
              for (int m = i, n = j ; m < size1 && n < size2;  ++m, ++n ) {
                ++comparisons;
                if (charArray1[m] != charArray2[n]) 
                  break;
                ++length;
              }
              if (longest < length){
                  longest = length;
                  start1 = i;
                  start2 = j;
              }
          }
      }
      System.out.println("comparisons= " + comparisons);
      return longest;
  }


    /**
     * 动态规划法 – 空间换时间 运算的时间复杂度也就降至了O(n2)。
     * 假设两个字符串分别为s和t，s[i]和t[j]分别表示其第i和第j个字符(字符顺序从0开始)，再令L[i, j]表示以s[i]和s[j]为结尾的相同子串的最大长度。
     * 应该不难递推出L[i, j]和L[i+1,j+1]之间的关系，因为两者其实只差s[i+1]和t[j+1]这一对字符。
     * 若s[i+1]和t[j+1]不同，那么L[i+1, j+1]自然应该是0，因为任何以它们为结尾的子串都不可能完全相同；
     * 而如果s[i+1]和t[j+1]相同，那么就只要在以s[i]和t[j]结尾的最长相同子串之后分别添上这两个字符即可，这样就可以让长度增加一位。
     * 合并上述两种情况，也就得到L[i+1,j+1]=(s[i]==t[j]?L[i,j]+1:0)这样的关系。
     *
     * 最后就是要小心的就是临界位置：如若两个字符串中任何一个是空串，那么最长公共子串的长度只能是0；
     * 当i为0时，L[0,j]应该是等于L[-1,j-1]再加上s[0]和t[j]提供的值，但L[-1,j-1]本是无效，但可以视s[-1]是空字符也就变成了前面一种临界情况，
     * 这样就可知L[-1,j-1]==0，所以L[0,j]=(s[0]==t[j]?1:0)。对于j为0也是一样的，同样可得L[i,0]=(s[i]==t[0]?1:0)。
     * @param str1
     * @param str2
     * @return
     */
    public static int longestCommonSubstring_n2_n2(String str1, String str2){
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int size1 = charArray1.length;
        int size2 = charArray2.length;
        if (size1 == 0 || size2 == 0)
            return 0;

        int[][] table = new int[size1][size2];
        int longest = 0;
        int comparisons = 0;

        for (int j = 0; j < size2; ++j){
            ++comparisons;
            table[0][j] = (charArray1[0] == charArray2[j] ? 1 :0);
        }

        for (int i = 1; i < size1; ++i){
            ++comparisons;
            table[i][0] = (charArray1[i] == charArray2[0] ? 1 :0);

            for (int j = 1; j < size2; ++j){
                ++comparisons;
                if (charArray1[i] == charArray2[j]){
                    table[i][j] = table[i-1][j-1] + 1;
                }
            }
        }

        for (int i = 0; i < size1; ++i){
            for (int j = 0; j < size2; ++j){
                if (longest < table[i][j]) {
                    longest = table[i][j];
                }
            }
        }
        System.out.println("comparisons= " + comparisons);
        return longest;
    }

    /**
     * 动态规划法优化 – 能省一点是一点
     * 仔细回顾之前的代码，其实可以做一些合并让代码变得更加简洁，
     * 比如最后一个求最长的嵌套for循环其实可以合并到之前计算整个表的for循环之中，每计算完L[i,j]就检查它是的值是不是更长。
     * 当合并代码之后，就会发现内部循环的过程重其实只用到了整个表的相邻两行而已，对于其它已经计算好的行之后就再也不会用到，
     * 而未计算的行首之前也不会用到，因此考虑只用两行来存储计算值可能就足够。
     * @param str1
     * @param str2
     * @return
     */
    public static int longestCommonSubstring_n2_2n(String str1, String str2){
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int size1 = charArray1.length;
        int size2 = charArray2.length;
        if (size1 == 0 || size2 == 0)
            return 0;

        int[][] table = new int[2][size2];
        int longest = 0;
        int comparisons = 0;

        for (int j = 0; j < size2; ++j){
            ++comparisons;
            if (charArray1[0] == charArray2[j]) { //字符串1 的第一个字符和字符串2的每一个字符串的比较结果
                table[0][j] = 1;
                if (longest == 0)
                    longest = 1;
            }
        }

        for (int i = 1; i < size1; ++i){
            ++comparisons;
            // with odd/even to swith working row
            int cur = ((i&1) == 1) ? 1 : 0; //奇数行 index for current working row
            int pre = ((i&1) == 0) ? 1 : 0; //index for previous working row
            table[cur][0] = 0;
            if (charArray1[i] == charArray2[0]) { //字符串2 的第一个字符和字符串1的每一个字符串的比较结果
                table[cur][0] = 1;
                if (longest == 0) {
                    longest = 1;
                }
            }

            for (int j = 1; j < size2; ++j) {
                ++comparisons;
                if (charArray1[i] == charArray2[j]) {
                    table[cur][j] = table[pre][j-1]+1;
                    if (longest < table[cur][j]) {
                        longest = table[cur][j];
                    }
                }
                else
                {
                    table[cur][j] = 0;
                }
            }
        }
        System.out.println("comparisons= " + comparisons);
        return longest;

    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
     public static int longestCommonSubstring_n2_1(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int size1 = charArray1.length;
        int size2 = charArray2.length;
        int start1 = -1;
        if (size1 == 0 || size2 == 0)  return 0;
        int longest = 0;
        int comparisons = 0;
        for (int i = 0; i < size1; ++i) {
            int length = 0;
            for (int m = i, n = 0;m < size1 && n < size2; m++, n++) {
                ++comparisons;
                if (charArray1[m] != charArray2[n]) length = 0;
                else {
                    ++length;
                    if (longest < length)  longest = length;
                }
            }
        }
        for (int j = 1; j < size2; ++j) {
            int length = 0;
            for (int m = 0, n = j;m < size1 && n < size2; m++, n++) {
                ++comparisons;
                if (charArray1[m] != charArray2[n]) length = 0;
                else {
                    ++length;
                    if (longest < length){
                        longest = length;
                        start1 = m-longest+1;
                    }
                }
            }
        }
        System.out.println("comparisons= " + comparisons);
        return longest;
    }

    public  static int longestCommonSubString_n1_1(String str1, String str2){
        char[] charArray1 = str1.toCharArray(); //字符串转换为数组
        char[] charArray2 = str2.toCharArray(); //字符串转换为数组
        int size1 = charArray1.length;
        int size2 = charArray2.length;
        if (size1 == 0 || size2 == 0) return 0;
        int longest = 0;
        int comparisons = 0;

        int sizes[] = {size1, size2};
        int[] init = {0,1};
        for(int index = 0; index < 2; index ++){  //循环两次
            for (int i = init[index]; i < sizes[index]; ++i) {
                int length = 0;
                int[] initfor = {i, 0};

                int a = ((index & 1) == 0) ? 0 : 1;
                int b = ((index & 1) == 0) ? 1: 0;

                for (int m = initfor[a], n = initfor[b];m < size1 && n < size2; m++, n++) {
                    ++comparisons;
                    if (charArray1[m] != charArray2[n]) length = 0;
                    else {
                        ++length;
                        if (longest < length)  longest = length;
                    }
                }
            }

        }

        System.out.println("comparisons= " + comparisons);
        return longest;
    }
}
