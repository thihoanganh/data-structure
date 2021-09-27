package com.model;

public class SinglyNode<T> {
	private SinglyNode<T> next;
	private T data;

	public SinglyNode(T data, SinglyNode<T> next) {
		this.next = next;
		this.data = data;
	}

	public SinglyNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
