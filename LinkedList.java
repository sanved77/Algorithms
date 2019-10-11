public class LinkedList {
    
    static Node root;
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        root = new Node(69);

        for(int a : arr){
            insertNode(a);
        }
        
        printNodes();
        deleteNode(5);
        printNodes();

        
    }

    public static void insertNode(int num){
        Node head = root;
        if(head == null) {
            root = new Node(num);
        }
        while(head.next != null){
            head = head.next;
        }
        
        Node temp = new Node(num);
        temp.next = null;
        head.next = temp;
    }

    public static void deleteNode(int num){
        Node head = root;
        if(head == null) return;
        if(head.num == num){
            root = head.next;
        }
        // if(head.next == null){
        //     if(head.num == num){
        //         root = null;
        //         System.out.println("Element at root deleted");
        //     }else{
        //         System.out.println("Nothing to delete");
        //         return;
        //     }
        // }
        Node prev = head;
        head = head.next;
        while(head.next != null){
            if(head.num == num){
                prev.next = head.next;
                break;
            }else{
                prev = head;
                head = head.next;
            }
        }
        if(head.num == num){
            prev.next = head.next;
        }
    }

    public static void printNodes(){
        Node ptr = root;
        System.out.println("");
        while(ptr.next != null)  {
            System.out.print(ptr.num + ",");
            ptr = ptr.next;
        }
        System.out.print(ptr.num + ",");
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