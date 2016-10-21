package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_31 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "" + NL + "" + NL + "\t\tRegexUtil_";
  protected final String TEXT_32 = " regexUtil_";
  protected final String TEXT_33 = " = new RegexUtil_";
  protected final String TEXT_34 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_35 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_36 = ".setDrawingsDisabled(true);";
  protected final String TEXT_37 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_38 = ".setCellValidationDisabled(true);";
  protected final String TEXT_39 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_40 = ".setSuppressWarnings(true);";
  protected final String TEXT_41 = NL + "        workbookSettings_";
  protected final String TEXT_42 = ".setEncoding(";
  protected final String TEXT_43 = ");" + NL + "" + NL + "        Object source_";
  protected final String TEXT_44 = " =";
  protected final String TEXT_45 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_46 = ";" + NL + "" + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_47 = " = null;" + NL + "        java.io.BufferedInputStream buffIStream";
  protected final String TEXT_48 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_49 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_50 = " = (java.io.InputStream)source_";
  protected final String TEXT_51 = ";" + NL + "        \t\tbuffIStream";
  protected final String TEXT_52 = " = new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_53 = ");" + NL + "        \t\tworkbook_";
  protected final String TEXT_54 = " = jxl.Workbook.getWorkbook(buffIStream";
  protected final String TEXT_55 = ", workbookSettings_";
  protected final String TEXT_56 = ");" + NL + "            }else if(source_";
  protected final String TEXT_57 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_58 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_59 = ".toString());" + NL + "        \t\tbuffIStream";
  protected final String TEXT_60 = " = new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_61 = ");" + NL + "        \t\tworkbook_";
  protected final String TEXT_62 = " = jxl.Workbook.getWorkbook(buffIStream";
  protected final String TEXT_63 = ", workbookSettings_";
  protected final String TEXT_64 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_65 = " = null;" + NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            }" + NL + "        } finally {" + NL + "\t\t\ttry{" + NL + "\t\t\t   if(buffIStream";
  protected final String TEXT_66 = " != null){" + NL + "\t\t\t   \t  buffIStream";
  protected final String TEXT_67 = ".close();" + NL + "\t\t\t   }" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_68 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_69 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_70 = ".getSheets());";
  protected final String TEXT_71 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_72 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_73 = NL + "        sheetList_";
  protected final String TEXT_74 = ".addAll(regexUtil_";
  protected final String TEXT_75 = ".getSheets(workbook_";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = "));";
  protected final String TEXT_79 = NL + "        if(sheetList_";
  protected final String TEXT_80 = ".size() <= 0){" + NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_81 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_82 = " : sheetList_";
  protected final String TEXT_83 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_84 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_85 = ".add(sheet_FilterNull_";
  protected final String TEXT_86 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_87 = " = sheet_FilterNullList_";
  protected final String TEXT_88 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_89 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_90 = " = 0;" + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = "0";
  protected final String TEXT_93 = ";" + NL + "" + NL + "        int footer_input_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = "0";
  protected final String TEXT_96 = ";" + NL + "" + NL + "        int end_line_";
  protected final String TEXT_97 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_98 = ":sheetList_";
  protected final String TEXT_99 = "){" + NL + "        \tend_line_";
  protected final String TEXT_100 = "+=sheet_";
  protected final String TEXT_101 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_102 = " -= footer_input_";
  protected final String TEXT_103 = ";" + NL + "        int limit_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "-1";
  protected final String TEXT_106 = ";" + NL + "        int start_column_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = "0";
  protected final String TEXT_109 = "-1";
  protected final String TEXT_110 = ";" + NL + "        int end_column_";
  protected final String TEXT_111 = " = sheetList_";
  protected final String TEXT_112 = ".get(0).getColumns();";
  protected final String TEXT_113 = NL + "        Integer lastColumn_";
  protected final String TEXT_114 = " = ";
  protected final String TEXT_115 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_116 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_117 = " = lastColumn_";
  protected final String TEXT_118 = ".intValue();" + NL + "        }";
  protected final String TEXT_119 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_120 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_121 = " = sheetList_";
  protected final String TEXT_122 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_123 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_124 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_125 = " = sheetList_";
  protected final String TEXT_126 = ".get(0).getRows();" + NL + "" + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_127 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_128 = " = df_";
  protected final String TEXT_129 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_130 = NL + "        for(int i_";
  protected final String TEXT_131 = " = begin_line_";
  protected final String TEXT_132 = "; i_";
  protected final String TEXT_133 = " < end_line_";
  protected final String TEXT_134 = "; i_";
  protected final String TEXT_135 = "++){" + NL + "" + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_136 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_137 = " != -1 && nb_line_";
  protected final String TEXT_138 = " >= limit_";
  protected final String TEXT_139 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "            while (i_";
  protected final String TEXT_140 = " >= rowCount_";
  protected final String TEXT_141 = " + currentRows_";
  protected final String TEXT_142 = ") {" + NL + "                rowCount_";
  protected final String TEXT_143 = " += currentRows_";
  protected final String TEXT_144 = ";" + NL + "                sheet_";
  protected final String TEXT_145 = " = sheetList_";
  protected final String TEXT_146 = ".get(++sheetIndex_";
  protected final String TEXT_147 = ");" + NL + "                currentRows_";
  protected final String TEXT_148 = " = sheet_";
  protected final String TEXT_149 = ".getRows();" + NL + "            }";
  protected final String TEXT_150 = NL + "            if (rowCount_";
  protected final String TEXT_151 = " <= i_";
  protected final String TEXT_152 = ") {" + NL + "                row_";
  protected final String TEXT_153 = " = sheet_";
  protected final String TEXT_154 = ".getRow(i_";
  protected final String TEXT_155 = " - rowCount_";
  protected final String TEXT_156 = ");" + NL + "            }";
  protected final String TEXT_157 = NL + "            if (rowCount_";
  protected final String TEXT_158 = " <= i_";
  protected final String TEXT_159 = " && i_";
  protected final String TEXT_160 = " - rowCount_";
  protected final String TEXT_161 = " >= begin_line_";
  protected final String TEXT_162 = " && currentRows_";
  protected final String TEXT_163 = " - footer_input_";
  protected final String TEXT_164 = " > i_";
  protected final String TEXT_165 = " - rowCount_";
  protected final String TEXT_166 = ") {" + NL + "                row_";
  protected final String TEXT_167 = " = sheet_";
  protected final String TEXT_168 = ".getRow(i_";
  protected final String TEXT_169 = " - rowCount_";
  protected final String TEXT_170 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_171 = NL + "        \tglobalMap.put(\"";
  protected final String TEXT_172 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_173 = ".getName());";
  protected final String TEXT_174 = NL + "    \t\t";
  protected final String TEXT_175 = " = null;";
  protected final String TEXT_176 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_177 = " = new String[";
  protected final String TEXT_178 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_179 = " = end_column_";
  protected final String TEXT_180 = " >\trow_";
  protected final String TEXT_181 = ".length ? row_";
  protected final String TEXT_182 = ".length : end_column_";
  protected final String TEXT_183 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_184 = ";i++){" + NL + "" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_185 = " < actual_end_column_";
  protected final String TEXT_186 = "){" + NL + "" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_187 = " = row_";
  protected final String TEXT_188 = "[i + start_column_";
  protected final String TEXT_189 = "];";
  protected final String TEXT_190 = NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_191 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_192 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_193 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_194 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_195 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_196 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_197 = "[i] = df_";
  protected final String TEXT_198 = ".format(doubleCell_";
  protected final String TEXT_199 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_200 = "[i] = cell_";
  protected final String TEXT_201 = ".getContents();" + NL + "                        }";
  protected final String TEXT_202 = NL + "                        temp_row_";
  protected final String TEXT_203 = "[i] = cell_";
  protected final String TEXT_204 = ".getContents();";
  protected final String TEXT_205 = NL + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_206 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_207 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_208 = " = new ";
  protected final String TEXT_209 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_210 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_211 = " = \"\";" + NL + "\t\t\ttry {";
  protected final String TEXT_212 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_213 = "[";
  protected final String TEXT_214 = "]";
  protected final String TEXT_215 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_216 = "=";
  protected final String TEXT_217 = " + start_column_";
  protected final String TEXT_218 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_219 = " = \"";
  protected final String TEXT_220 = "\";";
  protected final String TEXT_221 = NL + "\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = " = temp_row_";
  protected final String TEXT_224 = "[";
  protected final String TEXT_225 = "]";
  protected final String TEXT_226 = ";";
  protected final String TEXT_227 = NL + "\t\t\tif(";
  protected final String TEXT_228 = "<actual_end_column_";
  protected final String TEXT_229 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_230 = " = ((jxl.DateCell)row_";
  protected final String TEXT_231 = "[";
  protected final String TEXT_232 = " + start_column_";
  protected final String TEXT_233 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_236 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_237 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_239 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_240 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_241 = NL + "\t\t";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = ParserUtils.parseTo_";
  protected final String TEXT_244 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_245 = "[";
  protected final String TEXT_246 = "]";
  protected final String TEXT_247 = ", ";
  protected final String TEXT_248 = ", ";
  protected final String TEXT_249 = "));";
  protected final String TEXT_250 = NL + "\t\t\t";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = temp_row_";
  protected final String TEXT_253 = "[";
  protected final String TEXT_254 = "]";
  protected final String TEXT_255 = ".getBytes(";
  protected final String TEXT_256 = ");" + NL + "\t";
  protected final String TEXT_257 = NL + "\t\t\t";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = " = ParserUtils.parseTo_";
  protected final String TEXT_260 = "(temp_row_";
  protected final String TEXT_261 = "[";
  protected final String TEXT_262 = "]";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "\t\t\t}else {";
  protected final String TEXT_265 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_266 = "' in '";
  protected final String TEXT_267 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_268 = NL + "\t\t\t\t";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_272 = "++;";
  protected final String TEXT_273 = NL + "\t\t}";
  protected final String TEXT_274 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_275 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_276 = " ";
  protected final String TEXT_277 = " = null; ";
  protected final String TEXT_278 = NL;
  protected final String TEXT_279 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_280 = " == ";
  protected final String TEXT_281 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_282 = NL + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_283 = " = true;";
  protected final String TEXT_284 = NL + "            throw(e);";
  protected final String TEXT_285 = NL + "                    ";
  protected final String TEXT_286 = " = new ";
  protected final String TEXT_287 = "Struct();";
  protected final String TEXT_288 = NL + "                    ";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = " = ";
  protected final String TEXT_291 = ".";
  protected final String TEXT_292 = ";";
  protected final String TEXT_293 = NL + "                ";
  protected final String TEXT_294 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_295 = "+ \" column: \" + curColName_";
  protected final String TEXT_296 = " + \" (No. \" + curColNum_";
  protected final String TEXT_297 = " + \")\";";
  protected final String TEXT_298 = NL + "                ";
  protected final String TEXT_299 = " = null;";
  protected final String TEXT_300 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_301 = NL + "                ";
  protected final String TEXT_302 = " = null;";
  protected final String TEXT_303 = NL + "            \t";
  protected final String TEXT_304 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_305 = "+ \" column: \" + curColName_";
  protected final String TEXT_306 = " + \" (No. \" + curColNum_";
  protected final String TEXT_307 = " + \")\";";
  protected final String TEXT_308 = NL + "    }" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t";
  protected final String TEXT_310 = "if(!whetherReject_";
  protected final String TEXT_311 = ") { ";
  protected final String TEXT_312 = NL + "             if(";
  protected final String TEXT_313 = " == null){" + NL + "            \t ";
  protected final String TEXT_314 = " = new ";
  protected final String TEXT_315 = "Struct();" + NL + "             }";
  protected final String TEXT_316 = NL + "\t    \t ";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = " = ";
  protected final String TEXT_319 = ".";
  protected final String TEXT_320 = ";";
  protected final String TEXT_321 = NL + "\t\t";
  protected final String TEXT_322 = " } ";
  protected final String TEXT_323 = NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_324 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_325 = " regexUtil_";
  protected final String TEXT_326 = " = new RegexUtil_";
  protected final String TEXT_327 = "();" + NL + "" + NL + "\t\tObject source_";
  protected final String TEXT_328 = " = ";
  protected final String TEXT_329 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_330 = " = null;" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_331 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_332 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_333 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_334 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_335 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_336 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_337 = " = null;" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL;
  protected final String TEXT_338 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_339 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_340 = ":workbook_";
  protected final String TEXT_341 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_342 = ".add(sheet_";
  protected final String TEXT_343 = ");" + NL + "    \t}";
  protected final String TEXT_344 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_345 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_346 = NL + "        sheetList_";
  protected final String TEXT_347 = ".addAll(regexUtil_";
  protected final String TEXT_348 = ".getSheets(workbook_";
  protected final String TEXT_349 = ", ";
  protected final String TEXT_350 = ", ";
  protected final String TEXT_351 = "));";
  protected final String TEXT_352 = NL + "    \tif(sheetList_";
  protected final String TEXT_353 = ".size() <= 0){" + NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_354 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_355 = " : sheetList_";
  protected final String TEXT_356 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_357 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_358 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_359 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_360 = ".add(sheet_FilterNull_";
  protected final String TEXT_361 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_362 = " = sheetList_FilterNull_";
  protected final String TEXT_363 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_364 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_365 = " = 0;" + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_366 = " = ";
  protected final String TEXT_367 = "0";
  protected final String TEXT_368 = ";" + NL + "" + NL + "        int footer_input_";
  protected final String TEXT_369 = " = ";
  protected final String TEXT_370 = "0";
  protected final String TEXT_371 = ";" + NL + "" + NL + "        int end_line_";
  protected final String TEXT_372 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_373 = ":sheetList_";
  protected final String TEXT_374 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_375 = "+=(sheet_";
  protected final String TEXT_376 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_377 = " -= footer_input_";
  protected final String TEXT_378 = ";" + NL + "        int limit_";
  protected final String TEXT_379 = " = ";
  protected final String TEXT_380 = "-1";
  protected final String TEXT_381 = ";" + NL + "        int start_column_";
  protected final String TEXT_382 = " = ";
  protected final String TEXT_383 = "0";
  protected final String TEXT_384 = "-1";
  protected final String TEXT_385 = ";" + NL + "        int end_column_";
  protected final String TEXT_386 = " = -1;";
  protected final String TEXT_387 = NL + "        Integer lastColumn_";
  protected final String TEXT_388 = " = ";
  protected final String TEXT_389 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_390 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_391 = " = lastColumn_";
  protected final String TEXT_392 = ".intValue();" + NL + "        }";
  protected final String TEXT_393 = NL + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_394 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_395 = " = sheetList_";
  protected final String TEXT_396 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_397 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_398 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_399 = " = (sheetList_";
  protected final String TEXT_400 = ".get(0).getLastRowNum()+1);" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_401 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_402 = " = df_";
  protected final String TEXT_403 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_404 = NL + "        for(int i_";
  protected final String TEXT_405 = " = begin_line_";
  protected final String TEXT_406 = "; i_";
  protected final String TEXT_407 = " < end_line_";
  protected final String TEXT_408 = "; i_";
  protected final String TEXT_409 = "++){" + NL + "" + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_410 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_411 = " != -1 && nb_line_";
  protected final String TEXT_412 = " >= limit_";
  protected final String TEXT_413 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "            while (i_";
  protected final String TEXT_414 = " >= rowCount_";
  protected final String TEXT_415 = " + currentRows_";
  protected final String TEXT_416 = ") {" + NL + "                rowCount_";
  protected final String TEXT_417 = " += currentRows_";
  protected final String TEXT_418 = ";" + NL + "                sheet_";
  protected final String TEXT_419 = " = sheetList_";
  protected final String TEXT_420 = ".get(++sheetIndex_";
  protected final String TEXT_421 = ");" + NL + "                currentRows_";
  protected final String TEXT_422 = " = (sheet_";
  protected final String TEXT_423 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_424 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_425 = ".getSheetName());";
  protected final String TEXT_426 = NL + "            if (rowCount_";
  protected final String TEXT_427 = " <= i_";
  protected final String TEXT_428 = ") {" + NL + "                row_";
  protected final String TEXT_429 = " = sheet_";
  protected final String TEXT_430 = ".getRow(i_";
  protected final String TEXT_431 = " - rowCount_";
  protected final String TEXT_432 = ");" + NL + "            }";
  protected final String TEXT_433 = NL + "            if (rowCount_";
  protected final String TEXT_434 = " <= i_";
  protected final String TEXT_435 = " && i_";
  protected final String TEXT_436 = " - rowCount_";
  protected final String TEXT_437 = " >= begin_line_";
  protected final String TEXT_438 = " && currentRows_";
  protected final String TEXT_439 = " - footer_input_";
  protected final String TEXT_440 = " > i_";
  protected final String TEXT_441 = " - rowCount_";
  protected final String TEXT_442 = ") {" + NL + "                row_";
  protected final String TEXT_443 = " = sheet_";
  protected final String TEXT_444 = ".getRow(i_";
  protected final String TEXT_445 = " - rowCount_";
  protected final String TEXT_446 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_447 = NL + "\t\t    ";
  protected final String TEXT_448 = " = null;";
  protected final String TEXT_449 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_450 = " = new String[";
  protected final String TEXT_451 = "];";
  protected final String TEXT_452 = NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_453 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_454 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_455 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_456 = ".add(";
  protected final String TEXT_457 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_458 = ".add(";
  protected final String TEXT_459 = ");";
  protected final String TEXT_460 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_461 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_462 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_463 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_464 = "=row_";
  protected final String TEXT_465 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_466 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_467 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_468 = " = excel_end_column_";
  protected final String TEXT_469 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_470 = " = end_column_";
  protected final String TEXT_471 = " >\texcel_end_column_";
  protected final String TEXT_472 = " ? excel_end_column_";
  protected final String TEXT_473 = " : end_column_";
  protected final String TEXT_474 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_475 = " = null;" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_476 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_477 = " < actual_end_column_";
  protected final String TEXT_478 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_479 = " = row_";
  protected final String TEXT_480 = ".getCell(i + start_column_";
  protected final String TEXT_481 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_482 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_483 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_484 = "[i] = cell_";
  protected final String TEXT_485 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_486 = ")) {";
  protected final String TEXT_487 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_488 = ".get(i)){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_489 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_490 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_491 = ".get(i));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_492 = "[i] = cell_";
  protected final String TEXT_493 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_494 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_495 = "[i] =cell_";
  protected final String TEXT_496 = ".getDateCellValue().toString();";
  protected final String TEXT_497 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_498 = "[i] = df_";
  protected final String TEXT_499 = ".format(cell_";
  protected final String TEXT_500 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_501 = "[i] =String.valueOf(cell_";
  protected final String TEXT_502 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_503 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_504 = "[i] = cell_";
  protected final String TEXT_505 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_506 = ")) {";
  protected final String TEXT_507 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_508 = ".get(i)){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_509 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_510 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_511 = ".get(i));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_512 = "[i] =cell_";
  protected final String TEXT_513 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_514 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_515 = "[i] =cell_";
  protected final String TEXT_516 = ".getDateCellValue().toString();";
  protected final String TEXT_517 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_518 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_519 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_520 = "[i] = ne_";
  protected final String TEXT_521 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_522 = "[i] =String.valueOf(cell_";
  protected final String TEXT_523 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_524 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_525 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_526 = "[i]=\"\";" + NL + "                \t}" + NL + "" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_527 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_528 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_529 = " = new ";
  protected final String TEXT_530 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_531 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_532 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_533 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_534 = "[";
  protected final String TEXT_535 = "]";
  protected final String TEXT_536 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_537 = "=";
  protected final String TEXT_538 = " + start_column_";
  protected final String TEXT_539 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_540 = " = \"";
  protected final String TEXT_541 = "\";" + NL;
  protected final String TEXT_542 = NL + "\t\t\t\t";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = " = temp_row_";
  protected final String TEXT_545 = "[";
  protected final String TEXT_546 = "]";
  protected final String TEXT_547 = ";";
  protected final String TEXT_548 = NL + "\t\t\t\tif(";
  protected final String TEXT_549 = "<actual_end_column_";
  protected final String TEXT_550 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_551 = ".getCell(";
  protected final String TEXT_552 = "+ start_column_";
  protected final String TEXT_553 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_554 = ".getCell(";
  protected final String TEXT_555 = "+ start_column_";
  protected final String TEXT_556 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_557 = ".";
  protected final String TEXT_558 = " = row_";
  protected final String TEXT_559 = ".getCell(";
  protected final String TEXT_560 = "+ start_column_";
  protected final String TEXT_561 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_562 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_563 = "[";
  protected final String TEXT_564 = "]";
  protected final String TEXT_565 = ", ";
  protected final String TEXT_566 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_567 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_568 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_569 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_570 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_571 = NL + "                                ";
  protected final String TEXT_572 = ".";
  protected final String TEXT_573 = " = tempDate_";
  protected final String TEXT_574 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_575 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_576 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_577 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_578 = NL + "\t\t\t\t";
  protected final String TEXT_579 = ".";
  protected final String TEXT_580 = " = ParserUtils.parseTo_";
  protected final String TEXT_581 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_582 = "[";
  protected final String TEXT_583 = "]";
  protected final String TEXT_584 = ", ";
  protected final String TEXT_585 = ", ";
  protected final String TEXT_586 = "));";
  protected final String TEXT_587 = NL + "\t\t\t\t";
  protected final String TEXT_588 = ".";
  protected final String TEXT_589 = " = ParserUtils.parseTo_";
  protected final String TEXT_590 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_591 = "[";
  protected final String TEXT_592 = "]";
  protected final String TEXT_593 = ", null, '.'==decimalChar_";
  protected final String TEXT_594 = " ? null : decimalChar_";
  protected final String TEXT_595 = "));";
  protected final String TEXT_596 = NL + "\t\t\t\t";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = " = temp_row_";
  protected final String TEXT_599 = "[";
  protected final String TEXT_600 = "]";
  protected final String TEXT_601 = ".getBytes(";
  protected final String TEXT_602 = ");";
  protected final String TEXT_603 = NL + "\t\t\t\t";
  protected final String TEXT_604 = ".";
  protected final String TEXT_605 = " = ParserUtils.parseTo_";
  protected final String TEXT_606 = "(temp_row_";
  protected final String TEXT_607 = "[";
  protected final String TEXT_608 = "]";
  protected final String TEXT_609 = ");";
  protected final String TEXT_610 = NL + "\t\t\t}else{";
  protected final String TEXT_611 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_612 = "' in '";
  protected final String TEXT_613 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_614 = NL + "\t\t\t\t";
  protected final String TEXT_615 = ".";
  protected final String TEXT_616 = " = ";
  protected final String TEXT_617 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_618 = "++;";
  protected final String TEXT_619 = NL + "\t\t\t}";
  protected final String TEXT_620 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_621 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_622 = " ";
  protected final String TEXT_623 = " = null; ";
  protected final String TEXT_624 = NL;
  protected final String TEXT_625 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_626 = " == ";
  protected final String TEXT_627 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_628 = NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_629 = " = true;";
  protected final String TEXT_630 = NL + "\t            throw(e);";
  protected final String TEXT_631 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_632 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_633 = NL + "\t\t\t\t\t";
  protected final String TEXT_634 = " = new ";
  protected final String TEXT_635 = "Struct();";
  protected final String TEXT_636 = NL + "\t\t\t\t\t";
  protected final String TEXT_637 = ".";
  protected final String TEXT_638 = " = ";
  protected final String TEXT_639 = ".";
  protected final String TEXT_640 = ";";
  protected final String TEXT_641 = NL + "\t\t\t\t\t";
  protected final String TEXT_642 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_643 = "+ \" column: \" + curColName_";
  protected final String TEXT_644 = " + \" (No. \" + curColNum_";
  protected final String TEXT_645 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_646 = " = null;";
  protected final String TEXT_647 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_648 = " = null;";
  protected final String TEXT_649 = NL + "\t\t\t\t\t";
  protected final String TEXT_650 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_651 = "+ \" column: \" + curColName_";
  protected final String TEXT_652 = " + \" (No. \" + curColNum_";
  protected final String TEXT_653 = " + \")\";";
  protected final String TEXT_654 = NL + "\t\t\t}" + NL + NL;
  protected final String TEXT_655 = NL + "\t\t";
  protected final String TEXT_656 = "if(!whetherReject_";
  protected final String TEXT_657 = ") { ";
  protected final String TEXT_658 = NL + "             if(";
  protected final String TEXT_659 = " == null){" + NL + "            \t ";
  protected final String TEXT_660 = " = new ";
  protected final String TEXT_661 = "Struct();" + NL + "             }";
  protected final String TEXT_662 = NL + "\t    \t ";
  protected final String TEXT_663 = ".";
  protected final String TEXT_664 = " = ";
  protected final String TEXT_665 = ".";
  protected final String TEXT_666 = ";";
  protected final String TEXT_667 = NL + "\t\t";
  protected final String TEXT_668 = " } ";
  protected final String TEXT_669 = NL + "\t\tObject source_";
  protected final String TEXT_670 = " = ";
  protected final String TEXT_671 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_672 = " = null;" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_673 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_674 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_675 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {";
  protected final String TEXT_676 = NL + "\t\texcelReader_";
  protected final String TEXT_677 = ".addSheetName(\".*\",true);";
  protected final String TEXT_678 = NL + "\t\texcelReader_";
  protected final String TEXT_679 = ".addSheetName(";
  protected final String TEXT_680 = ", ";
  protected final String TEXT_681 = ");";
  protected final String TEXT_682 = NL + "\t\tint start_column_";
  protected final String TEXT_683 = " = ";
  protected final String TEXT_684 = "0";
  protected final String TEXT_685 = "-1";
  protected final String TEXT_686 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_687 = " = ";
  protected final String TEXT_688 = "-1";
  protected final String TEXT_689 = "-1";
  protected final String TEXT_690 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_691 = " >=0) {//follow start column" + NL + "\t\t\tend_column_";
  protected final String TEXT_692 = " = start_column_";
  protected final String TEXT_693 = " + ";
  protected final String TEXT_694 = " - 1;" + NL + "\t\t} else if(end_column_";
  protected final String TEXT_695 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_696 = " = end_column_";
  protected final String TEXT_697 = " - ";
  protected final String TEXT_698 = " + 1;" + NL + "\t\t}" + NL + "" + NL + "\t\tif(end_column_";
  protected final String TEXT_699 = "<0 || start_column_";
  protected final String TEXT_700 = "<0) {" + NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "" + NL + "\t\tint header_";
  protected final String TEXT_701 = " = ";
  protected final String TEXT_702 = "0";
  protected final String TEXT_703 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_704 = " = ";
  protected final String TEXT_705 = "-1";
  protected final String TEXT_706 = ";" + NL + "" + NL + "\t\tint nb_line_";
  protected final String TEXT_707 = " = 0;" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_708 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_709 = " = df_";
  protected final String TEXT_710 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_711 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_712 = ".parse((String)source_";
  protected final String TEXT_713 = ",";
  protected final String TEXT_714 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_715 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_716 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_717 = ",";
  protected final String TEXT_718 = ");" + NL + "\t\t}" + NL + "" + NL + "" + NL + "\t\twhile((header_";
  protected final String TEXT_719 = "--)>0 && excelReader_";
  protected final String TEXT_720 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_721 = ".next();" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_722 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_723 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_724 = " = 0;" + NL + "" + NL + "\t\t\tif (limit_";
  protected final String TEXT_725 = " != -1 && nb_line_";
  protected final String TEXT_726 = " >= limit_";
  protected final String TEXT_727 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_728 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_729 = " = excelReader_";
  protected final String TEXT_730 = ".next();";
  protected final String TEXT_731 = NL + "\t\t";
  protected final String TEXT_732 = " = null;";
  protected final String TEXT_733 = NL + "\t\tString[] temp_row_";
  protected final String TEXT_734 = " = new String[";
  protected final String TEXT_735 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_736 = "=0;i_";
  protected final String TEXT_737 = " < ";
  protected final String TEXT_738 = ";i_";
  protected final String TEXT_739 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_740 = " = i_";
  protected final String TEXT_741 = " + start_column_";
  protected final String TEXT_742 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_743 = " <= end_column_";
  protected final String TEXT_744 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_745 = " < row_";
  protected final String TEXT_746 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_747 = " = row_";
  protected final String TEXT_748 = ".get(current_";
  protected final String TEXT_749 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_750 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_751 = "[i_";
  protected final String TEXT_752 = "] = column_";
  protected final String TEXT_753 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_754 = "[i_";
  protected final String TEXT_755 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_756 = "[i_";
  protected final String TEXT_757 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_758 = "[i_";
  protected final String TEXT_759 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_760 = " = false;" + NL + "\t\t";
  protected final String TEXT_761 = " = new ";
  protected final String TEXT_762 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_763 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_764 = " = \"\";" + NL + "" + NL + "\t\ttry{";
  protected final String TEXT_765 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_766 = "[";
  protected final String TEXT_767 = "]";
  protected final String TEXT_768 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_769 = "=";
  protected final String TEXT_770 = " + start_column_";
  protected final String TEXT_771 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_772 = " = \"";
  protected final String TEXT_773 = "\";" + NL;
  protected final String TEXT_774 = NL + "\t\t\t\t";
  protected final String TEXT_775 = ".";
  protected final String TEXT_776 = " = temp_row_";
  protected final String TEXT_777 = "[";
  protected final String TEXT_778 = "]";
  protected final String TEXT_779 = ";";
  protected final String TEXT_780 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_781 = ".";
  protected final String TEXT_782 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_783 = "[";
  protected final String TEXT_784 = "]";
  protected final String TEXT_785 = ", ";
  protected final String TEXT_786 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_787 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_788 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_789 = " + \" )\");" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_790 = NL + "\t\t\t\t";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = " = ParserUtils.parseTo_";
  protected final String TEXT_793 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_794 = "[";
  protected final String TEXT_795 = "]";
  protected final String TEXT_796 = ", ";
  protected final String TEXT_797 = ", ";
  protected final String TEXT_798 = "));";
  protected final String TEXT_799 = NL + "\t\t\t\t";
  protected final String TEXT_800 = ".";
  protected final String TEXT_801 = " = ParserUtils.parseTo_";
  protected final String TEXT_802 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_803 = "[";
  protected final String TEXT_804 = "]";
  protected final String TEXT_805 = ", null, '.'==decimalChar_";
  protected final String TEXT_806 = " ? null : decimalChar_";
  protected final String TEXT_807 = "));";
  protected final String TEXT_808 = NL + "\t\t\t\t";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = " = temp_row_";
  protected final String TEXT_811 = "[";
  protected final String TEXT_812 = "]";
  protected final String TEXT_813 = ".getBytes(";
  protected final String TEXT_814 = ");";
  protected final String TEXT_815 = NL + "\t\t\t\t";
  protected final String TEXT_816 = ".";
  protected final String TEXT_817 = " = ParserUtils.parseTo_";
  protected final String TEXT_818 = "(temp_row_";
  protected final String TEXT_819 = "[";
  protected final String TEXT_820 = "]";
  protected final String TEXT_821 = ");";
  protected final String TEXT_822 = NL + "\t\t\t}else{";
  protected final String TEXT_823 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_824 = "' in '";
  protected final String TEXT_825 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_826 = NL + "\t\t\t\t";
  protected final String TEXT_827 = ".";
  protected final String TEXT_828 = " = ";
  protected final String TEXT_829 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_830 = "++;";
  protected final String TEXT_831 = NL + "\t\t\t}";
  protected final String TEXT_832 = NL;
  protected final String TEXT_833 = " ";
  protected final String TEXT_834 = " = null; ";
  protected final String TEXT_835 = NL;
  protected final String TEXT_836 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_837 = " == ";
  protected final String TEXT_838 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_839 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_840 = " = true;";
  protected final String TEXT_841 = NL + "\t            throw(e);";
  protected final String TEXT_842 = NL + "\t\t\t\t\t";
  protected final String TEXT_843 = " = new ";
  protected final String TEXT_844 = "Struct();";
  protected final String TEXT_845 = NL + "\t\t\t\t\t";
  protected final String TEXT_846 = ".";
  protected final String TEXT_847 = " = ";
  protected final String TEXT_848 = ".";
  protected final String TEXT_849 = ";";
  protected final String TEXT_850 = NL + "\t\t\t\t\t";
  protected final String TEXT_851 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_852 = "+ \" column: \" + curColName_";
  protected final String TEXT_853 = " + \" (No. \" + curColNum_";
  protected final String TEXT_854 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_855 = " = null;";
  protected final String TEXT_856 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_857 = " = null;";
  protected final String TEXT_858 = NL + "\t\t\t\t\t";
  protected final String TEXT_859 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_860 = "+ \" column: \" + curColName_";
  protected final String TEXT_861 = " + \" (No. \" + curColNum_";
  protected final String TEXT_862 = " + \")\";";
  protected final String TEXT_863 = NL + "\t\t\t}" + NL;
  protected final String TEXT_864 = NL + "        \t\t";
  protected final String TEXT_865 = "if(!whetherReject_";
  protected final String TEXT_866 = ") { ";
  protected final String TEXT_867 = NL + "                     if(";
  protected final String TEXT_868 = " == null){" + NL + "                    \t ";
  protected final String TEXT_869 = " = new ";
  protected final String TEXT_870 = "Struct();" + NL + "                     }";
  protected final String TEXT_871 = NL + "        \t    \t ";
  protected final String TEXT_872 = ".";
  protected final String TEXT_873 = " = ";
  protected final String TEXT_874 = ".";
  protected final String TEXT_875 = ";";
  protected final String TEXT_876 = NL + "        \t\t";
  protected final String TEXT_877 = " } ";
  protected final String TEXT_878 = NL;
  protected final String TEXT_879 = NL;
  protected final String TEXT_880 = NL;
  protected final String TEXT_881 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));

		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");

		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));

		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		boolean eventMode = "EVENT_MODE".equals(mode);

		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

		/* -------------------------- */
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_37);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_38);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_39);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_40);
    
		}

    stringBuffer.append(TEXT_41);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    
		}else{

    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_78);
    
			}
		}

    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_92);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_95);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_105);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_108);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    
	if(!affect){

    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    
	}else{

    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_170);
    
    }

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    
//begin
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_174);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_175);
    
    				}
    			}
    		}
    	}

		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_184);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    
                    if(bReadRealValue){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
                    }else{

    stringBuffer.append(TEXT_202);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
                    }

    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_214);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_221);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_225);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_226);
    
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_227);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_232);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_238);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    
//start
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_246);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_249);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
	
    stringBuffer.append(TEXT_250);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_254);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_256);
    
			} else {
//
//end
    stringBuffer.append(TEXT_257);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_262);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_263);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_264);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_265);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_267);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_271);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_272);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_273);
    
