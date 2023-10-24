# Melco Jr Developer Problem Set 
Submitted by Ryan Arment for consideration of Junior Developer position.

## Technologies used
Java 8, Google, Stack Overflow, Spring Tool Suite, codeconvert.ai (for c++ conversion), www.W3schools.com (for C++ refactoring).

## TODO:
Refactoring Methods/Functions to reduce time complexity, currently all Methods/Functions are O(n).
Transpose comments from Java solutions to C++ solutions.

## Lessons learned Problem 1
I had a little fun with this one by including a scanner so that I could 'test' a variety of imput cases. There is however no check for invalid imputs.
 I looked up some common methods for calculating the difference between RGB values and choose to us the average difference of the absolute values of each 'color[]'. This is a reasonable soltion but something more fine such as Euclidian (square roots) would be more precise. I also updated the 'machineThreads' with doubles, I used RGB values for Red, Blue, and Yellow.


## Lessons learned Problem 2
I espically enjoyed figuring out how to reverse the points in the enhanced portion of this problem. My 'basic' solution simply switched the start and end points if end was less than start. I decided to use Slope to determine the points. I had to google and stack overflow to find a few examples of solutions for Rasterizing. I did not include a scanner for this problem.

## Lessons learned C++ translation
I used an ai tool "https://www.codeconvert.ai/java-to-c++-converter" to covert snippets of my java code to c++. 
This AI coversion missed a few key issues that I was able to solve by doing some quick reading on "https://www.w3schools.com/cpp/default.asp".
I'm working through getting my compiler and enviornment set up for testing the c++ on my machine. 
The code for problem 2 and 1 seems to be operating as it does in Java using an online c++ compiler.

