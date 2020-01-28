//Its the game between two Humans

import java.util.*;
interface TTTMain {
	int Check(int i,int j,int player,int m);
	int IsWinning(int m);
	void ShowGameStatus(int m);
}
public class NewNxN {
	public static void main(String[] args) {
		TicTacToeMain t = new TicTacToeMain();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of Tic-Tac-Toe Game ");
		t.n = s.nextInt();
		do
		{
			if(t.player==1)
				System.out.println("Player 1 play your Move");
			else
				System.out.println("Player 2 play your Move");
			System.out.println("Enter Co-ordinates");
			t.i = s.nextInt();
			t.j = s.nextInt();
			if(t.Check(t.i,t.j,t.player,t.n)==1)
			{
				t.count++;
				t.player=-(t.player);
				t.ShowGameStatus(t.n);
			}
		}while(t.IsWinning(t.n)==0 && t.count<((t.n)*(t.n)));
		if(t.IsWinning(t.n)==1)
			System.out.println("Player 1 Won");
		else if(t.IsWinning(t.n)==-1)
			System.out.println("Player 2 Won");
		else
			System.out.println("Match Draw");
	}
}
class TicTacToeMain implements TTTMain {
	int player=1,i,j;
	int arr[][] = new int[100][100];
	int count = 0;  
	int n;
	int b[][] = new int[100][100];
	public int Check(int i,int j,int player,int m){
		if(i<0||i>m||j<0||j>m)
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
		{
			arr[i][j]=1;
			b[i][j]=1;
		}
		else
		{
			arr[i][j]=-1;
			b[i][j]=-1;
		}
		for(int i1=0;i1<m;i1++)
			for(int j1=0;j1<m;j1++)
				b[i1][j1]=arr[i1][j1];
		return 1;
	}
	public int IsWinning(int m) {
		int i,j;
		while(m>=1)
		{
			for(int i1=0;i1<(m/3);i1++)
			{
				for(int j1=0;j1<(m/3);j1++)
				{
					i=3*i1;
					j=3*j1;
					if((b[i][j] + b[i][j+1] + b[i][j+2]==3)||
						(b[i+1][j] + b[i+1][j+1] + b[i+1][j+2]==3)||
						(b[i+2][j] + b[i+2][j+1] + b[i+2][j+2]==3)||
						(b[i][j] + b[i+1][j] + b[i+2][j]==3)||
						(b[i][j+1] + b[i+1][j+1] + b[i+2][j+1]==3)||
						(b[i][j+2] + b[i+1][j+2] + b[i+2][j+2]==3)||
						(b[i][j] + b[i+1][j+1] + b[i+2][j+2]==3)||
						(b[i][j+2] + b[i+1][j+1] + b[i+2][j]==3))
							b[i1][j1]=1;
					else if((b[i][j] + b[i][j+1] + b[i][j+2]==-3)||
							(b[i+1][j] + b[i+1][j+1] + b[i+1][j+2]==-3)||
							(b[i+2][j] + b[i+2][j+1] + b[i+2][j+2]==-3)||
							(b[i][j] + b[i+1][j] + b[i+2][j]==-3)||
							(b[i][j+1] + b[i+1][j+1] + b[i+2][j+1]==-3)||
							(b[i][j+2] + b[i+1][j+2] + b[i+2][j+2]==-3)||
							(b[i][j] + b[i+1][j+1] + b[i+2][j+2]==-3)||
							(b[i][j+2] + b[i+1][j+1] + b[i+2][j]==-3))
							b[i1][j1]=-1;
					else
						b[i1][j1]=0;
				}
			}
			m=m/3;
		}
		return b[0][0];
	}
	public void ShowGameStatus(int m){
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(j==0)
					System.out.print("\n");
				if(arr[i][j]==1)
					System.out.print("|_X_|");
				else if(arr[i][j]==-1)
					System.out.print("|_0_|");
				else
					System.out.print("|_ _|");
			}
		}
		System.out.print("\n");
	}
}