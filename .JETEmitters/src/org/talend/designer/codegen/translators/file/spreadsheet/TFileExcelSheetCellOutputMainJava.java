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
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TFileExcelSheetCellOutputMainJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetCellOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetCellOutputMainJava result = new TFileExcelSheetCellOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // write input flow" + NL + "    nb_line_";
  protected final String TEXT_2 = "++;";
  protected final String TEXT_3 = NL + "\tif (Boolean.TRUE.equals(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ") == false || ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " != null) {";
  protected final String TEXT_8 = "     " + NL + "\t    try {" + NL + "\t\t\tif (";
  protected final String TEXT_9 = ".writeReferencedCellValue(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " - 1, ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ", null)) {" + NL + "\t\t\t    nb_cells_";
  protected final String TEXT_18 = "++;" + NL + "\t\t\t}" + NL + "\t    } catch (Exception e) {" + NL + "\t    \tglobalMap.put(\"";
  protected final String TEXT_19 = "_ERROR_MESSAGE\", \"Write cell:\" + ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " + \":\" + ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = " + \" failed:\" + e.getMessage());" + NL + "\t    \tthrow e;" + NL + "\t    }";
  protected final String TEXT_24 = NL + "\t}";
  protected final String TEXT_25 = "     ";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    IConnection conn = null;
    List<? extends IConnection> inConns = NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA);
    if (inConns != null && inConns.size() > 0) {
    	conn = inConns.get(0);
    }
	List<IMetadataColumn> listColumns = new java.util.ArrayList<IMetadataColumn>(); // dummy
	IMetadataTable metadata = (conn != null ? conn.getMetadataTable() : null);
	if (metadata != null) {
		listColumns = metadata.getListColumns();
	}

      if (conn != null) {
		boolean hasColumns = false;
		String colRow = null;
		String colCol = null;
		String colValue = null;
		boolean nullable = true;
		String colComment = null;
		String colDoNoWriteNull = null;
		int columnIndex = 0;
        for (IMetadataColumn col : listColumns) {
        	switch (columnIndex) {
        	case 0: colRow = col.getLabel(); break;
        	case 1: colCol = col.getLabel(); break;
        	case 2: {
        		nullable = col.isNullable();
        		colValue = col.getLabel(); 
        		break;
        	}
        	case 3: colComment = col.getLabel(); break;
        	case 4: colDoNoWriteNull = col.getLabel(); break;
        	}
        	columnIndex++;
        	hasColumns = true;
        }
		if (hasColumns) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
      if (nullable) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(colDoNoWriteNull);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(colValue);
    stringBuffer.append(TEXT_7);
      } 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(colRow);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colCol);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(colValue);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(colComment);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colRow);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colCol);
    stringBuffer.append(TEXT_23);
      if (nullable) { 
    stringBuffer.append(TEXT_24);
      } 
    stringBuffer.append(TEXT_25);
          } 
      } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
