class Node {
    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
	this.data = data;
	this.next = null;
	this.prev = null;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
	this.next = next;
    }

    public Node getPrev(){
	return this.prev;
    }

    public void setPrev(Node prev){
	this.prev = prev;
    }

}

class DLL {
    private Node head;
    private int length;

    public DLL(){
	this.head = null;
	this.length = 0;
    }
    public int getLength(){
	return this.length;
    }

    public void insertAtBegining(int data) {
	Node node  = new Node(data);
	if(head == null) {
	    System.out.println("DLL does not exists creating a new one");
	    head = node;
	    length++;
	} else {
	    node.setNext(head);
	    head.setPrev(node);
	    head = node;
	    length++;
	}
    }

    public void insertAtEnd(int data){
	Node node = new Node(data);
	if(head == null) {
	    System.out.println("DLL does not exists creating a new one");
	    head = node;
	    length++;
	} else{
	    Node temp = head;
	    while(temp.getNext() != null) {
		temp = temp.getNext();
	    }
	    temp.setNext(node);
	    node.setPrev(temp);
	    length++;
	}
    }

    public void insertAtPos(int data, int pos) {
	Node node = new Node(data);
	if(pos > length) {
	    System.out.println("Invalid length");
	    return;
	}
	if(pos == length)
	    insertAtEnd(data);
	else if(pos == 0) 
	    insertAtBegining(data);
	else {
	    Node temp = head;
	    for(int i=0; i<pos; i++) {
		temp = temp.getNext();
	//	System.out.println("en loop");
	    }
	   // System.out.println(temp.getData());
	   Node prevNode = temp.getPrev();
	   prevNode.setNext(node);
	   node.setNext(temp);
	   temp.setPrev(node);
	}
    }

    public void deleteAtBegining(){
	if(head == null)
	    System.out.println("DLL does not exists");
	head = head.getNext();
	head.setPrev(null);
	System.out.println(head.getData());
    }

    public void deleteAtEnd(){
	if(head == null)
	    System.out.println("DLL does not exists");
	Node temp = head;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	}
	Node prevNode = temp.getPrev();
	prevNode.setNext(null);
	temp.setPrev(null);
    }

    public void deleteAtPos(int pos) {
	if(head == null)
	     System.out.println("DLL does not exists");
	Node temp = head;
	if(pos == 0)
	    deleteAtBegining();
	else if(pos == length-1)
	    deleteAtEnd();
	else{
	    for(int i=0; i < pos; i++){
		temp = temp.getNext();
	    }
	    Node prevNode = temp.getPrev();
	    Node nextNode = temp.getNext();
	    prevNode.setNext(nextNode);
	    nextNode.setPrev(prevNode);
	}
    }

    public void printDLL(){
        Node temp = head;
        System.out.println("Contents of SLL are");
        while(temp.getNext() != null){
	     System.out.print(temp.getData()+" ");
             temp = temp.getNext();
         }
             System.out.println(temp.getData());
    }

    public static void main(String args[]){
	DLL dll = new DLL();
	dll.insertAtBegining(5);
	dll.insertAtBegining(4);
	dll.insertAtBegining(3);
	dll.insertAtEnd(99);
	dll.insertAtEnd(100);
//	dll.deleteAtEnd();
//	dll.deleteAtBegining();
//	System.out.println(dll.getLength());
	dll.insertAtPos(66,5);
	dll.deleteAtPos(0);
	dll.printDLL();
    }
}

