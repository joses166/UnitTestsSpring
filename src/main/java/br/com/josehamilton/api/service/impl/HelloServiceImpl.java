package br.com.josehamilton.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.josehamilton.api.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public void getHelloWorld(Object object) {
		System.out.println("Resultado: " + object.toString());
	}
	
	@Override
	public void getHelloWorldVarious(List<Object> listObjects) {
		System.out.println("Resultado: " + listObjects.toString());
	}

}
