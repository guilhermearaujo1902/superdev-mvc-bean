package br.com.mvcBean.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvcBean.model.Pessoa;

@Named("pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;
	
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private int idSequencia = 1;
	
	public String adicionar() {
		pessoa.setId(this.gerarId());
		pessoas.add(pessoa);
		pessoa = new Pessoa();
		return "/pessoa/lista.xhtml";
	}
	
	public String editar() {
		int index = pessoas.indexOf(pessoa);
		Pessoa p = pessoa;
		
		pessoas.remove(pessoa);
		pessoas.add(index,p);
		
		pessoa = new Pessoa();
		
		return "/pessoa/lista.xhtml";
	}
	
	public String telaEdicao() {
		System.out.println("telaEdicao");
		return "/pessoa/editar.xhtml";
	}
	
	public void carregarEdicao(ActionEvent event) {
		System.out.println("telaEdicao");
		Pessoa p = (Pessoa) event.getComponent().getAttributes().get("pessoa");
		
		pessoa.setId(p.getId());
		pessoa.setNome(p.getNome());
		pessoa.setProfissao(p.getProfissao());
	}
	
	private int gerarId() {
		return idSequencia++;
	}
	

	// Getter and Setter
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	

}
