import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/createProjectActions";

class ProjectItem extends Component {
  onDeleteClick = (projectId) => {
    this.props.deleteProject(projectId);
  };
  render() {
    const { project } = this.props;

    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{project.projectIdentifier}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{project.projectName}</h3>
              <p>{project.projectDesc}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">
                      <span style={{ paddingLeft: "10px" }}>Project Board</span>
                    </i>
                  </li>
                </a>
                <Link to={`/updateProject/${project.projectIdentifier}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1">
                      <span style={{ paddingLeft: "10px" }}>
                        Update Project Info
                      </span>
                    </i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={() => this.onDeleteClick(project.projectIdentifier)}
                >
                  <i className="fa fa-minus-circle pr-1">
                    <span style={{ paddingLeft: "10px" }}>Delete Project</span>
                  </i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired,
};

export default connect(null, { deleteProject })(ProjectItem);
