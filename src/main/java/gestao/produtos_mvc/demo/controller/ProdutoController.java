package gestao.produtos_mvc.demo.controller;

import gestao.produtos_mvc.demo.model.Produto;
import gestao.produtos_mvc.demo.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

        if("excluir".equals(acao) && id != null){
            service.excluir(id);
            return "redirect:/produto?msg=excluido";
        }

        List<Produto> lista = service.listar();
        model.addAttribute("produtos", lista);
        model.addAttribute("msg", msg);

        return "produtos";
    }

    @PostMapping
    public String salvar(@RequestParam(required = false) Integer id,
                         @RequestParam(required = false) String nome,
                         @RequestParam(required = false) String descricao,
                         @RequestParam(required = false) double preco,
                         @RequestParam(required = false) int quantidade,
                         HttpSession session,
                         RedirectAttributes redirectAttributes){

        if(session.getAttribute("usuario") == null){
            return "redirect:/index.jsp";
        }

        Produto p = new Produto(nome, descricao, preco, quantidade);

        if(id != null){
            p.setId(id);
            service.atualizar(p);
            redirectAttributes.addAttribute("msg", "editado");
        } else {
            service.inserir(p);
            redirectAttributes.addAttribute("msg", "salvo");
        }
        return "redirect:/produto";
    }
}
