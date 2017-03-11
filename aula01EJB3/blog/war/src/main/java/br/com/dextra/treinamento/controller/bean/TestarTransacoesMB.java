package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.dextra.treinamento.model.service.transaction.ClienteTransacoesLocal;

@ManagedBean(name = "testarTransacoesMB")
@RequestScoped
public class TestarTransacoesMB {
	@EJB
	private ClienteTransacoesLocal clientesTransacoesLocal;
	
	public void testarRequired(){
		try {
			clientesTransacoesLocal.testarRequired();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void testarRequiresNew(){
		try {
			clientesTransacoesLocal.testarRequiresNew();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
