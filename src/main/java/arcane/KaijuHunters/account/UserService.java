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

	public boolean login(AccountDTO userDTO) {
		Account a = repo.findOne(Example.of(new Account(userDTO.getUname()))).get();
		return a.checkPassword(userDTO.getPassword());
	}

	public Account read(String uname) {
		Account a = repo.findOne(Example.of(new Account(uname))).get();
		return a;
	}

	public boolean cookiecheck(String uname, int hash) {
		Account a = repo.findOne(Example.of(new Account(uname))).get();
		System.out.println(a);
		System.out.println(a.hashCode());
		return hash == a.hashCode();
	}
}
