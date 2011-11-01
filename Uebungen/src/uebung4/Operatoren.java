package uebung4;

public class Operatoren
{
	public static void main(String args[])
	{
          int x = 2, y, z;
          // Zuweisungsoperatoren
          x *= 3 + 2;              System.out.println(x);   /* 10 */
          x *= y = z = 4;          System.out.println(x);   /* 40 */
          // arithmestische Operatoren
          x = - 3 + 4 * 5 - 6;     System.out.println(x); /* 11 */
          
          // Modulo
          // Modulo = x % 5 = Rest von x / 5
          x = 3 + 4 % 5 - 6;       System.out.println(x); /* 1 */
          // 4 % 5 = 4, nicht 1!
          
          x = -3 * 4 % - 6 / 5; System.out.println(x);   /* 0 */
          // -12 % -6 = 0, nicht -6 und auch nicht 2 (-12/-6=2)!
          
          x = (7 + 6) % 5 / 2;    System.out.println(x); /* 1 */
          // 13 % 5 = 3 / 2 = 1.5, da x aber int => 1
          
          // Inkrement Operatoren
          x = y = 1;
          z = x ++ -1;             System.out.println(x + "\t" + z); /* 2   0 */
          /*  1    -1 */
          
          z += - x ++ + ++ y;      System.out.println(x + "\t" + z); /* 3  0 */
          /*   - 2    +    2 */
          
          z = x / ++ x ; System.out.println(z); /* 0.75, also 0, weil z int ist */
          /*  3 / 4   */
	}
}