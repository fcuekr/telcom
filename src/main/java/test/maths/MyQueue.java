package test.maths;


public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }

    static class Queue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public Queue(){
            head = null;
            tail = null;
            size = 0;
        }

        public Boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return this.size;
        }

        public void offer(T value){
            Node cur = new Node(null,value);

            if (head==null){
                head  = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }
        public T poll(){
            T answer = null;
            if (head!=null){
                answer = head.value;
                head = head.next;
                size--;
            }
            if (head == null){
                tail = null;
            }
            return answer;
        }

        public T peek(){
            return head==null?null:head.value;
        }
    }

    static class Node<T> {
        Node next;
        T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}
