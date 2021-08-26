/******************************************************************************
 *  Compilation:  javac HanoiVariant.java
 *  Execution:    java HanoiVariant n
 *  Partners:     Arib Chowdhury, Vladislav Vostrikov, Brian Rabinowitz
 *
 *  Shows the solving of a variant of towers of Hanoi problem. Where there are 2n disks of
 *  size 1 through 2n, where all the odd disks are on the left tower and all the even disks are on
 *  the right tower. The program provides a sequence of motions that swaps the two towers.
 *
 * $ java HanoiVariant 2
 * 1 Left
 * 1 Left
 * 2 Right
 * 1 Left
 * 1 Right
 * 2 Left
 * 1 Right
 * 3 Right
 * 1 Right
 * 2 Left
 * 1 Right
 * 4 Right
 * 1 Right
 * 2 Left
 * 1 Right
 * 3 Right
 * 1 Right
 * 2 Left
 * 1 Right
 * 1 Left
 * 2 Right
 * 1 Left
 * 1 Left
 *
 * $ java HanoiVariant 1
 * 1 Right
 * 2 Right
 * 1 Right



 ******************************************************************************/




public class HanoiVariant{
	public static void hanoi(int n, boolean right){
		if (n==0) return;
		hanoi(n-1,!right);
		if (right) System.out.println(n+" Right");
		else System.out.println(n+" Left");
		hanoi(n-1,!right);
	}
	public static void hanoiVariant(int n){
		for (int i=1;i<2*n-1;i++) {
			hanoi(i,i%2==0);
		}
		hanoi(2*n-1,(2*n-1)%2==1);
		System.out.println(2*n+" Right");
		hanoi(2*n-1,(2*n-1)%2==1);
		for (int i=1;i<2*n-1;i++) {
			hanoi(2*n-1-i,(2*n-1-i)%2==0);
		}
	}

	public static void main(String[] args){
		int n=Integer.parseInt(args[0]);
		hanoiVariant(n);
	}
}
