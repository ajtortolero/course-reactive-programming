package com.reactive.lesson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
	public static void main(String[] args) {
		Function<Integer, Function<Integer, Integer>> suma = x -> y -> x + y;

		int resultado = suma.apply(5).apply(7);
		System.out.println("La suma es: " + resultado);

		List<String> list = Arrays.asList("Zebra", "Apple", "Banana", "Orange");

		Collections.sort(list, String::compareTo);

		System.out.println("Lista ordenada alfabéticamente: " + list);

		Predicate<Integer> esPrimo = n -> n > 1 && java.util.stream.IntStream.range(2, n).noneMatch(i -> n % i == 0);

		int number = 11;
		if (esPrimo.test(number)) {
			System.out.println(number + " es un número primo.");
		} else {
			System.out.println(number + " no es un número primo.");
		}

		Predicate<String> isPalindrome = s -> s.equals(new StringBuilder(s).reverse().toString());

		String word = "radar";
		if (isPalindrome.test(word)) {
			System.out.println(word + " es un palíndromo.");
		} else {
			System.out.println(word + " no es un palíndromo.");
		}
	}
}
