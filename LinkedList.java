public class LinkedList {
    
    static Node root;
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        root = new Node(69);

        for(int a : arr){
            insertNode(a);
        }

        printNodes();
    }

    public static void insertNode(int num){
        Node head = root;
        if(head == null) return;
        while(head.next != null){
            head = head.next;
        }
        
        Node temp = new Node(num);
        temp.next = null;
        head.next = temp;

    }

    public static void printNodes(){
        Node ptr = root;
        while(ptr.next != null)  {
            System.out.println(" - " + ptr.num);
            ptr = ptr.next;
        }System.out.println(" - " + ptr.num);
    }

    static class Node{

        int num;
        Node next;

        Node(int num){
            this.num = num;
            this.next = null;
        }

    }

}