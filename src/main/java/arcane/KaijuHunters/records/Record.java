package arcane.KaijuHunters.records;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import arcane.KaijuHunters.Monsters.datastorage.Threat;
import arcane.KaijuHunters.account.Account;

@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Threat threat;
	@ManyToOne
	Account a;
	Long dmg;
	public Long getId() {
		return id;
	}
	public Threat getThreat() {
		return threat;
	}
	public Account getA() {
		return a;
	}
	public Long getDmg() {
		return dmg;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setThreat(Threat threat) {
		this.threat = threat;
	}
	public void setA(Account a) {
		this.a = a;
	}
	public void setDmg(Long dmg) {
		this.dmg = dmg;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((dmg == null) ? 0 : dmg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((threat == null) ? 0 : threat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (dmg == null) {
			if (other.dmg != null)
				return false;
		} else if (!dmg.equals(other.dmg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (threat == null) {
			if (other.threat != null)
				return false;
		} else if (!threat.equals(other.threat))
			return false;
		return true;
	}
	public Record(Threat threat, Account a, Long dmg) {
		super();
		this.threat = threat;
		this.a = a;
		this.dmg = dmg;
	}
	
	public Record() {
		super();

	}
}
