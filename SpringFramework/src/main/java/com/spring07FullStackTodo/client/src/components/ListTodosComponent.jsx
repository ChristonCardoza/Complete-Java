import { useEffect, useState } from "react";
import {
  retrieveAllTodosForUsername,
  deleteTodoForUsername,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

const ListTodosComponent = () => {
  const today = new Date();

  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );

  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);
  const { username } = useAuth();
  const navigate = useNavigate();

  const refreshTodos = () => {
    retrieveAllTodosForUsername(username)
      .then((response) => {
        console.log(response.data);
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  };

  const deleteTodo = (id) => {
    setMessage(`Delete of todo with id = ${id} successful`);
    deleteTodoForUsername(username, id).then(() => {
      // setMessage(`Delete of todo with ${id} successful`);
      refreshTodos();
    });
  };

  const updateTodo = (id) => {
    navigate(`/todo/${id}`);
  };

  const addNewTodo = () => {
    navigate("/todo/-1");
  };

  useEffect(() => refreshTodos(), []);

  return (
    <div className="container">
      {message && <div className="alert alert-warning">{message}</div>}
      <h1>Things You Want to Do!</h1>
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Is Done?</th>
              <th>Target Date</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {todos?.map(({ id, description, done, targetDate }) => (
              <tr key={id}>
                <td>{description}</td>
                <td>{done.toString()}</td>
                {/* <td>{targetDate.toDateString()}</td> */}
                <td>{targetDate.toString()}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => deleteTodo(id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="btn btn-success m-5" onClick={() => addNewTodo()}>
        Add New Todo
      </div>
    </div>
  );
};

export default ListTodosComponent;
