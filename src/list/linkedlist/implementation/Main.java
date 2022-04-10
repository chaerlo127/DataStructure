package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		MyLinkedList numbers = new MyLinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.add(1, 15);
		
//		numbers.remove(5);
		System.out.println(numbers); // toString 생성하여 객체만 만들어도 됨
		MyLinkedList.MyListIterator listIterator = numbers.listIterator();
		listIterator.add(5);
		listIterator.next();
		listIterator.remove();
		System.out.println(numbers);
		
	}

}
