package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomMessageIdListEndJava
{
  protected static String nl;
  public static synchronized TMomMessageIdListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomMessageIdListEndJava result = new TMomMessageIdListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t" + NL + "\t}" + NL + "\tflag";
  protected final String TEXT_3 = "=false;" + NL + "\tinput";
  protected final String TEXT_4 = ".close();" + NL + "}";
  protected final String TEXT_5 = NL + "}";
  protected final String TEXT_6 = NL + "\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_8 = " + \" .\");";
  protected final String TEXT_9 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_LINE\",nb_line_";
  protected final String TEXT_11 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("JBoss").equals(serverType)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}else{

    stringBuffer.append(TEXT_5);
    
	}
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
