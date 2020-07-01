package ml.sadriev.orm.service;

import javax.annotation.Resource;
import ml.sadriev.orm.api.service.IDomainService;
import ml.sadriev.orm.api.service.IProjectService;
import ml.sadriev.orm.api.service.ITaskService;
import org.springframework.stereotype.Service;
import ml.sadriev.orm.model.Domain;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrey Sadriev
 */
@Service
public class DomainService implements IDomainService {

    @Resource
    private IProjectService projectService;
    @Resource
    private ITaskService taskService;

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        projectService.load(domain.getProjects());
//        taskService.load(domain.getTasks());
    }

    @Override
    @Transactional
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(projectService.getListProject());
//        domain.setTasks(taskService.getListTask());
    }

}
