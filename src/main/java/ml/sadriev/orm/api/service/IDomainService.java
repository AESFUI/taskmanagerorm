package ml.sadriev.orm.api.service;

import ml.sadriev.orm.model.Domain;

/**
 * @author Andrey Sadriev
 */
public interface IDomainService {

    void load(Domain domain);

    void export(Domain domain);

}
