/**
 * This program is the homework1 for CSE 143 2017Summer
 * Written by: Su Wang, enrolled in quiz session AC, Student ID: 1627344 
 * LetterInventory is a list integers, each stores the value of the number of a
 * letter's appearance in a given string. Each value represents a letter in
 * alphabetic sequence.
 */
public class LetterInventory {
	private int[] elementData;
	private int size;
	public static final int INVENTORY_CAPACITY = 26;
	
	/**
	 * Constructs an initial LetterInventory with capacity of 26 to represent
	 * each letter in alphabet with each counts equals zero;
	 */
	public LetterInventory() {
		this("");
	}

	/**
	 * The constructor takes a string of data as the parameter to construct an
	 * initial LetterInventory with each number represents the counts of letter
	 * in data given.
	 * 
	 * @param data
	 *            can be a string of data, uppercase and lowercase will be
	 *            treated as same, non-alphabetic characters will be ignored.
	 */
	public LetterInventory(String data) {
		elementData = new int[INVENTORY_CAPACITY];
		size = 0;
		int index;
		for (int i = 0; i < data.length(); i++) {
			int charToInteger = (char) data.charAt(i);
			// to eliminate the non-alphabetic characters.
			if ((charToInteger <= 'z' & charToInteger >= 'a') || (charToInteger <= 'Z' & charToInteger >= 'A')) {
				index = getIndex(data.charAt(i));
				elementData[index]++;
				size++;
			}
		}
	}

	/**
	 * Gets the size of the inventory.
	 * 
	 * @return the sum of all the counts in the inventory.
	 */
	public int size() {
		return size;
	}

	/**
	 * Examines if the list is empty or not.
	 * 
	 * @return True if the inventory is empty, return False if not.
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the number of times the given letter appears in the inventory.
	 * 
	 * @param letter
	 *            should be an alphabetic character, can be either lowercase of
	 *            uppercase, throws IllegalArgumentException if violated.
	 * @returns an integer, which is the number of times the given letter
	 *          appears in the inventory.
	 */
	public int get(char letter) {
		int index = getIndex(letter);
		return elementData[index];
	}

	/**
	 * Returns a String representation of the inventory with all the letters in
	 * lowercases, in sorted order, and surrounded by square brackets The
	 * returned string is in lower case.
	 */
	public String toString() {
		String allLetters = "";
		for (int i = 0; i < elementData.length; i++) {
			if (elementData[i] != 0) {
				for (int j = 1; j <= elementData[i]; j++) {
					allLetters += (char) (i + 'a');// prints out the string in
													// lower cases
				}
			}
		}
		return ("[" + allLetters + "]");
	}

	/**
	 * Sets the count for the given letter to the given value.
	 * 
	 * @param letter
	 *            should be an alphabetic letter. Lowercase or in uppercase will
	 *            be treated as same, wil throw IllegalArgumentException if a
	 *            non-alphabetic character is passed.
	 * @param value
	 *            should be an integer greater than or equal to zero, will throw
	 *            IllegalArgumentException if violated.
	 */
	public void set(char letter, int value) {

		int indexOfList = getIndex(letter);
		if (elementData[indexOfList] > value) {
			size -= elementData[indexOfList] - value;// size change equals the
														// difference of the
														// change in value.
		} else if (elementData[indexOfList] < value) {
			size += value - elementData[indexOfList];
		}
		elementData[indexOfList] = value;
	}

	/**
	 * Constructs and returns a new LetterInventory object that represents the
	 * sum of LetterInventory and the other given LetterInventory. 
	 * Returns a
	 * LetterInventory with each count equals to the sum of the two respective
	 * counts in the two LetterInventory. The two LetterInventory being added
	 * will not be changed by this method.
	 * 
	 * @param other
	 *            should be a LetterInventory
	 * @returns a new LetterInventory with each counts represents the sum of the
	 *          respective two counts in the LetterInventory and the given
	 *          inventory.
	 */
	public LetterInventory add(LetterInventory other) {
		LetterInventory list = new LetterInventory();
		for (int i = 0; i < INVENTORY_CAPACITY; i++) {
			list.elementData[i] = this.elementData[i] + other.elementData[i];// add
																				// up
		}
		return list;
	}

	/**
	 * Constructs and returns a new LetterInventory object that represents the
	 * difference of LetterInventory and the other given LetterInventory. The
	 * two Inventories being subtracted will not be changed via this method.
	 * 
	 * @param other
	 *            should be a LetterInventory
	 * @returns new LetterInventory with each count equals to the result after
	 *          subtract the count in the given Inventory from the respective
	 *          count in the LetterInventory returns null if any single count
	 *          result is a negative number.
	 */
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory subtractResult = new LetterInventory();
		for (int i = 0; i < INVENTORY_CAPACITY; i++) {
			subtractResult.elementData[i] = this.elementData[i] - other.elementData[i];
			if (subtractResult.elementData[i] < 0) {
				return null;
			}
		}
		return subtractResult;
	}

	/**
	 * Calculates the percentage of the number of appearance for the given
	 * letter in this inventory.
	 * 
	 * @param letter
	 *            should be a alphabetic character in either lower case or upper
	 *            case. Throws IllegalArgumentException if non-alphabetic
	 *            character is passed.
	 * @returns a decimal number with one decimal point, which represents the
	 *          percentage of the given letter appeared in the LetterInventory.
	 */
	public double getLetterPercentage(char letter) {
		double size = size();
		double numbersOfLetter = get(letter);
		double percentage = numbersOfLetter / size;
		return percentage;
	}

	/**
	 * Gets the index of the item (which is the number of times the given letter
	 * appears) in the LetterInventory List. the index value is calculated as
	 * the numeric order of the given letter in the alphabetic list. For
	 * example, if you pass a you will get 1; if you pass z you will get 26.
	 * 
	 * @param letter
	 *            should be an alphabetic character, in either lower or upper
	 *            case, throws IllegalArgumentException if violated.
	 * @returns an integer, which is the index number in the LetterInventory
	 *          list the given letter represents
	 */
	private int getIndex(char letter) {
		int letterToInteger = letter;
		int index;
		if (letterToInteger <= 'z' & letterToInteger >= 'a') {// lower case
			index = letterToInteger - 'a';
		} else if (letterToInteger <= 'Z' & letterToInteger >= 'A') {// upper
																		// case
			index = letterToInteger - 'A';
		} else {
			throw new IllegalArgumentException();
		}
		return index;
	}
}
