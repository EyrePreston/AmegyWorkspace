package org.talend.designer.codegen.translators.tutorial;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TExcelToCSVMainJava
{
  protected static String nl;
  public static synchronized TExcelToCSVMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExcelToCSVMainJava result = new TExcelToCSVMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  java.util.StringTokenizer st_";
  protected final String TEXT_2 = " = new java.util.StringTokenizer(inBuffer_";
  protected final String TEXT_3 = ",\",\"); // here";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = st_";
  protected final String TEXT_7 = ".nextToken(); // and here" + NL;
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {//b
 IMetadataTable metadata = metadatas.get(0);
 if (metadata != null) {//a
  List<IMetadataColumn> columns = metadata.getListColumns();	
  List< ? extends IConnection> outConns = node.getOutgoingConnections();
  for (IConnection conn : outConns) 
  { //2	
   if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)||conn.getLineStyle().equals(EConnectionType.FLOW_MERGE))
   { //3
    String outputConnName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
     
    for (int i = 0; i < columns.size(); i++) 
    {//4
     IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
     
    }//4
   }//3
  }//2
 }//a
}//b

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
