package practice.springframework.Commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private String uom;

    @Override
    public String toString() {
        return "UnitOfMeasureCommand{" +
                "id=" + id +
                ", uom='" + uom + '\'' +
                '}';
    }
}
