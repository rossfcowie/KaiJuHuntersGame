package arcane.KaijuHunters.account;

public class PasswordSecurity {

	
	public static String encrypt(String input) {
		Long outint = hash(input);
		outint = (long) Math.pow(outint/31, (outint %10));
		outint = (outint * 31 * 29);
		try {

			outint = (long) (outint/ Math.pow(10,(outint %10)));
			if (outint<1000) {
				throw new Exception();
			}
		} catch (Exception e) {
			outint = (long) outint/10;
		}
		return outint.toString();
	}
	
	public static Long hash(String in) {
		Long total = 0L;
		for (int i = 0; i < in.length(); i++) {
			total += in.charAt(i);
		}
		return total;
	}
}
