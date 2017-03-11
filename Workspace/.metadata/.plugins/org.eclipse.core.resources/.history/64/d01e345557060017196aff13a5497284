package br.com.dextra.treinamento.model.service.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class PostServiceImpl implements PostServiceLocal {
	
	@PersistenceContext(unitName = "blog-pu")
	private EntityManager em;

	//private List<Post> posts = new ArrayList<Post>();

	public void salvar(Post p) {
		// posts.add(p);
		em.merge(p);
	}

	@SuppressWarnings("unchecked")
	public List<Post> listar() {
		// return posts;
		String sql = "FROM Post";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public void excluir(Long id) {
		Post post = BuscarPorId(id);
		em.remove(post);
	}

	@Override
	public Post BuscarPorId(Long id) {

		return em.find(Post.class, id);
	}
}
