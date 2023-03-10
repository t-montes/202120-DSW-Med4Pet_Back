package co.edu.uniandes.dse.med4pet.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniandes.dse.med4pet.entities.PSEEntity;

@Repository
public interface PSERepository extends JpaRepository<PSEEntity, Long>
{
	
}
