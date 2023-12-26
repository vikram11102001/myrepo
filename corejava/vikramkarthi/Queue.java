public class Queue {
	
	private Node headNode;
	
	public Node getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}

	public void addNode(String name) {
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

	public void removeNode() {
		if (headNode != null) {
			headNode = headNode.getNextNode();
		}
	}

	public void printNodes() {
		Node currentNode = headNode;
		while (currentNode != null) {
			System.out.println(currentNode.getName());
			currentNode = currentNode.getNextNode();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q1 = new Queue();
		q1.addNode("John");
		q1.addNode("Lisa");
		q1.printNodes();
		q1.removeNode();
		q1.printNodes();
	}

}