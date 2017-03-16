package br.com.principal;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.controller.PessoaControllerRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		Hashtable<String, Object> jndiProperties = new Hashtable<String, Object>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, 
				"org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, 
        		"http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", 
        		true);
        
        
        final Context context = new InitialContext(jndiProperties);
        PessoaControllerRemote p =  (PessoaControllerRemote) 
        		context.lookup("ProjetoEAR/"
        				+ "ProjetoEJB/"
        				+ "PessoaController!"
        				+ "br.com.controller.PessoaControllerRemote");
        p.cadastrar("Romulo", "Teste");
	}

}
