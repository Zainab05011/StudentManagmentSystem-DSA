import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class SinglyNode {
    Student student;
    SinglyNode next;

    SinglyNode(Student student) {
        this.student = student;
        this.next = null;
    }
}

class SinglyLinkedList {
    SinglyNode head;

    void insert(Student student) {
        SinglyNode newNode = new SinglyNode(student);
        if (head == null) {
            head = newNode;
        } else {
            SinglyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    boolean delete(int id) {
        if (head == null) return false;
        if (head.student.id == id) {
            head = head.next;
            return true;
        }
        SinglyNode current = head;
        while (current.next != null) {
            if (current.next.student.id == id) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    boolean update(int id, String newName) {
        SinglyNode current = head;
        while (current != null) {
            if (current.student.id == id) {
                current.student.name = newName;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void display() {
        SinglyNode current = head;
        while (current != null) {
            System.out.println("ID: " + current.student.id + ", Name: " + current.student.name);
            current = current.next;
        }
    }
}

class DoublyNode {
    Student student;
    DoublyNode next, prev;

    DoublyNode(Student student) {
        this.student = student;
        this.next = this.prev = null;
    }
}

class DoublyLinkedList {
    DoublyNode head;

    void insert(Student student) {
        DoublyNode newNode = new DoublyNode(student);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    boolean delete(int id) {
        if (head == null) return false;
        if (head.student.id == id) {
            head = head.next;
            if (head != null) head.prev = null;
            return true;
        }
        DoublyNode current = head;
        while (current != null) {
            if (current.student.id == id) {
                if (current.next != null) current.next.prev = current.prev;
                if (current.prev != null) current.prev.next = current.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    boolean update(int id, String newName) {
        DoublyNode current = head;
        while (current != null) {
            if (current.student.id == id) {
                current.student.name = newName;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void display() {
        DoublyNode current = head;
        while (current != null) {
            System.out.println("ID: " + current.student.id + ", Name: " + current.student.name);
            current = current.next;
        }
    }
}

class Stack {
    private List<Student> stack;

    Stack() {
        stack = new ArrayList<>();
    }

    void push(Student student) {
        stack.add(student);
    }

    Student pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    boolean update(int id, String newName) {
        for (Student student : stack) {
            if (student.id == id) {
                student.name = newName;
                return true;
            }
        }
        return false;
    }

    void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("ID: " + stack.get(i).id + ", Name: " + stack.get(i).name);
        }
    }
}

class Queue {
    private List<Student> queue;

    Queue() {
        queue = new ArrayList<>();
    }

    void enqueue(Student student) {
        queue.add(student);
    }

    Student dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }
        return queue.remove(0);
    }

    boolean update(int id, String newName) {
        for (Student student : queue) {
            if (student.id == id) {
                student.name = newName;
                return true;
            }
        }
        return false;
    }

    void display() {
        for (Student student : queue) {
            System.out.println("ID: " + student.id + ", Name: " + student.name);
        }
    }
}

class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter ID for Student " + i + ": ");
            int id = scanner.nextInt();
            System.out.print("Enter Name for Student " + i + ": ");
            String name = scanner.next();
            Student student = new Student(id, name);
            sll.insert(student);
            dll.insert(student);
            stack.push(student);
            queue.enqueue(student);
        }

        System.out.println("\nSingly Linked List of Students:");
        sll.display();
        System.out.println("\nDoubly Linked List of Students:");
        dll.display();
        System.out.println("\nStack of Students:");
        stack.display();
        System.out.println("\nQueue of Students:");
        queue.display();

        System.out.print("\nEnter ID of Student to drop: ");
        int dropId = scanner.nextInt();
        if (sll.delete(dropId)) {
            System.out.println("Student with ID " + dropId + " dropped from Singly Linked List.");
        } else {
            System.out.println("Student not found in Singly Linked List.");
        }
        if (dll.delete(dropId)) {
            System.out.println("Student with ID " + dropId + " dropped from Doubly Linked List.");
        } else {
            System.out.println("Student not found in Doubly Linked List.");
        }
        if (stack.pop() != null) {
            System.out.println("Top student popped from Stack.");
        }
        if (queue.dequeue() != null) {
            System.out.println("Front student dequeued from Queue.");
        }

        System.out.print("\nEnter ID of Student to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter new name: ");
        String newName = scanner.next();

        if (sll.update(updateId, newName)) {
            System.out.println("Student with ID " + updateId + " updated in Singly Linked List.");
        } else {
            System.out.println("Student not found in Singly Linked List.");
        }
        if (dll.update(updateId, newName)) {
            System.out.println("Student with ID " + updateId + " updated in Doubly Linked List.");
        } else {
            System.out.println("Student not found in Doubly Linked List.");
        }
        if (stack.update(updateId, newName)) {
            System.out.println("Student with ID " + updateId + " updated in Stack.");
        } else {
            System.out.println("Student not found in Stack.");
        }
        if (queue.update(updateId, newName)) {
            System.out.println("Student with ID " + updateId + " updated in Queue.");
        } else {
            System.out.println("Student not found in Queue.");
        }

        System.out.println("\nSingly Linked List after updates:");
        sll.display();
        System.out.println("\nDoubly Linked List after updates:");
        dll.display();
        System.out.println("\nStack after updates:");
        stack.display();
        System.out.println("\nQueue after updates:");
        queue.display();
        scanner.close();
    }
}