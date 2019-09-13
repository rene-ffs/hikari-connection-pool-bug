package atg.fingerfood.hikaripoolbug.service;

import atg.fingerfood.hikaripoolbug.domain.Foo;
import atg.fingerfood.hikaripoolbug.repository.FooRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public class FooService {
    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Transactional(readOnly = true)
    public Foo getOneById(UUID id) {
        return fooRepository.getOne(id);
    }
}
