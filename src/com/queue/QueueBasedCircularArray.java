package com.queue;

import java.util.Iterator;

public class QueueBasedCircularArray<T> implements QueueADT<T> {

	private T[] array;
	private int front, end;
	private int size;

	public QueueBasedCircularArray(int initSize) {
		front = end = 0;
		size = initSize + 1;
		array = (T[]) new Object[size];
	}

	@Override
	public void enQueue(T element) {
		array[end] = element;
		if (++end == size)
			end = 0;
		if (end == front)
			throw new RuntimeException("Queue is full!");
	}

	@Override
	public T deQueue() {
		if (isEmpty())
			throw new RuntimeException("Queue empty");
		T data = array[front];
		if (++front == size)
			front = 0;
		return data;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Queue empty");
		return array[front];
	}

	@Override
	public int size() {
		if(front <= end) return end - front;
		else return end - front + size;
	}

	@Override
	public boolean isEmpty() {
		return front == end;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int frontElement = front;
			private int endElement = end;
			
			@Override
			public boolean hasNext() {
				return frontElement != endElement;
			}

			@Override
			public T next() {
				T data = array[frontElement];
				frontElement++;
				if(frontElement >= size) frontElement = 0;
				return data;
			}
		};
	}

}
