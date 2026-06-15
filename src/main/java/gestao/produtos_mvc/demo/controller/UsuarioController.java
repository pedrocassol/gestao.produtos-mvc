package gestao.produtos_mvc.demo.controller;

import model.Usuario;
import gestao.produtos_mvc.demo.dao.UsuarioDAO;
import gestao.produtos_mvc.demo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service = new UsuarioService();

    @PostMapping
    public String cadastrar(@RequestParam String nome, @RequestParam String email, @RequestParam String senha, Model model){

        Usuario u = new Usuario(nome, email, senha, true);
        boolean sucesso = service.inserir(u);

        if(sucesso){
            return "redirect:/login";
        }else{
            model.addAttribute("erro", "Erro ao cadastrar usuário");
            return "cadastro";
        }
    }
}
