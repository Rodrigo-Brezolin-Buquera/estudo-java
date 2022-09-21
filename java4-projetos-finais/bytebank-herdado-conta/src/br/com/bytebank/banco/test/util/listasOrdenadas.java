package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class listasOrdenadas {

        public static void main(String[] args) {

        	 Conta cc1 = new ContaCorrente(22, 33);
             Cliente clienteCC1 = new Cliente();
             clienteCC1.setNome("Nico");
             cc1.setTitular(clienteCC1);
             cc1.deposita(333.0);

             Conta cc2 = new ContaPoupanca(22, 44);
             Cliente clienteCC2 = new Cliente();
             clienteCC2.setNome("Guilherme");
             cc2.setTitular(clienteCC2);
             cc2.deposita(444.0);

             Conta cc3 = new ContaCorrente(22, 11);
             Cliente clienteCC3 = new Cliente();
             clienteCC3.setNome("Paulo");
             cc3.setTitular(clienteCC3);
             cc3.deposita(111.0);

             Conta cc4 = new ContaPoupanca(22, 22);
             Cliente clienteCC4 = new Cliente();
             clienteCC4.setNome("Ana");
             cc4.setTitular(clienteCC4);
             cc4.deposita(222.0);
                

                List<Conta> lista = new ArrayList<>();
                lista.add(cc1);
                lista.add(cc2);
                lista.add(cc3);
                lista.add(cc4);
                
                
                NumeroContaComparator comparator = new NumeroContaComparator();
                TitularDaContaComparator titularComparetor = new TitularDaContaComparator();
                
             
                
                lista.sort(comparator);
                
                // clases anominimas 
                
                lista.sort( 
                		new Comparator<Conta>() {

                	@Override
                	public int compare(Conta o1, Conta o2) {
                	
                		String nomeo1 = o1.getTitular().getNome();
                		String nomeo2 = o2.getTitular().getNome();
                		
                		return nomeo1.compareTo(nomeo2);
                		
                		
                	}               		                        		
                		});
                
                
                // ou 
                
                Comparator<Conta> comp = new Comparator<Conta>() {

                	@Override
                	public int compare(Conta o1, Conta o2) {
                	
                		String nomeo1 = o1.getTitular().getNome();
                		String nomeo2 = o2.getTitular().getNome();
                		
                		return nomeo1.compareTo(nomeo2);
                		
                		
                	}               		                        		
                		};
                		
                		
               // lambdas 
                		 lista.sort((Conta o1, Conta o2) -> {
                         	
                     		String nomeo1 = o1.getTitular().getNome();
                     		String nomeo2 = o2.getTitular().getNome();
                     		
                     		return nomeo1.compareTo(nomeo2);
                     		
                     	});               	          
                		
                		
                		

        }

}

class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta o1, Conta o2) {
	
		String nomeo1 = o1.getTitular().getNome();
		String nomeo2 = o2.getTitular().getNome();
		
		return nomeo1.compareTo(nomeo2);
		
		
	}

}


class NumeroContaComparator implements Comparator<Conta>{

	@Override
	public int compare(Conta o1, Conta o2) {
		
		if(o1.getNumero() < o2.getNumero()) {
			return -1;
		}
		
		if(o1.getNumero() > o2.getNumero()) {
			return 1;
		}
		return 0;
		
		// ou
		// return getNumero() - o2.getNumero()
		
		// melhor ainda
		// return Integer.compare(getNumero(), o2.getNumero())
	}
	
	
	
	
}