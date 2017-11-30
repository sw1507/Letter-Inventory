//
//public class LetterInventory {
//	 private int[] elementData;
//	 public static final int INVENTORY_CAPACITY = 26;
//	 
//	 public LetterInventory() {
//	        elementData = new int[INVENTORY_CAPACITY];
//	        
//	
//	    }
//
//	 
//public LetterInventory(String data ){
//		 elementData = new int[INVENTORY_CAPACITY]; 
//		 for(int i = 0; i < data.length(); i ++){ 
//			 int charToInteger = (char) data.charAt(i);
//			 if (charToInteger <= 122 & charToInteger >= 97 ){
//				 elementData[charToInteger - 97] += 1;
//			 }else if(charToInteger <= 90 & charToInteger >= 65){
//				 elementData[charToInteger - 65] += 1;
//			 } 	
//		 }	
//}
//
//public int size(){	
//		 int size = 0;
//		 for(int i = 0; i < INVENTORY_CAPACITY; i ++){
//			 size += elementData[i];
//		 }
//		 return size;
//	 }
//	 
//	 public boolean isEmpty(){
//		 if (size() == 0){
//			 return true;
//		 }
//		return false;	 
//	 }
//
//public int get(char letter) {
//		int letterToInteger = letter;
//		int index = 0;
//		if (letterToInteger <=122 & letterToInteger >=97 ){//lower case
//			index = letterToInteger - 97;
//		}else if (letterToInteger <= 90 & letterToInteger >= 65){//upper case
//			index = letterToInteger - 65;
//		}else {
//			throw new IllegalArgumentException();
//		}	 
//			return elementData[index];
//		 }
// 
//public String toString(){
//		 String allLetters ="";
//		 for (int i = 0; i < elementData.length; i++){
//			 if(elementData[i] != 0){
//			 for(int j = 1; j <= elementData[i]; j++){
//				 allLetters += (char)(i + 97);
//			 	}	
//			 }
//		 }
//		return ("[" + allLetters + "]");
//	 }
//	 
//public void set(char letter, int value){
//		 int indexOfList;
//		 int letterToInteger = letter;
//		 if (letterToInteger <= 122 & letterToInteger >= 97 ){
//			 indexOfList = letterToInteger - 97;
//			}else if (letterToInteger <= 90 & letterToInteger >= 65){
//				indexOfList = letterToInteger - 65;
//			}else {
//				throw new IllegalArgumentException();
//			}	
//		 if (elementData[indexOfList]> value){
//		 }else if (elementData[indexOfList] < value){
//		 }
//		 elementData[indexOfList] = value; 	 
//	 }
//
//public LetterInventory add(LetterInventory other){
//		 LetterInventory list = new LetterInventory();
//		 for (int i = 0; i < INVENTORY_CAPACITY; i++){
//			 list.elementData[i] = this.elementData[i] + other.elementData[i];
//		 }
//		 return list;  
//	 }
//	 
//public LetterInventory subtract(LetterInventory other){
//		 LetterInventory subtractResult = new LetterInventory();
//		 for (int i = 0; i < INVENTORY_CAPACITY; i++){
//			 subtractResult.elementData[i] = this.elementData[i] - other.elementData[i];
//			 if (subtractResult.elementData[i]<0){
//				 return null;
//			 }
//		 }
//		 return subtractResult; 
//	 }
//
//public double getLetterPercentage(char letter){ 
//		 double size = size();
//		 double numbersOfLetter = get(letter);
//		 double percentage = numbersOfLetter/size;
//		 return percentage;	 
//	 }
//}
