package arcane.KaijuHunters.Monsters;

import org.springframework.boot.test.context.SpringBootTest;

import arcane.KaijuHunters.Monsters.datastorage.State;
import arcane.KaijuHunters.Monsters.datastorage.Trait;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class StateTests {
	
	@Test
	void jsonTest() {

		State s = new State(1);
		Trait t = new Trait(11,4,2.5);
		s.addTrait(t);
		Assertions.assertEquals(s.toJSON(),("{\"id\":1,\"autoRemovalTiming\":0,\"chanceByDamage\":100,\"traits\":[{{\"code\":11,\"dataId\":4,\"value\":2.5},],\"iconIndex\":0,\"maxTurns\":1,\"message1\":\"\",\"message2\":\"\",\"message3\":\"\",\"message4\":\"\",\"minTurns\":1,\"motion\":0,\"name\":\"\",\"note\":\"\",\"overlay\":0,\"priority\":50,\"removeAtBattleEnd\":false,\"removeByDamage\":false,\"removeByRestriction\":false,\"removeByWalking\":false,\"restriction\":0,\"stepsToRemove\":100}"));
	}
	
	
}
