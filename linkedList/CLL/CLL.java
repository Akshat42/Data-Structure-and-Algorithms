class Node {
    private int data;
    private Node next;

    Node(int data) {
	this.data = data;
	this.next= null;
    }

    public int getData() {
	return this.data;
    }
    
    public Node getNext(){
	return this.next;
    }

    public void setNext(Node next){
	this.next = next;
    }

}

public class CLL {
    private Node tail;
    private int length;

    public CLL() {
	this.length = 0;
	this.tail = null;
    }

    public void insertAtBegining(int data) {
	Node node = new Node(data);
	if(tail == null) {
	    System.out.println("CLL does not exists creating a new one...");
	    tail = node;
	    tail.setNext(tail);
	    length++;
	}
	else {
	    node.setNext(tail);
	    Node temp = tail;
	    while(temp.getNext() != tail){
		temp = temp.getNext();
	    }
	    temp.setNext(node);
	    tail = node;
	    length++;
	}
    }

    public void insertAtEnd(int data) {
	Node node = new Node(data);
	if(tail == null) {
	    System.out.println("CLL does not exists creating a new one...");
	    tail = node;
	    tail.setNext(tail);
	    length++;
	}
	Node temp = tail;
	while(temp.getNext() != tail){
	    temp = temp.getNext();
	}
	temp.setNext(node);
	node.setNext(tail);
	length++;
    }   

	public void insertAtPos(int data,int pos) {
	    Node node = new Node(data);
	    if(tail == null){
		node = tail;
		length++;
		return;
	    }
	    if(pos == 0)
		insertAtBegining(data);
	    else if(pos == length-1)
		insertAtEnd(data);
	    else {
		Node temp = tail;
		Node prev = null;
		for(int i=0;i<pos;i++) {
		    prev = temp;
		   temp = temp.getNext();
		}
//		System.out.println(prev.getData());
//		System.out.println(temp.getData());
		prev.setNext(node);
		node.setNext(temp);
		length++;
	    }
	}

    public void deleteAtBegining() {
	Node temp = tail;
	while(temp.getNext() != tail){
	    temp = temp.getNext();
	}
	tail = tail.getNext();
	temp.setNext(tail);
	length--;
    }

    public void deleteAtEnd() {
	Node temp = tail;
	Node prev = null;
	while(temp.getNext() != tail) {
	    prev = temp;
	    temp = temp.getNext();
	}
	prev.setNext(tail);
	temp.setNext(null);
	length--;
    }

    public void deleteAtPos(int pos) {
	if(pos == 0)
	    deleteAtBegining();
	else if(pos == length-1)
	    deleteAtEnd();
	else {
	    Node before = tail;
	    for(int i=0;i<pos-2;i++){
		before = before.getNext();
	    }
	    Node mid = before.getNext();
	    Node after = mid.getNext();
	    before.setNext(after);
	    mid.setNext(null);
	    length--;
	}
    }

    public void printCLL(){
	System.out.println("Contents for CLL are");
	Node temp = tail;
	System.out.print(tail.getData()+" ");
	while(temp.getNext() != tail) {
	    temp = temp.getNext();
	    System.out.print(temp.getData()+" ");
	}
	System.out.println();
    }

    public static void main(String args[]){
	CLL cll = new CLL();
	cll.insertAtBegining(5);
	cll.insertAtBegining(4);
	cll.insertAtBegining(3);
	cll.insertAtBegining(2);
	cll.insertAtBegining(1);
	cll.insertAtBegining(0);
//	cll.insertAtEnd(99);
//	cll.insertAtEnd(100);
//	cll.insertAtEnd(101);
//	cll.insertAtPos(9999,4);
//	cll.deleteAtBegining();
//	cll.deleteAtEnd();
	cll.deleteAtPos(1);
	cll.printCLL();
    }
}
