import java.util.Stack;

/**
 * @author William Mou
 * @date 2018/11/5 21:05
 */
public class PrintListReversedOrder {
    //栈
    public static void PrintListReversingly_Iteratively(ListNode pNode){
        Stack<ListNode> nodes = new Stack<>();
        while (pNode != null){
            nodes.push(pNode);
            pNode = pNode.next;
        }
        while (!nodes.isEmpty()){
            System.out.println(nodes.pop().value);
        }
    }
    //递归
    public static void PrintListReversing_Recursively(ListNode pHead){
        if (pHead == null){
            return;
        }
        PrintListReversing_Recursively(pHead.next);
        System.out.println(pHead.value);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 3;
        node2.value = 2;
        node3.value = 1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        PrintListReversingly_Iteratively(node1);
        PrintListReversing_Recursively(node1);
    }
}

class ListNode{
    int value;
    ListNode next;
}