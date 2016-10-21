package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TStewardshipTaskOutputBeginJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputBeginJava result = new TStewardshipTaskOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\tString taskFlag_";
  protected final String TEXT_3 = "=\"\";" + NL + "\t\t\t\t\tint nb_line_";
  protected final String TEXT_4 = " = 0;\t" + NL + "\t\t\t\t\torg.talend.stewardship.TaskGenerator tasks_";
  protected final String TEXT_5 = " = new org.talend.stewardship.TaskGenerator();" + NL + "\t\t\t\t\torg.talend.stewardship.Task task_";
  protected final String TEXT_6 = " = null;" + NL + "\t\t\t\t\tint port_";
  protected final String TEXT_7 = " =  ";
  protected final String TEXT_8 = ";" + NL + "\t\t\t\t\tString url_";
  protected final String TEXT_9 = " = org.talend.datastewardship.server.task.creation.TaskLoadClientTools.getUrl(";
  protected final String TEXT_10 = ",String.valueOf(port_";
  protected final String TEXT_11 = "));" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "\t\t\t\t\t";
  protected final String TEXT_20 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Attempt to get a task load client from: \" + url_";
  protected final String TEXT_22 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\torg.talend.datastewardship.server.task.creation.TaskLoadClient taskLoadClient_";
  protected final String TEXT_24 = " = new org.talend.datastewardship.server.task.creation.TaskLoadClient(url_";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = ",decryptedPassword_";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\ttaskLoadClient_";
  protected final String TEXT_28 = ".validate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Got successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\torg.talend.stewardship.Record record_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t\t\t\tboolean targetRecordExisted_";
  protected final String TEXT_33 = " = false;" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t    \tString recordColumn_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t\t\t    \tString recordColumn_";
  protected final String TEXT_37 = "_Value_";
  protected final String TEXT_38 = " = null;" + NL + "\t\t\t\t\t    \tString recordColumn_";
  protected final String TEXT_39 = "_Type_";
  protected final String TEXT_40 = " = null;" + NL + "\t\t\t\t\t    \tString recordColumn_";
  protected final String TEXT_41 = "_Key_";
  protected final String TEXT_42 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Start to upload task records to server.\");" + NL + "\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    String host = ElementParameterParser.getValue(node, "__HOST__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String username = ElementParameterParser.getValue(node, "__USERNAME__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	
	    	List< ? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
	    			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
					
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
					String passwordFieldName = "__PASSWORD__";
					
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
					}
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
					}
					
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    //For TDI-26345
					if(recordColumns.size()>0){
						for(Map<String, String> recordColumn:recordColumns){
					
    stringBuffer.append(TEXT_34);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
						}
					}
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
					}
				}
			}
		}	
	}
	
    return stringBuffer.toString();
  }
}
