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

		
		Monster m = new Monster("Big fish","Pictures/Boss%20Big%20Fish.png",100000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		m = new Monster("Colossal Bat","Pictures/Colossal%20Bat.png",50000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		m = new Monster("Colossal Crow","Pictures/Colossal%20Dark%20Crow.png",60000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		m = new Monster("Colossal Scorpion","Pictures/Colossal%20Scorpion.png",80000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		m = new Monster("Colossal Snake","Pictures/Colossal%20Snake.png",70000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		m = new Monster("Colossal Centipede","Pictures/Insects%20Giant%20Bug%20Centipede.png",120000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		m = new Monster("Colossal Beetle","Pictures/Insects%20Giant%20Bug%20Hercules.png",200000L);
		m.addLoot(1,15);
		m.addLoot(2,15);
		m.addLoot(3,15);
		m.addLoot(4,15);
		m.addLoot(5,15);
		service.createMonster(m);
		System.out.println(m);
		
	}
	
}
