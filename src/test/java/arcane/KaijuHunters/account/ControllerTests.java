package arcane.KaijuHunters.account;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@SpringBootTest
public class ControllerTests {

	@MockBean
	private UserService service;
	
	@Autowired
	private AccountController controller;
	

	Account acc = new Account(1L, "gura", "a");
	AccountDTO dto = new AccountDTO(1L, "gura", "a");
	
	@BeforeEach
	void init() {
		
	}
	
	@Test
	void createTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		when(service.create(Mockito.any(AccountDTO.class))).thenReturn(acc);
		ResponseEntity<Account> response = new ResponseEntity<>(acc, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.createUser(dto));
		verify(service, times(1)).create(Mockito.any(AccountDTO.class));
	}
	
	@Test
	void loginTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		when(service.login(Mockito.any(AccountDTO.class))).thenReturn(true);
		when(service.read(Mockito.any())).thenReturn(acc);
		ResponseEntity<String> response = new ResponseEntity<>("gura:50219477", HttpStatus.OK);
		assertThat(response).isEqualTo(controller.loginAsUser(dto));
		verify(service, times(1)).login(Mockito.any(AccountDTO.class));
	}
	
}
