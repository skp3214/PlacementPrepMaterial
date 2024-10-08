import java.util.Scanner;

public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node start;

    public void createList(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
        } else {
            Node curNode = start;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
            newNode.prev = curNode;
        }
    }

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (index == 1) {
            if (start == null) {
                start = newNode;
            } else {
                newNode.next = start;
                start.prev = newNode;
                start = newNode;
            }
        } else {
            Node curNode = start;
            for (int i = 1; i < index - 1; i++) {
                curNode = curNode.next;
            }
            newNode.next = curNode.next;
            if (curNode.next != null) {
                curNode.next.prev = newNode;
            }
            curNode.next = newNode;
            newNode.prev = curNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 1) {
            start = start.next;
            start.prev = null;
        } else {
            Node curNode = start;
            for (int i = 1; i < index - 1; i++) {
                curNode = curNode.next;
            }
            curNode.next = curNode.next.next;
            if (curNode.next != null) {
                curNode.next.prev = curNode;
            }
        }
    }

    public void printList() {
        if (start == null) {
            System.out.println("List is empty.");
        } else {
            Node curNode = start;
            while (curNode != null) {
                System.out.print(curNode.data + " <-> ");
                curNode = curNode.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many node you want to add ?: ");
        int noOfNode = sc.nextInt();
        for (int i = 0; i < noOfNode; i++) {
            System.out.print("Enter the data of " + (i + 1) + " Node: ");
            int data = sc.nextInt();
            list.createList(data);
        }
        boolean loop = true;
        list.printList();
        while (loop == true) {

            System.out.println("Choose the option below.");
            System.out.println("0.Exit. ");
            System.out.println("1.Insert a node at index.");
            System.out.println("2.Delete a node at index. ");
            System.out.println("3.Print the list. ");

            int choice = sc.nextInt();

            if (choice == 0) {
                loop = false;
            }
            if (choice == 1) {
                System.out.println("How many nodes you want to insert.");
                int noOfnode = sc.nextInt();
                for (int i = 0; i < noOfnode; i++) {
                    System.out.print("Enter the data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter the index: ");
                    int index = sc.nextInt();
                    list.insertAtIndex(data, index);
                    System.out.println(" ");

                }
            }
            if (choice == 2) {
                System.out.println("How many nodes you want to delete.");
                int nOfnode = sc.nextInt();
                for (int i = 0; i < nOfnode; i++) {
                    System.out.print("Enter the index: ");
                    int index = sc.nextInt();
                    list.deleteAtIndex(index);
                }
            }
            if (choice == 3) {
                list.printList();
            }

        }

        sc.close();
    }
}
