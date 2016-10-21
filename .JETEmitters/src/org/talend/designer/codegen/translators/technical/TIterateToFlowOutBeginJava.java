package org.talend.designer.codegen.translators.technical;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TIterateToFlowOutBeginJava
{
  protected static String nl;
  public static synchronized TIterateToFlowOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIterateToFlowOutBeginJava result = new TIterateToFlowOutBeginJava();
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
  protected final String TEXT_39 = NL + "OnSubjobOkStruct";
  protected final String TEXT_40 = " struct_";
  protected final String TEXT_41 = " = new OnSubjobOkStruct";
  protected final String TEXT_42 = "();";
  protected final String TEXT_43 = NL + "struct_";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = "  = ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "\tlog.trace(\"struct_";
  protected final String TEXT_48 = " - \" + struct_";
  protected final String TEXT_49 = ".toLogString());";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\t";
  protected final String TEXT_52 = NL + "\t\tsynchronized (";
  protected final String TEXT_53 = ".this.globalMap) {" + NL + "\t";
  protected final String TEXT_54 = NL + "\t\tsynchronized (";
  protected final String TEXT_55 = ".this.obj) {" + NL + "\t";
  protected final String TEXT_56 = NL + "\t\t    if(";
  protected final String TEXT_57 = ".this.globalMap.containsKey(\"";
  protected final String TEXT_58 = "\")){" + NL + "\t\t    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_59 = "> list_";
  protected final String TEXT_60 = " = (java.util.List<OnSubjobOkStruct";
  protected final String TEXT_61 = ">)";
  protected final String TEXT_62 = ".this.globalMap.get(\"";
  protected final String TEXT_63 = "\"); " + NL + "\t\t    \tlist_";
  protected final String TEXT_64 = ".add(struct_";
  protected final String TEXT_65 = ");" + NL + "\t\t    }else{" + NL + "\t\t    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_66 = "> list_";
  protected final String TEXT_67 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<OnSubjobOkStruct";
  protected final String TEXT_68 = ">());" + NL + "\t\t    \tlist_";
  protected final String TEXT_69 = ".add(struct_";
  protected final String TEXT_70 = ");" + NL + "\t\t    \t";
  protected final String TEXT_71 = ".this.globalMap.put(\"";
  protected final String TEXT_72 = "\",list_";
  protected final String TEXT_73 = ");" + NL + "\t\t    }" + NL + "\t\t}";
  protected final String TEXT_74 = NL + "    if(globalMap.get(\"";
  protected final String TEXT_75 = "\") != null){" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_76 = "> list_";
  protected final String TEXT_77 = " = (java.util.List<OnSubjobOkStruct";
  protected final String TEXT_78 = ">)globalMap.get(\"";
  protected final String TEXT_79 = "\"); " + NL + "    \tlist_";
  protected final String TEXT_80 = ".add(struct_";
  protected final String TEXT_81 = ");" + NL + "    }else{" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_82 = "> list_";
  protected final String TEXT_83 = " = new java.util.ArrayList<OnSubjobOkStruct";
  protected final String TEXT_84 = ">();" + NL + "    \tlist_";
  protected final String TEXT_85 = ".add(struct_";
  protected final String TEXT_86 = ");" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_87 = "\",list_";
  protected final String TEXT_88 = ");" + NL + "    }";

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
IProcess currentProcess = node.getProcess();

boolean isInThread = false;

List< ? extends IConnection> connsInIterate = node.getIncomingConnections(EConnectionType.ITERATE);
if(connsInIterate != null && connsInIterate.size() > 0){
	IConnection conn = connsInIterate.get(0);
	isInThread = "true".equals(ElementParameterParser.getValue(conn, "__ENABLE_PARALLEL__")); 
}

String destination = ElementParameterParser.getValue(
    node,
    "__DESTINATION__"
);

List<Map<String, String>> mapping =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__MAPPING__"
    );

    stringBuffer.append(TEXT_39);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_42);
    
for (Map<String, String> mappingColumn : mapping) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(mappingColumn.get("SCHEMA_COLUMN"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(mappingColumn.get("VALUE"));
    stringBuffer.append(TEXT_46);
    
}
if(log.isActive()){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
}

    stringBuffer.append(TEXT_50);
    if(isInThread){//tIterateToFlow is a little special, it link with OnSubJobOK in virtual level, so, in Multi-Thread, there should be synchronized.
    stringBuffer.append(TEXT_51);
    
	// if codeGenArgument.getIsRunInMultiThread() is true, the job.this.globalMap will wrapped with synchronizedMap, use synchronized(job.this.globalMap)
	// when codeGenArgument.getIsRunInMultiThread() is false, the job.this.globalMap is HashMap, use synchronized(job.this.object) when do the job.this.globalMap.put() operation(tMap,tIterateToFlow).
	if(codeGenArgument.getIsRunInMultiThread()){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(currentProcess.getName());
    stringBuffer.append(TEXT_53);
    }else{
    stringBuffer.append(TEXT_54);
    stringBuffer.append(currentProcess.getName());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }else{
    stringBuffer.append(TEXT_74);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    return stringBuffer.toString();
  }
}