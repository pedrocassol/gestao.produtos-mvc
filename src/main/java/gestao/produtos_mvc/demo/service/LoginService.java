package gestao.produtos_mvc.demo.service;

import gestao.produtos_mvc.demo.dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public Usuario autenticar(String email, String senha) {
        try {
            return new UsuarioDAO().autenticar(email, senha);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
