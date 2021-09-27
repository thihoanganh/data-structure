package com.array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T>{
	private T[] arr;
	private int capacity;
	private int size = 0;

	public DynamicArray(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity can not be nagative");
		}
		this.capacity = capacity;
		this.arr = (T[]) new Object[capacity];
	}

	public DynamicArray() {
		this(10);
	}
	
	public int capacity() {
		return capacity;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public T get(int index) {
		return arr[index];
	}

	public void set(int index, T obj) {
		arr[index] = obj;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			arr[i] = null;
		}
		size = 0;
	}

	public void add(T obj) {
		if (size == capacity) {
			capacity += 5;
			T[] newArr = (T[]) new Object[capacity];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[size++] = obj;
	}
	
	public void removeAt(int index) {
		if(index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
		T[] newArr = (T[]) new Object[size-1];
		for(int i = 0 ; i < size -1 ; i++) {
			if(i >= index) {
				newArr[i] = arr[i+1];
			}else {
				newArr[i] = arr[i];
			}
		}
		arr = newArr;
		capacity = --size;
			
	}
	
	public boolean remove(Object obj) {
		if(indexOf(obj)!= -1) {
			removeAt(indexOf(obj));
			return true;
		}else {
			return false;
		}
	}
	
	public int indexOf(Object obj) {
		for(int i = 0 ; i < size ; i++) {
			if(obj == null) {
				if(arr[i] == null) return i;
			}else {
				if(arr[i].equals(obj)) return i;
			}
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public Object next() {
				return arr[index++];
			}
		};
	}
	

}
