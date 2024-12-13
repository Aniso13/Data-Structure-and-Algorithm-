package Stack;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }
    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }
    public void push(int value) {
        Node newNode = new Node(value);
        if(top == null) top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }
    public Node pop() {
        if(top == null) return null;
        Node popped = top;
        top = top.next;
        height--;
        return popped;
    }
}
