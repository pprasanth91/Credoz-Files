package Practice;

public class Variable_Ex {
	
	int iRollNo;
	static int RollNo = 200;
	
	private int iPrivate = 10;
	int iDefault = 20;
	protected int iProtected = 30;
	public int iPublic = 40;
	
	public void sum() {
		
		iRollNo=1000;
		int a=10,b=20,c;
		c = a+b;
		System.out.println("Sum is : "+c);
		System.out.println("Roll No is : "+iRollNo);
		System.out.println("Static variable : "+RollNo);
	}
	
public static void main(String[] args) {
		
		Variable_Ex oSum = new Variable_Ex();
		oSum.sum();
		
		

	}


}
