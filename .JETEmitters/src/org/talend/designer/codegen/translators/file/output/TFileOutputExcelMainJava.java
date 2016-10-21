package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_30 = ".putValue_";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ",writableSheet_";
  protected final String TEXT_33 = "," + NL + "\t\t\t\t\tstartRowNum_";
  protected final String TEXT_34 = ",nb_line_";
  protected final String TEXT_35 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = "format_";
  protected final String TEXT_37 = "null";
  protected final String TEXT_38 = ",fitWidth_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = "\t\t\t\t";
  protected final String TEXT_42 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_46 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = " = writableSheet_";
  protected final String TEXT_51 = ".getWritableCell(";
  protected final String TEXT_52 = " + ";
  protected final String TEXT_53 = ", startRowNum_";
  protected final String TEXT_54 = " + nb_line_";
  protected final String TEXT_55 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = " = new jxl.write.";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = " + ";
  protected final String TEXT_61 = ", startRowNum_";
  protected final String TEXT_62 = " + nb_line_";
  protected final String TEXT_63 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = " = new jxl.write.";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ", startRowNum_";
  protected final String TEXT_69 = " + nb_line_";
  protected final String TEXT_70 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = NL + "//modif end";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ", cell_format_";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ")";
  protected final String TEXT_79 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ".toString()";
  protected final String TEXT_82 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = ")).toString()";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_87 = "), ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = "), ";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_95 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_96 = ").doubleValue()";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = ".setCellFormat( existingCell_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_108 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_109 = ".addCell(cell_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_115 = "_";
  protected final String TEXT_116 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = "=currentWith_";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ">10?10:currentWith_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = ";";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = " = cell_";
  protected final String TEXT_126 = "_";
  protected final String TEXT_127 = ".getContents().trim().length();";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_129 = "[";
  protected final String TEXT_130 = "]=fitWidth_";
  protected final String TEXT_131 = "[";
  protected final String TEXT_132 = "]>currentWith_";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = "?fitWidth_";
  protected final String TEXT_135 = "[";
  protected final String TEXT_136 = "]:currentWith_";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = "+2;";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = "=";
  protected final String TEXT_142 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_143 = "[";
  protected final String TEXT_144 = "]=fitWidth_";
  protected final String TEXT_145 = "[";
  protected final String TEXT_146 = "]>currentWith_";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = "?fitWidth_";
  protected final String TEXT_149 = "[";
  protected final String TEXT_150 = "]:currentWith_";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = "+2;";
  protected final String TEXT_153 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_154 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_155 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_157 = ".addRow();";
  protected final String TEXT_158 = NL + "   \t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_159 = ".putValue_";
  protected final String TEXT_160 = "(";
  protected final String TEXT_161 = ",xlsxTool_";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "\t\t\t\t";
  protected final String TEXT_164 = "\t\t\t\t\t";
  protected final String TEXT_165 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_169 = ".addCellValue(";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = ", ";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_174 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ")).toString());";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_179 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_180 = "), ";
  protected final String TEXT_181 = ", ";
  protected final String TEXT_182 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_184 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = "), ";
  protected final String TEXT_187 = ", ";
  protected final String TEXT_188 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_189 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_190 = ".addCellValue((";
  protected final String TEXT_191 = ").doubleValue());";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_193 = ".addCellValue(";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = ");";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_197 = ".addCellValue(";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_201 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = ")));";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_205 = ".addCellValue(String.valueOf(";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = "));";
  protected final String TEXT_208 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_209 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_210 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_211 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\tbufferCount_";
  protected final String TEXT_213 = "++;" + NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_214 = " >= flushRowNum_";
  protected final String TEXT_215 = "){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_216 = ".flushRowInMemory();" + NL + "    \t\t\t\t\tbufferCount_";
  protected final String TEXT_217 = "=0;" + NL + "    \t\t\t\t}";

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
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
String font = ElementParameterParser.getValue(node, "__FONT__"); 
//modif start
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
//modif end
boolean keepCellFormating =  ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__").equals("true");
boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		if(!version07){//version judgement
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
    					}
    					continue;
    				}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_44);
    
    				} 
    				
    stringBuffer.append(TEXT_45);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
   				
    stringBuffer.append(TEXT_46);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_47);
    if(keepCellFormating){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }else{
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_84);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_85);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_89);
     } else { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_94);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_96);
    
					}else {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_100);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
							}
							
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
					if(isNumber){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
					}else{

    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
					}else{

    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_153);
    
    				} 
    			
    
				}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    log4jFileUtil.debugWriteData(node);
    
    		}
    	}
    	}else{ //version judgement /***excel 2007 xlsx*****/

		List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
    					}
    					continue;
	        		}

    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_172);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_177);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_182);
     } else { 
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_188);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_191);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    
					}else{	

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_207);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
    				} 
    				
    
    			}
    			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    log4jFileUtil.debugWriteData(node);
    
				if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
				}
    		}
    	}

    	}
    }
}

    return stringBuffer.toString();
  }
}
