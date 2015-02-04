package br.com.jailsys.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.com.jailsys.model.EntidadeComum;

@SuppressWarnings("unchecked")
public abstract class GenericDAO<T extends EntidadeComum> {

    private static final String QUERY_LISTAR_POR = "FROM %s o WHERE o.%s = :valor";

    @PersistenceContext(unitName = "jailsys")
    private EntityManager manager;

    private static final Logger LOGGER = Logger.getLogger(GenericDAO.class);

    public void salvar(T entidade) {
        getEntityManager().persist(entidade);
        getEntityManager().flush();
    }

    public void editar(T entidade) {
        getEntityManager().merge(entidade);
        getEntityManager().flush();
    }

    public T buscar(Long id) {
        return (T) getEntityManager().find(getTypeClass(), id);
    }

    public T buscaDetach(Long id) {
        T object = (T) buscar(id);
        getEntityManager().detach(object);
        return object;
    }

    public void excluir(T entidade) {
        entidade = getEntityManager().merge(entidade);
        getEntityManager().remove(entidade);
        getEntityManager().flush();
    }

    public void excluir(Long id) {
        T object = buscar(id);
        excluir(object);
    }

    public List<T> listarPor(String atributo, Object valor) {
        String sql = String.format(QUERY_LISTAR_POR, getTypeClass().getSimpleName(), atributo);
        Query query = getEntityManager().createQuery(sql);
        query.setParameter("valor", valor);
        return query.getResultList();
    }

    public List<T> listarPorLike(String atributo, Object valor) {
        Query query = getEntityManager().createQuery(
                "FROM " + getTypeClass().getSimpleName() + " o WHERE o."
                        + atributo + " like :valor");
        query.setParameter("valor", "%" + valor + "%");
        return query.getResultList();
    }

    public T buscarPor(String atributo, Object valor) {
        Query query = getEntityManager().createQuery(
                "FROM " + getTypeClass().getSimpleName() + " o WHERE o."
                        + atributo + " = :valor");
        query.setParameter("valor", valor);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public List<T> listar() {
        return getEntityManager().createQuery(
                "FROM " + getTypeClass().getSimpleName() + " o")
                .getResultList();
    }

    public T attach(T object) {
        return (T) getEntityManager().getReference(getTypeClass(),
                object.getId());
    }

    protected EntityManager getEntityManager() {
        if (manager == null) {
            throw new IllegalStateException("getEntityManager() não foi setado antes do uso neste DAO");
        }
        return manager;
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T salvarERetornar(T entidade) {
        getEntityManager().persist(entidade);
        getEntityManager().flush();
        return entidade;
    }

    public Query criarQuery(String query) {
        return getEntityManager().createQuery(query);
    }

}
