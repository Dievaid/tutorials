package nemesis.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo_item")
@Getter
@Setter
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    private String title;

    private String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(referencedColumnName = "list_id")
    private TodoList todoList;
}
