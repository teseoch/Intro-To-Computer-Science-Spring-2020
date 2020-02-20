class GOL {
	final static String ALIVE = "\u2B1B";
	// final static String ALIVE = "x";
	final static String DEAD = "  ";

	public static void main(String[] args) {
		int n = 100;

		boolean[][] alive = new boolean[n][n];
		initalize(alive, 0.2);
		
		// System.out.println(isAlive(alive, -1, -1));
		// alive[0][3] = true;
		// alive[1][3] = true;
		// alive[2][3] = true;
		
		// alive[9][0] = true;
		// alive[9][1] = true;
		// alive[9][2] = true;

		while(true)
		{
			print(alive);
			update(alive);

			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e){}

			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	}

	public static void print(boolean[][] grid)
	{
		int n = grid.length;

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(grid[i][j])
					System.out.print(ALIVE);
				else
					System.out.print(DEAD);
			}
			System.out.println();
		}
	}

	public static void initalize(boolean[][] grid, double perc)
	{
		int n = grid.length;

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				//perc < 0, if(Math.random() < perc) always false
				//perc >=1, if(Math.random() < perc) always true
				//perc =0.5, if(Math.random() < perc) always 50/50
				// if(Math.random() < perc)
				// 	grid[i][j] = true;
				// else
				// 	grid[i][j] = false;
				grid[i][j] = Math.random() < perc;
			}
		}
	}

	public static boolean isAlive(boolean[][] grid, int i, int j)
	{
		int n = grid.length;
		//problem i,j < 0 || i,j >= n
		int indexi = (i + n) % n;
		int indexj = (j + n) % n;
		return grid[indexi][indexj];
	}

	public static int countAliveNeigh(boolean[][] grid, int i, int j)
	{
		int nAlive = 0;
		for(int x = -1; x <= 1; ++x)
		{
			for(int y = -1; y <= 1; ++y)
			{
				if(x == 0 && y == 0)
					continue;

				if(isAlive(grid, i+x, j+y))
					++nAlive;
			}
		}

		return nAlive;
	}

	public static void update(boolean[][] grid)
	{
		int n = grid.length;

		boolean[][] newGrid	= new boolean[n][n];

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				int nAlive = countAliveNeigh(grid, i, j);

				if(isAlive(grid, i, j))
				{
					if(nAlive < 2)
						newGrid[i][j] = false;
					else if(nAlive == 2 || nAlive == 3)
						newGrid[i][j] = true;
					else //if(nAlive > 3)
					newGrid[i][j] = false;
				}
				else
				{
					if(nAlive == 3)
						newGrid[i][j] = true;
					else
						newGrid[i][j] = false;
				}
			}
		}

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				grid[i][j] = newGrid[i][j];
			}
		}
	}
}