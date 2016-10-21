package org.talend.designer.codegen.translators.tutorial;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExcelToCSVBeginJava
{
  protected static String nl;
  public static synchronized TExcelToCSVBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExcelToCSVBeginJava result = new TExcelToCSVBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "  int nb_line_";
  protected final String TEXT_2 = " =0;" + NL + "  java.io.FileWriter fw_";
  protected final String TEXT_3 = " = new java.io.FileWriter( ";
  protected final String TEXT_4 = " );" + NL + "  java.io.PrintWriter pw_";
  protected final String TEXT_5 = " = new java.io.PrintWriter(fw_";
  protected final String TEXT_6 = " );" + NL + "  " + NL + "  pw_";
  protected final String TEXT_7 = ".println(\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>); //default xml header" + NL + "  pw_";
  protected final String TEXT_8 = ".println(\"<TABLE>\"); //root element" + NL + "  pw_";
  protected final String TEXT_9 = ".println(\"<METADATA>\");";
  protected final String TEXT_10 = NL + "  pw_";
  protected final String TEXT_11 = ".println(\"</METADATA>\");" + NL + "  pw_";
  protected final String TEXT_12 = ".println(\"<DATA>\");";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String filename = ElementParameterParser.getValue(node, "__INPUTFILE__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputFile );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	IMetadataTable preMetadata = null;
	if((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0))
		preMetadata = node.getIncomingConnections().get(0).getMetadataTable();
	List<IMetadataColumn> columns = preMetadata.getListColumns();
	for(int i =0; i<columns.size(); i++)
	{
	IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
