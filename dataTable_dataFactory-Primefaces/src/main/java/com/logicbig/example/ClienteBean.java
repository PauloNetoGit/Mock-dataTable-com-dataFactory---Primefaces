package com.logicbig.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.fluttercode.datafactory.impl.DataFactory;

@ManagedBean
@ViewScoped
public class ClienteBean {
	private List<Cliente> listaDeClientes = new ArrayList<Cliente>();
 
	@PostConstruct
	private void postConstruct() {
		DataFactory dataFactory = new DataFactory();
		for (int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setId(i);
			cliente.setNome(dataFactory.getName());
			cliente.setNumeroTelefone(
					String.format("(81) 9 " + "%s-%s", dataFactory.getNumberText(4), dataFactory.getNumberText(4)));
			cliente.setEndereco(dataFactory.getStreetName() + ",  " + dataFactory.getCity() + " - "
					+ dataFactory.getNumberBetween(000, 999));
			listaDeClientes.add(cliente);
		}
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
}