package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class THiveRowBeginJava
{
  protected static String nl;
  public static synchronized THiveRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowBeginJava result = new THiveRowBeginJava();
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
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_68 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_69 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_70 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_71 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_72 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_73 = " = new StringBuilder();";
  protected final String TEXT_74 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_75 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = "; ";
  protected final String TEXT_80 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_81 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "; ";
  protected final String TEXT_86 = NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_87 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_88 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_91 = " = new org.talend.webhcat.launcher.common.impl.PigJob(azureFs_";
  protected final String TEXT_92 = ", org.talend.webhcat.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_93 = ".setAzureAccountName(";
  protected final String TEXT_94 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_95 = ".setAzureAccountPassword(wasbPassword_";
  protected final String TEXT_96 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_97 = ".setAzureStorageAddress(";
  protected final String TEXT_98 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_99 = ".setAzureContainer(";
  protected final String TEXT_100 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_101 = ".setHdInsightUsername(";
  protected final String TEXT_102 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_103 = ".setHdInsightPassword(hdInsightPassword_";
  protected final String TEXT_104 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_105 = ".setUsername(";
  protected final String TEXT_106 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_107 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_108 = " + \":\" + ";
  protected final String TEXT_109 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_110 = ".setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_111 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_112 = ".setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_115 = " = (org.talend.webhcat.launcher.common.Job)globalMap.get(\"conn_";
  protected final String TEXT_116 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_117 = " = instance_";
  protected final String TEXT_118 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_119 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_120 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_121 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_122 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_123 = NL + "\tinstance_";
  protected final String TEXT_124 = ".setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_125 = " = azureFs_";
  protected final String TEXT_126 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_127 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_128 = NL + "\t\t\t\tbw_";
  protected final String TEXT_129 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_130 = " + \";\");" + NL + "\t\t\t\tbw_";
  protected final String TEXT_131 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_132 = " + \";\");" + NL + "\t\t\t\tbw_";
  protected final String TEXT_133 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_134 = " + \";\");";
  protected final String TEXT_135 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_136 = ".write(\"SET \"+";
  protected final String TEXT_137 = "+\"=\"+";
  protected final String TEXT_138 = " + \";\");";
  protected final String TEXT_139 = NL + "\t\t\tString dbname_";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = ";" + NL + "\t\t\tif(dbname_";
  protected final String TEXT_142 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_143 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_144 = ".trim())) {" + NL + "\t\t\t\tbw_";
  protected final String TEXT_145 = ".write(\"use \" + dbname_";
  protected final String TEXT_146 = " + \";\");" + NL + "\t\t\t}";
  protected final String TEXT_147 = NL + "\t\t";
  protected final String TEXT_148 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_149 = " = null;";
  protected final String TEXT_150 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_151 = "); ";
  protected final String TEXT_152 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "\t\tconn_";
  protected final String TEXT_155 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_156 = "\");" + NL + "\t\t" + NL + "\t\tString dbname_";
  protected final String TEXT_157 = " = (String)globalMap.get(\"";
  protected final String TEXT_158 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_159 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_160 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_161 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_162 = " = conn_";
  protected final String TEXT_163 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_164 = ".execute(\"use \" + dbname_";
  protected final String TEXT_165 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_166 = ".close();" + NL + "    \t}" + NL + "    \t" + NL + "    \tString dbUser_";
  protected final String TEXT_167 = " = (String)globalMap.get(\"";
  protected final String TEXT_168 = "\");" + NL + "    \t" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_169 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_170 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_171 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_172 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_173 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_175 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_176 = " ,";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_179 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_180 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_181 = ");" + NL + "\t        " + NL + "    \t\t";
  protected final String TEXT_182 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_183 = " " + NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_184 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_185 = ");" + NL + "   \t\t \t";
  protected final String TEXT_186 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_187 = " = ";
  protected final String TEXT_188 = "; " + NL + "\t\t\t";
  protected final String TEXT_189 = NL + "\t\t   \t" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_190 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_191 = ");\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_193 = ", ";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_198 = "\", ";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\tString dbUser_";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_203 = NL + NL + "\t\t";
  protected final String TEXT_204 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_205 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_208 = " = ";
  protected final String TEXT_209 = "; ";
  protected final String TEXT_210 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_211 = " = decryptedPassword_";
  protected final String TEXT_212 = ";" + NL;
  protected final String TEXT_213 = NL + "            String username_";
  protected final String TEXT_214 = " = ";
  protected final String TEXT_215 = ";" + NL + "            if(username_";
  protected final String TEXT_216 = "!=null && !\"\".equals(username_";
  protected final String TEXT_217 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_218 = ");" + NL + "            }";
  protected final String TEXT_219 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_220 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_221 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_222 = " + \":\" + ";
  protected final String TEXT_223 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_224 = " = \"jdbc:";
  protected final String TEXT_225 = "://\";";
  protected final String TEXT_226 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_227 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_228 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_229 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_231 = NL + "\t\t\t\tString url_";
  protected final String TEXT_232 = " = \"jdbc:";
  protected final String TEXT_233 = "://\" + ";
  protected final String TEXT_234 = " + \":\" + ";
  protected final String TEXT_235 = " + \"/\" + ";
  protected final String TEXT_236 = " + \";principal=\" + ";
  protected final String TEXT_237 = ";";
  protected final String TEXT_238 = NL + "\t\t\t\tString url_";
  protected final String TEXT_239 = " = \"jdbc:";
  protected final String TEXT_240 = "://\" + ";
  protected final String TEXT_241 = " + \":\" + ";
  protected final String TEXT_242 = " + \"/\" + ";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = NL + "\t\tString driverClass_";
  protected final String TEXT_245 = " = \"";
  protected final String TEXT_246 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_247 = ");" + NL + "\t\t";
  protected final String TEXT_248 = "\t" + NL + "\t\t";
  protected final String TEXT_249 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_250 = " - Connection attempt to '\" + url_";
  protected final String TEXT_251 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_252 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_253 = NL + "\t\t\tconn_";
  protected final String TEXT_254 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\t\t\tconn_";
  protected final String TEXT_257 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_258 = ", dbUser_";
  protected final String TEXT_259 = ", dbPwd_";
  protected final String TEXT_260 = ");";
  protected final String TEXT_261 = NL + "\t\t";
  protected final String TEXT_262 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_263 = " - Connection to '\" + url_";
  protected final String TEXT_264 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_265 = NL + "\t\t" + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_266 = " = conn_";
  protected final String TEXT_267 = ".createStatement();";
  protected final String TEXT_268 = NL + "        \tinit_";
  protected final String TEXT_269 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_270 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_271 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = NL + "\t\tinit_";
  protected final String TEXT_274 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "\t\t\tinit_";
  protected final String TEXT_277 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "\t\t\tinit_";
  protected final String TEXT_280 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "        \t\tinit_";
  protected final String TEXT_283 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_284 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_285 = ");";
  protected final String TEXT_286 = NL + "\t\t\t\tinit_";
  protected final String TEXT_287 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_288 = ");" + NL + "    \t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\tinit_";
  protected final String TEXT_290 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL + "                init_";
  protected final String TEXT_293 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_294 = NL + "\t\t\t\tinit_";
  protected final String TEXT_295 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "\t\t\t\tinit_";
  protected final String TEXT_298 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_299 = NL + "\t\t\t\t" + NL + "\t\t\t\tinit_";
  protected final String TEXT_300 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_301 = NL + "        \t\t//set default yarn classpath with environment variable" + NL + "        \t\tinit_";
  protected final String TEXT_302 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_303 = NL + "    \t\t\tinit_";
  protected final String TEXT_304 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_305 = NL + "    \t\t\tinit_";
  protected final String TEXT_306 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_307 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_308 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_309 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_310 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_311 = ");";
  protected final String TEXT_312 = NL + "\t\t\t\tinit_";
  protected final String TEXT_313 = ".execute(\"SET \"+";
  protected final String TEXT_314 = "+\"=\"+";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "\t\tinit_";
  protected final String TEXT_317 = ".close();" + NL + "\t\t" + NL + "    \tString dbname_";
  protected final String TEXT_318 = " = ";
  protected final String TEXT_319 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_320 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_321 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_322 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_323 = " = conn_";
  protected final String TEXT_324 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_325 = ".execute(\"use \" + dbname_";
  protected final String TEXT_326 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_327 = ".close();" + NL + "    \t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_328 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_329 = " = conn_";
  protected final String TEXT_330 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_331 = NL + "    \t\t\tstatement_";
  protected final String TEXT_332 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_333 = ");" + NL + "    \t\t";
  protected final String TEXT_334 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_335 = NL + "        \t\tstatement_";
  protected final String TEXT_336 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_337 = ");" + NL + "        \t";
  protected final String TEXT_338 = NL + "        \t" + NL + "\t\t\t";
  protected final String TEXT_339 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_340 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_341 = ");" + NL + "\t\t\t";
  protected final String TEXT_342 = "        \t" + NL + "    \t" + NL + "        \t";
  protected final String TEXT_343 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_344 = ".execute(\"add jar \"+";
  protected final String TEXT_345 = ");" + NL + "    \t\t";
  protected final String TEXT_346 = NL + "    \t\tstatement_";
  protected final String TEXT_347 = ".close();";
  protected final String TEXT_348 = NL + "\t\tif(true) {" + NL + "\t\t\tthrow new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "\t\t}";
  protected final String TEXT_349 = NL + "\t\t\t";
  protected final String TEXT_350 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_351 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_352 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister(\"../../job.xml\");" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_353 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_354 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tpublic boolean setJarsToRegister(String filename) throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(filename).getCanonicalPath();" + NL + "\t\t\t\tif(isNeedAddLibsPath(jobXmlPath)) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\tGetJarsToRegister_";
  protected final String TEXT_356 = " getJarsToRegister_";
  protected final String TEXT_357 = " = new GetJarsToRegister_";
  protected final String TEXT_358 = "();";
  protected final String TEXT_359 = NL + "\t\t\t\t";
  protected final String TEXT_360 = NL + "\t";
  protected final String TEXT_361 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_362 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_363 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister(\"../../job.xml\");" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_364 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_365 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tpublic boolean setJarsToRegister(String filename) throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(filename).getCanonicalPath();" + NL + "\t\t\t\tif(isNeedAddLibsPath(jobXmlPath)) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_367 = " extends GetJarsToRegister_";
  protected final String TEXT_368 = " {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\torg.apache.hadoop.fs.FileSystem fs = null;" + NL + "\t\t\torg.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();" + NL + "\t\t\tconf.set(\"fs.default.name\", ";
  protected final String TEXT_369 = ");" + NL + "\t\t\tString username = ";
  protected final String TEXT_370 = ";" + NL + "\t\t\tif (username == null\t|| \"\".equals(username)) {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(conf);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf.get(\"fs.default.name\")), conf, username);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfs.mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs.copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"));" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_371 = " + \"/user/\" + username + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t\t\tGetHiveJarsToRegister_";
  protected final String TEXT_372 = " getJarsToRegister_";
  protected final String TEXT_373 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_374 = "();";
  protected final String TEXT_375 = NL + "\t\t\tjava.sql.Statement addJar_";
  protected final String TEXT_376 = " = null;";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_378 = " = conn_";
  protected final String TEXT_379 = ".createStatement();" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_380 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_381 = ".replaceJarPaths(\"";
  protected final String TEXT_382 = "\"));" + NL + "\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_383 = ".close();" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_384 = NL + "\t\t\t\t\t\t\tbw_";
  protected final String TEXT_385 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_386 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_387 = ".replaceJarPaths(\"";
  protected final String TEXT_388 = "\")).getName() + \";\");" + NL + "\t\t\t\t\t\t\tlibjars_";
  protected final String TEXT_389 = ".append(getJarsToRegister_";
  protected final String TEXT_390 = ".replaceJarPaths(\"";
  protected final String TEXT_391 = "\") + \",\");";
  protected final String TEXT_392 = NL + "\t        if(conn_";
  protected final String TEXT_393 = ".getAutoCommit()) {" + NL + "\t            conn_";
  protected final String TEXT_394 = ".setAutoCommit(false);" + NL + "\t        }" + NL + "\t        int commitEvery_";
  protected final String TEXT_395 = " = ";
  protected final String TEXT_396 = ";" + NL + "\t        int commitCounter_";
  protected final String TEXT_397 = " = 0;" + NL + "\t        ";
  protected final String TEXT_398 = NL + "\t\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_399 = " = conn_";
  protected final String TEXT_400 = ".prepareStatement(";
  protected final String TEXT_401 = ");";
  protected final String TEXT_402 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_403 = " = conn_";
  protected final String TEXT_404 = ".createStatement();";
  protected final String TEXT_405 = NL + NL + "\tString query_";
  protected final String TEXT_406 = " = \"\";" + NL + "\tboolean whetherReject_";
  protected final String TEXT_407 = " = false;";
  protected final String TEXT_408 = NL;

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

    stringBuffer.append(TEXT_65);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");

	String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");//hive jdbc not support setAutoCommit
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

	boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));

	boolean isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
		isExecutedThroughWebHCat = false;
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
			if(connection!=null && connection.equals(pNode.getUniqueName())) {
				isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(pNode, "__DISTRIBUTION__"));
			}
		}
	}

	if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_66);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
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
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_82);
    
		} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_85);
    
		}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_HOST__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_113);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
		if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
			boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
			if(setMemory) {
				String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
				String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
				String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_134);
    
			}

			List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
			if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_138);
    
				}
			}

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		}
	} else {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_150);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_151);
     
	}
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_152);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_153);
    
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
		
		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
    	
    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
    	
    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
		
		boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
		
		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "MAPR310".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion)))) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}
		
		if(!isCustom && (("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
		 || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
		  || ("HDP_2_1".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode))
		   || ("MapR_EMR".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_174);
    
		}
		
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_175);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_177);
    
			} 
		}
		
		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_178);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_181);
    
    		String passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_182);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_185);
    } else {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_191);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_194);
    
			}
		}
		
		if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"PIVOTAL_HD_2_0".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"HDP_2_1".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion) && !"Cloudera_CDH5".equals(hiveVersion) && !"Cloudera_CDH5_1".equals(hiveVersion) && !"MAPR401".equals(hiveVersion) && !"APACHE_2_4_0_EMR".equals(hiveVersion))) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_195);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_196);
    
		}
		
		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_197);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_199);
    
		}		

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_202);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_203);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_206);
    } else {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    
        }
        
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_221);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_225);
    
			if(isCustom || (!isCustom && (("HDP_1_0,HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0".contains(hiveVersion)) || ("APACHE_2_4_0_EMR".equals(hiveVersion))))) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    
			}
		} else {
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_237);
    
			} else {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_243);
    
			}
		}

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);	
		
    stringBuffer.append(TEXT_248);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    
		} else {

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
		}

    stringBuffer.append(TEXT_261);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_272);
    
	}
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) ||  "APACHE_2_4_0_EMR".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion));
		
	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_275);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_278);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_281);
    
		}

	}
		
    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
		
    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_285);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_288);
    
			}
			
    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_291);
    
			}
    		
            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
            }
			
    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_296);
    
			}
		
			if("EMBEDDED".equals(connectionMode)) {
				if(!isCustom && ("HDP_2_1".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "MAPR401".equals(hiveVersion))) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
				}
				if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
				/**/
				} else {

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
				/**/
				}
				
    			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
    			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
				}
			}
		
    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_311);
    
			}
		}
		
		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_315);
    
			}
		}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_333);
    }
    stringBuffer.append(TEXT_334);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_337);
    }
    stringBuffer.append(TEXT_338);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_341);
    }
    stringBuffer.append(TEXT_342);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_345);
    
    			}
    		}

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
	  	}
	}

    
	}

	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String distribution = ElementParameterParser.getValue(node,"__DISTRIBUTION__");
	String hiveVersion = ElementParameterParser.getValue(node,"__HIVE_VERSION__");

	if("true".equals(useExistingConn) && !isExecutedThroughWebHCat) {
		connectionMode = "";
		setFsDefaultName = false;
		fsDefaultName = "";
		dbuser = "";
		distribution = "";
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
			if(connection!=null && connection.equals(pNode.getUniqueName())) {
				connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
				setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
				fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
				dbuser = ElementParameterParser.getValue(pNode, "__USER__");
				distribution = ElementParameterParser.getValue(pNode,"__DISTRIBUTION__");
				hiveVersion = ElementParameterParser.getValue(pNode,"__HIVE_VERSION__");
				break;
			}
		}
	}

	java.util.List<String> hiveVersionList = new java.util.ArrayList<String>();
	hiveVersionList.add("APACHE_0_20_203");
	hiveVersionList.add("Cloudera_CDH3");
	hiveVersionList.add("Cloudera_CDH4");
	hiveVersionList.add("APACHE_1_0_0");
	hiveVersionList.add("MAPR2");
	hiveVersionList.add("HDP_1_0");
	hiveVersionList.add("PIVOTAL_HD_1_0_1");

	boolean isParquetSupported = "CUSTOM".equals(distribution) || !hiveVersionList.contains(hiveVersion);
	if(useParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_348);
    
	}

	// Register jars to handle the parquet format.

	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	boolean generateAddJarCodeForAll = useParquet;
	if(generateAddJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();

		jarsToRegister.add("snappy-java");
		jarsToRegister.add("parquet-hive-bundle");

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

	if(jarsToRegister!=null && jars!=null) {
		if("EMBEDDED".equalsIgnoreCase(connectionMode) || isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    }
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    
		} else {
			generateAddJarCodeForAll = false;
			if(setFsDefaultName) {
				generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_359);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    }
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    
			}
		}

		if(generateAddJarCodeForAll) {

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {
						if(!isExecutedThroughWebHCat) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    
						} else {

    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_391);
    
						}
					}
				}
			}
		}
	}

	// End of parquet format handling.

	if(!("true").equals(useExistingConn) && !isExecutedThroughWebHCat) {
	    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
	    }
	}

	if(!isExecutedThroughWebHCat) {
		if (usePrepareStatement) {

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_401);
    
		} else {

    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    
		}
	}

    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(TEXT_408);
    return stringBuffer.toString();
  }
}
