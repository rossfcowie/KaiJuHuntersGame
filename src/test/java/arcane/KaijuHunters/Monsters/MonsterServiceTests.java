package arcane.KaijuHunters.Monsters;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.MonsterRepo;
import arcane.KaijuHunters.Monsters.service.MonsterService;

@SpringBootTest
public class MonsterServiceTests {
	
	@Autowired
	MonsterService service;
	
	@MockBean
	MonsterRepo mRepo;
	
	@Test
	void createMonster(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		when(mRepo.save(Mockito.any())).thenReturn(m);
		Assertions.assertEquals(m,service.createMonster(m));
	}
	
	@Test
	void readMonsters(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		when(mRepo.findAll()).thenReturn(List.of(m));
		Assertions.assertEquals(List.of(m),service.readMonsters());
	}
}
