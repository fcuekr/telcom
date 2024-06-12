package test.maths;

import lombok.AllArgsConstructor;

import java.util.Random;

public class G_NodeListAdd {

    public static void main(String[] args) {
        Node node1 = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(null, 9
                                        ), 9
                                ), 3
                        ), 2
                ), 1
        );

        Node node2 = new Node(
                new Node(
                        new Node(null,7
                        ), 8
                ), 9
        );
//        Node node = addTwoNodeList(node1, node2);
//        print(node);
        for (int i = 0; i < 100; i++) {
            Node nodeFirst = randomNode();
            Node nodeSecond = randomNode();
            print(nodeFirst);
            System.out.println();
            print(nodeSecond);
            System.out.println();
            System.out.println();
            print(addTwoNodeList2(nodeFirst,nodeSecond));
            System.out.println();
            System.out.println("------------------------------------");
        }
    }

    public static Node addTwoNodeList(Node node1,Node node2){
        if (node1==null||node2==null){
            return node1==null?node2:node1;
        }
        int carry=0;
        Node longNodeListHead = getNodeListLength(node1)>getNodeListLength(node2)?node1:node2;
        Node shortNodeListHead = getNodeListLength(node1)>getNodeListLength(node2)?node2:node1;
        Node head = longNodeListHead;
        Node last = null;
        while (shortNodeListHead!=null){
            int sCur = shortNodeListHead.value;
            int lCur = longNodeListHead.value;
            int sum = sCur+lCur+carry;
            carry=sum/10;
            longNodeListHead.value = sum%10;
            last = longNodeListHead;
            shortNodeListHead=shortNodeListHead.next;
            longNodeListHead=longNodeListHead.next;
        }
        while (longNodeListHead!=null){
            int lCur = longNodeListHead.value;
            int sum = lCur+carry;
            carry=sum/10;
            longNodeListHead.value = sum%10;
            last = longNodeListHead;
            longNodeListHead=longNodeListHead.next;
        }
        if (carry==1){
            last.next=new Node(null,1);
        }
        return head;
    }


    public static Node addTwoNodeList2(Node node1,Node node2){
        if (node1==null||node2==null){
            return node1==null?node2:node1;
        }
        Node shortNode = getNodeListLength(node1)<getNodeListLength(node2)?node1:node2;
        Node longNode = getNodeListLength(node1)<getNodeListLength(node2)?node2:node1;
        Node head = longNode;
        Node last = null;
        int carry = 0;
        while (shortNode!=null){
            int sum = (longNode.value+shortNode.value+carry)%10;
            carry = (longNode.value+shortNode.value+carry)/10;
            longNode.value = sum;
            last = longNode;
            shortNode = shortNode.next;
            longNode = longNode.next;
        }
        while (longNode!=null){
            int sum = (longNode.value+carry)%10;
            carry = (longNode.value+carry)/10;
            longNode.value = sum;
            last = longNode;
            longNode = longNode.next;
        }
        if (carry==1){
            last.next = new Node(null,1);
        }
        return head;
    }

    public static int getNodeListLength(Node node){
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }


    @AllArgsConstructor
    public static class Node{
        public Node next;
        public int value;
    }

    public static void print(Node node){
        if (node!=null){
            System.out.print(node.value +"->");
            print(node.next);
        }
    }

    public static Node randomNode(){
        int length = new Random().nextInt(10)+1;
        int number;
        Node cur;
        Node resultNode = null;
        Node last = null;
        while (length>0){
            length--;
            number = new Random().nextInt(10);
            cur = new Node(null,number);
            if (resultNode==null){
                resultNode=cur;
            }
            if (last!=null){
                last.next = cur;
            }
            last=cur;
        }
        return resultNode;
    }
}
