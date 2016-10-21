package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;

public class TTeradataFastLoadUtilityMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadUtilityMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadUtilityMainJava result = new TTeradataFastLoadUtilityMainJava();
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
  protected final String TEXT_71 = "+\".script\");" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_72 = " = new java.io.FileWriter(file_";
  protected final String TEXT_73 = ");" + NL;
  protected final String TEXT_74 = NL + "try{" + NL + "StringBuilder script_";
  protected final String TEXT_75 = " = new StringBuilder();" + NL + "fw_";
  protected final String TEXT_76 = ".write(\"SESSIONS 8;\"+ \"";
  protected final String TEXT_77 = "\");" + NL + "fw_";
  protected final String TEXT_78 = ".write(\"SET RECORD VARTEXT \\\"\"+";
  protected final String TEXT_79 = "+\"\\\";\"+ \"";
  protected final String TEXT_80 = "\");" + NL + "\t        ";
  protected final String TEXT_81 = NL;
  protected final String TEXT_82 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_83 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = "; ";
  protected final String TEXT_88 = NL + NL + "fw_";
  protected final String TEXT_89 = ".write(\"LOGON \"+";
  protected final String TEXT_90 = "+\"/\"+";
  protected final String TEXT_91 = "+\",\"+decryptedPassword_";
  protected final String TEXT_92 = "+\";\"+ \"";
  protected final String TEXT_93 = "\");";
  protected final String TEXT_94 = NL + "fw_";
  protected final String TEXT_95 = ".write(\"DELETE FROM \"+ ";
  protected final String TEXT_96 = " + \".\" + ";
  protected final String TEXT_97 = " + \" ALL;\"+ \"";
  protected final String TEXT_98 = "\");";
  protected final String TEXT_99 = NL + "fw_";
  protected final String TEXT_100 = ".write(\"DEFINE \"+ \"";
  protected final String TEXT_101 = "\");";
  protected final String TEXT_102 = NL + "\t\tfw_";
  protected final String TEXT_103 = ".write(\"";
  protected final String TEXT_104 = "\"+\" (VARCHAR(";
  protected final String TEXT_105 = ")),\"+ \"";
  protected final String TEXT_106 = "\");" + NL + "\t";
  protected final String TEXT_107 = NL + "\t\t\tfw_";
  protected final String TEXT_108 = ".write(\"";
  protected final String TEXT_109 = "\"+\" (VARCHAR(";
  protected final String TEXT_110 = "))\"+ \"";
  protected final String TEXT_111 = "\");" + NL + "\t";
  protected final String TEXT_112 = NL + "fw_";
  protected final String TEXT_113 = ".write(\"FILE=\"+";
  protected final String TEXT_114 = "+\";\"+ \"";
  protected final String TEXT_115 = "\");" + NL + "fw_";
  protected final String TEXT_116 = ".write(\"BEGIN LOADING \"+ ";
  protected final String TEXT_117 = " + \".\" + ";
  protected final String TEXT_118 = "+\" \"+";
  protected final String TEXT_119 = "+\" CHECKPOINT ";
  protected final String TEXT_120 = ";\"+ \"";
  protected final String TEXT_121 = "\");" + NL + "fw_";
  protected final String TEXT_122 = ".write(\"ERRLIMIT ";
  protected final String TEXT_123 = ";\"+ \"";
  protected final String TEXT_124 = "\");";
  protected final String TEXT_125 = NL + "fw_";
  protected final String TEXT_126 = ".write(\"INSERT INTO \"+ ";
  protected final String TEXT_127 = " + \".\" + ";
  protected final String TEXT_128 = "+\" (";
  protected final String TEXT_129 = ") VALUES (";
  protected final String TEXT_130 = ");\"+ \"";
  protected final String TEXT_131 = "\");";
  protected final String TEXT_132 = NL + "fw_";
  protected final String TEXT_133 = ".write(\"END LOADING;\"+ \"";
  protected final String TEXT_134 = "\");" + NL + "fw_";
  protected final String TEXT_135 = ".write(\"LOGOFF;\"+ \"";
  protected final String TEXT_136 = "\");" + NL;
  protected final String TEXT_137 = NL + "fw_";
  protected final String TEXT_138 = ".close();" + NL;
  protected final String TEXT_139 = NL + "String sb_";
  protected final String TEXT_140 = "= new String(\"fastload -c \"+";
  protected final String TEXT_141 = "+\" < \\\"\"+";
  protected final String TEXT_142 = "+";
  protected final String TEXT_143 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_144 = "+\"\\\" 2>&1\");";
  protected final String TEXT_145 = "\t" + NL + "String sb_";
  protected final String TEXT_146 = "= new String(\"fastload < \\\"\"+";
  protected final String TEXT_147 = "+";
  protected final String TEXT_148 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_149 = "+\"\\\" 2>&1\");";
  protected final String TEXT_150 = NL + "\tlog.info(\"";
  protected final String TEXT_151 = " - Executing '\" + sb_";
  protected final String TEXT_152 = " + \"'.\");";
  protected final String TEXT_153 = NL + "final Process process_";
  protected final String TEXT_154 = " = Runtime.getRuntime().exec(new String[]{\"cmd\",\"/c\",sb_";
  protected final String TEXT_155 = "}); ";
  protected final String TEXT_156 = NL + "final Process process_";
  protected final String TEXT_157 = " = Runtime.getRuntime().exec(new String[]{\"sh\",\"-c\",sb_";
  protected final String TEXT_158 = "});";
  protected final String TEXT_159 = NL + "Thread normal_";
  protected final String TEXT_160 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_161 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_162 = NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_163 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_164 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_165 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_166 = NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_167 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_168 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_169 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_170 = ".interrupt();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_171 = "_EXIT_VALUE\", process_";
  protected final String TEXT_172 = ".exitValue());" + NL;
  protected final String TEXT_173 = NL + "\tif(process_";
  protected final String TEXT_174 = ".exitValue()>=";
  protected final String TEXT_175 = ") {" + NL + "\t\tthrow new RuntimeException(\"Fastload returned exit code \"+process_";
  protected final String TEXT_176 = ".exitValue());" + NL + "\t}";
  protected final String TEXT_177 = NL;
  protected final String TEXT_178 = NL + "    log.info(\"";
  protected final String TEXT_179 = " - Excute '\" + sb_";
  protected final String TEXT_180 = " + \"' has finished.\");";
  protected final String TEXT_181 = NL + "}finally{" + NL + "\ttry{" + NL + "\t\tfile_";
  protected final String TEXT_182 = ".delete();" + NL + "\t}catch(Exception e_";
  protected final String TEXT_183 = "){";
  protected final String TEXT_184 = NL + "\t}" + NL + "}";
  protected final String TEXT_185 = NL;

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

