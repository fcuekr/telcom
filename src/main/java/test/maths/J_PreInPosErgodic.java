package test.maths;

import lombok.AllArgsConstructor;

public class J_PreInPosErgodic {
    public static void main(String[] args) {


        Node node = new Node(
                new Node(null, null, 1),
                new Node(null,
                        new Node(null, null, 2)
                        , 3),
                4);
        pre(node);
        System.out.println("------------------------");
        in(node);
        System.out.println("------------------------");
        pos(node);
        System.out.println("------------------------");
        all(node);
    }

    public static void pre(Node node){
        if (node==null){
            return;
        }
        System.out.println(node.value);
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node){
        if (node==null){
            return;
        }
        in(node.left);
        System.out.println(node.value);
        in(node.right);
    }

    public static void pos(Node node){
        if (node==null){
            return;
        }
        pos(node.left);
        pos(node.right);
        System.out.println(node.value);
    }

    public static void all(Node node){
        if (node==null){
            return;
        }
        System.out.println(node.value);
        pos(node.left);
        System.out.println(node.value);
        pos(node.right);
        System.out.println(node.value);
    }

    @AllArgsConstructor
    static class Node{
        public Node left;
        public Node right;
        public int value;
    }
}
