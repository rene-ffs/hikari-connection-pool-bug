package atg.fingerfood.hikaripoolbug.service;

import atg.fingerfood.hikaripoolbug.domain.FooBar;
import atg.fingerfood.hikaripoolbug.repository.FooBarRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public class FooBarService {
    private final FooBarRepository fooBarRepository;

    public FooBarService(FooBarRepository fooBarRepository) {
        this.fooBarRepository = fooBarRepository;
    }

    @Transactional(readOnly = true)
    public FooBar getOneById(UUID id) {
        return fooBarRepository.getOne(id);
    }
}
