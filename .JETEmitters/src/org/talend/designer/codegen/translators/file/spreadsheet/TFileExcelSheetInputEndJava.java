package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileExcelSheetInputEndJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetInputEndJava result = new TFileExcelSheetInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    }" + NL + "    globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\", nb_line_";
  protected final String TEXT_3 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_4 = "_LAST_ROW_INDEX\", ";
  protected final String TEXT_5 = ".getSheetLastRowIndex());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
