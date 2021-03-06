import axios from "axios";
import {
  DELETE_PROJECT,
  GET_ERRORS,
  GET_PROJECTS,
  GET_PROJECT_BY_ID,
} from "./type";

export const createProject = (project, history) => async (dispatch) => {
  try {
    const res = await axios.post("http://localhost:8080/api/project", project);
    console.log(res);
    history.push("/");
  } catch (err) {
    console.log(err);
    if (err.response != undefined)
      dispatch({
        type: GET_ERRORS,
        payload: err.response.data,
      });
  }
};

export const updateProject = (project, history) => async (dispatch) => {
  try {
    const res = await axios.put("http://localhost:8080/api/project", project);
    history.push("/");
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (err) {
    if (err.response != undefined)
      dispatch({
        type: GET_ERRORS,
        payload: err.response.data,
      });
  }
};

export const getProjects = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8080/api/project");
  dispatch({
    type: GET_PROJECTS,
    payload: res.data,
  });
};

export const getProjectById = (projectId, history) => async (dispatch) => {
  try {
    const res = await axios.get(
      `http://localhost:8080/api/project/${projectId}`
    );
    dispatch({
      type: GET_PROJECT_BY_ID,
      payload: res.data,
    });
  } catch (err) {
    history.push("/");
  }
};

export const deleteProject = (projectId) => async (dispatch) => {
  const res = await axios.delete(
    `http://localhost:8080/api/project/${projectId}`
  );
  console.log(res);
  dispatch({
    type: DELETE_PROJECT,
    payload: projectId,
  });
};
