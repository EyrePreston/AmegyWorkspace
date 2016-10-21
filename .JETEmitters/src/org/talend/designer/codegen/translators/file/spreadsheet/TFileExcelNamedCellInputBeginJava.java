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
import java.util.Map;

public class TFileExcelNamedCellInputBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelNamedCellInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelNamedCellInputBeginJava result = new TFileExcelNamedCellInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    de.cimt.talendcomp.tfileexcelpoi.SpeadSheetNamedCellInput ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpeadSheetNamedCellInput();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_5 = "\"));";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = ".retrieveNamedCellCount(); // count the named cells" + NL + "\t // row counter" + NL + "    int nb_cells_";
  protected final String TEXT_8 = " = 0;" + NL + "    while (";
  protected final String TEXT_9 = ".readNextNamedCell()) {";
  protected final String TEXT_10 = "\t\t" + NL + "\t\t";
  protected final String TEXT_11 = ".CELL_NAME = ";
  protected final String TEXT_12 = ".getCellName();" + NL + "\t\t";
  protected final String TEXT_13 = ".CELL_VALUE = ";
  protected final String TEXT_14 = ".getCellValue();" + NL + "\t\t";
  protected final String TEXT_15 = ".CELL_CLASS_NAME = ";
  protected final String TEXT_16 = ".getValueClass();" + NL + "\t\t";
  protected final String TEXT_17 = ".CELL_REF = ";
  protected final String TEXT_18 = ".getCellExcelReference();" + NL + "\t\t";
  protected final String TEXT_19 = ".CELL_ROW = ";
  protected final String TEXT_20 = ".getCellRowIndex();" + NL + "\t\t";
  protected final String TEXT_21 = ".CELL_COL = ";
  protected final String TEXT_22 = ".getCellColumnIndex();" + NL + "\t\t";
  protected final String TEXT_23 = ".CELL_INDEX = ";
  protected final String TEXT_24 = ".getCurrentCellIndex();" + NL + "\t\t";
  protected final String TEXT_25 = ".SHEET_NAME = ";
  protected final String TEXT_26 = ".getCellSheetName();";
  protected final String TEXT_27 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_28 = "_CELL_NAME\", ";
  protected final String TEXT_29 = ".getCellName());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_30 = "_CELL_VALUE\", ";
  protected final String TEXT_31 = ".getCellValue());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_CELL_CLASS_NAME\", ";
  protected final String TEXT_33 = ".getValueClass());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_CELL_REF\", ";
  protected final String TEXT_35 = ".getCellExcelReference());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_36 = "_CELL_ROW\", ";
  protected final String TEXT_37 = ".getCellRowIndex());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_CELL_COL\", ";
  protected final String TEXT_39 = ".getCellColumnIndex());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_40 = "_CELL_INDEX\", ";
  protected final String TEXT_41 = ".getCurrentCellIndex());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_42 = "_SHEET_NAME\", ";
  protected final String TEXT_43 = ".getCellSheetName());";
  protected final String TEXT_44 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String openWorkbookCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");
	String outgoingConnName = null;
	List<? extends IConnection> outConns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
	if (outConns != null && outConns.isEmpty() == false) {
	    IConnection outConn = outConns.get(0);
	    outgoingConnName = outConn.getName();
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(openWorkbookCompName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
       if (outgoingConnName != null) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
       } 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
