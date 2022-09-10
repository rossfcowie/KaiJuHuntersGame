package arcane.KaijuHunters.records;

import java.util.ArrayList;
import java.util.Map;

import arcane.KaijuHunters.Monsters.datastorage.Threat;

public class RewardDTO {
	int total=0;
	Long accountId;
	ArrayList<Integer> rewards;
	Long threatId;
	public RewardDTO() {
		super();

	}
	
	public RewardDTO(Long accountId, ArrayList<Integer> rewards, Long threatId) {
		super();
		this.accountId = accountId;
		this.rewards = rewards;
		this.threatId = threatId;
	}
	
	public RewardDTO(Long accountId, Threat t, int rewardcount) {
		super();
		this.accountId = accountId;
		this.rewards = rollRewards(t, rewardcount);
		this.threatId = t.getId();
	}
	private ArrayList<Integer> rollRewards(Threat t,int rewardcount) {
		System.out.println("claiming " + rewardcount + " rewards for " + t.getName());
		ArrayList<Integer> loot = new ArrayList<>();
		Map<Integer, Integer> r = t.getBaseMonster().getLoot();
		total=0;
		ArrayList<Integer> possible = new ArrayList<>();
		r.forEach((item, weight) -> {
				total+=weight;
				for (int j = 0; j < weight; j++) {
				possible.add(item);
				}
		});
		
		int roll=0;
		for (int i = 0; i < rewardcount; i++) {
			roll=(int) (Math.floor(Math.random()*total));
			loot.add(possible.get(roll));
		}
		
		
		return loot;
		
	}

	public int getTotal() {
		return total;
	}

	public Long getAccountId() {
		return accountId;
	}

	public ArrayList<Integer> getRewards() {
		return rewards;
	}

	public Long getThreatId() {
		return threatId;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setRewards(ArrayList<Integer> rewards) {
		this.rewards = rewards;
	}

	public void setThreatId(Long threatId) {
		this.threatId = threatId;
	}




	
}
