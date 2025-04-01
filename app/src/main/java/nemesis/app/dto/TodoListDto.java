package nemesis.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoListDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
