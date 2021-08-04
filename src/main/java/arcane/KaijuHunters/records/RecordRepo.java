package arcane.KaijuHunters.records;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepo  extends JpaRepository<Record, Long>{
	@Query(value = "SELECT * FROM Record WHERE A_ID = ?1 and THREAT_ID =?2", nativeQuery = true)
	public Optional<Record> findByAT(Long a,Long t);
}
