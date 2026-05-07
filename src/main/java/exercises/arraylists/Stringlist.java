package exercises.arraylists;

import java.util.ArrayList;
import java.util.List;

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
}
