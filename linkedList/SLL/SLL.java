class Node {
    private int data;
    private Node next;

    public Node(int data) {
	this.data = data;
	this.next = null;
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
}
class SLL {
    private Node head;
    private int length;
    public SLL(){
	this.head = null;
	this.length = 0;
    }

    public int getLength() {
	return this.length;
    }

    public void insertAtEnd(int data){
	Node node = new Node(data);
	if(head == null){
	    System.out.println("SLL does not exists creating a new one...");
	    head = node;
	    length++;
	}else {
	    Node temp = head;
	    while(temp.getNext() != null){
		temp = temp.getNext();
	    } 
	    temp.setNext(node);
	    System.out.println("Inserted at the end");
	    length++;
	}
    }

    public void insertAtBegning(int data) {
	Node node = new Node(data);
	Node temp = head;
	head = node;
	node.setNext(temp);
	length++;
    }

    public void insertAtPos(int data, int pos){
	Node node = new Node(data);
	if(pos > length){
	    System.out.println("Invalid length, data not inserted at the given pos");
	    return;
	}
	if(pos == 0) 
	    insertAtBegning(data);
	else if(pos == length)
	    insertAtEnd(data);
	else {
	Node temp=head,prev=null;
	for(int i=0;i < pos;i++){
		prev = temp;
		temp = temp.getNext();
	}
	prev.setNext(node);
	node.setNext(temp);
	length++;
	}
    }

    public void deleteAtBegining(){
          head = head.getNext();
          System.out.println("deleted");
	  length--;
    }

    public void deleteAtEnd(){
	Node temp = head;
	Node prev = null;
	while(temp.getNext() != null){
	    prev = temp;
	    temp = temp.getNext();
	}
	prev.setNext(null);
	length--;
	System.out.println("deleted");
    }

    public void deleteAtPos(int pos){
	Node last=null,mid=null,before=head;
	if(pos > length) {
	    System.out.println("invalid position");
	    return;
	}
	if(pos == 0)
	    deleteAtBegining();
	else {
	    for(int j=0;j <= pos-2;j++){
		before = before.getNext();
	    }
	    mid = before.getNext();
	    last = before.getNext().getNext();
	}
	  before.setNext(last);
    }


    public void printSLL(){
	Node temp = head;
	System.out.println("Contents of SLL are");
	while(temp.getNext() != null){
	    System.out.print(temp.getData()+" ");
	    temp = temp.getNext();
	}
	    System.out.println(temp.getData());
    }


    public static void main(String args[]){
	SLL sll = new SLL();
	sll.insertAtEnd(1);
	sll.insertAtEnd(2);
	sll.insertAtEnd(3);
	sll.insertAtEnd(4);
	sll.insertAtEnd(5);
	sll.insertAtEnd(6);
//	sll.insertAtPos(99,5);
	sll.deleteAtPos(5);
	sll.printSLL();
    }
}
		

