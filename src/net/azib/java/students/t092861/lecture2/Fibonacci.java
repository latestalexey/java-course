import java.math.BigInteger;

/**
 * @author Stanislav / 092861
 * 
 */
public class Fibonacci {

	/**
	 * @param n
	 *            - last index of the sequence
	 * @return the sum of Fibonacci sequence
	 */
	public BigInteger generate(int n) {
		int index = n + 1;
		BigInteger[] array = new BigInteger[index];
		BigInteger sum = null;
		array[0] = BigInteger.ZERO;
		array[1] = BigInteger.ONE;
		for (int i = 2; i < index; i++) {
			sum = array[i - 1].add(array[i - 2]);
			array[i] = sum;
			// System.out.println("F" + i + "= " + sum);
		}
		return sum;
	}
}
