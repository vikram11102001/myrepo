package linkedlist;


class Node {

	private String name;
	private Node nextNode;
	private Node previousNode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	
	
}


public class LinkedListDeletefr{
	
	//add Node
	//insert Node
	//delete Node
	//read all the nodes
	//CRUD - Create, Read, Update, Delete
	//Create a node == add, insert
	//Read a node
	//Update a node
	//Delete a node

	public static void printNodes(Node currNode) {
		while(currNode != null) {
			System.out.println(currNode.getName());
			currNode = currNode.getNextNode();
		}
	}
	
	public static void addNode(String name, Node headNode) { //Method signature
		//Method body/definition
		
		
		//Create a new node with the argument passed.
		Node newNode = new Node();
		newNode.setName(name);
		
		Node currentNode = headNode;
		
		if(currentNode != null) {
			while(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
		//currentNode = john
		//currentNode = lisa
		//currentNode = smith
		
	}
	
	public static void deleteNode(String name, Node headNode) {
		Node currentNode = headNode;
		if(currentNode != null){
			while(currentNode.getNextNode() == name){
				currentNode.setNextNode(newNode);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n1 = new Node();
		n1.setName("John"); // John is the name
		
		Node n2 = new Node();
		n2.setName("Lisa");
		
		Node n3 = new Node();
		n3.setName("Smith");
		
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		
		//Varrun is the name
		n1.setName("Varrun"); //updating the name
		
		
		
		
		
		
		printNodes(n1);
		addNode("Yuvaraj",n1);
		System.out.println("===========");
		printNodes(n1);
		deleteNode("Smith", n1);
		printNodes(n1);
		
	}

}