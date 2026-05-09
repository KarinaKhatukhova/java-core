package exercises.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Stringlist {

    public void getList() {
        List<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");

        System.out.println("Color list: " + colors);

    }

    public void getListWithSmallTitle() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");
        colors.add("Pink");
        colors.add("White");

        System.out.println("Source list: " + colors);

        for (int i = 0; i < colors.size(); i++) {
            String color = colors.get(i);
            if (color.length() > 3) {
                colors.set(i, color.substring(0, 3));
            }
        }

        System.out.println("Modified list: " + colors);

    }

    public void getOddList() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Black");
        colors.add("Violet");
        colors.add("Pink");
        colors.add("White");
        colors.add("Grey");
        colors.add("Brown");
        colors.add("Purple");
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


    public void getColorListProcessor() {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList(
                "Red", "Green", "Blue", "Yellow", "Purple"));
        System.out.println("Source list: " + colors);
        replaceBlueWithBlack(colors);
        System.out.println("Result: " + colors);
    }

    public static void replaceBlueWithBlack(ArrayList<String> colors) {
        if (colors.contains("Black")) {
            System.out.println("Color 'Black' is already in list. No replacement made.");
            return;
        }
        int indexOfBlue = colors.indexOf("Blue");
        if (indexOfBlue != -1) {
            colors.set(indexOfBlue, "Black");
            System.out.println("Color 'Blue' replaced with 'Black'.");
        }
        else {
            System.out.println("Color 'Blue' not found in the list.");
        }
    }

    public void getColorList() {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList(
                "Red", "Orange", "Yellow", "Green", "Black",
                "Blue", "Purple", "Pink", "Brown", "Gray"));
        System.out.println("Full list of colors: " + colors);
        System.out.println("Number of elements: " + colors.size());
        System.out.println();

        System.out.println("Elements 3 through 7:");
        printElementsFrom3rdTo7th(colors);
    }

    public static void printElementsFrom3rdTo7th(ArrayList<String> list) {
        if (list.size() < 7) {
            System.out.println("Error: There are less than 7 elements in the list.");
            return;
        }
        for (int i = 2; i <= 6; i++) {
            System.out.println((i + 1) + " element: " + list.get(i));
        }

    }


    public void getColorListMergerNoDuplicates() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(
                "Red", "Green", "Blue", "Yellow", "Purple"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(
                "Orange", "Blue", "Pink", "Red", "Brown"));
        System.out.println("First list: " + list1);
        System.out.println("Second list: " + list2);

        ArrayList<String> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        System.out.println("\nMerged list (with duplicates): " + mergedList);
        Collections.sort(mergedList);
        System.out.println("After sort (with duplicates): " + mergedList);

        LinkedHashSet<String> set = new LinkedHashSet<>(mergedList);
        ArrayList<String> uniqueSortedList = new ArrayList<>(set);
        System.out.println("After removing duplicates: " + uniqueSortedList);
    }


    public void getColorListComparator() {
        System.out.println("=== Test 1: The lists are completely identical ===");
        ArrayList<String> listA = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Blue"));
        ArrayList<String> listB = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Blue"));
        compareLists(listA, listB);

        System.out.println("\n=== Test 2: Different list lengths ===");
        ArrayList<String> listC = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        ArrayList<String> listD = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow"));
        compareLists(listC, listD);

        System.out.println("\n=== Test 3: Same Length, Different Elements (register) ===");
        ArrayList<String> listE = new ArrayList<>(Arrays.asList("Red", "Blue", "White"));
        ArrayList<String> listF = new ArrayList<>(Arrays.asList("Red", "Blue", "white"));
        compareLists(listE, listF);

        System.out.println("\n=== Test 4: Same Elements, Different Orders ===");
        ArrayList<String> listG = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        ArrayList<String> listH = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
        compareLists(listG, listH);

        System.out.println("\n=== Test 5: Arbitrary lists with duplicates ===");
        ArrayList<String> listI = new ArrayList<>(Arrays.asList("Red", "Blue", "Red", "Green", "Yellow"));
        ArrayList<String> listJ = new ArrayList<>(Arrays.asList("Red", "Blue", "Red", "Green", "Yellow"));
        compareLists(listI, listJ);
    }

    public static void compareLists(ArrayList<String> list1, ArrayList<String> list2) {
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        boolean sameLength = checkSameLength(list1, list2);
        boolean allElementsPresent = checkAllElementsPresent(list1, list2);
        boolean sameOrder = checkSameOrder(list1, list2);

        if (sameLength && allElementsPresent && sameOrder) {
            System.out.println("RESULT: The lists match");
        }
        else {
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

    private static boolean checkSameLength(ArrayList<String> list1, ArrayList<String> list2) {
        return list1.size() == list2.size();
    }

    private static boolean checkAllElementsPresent(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> tempList2 = new ArrayList<>(list2);

        for (String element : list1) {
            int index = tempList2.indexOf(element);
            if (index == -1) {
                return false;
            }
            tempList2.remove(index);
        }
        return true;
    }

    private static boolean checkSameOrder(ArrayList<String> list1, ArrayList<String> list2) {
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
