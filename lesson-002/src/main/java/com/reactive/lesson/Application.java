package com.reactive.lesson;

import com.reactive.lesson.interfaces.Adder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Application {
	public static void main(String[] args) {
		Adder adder = (a, b) -> a + b;

		int resultado1 = adder.add(5, 7);
		int resultado2 = adder.add(10, -3);

		System.out.println("Resultado 1: " + resultado1);
		System.out.println("Resultado 2: " + resultado2);

		List<String> listOne = new ArrayList<>();
		listOne.add("Apple");
		listOne.add("Banana");
		listOne.add("Cherry");

		Collections.sort(listOne, (a, b) -> a.compareTo(b));
		for (String s : listOne) {
			System.out.println(s);
		}

		List<String> listTwo = new ArrayList<>();
		listOne.add("Apple");
		listOne.add("Banana");
		listOne.add("Cherry");

		Collections.sort(listTwo, String::compareTo);

		for (String s : listTwo) {
			System.out.println(s);
		}

		int number = 17;
		IntPredicate esPrimo = n -> {
			if (n <= 1) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		};

		if (esPrimo.test(number)) {
			System.out.println(number + " es primo.");
		} else {
			System.out.println(number + " no es primo.");
		}

		List<String> listPalindrome = new ArrayList<>();
		listPalindrome.add("radar");
		listPalindrome.add("banana");
		listPalindrome.add("cherry");

		Predicate<String> isPalindrome = s -> {
			String stringFormat = s.replaceAll("\\s+", "").toLowerCase();
			return new StringBuilder(stringFormat).reverse().toString().equals(stringFormat);
		};

		for (String s : listPalindrome) {
			if (isPalindrome.test(s)) {
				System.out.println("\"" + s + "\" es un palíndromo.");
			} else {
				System.out.println("\"" + s + "\" no es un palíndromo.");
			}
		}
	}
}
