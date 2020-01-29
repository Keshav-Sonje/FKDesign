//Its the game between two Humans

import java.util.*;
interface TTTMain {
	int Check(int i,int j,int player,int m);
	int IsWinning(int i,int j);
	void ShowGameStatus(int m);
}
public class HexTicTacToe {
	public static void main(String[] args) {
		TicTacToeMain t = new TicTacToeMain();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of the game");
		t.n = s.nextInt();
		System.out.println("Index starts from 10");
		do
		{
			if(t.player==1)
				System.out.println("Player 1 Play your move");
			else
				System.out.println("Player 2 Play your move");
			System.out.println("Enter x and y places");
			t.i = s.nextInt();
			t.j = s.nextInt();
			if(t.Check(t.i,t.j,t.player,t.n)==1)
			{
				t.count++;
				t.player=-(t.player);
				t.ShowGameStatus(t.n);
			}
		}while(t.count<((t.n)*(t.n)) && t.IsWinning(t.i,t.j)==0);
		if(t.IsWinning(t.i,t.j)==1)
			System.out.println("Player 1 Won");
		else if(t.IsWinning(t.i,t.j)==-1)
			System.out.println("Player 2 Won");
		else
			System.out.println("Match Draw");
	}
}
class TicTacToeMain {
	int player=1,i,j;
	int arr[][] = new int[100][100];
	int count = 0;  
	int n;
	public int Check(int i,int j,int player,int m){
		if((i%2==1 && j%2==0)||(i%2==0 && j%2==1)||(i>10+2*m)||(j>10+2*m)||(i<10)||(j<10))
		{
			System.out.println("Invalid Move");
			return -1;
		}
		if(arr[i][j]!=0)
		{
			System.out.println("Occupied place");
			return -1;
		}
		if(player==1)
			arr[i][j]=1;
		else
			arr[i][j]=-1;
		return 1;
	}
	int IsWinning(int i,int j) {
		int sum=0;
		int var1,var2;
		var1=0;
		var2=0;
		for(int k1=1;k1<=4;k1++)
		{
			sum=0;
			for(int k=0;k<4;k++)
			{
				sum+=arr[i+var1][j+var2];
				if(sum==4)
					return 1;
				if(sum==-4)
					return -1;
				var2=var2+2;
			}
			var2=-k1*2;
		}
		var1=0;
		var2=0;
		for(int k1=1;k1<=4;k1++)
		{
			sum=0;
			for(int k=0;k<4;k++)
			{
				sum+=arr[i+var1][j+var2];
				if(sum==4)
					return 1;
				if(sum==-4)
					return -1;
				var2=var2+1;
				var1=var1+1;
			}
			var2=-k1;
			var1=-k1;
		}
		var1=0;
		var2=0;
		for(int k1=1;k1<=4;k1++)
		{
			sum=0;
			for(int k=0;k<4;k++)
			{
				sum+=arr[i+var1][j+var2];
				if(sum==4)
					return 1;
				if(sum==-4)
					return -1;
				var2=var2-1;
				var1=var1+1;
			}
			var2=k1;
			var1=-k1;
		}
		return 0;
	}
	public void ShowGameStatus(int m){
		for(int i=10;i<10+2*m;i++)
		{
			for(int j=10;j<10+2*m;j++)
			{
				if(i%2!=j%2)
					System.out.print("   ");
				else if(arr[i][j]==1 && i%2==0)
					System.out.print(" X ");
				else if(arr[i][j]==1 && i%2==1)
					System.out.print(" X ");
				else if(arr[i][j]==-1 && i%2==0)
					System.out.print(" O ");
				else if(arr[i][j]==-1 && i%2==1)
					System.out.print(" O ");
				else
					System.out.print(" . ");
			}
			System.out.println("\n");
		}
	}
}