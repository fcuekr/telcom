package test.maths;

import java.util.List;

public class F_ReverseListNodesInKGroup_ZuoChengYun {
  
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode ListNode = randListNode(8);
        printListNode(ListNode);
        ListNode ListNode1 = reverseKGroup(ListNode, 3);
        printListNode(ListNode1);
    }

    static ListNode reverseKGroup(ListNode ListNode, int k) {
        //1.计算k
        ListNode start = ListNode;
        ListNode end;
        ListNode head = ListNode;
        ListNode laseEnd;
        end = getKGroup(start,k);
        if (end == null) {
            return head;
        }
        resverse(start,end);
        laseEnd = start;
        head = end;
        start = laseEnd.next;
        while (start != null) {
            end = getKGroup(start,k);
            if (end == null) {
                return head;
            }
            resverse(start,end);
            laseEnd.next = end;
            laseEnd = start;
            start = laseEnd.next;
        }
        return head;
    }

    private static void resverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode next;
        ListNode prev = null;
        ListNode cur = start;
        while (cur != end) {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
        }
        start.next = end;
    }

    static ListNode getKGroup(ListNode ListNode, int k) {
        while (--k > 0 && ListNode != null){
            ListNode = ListNode.next;
        }
        return ListNode;
    }


    static void printListNode(ListNode head){
        while (head != null) {
            System.out.print(head.val + "---->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    static ListNode randListNode(int maxValue){
        int len = (int) (Math.random() * maxValue);
        int sum = 1;
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < len; i++) {
            ListNode ListNode = new ListNode(sum);
            sum++;
            if (head == null){
                head = ListNode;
                tail = ListNode;
            }else {
                tail.next = ListNode;
                tail = ListNode;
            }
        }
        return head;
    }
}
