package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.security.AgesSecurity;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Usuario;

public class ListUserCommand implements Command {

	private String proxima;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request) {
		this.usuarioBO = new UsuarioBO();
		proxima = "user/listUser.jsp";

		try {
			// AgesSecurity.listarUser();
			List<Usuario> listaUsuarios = usuarioBO.listarUsuario();
			request.setAttribute("listaUsuarios", listaUsuarios);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return proxima;
	}
}
