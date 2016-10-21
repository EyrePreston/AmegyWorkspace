package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMomMessageIdListBeginJava
{
  protected static String nl;
  public static synchronized TMomMessageIdListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomMessageIdListBeginJava result = new TMomMessageIdListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t\tclass HelloInput implements javax.jms.MessageListener {" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_5 = "Connection connection";
  protected final String TEXT_6 = ";" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_7 = "Session session";
  protected final String TEXT_8 = ";" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_9 = " topic";
  protected final String TEXT_10 = ";" + NL + "\t\t\tjava.util.Queue<String> msgQueue";
  protected final String TEXT_11 = "=null;\t" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tprivate static org.apache.log4j.Logger log = null;" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\tpublic HelloInput(String factoryJNDI, String topicJNDI) throws javax.jms.JMSException, javax.naming.NamingException{" + NL + "\t\t\t\tmsgQueue";
  protected final String TEXT_14 = "=new java.util.LinkedList<String>();" + NL + "\t\t\t\tjava.util.Hashtable props";
  protected final String TEXT_15 = "=new java.util.Hashtable();" + NL + "\t\t\t\tprops";
  protected final String TEXT_16 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_17 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_18 = "+\":\"+";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\tprops";
  protected final String TEXT_20 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_21 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_22 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t\tjavax.naming.Context context";
  protected final String TEXT_23 = "=new javax.naming.InitialContext(props";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\tjavax.jms.";
  protected final String TEXT_25 = "ConnectionFactory factory";
  protected final String TEXT_26 = "=(javax.jms.";
  protected final String TEXT_27 = "ConnectionFactory)context";
  protected final String TEXT_28 = ".lookup(factoryJNDI);" + NL + "\t\t\t\t";
  protected final String TEXT_29 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Attempt to create ";
  protected final String TEXT_31 = " connection...;" + NL + "\t\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "\t\t\t\tconnection";
  protected final String TEXT_33 = "=factory";
  protected final String TEXT_34 = ".create";
  protected final String TEXT_35 = "Connection();" + NL + "\t\t\t\t";
  protected final String TEXT_36 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Created successfully.\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_38 = " - Creating a ";
  protected final String TEXT_39 = " session...\");" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\tsession";
  protected final String TEXT_41 = "=connection";
  protected final String TEXT_42 = ".create";
  protected final String TEXT_43 = "Session(false, javax.jms.Session.AUTO_ACKNOWLEDGE);" + NL + "\t\t\t\t";
  protected final String TEXT_44 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_45 = " - Created successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\ttopic";
  protected final String TEXT_47 = "=(javax.jms.";
  protected final String TEXT_48 = ")context";
  protected final String TEXT_49 = ".lookup(topicJNDI);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tjavax.jms.";
  protected final String TEXT_51 = "Receiver receiver";
  protected final String TEXT_52 = "=session";
  protected final String TEXT_53 = ".createReceiver(topic";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t\treceiver";
  protected final String TEXT_55 = ".setMessageListener(this);" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\tjavax.jms.";
  protected final String TEXT_57 = "Subscriber subscriber";
  protected final String TEXT_58 = "=session";
  protected final String TEXT_59 = ".createSubscriber(topic";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\t\tsubscriber";
  protected final String TEXT_61 = ".setMessageListener(this);" + NL + "\t\t\t\t";
  protected final String TEXT_62 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_63 = " - Activating the connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tconnection";
  protected final String TEXT_65 = ".start();" + NL + "\t\t\t    ";
  protected final String TEXT_66 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_67 = " - Activated successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tpublic void onMessage(javax.jms.Message m){" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tString msg";
  protected final String TEXT_69 = "=((javax.jms.TextMessage)m).getText();" + NL + "\t\t\t\t\tmsgQueue";
  protected final String TEXT_70 = ".add(msg";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t} catch (javax.jms.JMSException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = "\t" + NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_73 = " - Could not get text message:\" + e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tSystem.err.println(\"Could not get text message:\" + e);" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic void close() throws javax.jms.JMSException{" + NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_76 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tsession";
  protected final String TEXT_78 = ".close();" + NL + "\t\t\t\tconnection";
  protected final String TEXT_79 = ".close();" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_81 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t}\t" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\tpublic void setLog(org.apache.log4j.Logger log){" + NL + "\t\t\t\t\tthis.log=log;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\tHelloInput input";
  protected final String TEXT_85 = "=null;" + NL + "\t\ttry {" + NL + "\t\t//begin part" + NL + "\t\t\tinput";
  protected final String TEXT_86 = "=new HelloInput(\"";
  protected final String TEXT_87 = "TopicConnectionFactory";
  protected final String TEXT_88 = "ConnectionFactory";
  protected final String TEXT_89 = "\",";
  protected final String TEXT_90 = ");\t\t\t" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_91 = "\t" + NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_92 = " - An exception occurred while testing HelloSubscriber:\" + e);" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\tSystem.err.println(\"An exception occurred while testing HelloSubscriber:\" + e);" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_94 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Ready to receive message.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_96 = " - Waiting...\");" + NL + "\t\t";
  protected final String TEXT_97 = "\t" + NL + "\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t" + NL + "\t\tBoolean flag";
  protected final String TEXT_98 = "=true;" + NL + "\t\twhile(flag";
  protected final String TEXT_99 = "){" + NL + "\t\t\twhile(!(input";
  protected final String TEXT_100 = ".msgQueue";
  protected final String TEXT_101 = ".size()==0)){" + NL + "\t\t\t\tString msg";
  protected final String TEXT_102 = "=(String)input";
  protected final String TEXT_103 = ".msgQueue";
  protected final String TEXT_104 = ".poll();" + NL + "\t";
  protected final String TEXT_105 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = ".from=";
  protected final String TEXT_107 = ";\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_108 = ".message=msg";
  protected final String TEXT_109 = ";\t" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\tjava.util.List<String> idList_";
  protected final String TEXT_111 = " = new java.util.ArrayList<String>();" + NL + "\t" + NL + "\t\tjava.util.Hashtable properties_";
  protected final String TEXT_112 = "=new java.util.Hashtable();" + NL + "\t\tproperties_";
  protected final String TEXT_113 = ".put(\"hostname\", ";
  protected final String TEXT_114 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_115 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_116 = "));" + NL + "\t\tproperties_";
  protected final String TEXT_117 = ".put(\"channel\", ";
  protected final String TEXT_118 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_119 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\tproperties_";
  protected final String TEXT_120 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t" + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_121 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_122 = "=null;" + NL + "\t\ttry{" + NL + "\t\t\tint openOptions_";
  protected final String TEXT_123 = "=com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INPUT_AS_Q_DEF;" + NL + "\t" + NL + "\t    \tcom.ibm.mq.MQGetMessageOptions gmo_";
  protected final String TEXT_124 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t    \tgmo_";
  protected final String TEXT_125 = ".options=gmo_";
  protected final String TEXT_126 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t    \tgmo_";
  protected final String TEXT_127 = ".options=gmo_";
  protected final String TEXT_128 = ".options+com.ibm.mq.MQC.MQGMO_NO_WAIT;" + NL + "\t    \tgmo_";
  protected final String TEXT_129 = ".options=gmo_";
  protected final String TEXT_130 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t    \tgmo_";
  protected final String TEXT_131 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t    \tcom.ibm.mq.MQException.log = null;" + NL + "\t    \tboolean flag_";
  protected final String TEXT_132 = "=true;" + NL + "\t\t\t";
  protected final String TEXT_133 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_134 = " - Ready to receive message.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_135 = " - Waiting...\");" + NL + "\t\t\t";
  protected final String TEXT_136 = "\t" + NL + "\t    \tqMgr_";
  protected final String TEXT_137 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_138 = ",properties_";
  protected final String TEXT_139 = ");" + NL + "\t    \twhile(flag_";
  protected final String TEXT_140 = "){" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_141 = "=qMgr_";
  protected final String TEXT_142 = ".accessQueue(";
  protected final String TEXT_143 = ",openOptions_";
  protected final String TEXT_144 = ");" + NL + "\t    \t\tcom.ibm.mq.MQMessage inMessage_";
  protected final String TEXT_145 = "=new com.ibm.mq.MQMessage();" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_146 = ".get(inMessage_";
  protected final String TEXT_147 = ",gmo_";
  protected final String TEXT_148 = ");" + NL + "\t    \t\tidList_";
  protected final String TEXT_149 = ".add(new String(inMessage_";
  protected final String TEXT_150 = ".messageId,\"ISO-8859-15\"));" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_151 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}catch(com.ibm.mq.MQException me_";
  protected final String TEXT_152 = "){" + NL + "\t\t\tif (me_";
  protected final String TEXT_153 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_155 = " - Disconnecting connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_156 = NL + "\t        \tremoteQ_";
  protected final String TEXT_157 = ".close();" + NL + "\t        \tqMgr_";
  protected final String TEXT_158 = ".backout();" + NL + "\t            qMgr_";
  protected final String TEXT_159 = ".disconnect();" + NL + "\t            ";
  protected final String TEXT_160 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_161 = " - Disconnected successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_162 = NL + "\t        }else{" + NL + "\t        \tthrow me_";
  protected final String TEXT_163 = ";" + NL + "\t        }" + NL + "\t\t}" + NL + "\t" + NL + "\t\tfor(String tmpId_";
  protected final String TEXT_164 = " : idList_";
  protected final String TEXT_165 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_166 = " ++;" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_168 = " - Retrieving the record: \" + nb_line_";
  protected final String TEXT_169 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_171 = "_CURRENT_MESSAGE_ID\", tmpId_";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(("JBoss").equals(serverType)){ // server judgement
		String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
		String from=ElementParameterParser.getValue(node, "__FROM__");


    stringBuffer.append(TEXT_4);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    
			}
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_31);
    
				}
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_35);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_39);
    
				}
				
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_43);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
				}
				
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    	
				if(("Queue").equals(msgType)){
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
				}else{
				
    stringBuffer.append(TEXT_56);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
				}
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
				}
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
				}
				
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
					}
					
    stringBuffer.append(TEXT_74);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
				}
				
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    	
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
				}
	            
    stringBuffer.append(TEXT_82);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_83);
    
			}
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if(("Topic").equals(msgType)){
    stringBuffer.append(TEXT_87);
    }else{
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_90);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
			}
			
    stringBuffer.append(TEXT_93);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
		}
		
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
				List<IMetadataColumn> columnList = metadata.getListColumns();
				for(IConnection conn:conns){
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
				 		String firstConnName = conn.getName();

    stringBuffer.append(TEXT_105);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
					}
				}
	}  //server judgement   /***WebSphere MQ*****/
	else{
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		String idMask = ElementParameterParser.getValue(node, "__IDMASK__");

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
			}
			
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
				}
				
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
				}
	            
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
			}
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	}

    stringBuffer.append(TEXT_173);
    return stringBuffer.toString();
  }
}
