package ml.sadriev.orm.service;

import javax.annotation.Resource;
import ml.sadriev.orm.api.service.IDomainService;
import org.springframework.stereotype.Service;
import ml.sadriev.orm.entity.Domain;

/**
 * @author Denis Volnenko
 */
@Service
public final class DomainService implements IDomainService {

    @Resource
    private ProjectService projectService;
    @Resource
    private TaskService taskService;

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        projectService.load(domain.getProjects());
        taskService.load(domain.getTasks());
    }

    @Override
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(projectService.getListProject());
        domain.setTasks(taskService.getListTask());
    }

}
