package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Committing the session...\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\tsession_";
  protected final String TEXT_5 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Commit successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Closing producer...\");" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\tproducer_";
  protected final String TEXT_11 = ".close();" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Closed successfully.\");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_16 = " // if no commmit or rollback component exists - close session" + NL + " \t\t\tSystem.out.println(\"Closing connection\");" + NL + "            session_";
  protected final String TEXT_17 = ".close();" + NL + "            connection_";
  protected final String TEXT_18 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_22 = "\", true); " + NL + "\t";
  protected final String TEXT_23 = NL + "\t\tglobalMap.put(\"remoteQ_";
  protected final String TEXT_24 = "\",remoteQ_";
  protected final String TEXT_25 = ");" + NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_26 = "\",qMgr_";
  protected final String TEXT_27 = ");" + NL + "\t";
  protected final String TEXT_28 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Disconnecting connection...\");" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\tremoteQ_";
  protected final String TEXT_31 = ".close();" + NL + "\t\tqMgr_";
  protected final String TEXT_32 = ".disconnect();" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Disconnected successfully.\");" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\tlog.info(\"";
  protected final String TEXT_36 = " - Written records count: \"+ nb_line_";
  protected final String TEXT_37 = " + \" .\");";
  protected final String TEXT_38 = NL + NL + "    globalMap.put(\"";
  protected final String TEXT_39 = "_NB_LINE\",nb_line_";
  protected final String TEXT_40 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 

if (isUseSharedConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType) || isUseSharedConnection){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	if( ("JBoss").equals(serverType) || ( ("ActiveMQ").equals(serverType)) ){
		// if no commmit or rollback component exists and set transacted - commit session
		if(!isCommitRollback && transacted){
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
		}
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		}
        if (!isCommitRollback && !isUseSharedConnection) {
        	if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			}
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
			}
		}
	}
	if((("ActiveMQ").equals(serverType) || isUseSharedConnection) && !isCommitRollback && transacted){
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	}
}else{//server judgement   /***WebSphere MQ*****/
	if (transacted) {
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	} else {
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
		}
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
		}
	}
}
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
