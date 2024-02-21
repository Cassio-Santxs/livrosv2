package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {
	
	private List<Livro> lista = new ArrayList<>();
	
	public String save(Livro livro) {
		lista.add(livro);
		return "Salvo com sucesso!";
	}
	
	public List<Livro> listAll() {
        return this.lista;
	}
	
	public String delete(Livro livro) {
		lista.remove(livro);
		return "Excluído com sucesso!";
	}
	
	public String put(Livro livro) {
		var index = lista.indexOf(livro); 
		
		this.lista.set(index, livro);

		return "Atualizado com sucesso!";
	}
}
