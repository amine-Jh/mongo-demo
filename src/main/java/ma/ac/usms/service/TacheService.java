package ma.ac.usms.service;

import ma.ac.usms.dao.ProjectDao;
import ma.ac.usms.dao.TacheDao;
import ma.ac.usms.dto.Project;
import ma.ac.usms.dto.Tache;

import java.util.List;

public class TacheService {

    private TacheDao tacheDao;

    public TacheService(TacheDao tache) {
        this.tacheDao = tache;
    }

    public List<Tache> getTache() {
        return tacheDao.getTaches();
    }

    public boolean deleteProject(Tache tache) {
        return tacheDao.deleteTache(tache);

    }

    public void createTache(Tache tache) {
        tacheDao.createTache(tache);
    }
}
