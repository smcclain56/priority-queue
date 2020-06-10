# Java Priority Queue 
This repository holds an implementation of a priority queue structure in Java. This was an implementation I did for my undergraduate algorithms class in which I was tasked with creating a min priority queue that stores pairs (p,e) which consist of a priority and an element. The element was to be stored in the priority queue with the associated priority. All priorities and elements were assumed to be integers for simplicity. 

# Features 
This priority queue is implemented using a min heap which is itself implemented using an array. To increase efficiency, I am keeping track of the index into the array for every element using a map data structure. The input to the map would be the elment and the output would be the index of that element in the heap array. The priority queue supports the following methods:
- push - add an element to the priority queue
- pop - remove the highest priority element from the queue
- topElement - return (but don't remove) the element with the highest priority
- topPriority - return (but don't remove) the highest priority value
- clear, isEmpty
- changePriority(int element, int newPriority) - change the priority of the existing element in the queue 
- getPriority(int element) - return the priority for an existing element in the queue
- isPresent(int element) - returns true if an element exists in the queue and false otherwise 

# Example
<pre>
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
1
Enter the element (must be an integer)
10
Enter the priority (must be an integer)
100
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
1
Enter the element (must be an integer)
3
Enter the priority (must be an integer)
50
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
1
Enter the element (must be an integer)
15
Enter the priority (must be an integer)
70
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
1
Enter the element (must be an integer)
8
Enter the priority (must be an integer)
4
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
4
Printing Priority Queue... 

Priority = 4, Element = 8
Priority = 50, Element = 3
Priority = 70, Element = 15
Priority = 100, Element = 10

[3=1, 8=0, 10=3, 15=2]
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
3
Enter the element you want to change (must be an integer)
8
Enter the new priority (must be an integer)
120
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
3
Enter the element you want to change (must be an integer)
3
Enter the new priority (must be an integer)
200
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
Please enter a number 1-5.
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
4
Printing Priority Queue... 

Priority = 70, Element = 15
Priority = 100, Element = 10
Priority = 200, Element = 3
Priority = 120, Element = 8

[3=2, 8=3, 10=1, 15=0]
========================= Welcome to Priority Queue ==========================
[Option 1] Insert a new element into the queue
[Option 2] Remove the highest priority element.
[Option 3] Change the priority of an element already in the priority queue.
[Option 4] Print out the priority queue
[Option 5] Quit.
Choose an option. (1-5)
5
Exiting... bye.
</pre>

# Credits
My professor, America Chambers, wrote the Pair class and gave it to me as starter code for this assignment. This was also a pair programming assignment in which I worked with my classmate, Gennie Cheatham. 
