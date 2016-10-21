package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TFileExcelSheetOutputMainJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetOutputMainJava result = new TFileExcelSheetOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // fill schema data into the object array" + NL + "    Object[] dataset_";
  protected final String TEXT_2 = " = new Object[";
  protected final String TEXT_3 = "];";
  protected final String TEXT_4 = NL + "    dataset_";
  protected final String TEXT_5 = "[";
  protected final String TEXT_6 = "] = ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "    // write dataset" + NL + "    try {";
  protected final String TEXT_10 = NL + "    \t";
  protected final String TEXT_11 = ".writeColumn(dataset_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "    \t";
  protected final String TEXT_14 = ".writeRow(dataset_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "    \tnb_line_";
  protected final String TEXT_17 = "++;" + NL + "    } catch (Exception e) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_18 = "_ERROR_MESSAGE\", \"Error in line \" + nb_line_";
  protected final String TEXT_19 = " + \":\" + e.getMessage());" + NL + "    \tthrow e;" + NL + "    }";
  protected final String TEXT_20 = NL + "\t// no schema defined!";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    IConnection conn = null;
    if (node.getIncomingConnections().size() > 0) {
    	conn = node.getIncomingConnections().get(0);
    }
	List<IMetadataColumn> listColumns = new ArrayList<IMetadataColumn>(); // dummy
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		listColumns = metadata.getListColumns();
		}
	}
	boolean writeColumns = "true".equals(ElementParameterParser.getValue(node, "__WRITE_IN_COLUMNS__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_3);
      int columnIndex = 0;
    if (conn != null) {
        for (IMetadataColumn col : listColumns) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_8);
              columnIndex++;
        } 
    stringBuffer.append(TEXT_9);
      if (writeColumns) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
      } else { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
      } 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
      } else { 
    stringBuffer.append(TEXT_20);
      } 
    return stringBuffer.toString();
  }
}
