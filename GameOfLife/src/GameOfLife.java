
public class GameOfLife {
private boolean [][] grid;
private boolean [][] tempGrid=new boolean[5][5];
public GameOfLife(boolean[][] grid){
	this.grid=grid;
}
public void nextGeneration()
{
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {
			int say=0;
			  for (int z = -1; z <= 1; z++) {
				for (int k = -1; k <= 1; k++) {
					if(z==0 && k==0)
						continue;
					else
					{
						if((i+z)>=0 && (j+k)>=0 && (i+z)< grid.length && (j+k)< grid.length && grid[i+z][j+k]==true)
						{
							say++;
						}
					}
				}
				
				
		}
			/*if(i!=0 && j!=0 && grid[i-1][j-1]==true)
				say++;
			if(j!=0 && grid[i][j-1]==true)
				say++;
			if(i!=4 && j!=0 && grid[i+1][j-1]==true)
				say++;
			if(i!=0 && grid[i-1][j]==true)
				say++;
			if(i!=4 && grid[i+1][j]==true)
				say++;
			if(j!=4 && i!=0 && grid[i-1][j+1]==true)
				say++;
			if(j!=4 && grid[i][j+1]==true)
				say++;
			if(i!=4 && j!=4 && grid[i+1][j+1]==true)
				say++;
			*/
			
			if(say==3)
			tempGrid[i][j]=true;
		else if(say==2)
		{
			if(grid[i][j]==true)
				tempGrid[i][j]=true;
			else
				tempGrid[i][j]=false;
		}
		else
			tempGrid[i][j]=false;
		}
	   }
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {
			if(grid[i][j]!=tempGrid[i][j])
				grid[i][j]=tempGrid[i][j];
		}
	}
}
public void displayGrid()
{
	   for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid.length; j++) {
			if(grid[i][j]==true)
				System.out.print("*");
			else
				System.out.print("_");
		}
		System.out.println();
	   }
	   
}
}
