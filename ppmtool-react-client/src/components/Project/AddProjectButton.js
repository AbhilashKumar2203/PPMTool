import React, { Fragment } from "react";
import { Link } from "react-router-dom";

const AddProjectButton = () => {
  return (
    <Fragment>
      <Link
        to="/addProject"
        href="ProjectForm.html"
        className="btn btn-lg btn-info"
      >
        Create a Project
      </Link>
    </Fragment>
  );
};

export default AddProjectButton;
