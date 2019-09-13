package atg.fingerfood.hikaripoolbug.service;

import atg.fingerfood.hikaripoolbug.domain.Bar;
import atg.fingerfood.hikaripoolbug.repository.BarRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public class BarService {
    private final BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @Transactional(readOnly = true)
    public Bar getOneById(UUID id) {
        return barRepository.getOne(id);
    }
}
