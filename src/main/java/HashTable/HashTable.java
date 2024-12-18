package HashTable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node [] dataMap;

    class Node {
        String key;
        int value;
        Node next;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
            int ascii = key.charAt(i);
            hash = (hash + ascii * 26) % dataMap.length ;
        }
        return hash ;
    }

    public void set(String key, int value){
        int hash = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[hash] == null){
            dataMap[hash] = newNode;
        }
        else{
            Node current = dataMap[hash];
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(String key){
        int hash = hash(key);
        Node current = dataMap[hash];
        while(current != null){
            if(current.key.equals(key)) return current.value;
            current = current.next;
        }
        return -1;
    }
    public ArrayList<String> keys(){
        ArrayList<String> keys = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Node current = dataMap[i];
            while(current != null){
                keys.add(current.key);
            }
        }
        return keys;
    }

}
