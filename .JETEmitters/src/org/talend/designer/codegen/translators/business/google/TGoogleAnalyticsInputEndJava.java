package org.talend.designer.codegen.translators.business.google;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGoogleAnalyticsInputEndJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsInputEndJava result = new TGoogleAnalyticsInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       if (countLines_";
  protected final String TEXT_2 = " >= ";
  protected final String TEXT_3 = ") {" + NL + "           break;" + NL + "       }";
  protected final String TEXT_4 = "    " + NL + "\t} // close while from output connection of ";
  protected final String TEXT_5 = NL + "\tint ";
  protected final String TEXT_6 = "_totalAffectedRows = 0;" + NL + "\tboolean ";
  protected final String TEXT_7 = "_isSampled = false;" + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_8 = "_totalAffectedRows = ";
  protected final String TEXT_9 = ".getTotalAffectedRows();" + NL + "\t\t";
  protected final String TEXT_10 = "_isSampled = ";
  protected final String TEXT_11 = ".containsSampledData();" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_12 = NL + "\t\tthrow e;";
  protected final String TEXT_13 = "\t\t" + NL + "\t}";
  protected final String TEXT_14 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_15 = "_NB_LINE_DIMENSIONS\", countDimensionValues_";
  protected final String TEXT_16 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE_METRICS\", countMetricValues_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_20 = "_NB_LINE\", countLines_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = "    " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_23 = "_TOTAL_AFFECTED_ROWS\", ";
  protected final String TEXT_24 = "_totalAffectedRows);" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_25 = "_CONTAINS_SAMPLED_DATA\", ";
  protected final String TEXT_26 = "_isSampled);" + NL + "\tif (";
  protected final String TEXT_27 = "_isSampled) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_28 = "_SAMPLE_SIZE\", ";
  protected final String TEXT_29 = ".getSampleSize());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_30 = "_SAMPLE_SPACE\", ";
  protected final String TEXT_31 = ".getSampleSpace());" + NL + "\t} else {" + NL + "\t\tglobalMap.remove(\"";
  protected final String TEXT_32 = "_SAMPLE_SIZE\");" + NL + "\t\tglobalMap.remove(\"";
  protected final String TEXT_33 = "_SAMPLE_SPACE\");" + NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName(); 
	String maxRowsStr = ElementParameterParser.getValue(node, "__MAX_ROWS__");
	int maxRows = 0;
	if (maxRowsStr != null && maxRowsStr.isEmpty() == false) {
		maxRows = Integer.parseInt(maxRowsStr);
	}
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean normalizedFlows = "true".equals(ElementParameterParser.getValue(node, "__NORMALIZED_OUTPUT__"));

     if (normalizedFlows == false) { 
      if (maxRows > 0) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_3);
      } 
     } 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
      if (dieOnError) { 
    stringBuffer.append(TEXT_12);
      } 
    stringBuffer.append(TEXT_13);
     if (normalizedFlows) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     } else { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
