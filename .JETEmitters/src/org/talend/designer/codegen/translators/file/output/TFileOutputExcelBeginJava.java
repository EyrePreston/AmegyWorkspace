package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
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
  protected final String TEXT_30 = NL + "\t\tint nb_line_";
  protected final String TEXT_31 = " = 0;" + NL;
  protected final String TEXT_32 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_33 = "=";
  protected final String TEXT_34 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_35 = " = new java.io.File(fileName_";
  protected final String TEXT_36 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_37 = " = true;";
  protected final String TEXT_38 = NL + "\t\tif(file_";
  protected final String TEXT_39 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_40 = " = false;" + NL + "\t\t}";
  protected final String TEXT_41 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_42 = " = file_";
  protected final String TEXT_43 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_44 = " != null && !parentFile_";
  protected final String TEXT_45 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_46 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_47 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_48 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "             parentFile_";
  protected final String TEXT_50 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_51 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_52 = " - Create directory '\"+parentFile_";
  protected final String TEXT_53 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "          }";
  protected final String TEXT_55 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_56 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_57 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_58 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_59 = ".setEncoding(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_62 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_63 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = "  " + NL + "        if (file_";
  protected final String TEXT_66 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_67 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_68 = ",workbookSettings_";
  protected final String TEXT_69 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_70 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_71 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_72 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_73 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_74 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_75 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_76 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_77 = ");        " + NL + "        }     ";
  protected final String TEXT_78 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_79 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_80 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = "       " + NL + "" + NL + "        writableSheet_";
  protected final String TEXT_83 = " = writeableWorkbook_";
  protected final String TEXT_84 = ".getSheet(";
  protected final String TEXT_85 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_86 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_87 = " = writeableWorkbook_";
  protected final String TEXT_88 = ".createSheet(";
  protected final String TEXT_89 = ", writeableWorkbook_";
  protected final String TEXT_90 = ".getNumberOfSheets());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_91 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_92 = " = writeableWorkbook_";
  protected final String TEXT_93 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_94 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_95 = "[i].equals(";
  protected final String TEXT_96 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_97 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_98 = " = writeableWorkbook_";
  protected final String TEXT_99 = ".createSheet(";
  protected final String TEXT_100 = ", writeableWorkbook_";
  protected final String TEXT_101 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_102 = NL + NL + "        //modif start";
  protected final String TEXT_103 = NL + "\t\tint startRowNum_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "        int startRowNum_";
  protected final String TEXT_107 = " = writableSheet_";
  protected final String TEXT_108 = ".getRows();";
  protected final String TEXT_109 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_110 = " = new int[";
  protected final String TEXT_111 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_112 = "=0;i_";
  protected final String TEXT_113 = "<";
  protected final String TEXT_114 = ";i_";
  protected final String TEXT_115 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_116 = "=writableSheet_";
  protected final String TEXT_117 = ".getColumnView(i_";
  protected final String TEXT_118 = "+";
  protected final String TEXT_119 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_120 = "[i_";
  protected final String TEXT_121 = "]=fitCellViewSize_";
  protected final String TEXT_122 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_123 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_124 = "[i_";
  protected final String TEXT_125 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_126 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_127 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_128 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_129 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_130 = "); ";
  protected final String TEXT_131 = NL;
  protected final String TEXT_132 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_135 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_136 = "));";
  protected final String TEXT_137 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_140 = "));";
  protected final String TEXT_141 = NL + "\t\tif(true){" + NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_142 = " in the schema of component ";
  protected final String TEXT_143 = "!\");" + NL + "\t\t}";
  protected final String TEXT_144 = "\t\t" + NL;
  protected final String TEXT_145 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_146 = "{";
  protected final String TEXT_147 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_148 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_149 = ",final int rowNum_";
  protected final String TEXT_150 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_151 = ",final int[] fitWidth_";
  protected final String TEXT_152 = ") throws java.lang.Exception {";
  protected final String TEXT_153 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_154 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_155 = " + ";
  protected final String TEXT_156 = ", rowNum_";
  protected final String TEXT_157 = ", \"";
  protected final String TEXT_158 = "\"";
  protected final String TEXT_159 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_160 = NL + "\t\t\t));\t\t";
  protected final String TEXT_161 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_162 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_163 = ", rowNum_";
  protected final String TEXT_164 = ", \"";
  protected final String TEXT_165 = "\"";
  protected final String TEXT_166 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_167 = NL + "\t\t\t));";
  protected final String TEXT_168 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_169 = "[";
  protected final String TEXT_170 = "]=fitWidth_";
  protected final String TEXT_171 = "[";
  protected final String TEXT_172 = "]>";
  protected final String TEXT_173 = "?fitWidth_";
  protected final String TEXT_174 = "[";
  protected final String TEXT_175 = "]:";
  protected final String TEXT_176 = ";";
  protected final String TEXT_177 = NL + "\t\t\t}";
  protected final String TEXT_178 = NL + "\t\t\t}";
  protected final String TEXT_179 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_180 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_181 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_182 = ") throws java.lang.Exception {";
  protected final String TEXT_183 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_184 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_185 = ".setColumnView(";
  protected final String TEXT_186 = " + ";
  protected final String TEXT_187 = ", fitWidth_";
  protected final String TEXT_188 = "[";
  protected final String TEXT_189 = "]);" + NL + "        \t\t";
  protected final String TEXT_190 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_191 = ".setColumnView(";
  protected final String TEXT_192 = ", fitWidth_";
  protected final String TEXT_193 = "[";
  protected final String TEXT_194 = "]);" + NL + "        \t\t";
  protected final String TEXT_195 = NL + "    \t\t\t//modif end";
  protected final String TEXT_196 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_197 = ".setColumnView(";
  protected final String TEXT_198 = ", fitWidth_";
  protected final String TEXT_199 = "[";
  protected final String TEXT_200 = "]);";
  protected final String TEXT_201 = NL + "\t\t\t}";
  protected final String TEXT_202 = NL + "\t\t\t}";
  protected final String TEXT_203 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_204 = "(final ";
  protected final String TEXT_205 = "Struct ";
  protected final String TEXT_206 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_207 = ",final int startRowNum_";
  protected final String TEXT_208 = ",final int nb_line_";
  protected final String TEXT_209 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_210 = ",int[] fitWidth_";
  protected final String TEXT_211 = ") throws java.lang.Exception {";
  protected final String TEXT_212 = NL + "\t\t\t";
  protected final String TEXT_213 = "\t\t\t\t";
  protected final String TEXT_214 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_218 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = " = writableSheet_";
  protected final String TEXT_223 = ".getWritableCell(";
  protected final String TEXT_224 = " + ";
  protected final String TEXT_225 = ", startRowNum_";
  protected final String TEXT_226 = " + nb_line_";
  protected final String TEXT_227 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_229 = "_";
  protected final String TEXT_230 = " = new jxl.write.";
  protected final String TEXT_231 = "(";
  protected final String TEXT_232 = " + ";
  protected final String TEXT_233 = ", startRowNum_";
  protected final String TEXT_234 = " + nb_line_";
  protected final String TEXT_235 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_237 = "_";
  protected final String TEXT_238 = " = new jxl.write.";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = ", startRowNum_";
  protected final String TEXT_241 = " + nb_line_";
  protected final String TEXT_242 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_243 = NL + "//modif end";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = ", cell_format_";
  protected final String TEXT_247 = "_";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = ")";
  protected final String TEXT_251 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = ".toString()";
  protected final String TEXT_254 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = ")).toString()";
  protected final String TEXT_257 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_258 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_259 = "), ";
  protected final String TEXT_260 = ", ";
  protected final String TEXT_261 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = "), ";
  protected final String TEXT_265 = ", ";
  protected final String TEXT_266 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_267 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_268 = ").doubleValue()";
  protected final String TEXT_269 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_274 = "_";
  protected final String TEXT_275 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = ".setCellFormat( existingCell_";
  protected final String TEXT_278 = "_";
  protected final String TEXT_279 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_281 = ".addCell(cell_";
  protected final String TEXT_282 = "_";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_285 = "_";
  protected final String TEXT_286 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_287 = "_";
  protected final String TEXT_288 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_289 = "_";
  protected final String TEXT_290 = "=currentWith_";
  protected final String TEXT_291 = "_";
  protected final String TEXT_292 = ">10?10:currentWith_";
  protected final String TEXT_293 = "_";
  protected final String TEXT_294 = ";";
  protected final String TEXT_295 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_296 = "_";
  protected final String TEXT_297 = " = cell_";
  protected final String TEXT_298 = "_";
  protected final String TEXT_299 = ".getContents().trim().length();";
  protected final String TEXT_300 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_301 = "[";
  protected final String TEXT_302 = "]=fitWidth_";
  protected final String TEXT_303 = "[";
  protected final String TEXT_304 = "]>currentWith_";
  protected final String TEXT_305 = "_";
  protected final String TEXT_306 = "?fitWidth_";
  protected final String TEXT_307 = "[";
  protected final String TEXT_308 = "]:currentWith_";
  protected final String TEXT_309 = "_";
  protected final String TEXT_310 = "+2;";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_312 = "_";
  protected final String TEXT_313 = "=";
  protected final String TEXT_314 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_315 = "[";
  protected final String TEXT_316 = "]=fitWidth_";
  protected final String TEXT_317 = "[";
  protected final String TEXT_318 = "]>currentWith_";
  protected final String TEXT_319 = "_";
  protected final String TEXT_320 = "?fitWidth_";
  protected final String TEXT_321 = "[";
  protected final String TEXT_322 = "]:currentWith_";
  protected final String TEXT_323 = "_";
  protected final String TEXT_324 = "+2;";
  protected final String TEXT_325 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t}";
  protected final String TEXT_327 = NL + "\t\t\t}";
  protected final String TEXT_328 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_329 = " fileOutputExcelUtil_";
  protected final String TEXT_330 = "=new FileOutputExcelUtil_";
  protected final String TEXT_331 = "();";
  protected final String TEXT_332 = NL;
  protected final String TEXT_333 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_334 = " == ";
  protected final String TEXT_335 = "){";
  protected final String TEXT_336 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_337 = " == 0){";
  protected final String TEXT_338 = NL + "\t//modif end";
  protected final String TEXT_339 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_340 = ".putHeaderValue_";
  protected final String TEXT_341 = "(writableSheet_";
  protected final String TEXT_342 = ",startRowNum_";
  protected final String TEXT_343 = ",";
  protected final String TEXT_344 = "format_";
  protected final String TEXT_345 = "null";
  protected final String TEXT_346 = ",fitWidth_";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_349 = ".putHeaderValue_";
  protected final String TEXT_350 = "(writableSheet_";
  protected final String TEXT_351 = ",nb_line_";
  protected final String TEXT_352 = ",";
  protected final String TEXT_353 = "format_";
  protected final String TEXT_354 = "null";
  protected final String TEXT_355 = ",fitWidth_";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "\t\t//modif start";
  protected final String TEXT_358 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_359 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_360 = " + ";
  protected final String TEXT_361 = ", startRowNum_";
  protected final String TEXT_362 = ", \"";
  protected final String TEXT_363 = "\"";
  protected final String TEXT_364 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_365 = NL + "\t\t\t));\t\t";
  protected final String TEXT_366 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_367 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_368 = ", nb_line_";
  protected final String TEXT_369 = ", \"";
  protected final String TEXT_370 = "\"";
  protected final String TEXT_371 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_372 = NL + "\t\t\t));";
  protected final String TEXT_373 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_374 = "[";
  protected final String TEXT_375 = "]=fitWidth_";
  protected final String TEXT_376 = "[";
  protected final String TEXT_377 = "]>";
  protected final String TEXT_378 = "?fitWidth_";
  protected final String TEXT_379 = "[";
  protected final String TEXT_380 = "]:";
  protected final String TEXT_381 = ";";
  protected final String TEXT_382 = NL + "\t\tnb_line_";
  protected final String TEXT_383 = " ++;" + NL + "\t}";
  protected final String TEXT_384 = NL + "\t\t";
  protected final String TEXT_385 = NL + "\t\tString fileName_";
  protected final String TEXT_386 = "=";
  protected final String TEXT_387 = ";";
  protected final String TEXT_388 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_389 = " = new java.io.File(fileName_";
  protected final String TEXT_390 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_391 = " = true;";
  protected final String TEXT_392 = NL + "\t\tif(file_";
  protected final String TEXT_393 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_394 = " = false;" + NL + "\t\t}";
  protected final String TEXT_395 = NL + "\t\tint nb_line_";
  protected final String TEXT_396 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_397 = " = new org.talend.ExcelTool();";
  protected final String TEXT_398 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_399 = "=";
  protected final String TEXT_400 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_401 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_402 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_403 = NL + "\t\txlsxTool_";
  protected final String TEXT_404 = ".setSheet(";
  protected final String TEXT_405 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_406 = ".setAppend(";
  protected final String TEXT_407 = ",";
  protected final String TEXT_408 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_409 = ".setRecalculateFormula(";
  protected final String TEXT_410 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_411 = ".setXY(";
  protected final String TEXT_412 = ",";
  protected final String TEXT_413 = ",";
  protected final String TEXT_414 = ",";
  protected final String TEXT_415 = ");" + NL + "\t\t";
  protected final String TEXT_416 = NL + "\t\txlsxTool_";
  protected final String TEXT_417 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_418 = ");" + NL + "\t\t";
  protected final String TEXT_419 = NL + "\t\txlsxTool_";
  protected final String TEXT_420 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_421 = NL + "\t\txlsxTool_";
  protected final String TEXT_422 = ".setFont(\"";
  protected final String TEXT_423 = "\");" + NL + "\t\t";
  protected final String TEXT_424 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_425 = "{";
  protected final String TEXT_426 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_427 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_428 = ") throws java.lang.Exception {";
  protected final String TEXT_429 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_430 = ".addCellValue(\"";
  protected final String TEXT_431 = "\");";
  protected final String TEXT_432 = NL + "\t\t\t\t}";
  protected final String TEXT_433 = NL + "\t\t\t\t}";
  protected final String TEXT_434 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_435 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_436 = ") throws java.lang.Exception {";
  protected final String TEXT_437 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_438 = ".setColAutoSize(";
  protected final String TEXT_439 = ");";
  protected final String TEXT_440 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_441 = ".setColAutoSize(";
  protected final String TEXT_442 = ");";
  protected final String TEXT_443 = NL + "\t\t\t\t}";
  protected final String TEXT_444 = NL + "\t\t\t\t}";
  protected final String TEXT_445 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_446 = "(final ";
  protected final String TEXT_447 = "Struct ";
  protected final String TEXT_448 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_449 = ") throws java.lang.Exception {";
  protected final String TEXT_450 = NL + "\t\t\t\t";
  protected final String TEXT_451 = "\t\t\t\t\t";
  protected final String TEXT_452 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_453 = ".";
  protected final String TEXT_454 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_455 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_456 = ".addCellValue(";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = ", ";
  protected final String TEXT_459 = ");";
  protected final String TEXT_460 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_461 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_462 = ".";
  protected final String TEXT_463 = ")).toString());";
  protected final String TEXT_464 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_465 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_466 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_467 = "), ";
  protected final String TEXT_468 = ", ";
  protected final String TEXT_469 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_470 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_471 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_472 = ".";
  protected final String TEXT_473 = "), ";
  protected final String TEXT_474 = ", ";
  protected final String TEXT_475 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_476 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_477 = ".addCellValue((";
  protected final String TEXT_478 = ").doubleValue());";
  protected final String TEXT_479 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_480 = ".addCellValue(";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = ");";
  protected final String TEXT_483 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_484 = ".addCellValue(";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = ");";
  protected final String TEXT_487 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_488 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_489 = ".";
  protected final String TEXT_490 = ")));";
  protected final String TEXT_491 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_492 = ".addCellValue(String.valueOf(";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = "));";
  protected final String TEXT_495 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_496 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_497 = NL + "\t\t\t\t}";
  protected final String TEXT_498 = NL + "\t\t\t\t}";
  protected final String TEXT_499 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_500 = " fileOutputExcelUtil_";
  protected final String TEXT_501 = "=new FileOutputExcelUtil_";
  protected final String TEXT_502 = "();";
  protected final String TEXT_503 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_504 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_505 = NL + "\t\txlsxTool_";
  protected final String TEXT_506 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_507 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_508 = ".putHeaderValue_";
  protected final String TEXT_509 = "(xlsxTool_";
  protected final String TEXT_510 = ");";
  protected final String TEXT_511 = NL + "\t\txlsxTool_";
  protected final String TEXT_512 = ".addCellValue(\"";
  protected final String TEXT_513 = "\");" + NL + "\t\t";
  protected final String TEXT_514 = NL + "\t\tnb_line_";
  protected final String TEXT_515 = "++; " + NL + "\t\t";
  protected final String TEXT_516 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_517 = NL;

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
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
			}
		}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_60);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    
			} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    
			}
		}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_105);
    }else{
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    if(font !=null && font.length()!=0){
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(font !=null && font.length()!=0){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_136);
    
					}else{

    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_140);
    	
					}
				}else{

    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_144);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_147);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_160);
    
			}else{

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_167);
    
			}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_176);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_177);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_178);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
				}
			}
			
			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_183);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_189);
    }else{
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
    
            		}
        		}
     		}
     		
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_201);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_202);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
			}

    stringBuffer.append(TEXT_212);
    stringBuffer.append(TEXT_213);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_214);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_216);
    
    				} 
    				
    stringBuffer.append(TEXT_217);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
   				
    stringBuffer.append(TEXT_218);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_219);
    if(keepCellFormating){
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    }
    stringBuffer.append(TEXT_228);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    }else{
    stringBuffer.append(TEXT_236);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_244);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_251);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_256);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_257);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_259);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_260);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_261);
     } else { 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_266);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_268);
    
					}else {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_272);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
							}
							
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
					if(isNumber){

    stringBuffer.append(TEXT_284);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
					}else{

    stringBuffer.append(TEXT_295);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
					}else{

    stringBuffer.append(TEXT_311);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_325);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_326);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_327);
    
     	}

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
	}//TD64

    stringBuffer.append(TEXT_332);
    
