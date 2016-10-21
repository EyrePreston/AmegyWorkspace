package org.talend.designer.codegen.translators.business_intelligence.tableau;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Calendar;
import java.util.List;

public class TTableauExtractOutputBeginJava
{
  protected static String nl;
  public static synchronized TTableauExtractOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTableauExtractOutputBeginJava result = new TTableauExtractOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + " // TODO: exception handling" + NL + " com.tableausoftware.DataExtract.Extract extract_";
  protected final String TEXT_3 = " = new com.tableausoftware.DataExtract.Extract( ";
  protected final String TEXT_4 = " );" + NL + " com.tableausoftware.DataExtract.TableDefinition tableDef";
  protected final String TEXT_5 = " = new com.tableausoftware.DataExtract.TableDefinition();" + NL + " " + NL + " tableDef";
  protected final String TEXT_6 = ".setDefaultCollation( com.tableausoftware.DataExtract.Collation.";
  protected final String TEXT_7 = " ); " + NL + "  ";
  protected final String TEXT_8 = NL + "\t   tableDef";
  protected final String TEXT_9 = ".addColumn( \"";
  protected final String TEXT_10 = "\",com.tableausoftware.DataExtract.Type.UNICODE_STRING);";
  protected final String TEXT_11 = NL + "\t   tableDef";
  protected final String TEXT_12 = ".addColumn( \"";
  protected final String TEXT_13 = "\",com.tableausoftware.DataExtract.Type.DATETIME);";
  protected final String TEXT_14 = NL + "\t   tableDef";
  protected final String TEXT_15 = ".addColumn( \"";
  protected final String TEXT_16 = "\",com.tableausoftware.DataExtract.Type.INTEGER);";
  protected final String TEXT_17 = NL + "\t   tableDef";
  protected final String TEXT_18 = ".addColumn( \"";
  protected final String TEXT_19 = "\",com.tableausoftware.DataExtract.Type.DOUBLE);" + NL;
  protected final String TEXT_20 = NL + "       System.out.println( \"Unknown type:  ";
  protected final String TEXT_21 = " \");" + NL + "\t   tableDef";
  protected final String TEXT_22 = ".addColumn( \"";
  protected final String TEXT_23 = "\",com.tableausoftware.DataExtract.Type.UNICODE_STRING);";
  protected final String TEXT_24 = NL + NL + "com.tableausoftware.DataExtract.Table table";
  protected final String TEXT_25 = " = extract_";
  protected final String TEXT_26 = ".addTable(\"Extract\", tableDef";
  protected final String TEXT_27 = ");" + NL + "            " + NL + "com.tableausoftware.DataExtract.Row row";
  protected final String TEXT_28 = " = new com.tableausoftware.DataExtract.Row(tableDef";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String outputFile = ElementParameterParser.getValue(node, "__OUTPUTFILE__");
String defCollation = ElementParameterParser.getValue(node, "__COLLATION__");
String tableName = ElementParameterParser.getValue(node, "__TABLE_NAME__");


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
    stringBuffer.append( defCollation );
    stringBuffer.append(TEXT_7);
    
  IMetadataTable preMetadata = null;
  if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0))
  preMetadata = node.getIncomingConnections().get(0).getMetadataTable();
  List<IMetadataColumn> columns = preMetadata.getListColumns();
  for (int i = 0; i < columns.size(); i++) 
  {
   IMetadataColumn column = columns.get(i);
   JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

   if ( javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( column.getLabel());
    stringBuffer.append(TEXT_10);
       } else if ( javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( column.getLabel());
    stringBuffer.append(TEXT_13);
    
   } else if ( javaType == JavaTypesManager.INTEGER) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( column.getLabel());
    stringBuffer.append(TEXT_16);
    
   } else if ( javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( column.getLabel());
    stringBuffer.append(TEXT_19);
     } else {  
    stringBuffer.append(TEXT_20);
    stringBuffer.append( javaType.toString() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( column.getLabel());
    stringBuffer.append(TEXT_23);
    
   } // if javatype

  }

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
