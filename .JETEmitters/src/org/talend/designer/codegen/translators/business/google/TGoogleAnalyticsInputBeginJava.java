package org.talend.designer.codegen.translators.business.google;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TGoogleAnalyticsInputBeginJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsInputBeginJava result = new TGoogleAnalyticsInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // start creating client";
  protected final String TEXT_2 = NL + "\tde.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput ";
  protected final String TEXT_3 = " = de.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput.getFromCache(";
  protected final String TEXT_4 = " + ";
  protected final String TEXT_5 = " + \"";
  protected final String TEXT_6 = "\" + jobName);" + NL + "\tif (";
  protected final String TEXT_7 = " == null) {" + NL + "\t\t";
  protected final String TEXT_8 = " = new de.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput();";
  protected final String TEXT_9 = NL + "\tde.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput ";
  protected final String TEXT_10 = " = new de.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput();";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setApplicationName(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = ".setUseServiceAccount(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "        // setup credentials with service account" + NL + "\t\t";
  protected final String TEXT_18 = ".setAccountEmail(";
  protected final String TEXT_19 = ");" + NL + "\t\t";
  protected final String TEXT_20 = ".setKeyFile(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "      // setup with Client ID for native application" + NL + "\t\t";
  protected final String TEXT_23 = ".setAccountEmail(";
  protected final String TEXT_24 = ");" + NL + "\t\t";
  protected final String TEXT_25 = ".setClientSecretFile(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setTimeoutInSeconds(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = ".setTimeOffsetMillisToPast(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t";
  protected final String TEXT_35 = ".setFetchSize(";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "        ";
  protected final String TEXT_38 = ".deliverTotalsDataset(";
  protected final String TEXT_39 = ");" + NL + "\t\ttry {" + NL + "\t\t    // initialize client with private key" + NL + "\t\t\t";
  protected final String TEXT_40 = ".initializeAnalyticsClient();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_41 = "_ERROR_MESSAGE\", e.getMessage());";
  protected final String TEXT_42 = NL + "\t\t\tthrow e;";
  protected final String TEXT_43 = NL + "\t\t\te.printStackTrace();";
  protected final String TEXT_44 = "\t" + NL + "\t\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_45 = "\", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\tde.jlo.talendcomp.googleanalytics.GoogleAnalyticsInput.putIntoCache(";
  protected final String TEXT_48 = " + ";
  protected final String TEXT_49 = " + \"";
  protected final String TEXT_50 = "\" + jobName, ";
  protected final String TEXT_51 = ");" + NL + "\t}";
  protected final String TEXT_52 = NL + "\t// setup query" + NL + "\t";
  protected final String TEXT_53 = ".setProfileId(";
  protected final String TEXT_54 = ");" + NL + "\t";
  protected final String TEXT_55 = ".setStartDate(";
  protected final String TEXT_56 = ");" + NL + "\t// for selecting data for one day, set end date == start date" + NL + "\t";
  protected final String TEXT_57 = ".setEndDate(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t";
  protected final String TEXT_60 = ".setDimensions(";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t";
  protected final String TEXT_63 = ".setMetrics(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t";
  protected final String TEXT_66 = ".setFilters(";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t";
  protected final String TEXT_69 = ".setSegment(";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\t";
  protected final String TEXT_72 = ".setSorts(";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t";
  protected final String TEXT_75 = ".setSamplingLevel(\"";
  protected final String TEXT_76 = "\");";
  protected final String TEXT_77 = NL + "\t// fire query and fetch first chunk of data" + NL + "\ttry {" + NL + "\t    // checks also the correctness of result columns" + NL + "\t\t";
  protected final String TEXT_78 = ".executeQuery();" + NL + "\t} catch (Exception e) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_79 = "_ERROR_MESSAGE\", e.getMessage());";
  protected final String TEXT_80 = NL + "\t\tthrow e;";
  protected final String TEXT_81 = NL + "\t\te.printStackTrace();";
  protected final String TEXT_82 = "\t" + NL + "\t}" + NL + "\t// iterate through the data...";
  protected final String TEXT_83 = NL + "\t// deliver the output in 2 normalized flows for dimensions and metrics" + NL + "\tint countDimensionValues_";
  protected final String TEXT_84 = " = 0;" + NL + "\tint countMetricValues_";
  protected final String TEXT_85 = " = 0;" + NL + "\twhile (true) {" + NL + "\t\ttry {" + NL + "\t\t\t// next calls the necessary calls to hasNextPlainRecord()" + NL + "\t\t\tif (";
  protected final String TEXT_86 = ".nextNormalizedRecord() == false) {" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_87 = "_ERROR_MESSAGE\", e.getMessage());";
  protected final String TEXT_88 = NL + "\t\t\tthrow e;";
  protected final String TEXT_89 = NL + "\t\t\tbreak;";
  protected final String TEXT_90 = "\t" + NL + "\t    }";
  protected final String TEXT_91 = " " + NL + "\t\tde.jlo.talendcomp.googleanalytics.DimensionValue dv = ";
  protected final String TEXT_92 = ".getCurrentDimensionValue();" + NL + "\t\tif (dv != null) {" + NL + "\t\t\t";
  protected final String TEXT_93 = " = new ";
  protected final String TEXT_94 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_95 = ".ROW_NUM = dv.rowNum;" + NL + "\t\t\t";
  protected final String TEXT_96 = ".DIMENSION_NAME = dv.name;" + NL + "\t\t\t";
  protected final String TEXT_97 = ".DIMENSION_VALUE = dv.value;" + NL + "\t\t\tcountDimensionValues_";
  protected final String TEXT_98 = "++;" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_99 = " = null;" + NL + "\t\t}";
  protected final String TEXT_100 = NL + "\t\tde.jlo.talendcomp.googleanalytics.MetricValue mv = ";
  protected final String TEXT_101 = ".getCurrentMetricValue();" + NL + "\t\tif (mv != null) {" + NL + "\t\t    ";
  protected final String TEXT_102 = " = new ";
  protected final String TEXT_103 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_104 = ".ROW_NUM = mv.rowNum;" + NL + "\t\t\t";
  protected final String TEXT_105 = ".METRIC_NAME = mv.name;" + NL + "\t\t\t";
  protected final String TEXT_106 = ".METRIC_VALUE = mv.value;" + NL + "\t\t\tcountMetricValues_";
  protected final String TEXT_107 = "++;" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_108 = " = null;" + NL + "\t\t}";
  protected final String TEXT_109 = "\t" + NL + "\tint countLines_";
  protected final String TEXT_110 = " = 0;" + NL + "\t// deliver the output as plain flow" + NL + "\t// with dimension and metrics as columns" + NL + "\tboolean warningAboutSchemaMismatchDone_";
  protected final String TEXT_111 = " = false;" + NL + "\twhile (true) {" + NL + "\t    try {" + NL + "\t\t    // hasNextPlainRecord() executes a new query if needed" + NL + "\t\t    if (";
  protected final String TEXT_112 = ".hasNextPlainRecord() == false) {" + NL + "\t\t    \tbreak;" + NL + "\t\t    }" + NL + "\t    } catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_113 = "_ERROR_MESSAGE\", e.getMessage());";
  protected final String TEXT_114 = NL + "\t\t\tthrow e;";
  protected final String TEXT_115 = NL + "\t\t\tbreak;";
  protected final String TEXT_116 = "\t" + NL + "\t    }" + NL + "\t    // next row from results" + NL + "\t\tjava.util.List<String> dataset_";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ".getNextPlainRecord();" + NL + "\t   countLines_";
  protected final String TEXT_119 = "++;";
  protected final String TEXT_120 = NL + "\t\t// create a new row, thats avoid the need of setting attributes to null" + NL + "\t\t";
  protected final String TEXT_121 = " = new ";
  protected final String TEXT_122 = "Struct();";
  protected final String TEXT_123 = NL + "\t\t// fill schema field ";
  protected final String TEXT_124 = NL + "\t\tif (dataset_";
  protected final String TEXT_125 = ".size() > ";
  protected final String TEXT_126 = ") {" + NL + "\t\t\tString ";
  protected final String TEXT_127 = "_value_";
  protected final String TEXT_128 = " = dataset_";
  protected final String TEXT_129 = ".get(";
  protected final String TEXT_130 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_131 = "_value_";
  protected final String TEXT_132 = " != null) {";
  protected final String TEXT_133 = NL + "\t\t\t\tif (countLines_";
  protected final String TEXT_134 = " == 0) {" + NL + "\t\t\t\t    // we cannot set a date value for the totals row" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = null;" + NL + "\t\t\t\t} else {";
  protected final String TEXT_137 = NL + "\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = "_value_";
  protected final String TEXT_141 = ";";
  protected final String TEXT_142 = NL + "\t    \t        try {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = (";
  protected final String TEXT_145 = ") de.jlo.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = "_value_";
  protected final String TEXT_147 = ", " + NL + "\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_148 = "\", " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_149 = ");" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = " value=[\" + ";
  protected final String TEXT_152 = "_value_";
  protected final String TEXT_153 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_154 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_155 = "                " + NL + "\t\t\t\t}";
  protected final String TEXT_156 = NL + "\t\t\t\t";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = ";
  protected final String TEXT_159 = "_value_";
  protected final String TEXT_160 = ";";
  protected final String TEXT_161 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = (";
  protected final String TEXT_164 = ") de.jlo.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_165 = "_value_";
  protected final String TEXT_166 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_167 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " value=[\" + ";
  protected final String TEXT_171 = "_value_";
  protected final String TEXT_172 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_173 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_174 = "                ";
  protected final String TEXT_175 = NL + "\t\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = "_value_";
  protected final String TEXT_179 = ";";
  protected final String TEXT_180 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " = (";
  protected final String TEXT_183 = ") de.jlo.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_184 = "_value_";
  protected final String TEXT_185 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_186 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " value=[\" + ";
  protected final String TEXT_190 = "_value_";
  protected final String TEXT_191 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_192 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_193 = "                ";
  protected final String TEXT_194 = NL + "\t\t\t}" + NL + "\t\t} else if (warningAboutSchemaMismatchDone_";
  protected final String TEXT_195 = " == false) {" + NL + "\t\t\twarningAboutSchemaMismatchDone_";
  protected final String TEXT_196 = " = true;" + NL + "\t\t\tSystem.err.println(\"Warning, the schema contains more columns than the ga result provides (current index=";
  protected final String TEXT_197 = "). Please check this!\");" + NL + "\t\t}";
  protected final String TEXT_198 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String applicationName = ElementParameterParser.getValue(node, "__APPLICATION_NAME__");
    boolean useServiceAccount = "SERVICE_ACCOUNT".equals(ElementParameterParser.getValue(node, "__AUTHENTICATION_METHOD__"));
	String accountEmail = ElementParameterParser.getValue(node, "__SERVICE_ACCOUNT_EMAIL__");
	String keyFile = ElementParameterParser.getValue(node, "__KEY_FILE__");
    String clientSecretFile = ElementParameterParser.getValue(node, "__CLIENT_SECRET_FILE__");
    String userEmail = ElementParameterParser.getValue(node, "__USER_ACCOUNT_EMAIL__");
    String profileId = ElementParameterParser.getValue(node, "__PROFILE_ID__");
	String startDate = ElementParameterParser.getValue(node, "__START_DATE__");
	String endDate = ElementParameterParser.getValue(node, "__END_DATE__");
	String dimensions = ElementParameterParser.getValue(node, "__DIMENSIONS__");
	String metrics = ElementParameterParser.getValue(node, "__METRICS__");
	String filters = ElementParameterParser.getValue(node, "__FILTERS__");
	String segment = ElementParameterParser.getValue(node, "__SEGMENT__");
	String sorts = ElementParameterParser.getValue(node, "__SORTS__");
	String samplingLevel = ElementParameterParser.getValue(node, "__SAMPLING_LEVEL__");
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT_IN_SEC__");
	String timeOffset = ElementParameterParser.getValue(node, "__TIME_OFFSET__");
	String fetchSize = ElementParameterParser.getValue(node, "__FETCH_SIZE__");
	String numberFormatLocale = ElementParameterParser.getValue(node, "__NUMBERFORMAT_LOCALE__");
	if (numberFormatLocale != null && numberFormatLocale.isEmpty() == false) {
		numberFormatLocale = "\"" + numberFormatLocale + "\"";
	} else {
		numberFormatLocale = "null";
	}
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean deliverTotalsDataset = "true".equals(ElementParameterParser.getValue(node, "__DELIVER_TOTALS_DATASET__"));
	String keepClient = ElementParameterParser.getValue(node, "__KEEP_CLIENT__");
	String keepClientName = ElementParameterParser.getValue(node, "__KEEP_CLIENT_KEY__");
	keepClientName = keepClientName != null && keepClientName.isEmpty() == false ? keepClientName : "\"\"";
    List<IMetadataColumn> listColumns = null;
    IConnection conn = null;
    IConnection connDimensions = null;
    IConnection connMetrics = null;
	boolean normalizedFlows = "true".equals(ElementParameterParser.getValue(node, "__NORMALIZED_OUTPUT__"));
    if (node.getOutgoingConnections() != null && node.getOutgoingConnections().size() > 0) {
    	if (normalizedFlows) {
		    List<? extends IConnection> connsDimensions = node.getOutgoingConnections("DIMENSION_VALUES");
		    if (connsDimensions != null && connsDimensions.size() > 0) {
		    	connDimensions = connsDimensions.get(0);
		    }
		    List<? extends IConnection> connsMetrics = node.getOutgoingConnections("METRIC_VALUES");
		    if (connsMetrics != null && connsMetrics.size() > 0) {
		    	connMetrics = connsMetrics.get(0);
		    }
    	} else {
		    List<? extends IConnection> connsPlain = node.getOutgoingConnections();
		    if (connsPlain != null && connsPlain.size() > 0) {
		    	conn = connsPlain.get(0);
		        IMetadataTable metadata = conn.getMetadataTable();
		        listColumns = metadata.getListColumns();
		    }
    	}
    }

    stringBuffer.append(TEXT_1);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
     } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
     }
     if (applicationName != null && applicationName.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(applicationName);
    stringBuffer.append(TEXT_13);
     }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(useServiceAccount);
    stringBuffer.append(TEXT_16);
      if (useServiceAccount) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(keyFile);
    stringBuffer.append(TEXT_21);
     } else { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(userEmail);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(clientSecretFile);
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
     if (timeout != null && timeout.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_30);
     }
     if (timeOffset != null && timeOffset.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(timeOffset);
    stringBuffer.append(TEXT_33);
     }
     if (fetchSize != null && fetchSize.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(fetchSize);
    stringBuffer.append(TEXT_36);
     }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(deliverTotalsDataset);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     if (dieOnError) { 
    stringBuffer.append(TEXT_42);
     } else { 
    stringBuffer.append(TEXT_43);
     } 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
     }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(profileId);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(startDate);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(endDate);
    stringBuffer.append(TEXT_58);
     if (dimensions != null && dimensions.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dimensions);
    stringBuffer.append(TEXT_61);
     }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(metrics);
    stringBuffer.append(TEXT_64);
     if (filters != null && filters.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(filters);
    stringBuffer.append(TEXT_67);
     }
     if (segment != null && segment.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(segment);
    stringBuffer.append(TEXT_70);
     }
     if (sorts != null && sorts.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(sorts);
    stringBuffer.append(TEXT_73);
     }
     if (samplingLevel != null && samplingLevel.trim().isEmpty() == false) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(samplingLevel);
    stringBuffer.append(TEXT_76);
     } 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
     if (dieOnError) { 
    stringBuffer.append(TEXT_80);
     } else { 
    stringBuffer.append(TEXT_81);
     } 
    stringBuffer.append(TEXT_82);
     if (normalizedFlows) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
     if (dieOnError) { 
    stringBuffer.append(TEXT_88);
     } else { 
    stringBuffer.append(TEXT_89);
     } 
    stringBuffer.append(TEXT_90);
    	 if (connDimensions != null) { 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(connDimensions.getName());
    stringBuffer.append(TEXT_99);
       } 
       if (connMetrics != null) { 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(connMetrics.getName());
    stringBuffer.append(TEXT_108);
       } 
     } else { 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
     if (dieOnError) { 
    stringBuffer.append(TEXT_114);
     } else { 
    stringBuffer.append(TEXT_115);
     } 
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
      if (conn != null) { 
    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_122);
      } 
    	int index = 0;
    if (listColumns != null && conn != null) {
        for (IMetadataColumn col : listColumns) {
        String javaClassName = JavaTypesManager.getJavaTypeFromId(col.getTalendType()).getNullableClass().getName(); 
    stringBuffer.append(TEXT_123);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_132);
              if (deliverTotalsDataset) {
		        if ("java.util.Date".equals(javaClassName)) { 
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_136);
                  if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_141);
                  } else { 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
                  } 
    stringBuffer.append(TEXT_155);
                  } else {
                    if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_160);
                      } else { 
    stringBuffer.append(TEXT_161);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
                      } 
    stringBuffer.append(TEXT_174);
                  } 
              } else {
                if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_179);
                  } else { 
    stringBuffer.append(TEXT_180);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
                  } 
    stringBuffer.append(TEXT_193);
              } 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_197);
          index++;
          } 
      } 
      } // if (normalizedFlows... 
    stringBuffer.append(TEXT_198);
    return stringBuffer.toString();
  }
}
