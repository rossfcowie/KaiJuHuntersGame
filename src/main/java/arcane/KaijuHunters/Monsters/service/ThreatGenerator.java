package arcane.KaijuHunters.Monsters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.dto.ThreatDTO;


@Component
public class ThreatGenerator {
	@Autowired
	private ThreatService service;
	@Autowired
	private MonsterService mservice;
	@Autowired
	public ThreatGenerator(MonsterService mservice,ThreatService service) {
		super();
		this.service = service;
		this.mservice = mservice;
	}
	@Scheduled(fixedDelay=300)
	public void aaa() {
		int x = 0;
		List<Monster> m = mservice.readMonsters();
		for (ThreatDTO threat : service.readThreats()) {
			if(threat.getChp()>0) {
				x++;
			}
		}
		
		if(x>7) {
			System.out.println("Capacity reached");
		}else {
			if(m.size()>0) {
				
				System.out.println();
				mservice.mRepo.save(service.createThreat(m.get((int) (Math.random() *m.size()))).getBaseMonster());
				System.out.println("created monster");
			}else {
				System.out.println("no data avaliable");
			}
		}
	}
	
}
