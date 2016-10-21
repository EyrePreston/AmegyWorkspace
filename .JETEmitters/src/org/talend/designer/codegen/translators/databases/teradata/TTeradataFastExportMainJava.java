package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TTeradataFastExportMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastExportMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastExportMainJava result = new TTeradataFastExportMainJava();
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
  protected final String TEXT_65 = NL + "\tString tableFullName_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = " + \".\" + ";
  protected final String TEXT_68 = ";";
  protected final String TEXT_69 = NL + "\tjava.io.File file_";
  protected final String TEXT_70 = " = new java.io.File(";
  protected final String TEXT_71 = "+";
  protected final String TEXT_72 = "+\".script\");";
  protected final String TEXT_73 = NL + "\tjava.io.File file_";
  protected final String TEXT_74 = " = new java.io.File(";
  protected final String TEXT_75 = "+";
  protected final String TEXT_76 = "+\".scr\");";
  protected final String TEXT_77 = NL + "\t" + NL + "\t";
  protected final String TEXT_78 = NL + "\t" + NL + "try{" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_79 = " = new java.io.FileWriter(file_";
  protected final String TEXT_80 = ");" + NL + "\tStringBuilder script_";
  protected final String TEXT_81 = " = new StringBuilder();" + NL + "\tfw_";
  protected final String TEXT_82 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_83 = "+\".\"+";
  protected final String TEXT_84 = "+\";\" + \"";
  protected final String TEXT_85 = "\");" + NL + "\t        " + NL + "\t";
  protected final String TEXT_86 = NL + "\t" + NL + "\t";
  protected final String TEXT_87 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_88 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = "; ";
  protected final String TEXT_93 = NL + "   \t" + NL + "\tfw_";
  protected final String TEXT_94 = ".write(\".LOGON \"+";
  protected final String TEXT_95 = "+\"/\"";
  protected final String TEXT_96 = " \"\" ";
  protected final String TEXT_97 = "+";
  protected final String TEXT_98 = "+\",\"+decryptedPassword_";
  protected final String TEXT_99 = "+\";\"+ \"";
  protected final String TEXT_100 = "\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_101 = NL + "\tfw_";
  protected final String TEXT_102 = ".write(\".BEGIN EXPORT SESSIONS 8;\"+\"";
  protected final String TEXT_103 = "\");" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\tfw_";
  protected final String TEXT_105 = ".write(\"SELECT ";
  protected final String TEXT_106 = "CAST(('' ||";
  protected final String TEXT_107 = "\"+\"";
  protected final String TEXT_108 = "\");" + NL + "\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_110 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_111 = " AS CHAR(";
  protected final String TEXT_112 = ")),'')) || '\"+";
  protected final String TEXT_113 = "+\"' ||\"+\"";
  protected final String TEXT_114 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_116 = ".write(\"cast( ";
  protected final String TEXT_117 = " as CHAR(";
  protected final String TEXT_118 = ")),\"+\"";
  protected final String TEXT_119 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_122 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_123 = " AS VARCHAR(";
  protected final String TEXT_124 = ")),''))) AS CHAR(";
  protected final String TEXT_125 = "))\"+\"";
  protected final String TEXT_126 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_128 = ".write(\"cast( ";
  protected final String TEXT_129 = " as CHAR(";
  protected final String TEXT_130 = "))\"+\"";
  protected final String TEXT_131 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t";
  protected final String TEXT_133 = NL + "\t" + NL + "\t\tfw_";
  protected final String TEXT_134 = ".write(\"FROM \"+ ";
  protected final String TEXT_135 = " + \".\" + ";
  protected final String TEXT_136 = "+\";\"+\"";
  protected final String TEXT_137 = "\");" + NL + "\t";
  protected final String TEXT_138 = NL + "\t\tfw_";
  protected final String TEXT_139 = ".write(";
  protected final String TEXT_140 = " +\";\"+\"";
  protected final String TEXT_141 = "\");" + NL + "\t";
  protected final String TEXT_142 = NL + "\t" + NL + "\t";
  protected final String TEXT_143 = NL + "\tfw_";
  protected final String TEXT_144 = ".write(\".EXPORT OUTFILE \\\"\"+";
  protected final String TEXT_145 = "+\".data\\\" FORMAT TEXT mode record;\"+\"";
  protected final String TEXT_146 = "\");" + NL + "\tfw_";
  protected final String TEXT_147 = ".write(\".END EXPORT;\"+\"";
  protected final String TEXT_148 = "\");" + NL + "\tfw_";
  protected final String TEXT_149 = ".write(\".LOGOFF;\"+\"";
  protected final String TEXT_150 = "\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_151 = NL + "\tfw_";
  protected final String TEXT_152 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_153 = NL + "\tString sb__";
  protected final String TEXT_154 = " = null;" + NL + "\t";
  protected final String TEXT_155 = NL + "\tsb__";
  protected final String TEXT_156 = " = \"fexp < \\\"\"+";
  protected final String TEXT_157 = "+";
  protected final String TEXT_158 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_159 = "+\"\\\" 2>&1\";" + NL + "\tString[] sb_";
  protected final String TEXT_160 = " = {\"cmd\",\"/c\", sb__";
  protected final String TEXT_161 = "};" + NL + "\t";
  protected final String TEXT_162 = NL + "\tsb__";
  protected final String TEXT_163 = " = \"fexp < \"+";
  protected final String TEXT_164 = "+";
  protected final String TEXT_165 = "+\".scr\"+\" > \\\"\"+";
  protected final String TEXT_166 = "+\"\\\" 2>&1\";" + NL + "\tString[] sb_";
  protected final String TEXT_167 = " = {\"sh\",\"-c\",sb__";
  protected final String TEXT_168 = "};" + NL + "\t";
  protected final String TEXT_169 = NL + "\t";
  protected final String TEXT_170 = NL + "\t\tlog.info(\"";
  protected final String TEXT_171 = " - Executing command '\" + sb__";
  protected final String TEXT_172 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_173 = NL + "\tfinal Process process_";
  protected final String TEXT_174 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_175 = ");" + NL + "\t" + NL + "\tThread normal_";
  protected final String TEXT_176 = " = new Thread() {" + NL + "\t    public void run() {" + NL + "\t    \ttry {" + NL + "\t    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_177 = ".getInputStream()));" + NL + "\t    \t\tString line = \"\";" + NL + "\t    \t\t" + NL + "\t    \t\ttry {" + NL + "\t    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t    \t\t\t\tSystem.out.println(line);" + NL + "\t    \t        }" + NL + "\t    \t    } finally {" + NL + "\t    \t         reader.close();" + NL + "\t    \t    }" + NL + "\t        }catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_178 = NL + "\t    \t\tioe.printStackTrace();" + NL + "\t    \t}" + NL + "\t    }" + NL + "\t};" + NL + "\tnormal_";
  protected final String TEXT_179 = ".start();" + NL + "\t" + NL + "\tThread error_";
  protected final String TEXT_180 = " = new Thread() {" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_181 = ".getErrorStream()));" + NL + "\t\t\t\tString line = \"\";" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\tSystem.err.println(line); " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} finally {" + NL + "\t\t\t\t\treader.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t   ioe.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t};" + NL + "\terror_";
  protected final String TEXT_183 = ".start();" + NL + "\t" + NL + "\tprocess_";
  protected final String TEXT_184 = ".waitFor();" + NL + "\t" + NL + "\tnormal_";
  protected final String TEXT_185 = ".interrupt();" + NL + "\t" + NL + "\terror_";
  protected final String TEXT_186 = ".interrupt();" + NL + "\t" + NL + "\t";
  protected final String TEXT_187 = NL + "\t\tlog.info(\"";
  protected final String TEXT_188 = " - Excute '\" + sb__";
  protected final String TEXT_189 = " + \"' has finished.\");" + NL + "\t";
  protected final String TEXT_190 = NL + "}finally{" + NL + "\ttry{" + NL + "\t\tfile_";
  protected final String TEXT_191 = ".delete();" + NL + "\t}catch(Exception e_";
  protected final String TEXT_192 = "){";
  protected final String TEXT_193 = NL + "\t}" + NL + "}";
  protected final String TEXT_194 = NL;

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

