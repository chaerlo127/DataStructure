package list.linkedlist.implementation;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node{
		private int value;
		private Node next;
		
		private Node(int data) {
			this.value = data;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.value);
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		// 기존의 head를 다음 node로 지정
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	

	public void addLast(int data) {
		Node newNode = new Node(data);
		// 처음으로 값을 넣는다면
		if(size == 0) {
			addFirst(data);
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void add(int index, int data) {
		if(index ==0) {
			addFirst(data);
		}else {
			Node x = node(index-1); // index 2에 넣고 싶다면 index 1의 node
			if(x == null) {
				return;
			}
			Node y = x.next; // 원래 index 2 node
			
			Node newNode = new Node(data);
			x.next = newNode;
			newNode.next = y;
			size ++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	// 외부에서 사용하면 안됨.
	private Node node(int index) {
		Node x = head;
		for(int i = 0; i<index ;i++	) {
			x = x.next;
			if(x == null) {
				return null;
			}
		}
		return x;
	}
	
	public int removeFirst() {
		if(head == null) {
			return -1;
		}
		
		Node temp = head;
		head = head.next;
		int returnData = temp.value;
		temp = null;
		size --;
		
		return returnData;
	}
	
	public int remove(int index) {
		if(index == 0) {
			return removeFirst();
		}else if(node(index-1) == null) {
			return -1;
		}
		else{
			Node x = node(index-1);
			Node y = x.next; // 삭제할 노드
			
			x.next = y.next;
			int returnData = y.value;
				
			if(y == tail) {
				tail = x;
			}
			y = null;
			size--;
			return returnData;
		}
		
	}
	
	public int removeLast() {
		return remove(size-1);
	}
	
	public int size() {
		return size;
	}
	
	public int get(int index) {
		return node(index).value;
	}
	
	public int indexOf(int data) {
		Node temp = head;
		int index = 0;
		while(head.value != data) {
			temp = temp.next;
			index ++;
			if(temp == null) {
				return -1;
			}
		}
		return index;
	}
	
	public String toString() {
		String str = "";
		Node temp = head;
		
		while(temp.next!=null) {
			str += temp.value + ", ";
			temp = temp.next;
		}
		str += temp.value;
		return str;
	}
	
	public MyListIterator listIterator(){
		return new MyListIterator();
	}
	
	public class MyListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		public MyListIterator() {
			this.next = MyLinkedList.this.head;
			this.nextIndex = 0;
		}
		
		public int next() {
			this.lastReturned = this.next;
			this.next = this.next.next;
			this.nextIndex ++;
			return lastReturned.value;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public void add(int data) {
			Node newNode = new Node(data);
			if(lastReturned == null) {
				head = newNode;
				newNode.next = this.next;
			} else {
				lastReturned.next = newNode;
				newNode.next = this.next;
			}				
			lastReturned = newNode;
			nextIndex++;
			size ++;			
		}

		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
		
		
	}


	
}
