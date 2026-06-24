/** Main driver for Practice 02: Adt Linear Structures Review. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 02: Adt Linear Structures Review");
        System.out.println("Related Course Module: Module 1 / Module 2");
        System.out.println("Weiss topic: Chapter 3, Lists, Stacks, and Queues");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        ListADTTraceDemo.run();
        ArrayBasedList.run();
        ArrayBasedListDemo.run();
        SinglyLinkedList.run();
        SinglyLinkedListDemo.run();
        DoublyLinkedList.run();
        DoublyLinkedListDemo.run();
        ArrayStack.run();
        StackDemo.run();
        LinkedQueue.run();
        QueueDemo.run();
        DequeDemo.run();
        ConcurrentModificationDemo.run();
        System.out.println("End of Practice 02. Re-run after changing input values to experiment.");
    }
}
