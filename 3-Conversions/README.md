# Recursive Conversions 

> A program that creates two methods that convert to and from a binary search tree.

<a name="toc"/></a>
## Table of Contents

1. [Overview](#overview)

2. [Technologies](#technologies)

3. [Launch](#launch) 

<a name="overview"/></a>
## 1. Overview
[Back to ToC](#toc)

This project creates two methods that convert to and from a binary search tree.  One creates a balanced BST starting from an array. The other relinks the nodes of a BST so that they form a linked list with elements following the inorder traversal of the original tree.  (The tree itself is destroyed by this process.)

### Array to BinaryTree / BST

There are two versions of this method, both of which take the array to be converted as their argument, and the return a `BinaryTree` or `BST` respectively.  The function calls a recursive helper.  This helper accepts a sorted array, plus low and high index numbers.  It only pays attention to the portion of the array between the low index (included in the range) and the high index (excluded).  With these elements it builds a balanced binary tree by splitting the active portion around its middle element (called the pivot) and recursively calling itself on the subranges remaining on either side of the pivot.

### BinaryTree to Linked List

To make this work, the `DLL` class included here needs to be modified so that it uses `BinaryTree` nodes as its list nodes.  You'll need to replace all the appearances of `NodeDL` with `BinaryTree`, and also substitute `getLeft` and `getRight` for `getPrevious` and `getNext`.  You can remove the `NodeDL` class entirely when this is done.

The program converts BinaryTree to Linked List by following a simple recursive process:  get lists for the left and right subtrees.  Form a new list by sticking them together with the root node in the middle between the two sides, and return the result.  The entire conversion is carried out just by updating the links between nodes.


<a name="technologies"/></a>
## 2. Technologies
[Back to ToC](#toc)

java version "1.8.0_181"<br />
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)<br />
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)<br />

<a name="launch"/></a>
## 3. Launch
[Back to ToC](#toc)
```bash
javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')

java TestConversion
```
 
 
