package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;

public class TJsonNormalizeMainJava
{
  protected static String nl;
  public static synchronized TJsonNormalizeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJsonNormalizeMainJava result = new TJsonNormalizeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    " + NL + "    // get JSON or BSON from stream" + NL + "    Object input_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";" + NL + "    // create empty list to support null in input values" + NL + "    java.util.List<de.cimt.talendcomp.mongodb.JSONValue> result_";
  protected final String TEXT_6 = " = new java.util.ArrayList<de.cimt.talendcomp.mongodb.JSONValue>();" + NL + "    if (input_";
  protected final String TEXT_7 = " instanceof String) {" + NL + "        result_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".traverse((String) input_";
  protected final String TEXT_10 = ");" + NL + "        nb_parsed_";
  protected final String TEXT_11 = "++;" + NL + "    } else if (input_";
  protected final String TEXT_12 = " instanceof org.bson.BSONObject) {" + NL + "        result_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".traverse((org.bson.BSONObject) input_";
  protected final String TEXT_15 = ");" + NL + "        nb_parsed_";
  protected final String TEXT_16 = "++;" + NL + "    } else if (input_";
  protected final String TEXT_17 = " != null) {" + NL + "    \tthrow new Exception(\"Input column contains no possible JSON input types: String or BSONObject\");" + NL + "    }";
  protected final String TEXT_18 = " " + NL + "    if (result_";
  protected final String TEXT_19 = ".size() == 0) {" + NL + "        result_";
  protected final String TEXT_20 = ".add(";
  protected final String TEXT_21 = ".getDummyValue());" + NL + "    }";
  protected final String TEXT_22 = NL + "    // iterate through all key value objects" + NL + "    for (de.cimt.talendcomp.mongodb.JSONValue value_";
  protected final String TEXT_23 = " : result_";
  protected final String TEXT_24 = ") {" + NL + "        nb_line_";
  protected final String TEXT_25 = "++;" + NL + "\t\t";
  protected final String TEXT_26 = " = new ";
  protected final String TEXT_27 = "Struct();";
  protected final String TEXT_28 = NL + "        ";
  protected final String TEXT_29 = ".JSON_PATH = value_";
  protected final String TEXT_30 = ".getKeyPath(";
  protected final String TEXT_31 = "); ";
  protected final String TEXT_32 = "            " + NL + "    \t";
  protected final String TEXT_33 = ".JSON_KEY = value_";
  protected final String TEXT_34 = ".getKey();";
  protected final String TEXT_35 = "            " + NL + "    \t";
  protected final String TEXT_36 = ".JSON_VALUE = value_";
  protected final String TEXT_37 = ".getValueString();";
  protected final String TEXT_38 = "            " + NL + "\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String jsonInput = ElementParameterParser.getValue(node, "__JSON_INPUT_COLUMN__");
String keyPathDelimiter = ElementParameterParser.getValue(node, "__JSON_PATH_DELIMITER__");
boolean allowEmpty = "true".equals(ElementParameterParser.getValue(node, "__ALLOW_EMPTY__"));
String incomingConnName = null;
String outgoingConnName = null;
List<? extends IConnection> inConns = node.getIncomingConnections();
if (inConns != null && inConns.isEmpty() == false) {
    IConnection inConn = inConns.get(0);
    incomingConnName = inConn.getName();
}
List<? extends IConnection> outConns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
if (outConns != null && outConns.isEmpty() == false) {
    IConnection outConn = outConns.get(0);
    outgoingConnName = outConn.getName();
}
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.isEmpty() == false) {
    IMetadataTable metadata = metadatas.get(0);
    List<IMetadataColumn> metadataColumns = metadata.getListColumns(); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(jsonInput);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
      if (allowEmpty) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
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
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_27);
      if (metadataColumns != null && metadataColumns.size() > 0) {
    	for (IMetadataColumn metadataColumn : metadataColumns) {
            if ("JSON_PATH".equals(metadataColumn.getLabel())) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(keyPathDelimiter);
    stringBuffer.append(TEXT_31);
              } else if ("JSON_KEY".equals(metadataColumn.getLabel())) { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
              } else if ("JSON_VALUE".equals(metadataColumn.getLabel())) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
              } else { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_42);
              }           
        }
    }
} 
    return stringBuffer.toString();
  }
}
