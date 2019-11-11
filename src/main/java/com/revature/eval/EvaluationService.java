package com.revature.eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		if (string == null) return null;
		
		String result = "";
		
		for (int i = string.length() - 1; i >= 0; i--) {
			result += string.charAt(i);
		}
		return result;
	}

	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		if (phrase == null) return null;

		String result = "";
		
		String[] arr = phrase.split("\\s|-");
		for (int i = 0; i < arr.length; i++) {
			result += arr[i].charAt(0);
		}
		return result.toUpperCase();
	}
	
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int result = 0;
		
		for (int i = 0; i < string.length(); i++) {
			
			String s = string.substring(i, i+1);
			
			if (s.matches("(?i)a|e|i|o|u|l|n|r|s|t")) {
				result += 1;
			} else if (s.matches("(?i)d|g")) {
				result += 2;
			} else if (s.matches("(?i)b|c|m|p")) {
				result += 3;
			} else if (s.matches("(?i)f|h|v|w|y")) {
				result += 4;
			} else if (s.matches("(?i)k")) {
				result += 5;
			} else if (s.matches("(?i)j|x")) {
				result += 8;
			} else if (s.matches("(?i)q|z")) {
				result += 10;
			}
		}
		return result;
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] arr = string.split("\\s|,\n|,");
		HashMap<String, Integer> wordMap = new HashMap<> ();
		
		for (String str: arr) {
			if (wordMap.containsKey(str)) {
				
				int count = wordMap.get(str);
				wordMap.put(str, ++count);
				
			} else {
				wordMap.put(str, 1);
			}
		}
		return wordMap;
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int left = 0;
			int right = sortedList.size();
			int mid = (left + right)/2;
			
			while (left < right) {
				
				T current = sortedList.get(mid);
				
				if (comparator(current, t) == 0) {
					return mid;
				} // else if (t < current) {
				else if (comparator(current, t) > 0) {
					right = mid;
				} else {
					left = mid;
				}
				
				mid = (left + right)/2;
			}
			return -1;
		}
		
		public int comparator(T t1, T t2) {
			if (t1 instanceof Number) {
				return Integer.parseInt(t1.toString()) - Integer.parseInt(t2.toString());
			} else if (t1 instanceof String) {
				return t1.toString().compareTo(t2.toString());
			}
			
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}
