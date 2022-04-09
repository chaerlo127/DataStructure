package list.arraylist.api;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		System.out.println("add: " + numbers);
		
		numbers.add(2, 50);
		System.out.println("add: " + numbers);
		
		numbers.remove(2);
		System.out.println("remove: " + numbers);
		
		
		System.out.println("get index 2: " + numbers.get(2));
		
		System.out.println("arraylist size: " + numbers.size());
		
		System.out.println("indexOf about 30:"  + numbers.indexOf(30));
		
		Iterator it = numbers.iterator();
		while(it.hasNext()) {
			int value = (int) it.next();
			if(value == 30) {
				it.remove();
			}
			System.out.println(value);
		}
		System.out.println(numbers);
		
		for(int value : numbers){
			System.out.println(value);
		}
		
		for(int i = 0; i<numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
	}

}
