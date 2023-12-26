public class Stack {
	
	private Node lastNode;
	
	public Node getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}

	public void push(String name) {
		Node n1 = new Node(name);
		if (headNode == null) {
			headNode = n1;
		} 
		else {
			Node currentNode = headNode;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(n1);
		}
	}
	
	public void pop() {
		
	}
	
	public void print() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack();
		s1.push("John");
		s1.push("Lisa");
		s1.print();
		s1.pop();
		s1.print();
	}

}