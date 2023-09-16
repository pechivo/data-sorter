package org.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorter {
    private char requiredLetter;

    public DateSorter(char requiredLetter) {
        this.requiredLetter = requiredLetter;
    }

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (unsortedDates == null) {
            throw new IllegalArgumentException("Be careful, your list is null. "
                    + "Correct the data");
        }
        List<LocalDate> listWithLetter = new ArrayList<>();
        List<LocalDate> listWithoutLetter = new ArrayList<>();
        for (LocalDate unsortedDate : unsortedDates) {
            if (unsortedDate == null) {
                throw new IllegalArgumentException("Be careful, your LocalDate is null. "
                        + "Correct the data");
            }
            if (hasMonthRequiredLetter(unsortedDate.getMonth())) {
                listWithLetter.add(unsortedDate);
            } else {
                listWithoutLetter.add(unsortedDate);
            }
        }

        List<LocalDate> sortedDates = new ArrayList<>(listWithLetter
                .stream()
                .sorted(Comparator.comparing(LocalDate::getMonth)
                        .thenComparing(LocalDate::getDayOfMonth))
                .toList());
        sortedDates.addAll(listWithoutLetter
                .stream()
                .sorted(Comparator.comparing(LocalDate::getMonth, Collections.reverseOrder())
                        .thenComparing(LocalDate::getDayOfMonth))
                .toList());
        return sortedDates;
    }

    private boolean hasMonthRequiredLetter(Month month) {
        return month.name().contains(String.valueOf(requiredLetter).toUpperCase());
    }
}
