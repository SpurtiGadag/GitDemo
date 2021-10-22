package javaPrac;
/* 2 4 5
   3 4 8
   1 2 9
   identify the min number and print max number in that column
 */
public class InterviewMin {
		public static void main(String[] args) {
		int mincolumn=0;
		
	int a[][]={{2,4,5},{3,4,8},{1,2,9}};
	int min=a[0][0];
	
	for (int i=0;i<3;i++)
	{
		
	
		for (int j=0;j<3;j++)
		{
			if (a[i][j]<=min)
			{
				min=a[i][j];
				mincolumn=j;
			}
		}
	}
System.out.println(min);
int k=0;
int max=a[0][mincolumn];
while(k<3)
{
	if(a[k][mincolumn]>max)
		
	{
		max=a[k][mincolumn];
		
	}
	k++;
}
System.out.println(max);
}
}