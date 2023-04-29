import { apiClient } from "./ApiClient";

export const retrieveHelloWorldBean = () => {
  return apiClient.get("/hello-world-bean");
};

export const retrieveHelloWorldPathVariable = (username) => {
  return apiClient.get(`/hello-world/path-variable/${username}`);
};
