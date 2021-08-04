package arcane.KaijuHunters.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String uname;
	String pass;
	public Account(String uname2) {
		uname = uname2;
	}
	public Account() {

	}
	
	public Account(long l, String string, String string2) {
		 id = l;
		 uname = string;
		 pass = PasswordSecurity.encrypt(string2);
	}
	public Account(AccountDTO dto) {
		 uname = dto.uname;
		 pass = PasswordSecurity.encrypt(dto.pass);
	}
	public Long getId() {
		return id;
	}
	public String getUname() {
		return uname;
	}
	public boolean checkPassword(String pass) {
		return PasswordSecurity.encrypt(pass).equals(this.pass);
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPass(String pass) {
		this.pass = PasswordSecurity.encrypt(pass);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", uname=" + uname + ", pass=" + pass + "]";
	}
	
	
}
