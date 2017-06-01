package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Renan");
		conta.setAgencia("123");
		conta.setBanco("Itaú");
		conta.setNumero("789");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		
		em.close();
		
	}

}
