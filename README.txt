****************
* Project DoubleLinkedList
* Class CS 221: Computer Science II
* Date 4/7/2023
* Your name Vlad Maliutin
**************** 

OVERVIEW:

ListTester.java class is meant to check correctness of IUArrayList.java, IUSingleLinkedList.java and IUDoubleLinkedList.java.
Those classes contain list iterators that support all ListIterator methods.
ListTester is supposed to compare results from manual results for different tests (in it) and returns from functions in given classes.
Then it gives result with total tests run plus passed and failed tests.


INCLUDED FILES:

 * ListTester.java - tester, source file
 * IUArrayList.java - source file for Array List
 * IUSingleLinkedList.java - source file for Single Linked List
 * IUDoubleLinkedList.java - source file for Double Linked List
 * Node.java - source file that supports IUSingleLinkedList and IUDoubleLinkedList
 * README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile t
 $ javac *.java

 Run the compiled class file with the command:
 $ java ListTester

 Console output will give the results (description of each test seperately, total tests run plus passed and failed tests) after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 Process of creating this program was prety straigh forward.
 It was just mostly following instruction and doing some logic.
 I used some parts of code from my previous project (like parts with ListIterator's add(), remove(), set()... methods).
 Of course I had to adapt them for my specific purposes and details of new code.
 I also used techinqe when I devide my code in parts so it looks organized and it is easy to navigate it.
 It is important since it helps to find mistakes in code really fast if there are any.
 Plus I used comments in my code for easier navigation.
 The most important part of code is probably logical part where I had to pay a lot of attention to details so I accidentaly don't make any mistake.
 Code had a lot of different methods which made it easy to organize and seperate pars of code.
 I had to think about every possible situation for methods in program so it doesn't throw any unpredicted exeption (I tried to avoid it as much as possible).
 Honestly I wich I had more time to work on this project to maximise its efficiency.

TESTING:

 ListTester.java was the primary mechanism for testing all Linked lists. 
 Almost all tests in it were written by me but base was given by instructor.

 ListTester.java was also helpful for debugging.
 I used it to develope a logic for my code and find mistakes in it.

 Righ now my code passes most of the tests.


DISCUSSION:
 
 I spent a lot of time trying to predict all exeptions to avoid them.
 It took a lot of time not because it was very complicated but because there are a lot of parts in this project (code) and it was not easy to move between them 
 and make sure the work right.
 And it was also important not to rush there because it would be realy hard to find even the smallest mistake in all of those conditions.
 
 
EXTRA CREDIT:

 If the project had opportunities for extra credit that you attempted,
 be sure to call it out so the grader does not overlook it.


----------------------------------------------------------------------------