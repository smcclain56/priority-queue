import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        Scanner scan = new Scanner(System.in);
        String option;
        try {
            do {
                //prints out the analyzing options for the user
                System.out.println("========================= Welcome to Priority Queue ==========================");
                System.out.println("[Option 1] Insert a new element into the queue");
                System.out.println("[Option 2] Remove the highest priority element.");
                System.out.println("[Option 3] Change the priority of an element already in the priority queue.");
                System.out.println("[Option 4] Print out the priority queue");
                System.out.println("[Option 5] Quit.");

                //prompts the user to choose an option
                System.out.println("Choose an option. (1-5)");
                option = scan.nextLine();
                if(option.equals("1")) { //insert a new element into the queue
                    //ask user for priority value
                    System.out.println("Enter the element (must be an integer)");
                    int element = scan.nextInt();
                    // ask user for element value
                    System.out.println("Enter the priority (must be an integer)");
                    int priority = scan.nextInt();
                    q.push(priority,element);
                }else if(option.equals("2")) { //remove the highest priority element
                    System.out.println("Removing element... ");
                    int priority = q.topPriority();
                    int element = q.topElement();
                    q.pop();
                    System.out.println("Element: " + element);
                    System.out.println("Priority: " + priority);

                }else if(option.equals("3")){ // change priority
                    //ask user for priority value
                    System.out.println("Enter the element you want to change (must be an integer)");
                    int element = scan.nextInt();
                    // ask user for element value
                    System.out.println("Enter the new priority (must be an integer)");
                    int priority = scan.nextInt();
                    q.changePriority(priority,element);
                }else if(option.equals("4")) { //display minimum heap
                    System.out.println("Printing Priority Queue... ");
                    System.out.println();
                    q.printHeap();
                    q.printMap();
                }else if(!option.equals("5")) {
                    System.out.println("Please enter a number 1-5.");
                }
            }while(!option.equals("5"));
            System.out.println("Exiting... bye.");
            System.exit(0);
        }catch(InputMismatchException e) {
            throw new InputMismatchException();
        }

    }
}
