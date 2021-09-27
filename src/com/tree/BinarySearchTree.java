package com.tree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
	private Node<T> root;
	private int size = 0;

	BinarySearchTree() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		return heightOfNode(root);
	}

	private int heightOfNode(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(heightOfNode(node.getLeft()), heightOfNode(node.getRight()));
	}

	@Override
	public boolean contains(T ele) {
		return contains(root, ele);
	}

	private boolean contains(Node node, T ele) {
		if (node == null)
			return false;
		int result = ele.compareTo((T) node.getData());
		if (result < 0)
			return contains(node.getLeft(), ele);
		else if (result > 0)
			return contains(node.getRight(), ele);
		else
			return true;
	}

	@Override
	public boolean add(T ele) {
		if (contains(ele))
			return false;
		root = add(root, ele);
		size++;
		return true;
	}

	private Node add(Node node, T ele) {
		if (node == null) {
			node = new Node(ele, null, null);
		} else {
			if (ele.compareTo((T) node.getData()) < 0) {
				node.setLeft(add(node, ele));
			} else {
				node.setRight(add(node, ele));
			}
		}
		return node;
	}

	@Override
	public boolean remove(T ele) {
		if (!contains(ele))
			return false;
		root = remove(root, ele);
		size--;
		return true;
	}

	private Node<T> remove(Node<T> node, T ele) {
		int result = ele.compareTo((T) node.getData());
		if (result < 0) {
			node.setLeft(remove(node, ele));
		} else if (result > 0) {
			node.setRight(remove(node, ele));
		} else {
			// found the node to be deleted
			if (node.getLeft() == null) {
				Node rightNode = node.getRight();
				node.setData(null);
				node = null;
				return rightNode;
			} else if (node.getRight() == null) {
				Node leftNode = node.getLeft();
				node.setData(null);
				node = null;
				return leftNode;
			} else {
				T tmp = minRight(node.getRight());
				node.setData(tmp);
				node.setRight(remove(node.getRight(), tmp));
			}
		}
		return node;
	}

	private T minRight(Node<T> node) {
		while (node.getLeft() != null)
			node = node.getLeft();
		return node.getData();
	}

	@Override
	public Iterator<T> traverse(TreeTraserseType type) {
		return null;
	}

}
