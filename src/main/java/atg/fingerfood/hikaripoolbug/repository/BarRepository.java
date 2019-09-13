package atg.fingerfood.hikaripoolbug.repository;

import atg.fingerfood.hikaripoolbug.domain.Bar;
import atg.fingerfood.hikaripoolbug.exception.BarNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BarRepository extends JpaRepository<Bar, UUID> {
    Optional<Bar> findByName(String name);

    @Override
    default Bar getOne(UUID id) {
        return findById(id)
                .orElseThrow(() -> new BarNotFoundException(id));
    }
}
