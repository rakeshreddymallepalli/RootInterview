# RootInterview

Instructions to execute:
-----------------------
java -jar process.jar input.txt

Object modeling / software design
----------------------------------

Driver class: To represent a driver
Trip class: To represent a Trip (Have methods to check if trip is valid or not and calculate average speed.)

Saving Drivers in a HashSet  - Helps us check for duplicates if any in the file.
Saving Driver_Trips in a HashMap of driver's name as key and ArrayList of Trips as value. Helps us group Trips related to a particular driver together.
Saving DriverStats in an TreeMap(maintians sort order using comparator example:MilesComparator.java). Driverstats contains the stats required for printing the final processing for each individual driver.

Entrypoint : main method in Process class
-----------------------------------------

Testing approach
------------------------
I did not write explicit test cases for this project but I would use Junit to test individual methods. (Else, reflection to do the same)
Use mutation testing tools like PIT to test the effectiveness of our testbench and make sure that the testcases cover most of the edge cases.






