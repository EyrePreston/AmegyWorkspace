package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TFileInputFullRowBeginJava
{
  protected static String nl;
  public static synchronized TFileInputFullRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputFullRowBeginJava result = new TFileInputFullRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "org.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_32 = " = null;" + NL;
  protected final String TEXT_33 = NL + NL + "try{" + NL + "fid_";
  protected final String TEXT_34 = " =new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = ",\"\",";
  protected final String TEXT_37 = ",";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ",false);" + NL + "while (fid_";
  protected final String TEXT_43 = ".nextRecord()) {";
  protected final String TEXT_44 = NL + "    \t\t";
  protected final String TEXT_45 = " = null;\t\t\t";
  protected final String TEXT_46 = "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_47 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_48 = " = new ";
  protected final String TEXT_49 = "Struct();" + NL + "\t\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_50 = "String temp_";
  protected final String TEXT_51 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = " = fid_";
  protected final String TEXT_55 = ".get(";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = "\t\t\t" + NL;
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " = null; ";
  protected final String TEXT_60 = NL + "\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_61 = " = true;";
  protected final String TEXT_62 = NL + "            throw(e);";
  protected final String TEXT_63 = "                    ";
  protected final String TEXT_64 = NL + "                    ";
  protected final String TEXT_65 = " = new ";
  protected final String TEXT_66 = "Struct();";
  protected final String TEXT_67 = NL + "                    ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ";";
  protected final String TEXT_72 = NL + "                ";
  protected final String TEXT_73 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "                ";
  protected final String TEXT_76 = " = null;";
  protected final String TEXT_77 = NL + "        \t\tlog.error(\"";
  protected final String TEXT_78 = " - \" +e.getMessage());" + NL + "\t        \t";
  protected final String TEXT_79 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_80 = NL + "                ";
  protected final String TEXT_81 = " = null;";
  protected final String TEXT_82 = NL + "            \t";
  protected final String TEXT_83 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL + "    }" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = "if(!whetherReject_";
  protected final String TEXT_88 = ") { ";
  protected final String TEXT_89 = "      " + NL + "             if(";
  protected final String TEXT_90 = " == null){ " + NL + "            \t ";
  protected final String TEXT_91 = " = new ";
  protected final String TEXT_92 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_93 = NL + "\t    \t ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ";    \t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t";
  protected final String TEXT_99 = " } ";
  protected final String TEXT_100 = "\t";
  protected final String TEXT_101 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		String filename = ElementParameterParser.getValue(node,"__FILENAME__");
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	if(("").equals(header)){
    		header="0";
    	}
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		if(("").equals(limit)){
			limit = "-1";
		}
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	if(("").equals(footer)){
    		footer="0";
    	}
    	String random = "-1";
    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
    	if(("true").equals(ran)){
    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
    		if(("").equals(random)){
    			random="0";
    		}
    	}
		
    	
    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_45);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    	
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				if(noStringTypeExist){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
				}
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					
    stringBuffer.append(TEXT_52);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_56);
    				}
				

    stringBuffer.append(TEXT_57);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_62);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_66);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    
                }
                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_76);
    
            } else if(("").equals(rejectConnName)){
	            if(isLog4jEnabled){
	        	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
	        	}
                
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_81);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_84);
    }
        } 
        
    stringBuffer.append(TEXT_85);
    
			}
		}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_86);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_92);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_98);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_99);
     } 
    stringBuffer.append(TEXT_100);
    
		}
	  }
	}
}

    stringBuffer.append(TEXT_101);
    return stringBuffer.toString();
  }
}
