package com.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

import com.array.DynamicArray;

public class StackBasedArray<T> implements StackADT<T> {
	private DynamicArray<T> array;
	private int index = -1;
	
	public StackBasedArray(int initialSize) {
		array = new DynamicArray<>(initialSize);
	}
	@Override
	public void push(T element) {
		array.add(element);
		index++;
	}

	@Override
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		T data = top();
		array.removeAt(index--);
		return data;
	}

	@Override
	public T top() {
		if(isEmpty()) throw new EmptyStackException();
		return array.get(index);
	}

	@Override
	public int size() {
		return index + 1;
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0 ;
			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public T next() {
				return array.get(index++);
			}
		};
	}

}
