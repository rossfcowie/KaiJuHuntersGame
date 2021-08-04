package arcane.KaijuHunters.Monsters.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.service.MonsterService;
import arcane.KaijuHunters.account.Account;
import arcane.KaijuHunters.account.AccountDTO;

@RestController
@RequestMapping(path = "/monsters")
@CrossOrigin
public class MonsterController {

	private MonsterService service;
	
	@Autowired
	public MonsterController(MonsterService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Monster>> readMonsters(@Validated @RequestBody AccountDTO dto)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		List<Monster> monsters = null;

		try {
			monsters = service.readMonsters();
		} catch (Exception e) {
		}
		return new ResponseEntity<List<Monster>>(monsters, HttpStatus.OK);
	}
	@PostMapping("/document")
	public ResponseEntity<Monster> createMonster(@Validated @RequestBody Monster mon)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		Monster newMonster = null;

		try {
			newMonster = service.createMonster(mon);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
		return new ResponseEntity<Monster>(newMonster, HttpStatus.CREATED);
	}
}
