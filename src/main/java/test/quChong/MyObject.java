package test.quChong;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@Builder
@EqualsAndHashCode
public class MyObject {
    private String name;
    private Integer age;
    private Boolean isDead;

    @Override
    public boolean equals(Object o){
        MyObject thisObj= (MyObject)o;
        return thisObj.isDead==isDead;
    }
    @Override
    public int hashCode(){
        return Objects.hash(isDead);
    }

    public static void main(String[] args) {

    }

    private void reversalNode(Node head){
        if (head==null||head.getNext()==null){
            return;
        }

        Node sonNode = head.getNext();
        Node preNode = head;
        head = sonNode;
        reversalNode(head);
    }

    @Data
    class Node{
        private Node next;
        private Integer value;
    }
}
