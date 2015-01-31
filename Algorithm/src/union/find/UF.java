package union.find;

import java.util.Scanner;



/**
 * 
 * @author debmalyajash Union Find
 */
public class UF {
	// element container
	private int[] id;

	// number of components.
	private int count;

	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param N
	 *            - count of elements.
	 */
	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/**
	 * 
	 * @param p
	 *            first id
	 * @param q
	 *            second id
	 * @return true if first and second are connected, false otherwise.
	 */
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	/**
	 * 
	 * @param p
	 * @return if p is there otherwise throw exception
	 */
	public int find(int p) {
		if (p < id.length) {
			return id[p];
		}
		throw new RuntimeException("No element at index " + p);
	}

	/**
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) return;
		id[p] = id[q];
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}			
		}
		count--;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			UF uf = new UF(N);
			while (scanner.hasNextInt()) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if (uf.connected(p, q))
					continue;
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
			System.out.println(uf.getCount() + " components");
		}

		
		
	}
}
