package arcane.KaijuHunters.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.Monsters.datastorage.ThreatRepo;
import arcane.KaijuHunters.Monsters.dto.ThreatDTO;
import arcane.KaijuHunters.account.Account;
import arcane.KaijuHunters.account.AccountRepo;

@Service
public class RecordService {

	@Autowired
	RecordRepo repo;
	ThreatRepo trepo;
	AccountRepo arepo;
	
	@Autowired
	public RecordService(RecordRepo repo,ThreatRepo trepo,AccountRepo arepo) {
		this.repo=repo;
		this.arepo=arepo;
		this.trepo=trepo;
	}
	public Record updateRecord(Long tid,Long dmg,Long aid) {
		Record r;
		try {
			r= repo.findByAT(aid,tid).get();
			r.setDmg(r.getDmg()+dmg);
		} catch (Exception e) {
			r=createRecord(tid,dmg,aid);
		}
		return repo.save(r);
	}
	public Record createRecord(Long tid,Long dmg,Long aid) {
		Threat t = trepo.getById(tid);
		Account a = arepo.getById(aid);
		return new Record(t, a, dmg);
	}
	public List<RecordDTO> readRecords() {
		List<Record> rs = repo.findAll();
		List<RecordDTO> dtos = new ArrayList<>();
    	rs.forEach(record->dtos.add(map(record)));
		return dtos;
	}
	public leaderboardDTO createLeaderboard(Long tid) {
		Optional<Threat> t=trepo.findById(tid);
			ThreatDTO tdto = new ThreatDTO(t.get());
			List<Record> rs = repo.findByT(tid);
			ArrayList<RecordDTO> dtos = new ArrayList<>();
	    	rs.forEach(record->dtos.add(map(record)));
			leaderboardDTO l=new leaderboardDTO(dtos,tdto);
			
			return l;

		
		
	}
	
	private RecordDTO map(Record record) {
		return new RecordDTO(record);
	}
}
