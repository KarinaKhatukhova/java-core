package exercises.streamApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamApiExamples {
    public static void main(String[] args) {

//        getAverage();
//        getStringToLowerCase();
//        getListWithoutRepeats();
//        StringCounter.getStringCounter();
          getReverseList();


    }
//    Создайте List целых чисел. Посчитайте среднее значение используя stream

    public static void getAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int average = (int) numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("Average value: " + average);
    }
//  Создайте List строк. Переведите все строки из списка в нижний регистр, используя stream

    public static void getStringToLowerCase() {
        List<String> strings = Arrays.asList("Hello", "WORLD", "Java", "STREAM", "API");

        List<String> lowerCaseStrings = strings.stream()
                .map(String::toLowerCase)
                .toList();

        System.out.println("Current list: " + strings);
        System.out.println("Lower case list: " + lowerCaseStrings);
    }

//    Создайте List целых чисел, включающий повторения. Удалите повторы из списка используя stream

    public static void getListWithoutRepeats() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3, 6, 4, 7, 5);

        System.out.println("Current list: " + numbers);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        System.out.println("List without repeats: " + uniqueNumbers);

    }

//    Создайте List строк. Создайте статичный метод,
//    который считает количество строк,начинающихся с конкретного символа, используя stream

    public static class StringCounter {

        public static long countStringsStartingWith(List<String> strings, char prefix) {
            return strings.stream()
                    .filter(s -> s != null && !s.isEmpty())
                    .filter(s -> s.charAt(0) == prefix)
                    .count();
        }

        public static void getStringCounter() {
            List<String> strings = Arrays.asList("Apple", "Banana", "Apricot", "Cherry",
                    "Avocado", "Blueberry", "Orange", "Apple");

            long countA = countStringsStartingWith(strings, 'A');
            System.out.println("Number of lines starting with 'A': " + countA); // 3
        }

    }

//    Создайте List целых чисел
//    Отсортируйте список в обратном порядке используя stream

    public static void getReverseList() {

            List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6);

            System.out.println("Current: " + numbers);

        Collections.reverse(numbers);

        System.out.println("After reverse: " + numbers);
        }
    }

