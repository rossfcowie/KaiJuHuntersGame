package arcane.KaijuHunters.records;

public class RecordDTO {

	Long dmg;
	String accountName;
	String threatName;
	
	public RecordDTO(Record r) {
		super();
		this.dmg = r.getDmg();
		this.accountName = r.getA().getUname();
		this.threatName = r.getThreat().getName();
	}
	
	
	public RecordDTO(Long dmg, String accountName, String threatName) {
		super();
		this.dmg = dmg;
		this.accountName = accountName;
		this.threatName = threatName;
	}
	public Long getDmg() {
		return dmg;
	}
	public String getAccountName() {
		return accountName;
	}
	public String getThreatName() {
		return threatName;
	}
	public void setDmg(Long dmg) {
		this.dmg = dmg;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setThreatName(String threatName) {
		this.threatName = threatName;
	}
	
	
}
