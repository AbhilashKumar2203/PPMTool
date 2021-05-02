import React, { Component } from "react";
import { connect } from "react-redux";
import { createProject } from "../../actions/createProjectActions";
import PropTypes from "prop-types";
import classnames from "classnames";

class AddProject extends Component {
  constructor() {
    super();
    this.state = {
      projectName: "",
      projectIdentifier: "",
      projectDesc: "",
      startDate: "",
      endDate: "",
      errors: {},
    };
  }

  comp;
  //Using this methos to set component state with application state.
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({
        errors: nextProps.errors,
      });
    }
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });
  onSubmit = (e) => {
    e.preventDefault();
    let newProject = { ...this.state };

    this.props.createProject(newProject, this.props.history);
  };

  render() {
    const { errors } = this.state;
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
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.projectName,
                    })}
                    placeholder="Project Name"
                    name="projectName"
                    value={this.state.projectName}
                    onChange={this.onChange}
                  />
                  {errors.projectName && (
                    <span className="invalid-feedback">
                      {errors.projectName}
                    </span>
                  )}
                </div>

                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.projectIdentifier,
                    })}
                    placeholder="Unique Project ID"
                    name="projectIdentifier"
                    onChange={this.onChange}
                  />
                  {errors.projectIdentifier && (
                    <span className="invalid-feedback">
                      {errors.projectIdentifier}
                    </span>
                  )}
                </div>

                <div className="form-group">
                  <textarea
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.projectDesc,
                    })}
                    placeholder="Project Description"
                    name="projectDesc"
                    onChange={this.onChange}
                  ></textarea>
                  {errors.projectDesc && (
                    <span className="invalid-feedback">
                      {errors.projectDesc}
                    </span>
                  )}
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
  errors: PropTypes.object.isRequired,
};

//mapStateToProps is used to connect application state available in store to component. SO application state.errors will be available as props(nextProps) in this component.
const mapStateToProps = (state) => ({
  errors: state.errors,
});

//Added mapStateToProps as parameter to connect to make application state values available here in component.
export default connect(mapStateToProps, { createProject })(AddProject);
