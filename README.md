RootInterview

Instructions to execute:
----------------------------
java -jar process.jar input.txt  

find process.jar in Process folder.

If you want to build and run tests by yourself:
------------------------------------
Import the project in Project folder in eclipse.
Add the required Jars in Required_Jars folder to the class/build path of the project (For Junit)

Object modeling / software design
-----------------------------------
Driver class: To represent a driver

Trip class: To represent a Trip (Have methods to check if trip is valid or not and calculate average speed.)

Saving Drivers in a HashSet - Helps us check for duplicates if any in the file.

Saving Driver_Trips in a HashMap of driver's name as key and ArrayList of Trips as value. Helps us group Trips related to a particular driver together.

Saving DriverStatsView in an TreeMap(maintians sort order using comparator example:MilesComparator.java). DriverStatsView contains the stats required for printing the final processing for each individual driver.

So, if the requirements change and if I need to print by ascending order all we have to do is to write a new comparator. 
If the view changed completely they we might have to write a new class similar to DriverStats.

Entrypoint
----------
main method in Process class

Testing approach
-----------------
I did not write all the required test cases for this project but I would write similar Junit tests for all the methods. (Else, reflection to do the same) Use mutation testing tools like PIT to test the effectiveness of our testbench and make sure that the testcases cover most of the edge cases.
Finally I would do the system level testing either manually as show in the SampleRun image. (We can automate that too)
