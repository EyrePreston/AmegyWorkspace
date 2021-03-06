package org.talend.designer.codegen.translators.business.salesforce;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSalesforceInputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceInputBeginJava result = new TSalesforceInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tif(log.is";
  protected final String TEXT_3 = "Enabled())" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\tlog.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ");" + NL + "\t\t";
  protected final String TEXT_10 = NL + "    \t\tStringBuilder ";
  protected final String TEXT_11 = " = new StringBuilder();" + NL + "    \t   \t";
  protected final String TEXT_12 = ".append(\"Parameters:\");" + NL + "    \t   \t";
  protected final String TEXT_13 = NL + "                    ";
  protected final String TEXT_14 = ".append(\"";
  protected final String TEXT_15 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_16 = ").substring(0, 4) + \"...\");\t\t" + NL + "       \t\t\t";
  protected final String TEXT_17 = NL + "    \t\t\t\t";
  protected final String TEXT_18 = ".append(\"";
  protected final String TEXT_19 = "\" + \" = \" + ";
  protected final String TEXT_20 = ");" + NL + "    \t\t\t";
  protected final String TEXT_21 = NL + "    \t\t\t";
  protected final String TEXT_22 = ".append(\" | \");" + NL + "    \t\t";
  protected final String TEXT_23 = NL + "        \tStringBuilder ";
  protected final String TEXT_24 = " = new StringBuilder();\t" + NL + "        \t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t";
  protected final String TEXT_26 = ".append(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "    \t\t\t\tif(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " == null){" + NL + "    \t\t\t\t\t";
  protected final String TEXT_32 = ".append(\"<null>\");" + NL + "    \t\t\t\t}else{" + NL + "        \t\t\t\t";
  protected final String TEXT_33 = ".append(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ");" + NL + "        \t\t\t}\t" + NL + "        \t\t";
  protected final String TEXT_36 = NL + "    \t\t\t";
  protected final String TEXT_37 = ".append(\"|\");" + NL + "    \t\t";
  protected final String TEXT_38 = NL + "\t";
  protected final String TEXT_39 = NL + " " + NL + "int nb_line_";
  protected final String TEXT_40 = " = 0;" + NL + "int limit_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_43 = NL + "\t\t\t\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_44 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_46 = "\") == null){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_47 = "\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_49 = " = (org.talend.salesforce.SforceConnection)globalMap.get(\"conn_";
  protected final String TEXT_50 = "\"); " + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "                \t\t";
  protected final String TEXT_52 = NL + "                    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_53 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_54 = ");" + NL + "                    \t";
  protected final String TEXT_55 = NL + "                    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL + "                    \t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tsforceConn_";
  protected final String TEXT_59 = " = " + NL + "\t\t\t\t\t\t\tnew org.talend.salesforce.SforceOAuthConnection.Builder(";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ", decryptedQauthClientPwd_";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ")" + NL + "                \t\t\t\t";
  protected final String TEXT_66 = NL + "                    \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_67 = ")" + NL + "                \t\t\t\t";
  protected final String TEXT_68 = NL + "                \t\t\t\t.setTimeout(";
  protected final String TEXT_69 = ").needCompression(";
  protected final String TEXT_70 = ")" + NL + "                            \t";
  protected final String TEXT_71 = NL + "                            \t\t.setClientID(";
  protected final String TEXT_72 = ");" + NL + "                            \t";
  protected final String TEXT_73 = NL + "                            \t.build();" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = NL + "                    \t\t\tString decryptedPwd_";
  protected final String TEXT_75 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_76 = ");" + NL + "                    \t\t";
  protected final String TEXT_77 = NL + "                    \t\t\tString decryptedPwd_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "                    \t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_81 = " = System.getProperties();" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_82 = ".put(\"socksProxyHost\",";
  protected final String TEXT_83 = ");  " + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_84 = ".put(\"socksProxyPort\",";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_86 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\t\t\t    props_";
  protected final String TEXT_88 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_89 = "); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "        " + NL + "        \t\t\t\t";
  protected final String TEXT_92 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_93 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = "; ";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\tsforceConn_";
  protected final String TEXT_99 = " = " + NL + "                \t\t\tnew org.talend.salesforce.SforceBasicConnection.Builder(";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ", decryptedPassword_";
  protected final String TEXT_102 = ")" + NL + "                \t\t\t\t.setTimeout(";
  protected final String TEXT_103 = ").needCompression(";
  protected final String TEXT_104 = ")" + NL + "                            \t";
  protected final String TEXT_105 = NL + "                            \t\t.setClientID(";
  protected final String TEXT_106 = ");" + NL + "                            \t";
  protected final String TEXT_107 = NL + "                            \t.build();" + NL + "\t\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_109 = " = new org.talend.salesforce.SforceManagementImpl(sforceConn_";
  protected final String TEXT_110 = ");" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\torg.talend.salesforceBulk.SforceBulkConnection sforceConn_";
  protected final String TEXT_112 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_114 = "\")==null){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_115 = "\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_116 = " = (org.talend.salesforceBulk.SforceBulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_117 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t";
  protected final String TEXT_119 = NL + "                    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_120 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_121 = ");" + NL + "                    \t";
  protected final String TEXT_122 = NL + "                    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ";" + NL + "                    \t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\tsforceConn_";
  protected final String TEXT_126 = " " + NL + "                    \t\t= new org.talend.salesforceBulk.SforceOAuthBulkConnection.Builder(";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ", decryptedQauthClientPwd_";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ")" + NL + "                    \t\t\t";
  protected final String TEXT_133 = NL + "                    \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_134 = ")" + NL + "                    \t\t\t";
  protected final String TEXT_135 = NL + "                    \t\t\t.needCompression(";
  protected final String TEXT_136 = ").needTraceMessage(";
  protected final String TEXT_137 = ")" + NL + "                    \t\t\t.build();" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_139 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_140 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_143 = " = ";
  protected final String TEXT_144 = "; ";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "                    \t\t\tString decryptedPwd_";
  protected final String TEXT_147 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_148 = ");" + NL + "                    \t\t";
  protected final String TEXT_149 = NL + "                    \t\t\tString decryptedPwd_";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = ";" + NL + "                    \t\t";
  protected final String TEXT_152 = NL + "                \t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tsforceConn_";
  protected final String TEXT_154 = " " + NL + "                \t\t\t= new org.talend.salesforceBulk.SforceBasicBulkConnection.Builder(";
  protected final String TEXT_155 = ",";
  protected final String TEXT_156 = ",decryptedPassword_";
  protected final String TEXT_157 = ",";
  protected final String TEXT_158 = ")" + NL + "                \t\t\t\t.needCompression(";
  protected final String TEXT_159 = ").needTraceMessage(";
  protected final String TEXT_160 = ")" + NL + "                \t\t\t\t";
  protected final String TEXT_161 = NL + "                        \t\t\t.setProxy(true,";
  protected final String TEXT_162 = ",";
  protected final String TEXT_163 = ",";
  protected final String TEXT_164 = ",decryptedPwd_";
  protected final String TEXT_165 = ")" + NL + "                        \t\t";
  protected final String TEXT_166 = NL + "                \t\t\t\t.build();" + NL + "\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\torg.talend.salesforceBulk.SalesforceBulkAPI\tsforceBulk_";
  protected final String TEXT_168 = " = new org.talend.salesforceBulk.SalesforceBulkAPI(sforceConn_";
  protected final String TEXT_169 = "); " + NL + "\t\t\t";
  protected final String TEXT_170 = "\t\t\t\t" + NL + "\t\t\t\tStringBuilder sql_";
  protected final String TEXT_171 = " = new StringBuilder(";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\tString condition_";
  protected final String TEXT_174 = " = ";
  protected final String TEXT_175 = ";" + NL + "\t\t\t\t\tif (condition_";
  protected final String TEXT_176 = " != null && !(\"\".equals(condition_";
  protected final String TEXT_177 = "))){" + NL + "\t\t\t\t\t\tsql_";
  protected final String TEXT_178 = ".append(\" where \").append(condition_";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t";
  protected final String TEXT_182 = "\t" + NL + "\t\t\t\t\tcom.salesforce.soap.partner.QueryResult qr_";
  protected final String TEXT_183 = " = null; " + NL + "\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\tqr_";
  protected final String TEXT_185 = " = sfMgr_";
  protected final String TEXT_186 = ".queryAll(sql_";
  protected final String TEXT_187 = ".toString(),new Integer(";
  protected final String TEXT_188 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\tqr_";
  protected final String TEXT_190 = " = sfMgr_";
  protected final String TEXT_191 = ".query(sql_";
  protected final String TEXT_192 = ".toString(),new Integer(";
  protected final String TEXT_193 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t" + NL + "\t\t\t\t\torg.talend.salesforce.TopConfig.VALUE_DELIMITER = ";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\t\torg.talend.salesforce.TopConfig.COLUMNNAME_DELIMTER = ";
  protected final String TEXT_196 = ";" + NL + "\t\t\t\t\t" + NL + "\t    \t\t\torg.talend.salesforce.TopQueryResult topqr_";
  protected final String TEXT_197 = " = null;    \t\t\t" + NL + "\t    \t\t\ttopqr_";
  protected final String TEXT_198 = " = new org.talend.salesforce.TopQueryResult();" + NL + "\t    \t\t\ttopqr_";
  protected final String TEXT_199 = ".processTopQueryResult(qr_";
  protected final String TEXT_200 = ");\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tboolean bContinue_";
  protected final String TEXT_201 = " = true;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twhile (bContinue_";
  protected final String TEXT_202 = " && qr_";
  protected final String TEXT_203 = " != null && qr_";
  protected final String TEXT_204 = ".getRecords() != null) {" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tjava.util.List<org.talend.salesforce.TopRecord> allTopRecords_";
  protected final String TEXT_205 = " = topqr_";
  protected final String TEXT_206 = ".getAllTopRecords();" + NL + "\t\t\t\t\t    // process the query results" + NL + "\t\t\t\t\t    for (int i_";
  protected final String TEXT_207 = " = 0; i_";
  protected final String TEXT_208 = " < allTopRecords_";
  protected final String TEXT_209 = ".size(); i_";
  protected final String TEXT_210 = "++) {\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\torg.talend.salesforce.TopRecord topRecord_";
  protected final String TEXT_211 = " = allTopRecords_";
  protected final String TEXT_212 = ".get(i_";
  protected final String TEXT_213 = ");" + NL + "" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_214 = "++;" + NL + "\t\t\t\t\t\t\tObject value_";
  protected final String TEXT_215 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\tsforceBulk_";
  protected final String TEXT_217 = ".doBulkQuery(";
  protected final String TEXT_218 = ", sql_";
  protected final String TEXT_219 = ".toString(), 30);" + NL + "\t\t\t\t\tString[] queryResultIDs_";
  protected final String TEXT_220 = " = sforceBulk_";
  protected final String TEXT_221 = ".getQueryResultIDs();" + NL + "\t\t\t\t\tfor(String queryResultId_";
  protected final String TEXT_222 = " : queryResultIDs_";
  protected final String TEXT_223 = "){" + NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_224 = " = sforceBulk_";
  protected final String TEXT_225 = ".getQueryResult(queryResultId_";
  protected final String TEXT_226 = ");" + NL + "\t\t\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_227 = " : resultListMessage_";
  protected final String TEXT_228 = "){" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_229 = "++;\t\t" + NL + "\t\t\t\t\t\t\tObject value_";
  protected final String TEXT_230 = " = null;\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_231 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t//get the real value according the columnName" + NL + "\t\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_232 = " = topRecord_";
  protected final String TEXT_233 = ".getValue(\"";
  protected final String TEXT_234 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_236 = " = resultMessage_";
  protected final String TEXT_237 = ".get(\"";
  protected final String TEXT_238 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\t\t\tif (value_";
  protected final String TEXT_240 = " != null){" + NL + "\t\t\t\t\t\t\t\t \tString valueStr_";
  protected final String TEXT_241 = " = (String) value_";
  protected final String TEXT_242 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = valueStr_";
  protected final String TEXT_246 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_247 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_250 = ", ";
  protected final String TEXT_251 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_253 = ".";
  protected final String TEXT_254 = " = valueStr_";
  protected final String TEXT_255 = ".getBytes();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_256 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = ParserUtils.parseTo_";
  protected final String TEXT_259 = "(valueStr_";
  protected final String TEXT_260 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_261 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = " = ";
  protected final String TEXT_264 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_265 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
	protected String cid  = "";
	protected org.talend.core.model.process.INode node = null;
	protected boolean log4jEnabled = false;
	private String logID = "";
	
	private BasicLogUtil(){}
	
	public BasicLogUtil(org.talend.core.model.process.INode node){
		this.node = node;
		this.cid = this.node.getUniqueName();
		this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
		this.log4jEnabled = this.log4jEnabled &&
							this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
		this.logID = this.cid;
	}
	
	public String var(String varName){
		return varName + "_" + this.cid;
	}
	public String str(String content){
		return "\"" + content + "\"";
	}
	
	public void info(String... message){
		log4j("info", message);
	}
	
	public void debug(String... message){
		log4j("debug", message);
	}
	
	public void warn(String... message){
		log4j("warn", message);
	}
	
	public void error(String... message){
		log4j("error", message);
	}
	
	public void fatal(String... message){
		log4j("fatal", message);
	}
	
	public void trace(String... message){
		log4j("trace", message);
	}
	java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"}); 	
	public void log4j(String level, String... messages){
		if(this.log4jEnabled){
			if(checkableList.contains(level)){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
			}
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
		}
	}
	
	public boolean isActive(){
		return this.log4jEnabled;
	}
}

