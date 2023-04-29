import { apiClient } from "./ApiClient";

export const retrieveBasicAuthenticationService = (token) => {
  return apiClient.get(`/basicauth`, {
    headers: {
      Authorization: token,
    },
  });
};

export const retrieveJwtAuthenticationService = (username, password) => {
  return apiClient.post(`/authenticate`, { username, password });
};
