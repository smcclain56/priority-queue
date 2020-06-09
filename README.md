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

# Credits
My professor, America Chambers, wrote the Pair class and gave it to me as starter code for this assignment. This was also a pair programming assignment in which I worked with my classmate, Gennie Cheatham. 
