package arcane.KaijuHunters.records;

import java.util.ArrayList;
import java.util.Iterator;
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
			r.setCount(r.getCount()+1);
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
	public ArrayList<RewardDTO> getAllRewards(Long aid){
		ArrayList<Record> records = (ArrayList<Record>) repo.findByA(aid);
		records.removeIf(n -> (n.getClaimed()));
		ArrayList<RewardDTO> rewards = new ArrayList<>();
		records.forEach(r -> {
			rewards.add(getRewards(r.threat, r.a.getId()));
			r.setClaimed(true);
			
			
		});
		repo.saveAll(records);
		return rewards;
	}
	public void allowClaims(Long t) {
		System.out.println("Allowing claims on:" + t);
		ArrayList<Record> r = (ArrayList<Record>) repo.findByT(t);
		r.forEach(i->{i.setClaimed(false);});
		repo.saveAll(r);
	}
	private RewardDTO getRewards(Threat t,Long aid) {
		int rewardCount= 0;
		Record r = repo.findByAT(aid, t.getId()).get();
		switch (r.getCount()) {
		case 5:
			rewardCount+=5;
		case 3:
			rewardCount+=5;
		case 2:
			rewardCount+=3;
		case 1:
			rewardCount+=2;
			
			break;
		default:
			break;
		}
		if(r.getDmg()>10000) {
			rewardCount+=3;
			Long i = r.getDmg()-10000;
			i= (long) Math.floor(rewardCount/10000);
			rewardCount+=i;
		}
		Double percent = (double) (t.getBaseMonster().getHp()/ r.getDmg());
		if(percent>=1) {
			rewardCount+=10;
			if(percent>=10) {
				rewardCount+=100;
				percent-=10;
				rewardCount+= Math.floor(percent/2);
			}
		}
		
		return new RewardDTO(aid, t, rewardCount);
	}
	
	private RecordDTO map(Record record) {
		return new RecordDTO(record);
	}
}
