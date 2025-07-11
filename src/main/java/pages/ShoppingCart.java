package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    public static int calculateTotalCost(List<String> items) {

        if (items == null) {
            throw new IllegalArgumentException("Basket cannot be null");
        }

        Map<String, Integer> itemCount = new HashMap<>();

        for (String item : items) {
            if (item == null || item.trim().isEmpty()) {
                System.out.println("Invalid item: null or empty");
                continue;
            }

            String cleanItem = item.trim().toLowerCase();
            itemCount.put(cleanItem, itemCount.getOrDefault(cleanItem, 0) + 1);
        }

        int total = 0;
        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();

            switch (item) {
                case "apple":
                    total += count * 35;
                    break;
                case "banana":
                    total += count * 20;
                    break;
                case "melon":
                    total += ((count / 2) + (count % 2)) * 50;
                    break;
                case "lime":
                    total += ((count / 3) * 2 + (count % 3)) * 15;
                    break;
                default:
                    System.out.println("Unknown item: " + item);
            }
        }

        return total;
    }
}


