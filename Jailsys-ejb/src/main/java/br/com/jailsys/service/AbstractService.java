package br.com.jailsys.service;

import br.com.jailsys.model.EntidadeComum;

public interface AbstractService<T extends EntidadeComum> {
    
    public void salvar(T entidade);
    public T salvarERetornar(T entidade);
    public void editar(T entidade);
    public void excluir(Long id);
    public void buscar(Long id);
}
