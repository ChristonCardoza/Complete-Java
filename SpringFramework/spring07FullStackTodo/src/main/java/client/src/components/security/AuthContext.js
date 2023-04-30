import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/ApiClient";
import {
  retrieveBasicAuthenticationService,
  retrieveJwtAuthenticationService,
} from "../api/AuthenticationService";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const [token, setToken] = useState(null);

  // const login = async (username, password) => {
  //   const baToken = "Basic " + window.btoa(username + ":" + password);

  //   try {
  //     const response = await retrieveBasicAuthenticationService(baToken);

  //     if (response.status === 200) {
  //       setIsAuthenticated(true);

  //       setUsername(username);

  //       setToken(baToken);

  //       apiClient.interceptors.request.use((config) => {

  //         config.headers.Authorization = baToken;

  //         return config;
  //       });

  //       return true;

  //     } else {
  //       logout();

  //       return false;
  //     }
  //   } catch (error) {
  //     logout();

  //     return false;
  //   }
  // };

  const login = async (username, password) => {
    try {
      const response = await retrieveJwtAuthenticationService(
        username,
        password
      );

      if (response.status === 200) {
        const jwtToken = "Bearer " + response.data.token;

        setIsAuthenticated(true);

        setUsername(username);

        setToken(jwtToken);

        apiClient.interceptors.request.use((config) => {
          config.headers.Authorization = jwtToken;

          return config;
        });

        return true;
      } else {
        logout();

        return false;
      }
    } catch (error) {
      logout();

      return false;
    }
  };

  const logout = () => {
    setIsAuthenticated(false);
    setUsername(null);
    setToken(null);
  };

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated,
        setIsAuthenticated,
        login,
        logout,
        username,
        token,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;
