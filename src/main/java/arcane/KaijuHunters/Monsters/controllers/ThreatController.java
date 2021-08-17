package arcane.KaijuHunters.Monsters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arcane.KaijuHunters.Monsters.dto.ThreatDTO;
import arcane.KaijuHunters.Monsters.service.ThreatService;
import arcane.KaijuHunters.records.RecordService;

@RestController
@RequestMapping(path = "/threat")
@CrossOrigin
public class ThreatController {

	private ThreatService service;

	private RecordService rservice;

	@Autowired
	public ThreatController(ThreatService service, RecordService s) {
		super();
		this.service = service;
		this.rservice = s;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ThreatDTO>> read() {
		List<ThreatDTO> threats = service.readThreats();
		System.out.println(threats);
		return new ResponseEntity<>(threats, HttpStatus.OK);
	}

	@PutMapping("/atk/{tid}/{aid}/{dmg}")
	public ResponseEntity<ThreatDTO> attack(@PathVariable Long tid, @PathVariable Long aid, @PathVariable Long dmg) {
		ThreatDTO dto;
		try {
			dto = service.noteDamage(tid, dmg, aid);
			rservice.updateRecord(tid, dmg, aid);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	@PutMapping("/move/{tid}/{x}/{y}")
	public ResponseEntity<ThreatDTO> move(@PathVariable Long tid, @PathVariable int x, @PathVariable int y) {
		System.out.println("x"+x + ",y"+y);
		ThreatDTO dto;
		try {
			dto = service.moveThreat(tid, x, y);
			System.out.println(dto);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
