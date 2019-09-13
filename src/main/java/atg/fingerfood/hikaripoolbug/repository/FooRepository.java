package atg.fingerfood.hikaripoolbug.repository;

import atg.fingerfood.hikaripoolbug.domain.Foo;
import atg.fingerfood.hikaripoolbug.exception.FooNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FooRepository extends JpaRepository<Foo, UUID> {
    Optional<Foo> findByName(String name);

    @Override
    default Foo getOne(UUID id) {
        return findById(id)
                .orElseThrow(() -> new FooNotFoundException(id));
    }
}
