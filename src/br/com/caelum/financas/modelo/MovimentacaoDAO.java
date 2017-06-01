package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovimentacaoDAO {
	
	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saída, Conta conta) {
		String jpql = "select DISTINCT avg(m.valor) from Movimentacao m WHERE m.conta = :pConta"
				+ " AND m.tipo = :pTipo" + " GROUP BY m.data";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAÍDA);

		return query.getResultList();
	}

}