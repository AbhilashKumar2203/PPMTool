import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import AddProjectButton from "./Project/AddProjectButton";
import { connect } from "react-redux";
import { getProjects } from "../actions/createProjectActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getProjects();
  }
  render() {
    const { projects } = this.props.allProjects;
    const projectList = projects.map((project) => (
      <ProjectItem key={project.id} project={project} />
    ));

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <AddProjectButton />
              <br />
              <hr />

              {
                //<!-- Project Item Component -->
              }
              {projectList}
              {
                //<!-- End of Project Item Component -->
              }
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  getProjects: PropTypes.func.isRequired,
};

//Here allProjects actually having appliation state i.e projects:[], project:{} in to allProjects prop
const mapStateToProps = (state) => ({
  allProjects: state.projects,
});

export default connect(mapStateToProps, { getProjects })(Dashboard);
