package datastructure.binarytree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode297SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = serializePreorder(root, new StringBuilder());
        return res.toString();
    }

    /**
     * 递归_将二叉树以前序遍历的顺序序列化为一个 StringBuilder 对象
     * Version 2.0 2021-07-19 by XCJ
     * @param root 待序列化二叉树树根节点
     * @param stringBuilder 字符串构造器
     * @return 一个以前序遍历顺序排列的 stringBuilder 对象
     */
    private StringBuilder serializePreorder(TreeNode root, StringBuilder stringBuilder) {
        // 递归出口
        if (root == null) {
            stringBuilder.append("null,");
            return stringBuilder;
        }
        /* 前序遍历位置 */
        // 将当前节点值加入 stringBuilder
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        // 处理子节点
        stringBuilder = serializePreorder(root.left, stringBuilder);
        stringBuilder = serializePreorder(root.right, stringBuilder);

        return stringBuilder;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 将参数二叉树元素字符串分割为字符串结点数组
        String[] strArray = data.split(",");
        // 转换为集合
        List<String> listString = new LinkedList<String>(Arrays.asList(strArray));
        // 构造二叉树
        return deserializePreorder(listString);
    }

    /**
     * 递归_由字符串数组构造一棵二叉树
     * Version 2.0 2021-07-19 by XCJ
     * @param listString 字符串数组，每个元素转换为 int 对应节点的 value
     * @return 生成的二叉树根节点
     */
    private TreeNode deserializePreorder(List<String> listString) {
        if(listString.get(0).equals("null")) {
            listString.remove(0);
            return null;
        }
        /* 前序遍历位置 */
        // 使用待构造序列的首元素新建一个节点
        TreeNode root = new TreeNode(Integer.parseInt(listString.get(0)));
        listString.remove(0);
        // 处理子节点
        root.left = deserializePreorder(listString);
        root.right = deserializePreorder(listString);

        return root;
    }
}
