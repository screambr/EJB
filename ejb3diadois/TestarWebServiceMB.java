package br.com.dextra.treinamento.controller.bean;

import br.com.dextra.treinamento.model.service.webservice.TesteWebServiceInterface;

import javax.faces.bean.ManagedBean;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;
import java.net.MalformedURLException;
import java.net.URL;

@ManagedBean(name = "testarWebServiceMB")
public class TestarWebServiceMB {

	private TesteWebServiceInterface obtemWS() throws ServiceException,
			MalformedURLException {
		String wsdlURL = "http://localhost:8080/blog-ejb-1.0-SNAPSHOT/TesteWebServiceImplService/TesteWebServiceImpl?wsdl";
		
		String targetNamespace = TesteWebServiceInterface.TARGET_NAME_SPACE;
		String serviceName = TesteWebServiceInterface.SERVICE_NAME;
		String portName = TesteWebServiceInterface.PORT_NAME;

		QName serviceQN = new QName(targetNamespace, serviceName);

		ServiceFactory serviceFactory = ServiceFactory.newInstance();
		Service service = serviceFactory.createService(new URL(wsdlURL), serviceQN);
		System.out.println("Criou o servico");
		
		TesteWebServiceInterface testeWebService = (TesteWebServiceInterface) service
				.getPort(new QName(targetNamespace, portName),
						TesteWebServiceInterface.class);
		return testeWebService;
	}
	
}
