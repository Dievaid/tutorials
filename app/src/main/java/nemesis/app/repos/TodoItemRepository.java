package nemesis.app.repos;

import nemesis.app.entities.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    List<TodoItem> findTodoItemsByTodoListId(Long id);
}
