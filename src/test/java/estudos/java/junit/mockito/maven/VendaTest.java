package estudos.java.junit.mockito.maven;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;


import org.junit.Test;

import estudos.java.junit.mockito.maven.loja.Client;
import estudos.java.junit.mockito.maven.loja.CreditoService;
import estudos.java.junit.mockito.maven.loja.Venda;

public class VendaTest {

	@Test
	public void testCheckoutClienteComLimite() {
		Client cliente = new Client("Gabriel", "07064987995");
		CreditoService credito = mock(CreditoService.class);
		when(credito.getLimite(cliente.getCpf())).thenReturn(1000.0);
		Venda venda= new Venda(500.0, cliente, credito);
		Boolean resultado =venda.chekout();
		assertTrue(resultado);
	}
	
	@Test
	public void testCheckoutClienteSemLimite() {
		Client cliente = new Client("Gabriel", "07064987995");
		CreditoService credito = mock(CreditoService.class);
		when(credito.getLimite(cliente.getCpf())).thenReturn(400.0);
		Venda venda= new Venda(500.0, cliente, credito);
		Boolean resultado =venda.chekout();
		assertFalse(resultado);
	}
	
	@Test
	public void testCheckoutClienteCompraAvista() {
		Client cliente = new Client("Gabriel", "07064987995");
		CreditoService credito = mock(CreditoService.class);
		when(credito.getLimite(cliente.getCpf())).thenReturn(400.0);
		Venda venda= new Venda(500.0, cliente, credito, true);
		Boolean resultado = venda.chekout();
		verify(credito, never()).getLimite(cliente.getCpf());
	}
	
	@Test
	public void testCheckoutNaoEfetivaVendaCasoFalhe() {
		Client cliente = new Client("Gabriel", "07064987995");
		CreditoService credito = mock(CreditoService.class);
		when(credito.getLimite(anyString())).thenThrow(new RuntimeException());
		Venda venda= new Venda(500.0, cliente, credito);
		Boolean resultado =venda.chekout();
		assertFalse(resultado);
	}
	
	

}
