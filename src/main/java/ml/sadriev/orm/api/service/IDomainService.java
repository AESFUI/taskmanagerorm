package ml.sadriev.orm.api.service;

import ml.sadriev.orm.entity.Domain;

/**
 * @author Denis Volnenko
 */
public interface IDomainService {

    void load(Domain domain);

    void export(Domain domain);

}
