import React, { Component } from "react";
import { connect } from "react-redux";
import { createProject } from "../../actions/createProjectActions";
import PropTypes from "prop-types";

class AddProject extends Component {
  constructor() {
    super();
    this.state = {
      projectName: "",
      projectIdentifier: "",
      projectDesc: "",
      startDate: "",
      endDate: "",
    };
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });
  onSubmit = (e) => {
    e.preventDefault();
    let newProject = { ...this.state };

    this.props.createProject(newProject, this.props.history);
  };

  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Project form</h5>
              <hr />
              <form>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Project Name"
                    name="projectName"
                    value={this.state.projectName}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Project ID"
                    name="projectIdentifier"
                    onChange={this.onChange}
                  />
                </div>

                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Project Description"
                    name="projectDesc"
                    onChange={this.onChange}
                  ></textarea>
                </div>
                <h6>Start Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="startDate"
                    onChange={this.onChange}
                  />
                </div>
                <h6>Estimated End Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="endDate"
                    onChange={this.onChange}
                  />
                </div>

                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                  onClick={this.onSubmit}
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddProject.propType = {
  createProject: PropTypes.func.isRequired,
};
export default connect(null, { createProject })(AddProject);
