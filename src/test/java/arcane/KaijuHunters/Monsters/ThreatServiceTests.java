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
	void moveThreat(){
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		Threat t = new Threat(m);
		t.setId(1L);
		Threat t2 = new Threat(m);
		t2.setId(1L);
		t2.setX(1);
		t2.setY(1);
		//id=null, name=sh-1:Indominable shark, level=1, chp=100000, x=1, y=1, species=shark, bid=1, image=shark.jpg, MaxHp=100000
		ThreatDTO dto =  new ThreatDTO(1L,1L,t2.getName(),1,100000L,1,1,"shark","shark.jpg",100000L);
		when(repo.getById(Mockito.any())).thenReturn(t);
		when(repo.save(t)).thenReturn(t2);
		Assertions.assertEquals(dto,service.moveThreat(1L,1,1));
	}
	
	@Test
	void createThreat(){
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(mRepo.getById(Mockito.any())).thenReturn(m);
		when(repo.save(Mockito.any())).thenReturn(t);
		Assertions.assertEquals(t,service.createThreat(m));
	}
	
	@Test
	void attackThreat() throws Exception{
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		Threat t = new Threat(m);
		Threat t2 = new Threat(t.getName(),m,100000L,15,15,1);
		t2.setHp(t2.getHp()-100);
		ThreatDTO dto =  new ThreatDTO(t2);
		when(mRepo.getById(Mockito.any())).thenReturn(m);
		when(repo.getById(Mockito.any())).thenReturn(t);
		when(repo.save(Mockito.any())).thenReturn(t);
		Assertions.assertEquals(dto,service.noteDamage(1L,100L,1L));
	}
	
	@Test
	void ReadThreats(){
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(repo.findAll()).thenReturn(List.of(t));
		Assertions.assertEquals(List.of(dto),service.readThreats());
	}
}
