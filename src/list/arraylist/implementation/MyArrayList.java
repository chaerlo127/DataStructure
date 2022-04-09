package list.arraylist.implementation;

public class MyArrayList {
	private int[] elementData;
	private int size;
	private int currentCapacity;
	private int initCapacity = 10;
	
	public MyArrayList() {
		this.elementData = new int[initCapacity];
		this.size = 0;
		this.currentCapacity = initCapacity;
	}
	
	
	public boolean addFirst(int data) {
		return add(0, data);
	}
	
	public boolean addLast(int data) {
		changeCapacity();
		elementData[size]= data;
		size++;
		return true;		
	}

	public boolean add(int index, int data) {
		changeCapacity();
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}

		elementData[index] = data;
		size++;
		return true;	
	}
	
	
	//refactoring
	private void changeCapacity() {
		if(size == currentCapacity) {
			int[] newArray = new int[currentCapacity*2];
			for(int i = 0; i < size ; i++) {
				newArray[i] = elementData[i];
			}
			elementData = newArray;
			currentCapacity = currentCapacity * 2;
		}
	}
	

	public int remove(int index) {
		int removed = elementData[index];
		for(int i = index+1; i<size; i++) {
			elementData[i-1] = elementData[i];
		}
		elementData[size-1] = 0;
		size --;
		return removed;
	}
	
	public int removeFirst() {
		return remove(0);
	}
	
	public int removeLast() {
		return remove(size-1);
	}
	public int get(int index) {
		return elementData[index];
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(int data) {
		for(int i =0; i<size; i++) {
			if(elementData[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += elementData[i];
			if (i < size - 1) {
				str += ", ";
			}
		}
		return str + "]";
	}


	public MyListIterator listIterator() {
		return new MyListIterator();
	}
	
	class MyListIterator {
		private int nextIndex = 0;

		public int next() {
//			int returnData = elementData[nextIndex];
//			nextIndex++;
//			return returnData;
			return elementData[nextIndex++];
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public int previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		public void add(int data) {
			MyArrayList.this.add(nextIndex++, data);
		}
		// 최소한 next(); 한번 호츨 후 remove 실행
		public void remove() {
			MyArrayList.this.remove(nextIndex-1); // next() 수행하면 nextIndex 값 1개 ++ -1 해주기
			nextIndex--;
			
		}

	}
}
