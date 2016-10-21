package org.talend.designer.codegen.translators.cloud.amazons3;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TS3ListEndJava
{
  protected static String nl;
  public static synchronized TS3ListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListEndJava result = new TS3ListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\t\t\t}" + NL + "\t\t\tif(!objects_";
  protected final String TEXT_3 = ".isTruncated()){" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t\tobjects_";
  protected final String TEXT_4 = " = conn_";
  protected final String TEXT_5 = ".listNextBatchOfObjects(objects_";
  protected final String TEXT_6 = ");" + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_8 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tthrow(e_";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_12 = " - \" + e_";
  protected final String TEXT_13 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_15 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_18 = NL + "\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_19 = "){" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_21 = ");" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_23 = " - \" + e_";
  protected final String TEXT_24 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_26 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_28 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_29 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_31 = "_NB_BUCKET\", nb_bucket_";
  protected final String TEXT_32 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_33 = "_NB_BUCKET_OBJECT\", nb_bucket_object_";
  protected final String TEXT_34 = ");" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tlog.info(\"";
  protected final String TEXT_36 = " - Retrieved the buckets count: \" + nb_bucket_";
  protected final String TEXT_37 = " + \" .\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_38 = " - Retrieved the objects count: \" + nb_bucket_object_";
  protected final String TEXT_39 = " + \" .\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(listAll || buckets.size()>0){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		    if(!listAll){
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
					if (("true").equals(dieOnError)) {
					
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
					} else {
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
						}
						
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
					}
					
    stringBuffer.append(TEXT_16);
    
			}
			
    stringBuffer.append(TEXT_17);
    
	}
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			}
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
		}
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    		
	}
	
    return stringBuffer.toString();
  }
}
