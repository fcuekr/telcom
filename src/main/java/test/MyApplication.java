package test;

/*
题目一、

        反转一个单链表。

        示例:

        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
        进阶:
        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？*/
public class MyApplication {
    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4,
                                        new Node(5, null)
                                )
                        )
                )
        );
        Node node2 = new Node(3,
                new Node(4,
                        new Node(2,
                                new Node(8,
                                        new Node(1, null)
                                )
                        )
                )
        );
        print(node);
        System.out.println("-------------------");
        Node reversal = reversal(node);
        Node reversal2 = reversal2(node2);

        print(reversal);
        System.out.println("-------------------");
        print(reversal2);
    }

    public static Node reversal(Node node){
        if (node.getNode()==null||node==null){
            return node;
        }
        Node reNode = reversal(node.getNode());
        node.getNode().setNode(node);
        node.setNode(null);
        return reNode;
    }

    public static Node reversal2(Node node){
        Node reNode = null;
        while (node!=null){
            Node sonNode = node.getNode();
            node.setNode(reNode);
            reNode = node;
            node = sonNode;
        }
        return reNode;
    }

    public static void print(Node node){
        System.out.println(node.getValue());
        if (node.getNode()==null){
            return;
        }else{
            print(node.getNode());
        }
    }

    static class Node{
        private Node node;
        private Integer value;

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node(Integer value,Node node) {
            this.node = node;
            this.value = value;
        }
    }
}
