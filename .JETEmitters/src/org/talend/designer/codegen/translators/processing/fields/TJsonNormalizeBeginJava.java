package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class TJsonNormalizeBeginJava
{
  protected static String nl;
  public static synchronized TJsonNormalizeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJsonNormalizeBeginJava result = new TJsonNormalizeBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "    int nb_parsed_";
  protected final String TEXT_4 = " = 0;" + NL + "    de.cimt.talendcomp.mongodb.JSONHelper ";
  protected final String TEXT_5 = " = new de.cimt.talendcomp.mongodb.JSONHelper();";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = ".setStartPath(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = ".setIgnoreNullValues(";
  protected final String TEXT_11 = ");" + NL + "    // setup exclude fields";
  protected final String TEXT_12 = NL + "    ";
  protected final String TEXT_13 = ".addExcludeFields(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    String startPath = ElementParameterParser.getValue(node, "__JSON_START_PATH__");
    if (startPath == null || startPath.trim().isEmpty()) {
	    startPath = "null";
    }
    String excludeFieldList = ElementParameterParser.getValue(node, "__EXCLUDE_FIELD_LIST__");
    String ignoreNullValues = ElementParameterParser.getValue(node, "__IGNORE_NULL_VALUES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(startPath);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ignoreNullValues);
    stringBuffer.append(TEXT_11);
      if (excludeFieldList != null && excludeFieldList.isEmpty() == false) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(excludeFieldList);
    stringBuffer.append(TEXT_14);
      } 
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
