package algo;

public class Queue {
	//insert from rear and delete from front
	//FIFO, O(1)
	//arrays of primitive types are all 0, not null at the beginning
	
	private int[] q;
	private int front;
	private int rear;
	private int length;
	
	public Queue(int length) {
		this.length=length;
		q= new int[length];
		front=-1;
		rear=-1;
	}
	
	
	//If rear is pointing to end of array, we have filled all spots
	private boolean isFull() {
		return rear==(length-1);
	}
	
	private boolean isEmpthy() {
		return front==-1 && rear==-1;
		
	}
	
	private boolean lastElement() {
		return rear==front;
		
	}
	
	
	public void enqueue(int i) {
		if(isFull()==true) {
			System.out.println("Queue is full");
			return;
		}
		else if(isEmpthy()==true) {
			front++;
		}	
			rear++;
			q[rear]=i;
			
			
	}
	
	
	public void dequeue() {
		if(isEmpthy()==true) {
			System.out.println("Queue is Empthy");
			return;
		}
		
		else if(lastElement()==true) {
			front=-1;
			rear=-1;
			return;
		}
		System.out.println("deleted" + String.valueOf(q[front]));
		front++;
		
		
	}
	
	@Override
	public String toString(){
		StringBuilder s= new StringBuilder();
		for(int i: q) {
			s.append(i+ ",");
			
		}
		return "[" + s.toString() + "]";
		
		
	}
	
	
	public static void main(String args[]) {
	Queue queue= new Queue(5);
	queue.enqueue(1);
	
	queue.dequeue();
	
	queue.enqueue(2);
	
	queue.enqueue(3);
	queue.enqueue(4);
	queue.enqueue(5);
	
	//it will get full bc we have already inserted five values even though we deleted 1 it still counts, make it
	//circular to solve this
	queue.enqueue(4);
	queue.enqueue(5);
	System.out.println(queue);
	System.out.println(queue.clone());
	
}
	//to make operation where we will need information about the queue, we need a clone to make sure we doe'nt change
	//anything
	public Queue clone() {
		Queue temp= new Queue(q.length);
		temp.q= new int[q.length];
		for(int i=0; i<q.length; i++) {
			temp.q[i]=this.q[i];
			
		}
		temp.front=this.front;
		temp.rear=this.rear;
		
		return temp;
	}
	 
	
	
}
