import { bindActionCreators } from "redux";
import {
  GET_PROJECTS,
  GET_PROJECT_BY_ID,
  DELETE_PROJECT,
} from "../actions/type";

const initialState = {
  projects: [],
  project: {},
};

const projectReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_PROJECTS:
      return {
        ...state,
        projects: action.payload,
      };

    case GET_PROJECT_BY_ID:
      return {
        ...state,
        project: action.payload,
      };
    case DELETE_PROJECT:
      return {
        ...state,
        projects: state.projects.filter(
          (project) => project.projectIdentifier != action.payload
        ),
      };

    default:
      return state;
  }
};

export default projectReducer;
