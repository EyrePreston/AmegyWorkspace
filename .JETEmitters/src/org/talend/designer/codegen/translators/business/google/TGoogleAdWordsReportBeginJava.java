package org.talend.designer.codegen.translators.business.google;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TGoogleAdWordsReportBeginJava
{
  protected static String nl;
  public static synchronized TGoogleAdWordsReportBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAdWordsReportBeginJava result = new TGoogleAdWordsReportBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // start creating client";
  protected final String TEXT_2 = NL + "\tde.jlo.talendcomp.google.adwords.AdWordsReport ";
  protected final String TEXT_3 = " = de.jlo.talendcomp.google.adwords.AdWordsReport.getFromCache(";
  protected final String TEXT_4 = " + ";
  protected final String TEXT_5 = " + ";
  protected final String TEXT_6 = " + \"";
  protected final String TEXT_7 = "\" + jobName);" + NL + "\tif (";
  protected final String TEXT_8 = " == null) {" + NL + "\t\t";
  protected final String TEXT_9 = " = new de.jlo.talendcomp.google.adwords.AdWordsReport();";
  protected final String TEXT_10 = NL + "\tde.jlo.talendcomp.google.adwords.AdWordsReport ";
  protected final String TEXT_11 = " = new de.jlo.talendcomp.google.adwords.AdWordsReport;";
  protected final String TEXT_12 = NL + "        // setup credentials with service account";
  protected final String TEXT_13 = NL + "        ";
  protected final String TEXT_14 = ".setUseServiceAccount(true);" + NL + "\t\t";
  protected final String TEXT_15 = ".setServiceAccountIdEmail(";
  protected final String TEXT_16 = ");" + NL + "\t\t";
  protected final String TEXT_17 = ".setKeyFile(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "        // setup with Client ID for native application";
  protected final String TEXT_20 = NL + "        ";
  protected final String TEXT_21 = ".setUseClientId(true);" + NL + "\t\t";
  protected final String TEXT_22 = ".setClientSecretFile(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = " ";
  protected final String TEXT_25 = NL + "    \t";
  protected final String TEXT_26 = ".setTimeMillisOffsetToPast(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "        ";
  protected final String TEXT_29 = ".setDeveloperToken(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "        ";
  protected final String TEXT_32 = ".setUserEmail(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "        ";
  protected final String TEXT_35 = ".setClientCustomerId(";
  protected final String TEXT_36 = ");" + NL + "\t\ttry {" + NL + "\t\t    // initialize session" + NL + "\t\t\t";
  protected final String TEXT_37 = ".initializeAdWordsSession();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_ERROR_MESSAGE\", e.getMessage());";
  protected final String TEXT_39 = NL + "\t\t\tthrow e;";
  protected final String TEXT_40 = NL + "\t\t\te.printStackTrace();";
  protected final String TEXT_41 = "\t" + NL + "\t\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_42 = "\", ";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t\tde.jlo.talendcomp.google.adwords.AdWordsReport.putIntoCache(";
  protected final String TEXT_45 = " + ";
  protected final String TEXT_46 = " + ";
  protected final String TEXT_47 = " + \"";
  protected final String TEXT_48 = "\" + jobName, ";
  protected final String TEXT_49 = ");" + NL + "\t}";
  protected final String TEXT_50 = NL + "    globalMap.put(\"";
  protected final String TEXT_51 = "_ERROR_CODE\", 0);" + NL + "    // build the report";
  protected final String TEXT_52 = NL + "    ";
  protected final String TEXT_53 = ".deliverTotalsDataset(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "    ";
  protected final String TEXT_56 = ".setDownloadDir(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "    ";
  protected final String TEXT_59 = ".setDownloadFormat(\"";
  protected final String TEXT_60 = "\");";
  protected final String TEXT_61 = NL + "    ";
  protected final String TEXT_62 = ".setDownloadFormat(\"CSV\");";
  protected final String TEXT_63 = NL + "\t";
  protected final String TEXT_64 = ".setReportName(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "    ";
  protected final String TEXT_67 = ".setUseAWQL(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t";
  protected final String TEXT_70 = ".setAwql(";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t";
  protected final String TEXT_73 = ".setReportType(";
  protected final String TEXT_74 = ");" + NL + "\t";
  protected final String TEXT_75 = ".setFields(";
  protected final String TEXT_76 = ");" + NL + "\t";
  protected final String TEXT_77 = ".setStartDate(";
  protected final String TEXT_78 = ");" + NL + "\t";
  protected final String TEXT_79 = ".setEndDate(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "    ";
  protected final String TEXT_82 = ".sendReportAsAWQL(";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "    ";
  protected final String TEXT_85 = ".setAWQLWhereClause(";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\tde.jlo.talendcomp.google.adwords.ReportResultParser parser_";
  protected final String TEXT_88 = " = new de.jlo.talendcomp.google.adwords.ReportResultParser();";
  protected final String TEXT_89 = NL + "    try {" + NL + "    \t";
  protected final String TEXT_90 = ".executeQuery();" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_91 = "_REPORT_TYPE\", ";
  protected final String TEXT_92 = ".getReportType());";
  protected final String TEXT_93 = NL + "    \t";
  protected final String TEXT_94 = ".downloadAsFile();" + NL + "    \tif (";
  protected final String TEXT_95 = " && ";
  protected final String TEXT_96 = ".downloadIsAnArchive()) {" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_97 = "_DOWNLOAD_FILEPATH\", de.jlo.talendcomp.google.adwords.AdWordsReport.unzip(";
  protected final String TEXT_98 = ".getReportDownloadFilePath(), ";
  protected final String TEXT_99 = "));" + NL + "    \t} else {" + NL + "\t    \tglobalMap.put(\"";
  protected final String TEXT_100 = "_DOWNLOAD_FILEPATH\", ";
  protected final String TEXT_101 = ".getReportDownloadFilePath());" + NL + "    \t}";
  protected final String TEXT_102 = NL + "        parser_";
  protected final String TEXT_103 = ".setFields(";
  protected final String TEXT_104 = ".getFields());" + NL + "\t\tparser_";
  protected final String TEXT_105 = ".initialize(";
  protected final String TEXT_106 = ".getResponseInputStream());";
  protected final String TEXT_107 = NL + "    } catch (Exception e) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_108 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "    \tthrow e;" + NL + "    }";
  protected final String TEXT_109 = NL + "    // iterate through the data..." + NL + "\tint countLines_";
  protected final String TEXT_110 = " = 0;" + NL + "\tboolean warningAboutSchemaDone = false;" + NL + "\twhile (true) {" + NL + "\t    try {" + NL + "\t\t    // hasNextDataset() executes a new query if needed" + NL + "\t\t    if (parser_";
  protected final String TEXT_111 = ".hasNextPlainRecord() == false) {" + NL + "\t\t        parser_";
  protected final String TEXT_112 = ".close();" + NL + "\t\t    \tbreak;" + NL + "\t\t    }" + NL + "\t    } catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_113 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\tthrow e;" + NL + "\t    }" + NL + "\t    // next row" + NL + "\t\tjava.util.List<String> dataset_";
  protected final String TEXT_114 = " = parser_";
  protected final String TEXT_115 = ".getNextPlainRecord();" + NL + "\t\t// create new row to avoid setting null values explicitly" + NL + "\t\t";
  protected final String TEXT_116 = " = new ";
  protected final String TEXT_117 = "Struct();";
  protected final String TEXT_118 = NL + "\t\t// fill schema field ";
  protected final String TEXT_119 = NL + "\t\tif (dataset_";
  protected final String TEXT_120 = ".size() > ";
  protected final String TEXT_121 = ") {" + NL + "\t\t\t// size check to avoid crashes if the schema does not fit absolutely to the returned dimensions and metrics" + NL + "\t\t\tString ";
  protected final String TEXT_122 = "_value_";
  protected final String TEXT_123 = " = dataset_";
  protected final String TEXT_124 = ".get(";
  protected final String TEXT_125 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_126 = "_value_";
  protected final String TEXT_127 = " != null) {";
  protected final String TEXT_128 = NL + "\t\t\t\tif (countLines_";
  protected final String TEXT_129 = " == 0) {" + NL + "\t\t\t\t    // we cannot set a date value for the totals row" + NL + "\t\t\t\t\t";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = null;" + NL + "\t\t\t\t} else {";
  protected final String TEXT_132 = NL + "\t\t\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = "_value_";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL + "\t    \t        try {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = (";
  protected final String TEXT_140 = ") de.jlo.talendcomp.google.adwords.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = "_value_";
  protected final String TEXT_142 = ", " + NL + "\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_143 = "\", " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " value=[\" + ";
  protected final String TEXT_147 = "_value_";
  protected final String TEXT_148 = " + \"] line=\" + countLines_";
  protected final String TEXT_149 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_150 = "                " + NL + "\t\t\t\t}";
  protected final String TEXT_151 = NL + "\t\t\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = "_value_";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "\t    \t        try {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = (";
  protected final String TEXT_159 = ") de.jlo.talendcomp.google.adwords.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = "_value_";
  protected final String TEXT_161 = ", " + NL + "\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_162 = "\", " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " value=[\" + ";
  protected final String TEXT_166 = "_value_";
  protected final String TEXT_167 = " + \"] line=\" + countLines_";
  protected final String TEXT_168 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_169 = "                ";
  protected final String TEXT_170 = NL + "\t\t\t\t\t";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = "_value_";
  protected final String TEXT_174 = ";";
  protected final String TEXT_175 = NL + "\t    \t        try {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = (";
  protected final String TEXT_178 = ") de.jlo.talendcomp.google.adwords.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = "_value_";
  protected final String TEXT_180 = ", " + NL + "\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_181 = "\", " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = " value=[\" + ";
  protected final String TEXT_185 = "_value_";
  protected final String TEXT_186 = " + \"] line=\" + countLines_";
  protected final String TEXT_187 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_188 = "                ";
  protected final String TEXT_189 = NL + "\t\t\t} // if (";
  protected final String TEXT_190 = "_value_";
  protected final String TEXT_191 = " != null)" + NL + "\t\t} else if (warningAboutSchemaDone == false) {" + NL + "\t\t\twarningAboutSchemaDone = true;" + NL + "\t\t\tSystem.err.println(\"Warning, the schema contains more columns as the mfc result provides (current index=";
  protected final String TEXT_192 = "). Please check this!\");" + NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useServiceAccount = "SERVICE_ACCOUNT".equals(ElementParameterParser.getValue(node, "__AUTHENTICATION_METHOD__"));
	String serviceAccountEmail = ElementParameterParser.getValue(node, "__SERVICE_ACCOUNT_EMAIL__");
	String keyFile = ElementParameterParser.getValue(node, "__KEY_FILE__");
    String clientSecretFile = ElementParameterParser.getValue(node, "__CLIENT_SECRET_FILE__");
    String adWordsAccountEmail = ElementParameterParser.getValue(node, "__ADWORDS_ACCOUNT_EMAIL__");
    String developerToken = ElementParameterParser.getValue(node, "__DEVELOPER_TOKEN__");
    String clientCustomerId = ElementParameterParser.getValue(node, "__ADWORDS_CUSTOMER_ID__");
	String timeOffset = ElementParameterParser.getValue(node, "__TIME_OFFSET__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	String keepClient = ElementParameterParser.getValue(node, "__KEEP_CLIENT__");
	String keepClientName = ElementParameterParser.getValue(node, "__KEEP_CLIENT_KEY__");
	keepClientName = keepClientName != null && keepClientName.isEmpty() == false ? keepClientName : "\"\"";
	boolean useAWQL = "true".equals(ElementParameterParser.getValue(node, "__USE_AWQL__"));
	String awql = ElementParameterParser.getValue(node, "__AWQL__");
	if (awql == null || awql.trim().isEmpty()) {
		awql = "null";
	} else {
    	awql = awql.trim().replace('\r', ' ').replace("\n", "\\n\" +\n\"");
	}
	boolean sendReportAsAWQL = "true".equals(ElementParameterParser.getValue(node, "__SEND_REPORT_AS_AWQL__"));
	String awqlWhereClause = ElementParameterParser.getValue(node, "__AWQL_WHERE_CLAUSE__");
	if (awqlWhereClause == null || awqlWhereClause.trim().isEmpty()) {
		awqlWhereClause = "null";
	} else {
    	awqlWhereClause = awqlWhereClause.trim().replace('\r', ' ').replace("\n", "\\n\" +\n\"");
	}
	String startDate = ElementParameterParser.getValue(node, "__START_DATE__");
	String endDate = ElementParameterParser.getValue(node, "__END_DATE__");
	String reportName = ElementParameterParser.getValue(node, "__REPORT_NAME__");
	String reportType = ElementParameterParser.getValue(node, "__REPORT_TYPE__");
	String fields = ElementParameterParser.getValue(node, "__FIELDS__");
	boolean downloadAsFile = "true".equals(ElementParameterParser.getValue(node, "__DOWNLOAD_AS_FILE__"));
	String downloadDir = ElementParameterParser.getValue(node, "__DOWNLOAD_DIR__");
	boolean deliverTotalsDataset = "true".equals(ElementParameterParser.getValue(node, "__DELIVER_TOTALS_DATASET__"));
	String downloadFormat = ElementParameterParser.getValue(node, "__DOWNLOAD_FORMAT__");
	boolean unarchiveFile = "true".equals(ElementParameterParser.getValue(node, "__UNARCHIVE__"));
	String removeArchiveFile = ElementParameterParser.getValue(node, "__REMOVE_SOURCE__");
    String connName = null;
    List<IMetadataColumn> listColumns = null;
    if (node.getOutgoingConnections().size() > 0) {
        IConnection conn = node.getOutgoingConnections().get(0);
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		    IMetadataTable metadata = conn.getMetadataTable();
		    listColumns = metadata.getListColumns();
		    connName = conn.getName();
        }
    }
	String numberFormatLocale = ElementParameterParser.getValue(node, "__NUMBERFORMAT_LOCALE__");
	if (numberFormatLocale != null && numberFormatLocale.isEmpty() == false) {
		numberFormatLocale = "\"" + numberFormatLocale + "\"";
	} else {
		numberFormatLocale = "null";
	}

    stringBuffer.append(TEXT_1);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(adWordsAccountEmail);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(clientCustomerId);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
     } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
     }
     if (useServiceAccount) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(serviceAccountEmail);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyFile);
    stringBuffer.append(TEXT_18);
     } else { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(clientSecretFile);
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(TEXT_24);
     if (timeOffset != null && timeOffset.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(timeOffset);
    stringBuffer.append(TEXT_27);
     }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(developerToken);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(adWordsAccountEmail);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(clientCustomerId);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
     if (dieOnError) { 
    stringBuffer.append(TEXT_39);
     } else { 
    stringBuffer.append(TEXT_40);
     } 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(adWordsAccountEmail);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(clientCustomerId);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
     } 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(deliverTotalsDataset);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(downloadDir);
    stringBuffer.append(TEXT_57);
      if (downloadAsFile) { 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(downloadFormat);
    stringBuffer.append(TEXT_60);
      } else { 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
      } 
      if (reportName != null && reportName.trim().isEmpty() == false) { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(reportName);
    stringBuffer.append(TEXT_65);
      } 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(useAWQL);
    stringBuffer.append(TEXT_68);
      if (useAWQL) { 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(awql);
    stringBuffer.append(TEXT_71);
      } else { 
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(reportType);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(fields);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(startDate);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(endDate);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(sendReportAsAWQL);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(awqlWhereClause);
    stringBuffer.append(TEXT_86);
      } 
      if (downloadAsFile == false) { 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
      } 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
      if (downloadAsFile) { 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(unarchiveFile);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(removeArchiveFile);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
      } else { 
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
      } 
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
      if (downloadAsFile == false && connName != null) { 
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
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_117);
    	int index = 0;
    if (listColumns != null) {
        for (IMetadataColumn col : listColumns) {
        	String javaClassName = JavaTypesManager.getJavaTypeFromId(col.getTalendType()).getNullableClass().getName(); 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_127);
              if (deliverTotalsDataset) {
		         if ("java.util.Date".equals(javaClassName)) { 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_131);
                  if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_136);
                  } else { 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
                  } 
    stringBuffer.append(TEXT_150);
                  } else {
                    if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_155);
                      } else { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
                      } 
    stringBuffer.append(TEXT_169);
                  } 
              } else {
                if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_174);
                  } else { 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
                  } 
    stringBuffer.append(TEXT_188);
              } 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_192);
          index++; 
    		} // for (IMetadataColumn col : listColumns) 
    	} // if (listColumns != null && conn != null) 
     } 
    return stringBuffer.toString();
  }
}