class LogUtil extends BasicLogUtil{
	
	private LogUtil(){
	}
	
	public LogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void startWork(){
		info(str("Start to work."));
	}
	
	public void endWork(){
		info(str("Done."));
	}
	
	public void logIgnoredException(String exception){
		warn(exception);
	}
	
	public void logPrintedException(String exception){
		error(exception);
	}
	
	public void logException(String exception){
		fatal(exception);
	}
	
	public void logCompSetting(){
    	if(log4jEnabled){
    	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    
    	   	java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
    	   	ignoredParamsTypes.addAll(
    	   		java.util.Arrays.asList(
    	   			org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
    		   		org.talend.core.model.process.EParameterFieldType.LABEL,
    		   		org.talend.core.model.process.EParameterFieldType.EXTERNAL,
    		   		org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
    		   		org.talend.core.model.process.EParameterFieldType.IMAGE,
    		   		org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
    		   		org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
    		   		org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
    		   		org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
    		   		org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
    		   		org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
    		   		org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
    		   		org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
    		   		org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
    		   		org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
    		   		org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
    		   		org.talend.core.model.process.EParameterFieldType.VERSION,
    		   		org.talend.core.model.process.EParameterFieldType.TECHNICAL,
    		   		org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
    		   		org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
    		   		org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
    		   		org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
    		   		org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
    		   		org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
    		   		org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
    		   		)
    	   	);
       		for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
       			if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
       				continue;
       			}
       			String name = ep.getName();
       			if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
       				String epName = "__" + name + "__";
       				String password = "";
       				if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
       					password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
       				}else{
       					String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
       					if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
       				    password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
       				} 
       				
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_16);
    
       			}else{
       				String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
       				
    stringBuffer.append(TEXT_17);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_20);
    
    			}	
    			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_22);
    
       		}
    	}
   		debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
    	if(log4jEnabled){
    	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_24);
    
    		for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
    			org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    			String columnName = column.getLabel();
    			boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
    			if(isPrimit){
   				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    
    			}else{
    			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    
        		}
        		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    
    		}
    	}
		trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
		
    stringBuffer.append(TEXT_38);
    
    }
}

