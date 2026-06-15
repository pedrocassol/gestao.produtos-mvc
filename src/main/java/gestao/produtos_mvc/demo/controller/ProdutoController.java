package gestao.produtos_mvc.demo.controller;

import gestao.produtos_mvc.demo.model.Produto;
import gestao.produtos_mvc.demo.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service = new ProdutoService();

    @GetMapping
    public String listar(@RequestParam(required = false) String acao,
                         @RequestParam(required = false) Integer id,
                         @RequestParam(required = false) String msg,
                         HttpSession session,
                         Model model){

        if(session.getAttribute("usuario") == null){
            return "redirect:/index.jsp";
        }

        if("editar".equals(acao) && id != null){
            Produto p = service.buscarPorId(id);
            model.addAttribute("produto", p);
        }


    }
}
