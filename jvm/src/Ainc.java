/**
 * @author zr
 * @date 2023/4/28
 */

public class Ainc {
    public static void main(String[] args) {
        int a = 10;
        int b = a++ + ++a + a--;
        System.out.println(a);
        System.out.println(b);
    }
}
