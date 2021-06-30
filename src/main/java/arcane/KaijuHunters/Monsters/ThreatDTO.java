package arcane.KaijuHunters.Monsters;

import java.util.ArrayList;

import javax.persistence.ManyToOne;

public class ThreatDTO {

	Long id;
	String name;
	Integer level;
	Long chp;
	Integer x;
	Integer y;
	String species;
	String image;
	Long MaxHp;
	Integer mp;
	Integer atk;
	Integer def;
	Integer mat;
	Integer mdf;
	Integer luk;
	Integer agi;
	ArrayList<Integer> drops;
	ArrayList<Integer> attacks;
	
	
	public ThreatDTO(Threat t) {
		super();
		this.id = t.id;
		this.name = t.name;
		this.level = t.level;
		this.chp = t.hp;
		this.x = t.x;
		this.y = t.y;
		this.species = t.baseMonster.name;
		this.image = t.baseMonster.image;
		this.MaxHp = t.baseMonster.hp;
		this.mp = t.baseMonster.mp;
		this.atk = t.baseMonster.atk;
		this.def = t.baseMonster.def;
		this.mat = t.baseMonster.mat;
		this.mdf = t.baseMonster.mdf;
		this.luk = t.baseMonster.luk;
		this.agi = t.baseMonster.agi;
		this.drops = t.baseMonster.drops;
		this.attacks = t.baseMonster.attacks;
	}
	
	
	public ThreatDTO(Long id, String name, Integer level, Long chp, Integer x, Integer y, String species, String image,
			Long maxHp, Integer mp, Integer atk, Integer def, Integer mat, Integer mdf, Integer luk, Integer agi,
			ArrayList<Integer> drops, ArrayList<Integer> attacks) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.chp = chp;
		this.x = x;
		this.y = y;
		this.species = species;
		this.image = image;
		MaxHp = maxHp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.mat = mat;
		this.mdf = mdf;
		this.luk = luk;
		this.agi = agi;
		this.drops = drops;
		this.attacks = attacks;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaxHp == null) ? 0 : MaxHp.hashCode());
		result = prime * result + ((agi == null) ? 0 : agi.hashCode());
		result = prime * result + ((atk == null) ? 0 : atk.hashCode());
		result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
		result = prime * result + ((chp == null) ? 0 : chp.hashCode());
		result = prime * result + ((def == null) ? 0 : def.hashCode());
		result = prime * result + ((drops == null) ? 0 : drops.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((luk == null) ? 0 : luk.hashCode());
		result = prime * result + ((mat == null) ? 0 : mat.hashCode());
		result = prime * result + ((mdf == null) ? 0 : mdf.hashCode());
		result = prime * result + ((mp == null) ? 0 : mp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		ThreatDTO other = (ThreatDTO) obj;
		if (MaxHp == null) {
			if (other.MaxHp != null)
				return false;
		} else if (!MaxHp.equals(other.MaxHp))
			return false;
		if (agi == null) {
			if (other.agi != null)
				return false;
		} else if (!agi.equals(other.agi))
			return false;
		if (atk == null) {
			if (other.atk != null)
				return false;
		} else if (!atk.equals(other.atk))
			return false;
		if (attacks == null) {
			if (other.attacks != null)
				return false;
		} else if (!attacks.equals(other.attacks))
			return false;
		if (chp == null) {
			if (other.chp != null)
				return false;
		} else if (!chp.equals(other.chp))
			return false;
		if (def == null) {
			if (other.def != null)
				return false;
		} else if (!def.equals(other.def))
			return false;
		if (drops == null) {
			if (other.drops != null)
				return false;
		} else if (!drops.equals(other.drops))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (luk == null) {
			if (other.luk != null)
				return false;
		} else if (!luk.equals(other.luk))
			return false;
		if (mat == null) {
			if (other.mat != null)
				return false;
		} else if (!mat.equals(other.mat))
			return false;
		if (mdf == null) {
			if (other.mdf != null)
				return false;
		} else if (!mdf.equals(other.mdf))
			return false;
		if (mp == null) {
			if (other.mp != null)
				return false;
		} else if (!mp.equals(other.mp))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ThreatDTO [id=" + id + ", name=" + name + ", level=" + level + ", chp=" + chp + ", x=" + x + ", y=" + y
				+ ", species=" + species + ", image=" + image + ", MaxHp=" + MaxHp + ", mp=" + mp + ", atk=" + atk
				+ ", def=" + def + ", mat=" + mat + ", mdf=" + mdf + ", luk=" + luk + ", agi=" + agi + ", drops="
				+ drops + ", attacks=" + attacks + "]";
	}
	
	
}
