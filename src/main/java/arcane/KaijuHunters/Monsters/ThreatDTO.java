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
	public String toString() {
		return "ThreatDTO [id=" + id + ", name=" + name + ", level=" + level + ", chp=" + chp + ", x=" + x + ", y=" + y
				+ ", species=" + species + ", image=" + image + ", MaxHp=" + MaxHp + ", mp=" + mp + ", atk=" + atk
				+ ", def=" + def + ", mat=" + mat + ", mdf=" + mdf + ", luk=" + luk + ", agi=" + agi + ", drops="
				+ drops + ", attacks=" + attacks + "]";
	}
	
	
}
