package arcane.KaijuHunters.Monsters.datastorage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThreatRepo extends JpaRepository<Threat, Long>{
	
	@Query(value = "SELECT * FROM Threat WHERE hp > 0", nativeQuery = true)
	public List<Threat> findAlive();
}
