package exercises;

import java.util.HashMap;
import java.util.Map;

public class SalesReport {

    private final Map<String, Double> salesMap = new HashMap<>();

    public void addSale(String productName, double amount) {
        if (amount < 0) {
            System.out.println("The sales amount cannot be less than 0");
        }

        if (salesMap.containsKey(productName)) {
            double currentAmount = salesMap.get(productName);
            salesMap.put(productName, currentAmount + amount);
        } else {
            salesMap.put(productName, amount);
        }
    }

    public void returnOfSale(String productName, double amount) {
        if (amount < 0) {
            System.out.println("The sales amount cannot be less than 0");
        }
        if (salesMap.containsKey(productName)) {
            double currentAmount = salesMap.get(productName);
            double newAmount = currentAmount - amount;

            if (newAmount <= 0) {
                salesMap.remove(productName);
            } else {
                salesMap.put(productName, newAmount);
            }
        }
    }

    public void removePosition(String productName) {
        salesMap.remove(productName);
    }

    @Override
    public String toString() {
        String result = "";

        if (salesMap.isEmpty()) {
            return "Отчет о продажах пуст";
        }

        for (String productName : salesMap.keySet()) {
            result += productName + ": " + salesMap.get(productName) + "\n";
        }

        return result;
    }
}
