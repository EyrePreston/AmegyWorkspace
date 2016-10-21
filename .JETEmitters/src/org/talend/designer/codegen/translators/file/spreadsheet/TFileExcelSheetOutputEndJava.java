package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileExcelSheetOutputEndJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetOutputEndJava result = new TFileExcelSheetOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t ";
  protected final String TEXT_2 = ".deleteFollowingRows();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setupColumnSize();";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = ".extendCellRangesForConditionalFormattings();";
  protected final String TEXT_7 = NL + "    globalMap.put(\"";
  protected final String TEXT_8 = "_NB_LINE\", nb_line_";
  protected final String TEXT_9 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_10 = "_LAST_ROW_INDEX\", ";
  protected final String TEXT_11 = ".getSheetLastRowIndex());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    boolean removeLastEmptyRows = "true".equals(ElementParameterParser.getValue(node, "__REMOVE_LAST_EMPTY_ROWS__"));
    boolean reuseCF = "true".equals(ElementParameterParser.getValue(node, "__REUSE_CF__"));

      if (removeLastEmptyRows) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
      } 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
      if (reuseCF) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
      } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
