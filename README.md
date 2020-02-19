# Soge - Technical Question
Particle Chamber Solution

## Instruction: 
Try to implement the below problment Statement in Java and if time permits do it in Python as well. 
Can you think of how to extend the scope of the problem? 
Do you think Java solution to the above problem can be implementd with Spring boot in a better way? 
If answer is yes do it. if anser is no, explain. 
Submit your code for our review either by checkin to your own public github repo (and share your repo URL) or send us by email.

## Problem Statement
A collection of particles is contained in a linear chamber. They all have the same speed, but some are headed toward the right and others are headed toward the left. These particles can pass through each other without disturbing the motion of the particles, so all the particles will leave the chamber relatively quickly.
You will be given the initial conditions by a String init containing at each position an 'L' for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty location. init shows all the positions in the chamber. Initially, no location in the chamber contains two particles passing through each other.
We would like an animation of the process. At each unit of time, we want a string showing occupied locations with an 'X' and unoccupied locations with a '.'. Create a class Animation that contains a method animate that is given an int speed and a String init giving the initial conditions. The speed is the number of positions each particle moves in one time unit.
The method will return an array of strings in which each successive element shows the occupied locations at the next time unit. The first element of the return should show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The last element in the return should show the empty chamber at the first time that it becomes empty.

## Answers
Can you think of how to extend the scope of the problem? 
To extand the scope of the probleme, we could have think of a problem in more dimensions.
