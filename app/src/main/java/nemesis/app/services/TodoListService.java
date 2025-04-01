package nemesis.app.services;

import lombok.RequiredArgsConstructor;
import nemesis.app.dto.CreateTodoItemDto;
import nemesis.app.dto.TodoListDto;
import nemesis.app.entities.TodoItem;
import nemesis.app.entities.TodoList;
import nemesis.app.exceptions.TodoListNotFoundException;
import nemesis.app.repos.TodoItemRepository;
import nemesis.app.repos.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoItemRepository todoItemRepository;
    private final TodoListRepository todoListRepository;

    public Long createTodoList() {
        TodoList todoList = new TodoList();
        TodoList created = todoListRepository.save(todoList);
        return created.getId();
    }

    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

    public void addToList(CreateTodoItemDto createTodoItemDto) {
        TodoItem todoItem = new TodoItem();

        Optional<TodoList> todoList = todoListRepository.findById(createTodoItemDto.getTodoListId());
        TodoList list = todoList.orElseThrow(TodoListNotFoundException::new);

        todoItem.setTodoList(list);
        todoItem.setTitle(createTodoItemDto.getTitle());
        todoItem.setDescription(createTodoItemDto.getDescription());

        todoItemRepository.save(todoItem);
    }

    public List<TodoListDto> getTodoList(Long id) {
        return todoItemRepository.findTodoItemsByTodoListId(id)
                .stream().map(todo -> new TodoListDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted()))
                .toList();
    }
}
