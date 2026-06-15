package gestao.produtos_mvc.demo.service;


import gestao.produtos_mvc.demo.dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    public boolean inserir(Usuario u) {
        return new UsuarioDAO().inserir(u);
    }
}
