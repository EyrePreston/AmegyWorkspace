package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

public class TFileOutputDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedMainJava result = new TFileOutputDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    \t\t\t\tStringBuilder sb_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "    \t\t        ";
  protected final String TEXT_5 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_7 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t        \t\tif(isFirstCheckDyn_";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "&& (file_";
  protected final String TEXT_11 = ".length()==0)";
  protected final String TEXT_12 = "){" + NL + "\t                \t";
  protected final String TEXT_13 = NL + "    \t\t        if(isFirstCheckDyn_";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = "&& file";
  protected final String TEXT_16 = ".length()==0";
  protected final String TEXT_17 = "){" + NL + "        \t\t        ";
  protected final String TEXT_18 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_19 = ".putHeaderValue_";
  protected final String TEXT_20 = "(out";
  protected final String TEXT_21 = ",OUT_DELIM_";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "    \t\t        \tout";
  protected final String TEXT_25 = ".write(\"";
  protected final String TEXT_26 = "\");" + NL + "        \t\t         ";
  protected final String TEXT_27 = NL + "\t    \t\t        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ", out";
  protected final String TEXT_30 = ", OUT_DELIM_";
  protected final String TEXT_31 = "); " + NL + "    \t    \t\t     ";
  protected final String TEXT_32 = NL + "                        out";
  protected final String TEXT_33 = ".write(OUT_DELIM_";
  protected final String TEXT_34 = ");" + NL + "        \t\t         ";
  protected final String TEXT_35 = NL + "                        out";
  protected final String TEXT_36 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_37 = ");" + NL + "                        isFirstCheckDyn_";
  protected final String TEXT_38 = " = false;" + NL + "    \t\t        }" + NL + "\t\t        ";
  protected final String TEXT_39 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_40 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_41 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "    \t\t                    ";
  protected final String TEXT_43 = NL + "                            fileOutputDelimitedUtil_";
  protected final String TEXT_44 = ".putValue_";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ",sb_";
  protected final String TEXT_47 = ",OUT_DELIM_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = "   \t\t\t\t" + NL + "    \t    \t\t\t\tif(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " != null) {" + NL + "        \t\t\t\t    ";
  protected final String TEXT_52 = NL + "    \t\t\t\t    routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ", sb_";
  protected final String TEXT_55 = ", OUT_DELIM_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "    \t\t\t\t\tsb_";
  protected final String TEXT_58 = ".append(" + NL + "    \t\t\t        ";
  protected final String TEXT_59 = NL + "    \t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ")" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_65 = ".toPlainString(), ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ")).toPlainString(), ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_74 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_75 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "    \t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_77 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ")).toString()" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "    \t\t\t\t\t);" + NL + "    \t\t\t\t\t";
  protected final String TEXT_84 = NL + "    \t\t\t\t\t    } " + NL + "    \t\t\t\t\t";
  protected final String TEXT_85 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_86 = ".append(OUT_DELIM_";
  protected final String TEXT_87 = ");" + NL + "    \t\t\t            ";
  protected final String TEXT_88 = NL + "    \t\t        sb_";
  protected final String TEXT_89 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_90 = ");" + NL + "    \t\t" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_91 = NL + "    \t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "    \t\t\t\t";
  protected final String TEXT_92 = NL + "    \t\t\t\tsynchronized (lockWrite) {" + NL + "    \t\t        ";
  protected final String TEXT_93 = NL + "\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "    \t\t        nb_line_";
  protected final String TEXT_95 = "++;" + NL + "    \t\t        resourceMap.put(\"nb_line_";
  protected final String TEXT_96 = "\", nb_line_";
  protected final String TEXT_97 = ");" + NL + "    \t\t        ";
  protected final String TEXT_98 = NL + "    \t\t            if(currentRow_";
  protected final String TEXT_99 = " % splitEvery_";
  protected final String TEXT_100 = "==0 && currentRow_";
  protected final String TEXT_101 = "!=0){" + NL + "    \t\t                splitedFileNo_";
  protected final String TEXT_102 = "++;" + NL + "    \t\t                out";
  protected final String TEXT_103 = ".close(); " + NL + "    \t\t                //close original outputStream" + NL + "    \t\t                " + NL + "    \t\t                file";
  protected final String TEXT_104 = " = new java.io.File(fullName_";
  protected final String TEXT_105 = " + splitedFileNo_";
  protected final String TEXT_106 = " + extension_";
  protected final String TEXT_107 = ");  " + NL + "    \t\t                " + NL + "        \t    \t\t    ";
  protected final String TEXT_108 = NL + "        \t    \t\t    if(file";
  protected final String TEXT_109 = ".exists()) {" + NL + "        \t\t    \t\t\tfile";
  protected final String TEXT_110 = ".delete();" + NL + "        \t    \t\t    }" + NL + "        \t    \t\t    ";
  protected final String TEXT_111 = "\t" + NL + "    \t\t                out";
  protected final String TEXT_112 = " = new ";
  protected final String TEXT_113 = "(new java.io.OutputStreamWriter(" + NL + "    \t\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_114 = " + splitedFileNo_";
  protected final String TEXT_115 = " + extension_";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = "),";
  protected final String TEXT_118 = "));" + NL + "    \t\t                ";
  protected final String TEXT_119 = NL + "    \t\t                    if(file";
  protected final String TEXT_120 = ".length()==0){  " + NL + "    \t\t                        ";
  protected final String TEXT_121 = NL + "                            \t\t\tfileOutputDelimitedUtil_";
  protected final String TEXT_122 = ".putHeaderValue_";
  protected final String TEXT_123 = "(out";
  protected final String TEXT_124 = ",OUT_DELIM_";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "    \t\t                            out";
  protected final String TEXT_128 = ".write(\"";
  protected final String TEXT_129 = "\");" + NL + "    \t\t                            ";
  protected final String TEXT_130 = NL + "\t    \t\t            \t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = ", out";
  protected final String TEXT_133 = ", OUT_DELIM_";
  protected final String TEXT_134 = "); " + NL + "\t    \t\t            \t\t\t";
  protected final String TEXT_135 = NL + "    \t\t                                out";
  protected final String TEXT_136 = ".write(OUT_DELIM_";
  protected final String TEXT_137 = ");" + NL + "    \t\t                                ";
  protected final String TEXT_138 = NL + "    \t\t                        out";
  protected final String TEXT_139 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_140 = ");" + NL + "    \t\t                    }\t" + NL + "    \t\t                    ";
  protected final String TEXT_141 = NL + "    \t\t                out";
  protected final String TEXT_142 = ".write(sb_";
  protected final String TEXT_143 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_144 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_145 = "%";
  protected final String TEXT_146 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_147 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_148 = " \t\t\t" + NL + "    \t\t            }else{" + NL + "    \t\t                out";
  protected final String TEXT_149 = ".write(sb_";
  protected final String TEXT_150 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_151 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_152 = "%";
  protected final String TEXT_153 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_154 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_155 = "  \t\t\t" + NL + "    \t\t            }\t" + NL + "    \t\t            currentRow_";
  protected final String TEXT_156 = "++;\t\t\t\t" + NL + "    \t\t\t" + NL + "    " + NL + "    \t\t            ";
  protected final String TEXT_157 = NL + "    \t\t" + NL + "    \t\t            out";
  protected final String TEXT_158 = ".write(sb_";
  protected final String TEXT_159 = ".toString());" + NL + "    \t\t            ";
  protected final String TEXT_160 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_161 = "%";
  protected final String TEXT_162 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_163 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                ";
  protected final String TEXT_164 = "     \t\t\t" + NL + "    \t\t            ";
  protected final String TEXT_165 = NL + "\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_167 = " - Writing the record \" + nb_line_";
  protected final String TEXT_168 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t" + NL + "    \t\t        ";
  protected final String TEXT_170 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_171 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_172 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_173 = " \t\t\t" + NL + "    \t\t        " + NL + "    \t\t        ";
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = NL;
  protected final String TEXT_176 = NL + "        \t    dynamic_column_count_";
  protected final String TEXT_177 = " = 1;" + NL + "        \t    ";
  protected final String TEXT_178 = NL + "\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_180 = NL + "        \t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "        \t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "        \t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_182 = " ";
  protected final String TEXT_183 = "&& (file_";
  protected final String TEXT_184 = ".length()==0)";
  protected final String TEXT_185 = "){" + NL + "        \t\t\t\t\theadColu";
  protected final String TEXT_186 = " = new String[";
  protected final String TEXT_187 = "-1+";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = ".getColumnCount()];" + NL + "            \t\t\t\t";
  protected final String TEXT_190 = NL + "            \t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_191 = " ";
  protected final String TEXT_192 = "&& file";
  protected final String TEXT_193 = ".length()==0";
  protected final String TEXT_194 = "){" + NL + "            \t\t\t\theadColu";
  protected final String TEXT_195 = " = new String[";
  protected final String TEXT_196 = "-1+";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = ".getColumnCount()];" + NL + "            \t\t\t";
  protected final String TEXT_199 = NL + "                                    dynamic_column_count_";
  protected final String TEXT_200 = " = ";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = ".getColumnCount();";
  protected final String TEXT_203 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_204 = ".putHeaderValue_";
  protected final String TEXT_205 = "(headColu";
  protected final String TEXT_206 = ", ";
  protected final String TEXT_207 = ",dynamic_column_count_";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "        \t\t        \theadColu";
  protected final String TEXT_210 = "[";
  protected final String TEXT_211 = "+dynamic_column_count_";
  protected final String TEXT_212 = "]=\"";
  protected final String TEXT_213 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_214 = NL + "        \t\t        \theadColu";
  protected final String TEXT_215 = "[";
  protected final String TEXT_216 = "]=\"";
  protected final String TEXT_217 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_218 = NL + "        \t    \t\t     for(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_219 = ";mi++){" + NL + "        \t    \t\t     \theadColu";
  protected final String TEXT_220 = "[";
  protected final String TEXT_221 = "+mi]=";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     }" + NL + "        \t    \t\t     ";
  protected final String TEXT_224 = NL + "                            CsvWriter";
  protected final String TEXT_225 = ".writeNext(headColu";
  protected final String TEXT_226 = ");" + NL + "        \t            \tCsvWriter";
  protected final String TEXT_227 = ".flush();" + NL + "        \t            \t";
  protected final String TEXT_228 = NL + "        \t            \tout";
  protected final String TEXT_229 = ".write(strWriter";
  protected final String TEXT_230 = ".getBuffer().toString());" + NL + "        \t            \tout";
  protected final String TEXT_231 = ".flush();" + NL + "        \t            \tstrWriter";
  protected final String TEXT_232 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_233 = ".getBuffer().length()); \t" + NL + "                    \t\t";
  protected final String TEXT_234 = NL + "        \t            }" + NL + "            \t        ";
  protected final String TEXT_235 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_236 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_237 = NL + "\t\t\t\t\t}" + NL + "            \t\t\t";
  protected final String TEXT_238 = NL + "        \t            if(isFirstCheckDyn_";
  protected final String TEXT_239 = "){" + NL + "                    \t\tCsvWriter";
  protected final String TEXT_240 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_241 = ".getEscapeChar());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_242 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_243 = ".getTextEnclosure());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_244 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "                    \t\tisFirstCheckDyn_";
  protected final String TEXT_245 = " = false;" + NL + "                    \t}";
  protected final String TEXT_246 = "  \t" + NL + "                    \tString[] row";
  protected final String TEXT_247 = "=new String[";
  protected final String TEXT_248 = "];\t\t" + NL + "                    \t";
  protected final String TEXT_249 = NL + "                    \tdynamic_column_count_";
  protected final String TEXT_250 = " =1;" + NL + "                    \t";
  protected final String TEXT_251 = NL + "                \t\t\t    dynamic_column_count_";
  protected final String TEXT_252 = " = ";
  protected final String TEXT_253 = ".";
  protected final String TEXT_254 = ".getColumnCount();" + NL + "                \t\t\t    ";
  protected final String TEXT_255 = NL + "                            \tfileOutputDelimitedUtil_";
  protected final String TEXT_256 = ".putValue_";
  protected final String TEXT_257 = "(";
  protected final String TEXT_258 = ",row";
  protected final String TEXT_259 = ",dynamic_column_count_";
  protected final String TEXT_260 = " ";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "                            if (";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " != null) {" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = ", row";
  protected final String TEXT_267 = ", ";
  protected final String TEXT_268 = ");" + NL + "                            }" + NL + "                \t\t\t";
  protected final String TEXT_269 = " " + NL + "                \t\t\trow";
  protected final String TEXT_270 = "[";
  protected final String TEXT_271 = "+dynamic_column_count_";
  protected final String TEXT_272 = "]=";
  protected final String TEXT_273 = NL + "                \t\t\trow";
  protected final String TEXT_274 = "[";
  protected final String TEXT_275 = "]=";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = ";" + NL + "                \t\t\t";
  protected final String TEXT_278 = "FormatterUtils.format_Date(";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = ", ";
  protected final String TEXT_281 = ");" + NL + "                \t\t\t";
  protected final String TEXT_282 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = ")).toString();" + NL + "                \t\t\t";
  protected final String TEXT_285 = "FormatterUtils.format_Number(";
  protected final String TEXT_286 = ".toPlainString(), ";
  protected final String TEXT_287 = ", ";
  protected final String TEXT_288 = ");\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_289 = "FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = ")).toPlainString(), ";
  protected final String TEXT_292 = ", ";
  protected final String TEXT_293 = ");\t\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_294 = ".toPlainString();" + NL + "                \t\t\t";
  protected final String TEXT_295 = "String.valueOf(";
  protected final String TEXT_296 = ".";
  protected final String TEXT_297 = ");" + NL + "                \t\t\t";
  protected final String TEXT_298 = NL + "    \t\t\tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_299 = NL + "\t\t\t\tsynchronized (lockWrite) {";
  protected final String TEXT_300 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {";
  protected final String TEXT_301 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_302 = "++;" + NL + "\t\t\t\tresourceMap.put(\"nb_line_";
  protected final String TEXT_303 = "\", nb_line_";
  protected final String TEXT_304 = ");";
  protected final String TEXT_305 = NL + "            \t\t\t    if(currentRow_";
  protected final String TEXT_306 = " % splitEvery_";
  protected final String TEXT_307 = "==0 && currentRow_";
  protected final String TEXT_308 = "!=0){" + NL + "            \t\t\t        splitedFileNo_";
  protected final String TEXT_309 = "++;" + NL + "            \t\t\t        CsvWriter";
  protected final String TEXT_310 = ".close(); " + NL + "            \t\t\t        //close original outputStream" + NL + "            \t\t\t        " + NL + "            \t    \t\t    ";
  protected final String TEXT_311 = NL + "        \t\t    \t\t    java.io.File fileToDelete_";
  protected final String TEXT_312 = " = new java.io.File(fullName_";
  protected final String TEXT_313 = " + splitedFileNo_";
  protected final String TEXT_314 = " + extension_";
  protected final String TEXT_315 = ");" + NL + "        \t\t    \t\t    if(fileToDelete_";
  protected final String TEXT_316 = ".exists()) {" + NL + "        \t\t    \t\t    \tfileToDelete_";
  protected final String TEXT_317 = ".delete();" + NL + "        \t\t    \t\t    }" + NL + "            \t    \t\t    ";
  protected final String TEXT_318 = NL + "            \t    \t\t    " + NL + "            \t\t\t        ";
  protected final String TEXT_319 = NL + "            \t\t\t        out";
  protected final String TEXT_320 = ".close();" + NL + "            \t\t\t        out";
  protected final String TEXT_321 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_322 = " + splitedFileNo_";
  protected final String TEXT_323 = " + extension_";
  protected final String TEXT_324 = ", ";
  protected final String TEXT_325 = "),";
  protected final String TEXT_326 = "));" + NL + "\t\t\t\t\t\t\t\tstrWriter";
  protected final String TEXT_327 = " = new java.io.StringWriter();" + NL + "            \t                CsvWriter";
  protected final String TEXT_328 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_329 = ");" + NL + "            \t                CsvWriter";
  protected final String TEXT_330 = ".setSeparator(csvSettings_";
  protected final String TEXT_331 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_332 = NL + "            \t                CsvWriter";
  protected final String TEXT_333 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_334 = " + splitedFileNo_";
  protected final String TEXT_335 = " + extension_";
  protected final String TEXT_336 = ", ";
  protected final String TEXT_337 = "),";
  protected final String TEXT_338 = ")));" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_339 = ".setSeparator(csvSettings_";
  protected final String TEXT_340 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_341 = NL + "            \t                " + NL + "            \t                ";
  protected final String TEXT_342 = NL + "\t\t\t\t       \t    \tif(csvSettings_";
  protected final String TEXT_343 = ".isUseCRLFRecordDelimiter()) {" + NL + "\t\t\t\t    \t    \t\tCsvWriter";
  protected final String TEXT_344 = ".setLineEnd(\"\\r\\n\");" + NL + "\t\t\t\t    \t    \t} else {" + NL + "\t\t\t\t    \t    \t\tCsvWriter";
  protected final String TEXT_345 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_346 = ".getRowDelim());" + NL + "\t\t\t\t    \t    \t}" + NL + "\t\t\t\t    \t    \t";
  protected final String TEXT_347 = NL + "\t\t\t\t    \t    \tif(!csvSettings_";
  protected final String TEXT_348 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_349 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_350 = ".getRowDelim()!='\\n') {" + NL + "\t\t\t\t\t    \t\t\tCsvWriter";
  protected final String TEXT_351 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_352 = ".getRowDelim());" + NL + "\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t    \t    \t";
  protected final String TEXT_353 = NL + "            \t                " + NL + "            \t\t\t        //set header." + NL + "            \t\t\t        ";
  protected final String TEXT_354 = NL + "            \t\t\t            CsvWriter";
  protected final String TEXT_355 = ".writeNext(headColu";
  protected final String TEXT_356 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_357 = "\t" + NL + "            \t\t\t            out";
  protected final String TEXT_358 = ".write(strWriter";
  protected final String TEXT_359 = ".getBuffer().toString());" + NL + "               \t\t\t\t\t\tstrWriter";
  protected final String TEXT_360 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_361 = ".getBuffer().length());" + NL + "            \t\t\t            ";
  protected final String TEXT_362 = NL + "                                    file";
  protected final String TEXT_363 = " = new java.io.File(fullName_";
  protected final String TEXT_364 = " + splitedFileNo_";
  protected final String TEXT_365 = " + extension_";
  protected final String TEXT_366 = ");" + NL + "                        \t\t    if(file";
  protected final String TEXT_367 = ".length() == 0) {" + NL + "                        \t\t        CsvWriter";
  protected final String TEXT_368 = ".writeNext(headColu";
  protected final String TEXT_369 = "); " + NL + "                        \t\t        ";
  protected final String TEXT_370 = NL + "                        \t\t        out";
  protected final String TEXT_371 = ".write(strWriter";
  protected final String TEXT_372 = ".getBuffer().toString());" + NL + "                \t\t\t\t\t\tstrWriter";
  protected final String TEXT_373 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_374 = ".getBuffer().length());" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_375 = NL + "                       \t\t    \t}\t  " + NL + "                        \t\t    ";
  protected final String TEXT_376 = NL + "                        \t\t//initialize new CsvWriter information" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_377 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_378 = ".getEscapeChar());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_379 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_380 = ".getTextEnclosure());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_381 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "\t\t\t\t\t      \t\t        \t\t" + NL + "                        \t\tCsvWriter";
  protected final String TEXT_382 = ".writeNext(row";
  protected final String TEXT_383 = ");" + NL + "                        \t\t";
  protected final String TEXT_384 = NL + "                        \t\tout";
  protected final String TEXT_385 = ".write(strWriter";
  protected final String TEXT_386 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_387 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_388 = ".getBuffer().length());" + NL + "                        \t\t";
  protected final String TEXT_389 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_390 = "%";
  protected final String TEXT_391 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_392 = NL + "            \t\t                out";
  protected final String TEXT_393 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_394 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_395 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_396 = NL + "            \t\t                }" + NL + "                        \t\t    ";
  protected final String TEXT_397 = " " + NL + "         \t\t\t\t" + NL + "         \t\t\t\t\t}else{" + NL + "         \t\t\t\t\t    CsvWriter";
  protected final String TEXT_398 = ".writeNext(row";
  protected final String TEXT_399 = ");\t" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_400 = NL + "         \t\t\t\t\t    out";
  protected final String TEXT_401 = ".write(strWriter";
  protected final String TEXT_402 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_403 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_404 = ".getBuffer().length());" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_405 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_406 = "%";
  protected final String TEXT_407 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_408 = NL + "            \t\t                out";
  protected final String TEXT_409 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_410 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_411 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_412 = NL + "            \t\t                }" + NL + "         \t\t\t\t\t        ";
  protected final String TEXT_413 = "  \t\t\t\t\t" + NL + "         \t\t\t\t\t}\t" + NL + "            \t\t\t    currentRow_";
  protected final String TEXT_414 = "++;\t\t" + NL + "             \t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_415 = NL + "            \t\t\t    CsvWriter";
  protected final String TEXT_416 = ".writeNext(row";
  protected final String TEXT_417 = ");\t" + NL + "            \t\t\t    ";
  protected final String TEXT_418 = NL + "            \t\t\t    out";
  protected final String TEXT_419 = ".write(strWriter";
  protected final String TEXT_420 = ".getBuffer().toString());" + NL + "                \t\t\tstrWriter";
  protected final String TEXT_421 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_422 = ".getBuffer().length());" + NL + "            \t\t\t    ";
  protected final String TEXT_423 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_424 = "%";
  protected final String TEXT_425 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_426 = NL + "            \t\t                out";
  protected final String TEXT_427 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_428 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_429 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_430 = NL + "            \t\t                }" + NL + "            \t\t\t        ";
  protected final String TEXT_431 = "  \t\t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_432 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_433 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_434 = " - Writing the record \" + nb_line_";
  protected final String TEXT_435 = " + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_437 = NL + "    \t\t\t} ";
  protected final String TEXT_438 = NL + "\t\t\t\t}";
  protected final String TEXT_439 = NL + "    \t\t\t}";
  protected final String TEXT_440 = NL + "            \t\t\t" + NL + "            \t\t\t";
  protected final String TEXT_441 = NL;
  protected final String TEXT_442 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
