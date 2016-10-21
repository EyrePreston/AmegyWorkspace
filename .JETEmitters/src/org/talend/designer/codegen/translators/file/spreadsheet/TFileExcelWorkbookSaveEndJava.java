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
import java.util.Map;

public class TFileExcelWorkbookSaveEndJava
{
  protected static String nl;
  public static synchronized TFileExcelWorkbookSaveEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelWorkbookSaveEndJava result = new TFileExcelWorkbookSaveEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tde.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile();" + NL + "    // set the workbook" + NL + "\t";
  protected final String TEXT_3 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_4 = "\"));";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = ".evaluateAllFormulars();\t";
  protected final String TEXT_7 = "\t" + NL + "\t// delete template sheets if needed";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = ".deleteSheet(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    // persist workbook" + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_12 = ".setOutputFile(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".createDirs();";
  protected final String TEXT_16 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_17 = "_COUNT_SHEETS\", ";
  protected final String TEXT_18 = ".getWorkbook().getNumberOfSheets());" + NL + "\t\t";
  protected final String TEXT_19 = ".writeWorkbook();" + NL + "\t\t// release the memory" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_20 = "_FILENAME\", ";
  protected final String TEXT_21 = ".getOutputFile());" + NL + "\t\tglobalMap.remove(\"workbook_";
  protected final String TEXT_22 = "\");" + NL + "\t} catch (Exception e) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_23 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\tthrow e;" + NL + "\t}";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String openCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");
    String file = ElementParameterParser.getValue(node, "__FILENAME__");
    boolean evaluateFomulas = "true".equals(ElementParameterParser.getValue(node, "__EVALUATE_ALL_FORMULAS__"));
    boolean createDirs = "true".equals(ElementParameterParser.getValue(node, "__CREATE_DIRS__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(openCompName);
    stringBuffer.append(TEXT_4);
      if (evaluateFomulas) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
      } 
    stringBuffer.append(TEXT_7);
      List<Map<String, String>> mappingList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__TEMPLATE_SHEETS__");
    for (Map<String, String> entry : mappingList) {
		String name = entry.get("SHEET");
		if (name != null && name.trim().isEmpty() == false) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_10);
    		}
	} 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_13);
      if (createDirs) {
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(openCompName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
