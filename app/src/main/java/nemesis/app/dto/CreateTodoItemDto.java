package nemesis.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTodoItemDto {
    private String title;
    private String description;
    private Long todoListId;
}
