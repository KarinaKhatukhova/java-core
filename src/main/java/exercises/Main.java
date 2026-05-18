package exercises;

import exercises.arraylists.Color;
import exercises.arraylists.StringList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static exercises.hashMap.MyStore.getSales;

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

//        StringList.getList(colors);
//        StringList.runListWithSmallTitle(colors);
//        StringList.runOddList(colors);
//        StringList.runColorListProcessor(colors);
//
//        StringList.runColorList(colors);
//        StringList.runColorListMergerNoDuplicates(colors);
//        StringList.runColorListComparator(colors);

        HashMap<String, Integer> salesMap = new HashMap<>();
        salesMap.put("Notebooks", 150000);
        salesMap.put("Smartphones", 85000);
        salesMap.put("Headphones", 12000);
        salesMap.put("Monitors", 34000);

        getSales(salesMap);
    }
}