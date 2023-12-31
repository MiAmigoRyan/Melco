# Melco Jr Developer Problem Set 
Submitted by Ryan Arment for consideration of Junior Developer position.

## Technologies used
Java 8, Google, Stack Overflow, VS Code, codeconvert.ai (for C++ conversion), www.W3schools.com (for C++ refactoring), www.phind.com (for explainations of Java and C++ differences)

## TO DO:
learn makefile!
consider possible edge cases
automate test cases
 improve and create UI

## Lessons learned Problem 1
I had a little fun with this one by including a scanner so that I could 'test' a variety of input cases. There is however, no check for invalid inputs.
I looked up some common methods for calculating the difference between RGB values and chose to use the average difference of the values of each 'color[]'. There are a number of other methods for calculating distance between colors. Perhaps calculating distance after converting to RGB could better correspond to the differences humans perceive in color (https://en.wikipedia.org/wiki/Color_difference#CIELAB_%CE%94E*).

## Lessons learned Problem 2
I especially enjoyed figuring out how to reverse the points in the enhanced portion of this problem. My 'basic' solution simply switched the start and end points, if end was less than start. I decided to use Slope to determine the points. I had to google and stack overflow to find a few examples of solutions for Rasterizing. 
After considering how I was handling the possibility of dividing by zero I realized that I was incorrect in how I had first designed the algorithm. I refactored to a simpler and easier to read solution. 

## Lessons learned C++ translation
I used an AI tool (https://www.codeconvert.ai/java-to-c++-converter) to convert snippets of my Java code to C++. 
This AI conversion missed a few key issues that I was able to solve by doing some quick reading on https://www.w3schools.com/cpp/default.asp.
I'm working through getting my compiler and environment set up for testing the C++ on my machine. 
The code for problem 2 and 1 seems to be operating as it does in Java using an online C++ compiler.
Converting to C++ yielded a number of other interesting learning opportunities. Two examples were needing to specify const in C++ when calling a function on object construction. Another was Java's implicit turnation with division, this was a particularly interesting issue in the rastercizing problem.


