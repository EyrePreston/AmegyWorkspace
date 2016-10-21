package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileExcelSheetCellOutputBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetCellOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetCellOutputBeginJava result = new TFileExcelSheetCellOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setDateFormatPattern(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_8 = "\"));";
  protected final String TEXT_9 = NL + "    // clone sheet";
  protected final String TEXT_10 = NL + "    ";
  protected final String TEXT_11 = ".createCopy(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = ".setTargetSheetName(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t";
  protected final String TEXT_18 = ".initializeSheet();" + NL + "\t// row counter" + NL + "    int nb_line_";
  protected final String TEXT_19 = " = 0;" + NL + "    int nb_cells_";
  protected final String TEXT_20 = " = 0;";
  protected final String TEXT_21 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String openWorkbookCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");
    String sheetName = ElementParameterParser.getValue(node, "__SHEET_NAME__");
    String dateFormat = ElementParameterParser.getValue(node, "__DEFAULT_DATE_FORMAT__");
    boolean createSheetAsCopy = "true".equals(ElementParameterParser.getValue(node, "__CREATE_SHEET_AS_COPY__"));
    String sourceSheetName = ElementParameterParser.getValue(node, "__SOURCE_SHEET_NAME__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dateFormat);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(openWorkbookCompName);
    stringBuffer.append(TEXT_8);
      if (sheetName != null && sheetName.isEmpty() == false) {
        if (createSheetAsCopy) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sourceSheetName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sheetName);
    stringBuffer.append(TEXT_13);
          } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sheetName);
    stringBuffer.append(TEXT_16);
      } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
