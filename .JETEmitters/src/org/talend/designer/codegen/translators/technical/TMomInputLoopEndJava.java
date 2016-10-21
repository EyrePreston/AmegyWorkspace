package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomInputLoopEndJava
{
  protected static String nl;
  public static synchronized TMomInputLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopEndJava result = new TMomInputLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tmessage_";
  protected final String TEXT_3 = ".acknowledge();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Sleepping time(";
  protected final String TEXT_7 = "s)...\");" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tThread.sleep(";
  protected final String TEXT_9 = "*1000);" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\tif (session_";
  protected final String TEXT_13 = " != null && connection_";
  protected final String TEXT_14 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Committing the session...\");" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tsession_";
  protected final String TEXT_18 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Commit successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t}" + NL + "\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_23 = " - A Active MQ error occurred :\" + ex);" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\tSystem.out.println(\"A Active MQ error occurred :\" + ex);" + NL + "\t      \tex.printStackTrace();" + NL + "\t\t\tif (session_";
  protected final String TEXT_25 = " != null  && connection_";
  protected final String TEXT_26 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Rollback operations...\");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tsession_";
  protected final String TEXT_30 = ".rollback();" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Rollback successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_34 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + " \t\t \tif (session_";
  protected final String TEXT_39 = " != null  && connection_";
  protected final String TEXT_40 = " != null) {" + NL + " \t\t \t\tsession_";
  protected final String TEXT_41 = ".close();" + NL + " \t\t \t}" + NL + "            if (connection_";
  protected final String TEXT_42 = " != null) {" + NL + "            \tconnection_";
  protected final String TEXT_43 = ".close();" + NL + "            }";
  protected final String TEXT_44 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_45 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = NL + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_50 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + " \t\t\tSystem.out.println(\"Closing connection\");" + NL + "            consumer_";
  protected final String TEXT_52 = ".close();" + NL + "            session_";
  protected final String TEXT_53 = ".close();" + NL + "            connection_";
  protected final String TEXT_54 = ".close();";
  protected final String TEXT_55 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t";
  protected final String TEXT_58 = NL + NL + "\t";
  protected final String TEXT_59 = NL + "\t\t" + NL + "\t\t\t}\t" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_61 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\t\tremoteQ";
  protected final String TEXT_63 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tqMgr";
  protected final String TEXT_65 = ".backout();" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\tqMgr";
  protected final String TEXT_67 = ".disconnect();" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_69 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "\t\t}catch(com.ibm.mq.MQException ex){" + NL + "\t\t\tSystem.out.println(\"A WebSphere MQ error occurred : Completion code \" + ex.completionCode + \" Reason code \" + ex.reasonCode);" + NL + "\t\t\tremoteQ";
  protected final String TEXT_71 = ".close();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_72 = NL + NL + "} finally {" + NL + "//        System.out.println(\"close connection after loop!\");" + NL + "\t";
  protected final String TEXT_73 = NL + "\t\t";
  protected final String TEXT_74 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_75 = " - Closing connection after loop...\");" + NL + "\t\t";
  protected final String TEXT_76 = NL + "         if (connection_";
  protected final String TEXT_77 = " != null) {" + NL + "         \tconnection_";
  protected final String TEXT_78 = ".close();" + NL + "         }";
  protected final String TEXT_79 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_80 = " - Closed successfully\");" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t";
  protected final String TEXT_82 = NL + "}";
  protected final String TEXT_83 = NL + "\tlog.info(\"";
  protected final String TEXT_84 = " - Consumed messages count: \"+ nb_line_";
  protected final String TEXT_85 = " + \" .\");";
  protected final String TEXT_86 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_87 = "_NB_LINE\",nb_line_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));	
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

    boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
		|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 

        if (isUseConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
			}	
		}


	}
	
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType) || isUseConnection) {
		if ("CLIENT_ACKNOWLEDGE".equals(acknowledgmentMode)) {
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_4);
    
		}
		if(("JBoss").equals(serverType)){
			if("true".equals(kListen)){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_7);
    
				}
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_9);
    		
			}else{
			
    stringBuffer.append(TEXT_10);
    			
			}
		}else if(("ActiveMQ").equals(serverType) || isUseConnection) {
			if (("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"))) {
			
    stringBuffer.append(TEXT_11);
    
			}
		}
               if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
				}
				
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				}
				
    stringBuffer.append(TEXT_21);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			}
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
				}
				
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    if( ("ActiveMQ").equals(serverType) && !isCommitRollback && !isUseConnection){
    stringBuffer.append(TEXT_35);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			}
			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			}
            
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    if( ("JBoss").equals(serverType) ){
    stringBuffer.append(TEXT_48);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			}
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			}
            
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    		
	}else{
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		
    stringBuffer.append(TEXT_59);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
			}
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
			if(isRollback){
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
			}
			
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
			}
            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	}
	
    stringBuffer.append(TEXT_72);
    if( ("ActiveMQ").equals(serverType) && !isUseConnection){
    stringBuffer.append(TEXT_73);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		}
		
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		}
		
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    return stringBuffer.toString();
  }
}
