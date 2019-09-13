package atg.fingerfood.hikaripoolbug.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(schema = "hikaripoolbug")
public class FooBar {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    public FooBar(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
