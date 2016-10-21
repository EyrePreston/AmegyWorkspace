package org.talend.designer.codegen.translators.file.spreadsheet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileExcelNamedCellOutputEndJava
{
  protected static String nl;
  public static synchronized TFileExcelNamedCellOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelNamedCellOutputEndJava result = new TFileExcelNamedCellOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t" + NL + "    // cell name: ";
  protected final String TEXT_2 = ", don't write null: ";
  protected final String TEXT_3 = ", missing cell will be ignored: ";
  protected final String TEXT_4 = NL + "\tif (nc_";
  protected final String TEXT_5 = ".isNotNull((";
  protected final String TEXT_6 = "))) {";
  protected final String TEXT_7 = NL + "\t    try {" + NL + "\t\t\tboolean cellExists = ";
  protected final String TEXT_8 = ".writeNamedCellValue(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\tif (cellExists == false) {" + NL + "\t\t\t\tthrow new Exception(\"Cell with name:\" + ";
  protected final String TEXT_12 = " + \" is missing!\");" + NL + "\t\t\t}";
  protected final String TEXT_13 = NL + "\t    } catch (Exception e) {" + NL + "\t    \tglobalMap.put(\"";
  protected final String TEXT_14 = "_ERROR_MESSAGE\", \"Write value for cell:\" + ";
  protected final String TEXT_15 = " + \" failed:\" + e.getMessage());" + NL + "\t    \tthrow e;" + NL + "\t    }";
  protected final String TEXT_16 = NL + "\t}" + NL + "    nb_cells_";
  protected final String TEXT_17 = "++;";
  protected final String TEXT_18 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_19 = "_NB_CELLS\", nb_cells_";
  protected final String TEXT_20 = ");" + NL;
  protected final String TEXT_21 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> cellConfigList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__CELL_CONFIG__");
    for (Map<String, String> cellConfig : cellConfigList) {
    	String name = cellConfig.get("CELL_NAME");
    	String value = cellConfig.get("CELL_VALUE");
    	boolean doNotWriteNull = "true".equals(cellConfig.get("DO_NOT_WRITE_NULL"));
    	boolean ignoreMissingCell = "true".equals(cellConfig.get("IGNORE_MISSING_CELL"));
		if (name != null && name.isEmpty() == false) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(doNotWriteNull);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ignoreMissingCell);
    			if (doNotWriteNull) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_6);
              } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_10);
    			if (ignoreMissingCell == false) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_12);
              } 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_15);
    			if (doNotWriteNull) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
              } 
          } 
      } 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
