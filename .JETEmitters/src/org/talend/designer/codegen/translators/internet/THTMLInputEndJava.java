package org.talend.designer.codegen.translators.internet;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;

public class THTMLInputEndJava
{
  protected static String nl;
  public static synchronized THTMLInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THTMLInputEndJava result = new THTMLInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}" + NL + "globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\",nb_line_";
  protected final String TEXT_3 = ");" + NL + "" + NL + "break;" + NL + "} " + NL + "catch (java.lang.NullPointerException e_e_p){" + NL + "\tif(die_";
  protected final String TEXT_4 = ")" + NL + "\t{\t\t" + NL + "\t\t//System.out.println(\"connection_or_document_Null_point_exception_3\");" + NL + "\t\tthrow new Exception();\t\t// it is actually java.lang.NullPointException but this exception is handled so to stop execution we throw unhandled exception Exception " + NL + "\t}" + NL + "\telse" + NL + "\t{\t\t" + NL + "\t\t//System.out.println(\"connection_or_document_Null_point_exception_2\");" + NL + "\t\tif (count_";
  protected final String TEXT_5 = "++ == maxReTries_";
  protected final String TEXT_6 = ")" + NL + "\t\t{" + NL + "\t\t\te_e_p.printStackTrace();\t\t" + NL + "\t\t\tbreak;" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
