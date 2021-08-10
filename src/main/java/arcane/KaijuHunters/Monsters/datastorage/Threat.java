package arcane.KaijuHunters.Monsters.datastorage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Threat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	Integer level;
	@ManyToOne(targetEntity = Monster.class)
	Monster baseMonster;
	Long hp;
	Integer x;
	Integer y;
	
	
	public Threat() {
		super();
		this.x = 0;
		this.y = 0;
	}
	
	public Threat(Monster baseMonster) {
		super();
		this.name = NameGeneration.classify(baseMonster) + "-" + (baseMonster.count++) + ":" + NameGeneration.generate(baseMonster);
		this.baseMonster = baseMonster;
		this.level = (int) (Math.floor(Math.random() * baseMonster.count) + 1);
		this.hp = baseMonster.hp * this.level;
		this.x = 0;
		this.y = 0;
	}
	
	public Threat( String name, Monster baseMonster, Long hp, Integer x, Integer y, Integer level) {
		super();
		this.name = name;
		this.baseMonster = baseMonster;
		this.level = level;
		this.hp = hp;
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public String toString() {
		return "Threat [id=" + id + ", name=" + name + ", level=" + level + ", baseMonster=" + baseMonster + ", hp="
				+ hp + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseMonster == null) ? 0 : baseMonster.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Threat other = (Threat) obj;
		if (baseMonster == null) {
			if (other.baseMonster != null)
				return false;
		} else if (!baseMonster.equals(other.baseMonster))
			return false;
		if (hp == null) {
			if (other.hp != null)
				return false;
		} else if (!hp.equals(other.hp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Monster getBaseMonster() {
		return baseMonster;
	}
	public Integer getLevel() {
		return level;
	}
	public Long getHp() {
		return hp;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBaseMonster(Monster baseMonster) {
		this.baseMonster = baseMonster;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public void setHp(Long hp) {
		this.hp = hp;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	
}
