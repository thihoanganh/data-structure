package com.hashset;

import java.util.ArrayList;

public class HashSet {
	private final int SIZE = 1000;
	private ArrayList<Integer> bucket[];
	
	public HashSet(){
		bucket = new ArrayList[SIZE];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<>();
		}
	}
	
	
	public int hash(int key) {
		return key % SIZE;
	}

	public void add(int key) {
		ArrayList<Integer> arrList = bucket[hash(key)];
		if(arrList.indexOf(key)<0) {
			arrList.add(key);
		}
		
	}
	
	public void remove(int key) {
		ArrayList<Integer> arrList = bucket[hash(key)];
		if(arrList.indexOf(key) >= 0) {
			arrList.remove(arrList.indexOf(key));
		}
	}
	
	public boolean contains(int key) {
		ArrayList<Integer> arrList = bucket[hash(key)];
		if(arrList==null) return false;
		return arrList.indexOf(key) > -1;
	}
}
