package arcane.KaijuHunters.Monsters.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import arcane.KaijuHunters.Monsters.controllers.ThreatController;
import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.dto.ThreatDTO;
import arcane.KaijuHunters.records.RecordService;


@Component
@Transactional
public class ThreatGenerator  {
	static ArrayList<Long> dead = new ArrayList<Long>();
	@Autowired
	private ThreatController controller;
	@Autowired
	private ThreatService service;
	@Autowired
	private MonsterService mservice;
	@Autowired
	private RecordService rservice;
	@Autowired
	public ThreatGenerator(MonsterService mservice,ThreatService service) {
		super();
		this.service = service;
		this.mservice = mservice;
	}
	

	@Scheduled(fixedDelay=30000)
	public void moveThreats() {
		List<ThreatDTO> t = service.readThreats();
		t.removeIf(n -> (dead.contains(n.getId())));
		for (ThreatDTO threat : t) {
			System.out.println(threat);
			int x = (threat.getX()+ (int)(Math.random()*3)-1);
			int y = (threat.getY()+ (int)(Math.random()*3)-1);
			 while (x<0 || y<0) {
				x = (threat.getX()+ (int)(Math.random()*3)-2);
				y = (threat.getY()+ (int)(Math.random()*3)-2);
			}
			 controller.move(threat.getId(),x,y);
		}
	}
	
	@Scheduled(fixedDelay=300)
	public void createThreat() {
		int x = 0;
		List<Monster> m = mservice.readMonsters();
		List<ThreatDTO> t = service.readThreats();
		t.removeIf(n -> (dead.contains(n.getId())));
		for (ThreatDTO threat : t) {
			if(threat.getChp()>0) {
				x++;
			}else {
				dead.add(threat.getId());
				rservice.allowClaims(threat.getId());
			}
		}
		
		if(x>7) {
			
		}else {
			if(m.size()>0) {
				Monster m2 = mservice.mRepo.save(service.createThreat(m.get((int) (Math.random() *m.size()))).getBaseMonster());
				System.out.println("created monster");
				System.out.println(m2);
			}else {
				System.out.println("no data avaliable");
			}
		}
	}
	
}
