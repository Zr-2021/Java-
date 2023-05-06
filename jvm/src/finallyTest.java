/**
 * @author zr
 * @date 2023/4/28
 */

public class finallyTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            System.out.println(i);
            return;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            i = 20;
        }
        System.out.println(i);
    }
}
