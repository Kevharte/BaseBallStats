import java.util.Scanner;
public class Calculate_stats {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter player name");
		String player_name   = input.nextLine();
		
		System.out.println("Enter # of At Bats");
		double at_bats   = input.nextDouble();
		
		System.out.println("Enter # of hits");
		double hits      = input.nextDouble();
		
		System.out.println("Enter # of doubles");
		double doubles   = input.nextDouble();
		
		System.out.println("Enter # of triples");
		double triples   = input.nextDouble();
		
		System.out.println("Enter # of home runs");
		double home_runs = input.nextDouble();
		
		System.out.println("Enter # of walks");
		double walks     = input.nextDouble();
		
		System.out.println("Enter # of times hit by pitch");
		double HBP		  = input.nextDouble();
		
		System.out.println("Enter # of sacrifice flies");
		double SF		  = input.nextDouble();
		
		double singles = (hits - (doubles + triples + home_runs)); 
		
		System.out.print(player_name);
		System.out.print(" has a batting average of ");
		System.out.printf("%.3f", batting_average(hits,at_bats));
		System.out.print(" , a one base percentage of ");
		System.out.printf("%.3f", OBP(hits,walks,at_bats,HBP,SF));
		System.out.print(" , a slugging percentage of ");
		System.out.printf("%.3f", SLG(singles,doubles,triples,home_runs,at_bats));
		System.out.print(" , an OBS of ");
		System.out.printf("%.3f", OBS(hits,singles,doubles,triples,home_runs,walks,at_bats,HBP,SF));
		System.out.print(" and ");
		System.out.print(total_bases(singles,doubles,triples,home_runs));
		System.out.print(" total bases.");

	}
	public static double batting_average(double hits, double at_bats) {
		double BA = (hits/at_bats);
		return BA;
	}
	public static double OBP(double hits, double walks, double at_bats, double HBP, double SF) {
		double OBP = ((hits + walks + HBP)/(at_bats + walks + HBP + SF));
		return OBP;
	}
	public static double SLG(double singles, double doubles, double triples, double home_runs, double at_bats) {
		double SLG = ((singles + (doubles * 2) + (triples * 3) + (home_runs * 4))/at_bats);
		return SLG;
	}
	public static double OBS (double hits, double singles, double doubles, double triples, double home_runs, double walks, double at_bats, double HBP, double SF) {
		double OBS = (OBP(hits, walks, at_bats, HBP, SF) + SLG(singles, doubles, triples, home_runs, at_bats));
		return OBS;
	}	
	public static int total_bases(double singles, double doubles, double triples, double home_runs) {
		int TB = (int) (singles + (doubles * 2) + (triples * 3) + (home_runs * 4));
		return TB;
	}
}
