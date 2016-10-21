package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSalesforceGetUpdatedBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceGetUpdatedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetUpdatedBeginJava result = new TSalesforceGetUpdatedBeginJava();
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
  protected final String TEXT_39 = NL + NL + "int nb_line_";
  protected final String TEXT_40 = " = 0;" + NL;
  protected final String TEXT_41 = NL + "        \tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_42 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t    java.text.SimpleDateFormat enddf_";
  protected final String TEXT_43 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t" + NL + "\t\t\tstartdf_";
  protected final String TEXT_44 = ".parse(";
  protected final String TEXT_45 = ");" + NL + "\t\t    enddf_";
  protected final String TEXT_46 = ".parse(";
  protected final String TEXT_47 = ");" + NL + "\t\t    " + NL + "\t\t    java.util.Calendar startCal_";
  protected final String TEXT_48 = " = startdf_";
  protected final String TEXT_49 = ".getCalendar();" + NL + "\t\t    java.util.Calendar endCal_";
  protected final String TEXT_50 = " = enddf_";
  protected final String TEXT_51 = ".getCalendar();" + NL + "\t\t\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_52 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_54 = "\") == null){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_55 = "\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tsforceConn_";
  protected final String TEXT_57 = " = (org.talend.salesforce.SforceConnection)globalMap.get(\"conn_";
  protected final String TEXT_58 = "\");" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "            \t\t";
  protected final String TEXT_60 = NL + "                \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_61 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_62 = ");" + NL + "                \t";
  protected final String TEXT_63 = NL + "                \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";" + NL + "                \t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_67 = " = \t" + NL + "\t\t\t\t\t\tnew org.talend.salesforce.SforceOAuthConnection.Builder(";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ", decryptedQauthClientPwd_";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ")" + NL + "            \t\t\t\t";
  protected final String TEXT_74 = NL + "                \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_75 = ")" + NL + "            \t\t\t\t";
  protected final String TEXT_76 = NL + "            \t\t\t\t.setTimeout(";
  protected final String TEXT_77 = ").needCompression(";
  protected final String TEXT_78 = ")" + NL + "                        \t";
  protected final String TEXT_79 = NL + "                        \t\t.setClientID(";
  protected final String TEXT_80 = ");" + NL + "                        \t";
  protected final String TEXT_81 = NL + "                        \t.build();" + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "                \t\t\tString decryptedPwd_";
  protected final String TEXT_83 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_84 = ");" + NL + "                \t\t";
  protected final String TEXT_85 = NL + "                \t\t\tString decryptedPwd_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "                \t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_89 = " = System.getProperties();" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_90 = ".put(\"socksProxyHost\",";
  protected final String TEXT_91 = ");  " + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_92 = ".put(\"socksProxyPort\",";
  protected final String TEXT_93 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_94 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_96 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_97 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = NL + "        " + NL + "        \t\t\t";
  protected final String TEXT_100 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_101 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "; ";
  protected final String TEXT_106 = NL + "\t\t\t" + NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_107 = " = " + NL + "            \t\t\tnew org.talend.salesforce.SforceBasicConnection.Builder(";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ", decryptedPassword_";
  protected final String TEXT_110 = ")" + NL + "            \t\t\t\t.setTimeout(";
  protected final String TEXT_111 = ").needCompression(";
  protected final String TEXT_112 = ")" + NL + "                        \t";
  protected final String TEXT_113 = NL + "                        \t\t.setClientID(";
  protected final String TEXT_114 = ");" + NL + "                        \t";
  protected final String TEXT_115 = NL + "                        \t.build();" + NL + "\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_117 = " = new org.talend.salesforce.SforceManagementImpl(sforceConn_";
  protected final String TEXT_118 = ");" + NL + "\t\t\t";
  protected final String TEXT_119 = "\t\t\t\t" + NL + "" + NL + "\tcom.salesforce.soap.partner.sobject.SObject[] so_";
  protected final String TEXT_120 = " = null;" + NL + "\tcom.salesforce.soap.partner.ID[] ids_";
  protected final String TEXT_121 = " = sfMgr_";
  protected final String TEXT_122 = ".getUpdated(";
  protected final String TEXT_123 = ", startCal_";
  protected final String TEXT_124 = ", endCal_";
  protected final String TEXT_125 = ");" + NL + "\t" + NL + "\tif(ids_";
  protected final String TEXT_126 = " !=null && ids_";
  protected final String TEXT_127 = ".length > 0){" + NL + "\t\t\t\t\t\t" + NL + "\t\tint newMax_";
  protected final String TEXT_128 = " = 0;" + NL + "\t\tint newBase_";
  protected final String TEXT_129 = " = 0;" + NL + "\t\t" + NL + "\t\twhile (newMax_";
  protected final String TEXT_130 = " < ids_";
  protected final String TEXT_131 = ".length){" + NL + "\t\t" + NL + "\t\t\tnewBase_";
  protected final String TEXT_132 = " = newMax_";
  protected final String TEXT_133 = ";" + NL + "\t\t\tnewMax_";
  protected final String TEXT_134 = " += 2000;" + NL + "\t\t\t" + NL + "\t\t\tif (newMax_";
  protected final String TEXT_135 = " > ids_";
  protected final String TEXT_136 = ".length){" + NL + "\t\t\t\tnewMax_";
  protected final String TEXT_137 = " = ids_";
  protected final String TEXT_138 = ".length;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tcom.salesforce.soap.partner.ID[] localIds_";
  protected final String TEXT_139 = " = new com.salesforce.soap.partner.ID[newMax_";
  protected final String TEXT_140 = "-newBase_";
  protected final String TEXT_141 = "];" + NL + "" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_142 = "=newBase_";
  protected final String TEXT_143 = ";i_";
  protected final String TEXT_144 = " < newMax_";
  protected final String TEXT_145 = ";i_";
  protected final String TEXT_146 = "++){" + NL + "\t\t\t\tlocalIds_";
  protected final String TEXT_147 = "[i_";
  protected final String TEXT_148 = "-newBase_";
  protected final String TEXT_149 = "] = ids_";
  protected final String TEXT_150 = "[i_";
  protected final String TEXT_151 = "];" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tso_";
  protected final String TEXT_152 = " = sfMgr_";
  protected final String TEXT_153 = ".retrieve(localIds_";
  protected final String TEXT_154 = ",";
  protected final String TEXT_155 = ",\"";
  protected final String TEXT_156 = "\");" + NL + "    \t\t" + NL + "    \t\tif(so_";
  protected final String TEXT_157 = " != null){" + NL + "    \t\t" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_158 = "=0;i_";
  protected final String TEXT_159 = "<so_";
  protected final String TEXT_160 = ".length;i_";
  protected final String TEXT_161 = "++){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_162 = " ++;" + NL + "\t\t\t\t" + NL + "\t\t\t  if(so_";
  protected final String TEXT_163 = "[i_";
  protected final String TEXT_164 = "]!=null){" + NL + "\t\t\t\torg.apache.axiom.om.OMElement[] fields_";
  protected final String TEXT_165 = " = so_";
  protected final String TEXT_166 = "[i_";
  protected final String TEXT_167 = "].getExtraElement();" + NL + "\t\t\t\tint len_";
  protected final String TEXT_168 = " = fields_";
  protected final String TEXT_169 = ".length;";
  protected final String TEXT_170 = "\t\t\t\t\t\t" + NL + "\t\t\t\t    \t\tif (";
  protected final String TEXT_171 = " < len_";
  protected final String TEXT_172 = " &&  fields_";
  protected final String TEXT_173 = "[";
  protected final String TEXT_174 = "]!=null && fields_";
  protected final String TEXT_175 = "[";
  protected final String TEXT_176 = "].getText() != null && !\"\".equals(fields_";
  protected final String TEXT_177 = "[";
  protected final String TEXT_178 = "].getText())){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = fields_";
  protected final String TEXT_182 = "[";
  protected final String TEXT_183 = "].getText();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ParserUtils.parseTo_Date(fields_";
  protected final String TEXT_187 = "[";
  protected final String TEXT_188 = "].getText(), ";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = fields_";
  protected final String TEXT_193 = "[";
  protected final String TEXT_194 = "].getText().getBytes();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ParserUtils.parseTo_";
  protected final String TEXT_198 = "(fields_";
  protected final String TEXT_199 = "[";
  protected final String TEXT_200 = "].getText());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_201 = "\t\t\t" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_205 = NL;

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

	log = new LogUtil(node);	
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
   	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));

	String cid = node.getUniqueName();

   	String passwordFieldName = "";

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns(); 
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		if (outgoingConns != null && outgoingConns.size() > 0){
			
			String sd = ElementParameterParser.getValue(node, "__START_DATE__");
			String ed = ElementParameterParser.getValue(node, "__END_DATE__");

			String username = ElementParameterParser.getValue(node, "__USER__");

			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String module = ElementParameterParser.getValue(node, "__MODULENAME__");
			String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__").trim();
			module = (("CustomModule").equals(module)) ? customModulename : "\""+module+"\"";
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
			
			boolean bulkConnection = false; //for tSalesforceOAuth.javajet
			
			String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(sd);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ed);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    if(useExistingConn){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_55);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_58);
    
			}else{
				if(useOAuth){
					String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
            		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
            		
    stringBuffer.append(TEXT_59);
    
                	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
                	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_62);
    
                	} else {
                	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_65);
    
                	}
                	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
            		
            		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
            		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
					
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_73);
    
            				if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
            				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_75);
    
            				}
            				
    stringBuffer.append(TEXT_76);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_78);
    
                        	if(clientID != null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                        	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_80);
    
                        	}
                        	
    stringBuffer.append(TEXT_81);
    
				}else{
					if(useProxy){
						passwordFieldName = "__PROXY_PASSWORD__";
        				if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                		
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_84);
    
                		} else {
                		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_87);
    
                		}
						
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
					}
					
    stringBuffer.append(TEXT_98);
    
        			passwordFieldName = "__PASS__";
        			
    stringBuffer.append(TEXT_99);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_112);
    
                        	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                        	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_114);
    
                        	}
                        	
    stringBuffer.append(TEXT_115);
    
				}
				log.info(log.str("Login successful."));
			}
			
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (IMetadataColumn column: columnList){
				if(sb.length() == 0){
					sb.append(column.getLabel());
				}else{
					sb.append(","+column.getLabel());
				}
			}
			
			String fieldlist = sb.toString();
			
			IConnection outgoingConn = outgoingConns.get(0);
			
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
				log.info(log.str("Retrieving records from the datasource."));

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(module );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(fieldlist );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
     
						for( int i = 0; i < columnList.size(); i++) {
						
							IMetadataColumn column = columnList.get(i);
							
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_170);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_178);
    
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
								
    stringBuffer.append(TEXT_179);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    
								} else if(javaType == JavaTypesManager.DATE) { // Date
								
    stringBuffer.append(TEXT_184);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_188);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_189);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
								
    stringBuffer.append(TEXT_190);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    
								} else  { // other
								
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_197);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
     
								}
								
    stringBuffer.append(TEXT_201);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_204);
     
						}
						log.debug(log.str("Retrieving the record "), log.var("nb_line"), log.str("."));
			}
		
		}
	}
}

    stringBuffer.append(TEXT_205);
    return stringBuffer.toString();
  }
}
