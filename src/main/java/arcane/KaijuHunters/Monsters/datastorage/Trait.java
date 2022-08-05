package arcane.KaijuHunters.Monsters.datastorage;

public class Trait {

	Integer code;
	Integer dataID;
	double value;
	
	
	
	 public Trait(Integer code, Integer dataID, double value) {
		super();
		this.code = code;
		this.dataID = dataID;
		this.value = value;
	}



	public Integer getCode() {
		return code;
	}



	public void setCode(Integer code) {
		this.code = code;
	}



	public Integer getDataID() {
		return dataID;
	}



	public void setDataID(Integer dataID) {
		this.dataID = dataID;
	}



	public double getValue() {
		return value;
	}



	public void setValue(double value) {
		this.value = value;
	}



	public String toJSON() {
		 String s = "{" + "{\"code\":"+code+",\"dataId\":"+dataID +",\"value\":"+value+"}";
		 return s;
	 }
	
}
