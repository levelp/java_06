import org.junit.Assert;
import org.junit.Test;

/**
 * Операции с бинарным деревом
 */
public class TreeTest extends Assert {
    static TreeOperation sum;
    static TreeOperation depth;

    static {
        depth = node -> {
            int r = 1;
            if (node.left != null)
                r = Math.max(r, 1 + depth.apply(node.left));
            if (node.right != null)
                r = Math.max(r, 1 + depth.apply(node.right));
            return r;
        };
        sum = node -> {
            int r = node.value;
            if (node.left != null)
                r += sum.apply(node.left);
            if (node.right != null)
                r += sum.apply(node.right);
            return r;
        };
    }

    public static void main(String[] args) {
        new TreeTest().testTree();
    }

    @Test
    public void testTree() {
        //             6
        //          5    1
        //        4  3  8
        //       2
        TreeNode tree = TN(
                6,
                TN(5,
                        TN(4,
                                TN(2)),
                        TN(3)),
                TN(1,
                        TN(8))
        );
        assertEquals(4, depth.apply(tree));
        assertEquals(3, depth.apply(tree.left));
        assertEquals(2, depth.apply(tree.right));

        assertEquals(29, sum.apply(tree));
        assertEquals(14, sum.apply(tree.left));
        assertEquals(9, sum.apply(tree.right));
    }

    TreeNode TN(int value, TreeNode left, TreeNode right) {
        return new TreeNode(value, left, right);
    }

    TreeNode TN(int value, TreeNode left) {
        return new TreeNode(value, left);
    }

    TreeNode TN(int value) {
        return new TreeNode(value);
    }

    // Операция с деревом
    interface TreeOperation {
        int apply(TreeNode node);
    }

    static class TreeNode {
        int value; // Значение в каждом узле дерева
        TreeNode left;
        TreeNode right; // Левое поддерево и правое поддерево

        // Конструктор
        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        TreeNode(int value, TreeNode left) {
            // Вызов другого конструктора
            this(value, left, null);
        }

        TreeNode(int value) {
            this(value, null);
        }
    }
}
