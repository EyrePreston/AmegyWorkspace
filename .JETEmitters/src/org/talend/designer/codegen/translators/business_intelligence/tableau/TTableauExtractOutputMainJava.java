package org.talend.designer.codegen.translators.business_intelligence.tableau;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TTableauExtractOutputMainJava
{
  protected static String nl;
  public static synchronized TTableauExtractOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTableauExtractOutputMainJava result = new TTableauExtractOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "" + NL + "java.util.Calendar cal_";
  protected final String TEXT_2 = " = java.util.Calendar.getInstance();" + NL + NL;
  protected final String TEXT_3 = "\t" + NL + "\t   row";
  protected final String TEXT_4 = ".setString( ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " );";
  protected final String TEXT_8 = NL + "\t   cal_";
  protected final String TEXT_9 = ".setTime(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");" + NL + "\t   row";
  protected final String TEXT_12 = ".setDateTime( ";
  protected final String TEXT_13 = "," + NL + "\t\t\t\t\tcal_";
  protected final String TEXT_14 = ".get(java.util.Calendar.YEAR)," + NL + "                    cal_";
  protected final String TEXT_15 = ".get(java.util.Calendar.MONTH) + 1," + NL + "                    cal_";
  protected final String TEXT_16 = ".get(java.util.Calendar.DAY_OF_MONTH)," + NL + "                    cal_";
  protected final String TEXT_17 = ".get(java.util.Calendar.HOUR_OF_DAY), " + NL + "                    cal_";
  protected final String TEXT_18 = ".get(java.util.Calendar.MINUTE), " + NL + "                    cal_";
  protected final String TEXT_19 = ".get(java.util.Calendar.SECOND), " + NL + "                    cal_";
  protected final String TEXT_20 = ".get(java.util.Calendar.MILLISECOND) * 10 );";
  protected final String TEXT_21 = NL + "\t   row";
  protected final String TEXT_22 = ".setInteger( ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " );";
  protected final String TEXT_26 = NL + "\t   row";
  protected final String TEXT_27 = ".setDouble( ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " );" + NL;
  protected final String TEXT_31 = NL + "\t   row";
  protected final String TEXT_32 = ".setString( ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " );";
  protected final String TEXT_36 = NL + NL + "table";
  protected final String TEXT_37 = ".insert( row";
  protected final String TEXT_38 = " );" + NL + "" + NL + "nb_line_";
  protected final String TEXT_39 = "++;";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
IMetadataTable preMetadata = null;
if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0))
preMetadata = node.getIncomingConnections().get(0).getMetadataTable();
String inRowName = node.getIncomingConnections().get(0).getName(); 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
     List<IMetadataColumn> columns = preMetadata.getListColumns();
for (int i = 0; i < columns.size(); i++) 
{
 IMetadataColumn column = columns.get(i);
 JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

 if ( javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inRowName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_7);
       } else if ( javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inRowName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
   } else if ( javaType == JavaTypesManager.INTEGER) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inRowName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_25);
    
   } else if ( javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inRowName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
     } else {  
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inRowName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
   } // if javatype
}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
