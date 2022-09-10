package arcane.KaijuHunters.Monsters.dto;

import java.util.ArrayList;

import arcane.KaijuHunters.Monsters.datastorage.Monster;
import arcane.KaijuHunters.Monsters.datastorage.Threat;

public class ThreatDTO {
	
	private Long id;
	private String name;
	private Integer level;
	private Long chp;
	private Integer x;
	private Integer y;
	private String species;
	private Long bid;
	private String image;
	private Long MaxHp;
//	ArrayList<Integer> drops;
//	ArrayList<Integer> attacks;
	
	
	
	
	public void loadMonster(Monster baseMonster) {
		this.species = baseMonster.getName();
		this.bid= baseMonster.getId();
		this.image = baseMonster.getImage();
		this.MaxHp = baseMonster.getHp();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getLevel() {
		return level;
	}

	public Long getChp() {
		return chp;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public String getSpecies() {
		return species;
	}

	public String getImage() {
		return image;
	}

	public Long getMaxHp() {
		return MaxHp;
	}



	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setChp(Long chp) {
		this.chp = chp;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setMaxHp(Long maxHp) {
		MaxHp = maxHp;
	}



	public ThreatDTO(Threat t) {
		super();
		this.id = t.getId();
		this.bid = t.getBaseMonster().getId();
		this.name = t.getName();
		this.level = t.getLevel();
		this.chp = t.getHp();
		this.x = t.getX();
		this.y = t.getY();
		this.MaxHp = t.getBaseMonster().getHp()*t.getLevel();
		this.chp = t.getHp();
		this.species = t.getBaseMonster().getName();
		this.image = t.getBaseMonster().getImage();
	}
	
	public ThreatDTO() {
		super();
	}
	
	public ThreatDTO(Long id,Long bid,  String name, Integer level, Long chp, Integer x, Integer y, String species, String image,
			Long maxHp) {
		super();
		this.id = id;
		this.bid = bid;
		this.name = name;
		this.level = level;
		this.chp = chp;
		this.x = x;
		this.y = y;
		this.species = species;
		this.image = image;
		MaxHp = maxHp;

//		this.drops = drops;
//		this.attacks = attacks;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaxHp == null) ? 0 : MaxHp.hashCode());
//		result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
//		result = prime * result + ((drops == null) ? 0 : drops.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		
//		if (attacks == null) {
//			if (other.attacks != null)
//				return false;
//		} else if (!attacks.equals(other.attacks))
//			return false;
		if (chp == null) {
			if (other.chp != null)
				return false;
		} else if (!chp.equals(other.chp))
			return false;
//		if (drops == null) {
//			if (other.drops != null)
//				return false;
//		} else if (!drops.equals(other.drops))
//			return false;
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
				+ ", species=" + species + ", bid=" + bid + ", image=" + image + ", MaxHp=" + MaxHp + "]";
	}




	
}
