package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.jailsys.model.Usuario;
import br.com.jailsys.qualifier.UsuarioBean;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.util.FacesUtil;

import com.google.common.base.Strings;

public class ProdutorUsuario {
    @Inject
    private UsuarioService usuarioService;

    @Produces
    @UsuarioBean
    public Usuario produzirUsuario() {
        Usuario usuario = new Usuario();
        String id = FacesUtil.getRequestParameter("idUsuario");
        if (!Strings.isNullOrEmpty(id)) {
            Long idLong = new Long(id);
            usuario = (Usuario) usuarioService.buscar(idLong);
        }
        return usuario;
    }
}
