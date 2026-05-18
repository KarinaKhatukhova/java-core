package exercises.arraylists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class StringList {

    public static void getList(List<String> colors) {
        System.out.println("Color list: " + colors);
    }

    public static void runListWithSmallTitle(List<String> colors) {
        System.out.println("Source list: " + colors);

        for (int i = 0; i < colors.size(); i++) {
            String color = colors.get(i);
            if (color.length() > 3) {
                colors.set(i, color.substring(0, 3));
            }
        }

        System.out.println("Modified list: " + colors);
    }

    public static void runOddList(List<String> colors) {
        System.out.println("Source list (" + colors.size() + " elements):");
        System.out.println(colors);

        for (int i = colors.size() - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                colors.remove(i);
            }
        }

        System.out.println("\nModified list (" + colors.size() + " elements):");
        System.out.println(colors);
    }


    public static void runColorListProcessor(List<String> colors) {
        System.out.println("Source list: " + colors);
        replaceBlueWithBlack(colors);
        System.out.println("Result: " + colors);
    }

    public static void replaceBlueWithBlack(List<String> colors) {
        if (colors.contains("Black")) {
            System.out.println("Color 'Black' is already in list. No replacement made.");
            return;
        }
        int indexOfBlue = colors.indexOf("Blue");
        if (indexOfBlue != -1) {
            colors.set(indexOfBlue, "Black");
            System.out.println("Color 'Blue' replaced with 'Black'.");
        } else {
            System.out.println("Color 'Blue' not found in the list.");
        }
    }

    public static void runColorList(List<String> colors) {
        System.out.println("Full list of colors: " + colors);
        System.out.println("Number of elements: " + colors.size());
        System.out.println();

        System.out.println("Elements 3 through 7:");
        printElementsFrom3rdTo7th(colors);
    }

    public static void printElementsFrom3rdTo7th(List<String> colors) {
        if (colors.size() < 7) {
            System.out.println("Error: There are less than 7 elements in the list.");
            return;
        }
        for (int i = 2; i <= 6; i++) {
            System.out.println((i + 1) + " element: " + colors.get(i));
        }
    }


    public static void runColorListMergerNoDuplicates(List<String> colors) {

        List<String> list1 = new ArrayList<>(colors);
        List<String> list2 = new ArrayList<>(colors);

        System.out.println("First list: " + list1);
        System.out.println("Second list: " + list2);

        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        System.out.println("\nMerged list (with duplicates): " + mergedList);
        Collections.sort(mergedList);
        System.out.println("After sort (with duplicates): " + mergedList);

        LinkedHashSet<String> set = new LinkedHashSet<>(mergedList);
        List<String> uniqueSortedList = new ArrayList<>(set);
        System.out.println("After removing duplicates: " + uniqueSortedList);
    }


    public static void runColorListComparator(List<String> colors) {

        System.out.println("=== Test 1: The lists are completely identical ===");
        List<String> listA = new ArrayList<>(colors);
        List<String> listB = new ArrayList<>(colors);
        compareLists(listA, listB);

        System.out.println("\n=== Test 2: Different list lengths ===");
        List<String> listC = new ArrayList<>(colors);
        List<String> listD = new ArrayList<>(colors);
        compareLists(listC, listD);

        System.out.println("\n=== Test 3: Same Length, Different Elements (register) ===");
        List<String> listE = new ArrayList<>(colors);
        List<String> listF = new ArrayList<>(colors);
        compareLists(listE, listF);

        System.out.println("\n=== Test 4: Same Elements, Different Orders ===");
        List<String> listG = new ArrayList<>(colors);
        List<String> listH = new ArrayList<>(colors);
        compareLists(listG, listH);

        System.out.println("\n=== Test 5: Arbitrary lists with duplicates ===");
        List<String> listI = new ArrayList<>(colors);
        List<String> listJ = new ArrayList<>(colors);
        compareLists(listI, listJ);
    }

    public static void compareLists(List<String> list1, List<String> list2) {
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        boolean sameLength = checkSameLength(list1, list2);
        boolean allElementsPresent = checkAllElementsPresent(list1, list2);
        boolean sameOrder = checkSameOrder(list1, list2);

        if (sameLength && allElementsPresent && sameOrder) {
            System.out.println("RESULT: The lists match");
        } else {
            System.out.println("RESULT: The lists do NOT match");
            System.out.println("Failed tests:");
            if (!sameLength) {
                System.out.println("  - Equal length lists");
            }
            if (!allElementsPresent) {
                System.out.println("  - All elements of the first list are present in the second " +
                        "(regardless of order)");
            }
            if (!sameOrder) {
                System.out.println("  - The elements match in order and indices");
            }
        }
        System.out.println("---");
    }

    private static boolean checkSameLength(List<String> list1, List<String> list2) {
        return list1.size() == list2.size();
    }

    private static boolean checkAllElementsPresent(List<String> list1, List<String> list2) {
        List<String> tempList2 = new ArrayList<>(list2);

        for (String element : list1) {
            int index = tempList2.indexOf(element);
            if (index == -1) {
                return false;
            }
            tempList2.remove(index);
        }
        return true;
    }

    private static boolean checkSameOrder(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
