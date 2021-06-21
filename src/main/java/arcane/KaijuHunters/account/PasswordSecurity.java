package arcane.KaijuHunters.account;

public class PasswordSecurity {

	
	public static String encrypt(String input) {
		System.out.println(input);
		Long outint = hash(input);
		System.out.println(outint);
		outint = (long) Math.pow(outint/31, (outint %10));
		System.out.println(outint);
		outint = (outint * 31 * 29);
		System.out.println(outint);
		try {

			outint = (long) (outint/ Math.pow(10,(outint %10)));
			if (outint<1000) {
				throw new Exception();
			}
		} catch (Exception e) {
			outint = (long) outint/10;
		}
		System.out.println(outint);
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
