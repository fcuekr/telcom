package test.maths;

import lombok.AllArgsConstructor;

public class E_MyDoubleQueue {

    public static void main(String[] args) {
        DoubleQueue<Integer> queue = new DoubleQueue<>();
        queue.headOffer(1);
        queue.headOffer(2);
        queue.headOffer(3);
        queue.headOffer(4);
        queue.headOffer(5);

        System.out.println(queue.headPeek());
        System.out.println(queue.tailPeek());

        System.out.println(queue.headPoll());
        System.out.println(queue.tailPoll());


        System.out.println(queue.headPeek());
        System.out.println(queue.tailPeek());

        System.out.println(queue.headPoll());
        System.out.println(queue.tailPoll());


        System.out.println(queue.headPeek());
        System.out.println(queue.tailPeek());

        System.out.println(queue.headPoll());
        System.out.println(queue.tailPoll());


        System.out.println(queue.headPeek());
        System.out.println(queue.tailPeek());

        System.out.println(queue.headPoll());
        System.out.println(queue.tailPoll());


        System.out.println(queue.headPeek());
        System.out.println(queue.tailPeek());

        System.out.println(queue.headPoll());
        System.out.println(queue.tailPoll());

    }

    @AllArgsConstructor
    public static class Node<T>{
        T value;
        Node next;
        Node last;
    }

    public static class DoubleQueue<T>{
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public Boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }

        public void headOffer(T val){
            Node<T> newNode = new Node<>(val, null, null);
            if (head==null){
                head = newNode;
                tail = newNode;
            }else {
                head.last = newNode;
                newNode.next=head;
                head = newNode;
            }
            size++;
        }

        public void tailOffer(T val){
            Node<T> newNode = new Node<>(val, null, null);
            if (head==null){
                head = newNode;
                tail = newNode;
            }else {
                tail.next=newNode;
                newNode.last=tail;
                tail = newNode;
            }
            size++;
        }

        public T headPoll(){
            T answer = null;
            if (head != null){
                answer = head.value;
                head = head.next;
                if (head!=null){
                    head.last=null;
                }else {
                    tail=null;
                }
                size--;
            }
            return answer;
        }

        public T tailPoll(){
            T answer = null;
            if (head != null){
                answer = tail.value;
                tail = tail.last;
                if (tail!=null){
                    tail.next=null;
                }else{
                    head=null;
                }
                size--;
            }
            return answer;
        }

        public T headPeek(){
            return head==null?null:head.value;
        }

        public T tailPeek(){
            return head==null?null:tail.value;
        }
    }

}
