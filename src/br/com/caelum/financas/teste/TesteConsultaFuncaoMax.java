package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(5);
	
	Query query = em.createQuery("SELECT max(m.valor) FROM Movimentacao m WHERE m.conta = :pConta");
	query.setParameter("pConta", conta);
	
	BigDecimal valorMaximo = (BigDecimal) query.getSingleResult();
	
	System.out.println("Valor m�ximo da movimenta��o: " + valorMaximo);
	
	em.getTransaction().commit();

	em.close();
	
	}
}
