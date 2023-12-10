package com.lesson.one;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		List<Item> inventory = Arrays.asList(
				new Item("apple", 9.99),
				new Item("orange", 7.99),
				new Item("watermelon", 11.99),
				new Item("apple", 9.99),
				new Item("apple", 9.99),
				new Item("orange", 7.99),
				new Item("lemon", 6.99),
				new Item("apple", 9.99),
				new Item("watermelon", 11.99),
				new Item("papaya", 11.99),
				new Item("banana", 9.99)
		);
		System.out.println("Inventory: " + inventory);
		System.out.println("Grouping Using Loops: " + groupByPrice(inventory));

	}
	// Group by Using Loops
	private static Map<Double, List<Item>> groupByPrice(List<Item> inventory) {
		Map<Double, List<Item>> result = new HashMap<>();
		for (Item item : inventory) {
			if(!result.containsKey(item.getPrice())) {
				List<Item> values = new ArrayList<>();
				values.add(item);
				result.put(item.getPrice(), values);
			} else {
				result.get(item.getPrice()).add(item);
			}
		}
		return result;
	}
}
