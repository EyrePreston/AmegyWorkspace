package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileExcelNamedCellInputEndJava
{
  protected static String nl;
  public static synchronized TFileExcelNamedCellInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelNamedCellInputEndJava result = new TFileExcelNamedCellInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tnb_cells_";
  protected final String TEXT_2 = "++;" + NL + "\t}" + NL + "\tglobalMap.put(\"NB_CELLS_";
  protected final String TEXT_3 = "\", nb_cells_";
  protected final String TEXT_4 = ");" + NL;
  protected final String TEXT_5 = NL + "    ";

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
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
