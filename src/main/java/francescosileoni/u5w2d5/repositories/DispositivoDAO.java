package francescosileoni.u5w2d5.repositories;

import francescosileoni.u5w2d5.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Integer> {
}
