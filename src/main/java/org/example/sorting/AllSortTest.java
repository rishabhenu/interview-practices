package org.example.sorting;

import org.example.util.MapBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AllSortTest {

    public static void main(String[] args) {
        Map<String, Consumer<int[]>> sortingAlgorithms = MapBuilder.<String, Consumer<int[]>>builder()
            .put("Insertion Sort", InsertionSort::insertionSort)
            .put("BubbleSort", BubbleSort::bubbleSort)
            .put("Selection Sort", SelectionSort::selectionSort)
            .build();
        sortingAlgorithms.forEach((name, algo) -> {
            int[] array = new int[]{1, -1, 10, 10, 1, 20, 100, 5};
            int[] original = new int[]{-1, 1, 1, 5, 10, 10, 20, 100};
            algo.accept(array);
            for (int i = 0; i < array.length; i++) {
                if (array[i] != original[i]) {
                    System.out.println(name + " failed!");
                    return;
                }
            }
            System.out.println(name + " success");
        });

    }


}
