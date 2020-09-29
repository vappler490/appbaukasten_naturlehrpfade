const projectModule = {
  state: {
    projectId: "",
    currentProject: null,
    centerLatLng: "",
    projects: [],

  },
  mutations: {
    changeCurrentProject(state, project) {
      state.currentProject = project;
    },
    addProject(state, project) {
      state.projects.push(project);
    },
    getProjects(state, projects) {
      state.projects = projects;
    },
    changeCenterLatLng(state, center) {
      state.centerLatLng = center;
    },
    changeProjectId(state, projectId) {
      state.projectId = projectId
    }
  },
  actions: {},
  getters: {
    currentProject: state => state.currentProject,
    projects: state => state.projects,
    centerLatLng: state => state.centerLatLng,
    projectId: state => state.projectId
  }
}

export default projectModule
