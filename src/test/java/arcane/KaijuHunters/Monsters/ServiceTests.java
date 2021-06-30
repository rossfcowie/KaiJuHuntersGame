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

@SpringBootTest
public class ServiceTests {
	
	@Autowired
	ThreatService service;
	
	@MockBean
	ThreatRepo repo;

	@MockBean
	MonsterRepo mRepo;
	
	@Test
	void createThreat(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L, 1000, 1000, 1000, 1000, 1000, 1000, 1000, a, a);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(mRepo.getById(Mockito.any())).thenReturn(m);
		when(repo.save(Mockito.any())).thenReturn(t);
		Assertions.assertEquals(dto,service.createThreat(1L));
	}
	
	@Test
	void ReadThreats(){
		ArrayList<Integer> a  = new ArrayList<>();
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L, 1000, 1000, 1000, 1000, 1000, 1000, 1000, a, a);
		Threat t = new Threat(m);
		ThreatDTO dto =  new ThreatDTO(t);
		when(repo.findAll()).thenReturn(List.of(t));
		Assertions.assertEquals(List.of(dto),service.readThreats());
	}
}
