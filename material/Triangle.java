import java.util.*;

class Triangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();

		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();

		double x3 = scanner.nextDouble();
		double y3 = scanner.nextDouble();

		double a = Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3));
		double b = Math.sqrt((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3));
		double c = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));

		double B = Math.acos((b*b - a*a -c*c) / (-2*a*c));
		double area = 0.5*a*c*Math.sin(B);
		boolean isDegenerated = Math.abs(area) < 1e-10;//area == 0

		System.out.println(a + " " + b + " " + c);
		System.out.println(B/Math.PI*180.0);
		System.out.println(area);
		System.out.println(isDegenerated);
	}
}