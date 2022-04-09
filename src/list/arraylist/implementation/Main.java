package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {
		MyArrayList numbers = new MyArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
//		numbers.add(1, 40);
//		numbers.add(0, 30);
//		System.out.println(numbers.get(0));
//		System.out.println(numbers.removeLast());
//		System.out.println(numbers.size());
//		System.out.println(numbers.indexOf(40));
//		System.out.println(numbers.toString());
		
//		ListIterator
//		for(int i =0; i<numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
		MyArrayList.MyListIterator li = numbers.listIterator();
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//		while(li.hasPrevious()) {
//		    System.out.println(li.previous());
//		}
		
		while(li.hasNext()) {
			int number = li.next();
			if(number == 30) {
				li.remove();
			}
			System.out.println(number);
		}
		
		System.out.println(numbers);
	}

}
