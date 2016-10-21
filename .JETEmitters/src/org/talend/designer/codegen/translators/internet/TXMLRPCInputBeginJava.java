package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;

public class TXMLRPCInputBeginJava
{
  protected static String nl;
  public static synchronized TXMLRPCInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLRPCInputBeginJava result = new TXMLRPCInputBeginJava();
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
  protected final String TEXT_39 = NL + "org.apache.xmlrpc.client.XmlRpcClientConfigImpl config";
  protected final String TEXT_40 = "= new org.apache.xmlrpc.client.XmlRpcClientConfigImpl();" + NL + "config";
  protected final String TEXT_41 = ".setServerURL(new java.net.URL(";
  protected final String TEXT_42 = "));" + NL + "config";
  protected final String TEXT_43 = ".setEnabledForExtensions(true);  " + NL + "config";
  protected final String TEXT_44 = ".setConnectionTimeout(60 * 1000);" + NL + "config";
  protected final String TEXT_45 = ".setReplyTimeout(60 * 1000);";
  protected final String TEXT_46 = NL + "\tconfig";
  protected final String TEXT_47 = ".setBasicUserName(";
  protected final String TEXT_48 = ");" + NL + "\t";
  protected final String TEXT_49 = NL + "    ";
  protected final String TEXT_50 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_51 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "; ";
  protected final String TEXT_56 = NL + "\t" + NL + "\t" + NL + "\tconfig";
  protected final String TEXT_57 = ".setBasicPassword(decryptedPassword_";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "org.apache.xmlrpc.client.XmlRpcClient client";
  protected final String TEXT_60 = " = new org.apache.xmlrpc.client.XmlRpcClient();" + NL + "// use Commons HttpClient as transport" + NL + " client";
  protected final String TEXT_61 = ".setTransportFactory(" + NL + "              new org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory(client";
  protected final String TEXT_62 = "));" + NL + "        // set configuration" + NL + "\t\tclient";
  protected final String TEXT_63 = ".setConfig(config";
  protected final String TEXT_64 = ");" + NL + "        // make the a regular call" + NL + "        Object[] params_";
  protected final String TEXT_65 = " = new Object[] {         " + NL + "\t  ";
  protected final String TEXT_66 = NL + "\t        \t";
  protected final String TEXT_67 = "," + NL + "\t\t    ";
  protected final String TEXT_68 = "      " + NL + "        };  " + NL + "        Object[] results_";
  protected final String TEXT_69 = " = null;" + NL + "\t    int nb_line_";
  protected final String TEXT_70 = " = 0;\t " + NL + "\t    ";
  protected final String TEXT_71 = NL + "        Object reValue";
  protected final String TEXT_72 = " = client";
  protected final String TEXT_73 = ".execute(";
  protected final String TEXT_74 = ", params_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "        " + NL + "        Object[] tempArray_";
  protected final String TEXT_77 = " = null;" + NL + "\t\tif (reValue";
  protected final String TEXT_78 = " instanceof Object[]) {\t\t\t" + NL + "\t\t\ttempArray_";
  protected final String TEXT_79 = " = (Object[]) reValue";
  protected final String TEXT_80 = ";" + NL + "\t\t} else {" + NL + "\t\t\ttempArray_";
  protected final String TEXT_81 = " = new Object[1];" + NL + "\t\t\ttempArray_";
  protected final String TEXT_82 = "[0] = reValue";
  protected final String TEXT_83 = ";" + NL + "\t\t}" + NL + "        for (int i_";
  protected final String TEXT_84 = " = 0; i_";
  protected final String TEXT_85 = " < tempArray_";
  protected final String TEXT_86 = ".length; i_";
  protected final String TEXT_87 = "++) {" + NL + "\t\t    results_";
  protected final String TEXT_88 = " = new Object[";
  protected final String TEXT_89 = "];\t\t    " + NL + "\t\t\t" + NL + "\t\t\tif (tempArray_";
  protected final String TEXT_90 = "[i_";
  protected final String TEXT_91 = "] instanceof java.util.Map) {" + NL + "\t\t\t\tjava.util.Map map_";
  protected final String TEXT_92 = " = (java.util.Map)tempArray_";
  protected final String TEXT_93 = "[i_";
  protected final String TEXT_94 = "];" + NL + "                java.util.Collection values_";
  protected final String TEXT_95 = " = map_";
  protected final String TEXT_96 = ".values();" + NL + "                int len_";
  protected final String TEXT_97 = " = Math.min(values_";
  protected final String TEXT_98 = ".size(), results_";
  protected final String TEXT_99 = ".length);" + NL + "                int k_";
  protected final String TEXT_100 = " = 0;" + NL + "                for (java.util.Iterator iter_";
  protected final String TEXT_101 = " = values_";
  protected final String TEXT_102 = ".iterator(); iter_";
  protected final String TEXT_103 = ".hasNext() && k_";
  protected final String TEXT_104 = " < len_";
  protected final String TEXT_105 = "; k_";
  protected final String TEXT_106 = "++) {" + NL + "                    results_";
  protected final String TEXT_107 = "[k_";
  protected final String TEXT_108 = "] =iter_";
  protected final String TEXT_109 = ".next();" + NL + "                    if(results_";
  protected final String TEXT_110 = "[k_";
  protected final String TEXT_111 = "] instanceof Object[] ){" + NL + "                    \tjava.util.List<Object> val_";
  protected final String TEXT_112 = " = new java.util.ArrayList<Object>();" + NL + "                    \t//results_";
  protected final String TEXT_113 = " = org.talend.rpc.util.ArrayUtilities.dumpMapInArray((Object[])results_";
  protected final String TEXT_114 = "[k_";
  protected final String TEXT_115 = "], val_";
  protected final String TEXT_116 = ").toArray();" + NL + "                    \tresults_";
  protected final String TEXT_117 = "[k_";
  protected final String TEXT_118 = "] = org.talend.rpc.util.ArrayUtilities.dumpMapInArray((Object[])results_";
  protected final String TEXT_119 = "[k_";
  protected final String TEXT_120 = "], val_";
  protected final String TEXT_121 = ").toArray();" + NL + "" + NL + "                    }" + NL + "                    else " + NL + "                     results_";
  protected final String TEXT_122 = "[k_";
  protected final String TEXT_123 = "] =String.valueOf(results_";
  protected final String TEXT_124 = "[k_";
  protected final String TEXT_125 = "]);" + NL + "                    \t" + NL + "                }\t\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\tresults_";
  protected final String TEXT_126 = "[0] = String.valueOf(tempArray_";
  protected final String TEXT_127 = "[i_";
  protected final String TEXT_128 = "]);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "        nb_line_";
  protected final String TEXT_129 = "++;" + NL + "\t       " + NL + "// for output";
  protected final String TEXT_130 = NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_131 = " < results_";
  protected final String TEXT_132 = ".length && results_";
  protected final String TEXT_133 = "[";
  protected final String TEXT_134 = "]!=null){\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = results_";
  protected final String TEXT_138 = "[";
  protected final String TEXT_139 = "].toString();";
  protected final String TEXT_140 = NL + "\t\t\t\t\t";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_143 = "[";
  protected final String TEXT_144 = "], ";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = results_";
  protected final String TEXT_149 = "[";
  protected final String TEXT_150 = "].getBytes();" + NL + "\t";
  protected final String TEXT_151 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ParserUtils.parseTo_";
  protected final String TEXT_154 = "(results_";
  protected final String TEXT_155 = "[";
  protected final String TEXT_156 = "]);";
  protected final String TEXT_157 = NL + "\t\t\t} else { " + NL + "\t\t\t\t\t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = ";
  protected final String TEXT_160 = ";" + NL + "\t\t\t}";
  protected final String TEXT_161 = NL + "   ";
  protected final String TEXT_162 = "  ";

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
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        List<IMetadataColumn> listColumns = metadata.getListColumns(); 
        String needAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
        String authUsername = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
		String authPassword = ElementParameterParser.getValue(node, "__AUTH_PASSWORD__");
        List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
        String  url=ElementParameterParser.getValue(node,"__SERVER-URL__");
        String  method=ElementParameterParser.getValue(node,"__METHOD__");

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
 if ("true".equals(needAuth)) {
 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(authUsername);
    stringBuffer.append(TEXT_48);
    
    String passwordFieldName = "__AUTH_PASSWORD__";
    
    stringBuffer.append(TEXT_49);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
	        for (int i = 0; i < params.size(); i++) {
	            Map<String, String> line = params.get(i);
	  
    stringBuffer.append(TEXT_66);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_67);
    
	        }
		    
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    log.debug(log.str("Invoking the method "), method, log.str("."));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    log.debug(log.str("Invoke the method "), method, log.str(" has succeeded."));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(listColumns.size() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
    			List<IMetadataColumn> columns=metadata.getListColumns();
    			int columnSize = columns.size();
    			for (int i=0;i<columnSize;i++) {//4
    				IMetadataColumn column=columns.get(i);
    				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_130);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_134);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_139);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_145);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_150);
    
					} else  { //other

    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_156);
    
					}

    stringBuffer.append(TEXT_157);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_160);
    			
				} //4
			}//3
		}//2
	}//1


    stringBuffer.append(TEXT_161);
    }
 }
 
    stringBuffer.append(TEXT_162);
    return stringBuffer.toString();
  }
}
