package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(5);

		String jpql = "select m from Movimentacao m WHERE m.conta = :pConta" +
						" AND m.tipo = :pTipo" +
						" ORDER BY m.valor DESC";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAÍDA);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Conta.id: " + movimentacao.getConta().getId() + " - Descrição: "
					+ movimentacao.getDescricao() + " - Valor: " + movimentacao.getValor());
		}
		em.getTransaction().commit();

		em.close();
	}
}