//start
//
					}
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_277);
    }
    stringBuffer.append(TEXT_278);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_279);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_281);
    
	}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_284);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_285);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_287);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_288);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_292);
    
                }
                
    stringBuffer.append(TEXT_293);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_299);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_300);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_302);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_303);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    }
        }
        
    stringBuffer.append(TEXT_308);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_309);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_312);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_315);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_316);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_320);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_321);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_322);
     } 
    
		}
		}

    
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_338);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
		}else{

    stringBuffer.append(TEXT_344);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_345);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_346);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_351);
    
			}
		}

    stringBuffer.append(TEXT_352);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_366);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_367);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_369);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_370);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_371);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_379);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_380);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_381);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_382);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_383);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_386);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    }
    stringBuffer.append(TEXT_393);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_404);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    
	if(!affect){

    stringBuffer.append(TEXT_426);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_432);
    
	}else{

    stringBuffer.append(TEXT_433);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    
    }

    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String rejectConnName = "";
		List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
		if(rejectConns != null && rejectConns.size() > 0) {
			IConnection rejectConn = rejectConns.get(0);
			rejectConnName = rejectConn.getName();
		}
		List<IMetadataColumn> rejectColumnList = null;
		IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
		if(metadataTable != null) {
			 rejectColumnList = metadataTable.getListColumns();
		}
		if (conns!=null) {
			if (conns.size()>0) {
		    	for (int i=0;i<conns.size();i++) {
		    		IConnection connTemp = conns.get(i);
		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_447);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_448);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_449);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_451);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_459);
    
						}
					}
				}
			}

    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_476);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    
								if(converDatetoString){

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    
								}else{

    stringBuffer.append(TEXT_494);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
								}

    stringBuffer.append(TEXT_497);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
										if(converDatetoString){

    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
										}else{

    stringBuffer.append(TEXT_514);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
										}

    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_535);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_538);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_541);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_542);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_546);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_547);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_548);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_552);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_555);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_558);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_560);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_564);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_565);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_575);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_578);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_580);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_583);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_584);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_585);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_586);
    
							} else {

    stringBuffer.append(TEXT_587);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_589);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_592);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_596);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_600);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_602);
    
						} else {

    stringBuffer.append(TEXT_603);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_605);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_608);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_609);
    
						}

    stringBuffer.append(TEXT_610);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_611);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_613);
    
						} else {

    stringBuffer.append(TEXT_614);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_617);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_618);
    
						}

    stringBuffer.append(TEXT_619);
    
					}

    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_622);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_623);
    }
    stringBuffer.append(TEXT_624);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_625);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_627);
    
	}

    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_630);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_633);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_635);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_636);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_638);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_640);
    
					    }//16

    stringBuffer.append(TEXT_641);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_646);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_647);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_648);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_649);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    
					}//15
				}

    stringBuffer.append(TEXT_654);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_655);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_658);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_661);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_662);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_663);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_665);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_666);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_667);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_668);
     } 
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_680);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_681);
    
				}
			}

    stringBuffer.append(TEXT_682);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_683);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_684);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_685);
    }
    stringBuffer.append(TEXT_686);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_687);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_688);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_689);
    }
    stringBuffer.append(TEXT_690);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_691);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_694);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_696);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_698);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_699);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_702);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_705);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_706);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

			String rejectConnName = "";
			List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    		if(rejectConns != null && rejectConns.size() > 0) {
    			IConnection rejectConn = rejectConns.get(0);
    			rejectConnName = rejectConn.getName();
    		}
    		List<IMetadataColumn> rejectColumnList = null;
    		IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    		if(metadataTable != null) {
    			 rejectColumnList = metadataTable.getListColumns();
    		}

    		if (conns!=null) {
    			if (conns.size()>0) {
    		    	for (int i=0;i<conns.size();i++) {
    		    		IConnection connTemp = conns.get(i);
    		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_731);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_732);
    
    		    		}
    		    	}
    		    }
			}

			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256

    stringBuffer.append(TEXT_733);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_767);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_770);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_772);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_773);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_774);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_777);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_778);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_779);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_780);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_784);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_785);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_786);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_787);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_789);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_790);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_791);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_792);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_795);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_796);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_797);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_798);
    
							} else {

    stringBuffer.append(TEXT_799);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_800);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_801);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_803);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_804);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_807);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_808);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_809);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_811);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_812);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_813);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_814);
    
						} else {

    stringBuffer.append(TEXT_815);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_817);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_819);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_820);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_821);
    
						}

    stringBuffer.append(TEXT_822);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_823);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_824);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_825);
    
						} else {

    stringBuffer.append(TEXT_826);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_827);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_828);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_829);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_830);
    
						}

    stringBuffer.append(TEXT_831);
    
					}//TD128

    stringBuffer.append(TEXT_832);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_833);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_834);
    }
    stringBuffer.append(TEXT_835);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_836);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_837);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_838);
    
	}

    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_841);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_842);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_843);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_844);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_845);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_847);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_849);
    
					    }//16

    stringBuffer.append(TEXT_850);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_854);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_855);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_856);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_857);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_858);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_862);
    
					}//15
				}

    stringBuffer.append(TEXT_863);
    
    				}//TD256
				}//TD528

        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_864);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_865);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_866);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_867);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_868);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_869);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_870);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_871);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_872);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_873);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_874);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_875);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_876);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_877);
     } 
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_878);
    
		}//end version judgement

    stringBuffer.append(TEXT_879);
    
	}
}
//
//end
    stringBuffer.append(TEXT_880);
    stringBuffer.append(TEXT_881);
    return stringBuffer.toString();
  }
}
