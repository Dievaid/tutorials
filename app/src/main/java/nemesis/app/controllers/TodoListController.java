package nemesis.app.controllers;

import lombok.RequiredArgsConstructor;
import nemesis.app.dto.CreateTodoItemDto;
import nemesis.app.dto.TodoListDto;
import nemesis.app.services.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoListController {
    private final TodoListService todoListService;


    @PostMapping("/list")
    public ResponseEntity<ListCreated> createList() {
        return ResponseEntity.ok(new ListCreated(todoListService.createTodoList()));
    }

    @PostMapping("/list/add")
    public ResponseEntity<Void> addItemToList(@RequestBody CreateTodoItemDto createTodoItemDto) {
        todoListService.addToList(createTodoItemDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<TodoListDto>> getTodos(@RequestParam Long id) {
        return ResponseEntity.ok(todoListService.getTodoList(id));
    }

    public record ListCreated(Long id) {}
}
