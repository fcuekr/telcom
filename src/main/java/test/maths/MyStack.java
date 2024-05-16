package test.maths;

public class MyStack {

    public static void main(String[] args) {

        Stack<Integer> Stack = new Stack();
        System.out.println(Stack.isEmpty());
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);
        Stack.push(5);
        System.out.println(Stack.isEmpty());
        System.out.println(Stack.size());
        System.out.println(Stack.peek());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.size());
        System.out.println(Stack.peek());
    }

    public static class Stack<T>{
        private Node<T> head;
        private int size;

        public Stack(){
            head = null;
            size = 0;
        }

        public Boolean isEmpty(){
            return this.size==0;
        }

        public int size(){
            return this.size;
        }

        public void push(T value){
            Node<T> tNode = new Node<>(null, value);
            if (head == null){
                head = tNode;
            }else{
                tNode.next = head;
                head = tNode;
            }
            size++;
        }
        
        public T pop(){
            T answer = null;
            if (head!=null){
                answer=head.value;
                head = head.next;
                size--;
            }
            return answer;
        }
        
        public T peek(){
            return head==null?null:head.value;
        }
    }

    public static class Node<T> {
        Node next;
        T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}
