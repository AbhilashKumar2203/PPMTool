import axios from "axios";
import { GET_ERRORS } from "./type";

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
