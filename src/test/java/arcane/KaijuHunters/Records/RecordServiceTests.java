package arcane.KaijuHunters.Records;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.datastorage.ThreatRepo;
import arcane.KaijuHunters.account.Account;
import arcane.KaijuHunters.account.AccountRepo;
import arcane.KaijuHunters.records.RecordRepo;
import arcane.KaijuHunters.records.RecordService;
import arcane.KaijuHunters.records.Record;

@SpringBootTest
public class RecordServiceTests {

	@MockBean
	RecordRepo repo;
	@MockBean
	ThreatRepo trepo;
	@MockBean
	AccountRepo arepo;
	
	@Autowired
	RecordService service;
	
	@Test
	void createRecord(){
		Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
		Threat t = new Threat(m);
		Account acc = new Account(1L, "gura", "a");
		Record r = new Record(t,acc,100L);
		r.setCount(1);
		when(trepo.getById(Mockito.any())).thenReturn(t);
		when(arepo.getById(Mockito.any())).thenReturn(acc);
		Assertions.assertEquals(r,service.createRecord(1L,100L,1L));
	}
	
	@Test
	void updateRecordNewRecord(){
			Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
			Threat t = new Threat(m);
			Account acc = new Account(1L, "gura", "a");
			Record r = new Record(t,acc,100L);
			r.setCount(1);
			when(repo.findByAT(Mockito.any(),Mockito.any())).thenReturn(null);
			when(trepo.getById(Mockito.any())).thenReturn(t);
			when(arepo.getById(Mockito.any())).thenReturn(acc);
			when(repo.save(Mockito.any())).thenReturn(r);
			Assertions.assertEquals(r,service.updateRecord(1L,1L,100L));
		}
	@Test
	void updateRecordOldRecord(){
			Monster m = new Monster(1L, "shark", "shark.jpg", 100000L);
			Threat t = new Threat(m);
			Account acc = new Account(1L, "gura", "a");
			Record r = new Record(t,acc,100L);
			r.setCount(1);
			Record r2 = new Record(t,acc,200L);
			r2.setCount(2);
			when(repo.findByAT(Mockito.any(),Mockito.any())).thenReturn(Optional.of(r));
			when(trepo.getById(Mockito.any())).thenReturn(t);
			when(arepo.getById(Mockito.any())).thenReturn(acc);
			when(repo.save(Mockito.any())).thenReturn(r);
			Assertions.assertEquals(r,service.updateRecord(1L,1L,100L));
		}
	
}
