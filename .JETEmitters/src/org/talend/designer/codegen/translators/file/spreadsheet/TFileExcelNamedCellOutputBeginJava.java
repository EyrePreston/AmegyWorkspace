package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileExcelNamedCellOutputBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelNamedCellOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelNamedCellOutputBeginJava result = new TFileExcelNamedCellOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_5 = "\"));" + NL + "    // configure cell positions" + NL + "\t// row counter" + NL + "    int nb_cells_";
  protected final String TEXT_6 = " = 0;" + NL + "\tclass NullCheck_";
  protected final String TEXT_7 = " {" + NL + "\t\t" + NL + "\t\tpublic boolean isNotNull(Object o) {" + NL + "\t\t\treturn o != null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "\tNullCheck_";
  protected final String TEXT_8 = " nc_";
  protected final String TEXT_9 = " = new NullCheck_";
  protected final String TEXT_10 = "();" + NL;
  protected final String TEXT_11 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String openWorkbookCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");

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
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