String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");

String table= ElementParameterParser.getValue(node, "__TABLE__");

String dbhost= ElementParameterParser.getValue(node, "__HOST__");
String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean returnCodeDie= ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__").equals("true");
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");

String checkPoint= ElementParameterParser.getValue(node, "__CHECK_POINT__");

String errorFiles= ElementParameterParser.getValue(node, "__ERRORFILES__");

String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");

String errLimit = ElementParameterParser.getValue(node, "__ERRLIMIT__");

String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
//windows line separator as default
String lineSeparator = "\\r\\n";
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}else {
	//Unix line separator
	lineSeparator = "\\n";
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
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_80);
    
String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_81);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    if(dbhost!=null && !"\"\"".equals(dbhost)){
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_93);
    
if(("CLEAR").equals(tableAction)){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_98);
    
}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_101);
    //Layout---------------------------------------------------------------
    
if(columnList!=null){
	int counter = 1;
	for(IMetadataColumn column:columnList){	
		if( columnList.size() != counter){	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_106);
    
		} else {
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_111);
     	}
		counter++;
	}
}

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(errorFiles);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(checkPoint);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(errLimit);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_124);
    //SQL statements-------------------------------------------------------
    
StringBuilder insertColSQL = new StringBuilder();
StringBuilder insertValueSQL = new StringBuilder();
if(columnList!=null){
	String columnName = "";
 	for(IMetadataColumn column:columnList){	
 		columnName= column.getOriginalDbColumnName();
 		if(insertColSQL.length()>0){
 			insertColSQL.append(",");
 		}
 		insertColSQL.append(columnName);
 		
 		if(insertValueSQL.length()>0){
 			insertValueSQL.append(",");
 		}
 		insertValueSQL.append(":").append(columnName);
	}
}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(insertColSQL.toString());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_131);
    //Import file----------------------------------------------------------
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_136);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    //run fastload command----------------------------------------------------
    if("true".equals(defineCharset)) {
	if(!("".equals(charset))) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_144);
    }} else {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_149);
    }
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    if(("Windows").equals(execution)){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    }else{
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    
if(returnCodeDie) {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    	
}

    stringBuffer.append(TEXT_177);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    log4jCodeGenerateUtil.logError(node,"warn","e_"+cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    return stringBuffer.toString();
  }
}
