package java.lang1;

/**
 * 沙箱安全机制
 * @author YiYa
 * @since 2020-06-09 下午 09:47
 */
public class String {
    static {
        System.out.println("自定义String类静态代码块~");
    }
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
