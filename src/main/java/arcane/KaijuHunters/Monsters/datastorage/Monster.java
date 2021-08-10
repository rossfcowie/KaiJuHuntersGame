package arcane.KaijuHunters.Monsters.datastorage;

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
	
	int count;
	public Monster() {
		
	}
	
	
	

	public Monster(Long id, String name, String image, Long hp) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.hp = hp;

	}





	public Monster(String name, String image, long hp) {
		super();
		this.name = name;
		this.image = image;
		this.hp = hp;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
	//	result = prime * result + ((drops == null) ? 0 : drops.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
//		if (attacks == null) {
//			if (other.attacks != null)
//				return false;
//		} else if (!attacks.equals(other.attacks))
//			return false;
//		if (drops == null) {
//			if (other.drops != null)
//				return false;
//		} else if (!drops.equals(other.drops))
//			return false;
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

//	public ArrayList<Integer> getDrops() {
//		return drops;
//	}
//
//	public ArrayList<Integer> getAttacks() {
//		return attacks;
//	}

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



//	public void setDrops(ArrayList<Integer> drops) {
//		this.drops = drops;
//	}
//
//	public void setAttacks(ArrayList<Integer> attacks) {
//		this.attacks = attacks;
//	}
	
	
	
	
}
