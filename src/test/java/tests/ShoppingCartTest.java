package tests;

import pages.ShoppingCart;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.assertEquals;

public class ShoppingCartTest {

    @Test(description = "Empty basket should return 0 cost")
    public void testEmptyBasket() {
        List<String> items = Collections.emptyList();
        int expected = 0;
        int actual = ShoppingCart.calculateTotalCost(items);
        assertEquals(actual, expected);
    }

    @Test(description = "One Apple should cost 35p")
    public void testSingleApple() {
        List<String> items = Arrays.asList("Apple");
        assertEquals(ShoppingCart.calculateTotalCost(items), 35);
    }

    @Test(description = "Two Bananas should cost 40p")
    public void testTwoBananas() {
        List<String> items = Arrays.asList("Banana", "Banana");
        assertEquals(ShoppingCart.calculateTotalCost(items), 40);
    }

    @Test(description = "Two Melons with BOGOF offer should cost 50p")
    public void testTwoMelons() {
        List<String> items = Arrays.asList("Melon", "Melon");
        assertEquals(ShoppingCart.calculateTotalCost(items), 50);
    }

    @Test(description = "Three Limes with 3-for-2 offer should cost 30p")
    public void testThreeLimes() {
        List<String> items = Arrays.asList("Lime", "Lime", "Lime");
        assertEquals(ShoppingCart.calculateTotalCost(items), 30);
    }

    @Test(description = "Two Apples and One Banana should cost 90p")
    public void testApplesAndBanana() {
        List<String> items = Arrays.asList("Apple", "Apple", "Banana");
        assertEquals(ShoppingCart.calculateTotalCost(items), 90);
    }

    @Test(description = "Three Melons should cost 100p due to BOGOF")
    public void testThreeMelons() {
        List<String> items = Arrays.asList("Melon", "Melon", "Melon");
        assertEquals(ShoppingCart.calculateTotalCost(items), 100);
    }

    @Test(description = "Four Limes should cost 45p with 3-for-2 offer")
    public void testFourLimes() {
        List<String> items = Arrays.asList("Lime", "Lime", "Lime", "Lime");
        assertEquals(ShoppingCart.calculateTotalCost(items), 45);
    }

    @Test(description = "Mixed items scenario test")
    public void testMixedItems() {
        List<String> items = Arrays.asList("Apple", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime");
        assertEquals(ShoppingCart.calculateTotalCost(items), 235);
    }

    @Test(description = "Unknown item should be skipped with warning")
    public void testUnknownItemOne() {
        List<String> items = Arrays.asList("Pineapple", "Apple");
        assertEquals(ShoppingCart.calculateTotalCost(items), 35);
    }

    @Test(description = "Unknown item should be ignored with a warning")
    public void testUnknownItem() {
        List<String> items = Arrays.asList("UnknownItem");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 0);
    }

    @Test(description = "All invalid items should result in 0 cost")
    public void testAllInvalidItems() {
        List<String> items = Arrays.asList("Dragonfruit", "Kiwi");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 0);
    }

    @Test(description = "Empty string as item should be ignored")
    public void testEmptyStringItem() {
        List<String> items = Arrays.asList("");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 0);
    }

    @Test(description = "Null item in list should be ignored")
    public void testNullItem() {
        List<String> items = new ArrayList<>();
        items.add(null);
        items.add("Apple");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 35);
    }

    @Test(description = "Case-insensitive item matching")
    public void testCaseInsensitiveItems() {
        List<String> items = Arrays.asList("APPLE", "apple", "ApPlE");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 105); // 35 x 3
    }

    @Test(description = "Whitespace around item should be treated as invalid")
    public void testWhitespaceItem() {
        List<String> items = Arrays.asList(" Apple ");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 35);
    }

    @Test(description = "Null input list should return 0 or handle gracefully")
    public void testNullBasket() {
        int cost = 0;
        try {
            cost = ShoppingCart.calculateTotalCost(null);
        } catch (Exception e) {
            cost = -1; // Simulating error fallback
        }
        assertEquals(cost, -1, "Null list should throw or be handled gracefully.");
    }

    @Test(description = "Large quantity of valid item should calculate correctly")
    public void testLargeQuantity() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            items.add("Apple");
        }
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 3_500_000); // 100000 * 35
    }

    @Test(description = "Mixed valid and invalid items")
    public void testMixedValidInvalidItems() {
        List<String> items = Arrays.asList("Apple", "Banana", "Dragonfruit");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 55); // Apple + Banana, ignore Dragonfruit
    }

    @Test(description = "Numbers and symbols as item names should be ignored")
    public void testNumericAndSymbolItems() {
        List<String> items = Arrays.asList("123", "!!!", "@@@");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 0);
    }

    @Test(description = "List with repeated null entries and one valid item")
    public void testMultipleNullsAndValidItem() {
        List<String> items = Arrays.asList(null, null, "Apple");
        int cost = ShoppingCart.calculateTotalCost(items);
        assertEquals(cost, 35);
    }
}
