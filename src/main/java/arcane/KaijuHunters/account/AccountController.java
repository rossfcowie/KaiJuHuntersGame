package arcane.KaijuHunters.account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<AccountDTO> createUser(@Validated @RequestBody AccountDTO dto)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		AccountDTO newUser = null;

		try {
			newUser = userService.create(dto);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
		return new ResponseEntity<AccountDTO>(newUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginAsUser(@Validated @RequestBody AccountDTO userDTO) {
		AccountDTO user = userService.read(userDTO.getUname());
		if (userService.login(userDTO)) {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(String.valueOf(user.getUname()), headers, HttpStatus.OK);
			
		}

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

}
