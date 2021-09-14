package estudos.java.junit.mockito.maven.loja;

public class Venda {

	private Double valor;
	private Client cliente;
	private ICredito creditoService;
	private Boolean avista = false;;

	
	
	public Venda(Double valor, Client cliente, ICredito cretido) {
		super();
		this.valor = valor;
		this.cliente = cliente;
		this.creditoService = cretido;
	}
	public Venda(Double valor, Client cliente, ICredito cretido, Boolean avista) {
		super();
		this.valor = valor;
		this.cliente = cliente;
		this.creditoService = cretido;
		this.avista = avista;
	}



	public Double getValor() {
		return valor;
	}


	public Client getCliente() {
		return cliente;
	}
	
	public Boolean chekout () {
		if(avista) {
			return true;
		}
		try {
			Double limite;
			limite = creditoService.getLimite(cliente.getCpf())	;
			if(limite >= valor) {
				return true ;
			}
			
		} catch (RuntimeException e) {
		
		}
		
		
		return false;
	}
	
}
