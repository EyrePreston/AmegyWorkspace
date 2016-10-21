package org.talend.designer.codegen.translators.business_intelligence.tableau;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TTableauTriggerScheduleMainJava
{
  protected static String nl;
  public static synchronized TTableauTriggerScheduleMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTableauTriggerScheduleMainJava result = new TTableauTriggerScheduleMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "tableauSrvrWebservice.Auth.WebServiceClient.authenticate(" + NL + "\t";
  protected final String TEXT_3 = "," + NL + "\t";
  protected final String TEXT_4 = "," + NL + "\t";
  protected final String TEXT_5 = "," + NL + "\t";
  protected final String TEXT_6 = NL + ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();


    stringBuffer.append(TEXT_2);
    stringBuffer.append( ElementParameterParser.getValue(node,"__HOST__") );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( ElementParameterParser.getValue(node,"__USERNAME__") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( ElementParameterParser.getValue(node,"__PASSWORD__") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( ElementParameterParser.getValue(node,"__SCHEDULE__") );
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
