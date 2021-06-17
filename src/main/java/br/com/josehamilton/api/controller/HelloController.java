package br.com.josehamilton.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josehamilton.api.service.HelloService;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@PostMapping
	public ResponseEntity<?> getHelloWorld(@RequestBody Object object) {
		if ( object != null && !object.toString().isEmpty() ) {
			this.helloService.getHelloWorld(object);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> getHelloWorldVarious(@RequestBody List<Object> listObjects) {
		if ( listObjects != null && listObjects.size() > 0 && !listObjects.toString().isEmpty() ) {
			this.helloService.getHelloWorldVarious(listObjects);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
