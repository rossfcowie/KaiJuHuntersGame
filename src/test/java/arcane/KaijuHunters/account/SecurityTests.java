package arcane.KaijuHunters.account;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecurityTests {
	
	@Test
	void passwordTests() {
		Assertions.assertTrue(PasswordSecurity.encrypt("password").equals(PasswordSecurity.encrypt("password")));
		Assertions.assertFalse(PasswordSecurity.encrypt("password").equals(PasswordSecurity.encrypt("passworsd")));
		Assertions.assertTrue(PasswordSecurity.encrypt("D4nc£D4nc3$").equals(PasswordSecurity.encrypt("D4nc£D4nc3$")));
		Assertions.assertFalse(PasswordSecurity.encrypt("D4nc£D4nc3$").equals(PasswordSecurity.encrypt("D4nc£D4nc3")));
	}
}
