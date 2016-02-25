package banktestJ;

public class Constants {

	public static final int N = 10; // number of bank

	public static final int E = 100000;
	public static final double p = 0.2;

	public static final double theta = 0.2;
	public static final double gamma = 0.05;

	public static double r_b = 0.1;
	public static double r_i = 0.1;
	public static double r_d = 0.1;

	public static int Z = 0;

	public static boolean[][] nw = new boolean[N][N];

	public static double[][] bsG = new double[N][5]; // balanceSheetGlobal
	
	public static boolean inShock = true;
	
	public static double netWorthTreshold = 0.2;
	
	public static final int T = 52;
	
	public static double w = 0; 
}
