package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
	    Conta conta = em.find(Conta.class, 5);
	    
	    Query query = em.createQuery("SELECT count(m) FROM Movimentacao m WHERE m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		Long qtdMov = (Long) query.getSingleResult();
		
		System.out.println("Total de movimentações: " + qtdMov);
	    
	    
	}

}
