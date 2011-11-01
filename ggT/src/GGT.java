
public class GGT 
{
	private int steps;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		GGT myGGT = new GGT();
		myGGT.steps = 0;
		myGGT.ggT(132,48);
	}
	
	public int ggT(int a, int b) 
	{
		System.out.println(a + ", " + b);
		if (a == b) {
			System.out.println("GGT:\t" + a);
			System.out.println("Steps:\t" + this.steps);
			return a;
		}
		if (this.steps > 100) return 1;
		this.steps++;
		if (a < b) a = this.ggT(a, b-a);
		if (b < a) a = this.ggT(a-b, b);
		return a;
	}
}