String host = ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");

String table= ElementParameterParser.getValue(node, "__TABLE__");
String logDB = ElementParameterParser.getValue(node, "__LOG_DB__");
String logTable = ElementParameterParser.getValue(node, "__LOG_TABLE__");

boolean needHost = ("".equals(host) || "\"\"".equals(host)) ? false : true;
logDB = ("".equals(logDB) || "\"\"".equals(logDB)) ? dbname : logDB;
logTable = ("".equals(logTable) || "\"\"".equals(logTable)) ? table + "+\"_lt\"" : logTable;

boolean useQuery = "true".equals(ElementParameterParser.getValue(node, "__USE_QUERY__"));
String query = ElementParameterParser.getValue(node, "__QUERY__"); 
query = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(query);

String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String exportedFile= ElementParameterParser.getValue(node, "__EXPORTED_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

//windows line separator as default
String lineSeparator = "\\r\\n";

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(exportedFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	exportedFile = exportedFile.replaceAll("/", "\\\\\\\\");
} else {
	//Unix line separator
	lineSeparator = "\\n";
}

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
    
	if(("Windows").equals(execution)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_72);
    
	}else{

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_76);
    
	}

    stringBuffer.append(TEXT_77);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(logDB);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_85);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_86);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_89);
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    if(needHost) {
    stringBuffer.append(host);
    stringBuffer.append(TEXT_95);
    } else {
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_100);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_103);
    if(!useQuery) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    if(separator.length()>0 && !"\"\"".equals(separator)){
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_108);
    
		if(columnList!=null){
			int counter = 1;
			int columnsLength = 0;
			for(IMetadataColumn column:columnList){	
				if( columnList.size() != counter){	
					if(separator.length()>0 && !"\"\"".equals(separator)){
						columnsLength+=(column.getLength()==null?0:column.getLength())+separator.length();
				
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_114);
    }else{
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    
				} else {
					if(separator.length()>0 && !"\"\"".equals(separator)){
						columnsLength+=(column.getLength()==null?0:column.getLength())+1;
			
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(columnsLength);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_126);
    }else{
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
     } 
				counter++;
			}
		}
		
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_137);
    } else {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    //Export file----------------------------------------------------------
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(exportedFile);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_150);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    //run fexp command----------------------------------------------------
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
	if("Windows".equals(execution)){
	
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }else{
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    log4jCodeGenerateUtil.logError(node,"warn","e_"+cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(TEXT_194);
    return stringBuffer.toString();
  }
}
