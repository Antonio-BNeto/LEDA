package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}if(element != null){
			this.top.insertFirst(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		T dequeued = null;
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}else{
			dequeued = this.top();
			this.top.removeFirst();
		}
		return dequeued;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>)this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
