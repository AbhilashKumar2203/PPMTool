import React, { Component } from "react";
import {
  getProjectById,
  updateProject,
} from "../../actions/createProjectActions";
import { connect } from "react-redux";

class UpdateProject extends Component {
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
    console.log("componet will receive props" + nextProps);
    this.setState({
      projectIdentifier: nextProps.selectedProject.projectIdentifier,
      projectName: nextProps.selectedProject.projectName,
      projectDesc: nextProps.selectedProject.projectDesc,
    });
  }
  render() {
    const { projectName, projectIdentifier, projectDesc } = this.state;
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
                    className="form-control form-control-lg "
                    placeholder="Project Name"
                    value={projectName}
                    name="projectName"
                    onChange={this.onChange}
                  />
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

const mapStateToProps = (state) => ({
  selectedProject: state.projects.project,
});
export default connect(mapStateToProps, { getProjectById, updateProject })(
  UpdateProject
);
