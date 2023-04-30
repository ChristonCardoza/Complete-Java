import { Link, useParams } from "react-router-dom";
import { retrieveHelloWorldPathVariable } from "./api/HelloWorldService";
import { useAuth } from "./security/AuthContext";
import { useState } from "react";

const WelcomeComponent = () => {
  const { username } = useParams();
  const { token } = useAuth();
  const [message, setMessage] = useState(null);

  const callHelloWorldRestApi = () => {
    retrieveHelloWorldPathVariable(username)
      .then((response) => successfulResponse(response))
      .catch((error) => errorResponse(error));
  };

  const successfulResponse = (response) => {
    setMessage(response.data.message);
  };

  const errorResponse = (error) => {
    console.log(error);
  };

  return (
    <div className="WelcomeComponent">
      <h1>Welcome {username}</h1>
      <div>
        Manage your todos - <Link to="/todos">Go here</Link>
      </div>
      <div>
        <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
          Call Hello World
        </button>
      </div>
      <div className="text-info">{message}</div>
    </div>
  );
};

export default WelcomeComponent;
