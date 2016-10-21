package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMomRollbackMainJava
{
  protected static String nl;
  public static synchronized TMomRollbackMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomRollbackMainJava result = new TMomRollbackMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_4 = " = (javax.jms.Session)globalMap.get(\"session_";
  protected final String TEXT_5 = "\");" + NL + "\t\tjavax.jms.Connection connection_";
  protected final String TEXT_6 = " = (javax.jms.Connection)globalMap.get(\"connection_";
  protected final String TEXT_7 = "\");" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_8 = " = (javax.jms.MessageProducer)globalMap.get(\"producer_";
  protected final String TEXT_9 = "\");" + NL + "\t\tif(session_";
  protected final String TEXT_10 = " != null && connection_";
  protected final String TEXT_11 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Rollback operations...\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\tsession_";
  protected final String TEXT_15 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_17 = " - Rollback successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tif (producer_";
  protected final String TEXT_19 = " != null) { " + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Closing producer...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tproducer_";
  protected final String TEXT_23 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Closed successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = " " + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t        session_";
  protected final String TEXT_30 = ".close();" + NL + "\t\t        connection_";
  protected final String TEXT_31 = ".close();" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_36 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_37 = "\");" + NL + "\t    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_38 = " = (com.ibm.mq.MQQueue)globalMap.get(\"remoteQ_";
  protected final String TEXT_39 = "\");" + NL + "\t\tif(qMgr_";
  protected final String TEXT_40 = " != null && remoteQ_";
  protected final String TEXT_41 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_43 = " - Backouting operations...\");" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\tqMgr_";
  protected final String TEXT_45 = ".backout();" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_47 = " - Backout successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_49 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tremoteQ_";
  protected final String TEXT_51 = ".close();" + NL + "\t\t\t    qMgr_";
  protected final String TEXT_52 = ".disconnect();;" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connectionCid = ElementParameterParser.getValue(node,"__CONNECTION__");
    
    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));

	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
      
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
			if(close){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
			    	if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
					}
					
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
					}
					
    stringBuffer.append(TEXT_26);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
     
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}
			}
			
    stringBuffer.append(TEXT_34);
    
	} else {
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
			}
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
      
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			}
			if(close){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				}
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
     
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
				}
			}
			
    stringBuffer.append(TEXT_55);
    
	}
	
    return stringBuffer.toString();
  }
}
