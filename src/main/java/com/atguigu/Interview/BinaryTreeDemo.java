package com.atguigu.Interview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
class TreeNode
{
    private String val;
    private TreeNode left;
    private TreeNode right;

    public void visitTree()
    {
        System.out.print(val+" ");
    }
}

/**
 * @auther zzyy
 * @create 2018-09-26 10:30
 *           A
 *     B          C
 *  D     E            F
 *  题目05：按照上图构造一个树并进行前中后三种遍历
 */
public class BinaryTreeDemo
{
    //前序遍历:(根，左，右)递归实现 A(root) B D E C F
    public static void beforeOrder(TreeNode node)
    {
        if (node == null) return;
        node.visitTree();
        beforeOrder(node.getLeft());
        beforeOrder(node.getRight());
    }
    //中序遍历:(左,根，右)递归实现 A(root) B D E C F
    public static void middleOrder(TreeNode node)
    {
        if (node == null) return;
        middleOrder(node.getLeft());
        node.visitTree();
        middleOrder(node.getRight());
    }
    //后序遍历:(左,右,根)递归实现D E B F C A(root)
    public static void afterOrder(TreeNode node)
    {
        if (node == null) return;
        afterOrder(node.getLeft());
        afterOrder(node.getRight());
        node.visitTree();
    }

    public static void main(String[] args)
    {
        TreeNode treeNodeD = new TreeNode("D",null,null);
        TreeNode treeNodeE = new TreeNode("E",null,null);
        TreeNode treeNodeF = new TreeNode("F",null,null);
        TreeNode treeNodeB = new TreeNode("B",treeNodeD,treeNodeE);
        TreeNode treeNodeC = new TreeNode("C",null,treeNodeF);
        TreeNode treeNodeA = new TreeNode("A(root)",treeNodeB,treeNodeC);

        System.out.println("前序遍历结果(递归实现):");
        beforeOrder(treeNodeA);
        System.out.println("--------------------");
        System.out.println("中序遍历结果(递归实现):");
        middleOrder(treeNodeA);
        System.out.println("--------------------");
        System.out.println("后序遍历结果(递归实现):");
        afterOrder(treeNodeA);

    }
}
