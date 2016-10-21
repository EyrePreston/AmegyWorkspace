package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TSshTunnelBeginJava
{
  protected static String nl;
  public static synchronized TSshTunnelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSshTunnelBeginJava result = new TSshTunnelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "" + NL + "\tjava.util.Hashtable<String,com.jcraft.jsch.Session> tunnels_";
  protected final String TEXT_3 = " = new java.util.Hashtable<String,com.jcraft.jsch.Session>();";
  protected final String TEXT_4 = NL + "\tboolean useKey_";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "=false;" + NL + "\tif (!";
  protected final String TEXT_7 = ".equals(\"\"))" + NL + "\t\tuseKey_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = "=true;" + NL + "\t\t" + NL + "\tif (!tunnels_";
  protected final String TEXT_10 = ".containsKey(";
  protected final String TEXT_11 = "+\"@\"+";
  protected final String TEXT_12 = "+\":\"+";
  protected final String TEXT_13 = ")) {" + NL + "\t\tcom.jcraft.jsch.JSch j=new com.jcraft.jsch.JSch();" + NL + "\t\tif(useKey_";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = ")" + NL + "\t\t\tj.addIdentity(";
  protected final String TEXT_16 = ");" + NL + "\t\tcom.jcraft.jsch.Session session=j.getSession(";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = ",Integer.parseInt(";
  protected final String TEXT_19 = "));" + NL + "\t\tjava.util.Hashtable<String, String> config = new java.util.Hashtable<String, String>();" + NL + "\t\tconfig.put(\"StrictHostKeyChecking\", \"no\");" + NL + "\t\tsession.setConfig(config);" + NL + "\t\tif (!useKey_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ") {" + NL + "\t\t\tsession.setPassword(";
  protected final String TEXT_22 = ");" + NL + "\t\t}" + NL + "\t\tsession.connect();" + NL + "\t\tString[] credentials = ";
  protected final String TEXT_23 = ".split(\":\");" + NL + "\t\tsession.setPortForwardingL(Integer.parseInt(credentials[0]), credentials[1], Integer.parseInt(credentials[2]));" + NL + "\t\ttunnels_";
  protected final String TEXT_24 = ".put(";
  protected final String TEXT_25 = "+\"@\"+";
  protected final String TEXT_26 = "+\":\"+";
  protected final String TEXT_27 = ",session);" + NL + "\t\t" + NL + "\t} else {" + NL + "\t\tcom.jcraft.jsch.Session session = tunnels_";
  protected final String TEXT_28 = ".get(";
  protected final String TEXT_29 = "+\"@\"+";
  protected final String TEXT_30 = "+\":\"+";
  protected final String TEXT_31 = ");" + NL + "\t\tString[] credentials = ";
  protected final String TEXT_32 = ".split(\":\");" + NL + "\t\tsession.setPortForwardingL(Integer.parseInt(credentials[0]), credentials[1], Integer.parseInt(credentials[2]));" + NL + "\t}" + NL + "\tglobalMap.put(\"tunnels_";
  protected final String TEXT_33 = "\",tunnels_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List<Map<String, String>> lines = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__TUNNELS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
  for (int i=0; i<lines.size(); i++) {
    Map<String, String> line = lines.get(i);
    

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(line.get("KEYFILE"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(line.get("USERNAME"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(line.get("HOST"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(line.get("PORT"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(line.get("KEYFILE"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(line.get("USERNAME"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(line.get("HOST"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(line.get("PORT"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(line.get("PASSWORD"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(line.get("L_TUNNEL_STRING"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(line.get("USERNAME"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(line.get("HOST"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(line.get("PORT"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(line.get("USERNAME"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(line.get("HOST"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(line.get("PORT"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(line.get("L_TUNNEL_STRING"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
  }

    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
