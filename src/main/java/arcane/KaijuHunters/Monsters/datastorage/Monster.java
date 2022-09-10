package arcane.KaijuHunters.Monsters.datastorage;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monster {

	String code;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String image;
	Long hp;
	@ElementCollection
	Map<Integer,Integer> loot = new HashMap<>();
	
	int count;

	public Monster() {

	}

	@Override
	public String toString() {
		return "Monster [code=" + code + ", id=" + id + ", name=" + name + ", image=" + image + ", hp=" + hp + ", loot="
				+ loot + ", count=" + count + "]";
	}

	public Monster(Long id, String name, String image, Long hp) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.hp = hp;
		this.loot = new HashMap<>();

	}

	public Monster(String name, String image, long hp) {
		super();
		this.name = name;
		this.image = image;
		this.hp = hp;
		this.loot = new HashMap<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loot == null) ? 0 : loot.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Monster other = (Monster) obj;
		if (count != other.count)
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public Long getHp() {
		return hp;
	}

	public Map<Integer, Integer> getLoot() {
		return loot;
	}

	public void setLoot(Map<Integer, Integer> loot) {
		this.loot = loot;
	}
	public void addLoot(Integer i, Integer weight) {
		this.loot.put(i, weight);
	}
	public int getCount() {
		return count;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setHp(Long hp) {
		this.hp = hp;
	}


	public void setCount(int count) {
		this.count = count;
	}

}
