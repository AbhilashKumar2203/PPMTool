import React, { Component } from "react";
import {
  getProjectById,
  updateProject,
} from "../../actions/createProjectActions";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import classnames from "classnames";

class UpdateProject extends Component {
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

  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onSubmit = (e) => {
    e.preventDefault();
    let newProject = { ...this.state };

    this.props.updateProject(newProject, this.props.history);
  };

  componentDidMount() {
    this.props.getProjectById(this.props.match.params.id, this.props.history);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({
        errors: nextProps.errors,
      });
    }
    this.setState({
      projectIdentifier: nextProps.selectedProject.projectIdentifier,
      projectName: nextProps.selectedProject.projectName,
      projectDesc: nextProps.selectedProject.projectDesc,
      startDate: nextProps.selectedProject.startDate,
      endDate: nextProps.selectedProject.endDate,
    });
  }
  render() {
    const {
      projectName,
      projectIdentifier,
      projectDesc,
      startDate,
      endDate,
      errors,
    } = this.state;
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update Project form</h5>
              <hr />
              <form>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames("form-control form-control-lg ", {
                      "is-invalid": errors.projectName,
                    })}
                    placeholder="Project Name"
                    value={projectName}
                    name="projectName"
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
                    className="form-control form-control-lg"
                    placeholder="Unique Project ID"
                    name="projectIdentifier"
                    value={projectIdentifier}
                    disabled
                  />
                </div>

                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Project Description"
                    value={projectDesc}
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
                    value={startDate}
                    onChange={this.onChange}
                  />
                </div>
                <h6>Estimated End Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="endDate"
                    value={endDate}
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

UpdateProject.propTypes = {
  getProjectById: PropTypes.func.isRequired,
  updateProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  selectedProject: PropTypes.object.isRequired,
};
const mapStateToProps = (state) => ({
  selectedProject: state.projects.project,
  errors: state.errors,
});
export default connect(mapStateToProps, { getProjectById, updateProject })(
  UpdateProject
);
