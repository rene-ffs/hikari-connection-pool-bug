package atg.fingerfood.hikaripoolbug.api;

import atg.fingerfood.hikaripoolbug.domain.Bar;
import atg.fingerfood.hikaripoolbug.service.BarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static atg.fingerfood.hikaripoolbug.api.BarController.BAR_ENDPOINT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(BAR_ENDPOINT)
public class BarController {
    public static final String BAR_ENDPOINT = "/api/bar";
    private final BarService barService;

    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping
    public ResponseEntity<Bar> getFoo(@RequestParam("id") String id) {
        Bar bar = barService.getOneById(UUID.fromString(id));
        return new ResponseEntity<>(bar, OK);
    }
}
