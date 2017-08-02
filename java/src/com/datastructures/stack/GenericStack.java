package com.datastructures.stack;


public final class GenericStack<E> {

	NodeWrapper<E> top = null;
	
	private static final class NodeWrapper<E> {
		E node;
		NodeWrapper<E> next;
		
		
		@SuppressWarnings("rawtypes")
		public static NodeWrapper getInstance(){
			return new NodeWrapper();
		}
		
		public NodeWrapper() {
			this.node = null;
			this.next = null;
		}
		/**
		 * @return the node
		 */
		public E getNode() {
			return node;
		}
		/**
		 * @return the next
		 */
		public NodeWrapper<E> getNext() {
			return next;
		}
		/**
		 * @param node the node to set
		 */
		public void setNode(E node) {
			this.node = node;
		}
		/**
		 * @param next the next to set
		 */
		public void setNext(NodeWrapper<E> next) {
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public void push(E node){
		NodeWrapper<E> newNode = NodeWrapper.getInstance();
		newNode.setNode(node);
		if(this.top ==null){
			//stack is empty
			this.top = newNode;
		}else{
			newNode.setNext(top);
			top = newNode;
		}
	}
	
	public E pop(){
		if(this.top == null){
			System.out.println("Stack is empty");
			return null;
		}
		E returnNode = top.getNode();		
		top = top.getNext();
		return returnNode;
	}
	
	/*
	 * Iterate through stack 
	 */
	public void iterate(){
		/*if(top!=null){
			System.out.println(top.getNode());
			top = top.getNext();
			iterate();
		}
		top = this.top;
		return;*/
		printInfo(top);
	}
	
	private void printInfo(NodeWrapper<E> node){
		if(node!=null){
			System.out.println(node.getNode());
			printInfo(node.getNext());
		}
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GenericStack<StackNode> stack = new GenericStack<StackNode>();
		stack.push(new StackNode(10));
		stack.push(new StackNode(20));
		stack.push(new StackNode(30));
		stack.iterate();
		System.out.println("-------------------------------------");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}


class StackNode {
	int info;
	
	public StackNode(int info) {
		this.info = info;
	}

	/**
	 * @return the info
	 */
	public int getInfo() {
		return info;
	}


	/**
	 * @param info the info to set
	 */
	public void setInfo(int info) {
		this.info = info;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.info);
	}
	
}