package br.com.dextra.treinamento.model.service.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dextra.treinamento.model.domain.PostAudit;

public class AuditInterceptor {
	@PersistenceContext(unitName = "blog-pu")
	private EntityManager em;
	
	@AroundInvoke
	public Object logar(InvocationContext ctx) throws Exception{
		
		String classe =  ctx.getTarget().getClass().getSimpleName();
		String metodo = ctx.getMethod().getName();
		String parametros = ctx.getParameters().toString();
		
		PostAudit postAudit= new PostAudit();
		postAudit.setClasse(classe);
		postAudit.setMetodo(metodo);
		postAudit.setParametros(parametros);
		
		em.persist(postAudit);
		
		return ctx.proceed();
	}

}
