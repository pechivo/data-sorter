# Data sorter

This test project provides a Java implementation to sort a collection of dates based on a specific sorting criteria. 

The sorting criteria are as follows:

* Dates with a required letter `(in tests it's - 'r')` in the month should be sorted in ascending order (from first to last).
* Dates without a required letter `(in tests it's - 'r')` in the month should be sorted in descending order (from last to first).

To use this functionality in your Java project, you can make use of the sortDates method provided by the DateSorter class. 
This method takes an unsorted list of dates `(unsortedDates)` as input and returns a collection of dates sorted according 
to the specified criteria.