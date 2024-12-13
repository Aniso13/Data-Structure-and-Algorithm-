package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0)
        {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        if(length == 0)
            return null;
        Node temp = head;
        Node prev = head;
        while (temp.next != tail) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }
public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
}

public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0)
            tail = null;
        return head;
}


public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
}
public Node get (int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
}

public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
}

public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (length == 0){
            prepend(value);
            return true;
        }
        if (index == length ){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
}

public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;

        if (length == 0)
            return removeFirst();
        if (index == length-1 )
            return removeLast();
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
}

public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        for (int i = 0; i < length ; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

}

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    @Override
    public String toString() {
        Node temp = head;
        StringBuilder result = new StringBuilder("LinkedList{ ");
        while (temp != null) {
            result.append(temp.value).append(" -> ");
            temp = temp.next;
        }
        result.append("null }");
        return result.toString();
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
    public Node findKthFromEnd(int k) {
        Node slow = this.head;
        Node fast = this.head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public void partitionList(int x) {
        if (head == null) return; // If the list is empty, return immediately

        // Dummy nodes to simplify list manipulation
        Node lessHead = new Node(0); // Dummy head for nodes < x
        Node greaterHead = new Node(0); // Dummy head for nodes >= x

        // Pointers to build the two lists
        Node less = lessHead;
        Node greater = greaterHead;

        Node current = head; // Traverse the original list

        while (current != null) {
            if (current.value < x) {
                less.next = current; // Add current node to the "less" list
                less = less.next;
            } else {
                greater.next = current; // Add current node to the "greater" list
                greater = greater.next;
            }
            current = current.next; // Move to the next node
        }

        greater.next = null; // Terminate the "greater" list
        less.next = greaterHead.next; // Connect the "less" list with the "greater" list
        head = lessHead.next; // Update the head of the original list
    }
    public void removeDuplicates() {
        Set values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                this.length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }
}
