package Learning;
public class ReturnObject {


	int length;
	int breadth;



	ReturnObject getRectangleObject(int a, int b) {
		ReturnObject rect = new ReturnObject();
		rect.breadth=a;
		rect.length=b;
		
		return rect;
	}
	public void display() {
		System.out.println("breadth is "+breadth);
		System.out.println("length is "+length);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReturnObject a1= new ReturnObject();
		ReturnObject a2= new ReturnObject();
		ReturnObject a3= new ReturnObject();
		ReturnObject a4= new ReturnObject();
		a1=a2.getRectangleObject(10,20);
		a3=a4.getRectangleObject(30,40);
		a1.display();
		a3.display();
		a1.display();
		a2.display();
		a4.display();
		System.out.println("a2 values are "+a2.getRectangleObject(70,80).length);
		a1.display();
		a1=a2.getRectangleObject(100,200);
		a1.display();
		a3.display();
		a3=a4.getRectangleObject(300,400);
		a1.display();
		a3.display();
	}

}
