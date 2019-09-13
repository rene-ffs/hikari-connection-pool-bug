package atg.fingerfood.hikaripoolbug.repository;

import atg.fingerfood.hikaripoolbug.domain.FooBar;
import atg.fingerfood.hikaripoolbug.exception.FooBarNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FooBarRepository extends JpaRepository<FooBar, UUID> {
    Optional<FooBar> findByName(String name);

    @Override
    default FooBar getOne(UUID id) {
        return findById(id)
                .orElseThrow(() -> new FooBarNotFoundException(id));
    }
}
