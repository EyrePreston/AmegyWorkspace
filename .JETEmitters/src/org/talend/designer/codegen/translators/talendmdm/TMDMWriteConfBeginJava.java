package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfBeginJava result = new TMDMWriteConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t\tclass Util_";
  protected final String TEXT_6 = "{" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "\t\t\t\torg.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "\t\t        wsUpdateMetadataItem.setTaskId(taskID);" + NL + "\t\t        wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "\t\t        return wsUpdateMetadataItem;" + NL + "\t\t\t}" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "\t\t\t\tint i = 0;" + NL + "\t\t        for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "\t\t        \twsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "\t\t        \ti++;" + NL + "\t\t        }" + NL + "\t\t        return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tUtil_";
  protected final String TEXT_7 = " util_";
  protected final String TEXT_8 = " = new Util_";
  protected final String TEXT_9 = "();" + NL + "\t";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_12 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_14 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\t\tjava.util.List<String> taskIDs_";
  protected final String TEXT_16 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\torg.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_19 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "\txtentisService_";
  protected final String TEXT_20 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_21 = ");" + NL + "\torg.talend.mdm.webservice.XtentisPort_PortType xtentisWS_";
  protected final String TEXT_22 = " = xtentisService_";
  protected final String TEXT_23 = ".getXtentisPort();    " + NL + "\torg.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_24 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_25 = ";" + NL + "\t" + NL + "\t// Authentification" + NL + "\t";
  protected final String TEXT_26 = NL + "\tstub_";
  protected final String TEXT_27 = ".setUsername(";
  protected final String TEXT_28 = ");" + NL + "\t";
  protected final String TEXT_29 = NL + "\tstub_";
  protected final String TEXT_30 = ".setUsername(";
  protected final String TEXT_31 = " + \"/\" + ";
  protected final String TEXT_32 = ");" + NL + "\t";
  protected final String TEXT_33 = NL + "\t";
  protected final String TEXT_34 = NL + "    ";
  protected final String TEXT_35 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = NL + "\t" + NL + "\tstub_";
  protected final String TEXT_42 = ".setPassword(decryptedPassword_";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\torg.talend.mdm.webservice.XtentisPort_PortType xtentisWS_";
  protected final String TEXT_45 = " = (org.talend.mdm.webservice.XtentisPort_PortType)globalMap.get(\"";
  protected final String TEXT_46 = "\");";
  protected final String TEXT_47 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_48 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_49 = " + \"";
  protected final String TEXT_50 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_51 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_52 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_53 = ";" + NL + "" + NL + "org.talend.mdm.webservice.WSItemPK[] wspks_";
  protected final String TEXT_54 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_55 = ";" + NL;
  protected final String TEXT_56 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_57 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t";
  protected final String TEXT_58 = NL + "\t\tjava.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_59 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<java.util.Map<String,String>>());" + NL + "\t\tint flowNum_";
  protected final String TEXT_60 = " = 0;" + NL + "\t";
  protected final String TEXT_61 = NL + "\tclass ThreadXMLField_";
  protected final String TEXT_62 = " extends Thread {" + NL + "\t\tjava.util.Queue<String> queue;" + NL + "\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\tjava.lang.Exception lastException;" + NL + "\t\tString currentComponent;" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_63 = "(java.util.Queue q) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_64 = "\", queue);" + NL + "\t\t\tlastException = null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_65 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tthis.flows = l;" + NL + "\t\t\tlastException = null;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_66 = "\", queue);" + NL + "\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_67 = "\", flows);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\treturn this.lastException;" + NL + "\t\t}" + NL + "\t\tpublic String getCurrentComponent() {" + NL + "\t\t\treturn this.currentComponent;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_68 = "Process(globalMap);" + NL + "\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_69 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_70 = NL + "\t\tThreadXMLField_";
  protected final String TEXT_71 = " txf_";
  protected final String TEXT_72 = " = new ThreadXMLField_";
  protected final String TEXT_73 = "(queue_";
  protected final String TEXT_74 = ", xmlFlowList_";
  protected final String TEXT_75 = ");" + NL + "\t";
  protected final String TEXT_76 = NL + "\t\tThreadXMLField_";
  protected final String TEXT_77 = " txf_";
  protected final String TEXT_78 = " = new ThreadXMLField_";
  protected final String TEXT_79 = "(queue_";
  protected final String TEXT_80 = ");" + NL + "\t";
  protected final String TEXT_81 = NL + "\ttxf_";
  protected final String TEXT_82 = ".start();";
  protected final String TEXT_83 = NL + "\t\tjava.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_84 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"flows_";
  protected final String TEXT_85 = "\");" + NL + "\t\tint flowNum_";
  protected final String TEXT_86 = " = 0;" + NL + "\t";
  protected final String TEXT_87 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_88 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_89 = "\"); ";
  protected final String TEXT_90 = NL + "\tString readFinishMarkWithPipeId_";
  protected final String TEXT_91 = " = \"";
  protected final String TEXT_92 = "_FINISH\"+(queue_";
  protected final String TEXT_93 = "==null?\"\":queue_";
  protected final String TEXT_94 = ".hashCode());" + NL + "\twhile(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_95 = ") || !queue_";
  protected final String TEXT_96 = ".isEmpty()) { " + NL + "\t\tif (!queue_";
  protected final String TEXT_97 = ".isEmpty()) {";
  protected final String TEXT_98 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String virtualcid = cid;
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}

	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "xtentisWS_" + connection;
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
	String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
	
	boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(!usePartialUpdate){
    stringBuffer.append(TEXT_4);
    if(addTaskID){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    if(isMassInsert){
		if(!isStaging && withReport){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    	}else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
		}
		if(addTaskID){
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    	
		}
	}
}
    stringBuffer.append(TEXT_17);
    if(!useExistingConn){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_28);
    }else{
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }else{
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
	startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){	

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
	if(storeFlow){
	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	}
	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_69);
    if(storeFlow){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }else{
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
}else{
	if(storeFlow){
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
	}
	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_89);
    
}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    return stringBuffer.toString();
  }
}