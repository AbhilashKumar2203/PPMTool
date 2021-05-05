import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReducer from "./projectsReducer";

export default combineReducers({
  errors: errorReducer,
  projects: projectReducer,
});
