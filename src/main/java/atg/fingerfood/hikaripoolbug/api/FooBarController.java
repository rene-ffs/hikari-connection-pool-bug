package atg.fingerfood.hikaripoolbug.api;

import atg.fingerfood.hikaripoolbug.domain.FooBar;
import atg.fingerfood.hikaripoolbug.service.FooBarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static atg.fingerfood.hikaripoolbug.api.FooBarController.FOOBAR_ENDPOINT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(FOOBAR_ENDPOINT)
public class FooBarController {
    public static final String FOOBAR_ENDPOINT = "/api/foobar";
    private final FooBarService fooBarService;

    public FooBarController(FooBarService fooBarService) {
        this.fooBarService = fooBarService;
    }

    @GetMapping
    public ResponseEntity<FooBar> getFoo(@RequestParam("id") String id) {
        FooBar fooBar = fooBarService.getOneById(UUID.fromString(id));
        return new ResponseEntity<>(fooBar, OK);
    }
}
