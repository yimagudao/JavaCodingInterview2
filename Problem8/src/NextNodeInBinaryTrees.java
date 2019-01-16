/**
 * @author William Mou
 * @date 2019/1/15 16:43
 */
public class NextNodeInBinaryTrees {
    public static PBinaryTreeNode getNextNode(PBinaryTreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        PBinaryTreeNode pNext = null;
        if (pNode.right != null) {
            PBinaryTreeNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        }
        else if(pNode.parent != null){
            PBinaryTreeNode pcurent = pNode;
            PBinaryTreeNode pParent = pNode.parent;
            while (pParent != null && pcurent == pParent.right){
                pcurent = pParent;
                pParent = pcurent.parent;
            }
            pNext = pParent;
        }
        return  pNext;
    }
}
