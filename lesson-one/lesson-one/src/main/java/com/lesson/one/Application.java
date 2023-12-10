package com.lesson.one;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
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
		System.out.println("Grouping Using Sets: " + groupByPriceSet(inventory));
		System.out.println("Grouping Using Sets: " + groupByPriceStream(inventory));

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

	// Group by Using Sets
	private static Map<Double, Set<String>> groupByPriceSet(List<Item> inventory) {
		Map<Double, Set<String>> result = new HashMap<>();
		for (Item item : inventory) {
			if(!result.containsKey(item.getPrice())) {
				Set<String> values = new HashSet<>();
				values.add(item.getName());

				result.put(item.getPrice(), values);
			} else {
				result.get(item.getPrice()).add(item.getName());
			}
		}
		return result;
	}
	// Group by Using Stream
	private static Map<Double, Set<String>> groupByPriceStream(List<Item> inventory) {
		return inventory.stream()
				.collect(Collectors.groupingBy(Item::getPrice,
						Collectors.mapping(Item::getName, Collectors.toSet())));
	}
}
