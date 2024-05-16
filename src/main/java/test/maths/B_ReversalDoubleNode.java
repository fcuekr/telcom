package test.maths;

import lombok.AllArgsConstructor;

public class B_ReversalDoubleNode {

    public static void main(String[] args) {
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node3, null);
        node3.last=node2;
        Node head = new Node(1, node2, null);
        node2.last=head;

        Node node4 = new Node(4, null, node3);
        Node node5 = new Node(5, null, node4);
        node3.next=node4;
        node4.next=node5;
        print(head);

        Node node = reversalDoubleNode2(head);
        print(node);
    }

    //----------------算法---------------------
    private static Node reversalDoubleNode(Node head){
        Node pre = null;
        Node next;
        while (head!=null){
            next = head.next;
            pre = head.last;
            head.next=pre;
            head.last=next;
            head = next;
        }
        pre=pre.last;
        return pre;
    }
    //----------------算法---------------------

    private static Node reversalDoubleNode2(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head=next;
        }
        return pre;
    }

    @AllArgsConstructor
    static class Node{
        Integer value;
        Node next;
        Node last;
    }

    private static void print(Node head){
        if (head==null){
            return;
        }
        System.out.println(head.value);
        head=head.next;
        print(head);
    }
}