int dynamic_column_index=-1;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_2);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                        
            
            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );
            
            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
            
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
    		boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
            
            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
            
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
			String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
			
			boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
			
			boolean hasDynamic = metadata.isDynamicSchema();

        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	for (IConnection conn : conns) {
        		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        			List<IMetadataColumn> columns = metadata.getListColumns();
        			int sizeColumns = columns.size();
        		    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	                if(isIncludeHeader && hasDynamic){
						if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_5);
    
    					}
    					if (NodeUtil.subBranchContainsParallelIterate(node)) {
				
    stringBuffer.append(TEXT_6);
     
    		        	}
    		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_7);
     
						}
	                	if(!split && compress && !isAppend){
	                	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(!useStream){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    
	                	}else{
    		        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if(!useStream){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
        		        }
                    	for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){
								
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    
                            	}
                            }else{//AA
                            if(!("id_Dynamic".equals(column.getTalendType()))) {
        		         
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
        		            }else{
    	    		     
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
        		            }
        		            if(i != sizeColumns - 1) {
        		         
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
                            }
                            }//AA
                        }
        		        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
     
		        		if (isParallelize) {
				
    stringBuffer.append(TEXT_39);
    
		        		}
						if (NodeUtil.subBranchContainsParallelIterate(node)) {
				
    stringBuffer.append(TEXT_40);
    
		        		}
		        		if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_41);
    
						}
		        
    stringBuffer.append(TEXT_42);
    
    		        }					  
        			for (int i = 0; i < sizeColumns; i++) {
      			
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    					if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
                            }
                        }else{//BB
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){
    				    	dynamic_column_index = i;

    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
    				    }else{
    				    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    			            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_62);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_63);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_67);
     } else { 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
    
							} else if(javaType == JavaTypesManager.BIGDECIMAL){
    						
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_75);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){
    						
    stringBuffer.append(TEXT_76);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
    			        	} else {
    			            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    				
    			        	}
    			        
    stringBuffer.append(TEXT_83);
    
    					}
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_84);
    
    			        } 
    			        if(i != sizeColumns - 1) {
    			            
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
    			        }
    			        }//BB
    		        }
    		        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
    					if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_91);
    
    					}
    					if (NodeUtil.subBranchContainsParallelIterate(node)) {
    				
    stringBuffer.append(TEXT_92);
     
    		        	}
    		        	if (isParallelize) {
  					
    stringBuffer.append(TEXT_93);
     
						}
    		        
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
    		        // add a prerequisite useStream to support output stream feature:8873
    		        if(!useStream && split){ 
    		            
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    if(!isAppend) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(isInRowMode?"routines.system.BufferedOutput":"java.io.BufferedWriter");
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_117);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_118);
    
    		                if(isIncludeHeader){
    		                    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    		
    		                        //List<IMetadataColumn> columns = metadata.getListColumns();
    		                        //int sizeColumns = columns.size();
    		                        for (int i = 0; i < sizeColumns; i++) {
    		                            IMetadataColumn column = columns.get(i);
										if(sizeColumns> schemaOptNum){
                            				if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    if(hasDynamic){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_126);
    
                            				}
                           			 	}else{//CC
    		                            if(!("id_Dynamic".equals(column.getTalendType()))) {
    		                            
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_129);
    
    		                            }else{
	    		            			
    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
    		                            }
    		                            if(i != sizeColumns - 1) {
    		                                
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
    		                            }
    		                            }//CC
    		                        }
    		                        
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
    		                }
    		                
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
    		                }
    		                
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    
    		                }
    		                
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
     
    		        } else { 
    		            
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
     
    		            if(flushOnRow) { 
    		                
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
    		            }
    		            
    stringBuffer.append(TEXT_164);
    
    		        }
    		        
    stringBuffer.append(TEXT_165);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
     
    		        	if (isParallelize) {
    				
    stringBuffer.append(TEXT_170);
    
    		        	}
    					if (NodeUtil.subBranchContainsParallelIterate(node)) {
    				
    stringBuffer.append(TEXT_171);
    
    		        	}
    		        	if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_172);
    
    					}
    		        
    stringBuffer.append(TEXT_173);
    
    	        }
            }
        }
    }
    
    stringBuffer.append(TEXT_174);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_175);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                                    
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
        	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

        	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
        	
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        	
        	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        	
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        	
        	
        	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
        	
        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	
        	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        	
        	boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));
        	
        	boolean hasDynamic = metadata.isDynamicSchema();
        	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
        	if(hasDynamic){
        	    
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
        	}
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        				List<IMetadataColumn> columns = metadata.getListColumns();
            			int sizeColumns = columns.size();
            			if(isIncludeHeader && hasDynamic){

							if(codeGenArgument.getIsRunInMultiThread()){
							
    stringBuffer.append(TEXT_178);
    
            				}
            				if (NodeUtil.subBranchContainsParallelIterate(node)) {
							
    stringBuffer.append(TEXT_179);
     
            	        	}
            	        	if (isParallelize) {
							
    stringBuffer.append(TEXT_180);
     
							}
            				if(!split && compress && !isAppend){
            				
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    if(!useStream){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_189);
    
            				}else{
            			
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    if(!useStream){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_198);
    
            				}
                        	for (int i = 0; i < sizeColumns; i++) {
                                IMetadataColumn column = columns.get(i);
                                if(("id_Dynamic").equals(column.getTalendType())) {
                                    
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_202);
    
                                }
								if(sizeColumns> schemaOptNum){
                            		if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
                            		}
                            	}else{//DD
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                	if(i>dynamic_column_index&& dynamic_column_index != -1){
            		         
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    
            		         		}else{
            		         
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    
            		         		}
            		            }else{
            		            dynamic_column_index = i;
        	    		     
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_223);
    
            		            }
            		            }//DD
                            }
                            
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    if(isInRowMode){
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
     
            	        	if (isParallelize) {
            			
    stringBuffer.append(TEXT_235);
    
            	        	}
            				if (NodeUtil.subBranchContainsParallelIterate(node)) {
            			
    stringBuffer.append(TEXT_236);
    
            	        	}
            	        	if(codeGenArgument.getIsRunInMultiThread()){
            			
    stringBuffer.append(TEXT_237);
    
            				}
            	        
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
            			}
            			
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(hasDynamic?"+"+conn.getName()+".":"" );
    stringBuffer.append(dynamicCol==null?"":dynamicCol.getLabel()+".getColumnCount()-1" );
    stringBuffer.append(TEXT_248);
    
                    	if(hasDynamic){
                    	
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
                    	}
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_254);
    
                			}
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    
                            	}
                            }else{//EE
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			    dynamic_column_index=i;
                			
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(dynamic_column_index);
    stringBuffer.append(TEXT_268);
    
                			}else{
                				if(i>dynamic_column_index && dynamic_column_index !=-1){
                			
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				}else{
                			
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				}
                				if(javaType == JavaTypesManager.STRING ){
                			
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_277);
    
                				}else if(javaType == JavaTypesManager.DATE && pattern != null){
                			
    stringBuffer.append(TEXT_278);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_281);
    
                				}else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			
    stringBuffer.append(TEXT_282);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    
                				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        							if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_285);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_286);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_287);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_288);
      	} else { 
    stringBuffer.append(TEXT_289);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_292);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_293);
    		}
        						} else if (javaType == JavaTypesManager.BIGDECIMAL) {
							
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_294);
    
                			 	} else{
                			
    stringBuffer.append(TEXT_295);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_297);
    
                				}
                			}
                			}//EE
            			}

        					if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_298);
    
    					}
    					if (NodeUtil.subBranchContainsParallelIterate(node)) {

    stringBuffer.append(TEXT_299);
    
						}
						if (isParallelize) {

    stringBuffer.append(TEXT_300);
    
						}

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
            			if(!useStream && split){
            			    
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    if(!isAppend) {
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    }
    stringBuffer.append(TEXT_318);
    if(isInRowMode){
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    }else{
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    }
    stringBuffer.append(TEXT_341);
    
            	                if(!useOSLineSeparator) {
								
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    
				    	    	} else {
				    	    	
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
				    	    	}
            	                
    stringBuffer.append(TEXT_353);
    
            			        if(isIncludeHeader && !isAppend){
            			            
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    if(isInRowMode){
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    }
            			        }
            			        if(isIncludeHeader && isAppend){
            			            
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    if(isInRowMode){
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    
            			        }
                        		
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    if(isInRowMode){
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    }
                        		if(flushOnRow) { 
                        		    
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_391);
    if(isInRowMode){
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    }else{
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    }
    stringBuffer.append(TEXT_396);
    
                    			}
                        		
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    if(isInRowMode){
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    }
         					    if(flushOnRow) { 
         					        
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_407);
    if(isInRowMode){
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    }else{
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    }
    stringBuffer.append(TEXT_412);
    
         					    }
         					    
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    
            			}else{
            			    
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    if(isInRowMode){
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    }
            			    if(flushOnRow) { 
            			        
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_425);
    if(isInRowMode){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    }else{
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    }
    stringBuffer.append(TEXT_430);
    
                			}
            			    
    stringBuffer.append(TEXT_431);
       		
            		
            			}
            			
    stringBuffer.append(TEXT_432);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    }
    stringBuffer.append(TEXT_436);
     
						if ( isParallelize) {

    stringBuffer.append(TEXT_437);
    
    		        	}
    					if (NodeUtil.subBranchContainsParallelIterate(node)) {

    stringBuffer.append(TEXT_438);
    
						}
						if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_439);
    
    					}

    stringBuffer.append(TEXT_440);
       		
            		}
        		
        		}
        	}	
    	
        }
    
    }
    
    stringBuffer.append(TEXT_441);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_442);
    return stringBuffer.toString();
  }
}
