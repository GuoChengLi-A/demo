package bean;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/22 09:44
 */
public class StackOverFlowTest {
    private static Integer count = 0;

    private static void recursion(int i5, int i6, int i7) {
        int i = 1, i2 = 2, i3 = 3, i4 = 4;
        count++;
        recursion(i5, i6, i7);
    }

    public static void main(String[] args) {
        try {
            recursion(1, 2, 3);
            System.out.println(count);
        } catch (Throwable e) {
            System.out.println("deep of calling =" + count);
            e.printStackTrace();//Xss=160k 705 Xss=256K 1730
        }

    }
}
