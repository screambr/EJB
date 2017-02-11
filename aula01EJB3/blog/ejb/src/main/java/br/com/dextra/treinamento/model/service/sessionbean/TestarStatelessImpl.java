package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.dextra.treinamento.model.service.interceptor.LogInterceptor;

@Stateless
@Interceptors(value = LogInterceptor.class)
public class TestarStatelessImpl implements TestarStatelessLocal {

	Integer contador = 0;

	@Override
	public Integer adicionar() {
		contador++;
		return contador;
	}

}
