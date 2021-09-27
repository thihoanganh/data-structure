package com.app;

import java.util.Iterator;

import com.queue.QueueBasedCircularArray;

public class App {
	

	public static void main(String[] args) {
		QueueBasedCircularArray<Integer> arr = new QueueBasedCircularArray<Integer>(3);
		arr.enQueue(1);
		arr.enQueue(2);
		
		Iterator itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
