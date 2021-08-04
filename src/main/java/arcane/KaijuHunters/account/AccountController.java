package arcane.KaijuHunters.account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin
public class AccountController {

	private UserService userService;

	@Autowired
	public AccountController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/signup")
	public ResponseEntity<Account> createUser(@Validated @RequestBody AccountDTO dto)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		Account newUser = null;

		try {
			newUser = userService.create(dto);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
		return new ResponseEntity<Account>(newUser, HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<String> loginAsUser(@Validated @RequestBody AccountDTO userDTO) {
		if (userService.login(userDTO)) {
			Account u = userService.read(userDTO.uname);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(String.valueOf(u.uname + ":" +u.hashCode()), headers, HttpStatus.OK);
			
		}

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/bypass")
	public ResponseEntity<Boolean> cookieAsUser(@RequestHeader("key") String userKey) {
		String uname[]  = userKey.split(":");
		System.out.println(uname[0]);
		System.out.println(uname[1]);
		if (userService.cookiecheck(uname[0],Integer.valueOf(uname[1]))) {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(true, headers, HttpStatus.OK);
			
		}

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}
	
}
