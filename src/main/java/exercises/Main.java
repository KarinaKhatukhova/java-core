package exercises;

import java.util.HashMap;

/**
 * Отчет продаж магазина (вставте данный текст себе IDEA) над методом<p>
 * 1. Создайте HashMap<String, Integer> и добавьте туда список товаров и сумму продаж<p>
 * 2. Вбейте в idea - iter выберите что предложит idea (итерацию по созданному выше HashMap в методе где вы вбили iter). Вывести в консоль результат по каждому товару в терминал<p>
 * 3. Добавье по названию из map новую позицию<p>
 * 4. Модифицируйте по названию из map существующую позицию (прибавление вычитание)<p>
 * 5. Удалите по названию из map позицию<p>
 * 6. Изучите метод Map containsKey("тут ваше значение") почитайте что он возвращает, подумайте где может понадобиться и добавьте<p>
 * *7. Задача на рефакторинг кода. Вынесите всё взаимодействие с этим map в класс SalesReport <p>
 * Создайте методы в классе SalesReport, которые будут модифицировать Map:<p>
 * - добавления продажи (находит название товара и прибавляет к имеющемуся либо создает новую позицию)<p>
 * - вычитание продажи (сделали возврат товара надо вычесть из отчета сумму на которую было продано товаров по данной позиции)<p>
 * - удаление позиции (например её ошибочно внесли и необходиму удалить эту позицию)<p>
 * - отчет по продажам (переопределить метод toString которвый выведет позицию и числовое значение)<p>
 * *- опционально добавье возможность хранения удаленных и вовзратов по позициям товаров в отчет toString <p>
 */

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> salesMap = new HashMap<>();
        salesMap.put("Notebooks", 150000);
        salesMap.put("Smartphones", 85000);
        salesMap.put("Headphones", 12000);
        salesMap.put("Monitors", 34000);
        salesMap.put("Microwave", 55000);

        String item = "Smartphones";
        if (salesMap.containsKey(item)) {
            System.out.println("\nThe position exists \nPosition value: " + salesMap.get(item));

            int newPrice = salesMap.get(item) + 50000;
            salesMap.put(item, newPrice);

            System.out.println("New position value: " + salesMap.get(item));

            boolean isRemoved = salesMap.remove(item, newPrice);
            System.out.println("Position \"" + item + "\" deleted");

            if (!isRemoved) {
                System.out.println("Deletion failed: the position is missing.");
            }

        } else {
            System.out.println("Position not found");
        }
    }
}