package linkedlist;

/*class Node {

	private String name;
	private Node nextNode;
	private Node previousNode;
	
	public Node(String name){
		this.name = name;
		this.nextNode = null;
	}

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
	
	
	
}*/

class LinkedList {
    Node headNode;

    public LinkedList() {
        this.headNode = null;
    }

    // Method to add a new node at the end of the linked list
    public void addNode(String name) {
        Node newNode = new Node(name);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node current = headNode;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }

    // Method to remove duplicates from the linked list
    public void removeDuplicates() {
        Node current = headNode;

        while (current != null) {
            Node runner = current;

            while (runner.getNextNode() != null) {
                if (runner.getNextNode().getName().equals(current.getName())) {
                    runner.setNextNode(runner.getNextNode().getNextNode());
                } else {
                    runner = runner.getNextNode();
                }
            }

            current = current.getNextNode();
        }
    }

    // Method to print the linked list
    public void printNodes() {
        Node current = headNode;
        while (current != null) {
            System.out.print(current.getName() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }
}

public class RemoveDuplicatesInLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode("ram");
        list.addNode("surya");
        list.addNode("surya");
        list.addNode("vikram");
        list.addNode("smith");
        list.addNode("ram");

        System.out.println("Original linked list:");
        list.printNodes();

        list.removeDuplicates();

        System.out.println("Linked list after removing duplicates:");
        list.printNodes();
    }
}
