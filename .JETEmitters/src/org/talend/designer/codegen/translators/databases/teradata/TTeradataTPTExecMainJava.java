package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Arrays;

public class TTeradataTPTExecMainJava
{
  protected static String nl;
  public static synchronized TTeradataTPTExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataTPTExecMainJava result = new TTeradataTPTExecMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_33 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_34 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\tconn_";
  protected final String TEXT_36 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_37 = ", dbUser_";
  protected final String TEXT_38 = ", dbPwd_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\tconn_";
  protected final String TEXT_43 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\tconn_";
  protected final String TEXT_45 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\tconn_";
  protected final String TEXT_47 = ".setAutoCommit(";
  protected final String TEXT_48 = ");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tlog.";
  protected final String TEXT_50 = "(\"";
  protected final String TEXT_51 = " - \" + ";
  protected final String TEXT_52 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t    \t\tlog.";
  protected final String TEXT_54 = "(\"";
  protected final String TEXT_55 = "\");" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_57 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_59 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_60 = ": pstmt_";
  protected final String TEXT_61 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_62 = " += (countEach_";
  protected final String TEXT_63 = " < 0 ? 0 : ";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "String tableFullName_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = " + \".\" + ";
  protected final String TEXT_68 = ";" + NL + "java.io.File file_";
  protected final String TEXT_69 = " = new java.io.File(";
  protected final String TEXT_70 = "+";
  protected final String TEXT_71 = "+ ";
  protected final String TEXT_72 = "\".script\"";
  protected final String TEXT_73 = "\".scr\"";
  protected final String TEXT_74 = ");" + NL;
  protected final String TEXT_75 = NL + "\t   String logTable_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = " + \".\" +";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + "try{" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t    ";
  protected final String TEXT_82 = NL + NL + "\t\t\t\tjava.io.FileWriter fw_";
  protected final String TEXT_83 = " = new java.io.FileWriter(file_";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_85 = ".write(\"DEFINE JOB \"+";
  protected final String TEXT_86 = "+\"";
  protected final String TEXT_87 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_88 = ".write(\"  (\"+\"";
  protected final String TEXT_89 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tfw_";
  protected final String TEXT_91 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_92 = "+\"";
  protected final String TEXT_93 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_94 = ".write(\"  \tTYPE LOAD";
  protected final String TEXT_95 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_96 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_97 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_98 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_99 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_100 = ".write(\"  \t(";
  protected final String TEXT_101 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_102 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_103 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_104 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_105 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_106 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_107 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_108 = ".write(\"  \t\tVARCHAR TargetTable, ";
  protected final String TEXT_109 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_110 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_111 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_112 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_113 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_114 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_115 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_116 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_117 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_118 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_119 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_120 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_121 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_122 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_123 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_124 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_125 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_126 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_127 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_128 = ".write(\"  \t\tVARCHAR ErrorTable1, ";
  protected final String TEXT_129 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_130 = ".write(\"  \t\tVARCHAR ErrorTable2, ";
  protected final String TEXT_131 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_132 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_133 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_134 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_135 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_136 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_137 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_138 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_139 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_140 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_141 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_142 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_143 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_144 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_145 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_146 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_147 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_148 = ".write(\"  \t\tVARCHAR PauseAcq, ";
  protected final String TEXT_149 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_150 = ".write(\"  \t\tVARCHAR PrivateLogName,";
  protected final String TEXT_151 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_152 = ".write(\"  \t\tVARCHAR QueryBandSessInfo,";
  protected final String TEXT_153 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_154 = ".write(\"  \t\tVARCHAR TdpId, ";
  protected final String TEXT_155 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_156 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_157 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_158 = ".write(\"  \t\tVARCHAR WildcardInsert, ";
  protected final String TEXT_159 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_160 = ".write(\"  \t\tVARCHAR WorkingDatabase";
  protected final String TEXT_161 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_162 = ".write(\"  \t);";
  protected final String TEXT_163 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_164 = ".write(\"  ";
  protected final String TEXT_165 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\tfw_";
  protected final String TEXT_167 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_168 = "+\"";
  protected final String TEXT_169 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_170 = ".write(\"  \tTYPE INSERTER";
  protected final String TEXT_171 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_172 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_173 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_174 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_175 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_176 = ".write(\"  \t(";
  protected final String TEXT_177 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_178 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_179 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_180 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_181 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_182 = ".write(\"  \t\tVARCHAR Tdpid, ";
  protected final String TEXT_183 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_184 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_185 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_186 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_187 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_188 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_189 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_190 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_191 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_192 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_193 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_194 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_195 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_196 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_197 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_198 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_199 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_200 = ".write(\"  \t\tVARCHAR ReplicationOverride, ";
  protected final String TEXT_201 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_202 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_203 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_204 = ".write(\"  \t\tVARCHAR WorkingDatabase ";
  protected final String TEXT_205 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_206 = ".write(\"  \t);";
  protected final String TEXT_207 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_208 = ".write(\"  ";
  protected final String TEXT_209 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_210 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_211 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_212 = "+\"";
  protected final String TEXT_213 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_214 = ".write(\"  \tTYPE UPDATE";
  protected final String TEXT_215 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_216 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_217 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_218 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_219 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_220 = ".write(\"  \t(";
  protected final String TEXT_221 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_222 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_223 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_224 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_225 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_226 = ".write(\"  \t\tVARCHAR Tdpid, ";
  protected final String TEXT_227 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_228 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_229 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_230 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_231 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_232 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_233 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_234 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_235 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_236 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_237 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_238 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_239 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_240 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_241 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_242 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_243 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_244 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_245 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_246 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_247 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_248 = ".write(\"  \t\tVARCHAR AmpCheck, ";
  protected final String TEXT_249 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_250 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_251 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_252 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_253 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_254 = ".write(\"  \t\tVARCHAR DeleteTask, ";
  protected final String TEXT_255 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_256 = ".write(\"  \t\tVARCHAR DropErrorTable, ";
  protected final String TEXT_257 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_258 = ".write(\"  \t\tVARCHAR DropLogTable, ";
  protected final String TEXT_259 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_260 = ".write(\"  \t\tVARCHAR DropWorkTable, ";
  protected final String TEXT_261 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_262 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_263 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_264 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_265 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_266 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_267 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_268 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_269 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_270 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_271 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_272 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_273 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_274 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_275 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_276 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_277 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_278 = ".write(\"  \t\tVARCHAR PauseAcq, ";
  protected final String TEXT_279 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_280 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_281 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_282 = ".write(\"  \t\tVARCHAR QueueErrorTable, ";
  protected final String TEXT_283 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_284 = ".write(\"  \t\tVARCHAR ARRAY WorkTable, ";
  protected final String TEXT_285 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_286 = ".write(\"  \t\tVARCHAR WorkingDatabase, ";
  protected final String TEXT_287 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_288 = ".write(\"  \t\tVARCHAR ARRAY TargetTable, ";
  protected final String TEXT_289 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_290 = ".write(\"  \t\tVARCHAR ARRAY ErrorTable1, ";
  protected final String TEXT_291 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_292 = ".write(\"  \t\tVARCHAR ARRAY ErrorTable2 ";
  protected final String TEXT_293 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_294 = ".write(\"  \t);";
  protected final String TEXT_295 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_296 = ".write(\"  ";
  protected final String TEXT_297 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_298 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_299 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_300 = "+\"";
  protected final String TEXT_301 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_302 = ".write(\"  \tTYPE STREAM";
  protected final String TEXT_303 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_304 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_305 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_306 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_307 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_308 = ".write(\"  \t(";
  protected final String TEXT_309 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_310 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_311 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_312 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_313 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_314 = ".write(\"  \t\tVARCHAR TdpId, ";
  protected final String TEXT_315 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_316 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_317 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_318 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_319 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_320 = ".write(\"  \t\tVARCHAR ErrorTable, ";
  protected final String TEXT_321 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_322 = ".write(\"  \t\tVARCHAR AppendErrorTable, ";
  protected final String TEXT_323 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_324 = ".write(\"  \t\tINTEGER Buffers, ";
  protected final String TEXT_325 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_326 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_327 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_328 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_329 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_330 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_331 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_332 = ".write(\"  \t\tINTEGER Pack, ";
  protected final String TEXT_333 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_334 = ".write(\"  \t\tINTEGER Rate, ";
  protected final String TEXT_335 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_336 = ".write(\"  \t\tINTEGER Periodicity, ";
  protected final String TEXT_337 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_338 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_339 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_340 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_341 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_342 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_343 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_344 = ".write(\"  \t\tVARCHAR ArraySupport, ";
  protected final String TEXT_345 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_346 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_347 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_348 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_349 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_350 = ".write(\"  \t\tVARCHAR DropMacro, ";
  protected final String TEXT_351 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_352 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_353 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_354 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_355 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_356 = ".write(\"  \t\tVARCHAR MacroDatabase, ";
  protected final String TEXT_357 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_358 = ".write(\"  \t\tVARCHAR OperatorCommandID, ";
  protected final String TEXT_359 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_360 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_361 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_362 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_363 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_364 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_365 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_366 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_367 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_368 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_369 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_370 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_371 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_372 = ".write(\"  \t\tVARCHAR PackMaximum, ";
  protected final String TEXT_373 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_374 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_375 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_376 = ".write(\"  \t\tVARCHAR QueueErrorTable, ";
  protected final String TEXT_377 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_378 = ".write(\"  \t\tVARCHAR ReplicationOverrride, ";
  protected final String TEXT_379 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_380 = ".write(\"  \t\tVARCHAR Robust, ";
  protected final String TEXT_381 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_382 = ".write(\"  \t\tVARCHAR WorkingDatabase, ";
  protected final String TEXT_383 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_384 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_385 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_386 = ".write(\"  \t\tVARCHAR DropErrorTable";
  protected final String TEXT_387 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_388 = ".write(\"  \t);";
  protected final String TEXT_389 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_390 = ".write(\"  ";
  protected final String TEXT_391 = "\");" + NL + "\t\t\t    ";
  protected final String TEXT_392 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_393 = ".write(\"  \tDEFINE SCHEMA \"+";
  protected final String TEXT_394 = "+\"";
  protected final String TEXT_395 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_396 = ".write(\"  \t(";
  protected final String TEXT_397 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_399 = ".write(\"               ";
  protected final String TEXT_400 = "\"+\" VARCHAR(";
  protected final String TEXT_401 = "),";
  protected final String TEXT_402 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_404 = ".write(\"               ";
  protected final String TEXT_405 = "\"+\" VARCHAR(";
  protected final String TEXT_406 = ")";
  protected final String TEXT_407 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_408 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_409 = ".write(\"  \t);";
  protected final String TEXT_410 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_411 = ".write(\"  ";
  protected final String TEXT_412 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_413 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_414 = "+\"";
  protected final String TEXT_415 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_416 = ".write(\"  \tTYPE DATACONNECTOR PRODUCER";
  protected final String TEXT_417 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_418 = ".write(\"  \tSCHEMA \"+";
  protected final String TEXT_419 = "+\"";
  protected final String TEXT_420 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_421 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_422 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_423 = ".write(\"  \t(";
  protected final String TEXT_424 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_425 = ".write(\"  \t\tVARCHAR FileName, ";
  protected final String TEXT_426 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_427 = ".write(\"  \t\tVARCHAR Format, ";
  protected final String TEXT_428 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_429 = ".write(\"  \t\tVARCHAR OpenMode, ";
  protected final String TEXT_430 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_431 = ".write(\"  \t\tINTEGER BlockSize, ";
  protected final String TEXT_432 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_433 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_434 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_435 = ".write(\"  \t\tINTEGER RetentionPeriod, ";
  protected final String TEXT_436 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_437 = ".write(\"  \t\tINTEGER RowsPerInstance, ";
  protected final String TEXT_438 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_439 = ".write(\"  \t\tINTEGER SecondarySpace, ";
  protected final String TEXT_440 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_441 = ".write(\"  \t\tINTEGER UnitCount, ";
  protected final String TEXT_442 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_443 = ".write(\"  \t\tINTEGER VigilElapsedTime, ";
  protected final String TEXT_444 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_445 = ".write(\"  \t\tINTEGER VigilWaitTime, ";
  protected final String TEXT_446 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_447 = ".write(\"  \t\tINTEGER VolumeCount, ";
  protected final String TEXT_448 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_449 = ".write(\"  \t\tVARCHAR AccessModuleName, ";
  protected final String TEXT_450 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_451 = ".write(\"  \t\tVARCHAR AccessModuleInitStr, ";
  protected final String TEXT_452 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_453 = ".write(\"  \t\tVARCHAR DirectoryPath, ";
  protected final String TEXT_454 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_455 = ".write(\"  \t\tVARCHAR ExpirationDate, ";
  protected final String TEXT_456 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_457 = ".write(\"  \t\tVARCHAR IndicatorMode, ";
  protected final String TEXT_458 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_459 = ".write(\"  \t\tVARCHAR PrimarySpace, ";
  protected final String TEXT_460 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_461 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_462 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_463 = ".write(\"  \t\tVARCHAR RecordFormat, ";
  protected final String TEXT_464 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_465 = ".write(\"  \t\tVARCHAR RecordLength, ";
  protected final String TEXT_466 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_467 = ".write(\"  \t\tVARCHAR SpaceUnit, ";
  protected final String TEXT_468 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_469 = ".write(\"  \t\tVARCHAR TextDelimiter, ";
  protected final String TEXT_470 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_471 = ".write(\"  \t\tVARCHAR VigilNoticeFileName, ";
  protected final String TEXT_472 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_473 = ".write(\"  \t\tVARCHAR VigilStartTime, ";
  protected final String TEXT_474 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_475 = ".write(\"  \t\tVARCHAR VigilStopTime, ";
  protected final String TEXT_476 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_477 = ".write(\"  \t\tVARCHAR VolSerNumber, ";
  protected final String TEXT_478 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_479 = ".write(\"  \t\tVARCHAR UnitType";
  protected final String TEXT_480 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_481 = ".write(\"  \t);";
  protected final String TEXT_482 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_483 = ".write(\"  ";
  protected final String TEXT_484 = "\");" + NL + "" + NL + "\t\t\t\tfw_";
  protected final String TEXT_485 = ".write(\"    APPLY";
  protected final String TEXT_486 = "\");" + NL + "                fw_";
  protected final String TEXT_487 = ".write(\"        (";
  protected final String TEXT_488 = "\");" + NL + "" + NL + "                //builder4insert begin";
  protected final String TEXT_489 = NL + "                //builder4insert end" + NL + "" + NL + "                //builder4update begin";
  protected final String TEXT_490 = NL;
  protected final String TEXT_491 = NL + "                //builder4update end" + NL;
  protected final String TEXT_492 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_493 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_494 = " + \".\" + ";
  protected final String TEXT_495 = "+\" (";
  protected final String TEXT_496 = ") VALUES (";
  protected final String TEXT_497 = ");'";
  protected final String TEXT_498 = "\");" + NL + "\t\t\t\t ";
  protected final String TEXT_499 = NL + "\t\t                ";
  protected final String TEXT_500 = NL + "\t\t                    fw_";
  protected final String TEXT_501 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_502 = " + \".\" + ";
  protected final String TEXT_503 = "+\" (";
  protected final String TEXT_504 = ") VALUES (";
  protected final String TEXT_505 = ");'";
  protected final String TEXT_506 = "\");" + NL + "\t\t                ";
  protected final String TEXT_507 = NL + "\t\t                    fw_";
  protected final String TEXT_508 = ".write(\"            'UPDATE \" + ";
  protected final String TEXT_509 = " + \".\" + ";
  protected final String TEXT_510 = " + \" SET ";
  protected final String TEXT_511 = " WHERE ";
  protected final String TEXT_512 = ";'";
  protected final String TEXT_513 = "\" );" + NL + "\t\t                ";
  protected final String TEXT_514 = NL + "\t\t                    fw_";
  protected final String TEXT_515 = ".write(\"            'DELETE  FROM \" + ";
  protected final String TEXT_516 = " + \".\" + ";
  protected final String TEXT_517 = " + \" WHERE ";
  protected final String TEXT_518 = ";'";
  protected final String TEXT_519 = "\");" + NL + "\t\t                ";
  protected final String TEXT_520 = NL + "\t\t                    fw_";
  protected final String TEXT_521 = ".write(\"            'UPDATE \" + ";
  protected final String TEXT_522 = " + \".\" + ";
  protected final String TEXT_523 = " + \" SET ";
  protected final String TEXT_524 = " WHERE ";
  protected final String TEXT_525 = ";',";
  protected final String TEXT_526 = "\");" + NL + "\t\t                    fw_";
  protected final String TEXT_527 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_528 = " + \".\" + ";
  protected final String TEXT_529 = "+\" (";
  protected final String TEXT_530 = ") VALUES (";
  protected final String TEXT_531 = ");'";
  protected final String TEXT_532 = "\");" + NL + "\t\t                ";
  protected final String TEXT_533 = NL + "\t\t                      System.err.println(\"Unexcepted DML type.\");" + NL + "\t\t                    ";
  protected final String TEXT_534 = NL + "                \t  \tSystem.err.println(\"Unknow customer operator.\");" + NL + "                \t";
  protected final String TEXT_535 = NL + NL + "                fw_";
  protected final String TEXT_536 = ".write(\"        )";
  protected final String TEXT_537 = "\");";
  protected final String TEXT_538 = NL + "                fw_";
  protected final String TEXT_539 = ".write(\"    INSERT FOR MISSING UPDATE ROWS";
  protected final String TEXT_540 = "\");";
  protected final String TEXT_541 = NL + NL + "             \tfw_";
  protected final String TEXT_542 = ".write(\"    TO OPERATOR";
  protected final String TEXT_543 = "\");" + NL + "                fw_";
  protected final String TEXT_544 = ".write(\"    (";
  protected final String TEXT_545 = "\");" + NL + "                fw_";
  protected final String TEXT_546 = ".write(\"        \"+";
  protected final String TEXT_547 = "+\"[1]\"+\"";
  protected final String TEXT_548 = "\");" + NL + "                fw_";
  protected final String TEXT_549 = ".write(\"  ";
  protected final String TEXT_550 = "\");" + NL + "                fw_";
  protected final String TEXT_551 = ".write(\"        ATTRIBUTES";
  protected final String TEXT_552 = "\");" + NL + "                fw_";
  protected final String TEXT_553 = ".write(\"        (";
  protected final String TEXT_554 = "\");" + NL + "                fw_";
  protected final String TEXT_555 = ".write(\"            UserName = '\" + ";
  protected final String TEXT_556 = " + \"', ";
  protected final String TEXT_557 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_558 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_559 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_560 = ");";
  protected final String TEXT_561 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_562 = " = ";
  protected final String TEXT_563 = "; ";
  protected final String TEXT_564 = NL + NL + "                fw_";
  protected final String TEXT_565 = ".write(\"            UserPassword = '\" + decryptedPassword_";
  protected final String TEXT_566 = " + \"',";
  protected final String TEXT_567 = "\");" + NL + "                fw_";
  protected final String TEXT_568 = ".write(\"            TdpId = '\" + ";
  protected final String TEXT_569 = " + \"'";
  protected final String TEXT_570 = "\");                " + NL;
  protected final String TEXT_571 = NL + "                \t    fw_";
  protected final String TEXT_572 = ".write(\"            ,TargetTable = '\" + tableFullName_";
  protected final String TEXT_573 = " + \"'";
  protected final String TEXT_574 = "\");" + NL + "                \t";
  protected final String TEXT_575 = "                \t    " + NL + "                \t    fw_";
  protected final String TEXT_576 = ".write(\"            ,LogTable = '\" + logTable_";
  protected final String TEXT_577 = " + \"'";
  protected final String TEXT_578 = "\");" + NL + "                \t";
  protected final String TEXT_579 = NL + "                \t";
  protected final String TEXT_580 = "                \t    " + NL + "                \t    fw_";
  protected final String TEXT_581 = ".write(\"            ,LogTable = '\" + logTable_";
  protected final String TEXT_582 = " + \"'";
  protected final String TEXT_583 = "\");" + NL + "                \t";
  protected final String TEXT_584 = NL + "                \t\tfw_";
  protected final String TEXT_585 = ".write(\"            ,TargetTable = ['\" + tableFullName_";
  protected final String TEXT_586 = " + \"']";
  protected final String TEXT_587 = "\");";
  protected final String TEXT_588 = NL + "                \t";
  protected final String TEXT_589 = NL + "                \t    fw_";
  protected final String TEXT_590 = ".write(\"            ,LogTable = '\" + logTable_";
  protected final String TEXT_591 = " + \"'";
  protected final String TEXT_592 = "\");" + NL + "                \t";
  protected final String TEXT_593 = NL + "\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_594 = ".write(\"            ,";
  protected final String TEXT_595 = " = \"+";
  protected final String TEXT_596 = "+\"";
  protected final String TEXT_597 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_598 = NL + "\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_599 = ".write(\"            ,";
  protected final String TEXT_600 = " = '\"+";
  protected final String TEXT_601 = "+\".\"+";
  protected final String TEXT_602 = "+\"'";
  protected final String TEXT_603 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_604 = NL + "\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_605 = ".write(\"            ,";
  protected final String TEXT_606 = " = '\"+";
  protected final String TEXT_607 = "+\"'";
  protected final String TEXT_608 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_609 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_610 = ".write(\"            ,";
  protected final String TEXT_611 = " = \"+";
  protected final String TEXT_612 = "+\"";
  protected final String TEXT_613 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_614 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_615 = ".write(\"            ,";
  protected final String TEXT_616 = " = \"+";
  protected final String TEXT_617 = "+\"";
  protected final String TEXT_618 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_619 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_620 = ".write(\"            ,";
  protected final String TEXT_621 = " = '\"+";
  protected final String TEXT_622 = "+\".\"+";
  protected final String TEXT_623 = "+\"'";
  protected final String TEXT_624 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_625 = NL + NL + "                fw_";
  protected final String TEXT_626 = ".write(\"        )";
  protected final String TEXT_627 = "\");" + NL + "                fw_";
  protected final String TEXT_628 = ".write(\"    )";
  protected final String TEXT_629 = "\");" + NL + "                fw_";
  protected final String TEXT_630 = ".write(\"    SELECT * FROM OPERATOR";
  protected final String TEXT_631 = "\");" + NL + "                fw_";
  protected final String TEXT_632 = ".write(\"    (";
  protected final String TEXT_633 = "\");" + NL + "                fw_";
  protected final String TEXT_634 = ".write(\"        \"+";
  protected final String TEXT_635 = "+\"[1]\"+\"";
  protected final String TEXT_636 = "\");" + NL + "                fw_";
  protected final String TEXT_637 = ".write(\"  ";
  protected final String TEXT_638 = "\");" + NL + "                fw_";
  protected final String TEXT_639 = ".write(\"        ATTRIBUTES";
  protected final String TEXT_640 = "\");" + NL + "                fw_";
  protected final String TEXT_641 = ".write(\"        (";
  protected final String TEXT_642 = "\");" + NL + "                fw_";
  protected final String TEXT_643 = ".write(\"            FileName = '\" + ";
  protected final String TEXT_644 = " + \"', ";
  protected final String TEXT_645 = "\");" + NL + "                fw_";
  protected final String TEXT_646 = ".write(\"            Format = 'DELIMITED', ";
  protected final String TEXT_647 = "\");" + NL + "                fw_";
  protected final String TEXT_648 = ".write(\"            OpenMode = 'Read', ";
  protected final String TEXT_649 = "\");" + NL + "                fw_";
  protected final String TEXT_650 = ".write(\"            DirectoryPath = '', ";
  protected final String TEXT_651 = "\");" + NL + "                fw_";
  protected final String TEXT_652 = ".write(\"            IndicatorMode = 'N', ";
  protected final String TEXT_653 = "\");" + NL + "                fw_";
  protected final String TEXT_654 = ".write(\"            TextDelimiter = '\" + ";
  protected final String TEXT_655 = " + \"'";
  protected final String TEXT_656 = "\");" + NL + "                fw_";
  protected final String TEXT_657 = ".write(\"        )";
  protected final String TEXT_658 = "\");" + NL + "                fw_";
  protected final String TEXT_659 = ".write(\"    );";
  protected final String TEXT_660 = "\");" + NL + "                fw_";
  protected final String TEXT_661 = ".write(\"  );";
  protected final String TEXT_662 = "\");" + NL + "" + NL + "                //write script to file" + NL + "                fw_";
  protected final String TEXT_663 = ".close();" + NL + "" + NL + "                //run tbuild (TPT) command";
  protected final String TEXT_664 = NL + "                            String[] sb_";
  protected final String TEXT_665 = "= {\"cmd\",\"/c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_666 = "+";
  protected final String TEXT_667 = "+\".script\\\" -e \"+";
  protected final String TEXT_668 = "+\" > \\\"\"+";
  protected final String TEXT_669 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_670 = NL + "                            String[] sb_";
  protected final String TEXT_671 = "= {\"sh\",\"-c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_672 = "+";
  protected final String TEXT_673 = "+\".scr\\\" -e \"+";
  protected final String TEXT_674 = "+\" > \\\"\"+";
  protected final String TEXT_675 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_676 = NL + "                        String[] sb_";
  protected final String TEXT_677 = "= {\"cmd\",\"/c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_678 = "+";
  protected final String TEXT_679 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_680 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_681 = NL + "                        String[] sb_";
  protected final String TEXT_682 = "= {\"sh\",\"-c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_683 = "+";
  protected final String TEXT_684 = "+\".scr\\\" > \\\"\"+";
  protected final String TEXT_685 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_686 = NL + "                \tString cmdStr_";
  protected final String TEXT_687 = " = java.util.Arrays.toString(sb_";
  protected final String TEXT_688 = ");" + NL + "                    log.info(\"";
  protected final String TEXT_689 = " - Executing command: '\" + cmdStr_";
  protected final String TEXT_690 = " + \"'.\");";
  protected final String TEXT_691 = NL + "                final Process process_";
  protected final String TEXT_692 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_693 = ");" + NL + "                Thread normal_";
  protected final String TEXT_694 = " = new Thread() {" + NL + "                    public void run() {" + NL + "                        try {" + NL + "                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_695 = ".getInputStream()));" + NL + "                            String line = \"\";" + NL + "                            try {" + NL + "                                while((line = reader.readLine()) != null) {" + NL + "                                   System.out.println(line);" + NL + "                                }" + NL + "                            } finally {" + NL + "                                 reader.close();" + NL + "                            }" + NL + "                        }catch(java.io.IOException ioe) {";
  protected final String TEXT_696 = NL + "                            ioe.printStackTrace();" + NL + "                        }" + NL + "                    }" + NL + "                };" + NL + "                normal_";
  protected final String TEXT_697 = ".start();" + NL + "" + NL + "                Thread error_";
  protected final String TEXT_698 = " = new Thread() {" + NL + "                    public void run() {" + NL + "                        try {" + NL + "                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_699 = ".getErrorStream()));" + NL + "                            String line = \"\";" + NL + "                            try {" + NL + "                                while((line = reader.readLine()) != null) {" + NL + "                                    System.err.println(line);" + NL + "                                }" + NL + "                            } finally {" + NL + "                                reader.close();" + NL + "                            }" + NL + "                        } catch(java.io.IOException ioe) {";
  protected final String TEXT_700 = NL + "                           ioe.printStackTrace();" + NL + "                        }" + NL + "                    }" + NL + "                };" + NL + "                error_";
  protected final String TEXT_701 = ".start();" + NL + "" + NL + "                process_";
  protected final String TEXT_702 = ".waitFor();" + NL + "" + NL + "                normal_";
  protected final String TEXT_703 = ".interrupt();" + NL + "" + NL + "                error_";
  protected final String TEXT_704 = ".interrupt();" + NL + "" + NL + "                globalMap.put(\"";
  protected final String TEXT_705 = "_EXIT_VALUE\", process_";
  protected final String TEXT_706 = ".exitValue());" + NL;
  protected final String TEXT_707 = NL + "                    if(process_";
  protected final String TEXT_708 = ".exitValue()>=";
  protected final String TEXT_709 = ") {" + NL + "                        throw new RuntimeException(\"TPT returned exit code \"+process_";
  protected final String TEXT_710 = ".exitValue());" + NL + "                    }";
  protected final String TEXT_711 = NL + "                    log.info(\"";
  protected final String TEXT_712 = " - Excute command:'\" + cmdStr_";
  protected final String TEXT_713 = " + \"' has finished.\");";
  protected final String TEXT_714 = NL + "}finally{" + NL + "\ttry{" + NL + "\t\tfile_";
  protected final String TEXT_715 = ".delete();" + NL + "\t}catch(Exception e_";
  protected final String TEXT_716 = "){";
  protected final String TEXT_717 = NL + "\t}" + NL + "}";
  protected final String TEXT_718 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"info",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"info",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"info",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_48);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"info",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"info",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_52);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_55);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_64);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String operatorType = ElementParameterParser.getValue(node, "__ACTION__");
