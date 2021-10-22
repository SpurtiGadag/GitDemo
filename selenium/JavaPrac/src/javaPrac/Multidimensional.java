package javaPrac;

public class Multidimensional {
	public static void main(String[] args) {
	


		int a[][] = new int[2][3];
		a[0][0]=2;
		a[0][1]=4;
		a[0][2]=5;
		a[1][0]=3;
		a[1][1]=4;
		a[1][2]=7;
	

		for(int i=0;i<2;i++) //row
		{

		for(int j=0;j<3;j++) 
		{

		System.out.print(a[i][j]);
		System.out.print("\t");
		}
		System.out.print("\n");
		}

		}



}


