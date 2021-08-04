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
import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.datastorage.ThreatRepo;
import arcane.KaijuHunters.Monsters.dto.ThreatDTO;
import arcane.KaijuHunters.Monsters.service.ThreatService;

@SpringBootTest
public class ThreatServiceTests {
	
	@Autowired
	ThreatService service;
	
	@MockBean
	ThreatRepo repo;

	@MockBean
	MonsterRepo mRepo;
	
	@Test
	void createThreat(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L, a, a);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(mRepo.getById(Mockito.any())).thenReturn(m);
		when(repo.save(Mockito.any())).thenReturn(t);
		Assertions.assertEquals(t,service.createThreat(m));
	}
	
	@Test
	void attackThreat() throws Exception{
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L, a, a);
		Threat t = new Threat(m);
		Threat t2 = new Threat(m);
		t2.setHp(t2.getHp()-100);
		ThreatDTO dto =  new ThreatDTO(t);
		when(mRepo.getById(Mockito.any())).thenReturn(m);
		when(repo.getById(Mockito.any())).thenReturn(t);
		when(repo.save(Mockito.any())).thenReturn(t);
		Assertions.assertEquals(dto,service.noteDamage(1L,100L,1L));
	}
	
	@Test
	void ReadThreats(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L, a, a);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(repo.findAll()).thenReturn(List.of(t));
		Assertions.assertEquals(List.of(dto),service.readThreats());
	}
}
