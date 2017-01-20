# Java-Reflection

Date: Wednesday, December 14, 2016
Author: Sandesh Nimhan
e-mail: snimhan1@binghamton.edu


PURPOSE:

[
	Understanding and implementing Java Reflection.
  By creating objects of different classes with given attribute values, and count unique and total number of objects of all classes.
]

DATA STRUCTURE:
[
	HashSet to store the objects
	It is easy to implement and to find if the object already exists in HashSet efficiently. 
	Time Complexity of HashSet is O(1). Internal Data Structure used by HashSet is Hash Table. 
]


TO COMPILE USING ANT:
[
	ant all 
]

TO RUN: 
[
	ant run -Darg0=input.txt -Darg1=0
]

SAMPLE OUTPUT:

[ 
	Number of Unique First Objects: 359994
	Number of Total First Objects: 498623
	Number of Unique Second Objects: 100643
	Number of Total Second Objects: 501377
]
