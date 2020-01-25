//Its the game between two Humans

import java.util.*;
interface TTTMain {
	int Check(int i,int j,int player);
	boolean IsWinning(int player);
	void ShowGameStatus();
}
public class UTicTacToe {
	public static void main(String[] args) {
		TicTacToeMain t = new TicTacToeMain();
		Scanner s = new Scanner(System.in);
		do
		{
			if(t.player==1)
				System.out.println("Player 1");
			else
				System.out.println("Player 2");
			System.out.println("Enter x and y places");
			t.i = s.nextInt();
			t.j = s.nextInt();
			if(t.Check(t.i,t.j,t.player)==1)
			{
				t.count++;
				t.player=-(t.player);
				t.ShowGameStatus();
			}
		}while(t.count<=9 && t.IsWinning(-t.player)==false);
		if(t.IsWinning(-t.player)==true)
		{
			if(t.player==1)
				System.out.println("Player 2 Won");
			else
				System.out.println("Player 1 Won");
		}
		else
			System.out.println("Match Draw");
	}
}
class TicTacToeMain implements TTTMain {
	int player=1,i,j;
	int arr[][] = new int[3][3];
	int count = 0;  
	public int Check(int i,int j,int player){
		if(i<0||i>2||j<0||j>2)
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
	public boolean IsWinning(int player) {
		int score;
		if(player==1)
			score=3;
		else
			score=-3;
		return ((arr[0][0] + arr[0][1] + arr[0][2]==score)||
				(arr[1][0] + arr[1][1] + arr[1][2]==score)||
				(arr[2][0] + arr[2][1] + arr[2][2]==score)||
				(arr[0][0] + arr[1][0] + arr[2][0]==score)||
				(arr[0][1] + arr[1][1] + arr[2][1]==score)||
				(arr[0][2] + arr[1][2] + arr[2][2]==score)||
				(arr[0][0] + arr[1][1] + arr[2][2]==score)||
				(arr[0][2] + arr[1][1] + arr[2][0]==score));
	}
	public void ShowGameStatus(){
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if((i==1 && j==0)||(i==2 && j==0))
					System.out.print("\n");
				if(arr[i][j]==1)
					System.out.print("|_X_|");
				else if(arr[i][j]==-1)
					System.out.print("|_0_|");
				else
					System.out.print("|_ _|");
			}
		}
	}
}