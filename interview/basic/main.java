package basic;

import java.util.Arrays;

/**
 * @author zr
 * @date 2023/4/23
 */

public class main {
    int[] sortNums = {4,5,7,2,9,0,8,3,1};
    public static void main(String[] args) {
        searchUtil util = new searchUtil();
        System.out.println(util.binarySearch(11));

        util.quickSort(util.sortNums);
        System.out.println(Arrays.toString(util.sortNums));
    }
}
