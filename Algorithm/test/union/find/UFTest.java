package union.find;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class UFTest {

	@Test
	public void test() {
		UF uf = new UF(10);
		uf.union(1, 2);
		uf.union(3, 4);
		uf.union(5, 6);
		uf.union(7, 8);
		uf.union(7, 9);
		uf.union(2, 8);
		uf.union(0, 5);
		uf.union(1, 9);
		int r = uf.getCount();
		assertEquals(3, r);
	}

}
