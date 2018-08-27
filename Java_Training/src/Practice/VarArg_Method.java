package Practice;



	public class VarArg_Method {

		public void print(int i,String ...s) {
			System.out.println("This is Print Method");
			String NewMsg = null;

			//String Msg = java.util.Arrays.toString(s);
			//System.out.println(s.length);
			 System.out.println(i);
			for( int j = 0; j <= s.length-1; j++) {

				 NewMsg = (s[j] + " ");
				
				System.out.println(NewMsg);
			}
			
		}
		//public void print(int i,char ...cs) {
			//System.out.println("This is Print Method");
			//System.out.println(i+"  "+cs);
		//}
		public static void main(String[] args) {
			VarArg_Method oBj = new VarArg_Method();
			//oBj.print(100,'c');
			//oBj.print(100);// overloading may lead to ambiguity.
			oBj.print(200,"Mathan");
			oBj.print(300,"Viji","Mathan");
			oBj.print(400,"Viji","Mathan","Karhitck");

		}
	}
