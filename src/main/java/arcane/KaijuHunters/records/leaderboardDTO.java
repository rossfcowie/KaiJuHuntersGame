package arcane.KaijuHunters.records;

import java.util.ArrayList;

import arcane.KaijuHunters.Monsters.dto.ThreatDTO;

public class leaderboardDTO {

	ArrayList<RecordDTO> records;
	ThreatDTO threat;
	
	public leaderboardDTO(ArrayList<RecordDTO> a,ThreatDTO t) {
		super();
		this.records= a;
		this.threat = t;
	}
	
	
	public leaderboardDTO() {
		super();

	}


	public ArrayList<RecordDTO> getRecords() {
		return records;
	}


	public ThreatDTO getThreat() {
		return threat;
	}


	public void setRecords(ArrayList<RecordDTO> records) {
		this.records = records;
	}


	public void setThreat(ThreatDTO threat) {
		this.threat = threat;
	}

	
	
}