class LogHelper{
	
	java.util.Map<String, String> pastDict = null;
	
	public LogHelper(){
		pastDict = new java.util.HashMap<String, String>();
		pastDict.put("insert", "inserted");
		pastDict.put("update", "updated");
		pastDict.put("delete", "deleted");
		pastDict.put("upsert", "upserted");
	}	
	
	public String upperFirstChar(String data){ 
		return data.substring(0, 1).toUpperCase() + data.substring(1);
	}
	
	public String toPastTense(String data){
		return pastDict.get(data);
	}
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	log = new LogUtil(node);	
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

   	String limit = ElementParameterParser.getValue(node,"__LIMIT__");
   	
   	String passwordFieldName = "";
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_42);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String api = ElementParameterParser.getValue(node,"__API__");
			
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			String username = ElementParameterParser.getValue(node, "__USER__");

			boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
			
			String modulename = ElementParameterParser.getValue(node, "__MODULENAME__").trim();
			String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE__").trim();
			String sObject = (("CustomModule").equals(modulename)) ? customModulename : "\""+modulename+"\"";

			//for bulk query
		   	String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
		   	boolean needTraceMessage = ("true").equals(ElementParameterParser.getValue(node,"__HTTP_TRACEMESSAGE__"));
		   	
		   	//for soap query
		   	String batchSize = ElementParameterParser.getValue(node,"__BATCH_SIZE__");
			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String normalize_delimiter = ElementParameterParser.getValue(node, "__NORMALIZE_DELIMITER__");
			String columnname_delimiter = ElementParameterParser.getValue(node, "__COLUMNNAME_DELIMITER__");
			boolean queryAll = ("true").equals(ElementParameterParser.getValue(node,"__QUERY_ALL__"));
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
			
			boolean bulkConnection = ("bulk").equals(ElementParameterParser.getValue(node,"__API__"));
			
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);
			if("soap".equals(api)){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if(useExistingConn){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_47);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_50);
    
				}else{
					if(useOAuth){
						String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
                		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
                		
    stringBuffer.append(TEXT_51);
    
                    	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
                    	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                    	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    
                    	} else {
                    	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    
                    	}
                    	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
                		
                		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
                		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
						
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_65);
    
                				if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
                				
    stringBuffer.append(TEXT_66);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_67);
    
                				}
                				
    stringBuffer.append(TEXT_68);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_70);
    
                            	if(clientID != null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                            	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_72);
    
                            	}
                            	
    stringBuffer.append(TEXT_73);
    
					}else{
						if(useProxy){
							passwordFieldName = "__PROXY_PASSWORD__";
            				if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                    		
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_76);
    
                    		} else {
                    		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_79);
    
                    		}
							
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
						}
						
    stringBuffer.append(TEXT_90);
    
            			passwordFieldName = "__PASS__";
            			
    stringBuffer.append(TEXT_91);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_94);
    } else {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_104);
    
                            	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                            	
    stringBuffer.append(TEXT_105);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_106);
    
                            	}
                            	
    stringBuffer.append(TEXT_107);
    
					}
					log.info(log.str("Login successful."));
				}
				
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
			}else{
			
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
				if(useExistingConn){
				
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_117);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_118);
    
				}else{
					if(useOAuth){
						String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
                		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
                    	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
                    	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                    	
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_121);
    
                    	} else {
                    	
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_124);
    
                    	}
                    	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
                		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
                		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
						
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_132);
    
                    			if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
                    			
    stringBuffer.append(TEXT_133);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_134);
    
                    			}
                    			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(needTraceMessage);
    stringBuffer.append(TEXT_137);
    
					}else{
            			passwordFieldName = "__PASS__";
            			
    stringBuffer.append(TEXT_138);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    
        				if(useProxy){
                			passwordFieldName = "__PROXY_PASSWORD__";
                			
                			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                    		
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_148);
    
                    		} else {
                    		
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_151);
    
                    		}
                			
    stringBuffer.append(TEXT_152);
    
                		}	
        				
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(needTraceMessage);
    stringBuffer.append(TEXT_160);
    
                				if(useProxy){
                       			
    stringBuffer.append(TEXT_161);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
                        		}	
                				
    stringBuffer.append(TEXT_166);
    
					}
					log.info(log.str("Login successful."));
				}
				
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
			}
						
			boolean bIsManualQuery = ("true").equals(ElementParameterParser.getValue(node, "__MANUAL_QUERY__"));
			String sql = "";
			String condition = null;
			
			if (bIsManualQuery){

				sql = ElementParameterParser.getValue(node, "__QUERY__");
				sql = sql.replaceAll("\n", " ").replaceAll("\r", " ");

			} else{
				
				condition = ElementParameterParser.getValue(node, "__CONDITION__").trim();

				StringBuilder sb = new StringBuilder("\"select ");

				for (IMetadataColumn column: columnList){
					sb.append(column.getLabel());
					sb.append(",");
				}
				sb.deleteCharAt(sb.lastIndexOf(","));
				sb.append(" from ");
				sb.append("\"+");
				sb.append(sObject);
				
				sql = sb.toString();
			}

			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_172);
    
				if(!("".equals(condition))) {
				
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(condition );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
				}
				
    stringBuffer.append(TEXT_180);
    log.debug(log.str("SOQL is: "), log.var("sql"), log.str("."));
    stringBuffer.append(TEXT_181);
    
				log.info(log.str("Retrieving records from the datasource."));
				if("soap".equals(api)){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
					if(queryAll){
					
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_188);
    			
					}else{
					
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_193);
    
					}
					
    stringBuffer.append(TEXT_194);
    stringBuffer.append(normalize_delimiter );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(columnname_delimiter );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
				}else{
				
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
				}
							for( int i = 0; i < columnList.size(); i++) {
							
								IMetadataColumn column = columnList.get(i);
								
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
								if("soap".equals(api)){
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_234);
    }else{
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
									
    stringBuffer.append(TEXT_243);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
									} else if(javaType == JavaTypesManager.DATE) { // Date
									
    stringBuffer.append(TEXT_247);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_251);
    
									} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
									
    stringBuffer.append(TEXT_252);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
									} else  { // other
									
    stringBuffer.append(TEXT_256);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_258);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
									}
									
    stringBuffer.append(TEXT_261);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_264);
    
							}
							log.debug(log.str("Retrieving the record "), log.var("nb_line"), log.str("."));
			}// end 1
		}
	}
}

    stringBuffer.append(TEXT_265);
    return stringBuffer.toString();
  }
}
