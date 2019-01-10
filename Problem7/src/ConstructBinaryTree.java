/**
 * @author William Mou
 * @date 2019/1/10 11:28
 */
public class ConstructBinaryTree {
    /**
     * @param preorder 前序序列
     * @param inorder  中序序列
     * @return 二叉树
     */
    public static BinaryTreeNode Construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        return ConstructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param pre 先序遍历
     * @param startPre
     * @param endPre
     * @param in 中序遍历
     * @param startIn
     * @param endIn
     * @return 二叉树
     */
    public static BinaryTreeNode ConstructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int rootValue = pre[startPre];
//        System.out.println(rootValue);
//        构建根节点
        BinaryTreeNode root = new BinaryTreeNode();
        root.setM_nValue(rootValue);
        root.setM_pLeft(null);
        root.setM_pRight(null);
        if (startPre == endPre) {
            if (startIn == endIn && pre[startIn] == in[startIn]) {
                return root;
            }
        }
//        查找中序遍历中的根节点
        int rootInorder = startIn;
        while (rootInorder <= endIn && in[rootInorder] != rootValue) {
            ++rootInorder;
        }
        int leftLength = rootInorder - startIn;
        int leftPreorderEnd = startPre + leftLength;
//        构建左子树
        if (leftLength > 0) {
            root.setM_pLeft(ConstructCore(pre, startPre + 1, leftPreorderEnd, in, startIn, rootInorder - 1));
        }
//        构建右子树
        if (leftLength < endPre - startIn) {
            root.setM_pRight(ConstructCore(pre, leftPreorderEnd + 1, endPre, in, rootInorder + 1, endIn));
        }
        return root;
    }
//    后序遍历
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.getM_pLeft());
            printTree(root.getM_pRight());
            System.out.println(root.getM_nValue());
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = Construct(preOrder, inOrder);
        printTree(root);
    }
}

class BinaryTreeNode {
    private int m_nValue;
    private BinaryTreeNode m_pLeft;
    private BinaryTreeNode m_pRight;

    public int getM_nValue() {
        return m_nValue;
    }

    public void setM_nValue(int m_nValue) {
        this.m_nValue = m_nValue;
    }

    public BinaryTreeNode getM_pLeft() {
        return m_pLeft;
    }

    public void setM_pLeft(BinaryTreeNode m_pLeft) {
        this.m_pLeft = m_pLeft;
    }

    public BinaryTreeNode getM_pRight() {
        return m_pRight;
    }

    public void setM_pRight(BinaryTreeNode m_pRight) {
        this.m_pRight = m_pRight;
    }
}