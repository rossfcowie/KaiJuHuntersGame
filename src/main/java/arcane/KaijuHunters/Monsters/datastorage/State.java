package arcane.KaijuHunters.Monsters.datastorage;

import java.util.ArrayList;

public class State{
	 private Integer id;
	 ArrayList <Trait> traits = new ArrayList <Trait> ();

	 
	 
	 
	 public State(Integer id) {
		super();
		this.id = id;
		traits = new ArrayList<>();
	}


	public State(int id) {
		super();
		this.id = id;
		traits = new ArrayList<>();
		}


	public Integer getId() {
		return id;
	}
	 

	public void setId(Integer id) {
		this.id = id;
	}



	public ArrayList<Trait> getTraits() {
		return traits;
	}

	public void addTrait(Trait t) {
		this.traits.add(t);
	}


	public void setTraits(ArrayList<Trait> traits) {
		this.traits = traits;
	}



	public String toJSON() {
		 String s = "{\"id\":"+id+",\"autoRemovalTiming\":0,\"chanceByDamage\":100,\"traits\":[";
		 		for (Trait trait : traits) {
					s+= trait.toJSON();
					s+= ",";
				}
		 		s.substring(0, s.length()-1);
		 		s+= "],\"iconIndex\":0,\"maxTurns\":1,\"message1\":\"\",\"message2\":\"\",\"message3\":\"\",\"message4\":\"\",\"minTurns\":1,\"motion\":0,\"name\":\"\",\"note\":\"\",\"overlay\":0,\"priority\":50,\"removeAtBattleEnd\":false,\"removeByDamage\":false,\"removeByRestriction\":false,\"removeByWalking\":false,\"restriction\":0,\"stepsToRemove\":100}"
		 		+ "";
		 		System.out.println(s);
		 return s;
	 }
	 
}
