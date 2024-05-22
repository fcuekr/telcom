package test.maths;

@SuppressWarnings("all")
public class A_ReversalNode {

    public static void main(String[] args) {
        Node node = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(null, 5
                                        ), 4
                                ), 3
                        ), 2
                ), 1
        );
        print(node);
        Node reversalNode = reversalNode8(node);
        print(reversalNode);
    }

    private static Node reversalNode(Node node){
        if (node==null||node.next==null){
            return node;
        }
        Node resultNode = reversalNode(node.next);
        node.next.next=node;
        node.next=null;
        return resultNode;
    }

    private static Node reversalNode2(Node node){
        Node resultNode = null;
        while (node!=null){
            Node nextNode = node.next;
            node.next = resultNode;
            resultNode = node;
            node = nextNode;
        }
        return resultNode;
    }

    private static Node reversalNode3(Node node){
        if (node ==null||node.next==null){
            return node;
        }
        Node resultNode = reversalNode3(node.next);
        node.next.next=node;
        node.next=null;
        return resultNode;
    }

    private static Node reversalNode4(Node node){
        Node resultNode =null;
        while (node!=null){
            Node nextNode =node.next;
            node.next=resultNode;
            resultNode = node;
            node = nextNode;
        }
        return resultNode;
    }

    private static Node reversalNode5(Node node){
        if (node==null||node.next==null){
            return node;
        }
        Node resultNode = reversalNode5(node.next);
        node.next.next = node;
        node.next = null;
        return resultNode;
    }

    private static Node reversalNode6(Node node){
        Node resultNode = null;
        Node next = null;
        while (node!=null){
            next = node.next;
            node.next = resultNode;
            resultNode = node;
            node = next;
        }
        return resultNode;
    }

    private static Node reversalNode7(Node node){
        if (node==null||node.next==null){
            return node;
        }
        Node resultNode = null;
        resultNode = reversalNode7(node.next);
        node.next.next = node;
        node.next = null;
        return resultNode;
    }

    private static Node reversalNode8(Node head){
        Node resultNode = null;
        while (head!=null){
            Node nextNode = head.next;
            head.next = resultNode;
            resultNode = head;
            head = nextNode;
        }
        return resultNode;
    }

     static class Node{
        Node next;
        Integer value;

        Node(Node next,Integer value){
            this.next=next;
            this.value=value;
        }
    }

    public static void print(Node node){
        if (node!=null){
            System.out.println(node.value);
            print(node.next);
        }
    }
}
