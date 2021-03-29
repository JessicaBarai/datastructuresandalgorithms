package algo;

public class CircQueue extends  Queue{

	public CircQueue(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean isFull() {
		return ((rear+1)%q.length)==front;
		
	}
	
	@Override
	public void enqueue(int i) {
		//change if we want queue to be able to override
		if(isFull()==true) {
			System.out.println("Queue is full");
			return;
		}
		else if(isEmpthy()==true) {
			front++;
		}	
			 rear=(rear+1)%q.length;
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
		front=((front+1)%q.length);
		
		
	}
	
	
	public static void main(String [] args) {
		CircQueue circle= new CircQueue(4);
		circle.enqueue(1);
		circle.enqueue(1);
		
		circle.enqueue(1);
		
		circle.enqueue(1);
		circle.enqueue(1);
		
		circle.dequeue();
		circle.enqueue(2);
		System.out.print(circle);
		
		
	}
	
	
	

	

	
	
	
	

}
