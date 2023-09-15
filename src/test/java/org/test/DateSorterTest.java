package org.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateSorterTest {
    private static final char REQUIRED_LETTER = 'r';
    private static DateSorter dateSorter;
    private static List<LocalDate> unsortedDate;
    private static Collection<LocalDate> result;
    private static List<LocalDate> sortedList;
    private static List<LocalDate> notNormalList;
    private static List<LocalDate> nullList;

    @BeforeAll
    static void beforeAll() {
        dateSorter = new DateSorter(REQUIRED_LETTER);
        result = new ArrayList<>();

        unsortedDate = new ArrayList<>();
        unsortedDate.add(LocalDate.of(2005, 07, 01));
        unsortedDate.add(LocalDate.of(2005, 01, 02));
        unsortedDate.add(LocalDate.of(2005, 01, 01));
        unsortedDate.add(LocalDate.of(2005, 05, 03));

        sortedList = new ArrayList<>();
        sortedList.add(LocalDate.of(2005, 1, 1));
        sortedList.add(LocalDate.of(2005, 1, 2));
        sortedList.add(LocalDate.of(2005, 7, 1));
        sortedList.add(LocalDate.of(2005, 5, 3));

        nullList = null;

        notNormalList = new ArrayList<>();
        notNormalList.add(null);
    }

    @Test
    void sortDatesWithNormalSortedList_Ok() {
        result = dateSorter.sortDates(unsortedDate);
        assertEquals(result, sortedList);
    }

    @Test
    void sortDatesWithNullList_NotOk() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
            dateSorter.sortDates(nullList);
            }, "IllegalArgumentException is awaiting");
        assertEquals(exception.getMessage(), "Be careful, your list is null. " +
                "Correct the data");
    }

    @Test
    void sortDatesWithNullItemsInList_NotOk() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    dateSorter.sortDates(notNormalList);
                }, "IllegalArgumentException is awaiting");
        assertEquals(exception.getMessage(),"Be careful, your LocalDate is null. " +
                "Correct the data");
    }
}