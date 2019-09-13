package atg.fingerfood.hikaripoolbug.api;

import atg.fingerfood.hikaripoolbug.domain.Foo;
import atg.fingerfood.hikaripoolbug.service.FooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static atg.fingerfood.hikaripoolbug.api.FooController.FOO_ENDPOINT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(FOO_ENDPOINT)
public class FooController {
    public static final String FOO_ENDPOINT = "/api/foo";
    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping
    public ResponseEntity<Foo> getFoo(@RequestParam("id") String id) {
        Foo foo = fooService.getOneById(UUID.fromString(id));
        return new ResponseEntity<>(foo, OK);
    }
}
