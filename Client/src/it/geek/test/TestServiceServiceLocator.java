/**
 * TestServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.geek.test;

public class TestServiceServiceLocator extends org.apache.axis.client.Service implements it.geek.test.TestServiceService {

    public TestServiceServiceLocator() {
    }


    public TestServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TestServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TestService
    private java.lang.String TestService_address = "http://localhost:8080/WebService/services/TestService";

    public java.lang.String getTestServiceAddress() {
        return TestService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TestServiceWSDDServiceName = "TestService";

    public java.lang.String getTestServiceWSDDServiceName() {
        return TestServiceWSDDServiceName;
    }

    public void setTestServiceWSDDServiceName(java.lang.String name) {
        TestServiceWSDDServiceName = name;
    }

    public it.geek.test.TestService getTestService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TestService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTestService(endpoint);
    }

    public it.geek.test.TestService getTestService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.geek.test.TestServiceSoapBindingStub _stub = new it.geek.test.TestServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTestServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTestServiceEndpointAddress(java.lang.String address) {
        TestService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.geek.test.TestService.class.isAssignableFrom(serviceEndpointInterface)) {
                it.geek.test.TestServiceSoapBindingStub _stub = new it.geek.test.TestServiceSoapBindingStub(new java.net.URL(TestService_address), this);
                _stub.setPortName(getTestServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TestService".equals(inputPortName)) {
            return getTestService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://test.geek.it", "TestServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://test.geek.it", "TestService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TestService".equals(portName)) {
            setTestServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
