import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import AddProjectButton from "./Project/AddProjectButton";

export default class Dashboard extends Component {
  render() {
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
              <ProjectItem />
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
