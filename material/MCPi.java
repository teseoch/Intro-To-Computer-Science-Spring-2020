class MCPi {
	public static void main(String[] args) {
		long insides = 0;
		long total = 0;

		while(true){
		// for(int i =0; i < 100000000; ++i) {
			double x = Math.random()*2-1;
			double y = Math.random()*2-1;

			//x**2 not java
			double dist2 = x*x + y*y;
			boolean isInside = dist2 <= 1;

			if(isInside)
				++insides;
			++total;

			if(total % 10000000 == 0){
				double piApprox = (4.0 * insides) / total;
				System.out.println(piApprox);
			}
		}


		// System.out.println(x + "," + y + "? "+ isInside);
	}
}