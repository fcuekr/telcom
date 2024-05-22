package test.maths;

@SuppressWarnings("all")
public class F_KGroupReverse {

    public static void main(String[] args) {
        Node node = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(new Node(new Node (new Node(null,8),7),6), 5
                                        ), 4
                                ), 3
                        ), 2
                ), 1
        );

        Node node2 = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(null, 5
                                        ), 4
                                ), 3
                        ), 2
                ), 1
        );

        Node node3 = new Node(null, 1);

        Node node1 = new F_KGroupReverse().reverseNodeListWithKGroup(node3, 3);
        System.out.println(node1);
        print(node1);
    }

    static class Node{
        Node next;
        Integer value;

        Node(Node next, Integer value){
            this.next=next;
            this.value=value;
        }
    }

    public Node reverseNodeListWithKGroup(Node node,int k){
        Node start = node;
        Node end;
        Node lastEnd =null;
        node = getNextKNode(node,k);
        while (start!=null){
            end = getNextKNode(start, k);
            if (end==null){
                return node;
            }
            reverseNodeLimitK2(start,end);
            if (lastEnd!=null){
                lastEnd.next=end;
            }
            lastEnd = start;
            start = lastEnd.next;
        }
        return node;
    }
    
    public Node getNextKNode(Node node,int k){
        while (node!=null&&--k>0){
            node = node.next;
        }
        return node;
    }
    
    public void reverseNodeLimitK(Node head,int k,Node end){
        if (getNextKNode(head,k)==null){
            return  ;
        }
        Node start = head;
        Node resultNode = null;
        while (--k>=0){
            Node nextNode = head.next;
            head.next = resultNode;
            resultNode = head;
            head=nextNode;
        }
        start.next = end;
    }

    public void reverseNodeLimitK2(Node head,Node end){
        end=end.next;
        Node last = null;
        Node cur = head;
        while (cur!=end){
            Node nextNode = cur.next;
            cur.next = last;
            last=cur;
            cur = nextNode;
        }
        head.next=end;
    }

    public Node reverseNodeListWithKGroup2(Node node,int k){
        Node resultNode =getNextKNode(node,k);
        if (resultNode==null){
            return node;
        }
        Node start =node;
        Node end = null;
        Node lastEnd = null;
        while (start!=null){
            end=getNextKNode(start,k);
            if (end==null){
                return resultNode;
            }
            reverseNode(start,end);
            if (lastEnd!=null){
                lastEnd.next=end;
            }
            lastEnd = start;
            start = lastEnd.next;
        }
        return resultNode;
    }

    public void reverseNode(Node start,Node end){
        end=end.next;
        Node pre = null;
        Node cur = start;
        while (cur!=end){
            Node next = cur.next;
            cur.next=pre;
            pre = cur;
            cur=next;
        }
        start.next=end;
    }



    private static void print(Node node){
        if (node!=null){
            System.out.println(node.value);
            print(node.next);
        }
    }
}