if(isIncludeHeader){
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_335);
    
	}else{

    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    
	}

    stringBuffer.append(TEXT_338);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
        		} else {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_354);
    }
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_357);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_363);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_365);
    
		}else{

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_370);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_372);
    
		}

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_381);
    
	}

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    
}

    stringBuffer.append(TEXT_384);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_387);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    
					}
				}
			}

    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    		
		}
		
		boolean recalculateFormula = "true".equals(ElementParameterParser.getValue(node,"__RECALCULATE_FORMULA__"));

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(recalculateFormula);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_415);
    if(!useStream){
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    }else{
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    }
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_423);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_426);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    
    			}

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_431);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_432);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_433);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
        			
					}
    			}
    			
    			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_439);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_442);
    
            		}
    			}
    			
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_443);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_444);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_445);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
        			
    			}

    stringBuffer.append(TEXT_450);
    stringBuffer.append(TEXT_451);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_452);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_454);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_459);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_463);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_464);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_467);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_468);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_469);
     } else { 
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_473);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_474);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_475);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_478);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_482);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_486);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_490);
    
					}else{	

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_494);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_497);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_498);
        		
    		}

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    
		}//TD1
		
		if(isIncludeHeader){
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    
			}
		
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_513);
    
			}
		
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_516);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_517);
    return stringBuffer.toString();
  }
}
