import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

const LoginComponent = () => {
  const [username, setUsername] = useState("DeadMan");
  const [password, setPassword] = useState("******");
  const [showErrorMessage, setShowErrorMessage] = useState(false);
  const navigate = useNavigate();
  const { login } = useAuth();

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = async () => {
    if (await login(username, password)) {
      setShowErrorMessage(false);
      navigate(`/welcome/${username}`);
    } else {
      setShowErrorMessage(true);
    }
  };

  return (
    <div className="Login">
      {showErrorMessage && (
        <div className="errorMessage">
          Authentication Failed. Please check your credentials
        </div>
      )}

      <div className="LoginForm">
        <h1>Time to Login!</h1>
        <div>
          <label for="username">User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label for="password">Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
};

export default LoginComponent;
