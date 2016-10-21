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

public class TFileExcelSheetListBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetListBeginJava result = new TFileExcelSheetListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetList ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetList();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_5 = "\"));" + NL + "\tint countSheets_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".countSheets();" + NL + "\tint ";
  protected final String TEXT_8 = "_sheetIndex = 0;" + NL + "\tString ";
  protected final String TEXT_9 = "_sheetName = null;" + NL + "\tint ";
  protected final String TEXT_10 = "_countRows = 0;" + NL + "\tint nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_COUNT_SHEETS\", countSheets_";
  protected final String TEXT_13 = ");" + NL + "\tfor ( ; ";
  protected final String TEXT_14 = "_sheetIndex < countSheets_";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = "_sheetIndex++) {" + NL + "\t\t";
  protected final String TEXT_17 = "_sheetName = ";
  protected final String TEXT_18 = ".getSheetName(";
  protected final String TEXT_19 = "_sheetIndex);" + NL + "\t\t";
  protected final String TEXT_20 = "_countRows = ";
  protected final String TEXT_21 = ".getCountSheetRows(";
  protected final String TEXT_22 = "_sheetIndex);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_23 = "_SHEET_INDEX\", ";
  protected final String TEXT_24 = "_sheetIndex);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_25 = "_SHEET_NAME\", ";
  protected final String TEXT_26 = "_sheetName);";
  protected final String TEXT_27 = "\t\t" + NL + "\t\t";
  protected final String TEXT_28 = ".COUNT_SHEETS = countSheets_";
  protected final String TEXT_29 = ";" + NL + "\t\t";
  protected final String TEXT_30 = ".SHEET_INDEX = ";
  protected final String TEXT_31 = "_sheetIndex;" + NL + "\t\t";
  protected final String TEXT_32 = ".SHEET_NAME = ";
  protected final String TEXT_33 = "_sheetName;" + NL + "\t\t";
  protected final String TEXT_34 = ".SHEET_ROW_COUNT = ";
  protected final String TEXT_35 = "_countRows;";

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
       if (outgoingConnName != null) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
       } 
    return stringBuffer.toString();
  }
}
