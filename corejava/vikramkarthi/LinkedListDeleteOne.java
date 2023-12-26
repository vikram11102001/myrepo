

public class LinkedListDeleteOne{
	
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
	
	public static void deleteNode1(String name, Node headNode) {
		Node prevNode = null;
		Node currentNode = headNode;

    // Handle the case when the node to be deleted is the head node
    if (currentNode != null && currentNode.getName()== name ){
        headNode = currentNode.getNextNode();
        return;
    }

    while (currentNode != null) {
        if (currentNode.getName()== name ){
            // Found the node to delete, update the references to skip the node
            prevNode.setNextNode(currentNode.getNextNode());
            return;
        }

        prevNode = currentNode;
        currentNode = currentNode.getNextNode();
    }
}

public static void deleteNode(String name, Node headNode) {
		Node prevNode = null;
		

	Node currentNode = headNode;
	
    while (currentNode != null) {
        if (currentNode.getName()== name ){
            // Found the node to delete, update the references to skip the node
            prevNode.setNextNode(currentNode.getNextNode());
            return;
        }

        prevNode = currentNode;
        currentNode = currentNode.getNextNode();
    }
}

public static void insertNode(Node nodeToBeInserted, Node searchNode) {
   

    // Get the reference of the node after which we want to insert the new node.
    Node nextNode = searchNode.getNextNode();

    // Set the next node of the new node to the next node of the search node.
    nodeToBeInserted.setNextNode(nextNode);

    // Set the next node of the search node to the new node.
    searchNode.setNextNode(nodeToBeInserted);
}


public static void printNodesToConsole(Node currentNode) {
    if (currentNode != null) {
        System.out.println(currentNode.getName());
        printNodesToConsole(currentNode.getNextNode());
    }
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
	//	n1.setName("Varrun"); //updating the name
		
		
		
		
		
		
		printNodes(n1);
		addNode("Yuvaraj",n1);
		System.out.println("===========");
		printNodes(n1);
		String nameToBeRemoved = "Yuvaraj";
		// Handle the case when the node to be deleted is the head node
    if (n1 != null && n1.getName()== nameToBeRemoved ){
        n1 = n1.getNextNode();
        
    }else{
			deleteNode(nameToBeRemoved, n1);
	}
		System.out.println("===========");
		printNodes(n1);
		
	
	System.out.println("----");
	Node n4 = new Node();
	n4.setName("Vikram");
	deleteNode2(n4);
	//n4 = null;
	System.out.println(n4.getName());
	Node newNode = new Node();
	newNode.setName("Surya");

// Insert the new node after the node with the name "Lisa"
	insertNode(newNode, n3);

// Print the nodes to verify the insertion
	System.out.println("==========");
	printNodes(n1);
	System.out.println("==========");
	printNodesToConsole(n1);
	}
	
	


public static void deleteNode2(Node tempNode) {
	tempNode = null;
	
}	

}