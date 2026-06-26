package exercises;

import java.util.HashMap;
import java.util.Map;

public class SalesReport {

    private final Map<String, Double> salesMap = new HashMap<>();

    public void addSale(String productName, double amount) {
        failIfNegative(amount);

        if (salesMap.containsKey(productName)) {
            double currentAmount = salesMap.get(productName);
            salesMap.put(productName, currentAmount + amount);
        } else {
            salesMap.put(productName, amount);
        }
    }

    public void cancelSale(String productName, double amount) {
        failIfNegative(amount);

        if (salesMap.containsKey(productName)) {
            double currentAmount = salesMap.get(productName);

            if (amount > currentAmount) {
                throw new RuntimeException("Cannot cancel for amount > current amount");
            }

            double newAmount = currentAmount - amount;
            salesMap.put(productName, newAmount);
        } else {
            throw new IllegalArgumentException("Product not found in sales");
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

    private void failIfNegative(double amount) {
        if (amount < 0) {
            throw new RuntimeException("The sales amount cannot be less than 0");
        }
    }
}
