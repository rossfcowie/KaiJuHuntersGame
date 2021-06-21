package arcane.KaijuHunters.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	AccountRepo repo;
	
	@Autowired
	public UserService(AccountRepo repo) {
		this.repo = repo;
	}
	
	public Account create(AccountDTO dto) {
		return repo.save(new Account(dto));
	}

	private AccountDTO map(Account a) {
		
		return new AccountDTO(a);
	}

	public boolean login(AccountDTO userDTO) {
		Account a = repo.findOne(Example.of(new Account(userDTO.getUname()))).get();
		System.out.println(a);
		System.out.println(userDTO);
		return a.checkPassword(userDTO.getPassword());
	}

	public AccountDTO read(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

}
