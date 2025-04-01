import { useEffect, useState } from "react";
import TodoItem from "./TodoItem";

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    const listId = parseInt(prompt("Enter a list ID"));

    fetch(`http://localhost:8081/api/todo/list?id=${listId}`)
      .then(async (response) => {
        const result = await response.json();
        console.log(result);
        setTodos(result);
      });
  }, []);

  const mappedTodos = todos.map((todo, index) => <TodoItem key={index} {...todo}/>)

  if (mappedTodos.length === 0) {
    return (
      <div className="flex items-center justify-center h-screen">
        <div className="text-2xl text-gray-500">No todos found</div>
      </div>
    )
  }

  return (
    <div className="flex items-center flex-col gap-4 pt-4">
      <ul id="todo-list" className="divide-y">
        {mappedTodos}
      </ul>
    </div>
  );
}

export default App;
