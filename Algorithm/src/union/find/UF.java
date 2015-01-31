package union.find;

/**
 * 
 * @author debmalyajash Union Find
 */
public class UF {
	// element container
	private int[] id;

	// number of element
	private int count;

	/**
	 * 
	 * @param N
	 *            - count of elements.
	 */
	public UF(int N) {
		count = N;
		id = new int[N];
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
		if (p < count) {
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
		id[p] = id[q];
		for (int i = 0; i < count; i++) {
			if (id[i] == p) {
				id[i] = q;
			}
		}
	}

}
