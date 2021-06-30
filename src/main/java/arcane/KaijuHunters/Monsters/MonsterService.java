package arcane.KaijuHunters.Monsters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterService {

	@Autowired
	MonsterRepo mRepo;
	
	@Autowired
	public MonsterService(MonsterRepo mRepo) {
		this.mRepo=mRepo;
	}
	
	public Monster createMonster(Monster m) {
		return mRepo.save(m);
	}
	
	public List<Monster> readMonsters() {
		return mRepo.findAll();
	}
	
}
