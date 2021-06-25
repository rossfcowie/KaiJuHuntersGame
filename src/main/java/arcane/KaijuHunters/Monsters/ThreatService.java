package arcane.KaijuHunters.Monsters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ThreatService {

	ThreatRepo repo;
	MonsterRepo mRepo;
	private ThreatDTO map(Threat t) {
		return new ThreatDTO(t);
		
	}
	
	public ThreatDTO createThreat(Long monsterID) {
		Threat t = new Threat(mRepo.getById(monsterID));
		return map(repo.save(t));
	}
	
	public List<ThreatDTO> readThreats() {
		return this.repo.findAll().stream().map(this::map).collect(Collectors.toList());
	}
}
