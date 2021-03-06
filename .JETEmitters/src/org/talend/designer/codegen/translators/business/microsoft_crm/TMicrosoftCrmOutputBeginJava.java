package org.talend.designer.codegen.translators.business.microsoft_crm;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputBeginJava result = new TMicrosoftCrmOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tint nb_line_";
  protected final String TEXT_2 = " = 0;\t" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + NL + "\t\t\t";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\torg.apache.commons.httpclient.auth.AuthPolicy.registerAuthScheme(org.apache.commons.httpclient.auth.AuthPolicy.NTLM, org.talend.mscrm.login.ntlm.JCIFS_NTLMScheme.class);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_14 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_16 = " = service_";
  protected final String TEXT_17 = "._getServiceClient().getOptions();" + NL + "\t\t\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_18 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tList<String> authSchemes_";
  protected final String TEXT_19 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\tauthSchemes_";
  protected final String TEXT_20 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\t\t\tauth_";
  protected final String TEXT_21 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t            auth_";
  protected final String TEXT_23 = " .setUsername(";
  protected final String TEXT_24 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_25 = " .setPassword(decryptedPassword_";
  protected final String TEXT_26 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_27 = " .setHost(";
  protected final String TEXT_28 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_29 = " .setPort(";
  protected final String TEXT_30 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_31 = " .setDomain(";
  protected final String TEXT_32 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_33 = " .setPreemptiveAuthentication(false);" + NL + "\t\t            " + NL + "\t\t            options_";
  protected final String TEXT_34 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_35 = ");" + NL + "\t\t            options_";
  protected final String TEXT_36 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_37 = "\");" + NL + "\t\t            " + NL + "\t\t            options_";
  protected final String TEXT_38 = " .setUserName(";
  protected final String TEXT_39 = ");" + NL + "\t\t            options_";
  protected final String TEXT_40 = " .setPassword(decryptedPassword_";
  protected final String TEXT_41 = ");" + NL + "\t\t            options_";
  protected final String TEXT_42 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_43 = "));" + NL + "\t\t            " + NL + "\t\t            options_";
  protected final String TEXT_44 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_45 = "));" + NL + "\t\t            options_";
  protected final String TEXT_46 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_47 = "));" + NL + "\t\t            " + NL + "\t\t            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_48 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_49 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_50 = ".setAuthenticationType(0);" + NL + "\t\t            token_";
  protected final String TEXT_51 = ".setOrganizationName(";
  protected final String TEXT_52 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_53 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_54 = ");" + NL + "\t\t        ";
  protected final String TEXT_55 = NL + "\t\t        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_56 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_57 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_58 = " = service_";
  protected final String TEXT_59 = "._getServiceClient().getOptions();" + NL + "\t\t        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_60 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ",decryptedPassword_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_65 = ".connect();" + NL + "\t\t\t\t\tString crmTicket_";
  protected final String TEXT_66 = " = msDynamicsWrapper_";
  protected final String TEXT_67 = ".getCrmTicket();" + NL + "\t\t        \t" + NL + "\t\t        \toptions_";
  protected final String TEXT_68 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_69 = "\");" + NL + "\t\t        \toptions_";
  protected final String TEXT_70 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_71 = "));" + NL + "\t\t            " + NL + "\t\t            options_";
  protected final String TEXT_72 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_73 = "));" + NL + "\t\t            options_";
  protected final String TEXT_74 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_75 = "));" + NL + "\t\t        \t" + NL + "\t\t        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_76 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_77 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_78 = ".setAuthenticationType(1);" + NL + "\t\t            token_";
  protected final String TEXT_79 = ".setOrganizationName(";
  protected final String TEXT_80 = ");" + NL + "\t\t            token_";
  protected final String TEXT_81 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_82 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_83 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_84 = ");" + NL + "\t        \t";
  protected final String TEXT_85 = NL + "\t        \torg.talend.ms.crm.MSCRMClient client_";
  protected final String TEXT_86 = " = new org.talend.ms.crm.MSCRMClient(";
  protected final String TEXT_87 = ", decryptedPassword_";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_90 = ".setTimeout(";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_92 = ".setReuseHttpClient(";
  protected final String TEXT_93 = ");" + NL + "\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationServiceStub serviceStub_";
  protected final String TEXT_94 = " = client_";
  protected final String TEXT_95 = ".getOnlineConnection(";
  protected final String TEXT_96 = ");" + NL + "\t        ";
  protected final String TEXT_97 = NL + "            " + NL + "     \t" + NL + "" + NL + "  \t\t" + NL + "        \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

			String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
			String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
			String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");

			String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
			String host = ElementParameterParser.getValue(node, "__HOST__");
			String port = ElementParameterParser.getValue(node, "__PORT__");
			String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
			String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
			int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
			boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
			boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));
			boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
			String discWSDL = ElementParameterParser.getValue(node, "__DISC_WSDL__");
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    if(debug){
    stringBuffer.append(TEXT_3);
    }else{
    stringBuffer.append(TEXT_4);
    }
			
			String passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_5);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    
			if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
				if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
	        }else{
	        
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(discWSDL);
    stringBuffer.append(TEXT_96);
    
	        }
    stringBuffer.append(TEXT_97);
    return stringBuffer.toString();
  }
}
