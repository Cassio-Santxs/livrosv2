package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/apí/carro")
public class LivroController {
	
	@Autowired
	private LivroService carroService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Livro livro) {
		try {
			String mensagem = this.carroService.save(livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<String>("ERRO! " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll() {
		try {
			List<Livro> list = this.carroService.listAll();
			return new ResponseEntity<List<Livro>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<List<Livro>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody Livro livro) {
		try {
			String message = this.carroService.delete(livro);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/put")
	public ResponseEntity<String> put(@RequestBody Livro livro) {
		try {
			String message = this.carroService.put(livro);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
