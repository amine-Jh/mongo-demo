package ma.ac.usms.service;

import ma.ac.usms.dao.ProjectDao;
import ma.ac.usms.dto.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProjectService {

    private Logger LOGGER= LoggerFactory.getLogger(ProjectService.class);
    private ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        LOGGER.error("create ProjectService");
        this.projectDao = projectDao;
    }

    public List<Project> getProjects() {
        return projectDao.getProjects();
    }

    public boolean deleteProject(Project project) {
        return projectDao.deleteProject(project);

    }

    public void createProject(Project project) {
        projectDao.createProject(project);
    }
}
