package com.hashmap;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMap {
	private class Data {
		public int key, value;

		public Data(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object other) {
			if (other instanceof Data)
				return this.key == ((Data) other).key;
			return false;
		}
	}

	private final int SIZE = 1000;
	private ArrayList<Data> bucket[];

	public HashMap() {
		bucket = new ArrayList[SIZE];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Data>();
		}
	}

	public int hash(int key) {
		return key % SIZE;
	}

	public void put(int key, int value) {
		ArrayList<Data> arrList = bucket[hash(key)];
		int indexOfObjInArrayList = arrList.indexOf(new Data(key, value));
		if (indexOfObjInArrayList < 0) {
			// obj is not present in list
			arrList.add(new Data(key, value));
		} else {
			// already exsit in list
			// update new value for obj
			arrList.get(indexOfObjInArrayList).value = value;
		}
	}

	public boolean remove(int key) {
		ArrayList<Data> arrList = bucket[hash(key)];
		int indexOfObjInArrayList = arrList.indexOf(new Data(key, -1));
		if (indexOfObjInArrayList < 0)
			return false;
		else {
			arrList.remove(indexOfObjInArrayList);
			return true;
		}
	}

	public int get(int key) {
		ArrayList<Data> arrList = bucket[hash(key)];
		return arrList.get(arrList.indexOf(new Data(key, -1))).value;
	}

	public boolean containsKey(int key) {
		ArrayList<Data> arrList = bucket[hash(key)];
		if (arrList == null)
			return false;
		else {
			return arrList.indexOf(new Data(key, -1)) < 0 ? false : true;
		}
	}

	public boolean containsValue(int value) {
		for (int i = 0; i < bucket.length; i++) {
			ArrayList<Data> arrList = bucket[i];
			Iterator itr = arrList.iterator();
			while(itr.hasNext()) {
				if(((Data)itr.next()).value == value) return true;
			}
		}
		return false;
	}
}
