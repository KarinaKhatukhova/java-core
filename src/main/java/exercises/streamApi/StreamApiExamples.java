package exercises.streamApi;

import java.util.*;


public class StreamApiExamples {
    public static void main(String[] args) {
//        getAverage();
//        getStringToLowerCase();
//        getListWithoutRepeats();
//        getStringCounter();
//        getReverseList();
//        getFirstStringFromList();
//        getMapValues();
        getMapStringProcessing();


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

    /*
     *
     * Создайте List строк. Создайте статичный метод,
     * который считает количество строк,начинающихся с
     * конкретного символа, используя stream
     */
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

    /*
     * Создайте List целых чисел
     * Отсортируйте список в обратном порядке используя stream
     */
    public static void getReverseList() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6);
        System.out.println("Current: " + numbers);
        Collections.reverse(numbers);
        System.out.println("After reverse: " + numbers);
    }

    /*
     * Создайте List строк
     * Создайте статичный метод, который возвращает первую строку из списка,
     * начинающуюся с определенного набора символов. Используйте stream
     */
    public static String findFirstStartingWith(List<String> strings, String prefix) {
        if (strings == null || prefix == null || prefix.isEmpty()) {
            return null;
        }

        return strings.stream()
                .filter(s -> s != null && s.startsWith(prefix))
                .findFirst()
                .orElse(null);
    }

    public static void getFirstStringFromList() {
        List<String> stringList = Arrays.asList(
                "Apple",
                "Banana",
                "Apricot",
                "Cherry",
                "Avocado",
                "Blueberry"
        );

        String result = findFirstStartingWith(stringList, "Ap");
        System.out.println(result != null ? result : "String is not found");
    }

    /*
     *     Создайте Map<Integer, String> карту пар число - строка
     *     Извлеките все строковые значения из карты в список строк, используя stream
     */
    public static void getMapValues() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");
        map.put(5, "Elderberry");

        List<String> stringList = map.values()
                .stream()
                .toList();

        System.out.println("Current Map: " + map);
        System.out.println("List of strings: " + stringList);
    }

    /**
     * Создайте Map<Integer, String> карту пар число - строка
     * Создайте статичный метод, который принимает пару Integer и String.
     * Строку конвертирует в нижний регистр,
     * конкатенирует с полученным числом по шаблону "<число> <строка> четная"
     * и выводит результат на экран
     * Создайте статичный метод, который принимает пару Integer и String.
     * Строку конвертирует в верхний регистр,
     * конкатенирует с полученным числом по шаблону "<строка> <число> нечетная"
     * и выводит результат на экран
     * Используя stream, лямбда функции и созданные методы конвертации строк обработайте карту
     * по правилу:
     * 1) Если ключ мапы - четное значение,
     * подать такую пару ключ - значение в метод конвертации в нижний регистр
     * 2) Если ключ мапы - нечетное значение,
     * подать такую пару ключ - значение в метод конвертации в верхний регистр
     * 3) Если ключу не присвоено значение (null или пустая строка),
     * то вывести "Ключу <ключ> не присвоено значение"
     */

    public static void processEvenKey(Integer number, String text) {
        if (text == null) {
            text = "";
        }
        String lowerCaseText = text.toLowerCase();
        String result = number + " " + lowerCaseText;
        System.out.println(result);
    }

    public static void processOddKey(Integer number, String text) {
        if (text == null) {
            text = "";
        }
        String upperCaseText = text.toUpperCase();
        String result = number + " " + upperCaseText;
        System.out.println(result);
    }

    public static void getMapStringProcessing() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "apple");
        map.put(2, "banana");
        map.put(3, "cherry");
        map.put(4, "date");
        map.put(5, null);
        map.put(6, "");
        map.put(7, "grape");
        map.put(8, "  hello  ");

        System.out.println("=== Map processing ===\n");

        map.entrySet().stream()
                .forEach(entry -> {
                    Integer key = entry.getKey();
                    String value = entry.getValue();

                    if (value == null || value.trim().isEmpty()) {
                        System.out.println("Key " + key + " has no value assigned");
                    } else {
                        if (key % 2 == 0) {
                            processEvenKey(key, value);
                        } else {
                            processOddKey(key, value);
                        }
                    }
                });
    }
}

