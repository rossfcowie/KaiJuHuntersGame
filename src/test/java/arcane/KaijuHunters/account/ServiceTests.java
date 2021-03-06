package arcane.KaijuHunters.account;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;

@SpringBootTest
public class ServiceTests {
	
	@Autowired
	UserService service;
	
	@MockBean
	AccountRepo repo;
	
	@Test
	void loginWorks(){
		Account acc = new Account(1L, "gura", "a");
		AccountDTO dto = new AccountDTO(1L, "gura", "a");
		when(repo.findOne(Mockito.any())).thenReturn(Optional.of(acc));
		Assertions.assertTrue(service.login(dto));
	}
	
	@Test
	void loginfails(){
		Account acc = new Account(1L, "gura", "a");
		AccountDTO dto = new AccountDTO(1L, "gura", "aa");
		when(repo.findOne(Mockito.any())).thenReturn(Optional.of(acc));
		Assertions.assertFalse(service.login(dto));
	}
	
	@Test
	void signup(){
		Account acc = new Account(1L, "gura", "a");
		AccountDTO dto = new AccountDTO(1L, "gura", "a");
		when(repo.save(Mockito.any())).thenReturn(acc);
		Assertions.assertEquals(acc,service.create(dto));
	}
	
	@Test
	void read(){
		Account acc = new Account(1L, "gura", "a");
		when(repo.findOne(Mockito.any())).thenReturn(Optional.of(acc));
		Assertions.assertEquals(acc,service.read("gura"));
	}
	
	@Test
	void cookiecheck(){
		Account acc = new Account(1L, "gura", "a");
		when(repo.findOne(Mockito.any())).thenReturn(Optional.of(acc));
		Assertions.assertTrue(service.cookiecheck("gura", 50219477));
	}
	
	@Test
	void cookieCheckBad(){
		Account acc = new Account(1L, "gura", "a");
		when(repo.findOne(Mockito.any())).thenReturn(Optional.of(acc));
		Assertions.assertFalse(service.cookiecheck("gura", 50219478));
	}
}
