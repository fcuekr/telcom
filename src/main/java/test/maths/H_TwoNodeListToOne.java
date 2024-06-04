package test.maths;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("all")
public class H_TwoNodeListToOne {
    public static void main(String[] args) {
        Node node1 = arrToNode(randArr(10,10));
        print(node1);
        System.out.println();
        Node node2 = arrToNode(randArr(10,10));
        print(node2);
        System.out.println("\n");
        Node resultNode = toOneList(node1, node2);
        print(resultNode);
        System.out.println("\n------------------------------------");
    }

    public static Node toOneList(Node nodeFirst,Node nodeSecond){
        if (nodeFirst==null||nodeSecond==null){
            return nodeFirst==null?nodeSecond:nodeFirst;
        }
        Node resultNode = new Node(null,-1);
        Node cur=resultNode;
        while (nodeFirst!=null&&nodeSecond!=null){
            if (nodeFirst.value>nodeSecond.value){
                cur.next = nodeSecond;
                cur=cur.next;
                nodeSecond=nodeSecond.next;
            }else {
                cur.next = nodeFirst;
                cur=cur.next;
                nodeFirst=nodeFirst.next;
            }
        }
        cur.next=nodeFirst==null?nodeSecond:nodeFirst;
        return resultNode.next;
    }

    @AllArgsConstructor
    public static class Node{
        public Node next;
        public int value;
    }

    static Node arrToNode(int[] arr) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(null,arr[i]);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    static int[] randArr(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void print(Node node){
        if (node!=null){
            System.out.print(node.value +"->");
            print(node.next);
        }
    }
}
