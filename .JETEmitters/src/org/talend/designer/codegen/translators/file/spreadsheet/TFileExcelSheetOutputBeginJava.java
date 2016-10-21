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
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TFileExcelSheetOutputBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetOutputBeginJava result = new TFileExcelSheetOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetOutput();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_5 = "\"));";
  protected final String TEXT_6 = NL + "    // clone sheet";
  protected final String TEXT_7 = NL + "    ";
  protected final String TEXT_8 = ".createCopy(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = ".setTargetSheetName(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = ".initializeSheet();";
  protected final String TEXT_16 = NL + "\t {" + NL + "\t    ";
  protected final String TEXT_17 = ".setRowStartIndex(";
  protected final String TEXT_18 = ".getLastRowNum() + 1);" + NL + "\t }";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = ".setRowStartIndex(";
  protected final String TEXT_21 = " - 1);";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = ".setFirstRowIsHeader(true);";
  protected final String TEXT_24 = NL + "\t";
  protected final String TEXT_25 = ".setFirstRowIsHeader(false);";
  protected final String TEXT_26 = NL + "    // configure cell positions";
  protected final String TEXT_27 = NL + "    ";
  protected final String TEXT_28 = ".setDataColumnPosition(";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t";
  protected final String TEXT_32 = ".setColumnStart(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t";
  protected final String TEXT_35 = ".setReuseExistingStyles(";
  protected final String TEXT_36 = ");" + NL + "\t";
  protected final String TEXT_37 = ".setReuseFirstRowHeight(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t";
  protected final String TEXT_40 = ".setReuseExistingStylesAlternating(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "    // configure cell formats";
  protected final String TEXT_43 = NL + "    // columnIndex: ";
  protected final String TEXT_44 = ", format: ";
  protected final String TEXT_45 = ", talendType: ";
  protected final String TEXT_46 = NL + "    ";
  protected final String TEXT_47 = ".setDataFormat(";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "    ";
  protected final String TEXT_51 = ".setDataFormat(";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "    ";
  protected final String TEXT_55 = ".setNumberPrecision(";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "    // freeze pane";
  protected final String TEXT_59 = NL + "    ";
  protected final String TEXT_60 = ".freezeAt(";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "    ";
  protected final String TEXT_64 = ".setWriteNullValues(";
  protected final String TEXT_65 = ");" + NL + "    // configure auto size columns";
  protected final String TEXT_66 = NL + "\t";
  protected final String TEXT_67 = ".setAutoSizeColumn(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "    // configure comments";
  protected final String TEXT_70 = NL + "\t";
  protected final String TEXT_71 = ".setColumnValueAsComment(";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "    // fill schema names into the header object array" + NL + "    Object[] header_";
  protected final String TEXT_74 = " = new Object[";
  protected final String TEXT_75 = "];";
  protected final String TEXT_76 = NL + "    header_";
  protected final String TEXT_77 = "[";
  protected final String TEXT_78 = "] = ";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "    // write header" + NL + "    try {";
  protected final String TEXT_81 = NL + "    \t";
  protected final String TEXT_82 = ".writeColumn(header_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "    \t";
  protected final String TEXT_85 = ".writeRow(header_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "    } catch (Exception e) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_88 = "_ERROR_MESSAGE\", \"Error in header:\" + e.getMessage());" + NL + "    \tthrow e;" + NL + "    }";
  protected final String TEXT_89 = NL + "\t// no schema defined!";
  protected final String TEXT_90 = "\t" + NL + "\t// row counter" + NL + "    int nb_line_";
  protected final String TEXT_91 = " = 0;" + NL;
  protected final String TEXT_92 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String openWorkbookCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");
    String sheetName = ElementParameterParser.getValue(node, "__SHEET_NAME__");
    boolean createSheetAsCopy = "true".equals(ElementParameterParser.getValue(node, "__CREATE_SHEET_AS_COPY__"));
    String sourceSheetName = ElementParameterParser.getValue(node, "__SOURCE_SHEET_NAME__");
    boolean appendRows = "true".equals(ElementParameterParser.getValue(node, "__APPEND_ROWS__"));
    boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDE_HEADER__"));
    String rowStartIndexStr = ElementParameterParser.getValue(node, "__ROW_START_INDEX__");
    String allowWriteNull = ElementParameterParser.getValue(node, "__WRITE_NULL__");
    String freezeRowStr = ElementParameterParser.getValue(node, "__FREEZE_ROW__");
    String freezeColStr = ElementParameterParser.getValue(node, "__FREEZE_COL__");
    boolean useIndividualColumnPositions = "true".equals(ElementParameterParser.getValue(node, "__USE_COLUMN_POSITIONING__"));
    String columnStartPosStr = ElementParameterParser.getValue(node, "__COLUMN_START_INDEX__");
    Map<Integer, String> fieldMap = new HashMap<Integer, String>();
    int columnIndex = 0;
	if (useIndividualColumnPositions) {
        List<Map<String, String>> mappingList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
		for (Map<String, String> entry : mappingList) {
			String name = entry.get("POSITION");
			if (name != null && name.trim().isEmpty() == false) {
				fieldMap.put(columnIndex, name.trim());
			}
			columnIndex++;
		}
	}
    IConnection conn = null;
    if (node.getIncomingConnections().size() > 0) {
    	conn = node.getIncomingConnections().get(0);
    }
	List<IMetadataColumn> listColumns = new ArrayList<IMetadataColumn>(); // dummy
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		listColumns = metadata.getListColumns();
		}
	}
    List<Map<String, String>> formatList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
    Map<Integer, String> formatMap = new HashMap<Integer, String>();
	columnIndex = 0;
	for (Map<String, String> entry : formatList) {
		String format = entry.get("FORMAT");
		if (format != null && format.isEmpty() == false) {
			formatMap.put(columnIndex, format);
		}
		columnIndex++;
	}	
   List<Map<String, String>> headerList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
   Map<Integer, String> headerMap = new HashMap<Integer, String>();
	columnIndex = 0;
	for (Map<String, String> entry : headerList) {
		String header = entry.get("HEADER");
		if (header != null && header.isEmpty() == false) {
			headerMap.put(columnIndex, header);
		}
		columnIndex++;
	}
	String reuseStyle = ElementParameterParser.getValue(node, "__REUSE_STYLE__");
	String reuseStyleAlternating = ElementParameterParser.getValue(node, "__REUSE_STYLE_ALTERNATING__");
	String reuseFirstRowHeight = ElementParameterParser.getValue(node, "__REUSE_FIRST_ROW_HEIGHT__");
	boolean writeColumns = "true".equals(ElementParameterParser.getValue(node, "__WRITE_IN_COLUMNS__"));
	if (writeColumns) appendRows = false;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(openWorkbookCompName);
    stringBuffer.append(TEXT_5);
      if (sheetName != null && sheetName.isEmpty() == false) {
        if (createSheetAsCopy) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sourceSheetName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sheetName);
    stringBuffer.append(TEXT_10);
          } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sheetName);
    stringBuffer.append(TEXT_13);
      } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
      if (appendRows) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
      } else if (rowStartIndexStr != null && rowStartIndexStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rowStartIndexStr);
    stringBuffer.append(TEXT_21);
      } 
      if (includeHeader) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
      } else { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
      }  
    stringBuffer.append(TEXT_26);
      if (useIndividualColumnPositions) {
        String sheetColumn = null;
        for (Map.Entry<Integer, String> entry : fieldMap.entrySet()) {
            Integer schemaColumnIndex = entry.getKey();
            sheetColumn = entry.getValue();
            if (sheetColumn != null && sheetColumn.isEmpty() == false) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(sheetColumn);
    stringBuffer.append(TEXT_30);
              }
        }
    } else if (columnStartPosStr != null && columnStartPosStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnStartPosStr);
    stringBuffer.append(TEXT_33);
      }
    if (writeColumns == false) { 
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(reuseStyle);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(reuseFirstRowHeight);
    stringBuffer.append(TEXT_38);
      	if ("true".equals(reuseStyle)) { 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(reuseStyleAlternating);
    stringBuffer.append(TEXT_41);
      	} 
      } 
    stringBuffer.append(TEXT_42);
    	if ("true".equals(reuseStyle) == false) {
	    for (Map.Entry<Integer, String> entry : formatMap.entrySet()) { 
		    String columnFormat = null;
        	Integer schemaColumnIndex = entry.getKey();
        	columnFormat = entry.getValue();
        	String talendType = null;
        	Integer precision = null;
        	if (listColumns != null) { 
	        	IMetadataColumn mc = listColumns.get(schemaColumnIndex);
	        	precision = mc.getPrecision();
   	        	talendType = mc.getTalendType().substring(3);
 		    	if (columnFormat == null || columnFormat.isEmpty()) {
               		columnFormat = mc.getPattern();
            	}
        	} 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnFormat);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(talendType);
    			if (columnFormat != null &&  columnFormat.isEmpty() == false) {
				if ("Date".equalsIgnoreCase(talendType) || "Timestamp".equalsIgnoreCase(talendType)) { 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnFormat);
    stringBuffer.append(TEXT_49);
    				} else if ("Double".equals(talendType) || "Float".equals(talendType) || "BigDecimal".equals(talendType) || "Integer".equals(talendType) || "Long".equals(talendType) || "Short".equals(talendType) || "String".equals(talendType)) { 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnFormat);
    stringBuffer.append(TEXT_53);
              	}
        	} else if (precision != null) {
            	if ("Double".equals(talendType) || "Float".equals(talendType) || "BigDecimal".equals(talendType) || "Integer".equals(talendType) || "Long".equals(talendType) || "Short".equals(talendType) || "String".equals(talendType)) { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(precision);
    stringBuffer.append(TEXT_57);
              	}
        	}
        } // for
    }  // if (reuseStyle == false)
    if (freezeRowStr != null && freezeRowStr.isEmpty() == false && freezeColStr != null && freezeColStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(freezeColStr);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(freezeRowStr);
    stringBuffer.append(TEXT_62);
      } 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(allowWriteNull);
    stringBuffer.append(TEXT_65);
      List<Map<String, String>> autoSizeColumnList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
	columnIndex = 0;
	for (Map<String, String> entry : autoSizeColumnList) {
		boolean autoSize = "true".equals(entry.get("IS_AUTO_SIZE"));
		if (autoSize) { 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_68);
    		}
		columnIndex++;
	} 
    stringBuffer.append(TEXT_69);
      List<Map<String, String>> commentColumnList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
	columnIndex = 0;
	for (Map<String, String> entry : commentColumnList) {
		boolean comment = "true".equals(entry.get("IS_COMMENT"));
		if (comment) { 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_72);
    		}
		columnIndex++;
	} 
      if (includeHeader && conn != null && listColumns != null && headerMap != null) { 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_75);
          columnIndex = 0;
        if (conn != null) {
            String header = null;
            for (IMetadataColumn col : listColumns) { 
                 header = headerMap.get(columnIndex); 
                 if (header == null || header.isEmpty()) {
                 	header = "\"" + col.getLabel() + "\"";
                 }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_79);
              columnIndex++;
            } 
    stringBuffer.append(TEXT_80);
      if (writeColumns) { 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
      } else { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
      } 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
          } else { 
    stringBuffer.append(TEXT_89);
          } 
    	} // include header 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
    return stringBuffer.toString();
  }
}
