
public class Main {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.push(100,10);
        q.push(50,3);
        q.push(70, 15);
        q.push(4,8);
        q.printHeap();
        q.printMap();
        q.changePriority(120,8);
        q.printHeap();
        q.printMap();
        q.changePriority(200,3);
        q.printHeap();
        q.printMap();

    }
}
