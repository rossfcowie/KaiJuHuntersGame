package arcane.KaijuHunters.Monsters.datastorage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arcane.KaijuHunters.Monsters.service.MonsterService;

@Component
public class MonsterPresets {

	@Autowired
	private MonsterService service;
	
	@PostConstruct
	public void init() {
		
		Monster m = new Monster("Big fish","Pictures/Boss%20Big%20Fish.png",10000L);
		service.createMonster(m);
		m = new Monster("Colossal Bat","Pictures/Colossal%20Bat.png",5000L);
		service.createMonster(m);
		m = new Monster("Colossal Crow","Pictures/Colossal%20Dark%20Crow.png",6000L);
		service.createMonster(m);
		m = new Monster("Colossal Scorpion","Pictures/Colossal%20Scorpion.png",8000L);
		service.createMonster(m);
		m = new Monster("Colossal Snake","Pictures/Colossal%20Snake.png",7000L);
		service.createMonster(m);
		m = new Monster("Colossal Centipede","Pictures/Insects%20Giant%20Bug%20Centipede.png",12000L);
		service.createMonster(m);
		m = new Monster("Colossal Beetle","Pictures/Insects%20Giant%20Bug%20Hercules.png",20000L);
		service.createMonster(m);
		
	}
	
}
