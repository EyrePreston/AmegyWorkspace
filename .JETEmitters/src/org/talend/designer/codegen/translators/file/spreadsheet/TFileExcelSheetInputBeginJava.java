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

public class TFileExcelSheetInputBeginJava
{
  protected static String nl;
  public static synchronized TFileExcelSheetInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileExcelSheetInputBeginJava result = new TFileExcelSheetInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    de.cimt.talendcomp.tfileexcelpoi.SpreadsheetInput ";
  protected final String TEXT_2 = " = new de.cimt.talendcomp.tfileexcelpoi.SpreadsheetInput();";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = ".setWorkbook((org.apache.poi.ss.usermodel.Workbook) globalMap.get(\"workbook_";
  protected final String TEXT_5 = "\"));";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = ".useSheet(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = ".setRowStartIndex(";
  protected final String TEXT_11 = " - 1);";
  protected final String TEXT_12 = NL + "    // configure cell positions";
  protected final String TEXT_13 = NL + "    ";
  protected final String TEXT_14 = ".setHeaderName(";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = ".setHeaderRowIndex(";
  protected final String TEXT_20 = " - 1);" + NL + "\t";
  protected final String TEXT_21 = ".setFindHeaderPosByRegex(";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = ".configColumnPositions();";
  protected final String TEXT_24 = NL + "    ";
  protected final String TEXT_25 = ".setDataColumnPosition(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = ".setColumnStart(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t";
  protected final String TEXT_32 = ".setNumberFormatLocale(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t";
  protected final String TEXT_35 = ".setReturnURLInsteadOfName(";
  protected final String TEXT_36 = ");" + NL + "\t";
  protected final String TEXT_37 = ".setConcatenateLabelUrl(";
  protected final String TEXT_38 = ");" + NL + "\t// row counter" + NL + "    int nb_line_";
  protected final String TEXT_39 = " = 0;" + NL + "    while (";
  protected final String TEXT_40 = ".readNextRow()) {";
  protected final String TEXT_41 = NL + "\t\tif (";
  protected final String TEXT_42 = " > 0 && nb_line_";
  protected final String TEXT_43 = " >= ";
  protected final String TEXT_44 = ") {" + NL + "\t\t    System.out.println(\"Stop reading at row \" + ";
  protected final String TEXT_45 = ");" + NL + "\t\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "       \tnb_line_";
  protected final String TEXT_47 = "++;" + NL + "    \t";
  protected final String TEXT_48 = " = new ";
  protected final String TEXT_49 = "Struct(); // to avoid cell value reusing in errors" + NL;
  protected final String TEXT_50 = NL + "\t\tboolean ";
  protected final String TEXT_51 = "_rowHasValues = false;";
  protected final String TEXT_52 = NL + "\t\tif (";
  protected final String TEXT_53 = "_rowHasValues || ";
  protected final String TEXT_54 = ".isCellCommentEmpty(";
  protected final String TEXT_55 = ") == false) {" + NL + "\t\t\t";
  protected final String TEXT_56 = "_rowHasValues = true;" + NL + "\t\t}";
  protected final String TEXT_57 = NL + "\t\tif (";
  protected final String TEXT_58 = "_rowHasValues || ";
  protected final String TEXT_59 = ".isCellValueEmpty(";
  protected final String TEXT_60 = ") == false) {" + NL + "\t\t\t";
  protected final String TEXT_61 = "_rowHasValues = true;" + NL + "\t\t}";
  protected final String TEXT_62 = NL + "\t\tif (";
  protected final String TEXT_63 = "_rowHasValues == false) {" + NL + "\t\t\tSystem.out.println(\"Stop at empty row\");" + NL + "\t\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + " \t\ttry {";
  protected final String TEXT_66 = NL + "\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ".getCommentCellValue(";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ".getStringCellValue(";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_83 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_84 = " in row number=\" + nb_line_";
  protected final String TEXT_85 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_86 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_87 = " in row number=\" + nb_line_";
  protected final String TEXT_88 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_89 = NL + "\t\t}";
  protected final String TEXT_90 = "\t" + NL + " \t\ttry {" + NL + "    \t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ".getIntegerCellValue(";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_97 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_98 = " in row number=\" + nb_line_";
  protected final String TEXT_99 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_100 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_101 = " in row number=\" + nb_line_";
  protected final String TEXT_102 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_103 = NL + "\t\t}";
  protected final String TEXT_104 = "\t" + NL + " \t\ttry {" + NL + "    \t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ".getLongCellValue(";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_111 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_112 = " in row number=\" + nb_line_";
  protected final String TEXT_113 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_114 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_115 = " in row number=\" + nb_line_";
  protected final String TEXT_116 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_117 = NL + "\t\t}";
  protected final String TEXT_118 = "\t" + NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ".getBigDecimalCellValue(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_125 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_126 = " in row number=\" + nb_line_";
  protected final String TEXT_127 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_128 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_129 = " in row number=\" + nb_line_";
  protected final String TEXT_130 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_131 = NL + "\t\t}";
  protected final String TEXT_132 = "\t" + NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ".getDoubleCellValue(";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_139 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_140 = " in row number=\" + nb_line_";
  protected final String TEXT_141 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_142 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_143 = " in row number=\" + nb_line_";
  protected final String TEXT_144 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_145 = NL + "\t\t}";
  protected final String TEXT_146 = "\t" + NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ".getFloatCellValue(";
  protected final String TEXT_150 = ", ";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_153 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_154 = " in row number=\" + nb_line_";
  protected final String TEXT_155 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_156 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_157 = " in row number=\" + nb_line_";
  protected final String TEXT_158 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_159 = NL + "\t\t}";
  protected final String TEXT_160 = "\t" + NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = ".getShortCellValue(";
  protected final String TEXT_164 = ", ";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_167 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_168 = " in row number=\" + nb_line_";
  protected final String TEXT_169 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_170 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_171 = " in row number=\" + nb_line_";
  protected final String TEXT_172 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_173 = NL + "\t\t}";
  protected final String TEXT_174 = NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = ".getDateCellValue(";
  protected final String TEXT_178 = ", ";
  protected final String TEXT_179 = ", ";
  protected final String TEXT_180 = ", ";
  protected final String TEXT_181 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_182 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_183 = " in row number=\" + nb_line_";
  protected final String TEXT_184 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_185 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_186 = " in row number=\" + nb_line_";
  protected final String TEXT_187 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_188 = NL + "\t\t}";
  protected final String TEXT_189 = NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = " = ";
  protected final String TEXT_192 = ".getBooleanCellValue(";
  protected final String TEXT_193 = ", ";
  protected final String TEXT_194 = ", ";
  protected final String TEXT_195 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_196 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_197 = " in row number=\" + nb_line_";
  protected final String TEXT_198 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_199 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_200 = " in row number=\" + nb_line_";
  protected final String TEXT_201 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_202 = NL + "\t\t}";
  protected final String TEXT_203 = NL + " \t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_204 = ".";
  protected final String TEXT_205 = " = ";
  protected final String TEXT_206 = ".getStringCellValue(";
  protected final String TEXT_207 = ", ";
  protected final String TEXT_208 = ", ";
  protected final String TEXT_209 = ", ";
  protected final String TEXT_210 = ");" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_211 = NL + "            System.err.println(\"Read column ";
  protected final String TEXT_212 = " in row number=\" + nb_line_";
  protected final String TEXT_213 = " + \" error ignored:\" + e.getMessage());";
  protected final String TEXT_214 = NL + "\t\t\tthrow new Exception(\"Read column ";
  protected final String TEXT_215 = " in row number=\" + nb_line_";
  protected final String TEXT_216 = " + \" failed:\" + e.getMessage(), e); ";
  protected final String TEXT_217 = NL + "\t\t}";
  protected final String TEXT_218 = " ";
  protected final String TEXT_219 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String openWorkbookCompName = ElementParameterParser.getValue(node, "__WORKBOOK__");
    String sheetName = ElementParameterParser.getValue(node, "__SHEET_NAME__");
    String rowStartIndexStr = ElementParameterParser.getValue(node, "__ROW_START_INDEX__");
    String rowEndIndexStr = ElementParameterParser.getValue(node, "__ROW_STOP_INDEX__");
    boolean stopAtEmptyRow = "true".equals(ElementParameterParser.getValue(node, "__STOP_AT_EMPTY_ROW__"));
    String headerRowIndexStr = ElementParameterParser.getValue(node, "__HEADER_ROW_INDEX__");
    if (headerRowIndexStr == null || headerRowIndexStr.isEmpty()) {
    	headerRowIndexStr = "1";
    }
    boolean useIndividualColumnPositions = "true".equals(ElementParameterParser.getValue(node, "__USE_COLUMN_POSITIONING__"));
    boolean configColumnByHeader = useIndividualColumnPositions && "true".equals(ElementParameterParser.getValue(node, "__CONFIG_COLUMN_BY_HEADER__"));
    String useRegexToFindColumnInHeader = ElementParameterParser.getValue(node, "__CONFIG_HEADER_BY_REGEX__");
    String columnStartPosStr = ElementParameterParser.getValue(node, "__COLUMN_START_INDEX__");
    String numberFormatLocale = ElementParameterParser.getValue(node, "__NUMBERFORMAT_LOCALE__");
    String returnLink = ElementParameterParser.getValue(node, "__RETURN_LINK__");
    String concatenateLabelUrl = ElementParameterParser.getValue(node, "__ADD_LINK_TO_LABEL__");
    Map<Integer, String> fieldMap = new HashMap<Integer, String>();
    Map<Integer, String> headerNameMap = new HashMap<Integer, String>();
    Map<Integer, Boolean> readCommentMap = new HashMap<Integer, Boolean>();
    Map<Integer, Boolean> useLastMap = new HashMap<Integer, Boolean>();
    Map<Integer, Boolean> ignoreErrorMap = new HashMap<Integer, Boolean>();
    Map<Integer, Boolean> ignoreMissingMap = new HashMap<Integer, Boolean>();
    int columnIndex = 0;
    List<Map<String, String>> mappingList = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__COLUMN_CONFIG__");
	for (Map<String, String> entry : mappingList) {
		String name = entry.get("POSITION");
		if (useIndividualColumnPositions && name != null && name.trim().isEmpty() == false) {
			fieldMap.put(columnIndex, name.trim());
		}
		String readComment = entry.get("READ_COMMENT");
		String useLast = entry.get("KEEP_LAST");
		String ignore = entry.get("IGNORE_ERROR");
		String ignoreMissing = entry.get("IGNORE_MISSING");
		String headerName = entry.get("HEADER_NAME");
		readCommentMap.put(columnIndex, useIndividualColumnPositions && "true".equals(readComment));
		useLastMap.put(columnIndex, useIndividualColumnPositions && "true".equals(useLast));
		ignoreErrorMap.put(columnIndex, useIndividualColumnPositions && "true".equals(ignore));
		ignoreMissingMap.put(columnIndex, configColumnByHeader && "true".equals(ignoreMissing));
		if (headerName == null || headerName.isEmpty()) {
			headerName = "\"" + entry.get("SCHEMA_COLUMN") + "\"";
		}
		headerNameMap.put(columnIndex, headerName);
		columnIndex++;
	}
    IConnection conn = null;
    if (node.getOutgoingConnections().size() > 0) {
    	conn = node.getOutgoingConnections().get(0);
    }
	List<IMetadataColumn> listColumns = new ArrayList<IMetadataColumn>(); // dummy
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		listColumns = metadata.getListColumns();
		}
	}
	List<Map<String, String>> trimSelects = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
    Map<Integer, Boolean> trimMap = new HashMap<Integer, Boolean>();
    columnIndex = 0;
	for (Map<String, String> entry : trimSelects) {
		String trim = entry.get("TRIM");
		trimMap.put(columnIndex, "true".equals(trim));
		columnIndex++;
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(openWorkbookCompName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sheetName);
    stringBuffer.append(TEXT_8);
      if (rowStartIndexStr != null && rowStartIndexStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rowStartIndexStr);
    stringBuffer.append(TEXT_11);
      } 
    stringBuffer.append(TEXT_12);
      if (useIndividualColumnPositions) {
		if (configColumnByHeader) {
			for (Map.Entry<Integer, String> entry : headerNameMap.entrySet()) {
   				Integer schemaColumnIndex = entry.getKey();
				String headerName = entry.getValue(); 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ignoreMissingMap.get(schemaColumnIndex));
    stringBuffer.append(TEXT_17);
    			} 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(headerRowIndexStr);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(useRegexToFindColumnInHeader);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    		} else {
			String sheetColumn = null;
			for (Map.Entry<Integer, String> entry : fieldMap.entrySet()) {
   				Integer schemaColumnIndex = entry.getKey();
				sheetColumn = entry.getValue();
				if (sheetColumn != null && sheetColumn.isEmpty() == false) { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(schemaColumnIndex);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(sheetColumn);
    stringBuffer.append(TEXT_27);
              	}
			}
		}
    } else if (columnStartPosStr != null && columnStartPosStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnStartPosStr);
    stringBuffer.append(TEXT_30);
      }
	if (numberFormatLocale != null && numberFormatLocale.isEmpty() == false) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(numberFormatLocale);
    stringBuffer.append(TEXT_33);
      } 
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(returnLink);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(concatenateLabelUrl);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
      if (rowEndIndexStr != null && rowEndIndexStr.isEmpty() == false) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(rowEndIndexStr);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rowEndIndexStr);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(rowEndIndexStr);
    stringBuffer.append(TEXT_45);
      } 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_49);
      if (stopAtEmptyRow) { 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
          for (columnIndex = 0; columnIndex < listColumns.size(); columnIndex++) { 
    			if (readCommentMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    			} else { 
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
              } 
          } 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
      } 
    stringBuffer.append(TEXT_64);
      for (columnIndex = 0; columnIndex < listColumns.size(); columnIndex++) {
		IMetadataColumn column = listColumns.get(columnIndex);
		boolean trim = trimMap.get(columnIndex);
		boolean useLast = useLastMap.get(columnIndex);
		String type = column.getTalendType();
		if ("id_String".equals(type)) { 
    stringBuffer.append(TEXT_65);
    			if (readCommentMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_73);
    			} else { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_81);
              } 
    stringBuffer.append(TEXT_82);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    	    } else { 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
          } 
    stringBuffer.append(TEXT_89);
          } else if ("id_Integer".equals(type)) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_96);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    	    } else { 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
          } 
    stringBuffer.append(TEXT_103);
          } else if ("id_Long".equals(type)) { 
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_110);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    	    } else { 
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
          } 
    stringBuffer.append(TEXT_117);
          } else if ("id_BigDecimal".equals(type)) { 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_124);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    	    } else { 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
          } 
    stringBuffer.append(TEXT_131);
          } else if ("id_Double".equals(type)) { 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_138);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    	    } else { 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
          } 
    stringBuffer.append(TEXT_145);
          } else if ("id_Float".equals(type)) { 
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_152);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    	    } else { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
          } 
    stringBuffer.append(TEXT_159);
          } else if ("id_Short".equals(type)) { 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_166);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    	    } else { 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
          } 
    stringBuffer.append(TEXT_173);
          } else if ("id_Date".equals(type)) { 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_181);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    	    } else { 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
          } 
    stringBuffer.append(TEXT_188);
          } else if ("id_Boolean".equals(type)) { 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_195);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    	    } else { 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
          } 
    stringBuffer.append(TEXT_202);
          } else { 
    stringBuffer.append(TEXT_203);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(useLast);
    stringBuffer.append(TEXT_210);
          if (ignoreErrorMap.get(columnIndex)) { 
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    	    } else { 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
          } 
    stringBuffer.append(TEXT_217);
          }
    } 
    stringBuffer.append(TEXT_218);
    stringBuffer.append(TEXT_219);
    return stringBuffer.toString();
  }
}
