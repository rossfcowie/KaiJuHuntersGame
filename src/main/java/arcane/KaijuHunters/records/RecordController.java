package arcane.KaijuHunters.records;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stats")
@CrossOrigin
public class RecordController {

	private RecordService service;
	
	@Autowired
	public RecordController(RecordService service) {
		super();
		this.service=service;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RecordDTO>> readRecords()
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		List<RecordDTO> records = null;

		try {
			records = service.readRecords();
		} catch (Exception e) {
		}
		return new ResponseEntity<List<RecordDTO>>(records, HttpStatus.OK);
	}
}
