package org.talend.designer.codegen.translators.cloud.google;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TGoogleDriveEndJava
{
  protected static String nl;
  public static synchronized TGoogleDriveEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveEndJava result = new TGoogleDriveEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t} // close while from output connection of ";
  protected final String TEXT_2 = " " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", countFiles_";
  protected final String TEXT_4 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName(); 
    List<? extends IConnection> connsFiles = node.getOutgoingConnections("FILES");
    String filesRowName = null;
    if (connsFiles != null && connsFiles.size() > 0) {
    	IConnection connTemp = connsFiles.get(0);
    	if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		filesRowName = connTemp.getName();
    	}
    }
    
      if (filesRowName != null) { 
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
