import java.util.*;
public class sjf {
public static void main(String args[])
{
	int totwt,n,i,j,temp;
	Scanner s=new Scanner(System.in);
	System.out.print("Enter no of processes: ");
	n=s.nextInt();
	int pid[]=new int[10];
	int bt[]=new int[10];
	int wt[]=new int[10];
	int tat[]=new int[10];
	float avgwt=0,avgtt=0;
	//input
	for(i=0;i<n;i++)
	{
		System.out.println("Enter process "+(i+1)+" brust time");
		bt[i]=s.nextInt();
		pid[i]=i+1;
	}
	//sorting
	for(i=0;i<n-1;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(bt[i]>bt[j])
			{
				temp=bt[i];
				bt[i]=bt[j];
				bt[j]=temp;
				
				temp=pid[i];
				pid[i]=pid[j];
				pid[j]=temp;
				
			}
		}
	}
	
	//calculation
	
	//waiting time
	wt[0]=0;
	totwt=0;
	for(i=1;i<n;i++)
	{
		totwt=totwt+bt[i-1];
		wt[i]=totwt;
		avgwt=avgwt+wt[i];
	}
//	turn around time
	for(i=0;i<n;i++)
	{
		tat[i]=wt[i]+bt[i];
		avgtt=avgtt+tat[i];
	}
	
	//printing
	System.out.println("pid\t"+"brust time\t"+"waiting\t"+"turnaround time");
	for(i=0;i<n;i++)
	{
		System.out.println(pid[i]+"\t"+bt[i]+"\t\t"+wt[i]+"\t"+tat[i]);
	}
	System.out.println("Average waiting time= "+avgwt/n);
	System.out.println("Average turnaround time= "+avgtt/n);
}
}
