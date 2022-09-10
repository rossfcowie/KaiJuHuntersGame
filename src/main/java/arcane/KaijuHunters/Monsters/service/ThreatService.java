package arcane.KaijuHunters.Monsters.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.datastorage.ThreatRepo;
import arcane.KaijuHunters.Monsters.dto.ThreatDTO;

@Service
public class ThreatService {
	@Autowired
	ThreatRepo repo;
	@Autowired
	MonsterService mservice;
	
	@Autowired
	public ThreatService(ThreatRepo repo, MonsterService mservice) {
		this.repo=repo;
		this.mservice = mservice;
	}
	
	private ThreatDTO map(Threat t) {
		ThreatDTO dto =  new ThreatDTO(t);
		dto.loadMonster(t.getBaseMonster());
		return dto;
	}
	
	public Threat createThreat(Monster mon) {
		Threat t = new Threat(mon);
		return repo.save(t);
	}
	
	public ThreatDTO moveThreat(Long threatID, int x, int y) {
		Threat t = repo.getById(threatID);
		t.setX(x);
		t.setY(y);
		return map(repo.save(t));
		
	}
	
	public ThreatDTO noteDamage(Long threatID, Long damage, Long accountID) throws Exception {
		Threat t = repo.getById(threatID);
		if(t.getHp()>0) {
			t.setHp(t.getHp()-damage);
			return map(repo.save(t));
		}else {
			throw new Exception();
		}
	}
	public List<ThreatDTO> readThreats() {
    	List<Threat> threats = repo.findAll();
    	List<ThreatDTO> dtos = new ArrayList<>();
       	threats.forEach(t->dtos.add(map(t)));
    	return dtos;
		
	}

	public ThreatDTO readThreat(Long tid) {
		Threat t =repo.getById(tid);
		return map(t);
	}
}
