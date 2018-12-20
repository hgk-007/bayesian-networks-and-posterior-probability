1) Name : Himanshu Kotbagi
   UTA ID : 1001581530

------------------------------------------ TASK 1----------------------------------------
2) Programming language : Java

3) How the code is structured?
 
compute_a_posteriori - The task of this code is to find out the probability of occurrence of cherry and lime after ith observation. So, the code written will calculate the probabilty of the current observation based on prior observation and further uses the current observation as prior probabilty for calculating probability for the next one. Finally, finds out the probability of i+1 occurrence of cherry and lime from the given bags.
 
4) How to run the code?
 The code can be executed on the command prompt using the following arguments.

java compute_a_posteriori observations

eg:
java compute_a_posteriori CLLLCCCLLLCC


------------------------------------------ TASK 2----------------------------------------


2) Programming language : Java

3) How the code is structured?

1. Initially, the code accepts input from command line arguments.
2. It then computes the hidden variables if any hidden variables are present. If the argument contains "given" then it finds
   hidden variables for numerator and denominator.
3. This will then call a method which then sets true and false value to the hidden variables and calls computeProbability.
4. The computeProbability then calculates the probability of the given combination and returns the probability. Here only table values are hardcoded. The arguments to the computeProbability are the truth values.
 
4) How to run the code?
 The code can be executed on the command prompt using the following command

eg:java bnet Bt Af given Mf


Note: command line arguments are case sensitive.

Reference:

1.Referred Ai CSE 5360 Dr.Vamsikrishna's slides and echo 360 videos on Posterior Probability and Bayesian Networks.
2.Artificial Intelligence: A modern approach <Third Edition> - Stuart Rusell, Peter Norvig.
3.Referred youtube and stackoverflow along with w3 schools.
