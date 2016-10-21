package org.talend.designer.codegen.translators.business.google;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TGoogleAdWordsReportEndJava
{
  protected static String nl;
  public static synchronized TGoogleAdWordsReportEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAdWordsReportEndJava result = new TGoogleAdWordsReportEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tcountLines_";
  protected final String TEXT_2 = "++;" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", countLines_";
  protected final String TEXT_4 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	boolean downloadAsFile = "true".equals(ElementParameterParser.getValue(node, "__DOWNLOAD_AS_FILE__"));
    String connName = null;
    if (node.getOutgoingConnections().size() > 0) {
        IConnection conn = node.getOutgoingConnections().get(0);
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		    connName = conn.getName();
        }
    }

     if (downloadAsFile == false && connName != null) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
     } 
    return stringBuffer.toString();
  }
}
