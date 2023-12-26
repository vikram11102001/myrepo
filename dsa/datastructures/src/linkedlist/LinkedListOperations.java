package linkedlist;


class Node {
    private String name;
    private Node nextNode;

    public Node(String name) {
        this.name = name;
        this.nextNode = null;
    }

    public String getName() {
        return name;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedList {
    Node headNode = null;

    public LinkedList() {
    }

    public void addNode(String var1) {
        Node var2 = new Node(var1);
        if (this.headNode == null) {
            this.headNode = var2;
        } else {
            Node var3;
            for (var3 = this.headNode; var3.getNextNode() != null; var3 = var3.getNextNode()) {
            }
            var3.setNextNode(var2);
        }
    }

    public void removeDuplicates() {
        for (Node var1 = this.headNode; var1 != null; var1 = var1.getNextNode()) {
            Node var2 = var1;
            while (var2.getNextNode() != null) {
                if (var2.getNextNode().getName().equals(var1.getName())) {
                    var2.setNextNode(var2.getNextNode().getNextNode());
                } else {
                    var2 = var2.getNextNode();
                }
            }
        }
    }

    public void printNodes() {
        for (Node var1 = this.headNode; var1 != null; var1 = var1.getNextNode()) {
            System.out.print(var1.getName() + " ");
        }
        System.out.println();
    }
}

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode("A");
        list.addNode("B");
        list.addNode("A");
        list.addNode("C");
        list.addNode("B");

        System.out.println("Original list:");
        list.printNodes();

        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printNodes();
    }
}
