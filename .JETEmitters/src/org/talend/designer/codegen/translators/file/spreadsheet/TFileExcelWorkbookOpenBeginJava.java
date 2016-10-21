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

public class TFileExcelWorkbookOpenBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelWorkbookOpenBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelWorkbookOpenBeginJava result = new TFileExcelWorkbookOpenBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tde.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile.registerFunction(";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tde.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile ";
  protected final String TEXT_5 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile();";
  protected final String TEXT_6 = NL + "    // register additional backported functions like IFERROR" + NL + "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetFile.registerBackportFunctions();";
  protected final String TEXT_7 = "\t" + NL + "\t";
  protected final String TEXT_8 = ".setCreateStreamingXMLWorkbook(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\ttry {";
  protected final String TEXT_11 = NL + "        // create empty XLS workbook" + NL + "\t\t";
  protected final String TEXT_12 = ".createEmptyXLSWorkbook();";
  protected final String TEXT_13 = NL + "        // create empty XLSX workbook" + NL + "\t\t";
  protected final String TEXT_14 = ".createEmptyXLSXWorkbook();";
  protected final String TEXT_15 = NL + "\t\t\tthrow new Exception(\"Unknown spreadsheet type: ";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".initializeWorkbook();" + NL + "\t} catch (Exception e) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_19 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\tthrow e;" + NL + "\t}";
  protected final String TEXT_20 = NL + "\ttry {" + NL + "\t    // read a excel file as template" + NL + "\t    // this file file will not used as output file" + NL + "\t\t";
  protected final String TEXT_21 = ".setInputFile(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = ".setPassword(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t";
  protected final String TEXT_27 = ".initializeWorkbook();" + NL + "\t} catch (Exception e) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_28 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\tthrow e;" + NL + "\t}";
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = ".addStyle(";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t" + NL + "\tglobalMap.put(\"workbook_";
  protected final String TEXT_39 = "\", ";
  protected final String TEXT_40 = ".getWorkbook());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_41 = "_COUNT_SHEETS\", ";
  protected final String TEXT_42 = ".getWorkbook().getNumberOfSheets());";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String file = ElementParameterParser.getValue(node, "__FILENAME__");
    String spreadsheetType = ElementParameterParser.getValue(node, "__SPREADSHEET_TYPE__");
    boolean createEmptyWorkbook = "true".equals(ElementParameterParser.getValue(node, "__CREATE_EMPTY_WORKBOOK__"));
    boolean createStreamingWorkbook = "true".equals(ElementParameterParser.getValue(node, "__CREATE_STREAMING_WORKBOOK__"));
    boolean dieIfFileNotExists = "true".equals(ElementParameterParser.getValue(node, "__DIE_IF_FILE_NOT_EXISTS__"));
    boolean decrypt = "true".equals(ElementParameterParser.getValue(node, "__DECRYPT_FILE__"));
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	List<Map<String, String>> functionList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__FUNCTION_ADDONS__");
	if (functionList != null) {
		for (Map<String, String> entry : functionList) {
			String fName = entry.get("FUNC_NAME");
			String fClass = entry.get("FUNC_CLASS"); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(fName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fClass);
    stringBuffer.append(TEXT_3);
    		}
	}
    boolean registerBackportFunctions = "true".equals(ElementParameterParser.getValue(node, "__REGISTER_BACKPORT_FUNCTIONS__"));

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
      if (registerBackportFunctions) { 
    stringBuffer.append(TEXT_6);
      } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(createStreamingWorkbook);
    stringBuffer.append(TEXT_9);
      if (createEmptyWorkbook) {
    stringBuffer.append(TEXT_10);
    		if ("XLS".equals(spreadsheetType)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    		} else if ("XLSX".equals(spreadsheetType)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
          } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(spreadsheetType);
    stringBuffer.append(TEXT_16);
          }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
      } else {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_22);
      if (decrypt && createStreamingWorkbook == false) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_25);
      } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
      }
    /*
	List<Map<String, String>> styleList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__CELL_STYLES__");
	if (styleList != null && styleList.isEmpty() == false) {
		for (Map<String, String> style : styleList) {
			String styleName = style.get("NAME");
			if (styleName == null || styleName.isEmpty()) {
				styleName = "null";
			} else if (styleName.startsWith("\"") == false) {
				styleName = "\"" + styleName + "\"";
			}
			String fontFamily = style.get("FONT_NAME");
			if (fontFamily == null || fontFamily.isEmpty()) {
				fontFamily = "null";
			} else if (fontFamily.startsWith("\"") == false) {
				fontFamily = "\"" + fontFamily + "\"";
			}
			String fontHeight = style.get("FONT_HEIGHT");
			if (fontHeight == null || fontHeight.isEmpty()) {
				fontHeight = "null";
			} else if (fontHeight.startsWith("\"") == false) {
				fontHeight = "\"" + fontHeight + "\"";
			}
			String fontDeco = style.get("FONT_DECO");
			if (fontDeco == null || fontDeco.isEmpty()) {
				fontDeco = "null";
			} else {
				fontDeco = "\"" + fontDeco + "\"";
			}
			String fontColor = style.get("FONT_COLOR");
			if (fontColor == null) {
				fontColor = "null";
			} else {
				fontColor = "\"" + fontColor + "\"";
			}
			String textAlign = style.get("TEXT_ALIGN");
			if (textAlign == null) {
				textAlign = "null";
			} else {
				textAlign = "\"" + textAlign + "\"";
			}
			String cellColor = style.get("CELL_COLOR");
			if (cellColor == null) {
				cellColor = "null";
			} else {
				cellColor = "\"" + cellColor + "\"";
			}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(styleName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(fontFamily);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(fontHeight);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(fontDeco);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(fontColor);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cellColor);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(textAlign);
    stringBuffer.append(TEXT_37);
    		}
	}
	*/

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
