package javaPrac;

public class Pallindromepgm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="madam";
		String t = "";
		for (int i=s.length()-1;i>=0;i--)
		{
			t= t+s.charAt(i);
			
		}
		System.out.println(t);
		if(t.equals(s))
			System.out.println("Pallindrome");
		else
		{
			System.out.println("Not Pallindrome");
		}
	}

}
