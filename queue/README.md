### Queue 1
##### Strengths of this exercise  
The "Queue 1" exercise gives the candidate exceptional opportunity to propose tests. 
Many of these opportunities are marked with comments in the test class.

The "Queue 1" exercise will not result in a full queue implementation. 
If the candidate gets ahead of the minimum required by each test they may begin to trip over the unnecessary redundancy they have added. 
On more than one execution of this TTD exercise, candidates that have heavily studied the queue algorithm have overshot what was required during this exercise.
Hence this is a good exercise to practise minimum implementation in the face of candidate bias.

##### Test 1
Driver should take opportunity to emphasis the importance of the isNotEmpty assertion; 
thus set the expectation of what the candidate will suggest moving forward.

##### Test 2
Engineer should have removed any boolean field representing empty state of queue.
For example they may re-use a size field in the isEmpty() method.
```
public boolean isEmpty() {
    return size == 0;
}
```

##### Test 3
Candidate may initially use a loop such as below.
```
public Object dequeue() {
    for (int i = 0; i < size + 1; i++) {
        if (arrayOfItems[i] != null) {
            Object dequeuedItem = arrayOfItems[i];
            arrayOfItems[i] = null;
            size--;
            return dequeuedItem;
        }
    }

    return "Nothing left";
}
```
While this will pass, it will prevent candidate from isolating the "Nothing left" result to a single Guard Clause. 
In order to resolve this, the FOR>IF block needs replaced. One way of achieving this is by tracking head in an class variable.
Head might also be calculated programmatically via a private method.

Candidate may choose not to delete the object reference during dequeue of an item. 
They should be pressed to better manage memory and explain the consequences of not removing dequeued items in a high-load queuing system.

##### Test 4
If the candidate has made use of a head variable/method, this gives them the opportunity to better narrow the boundaries of an array search.
Regardless, candidate should be expected to at least limit the termination boundary.
Candidate will likely receive a null pointer exception if they do not narrow boundaries on each side, thus have to write a more complicated IF statement.

##### Test 5
Suggestion to driver - The two "is not full" assertions in this test method can be omitted simultaneously in order to stretch the candidate assertion writing practise.
