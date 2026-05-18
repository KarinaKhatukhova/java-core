package exercises;

import exercises.arraylists.Color;
import exercises.arraylists.StringList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add(String.valueOf(Color.Red));
        colors.add(String.valueOf(Color.Blue));
        colors.add(String.valueOf(Color.Green));
        colors.add(String.valueOf(Color.Yellow));
        colors.add(String.valueOf(Color.Black));
        colors.add(String.valueOf(Color.Pink));
        colors.add(String.valueOf(Color.White));

        StringList.getList(colors);
//        StringList.runListWithSmallTitle(colors);
//        StringList.runOddList(colors);
//        StringList.runColorListProcessor(colors);
//
//        StringList.runColorList(colors);
//        StringList.runColorListMergerNoDuplicates(colors);
//        StringList.runColorListComparator(colors);
    }
}