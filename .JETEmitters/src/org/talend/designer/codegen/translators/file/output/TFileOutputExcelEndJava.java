package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelEndJava result = new TFileOutputExcelEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_30 = ".setColumnView_";
  protected final String TEXT_31 = "(writableSheet_";
  protected final String TEXT_32 = ",fitWidth_";
  protected final String TEXT_33 = ");" + NL + "\t";
  protected final String TEXT_34 = NL + "\t//modif start" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_36 = ".setColumnView(";
  protected final String TEXT_37 = " + ";
  protected final String TEXT_38 = ", fitWidth_";
  protected final String TEXT_39 = "[";
  protected final String TEXT_40 = "]);" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_42 = ".setColumnView(";
  protected final String TEXT_43 = ", fitWidth_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "]);" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t//modif end" + NL + "\t";
  protected final String TEXT_47 = NL + "\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_48 = ".setColumnView_";
  protected final String TEXT_49 = "(writableSheet_";
  protected final String TEXT_50 = ",fitWidth_";
  protected final String TEXT_51 = ");" + NL + "\t";
  protected final String TEXT_52 = NL + "\t\twritableSheet_";
  protected final String TEXT_53 = ".setColumnView(";
  protected final String TEXT_54 = ", fitWidth_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "]);" + NL + "\t";
  protected final String TEXT_57 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_58 = ".write();" + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_59 = ".close();" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tnb_line_";
  protected final String TEXT_61 = " = nb_line_";
  protected final String TEXT_62 = " -1;" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_NB_LINE\",nb_line_";
  protected final String TEXT_65 = ");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_66 = NL + "\t\tif(isFileGenerated_";
  protected final String TEXT_67 = " && nb_line_";
  protected final String TEXT_68 = " == 0){" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_70 = " - Creating directory '\" + file_";
  protected final String TEXT_71 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\tfile_";
  protected final String TEXT_73 = ".delete();" + NL + "\t    \t";
  protected final String TEXT_74 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_75 = " - Create directory '\"+ file_";
  protected final String TEXT_76 = ".getCanonicalPath() + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t}\t\t" + NL + "\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_79 = ".setColAutoSize_";
  protected final String TEXT_80 = "(xlsxTool_";
  protected final String TEXT_81 = ");" + NL + "\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_83 = ".setColAutoSize(";
  protected final String TEXT_84 = ");" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_86 = ".setColAutoSize_";
  protected final String TEXT_87 = "(xlsxTool_";
  protected final String TEXT_88 = ");" + NL + "\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_90 = ".setColAutoSize(";
  protected final String TEXT_91 = ");" + NL + "\t";
  protected final String TEXT_92 = NL + "\t" + NL + "\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_94 = "!=0){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_95 = ".flushRowInMemory();" + NL + "    \t\t\t\t\t//flush all rocords in memory on disk." + NL + "    \t\t\t\t}" + NL + "\t";
  protected final String TEXT_96 = NL + "\t";
  protected final String TEXT_97 = NL + "\t\t\txlsxTool_";
  protected final String TEXT_98 = ".writeExcel(";
  protected final String TEXT_99 = ");" + NL + "\t";
  protected final String TEXT_100 = NL + "\t\t\txlsxTool_";
  protected final String TEXT_101 = ".writeExcel(fileName_";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = ");" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\t";
  protected final String TEXT_105 = NL + "\t\t\tnb_line_";
  protected final String TEXT_106 = " = nb_line_";
  protected final String TEXT_107 = " -1;" + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_109 = "_NB_LINE\",nb_line_";
  protected final String TEXT_110 = ");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_111 = NL + "\t\tif(isFileGenerated_";
  protected final String TEXT_112 = " && nb_line_";
  protected final String TEXT_113 = " == 0){" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_115 = " - Creating directory '\" + file_";
  protected final String TEXT_116 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\tfile_";
  protected final String TEXT_118 = ".delete();" + NL + "\t    \t";
  protected final String TEXT_119 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - Create directory '\"+ file_";
  protected final String TEXT_121 = ".getCanonicalPath() + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t}\t\t" + NL + "\t";
  protected final String TEXT_123 = "\t";
  protected final String TEXT_124 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));

	boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
	String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
	boolean createDir = ("true").equals(ElementParameterParser.getValue(node,"__CREATE__"));	
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));	
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND_FILE__"));
	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
	
	String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
	boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
	boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
	//modif start
	boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
	String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
	String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
	//modif end
	
	boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
	List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");
	
	int schemaOptNum=100;
    String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
    if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
    }
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if((conns == null) || (conns.size() < 1) || (conns.get(0) == null)) {
		return "";
	}
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(!version07){//version judgement
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
	    	IMetadataTable metadata = metadatas.get(0);
	        if (metadata!=null) {
	        	List<IMetadataColumn> columns = metadata.getListColumns();
	        	int sizeColumns = columns.size();
	        	if(isAllColumnAutoSize){
	        		for(int i=0;i<columns.size();i++){
	        			if(sizeColumns > schemaOptNum) {
	        				if(i%schemaOptNum==0){
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
	        				}
	        				continue;
	        			}
	
    stringBuffer.append(TEXT_34);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_40);
    }else{
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
	    			}
	    		}else{
	    			if(autoSizeList.size() == columns.size()){
	                	for(int i=0;i<columns.size();i++){
	        				if(sizeColumns > schemaOptNum) {
	        					if(i%schemaOptNum==0){
	        						boolean emptyMethod = true;
	        						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
                						Map<String,String> tmp= autoSizeList.get(i+j);
                						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
                							emptyMethod = false;
                							break;
                						}
									}
									
									if(!emptyMethod) {
	
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
									}
	        					}
	        					continue;
	        				}
	                		Map<String,String> tmp= autoSizeList.get(i);
	                		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){ 
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    
	                		}
	                	}
	                }
	    		}
	    	}
	    }
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    if(isIncludeHeader){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    if(!useStream && isDeleteEmptyFile){
	
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    }
		log4jFileUtil.writeDataFinishInfo(node);
	}else{//version judgement /***excel 2007 xlsx*****/
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
	    	IMetadataTable metadata = metadatas.get(0);
	        if (metadata!=null) {
	        	List<IMetadataColumn> columns = metadata.getListColumns();
	        	int sizeColumns = columns.size();
	        	if(isAllColumnAutoSize){
	        		for(int i=0;i<columns.size();i++){
	        			if(sizeColumns > schemaOptNum) {
	        				if(i%schemaOptNum==0){
	
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	        				}
	        				continue;
	        			}
	
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
	    			}
	    		}else{
	    			if(autoSizeList.size() == columns.size()){
	                	for(int i=0;i<columns.size();i++){
	                		if(sizeColumns > schemaOptNum) {
	        					if(i%schemaOptNum==0){
	        						boolean emptyMethod = true;
	        						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
                						Map<String,String> tmp= autoSizeList.get(i+j);
                						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
                							emptyMethod = false;
                							break;
                						}
									}
									
									if(!emptyMethod) {
	
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
									}
	        					}
	        					continue;
	        				}
	                		Map<String,String> tmp= autoSizeList.get(i);
	                		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){ 
	
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_91);
    
	                		}
	                	}
	                }
	    		}
	    	}
	    }
	
    stringBuffer.append(TEXT_92);
    
				if(flushOnRow && (useStream || !isAppendFile)){
	
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				}
	
    stringBuffer.append(TEXT_96);
    
		if(useStream){
	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outStream);
    stringBuffer.append(TEXT_99);
    
		}else{	
	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(createDir);
    stringBuffer.append(TEXT_103);
    
		}
	
    stringBuffer.append(TEXT_104);
    if(isIncludeHeader){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    if(!useStream && isDeleteEmptyFile){
	
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    }
log4jFileUtil.writeDataFinishInfo(node);
	}
	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
