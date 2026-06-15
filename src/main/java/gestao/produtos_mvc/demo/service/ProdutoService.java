package gestao.produtos_mvc.demo.service;

import gestao.produtos_mvc.demo.dao.ProdutoDAO;
import gestao.produtos_mvc.demo.model.Produto;

import java.util.List;

public class ProdutoService {

    public List<Produto> listar() {
        return new ProdutoDAO().listar();
    }

    public boolean inserir(Produto p) {
        return new ProdutoDAO().inserir(p);
    }

    public void excluir(int id) {
        new ProdutoDAO().excluir(id);
    }

    public void atualizar(Produto p) {
        new ProdutoDAO().atualizar(p);
    }

    public Produto buscarPorId(int id) {
        return new ProdutoDAO().buscarPorId(id);
    }
}
