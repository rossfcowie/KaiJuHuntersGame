package arcane.KaijuHunters.Monsters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String image;
	Long hp;
	Integer mp;
	Integer atk;
	Integer def;
	Integer mat;
	Integer mdf;
	Integer luk;
	Integer agi;
	
	ArrayList<Integer> drops;
	ArrayList<Integer> attacks;
	static int count;
	public Monster() {
		
	}
	
	public int highestStat() {
		int max = 0;
		int val = (int) (hp/100000);
		if((val)>mp) {
			max = 1;
		}else {
			max = 2;
			val = mp;
		}
		if((val)>atk) {
			
		}else {
			max = 3;
			val = atk;
		}
		if((val)>def) {
		}else {
			max = 4;
			val = def;
		}
		if((val)>mat) {
			
		}else {
			max = 5;
			val = mat;
		}
		if((val)>mdf) {
			
		}else {
			max = 6;
			val = mdf;
		}
		if((val)>luk) {
			
		}else {
			max = 7;
			val = luk;
		}
		if((val)>agi) {
			
		}else {
			max = 8;
			val = agi;
		}
		return max;
	}
	
	

	public Monster(Long id, String name, String image, Long hp, Integer mp, Integer atk, Integer def,
			Integer mat, Integer mdf, Integer luk, Integer agi, List<Integer> drops, List<Integer> attacks) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.mat = mat;
		this.mdf = mdf;
		this.luk = luk;
		this.agi = agi;
		this.drops = (ArrayList<Integer>) drops;
		this.attacks = (ArrayList<Integer>) attacks;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agi == null) ? 0 : agi.hashCode());
		result = prime * result + ((atk == null) ? 0 : atk.hashCode());
		result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
		result = prime * result + ((def == null) ? 0 : def.hashCode());
		result = prime * result + ((drops == null) ? 0 : drops.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((luk == null) ? 0 : luk.hashCode());
		result = prime * result + ((mat == null) ? 0 : mat.hashCode());
		result = prime * result + ((mdf == null) ? 0 : mdf.hashCode());
		result = prime * result + ((mp == null) ? 0 : mp.hashCode());
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

	public Integer getMp() {
		return mp;
	}

	public Integer getAtk() {
		return atk;
	}

	public Integer getDef() {
		return def;
	}

	public Integer getMat() {
		return mat;
	}

	public Integer getMdf() {
		return mdf;
	}

	public Integer getLuk() {
		return luk;
	}

	public Integer getAgi() {
		return agi;
	}

	public ArrayList<Integer> getDrops() {
		return drops;
	}

	public ArrayList<Integer> getAttacks() {
		return attacks;
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

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public void setDef(Integer def) {
		this.def = def;
	}

	public void setMat(Integer mat) {
		this.mat = mat;
	}

	public void setMdf(Integer mdf) {
		this.mdf = mdf;
	}

	public void setLuk(Integer luk) {
		this.luk = luk;
	}

	public void setAgi(Integer agi) {
		this.agi = agi;
	}

	public void setDrops(ArrayList<Integer> drops) {
		this.drops = drops;
	}

	public void setAttacks(ArrayList<Integer> attacks) {
		this.attacks = attacks;
	}
	
	
	
	
}
