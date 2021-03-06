package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TJDBCOutputEndJava
{
  protected static String nl;
  public static synchronized TJDBCOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCOutputEndJava result = new TJDBCOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\tif(log.is";
  protected final String TEXT_4 = "Enabled())" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\tlog.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ");" + NL + "\t\t";
  protected final String TEXT_11 = NL + "    \t\tStringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();" + NL + "    \t   \t";
  protected final String TEXT_13 = ".append(\"Parameters:\");" + NL + "    \t   \t";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_17 = ").substring(0, 4) + \"...\");\t\t" + NL + "       \t\t\t";
  protected final String TEXT_18 = NL + "    \t\t\t\t";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");" + NL + "    \t\t\t";
  protected final String TEXT_22 = NL + "    \t\t\t";
  protected final String TEXT_23 = ".append(\" | \");" + NL + "    \t\t";
  protected final String TEXT_24 = NL + "        \tStringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();\t" + NL + "        \t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "    \t\t\t\tif(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " == null){" + NL + "    \t\t\t\t\t";
  protected final String TEXT_33 = ".append(\"<null>\");" + NL + "    \t\t\t\t}else{" + NL + "        \t\t\t\t";
  protected final String TEXT_34 = ".append(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");" + NL + "        \t\t\t}\t" + NL + "        \t\t";
  protected final String TEXT_37 = NL + "    \t\t\t";
  protected final String TEXT_38 = ".append(\"|\");" + NL + "    \t\t";
  protected final String TEXT_39 = NL + "\t";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = NL + "    if(pstmtUpdate_";
  protected final String TEXT_42 = " != null){" + NL + "" + NL + "        pstmtUpdate_";
  protected final String TEXT_43 = ".close();" + NL + "        " + NL + "    } " + NL + "    if(pstmtInsert_";
  protected final String TEXT_44 = " != null){" + NL + "" + NL + "        pstmtInsert_";
  protected final String TEXT_45 = ".close();" + NL + "        " + NL + "    }" + NL + "    if(pstmt_";
  protected final String TEXT_46 = " != null) {" + NL + "" + NL + "        pstmt_";
  protected final String TEXT_47 = ".close();" + NL + "        " + NL + "    }        ";
  protected final String TEXT_48 = NL + "    if(pstmtUpdate_";
  protected final String TEXT_49 = " != null){" + NL + "" + NL + "        pstmtUpdate_";
  protected final String TEXT_50 = ".close();" + NL + "        " + NL + "    } " + NL + "    if(pstmtInsert_";
  protected final String TEXT_51 = " != null){" + NL + "" + NL + "        pstmtInsert_";
  protected final String TEXT_52 = ".close();" + NL + "        " + NL + "    }        ";
  protected final String TEXT_53 = "                " + NL + "\t\t\t\tint[] status_";
  protected final String TEXT_54 = " = null;" + NL + "\t\t\t\tint countSum_";
  protected final String TEXT_55 = " = 0;" + NL + "                try {" + NL + "                \tif(pstmt_";
  protected final String TEXT_56 = "!=null && batchSizeCounter_";
  protected final String TEXT_57 = " > 0 ){" + NL + "                \t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tstatus_";
  protected final String TEXT_59 = " = pstmt_";
  protected final String TEXT_60 = ".executeBatch();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_62 = ": status_";
  protected final String TEXT_63 = ") {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_64 = " += (countEach_";
  protected final String TEXT_65 = " < 0 ? 0 : countEach_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t\t\t}" + NL + "            \t    }" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_67 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_68 = NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_69 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_70 = " += (countEach_";
  protected final String TEXT_71 = " < 0 ? 0 : countEach_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t}" + NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_73 = "                \t" + NL + "            \t}                                  " + NL + "            \tif(pstmt_";
  protected final String TEXT_74 = "!=null && batchSizeCounter_";
  protected final String TEXT_75 = " > 0 ){" + NL + "        \t\t\ttry {" + NL + "        \t\t\t\ttmp_batchUpdateCount_";
  protected final String TEXT_76 = " = pstmt_";
  protected final String TEXT_77 = ".getUpdateCount();" + NL + "\t\t\t\t\t}catch (java.sql.SQLException e){" + NL + "\t                \t                \t" + NL + "\t\t\t\t\t} " + NL + "\t\t\t\t\ttmp_batchUpdateCount_";
  protected final String TEXT_78 = " = tmp_batchUpdateCount_";
  protected final String TEXT_79 = " > countSum_";
  protected final String TEXT_80 = " ? tmp_batchUpdateCount_";
  protected final String TEXT_81 = " : countSum_";
  protected final String TEXT_82 = ";" + NL + "        \t    \t";
  protected final String TEXT_83 = NL + "        \t    \t\tinsertedCount_";
  protected final String TEXT_84 = " += tmp_batchUpdateCount_";
  protected final String TEXT_85 = "; " + NL + "        \t    \t";
  protected final String TEXT_86 = NL + "        \t    \t\tupdatedCount_";
  protected final String TEXT_87 = " += tmp_batchUpdateCount_";
  protected final String TEXT_88 = ";" + NL + "        \t    \t";
  protected final String TEXT_89 = NL + "        \t    \t    deletedCount_";
  protected final String TEXT_90 = " += tmp_batchUpdateCount_";
  protected final String TEXT_91 = ";" + NL + "        \t    \t";
  protected final String TEXT_92 = NL + "            \t}";
  protected final String TEXT_93 = "    " + NL + "    if(pstmt_";
  protected final String TEXT_94 = " != null) {" + NL + "" + NL + "        pstmt_";
  protected final String TEXT_95 = ".close();" + NL + "        " + NL + "    }        ";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + "\tif (commitCounter_";
  protected final String TEXT_98 = " > 0) {" + NL + "\t    ";
  protected final String TEXT_99 = NL + "\t    connection_";
  protected final String TEXT_100 = ".commit();" + NL + "\t    ";
  protected final String TEXT_101 = NL + "\t}" + NL + "\t    ";
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = NL + "\tconnection_";
  protected final String TEXT_104 = ".close();" + NL + "\t";
  protected final String TEXT_105 = NL + "\tresourceMap.put(\"finish_";
  protected final String TEXT_106 = "\", true);" + NL + "\t";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = NL + "\tnb_line_deleted_";
  protected final String TEXT_109 = "=nb_line_deleted_";
  protected final String TEXT_110 = "+ deletedCount_";
  protected final String TEXT_111 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_112 = "=nb_line_update_";
  protected final String TEXT_113 = " + updatedCount_";
  protected final String TEXT_114 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_115 = "=nb_line_inserted_";
  protected final String TEXT_116 = " + insertedCount_";
  protected final String TEXT_117 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_118 = "=nb_line_rejected_";
  protected final String TEXT_119 = " + rejectedCount_";
  protected final String TEXT_120 = ";" + NL + "\t";
  protected final String TEXT_121 = NL + "    \tif (globalMap.get(\"";
  protected final String TEXT_122 = "_NB_LINE\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_123 = "_NB_LINE\",nb_line_";
  protected final String TEXT_124 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_125 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_126 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_127 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_128 = "_NB_LINE_UPDATED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_129 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_130 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_131 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_132 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_133 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_134 = "_NB_LINE_INSERTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_135 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_136 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_137 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_138 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_139 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_140 = "_NB_LINE_DELETED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_141 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_142 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_143 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_144 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_145 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_146 = "_NB_LINE_REJECTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_147 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_148 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_149 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_150 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_151 = ");" + NL + "        }" + NL + "\t";
  protected final String TEXT_152 = NL + "        globalMap.put(\"";
  protected final String TEXT_153 = "_NB_LINE\",nb_line_";
  protected final String TEXT_154 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_155 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_156 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_157 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_158 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_159 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_160 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_161 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_162 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_163 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
			}
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
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
    	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    
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
       				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
       			}else{
       				String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
       				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    
    			}	
    			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    
       		}
    	}
   		debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
    	if(log4jEnabled){
    	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
    		for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
    			org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    			String columnName = column.getLabel();
    			boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
    			if(isPrimit){
   				
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
    			}else{
    			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    
        		}
        		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    
    		}
    	}
		trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
		
    stringBuffer.append(TEXT_39);
    
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

    stringBuffer.append(TEXT_40);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			info(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			info(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		info(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			info(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			info(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			info(str("Closing the connection to the database."));
		}else{
			info(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			info(str("Connection to the database has closed."));	
		}else{
			info(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		info(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		info(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		info(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();
dbLog = new DBLogUtil(node);
String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

//------get first reject name
String rejectConnName = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectConnName = rejectConn.getName();
}

// Close SQL statements
if(("INSERT_OR_UPDATE").equals(dataAction)) {
    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
} else if(("UPDATE_OR_INSERT").equals(dataAction)) {
    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
} else {
    //----------------------batch size
	if ((rejectConnName==null && ("true").equals(useBatchSize)&& !useExistingConnection) 
		&& (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
                	if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_67);
    
                	}else {
                	dbLog.logPrintedException("e.getMessage()");
                	
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
                	}
                	
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    if (("INSERT").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
        	    	}else if (("UPDATE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
        	    	}else if (("DELETE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
        	    	}
    stringBuffer.append(TEXT_92);
    
	}//--------end batch

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
}

    stringBuffer.append(TEXT_96);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("false").equals(useExistingConn)){
	// Commit if needed
	if (!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_101);
    
	}
	
    stringBuffer.append(TEXT_102);
    dbLog.conn().closeTry(null);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    dbLog.conn().closeDone(null);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {
	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
	} else {
	
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
	}
	if (("INSERT").equals(dataAction)) {
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if (("UPDATE").equals(dataAction)) {
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}else if (("DELETE").equals(dataAction)) {
		dbLog.state().logDeletedLines(dbLog.var("nb_line_deleted"));
	}else if("UPDATE_OR_INSERT".equals(dataAction)){
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if("INSERT_OR_UPDATE".equals(dataAction)){
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}
	if(rejectConnName != null) {
		dbLog.state().logRejectedLines(dbLog.var("nb_line_rejected"));
	}
	
    stringBuffer.append(TEXT_163);
    return stringBuffer.toString();
  }
}