String dmlType = ElementParameterParser.getValue(node, "__DML_TYPE__");
String tdpid= ElementParameterParser.getValue(node, "__TDPID__");
String jobName= ElementParameterParser.getValue(node, "__JOB_NAME__");
String operatorLoad= ElementParameterParser.getValue(node, "__OPERATOR_LOAD__");
String operatorDataConnector= ElementParameterParser.getValue(node, "__OPERATOR_DATA_CONNECTOR__");
String layoutName= ElementParameterParser.getValue(node, "__LAYOUT_NAME__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean returnCodeDie= "true".equals(ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__"));
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");
boolean specifyLogTable= "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_LOG_TABLE__"));
String logTable= ElementParameterParser.getValue(node, "__LOG_TABLE_TABLE__");
String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

boolean checkedScriptParameter = ("true").equals(ElementParameterParser.getValue(node, "__SCRIPT_PARAMETER__"));
boolean applyOptionalAttributes = "true".equals(ElementParameterParser.getValue(node, "__APPLY_OPTIONAL_ATTRIBUTES__"));

String passwordFieldName="__PASS__";

//New Feature TDI-29325 begin
List<String>  intAttrisList = null;
List<String>  arrayAttrisList = null;
Map<String,String> attrisMap = null;
if(applyOptionalAttributes){
	List<Map<String,String>> additionalList = null;
	if("LOAD".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_CONSUMER_OPERATOR_OPTIONAL_ATTRIBUTES__");
	}else if("INSERTER".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_INSERTER__");
	}else if("UPDATE".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_UPDATE__");
	}else if("STREAM".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_STREAM__");
	}else{
		System.err.println("Unexcepted consumer operator type.");
	}

	attrisMap =  new HashMap<String,String>();//For unique key

	for(Map<String,String> map : additionalList){
		String attriName = map.get("OPTIONAL_ATTRIBUTES_NAME");
		String attriValue = map.get("OPTIONAL_ATTRIBUTES_VALUE");
		if("WORKINGDATABASE".equalsIgnoreCase(attriName)){
			dbname = attriValue;
		}
		attrisMap.put(attriName, attriValue);
	}

	intAttrisList = Arrays.asList(
										"BUFFERSIZE","ERRORLIMIT","MAXSESSIONS",
										"MINSESSIONS","TENACITYHOURS","TENACITYSLEEP",
										"BUFFERS","PACK","RATE",
										"PERIODICITY","IOBUFFERSIZE","ROWSPERINSTANCE",
										"SKIPROWS","TIMEOUT","VIGILELAPSEDTIME",
										"VIGILMAXFILES","VIGILWAITTIME"
								  );
    arrayAttrisList = Arrays.asList("TRACELEVEL","TARGETTABLE","ERRORTABLE1","ERRORTABLE2","WORKTABLE");
}
//end

