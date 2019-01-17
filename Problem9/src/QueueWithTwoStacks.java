import sun.font.FontRunIterator;

import java.util.logging.XMLFormatter;

/**
 * @author William Mou
 * @date 2019/1/17 21:13
 */
public class QueueWithTwoStacks {
    public static void main(String[] args) {
        CQueue<Integer> queue = new CQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.appendTail(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.deleteHead());
        }
    }
}

