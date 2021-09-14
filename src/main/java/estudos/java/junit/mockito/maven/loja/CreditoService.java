package estudos.java.junit.mockito.maven.loja;

public class CreditoService implements ICredito {
	
	@Override
	public Double getLimite(String cpf) {
		System.out.println("Consultando Cretito...");
		return 2000.0;
	}
}