//windows line separator as default
String lineSeparator = "\\r\\n";
if("Unix".equals(execution)){
	lineSeparator = "\\n";
}
if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

List<String> primaryKeyList = new ArrayList<String>();
if(columnList!=null){
	for(IMetadataColumn column:columnList){
		if(column.isKey()){
			primaryKeyList.add(column.getOriginalDbColumnName());
		}
	}
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_71);
    if("Windows".equals(execution)){
    stringBuffer.append(TEXT_72);
    }else{
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( logTable );
    stringBuffer.append(TEXT_78);
     } 
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_79);
     if(!checkedScriptParameter){
    stringBuffer.append(TEXT_80);
    
						operatorLoad = "\"Operator_" + cid+"\"";
						operatorDataConnector = "\"Connector_" + cid+"\"";
						jobName = "\"Job_" + cid+"\"";
						layoutName = "\"Schema_" +cid+"\"";
					
    stringBuffer.append(TEXT_81);
     }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_89);
     if("Load".equals(operatorType)){ 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_165);
    }else if("Inserter".equals(operatorType)){ 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_209);
    }else if("Update".equals(operatorType)){ 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_297);
    }else if("Stream".equals(operatorType)){
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_391);
    }else{}
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(layoutName );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_397);
    
				if(columnList!=null){
					int counter = 1;
					for(IMetadataColumn column:columnList){
						if( columnList.size() != counter){	
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_400);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_401);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_402);
    
						} else {
					
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_407);
     	}
						counter++;
					}
				}
				
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(operatorDataConnector );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(layoutName );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_488);
    
                StringBuilder inserterColsStrBuilder = new StringBuilder();
                StringBuilder inserterValueSqlStrBuilder = new StringBuilder();
                if(columnList!=null){
                    String columnName = "";
                    for(IMetadataColumn column:columnList){
                        columnName= column.getOriginalDbColumnName();
                        if(inserterColsStrBuilder.length()>0){
                            inserterColsStrBuilder.append(",");
                        }
                        inserterColsStrBuilder.append(columnName);

                        if(inserterValueSqlStrBuilder.length()>0){
                            inserterValueSqlStrBuilder.append(",");
                        }
                        inserterValueSqlStrBuilder.append(":").append(columnName);
                    }
                }
                
    stringBuffer.append(TEXT_489);
    
                StringBuilder setStrBuilder = new StringBuilder();
                if(columnList!=null){
                    String columnName = "";
                    int lgth = columnList.size();
                    for(IMetadataColumn column:columnList){
                    	if(!column.isKey()){
	                        columnName= column.getOriginalDbColumnName();
	                        if(lgth>1){
	                            setStrBuilder.append(columnName).append("=:").append(columnName).append(",");
	                        }else{
	                            setStrBuilder.append(columnName).append("=:").append(columnName);
	                        }
                    	}
                    	lgth--;
                    }
                }
                
    stringBuffer.append(TEXT_490);
    
                StringBuilder whereStrBuilder = new StringBuilder();
                if(primaryKeyList.size()>0){
                    //get primary key from talend schema
                    int lgthx = primaryKeyList.size();
                    for(String primaryKey:primaryKeyList){
                        if(lgthx>1){
                            whereStrBuilder.append(primaryKey).append("=:").append(primaryKey).append(" and ");
                        }else{
                            whereStrBuilder.append(primaryKey).append("=:").append(primaryKey);
                        }
                        lgthx--;
                    }
                }else{
                     whereStrBuilder.append("1=0");
                }
    stringBuffer.append(TEXT_491);
     if("Load".equals(operatorType) || "Inserter".equals(operatorType)){
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_496);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_497);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_498);
    }else if("Update".equals(operatorType) || "Stream".equals(operatorType)){
    stringBuffer.append(TEXT_499);
     if("Insert".equals(dmlType)){ 
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_506);
     } else if("Update".equals(dmlType)){ 
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_510);
    stringBuffer.append( setStrBuilder.toString() );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_513);
     }else if("Delete".equals(dmlType)){
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_517);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_519);
    }else if("InsertOrUpdate".equals(dmlType)){
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_523);
    stringBuffer.append( setStrBuilder.toString() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_530);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_531);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_532);
    }else{
		                    
    stringBuffer.append(TEXT_533);
    
		                } 
    }else{
                	
    stringBuffer.append(TEXT_534);
    
	            } 
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_537);
      if(("Update".equals(operatorType) || "Stream".equals(operatorType)) && "InsertOrUpdate".equals(dmlType)){
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_540);
    } 
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_557);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_560);
    } else {
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_563);
    }
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(tdpid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_570);
     if("Load".equals(operatorType)){
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_574);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_578);
     } 
    } if("Update".equals(operatorType)){
    stringBuffer.append(TEXT_579);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_583);
     } 
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_587);
    } if("Stream".equals(operatorType)){
    stringBuffer.append(TEXT_588);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_592);
     }
                }
					//New Feature TDI-29325
					if(applyOptionalAttributes){
						Set<String> attrisKeySet = attrisMap.keySet();
						for(String key : attrisKeySet){
							String value = attrisMap.get(key);
							boolean isIntType = intAttrisList.contains(key);
							boolean isArrType;
							if(isIntType){//Integer
								
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_595);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_597);
    
							}else{
								isArrType = arrayAttrisList.contains(key);
								if(!isArrType){//Varchar
									if("ERRORTABLE".equalsIgnoreCase(key)){
									
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_600);
    stringBuffer.append( dbname );
    stringBuffer.append(TEXT_601);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_603);
    
									}else{
									
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_606);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_608);
    
									}
								}else{//Array
											if(!operatorType.equalsIgnoreCase("LOAD")){ // The Type Of ErrorTable1 and  ErrorTable2 and TargetTable are Array
													
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_611);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_613);
    
											}else if("TRACELEVEL".equalsIgnoreCase(key)){ // The Type Of ErrorTable1 and  ErrorTable2 and TargetTable are Varchar for Load
														
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_616);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_618);
    
											}else{// Just for ErrorTable1 and ErrorTable2
													
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_621);
    stringBuffer.append( dbname );
    stringBuffer.append(TEXT_622);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_624);
    
											}
									}
								}
							}
						}
				
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(operatorDataConnector );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_663);
    if("true".equals(defineCharset)) {
                    if(!("".equals(charset))) {
                        if("Windows".equals(execution)){
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_669);
    }else{
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_675);
    }
                    }
                } else {
                    if("Windows".equals(execution)){
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_680);
    }else{
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_685);
    }
                }
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_686);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_690);
    }
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_699);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    
                if(returnCodeDie) {
                
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    
                }
                
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_713);
    }
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    log4jCodeGenerateUtil.logError(node,"warn","e_"+cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(TEXT_718);
    return stringBuffer.toString();
  }
}
