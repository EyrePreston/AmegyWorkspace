package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileUnarchiveBeginJava
{
  protected static String nl;
  public static synchronized TFileUnarchiveBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileUnarchiveBeginJava result = new TFileUnarchiveBeginJava();
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
  protected final String TEXT_30 = " " + NL;
  protected final String TEXT_31 = "      " + NL + "\t\tcom.talend.compress.zip.Util util_";
  protected final String TEXT_32 = " = new com.talend.compress.zip.Util(";
  protected final String TEXT_33 = ");" + NL + "        " + NL + "        String zipFileURL_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "        String tmpFileURL_";
  protected final String TEXT_36 = " = zipFileURL_";
  protected final String TEXT_37 = ".toLowerCase();" + NL + "        String outputPath_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = "        " + NL + "        java.io.File file_";
  protected final String TEXT_41 = " = new java.io.File(zipFileURL_";
  protected final String TEXT_42 = ");        " + NL + "        String name_";
  protected final String TEXT_43 = " = file_";
  protected final String TEXT_44 = ".getName();        " + NL + "\t\tint i_";
  protected final String TEXT_45 = " = 0;" + NL + "\t\tif (tmpFileURL_";
  protected final String TEXT_46 = ".endsWith(\".tar.gz\"))  {" + NL + "\t\t\ti_";
  protected final String TEXT_47 = " = name_";
  protected final String TEXT_48 = ".length()-7;" + NL + "   \t\t} else {           " + NL + "            i_";
  protected final String TEXT_49 = " = name_";
  protected final String TEXT_50 = ".lastIndexOf('.');        " + NL + "            i_";
  protected final String TEXT_51 = " = i_";
  protected final String TEXT_52 = "!=-1? i_";
  protected final String TEXT_53 = " : name_";
  protected final String TEXT_54 = ".length();        " + NL + "        }    " + NL + "        String root_";
  protected final String TEXT_55 = " = name_";
  protected final String TEXT_56 = ".substring(0, i_";
  protected final String TEXT_57 = ");   " + NL + "        new java.io.File(outputPath_";
  protected final String TEXT_58 = ", root_";
  protected final String TEXT_59 = ").mkdir();" + NL + "        outputPath_";
  protected final String TEXT_60 = " = outputPath_";
  protected final String TEXT_61 = " +\"/\" + root_";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + NL + "\tif (tmpFileURL_";
  protected final String TEXT_64 = ".endsWith(\".tar.gz\") || tmpFileURL_";
  protected final String TEXT_65 = ".endsWith(\".tgz\")){   " + NL + "\t\tif(";
  protected final String TEXT_66 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_67 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_68 = " + \" is corrupted, process terminated...\" );" + NL + "\t\t}" + NL + "\t\torg.apache.tools.tar.TarInputStream zip_";
  protected final String TEXT_69 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_70 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_71 = " = new java.io.FileInputStream(zipFileURL_";
  protected final String TEXT_72 = ");" + NL + "\t\t\tinputStream_";
  protected final String TEXT_73 = " = new java.util.zip.GZIPInputStream(inputStream_";
  protected final String TEXT_74 = ");" + NL + "           \tzip_";
  protected final String TEXT_75 = " = new org.apache.tools.tar.TarInputStream(inputStream_";
  protected final String TEXT_76 = ");" + NL + "           \t" + NL + "            org.apache.tools.tar.TarEntry entry_";
  protected final String TEXT_77 = " = null;" + NL + "            java.io.InputStream is_";
  protected final String TEXT_78 = " = null;" + NL + "            while ((entry_";
  protected final String TEXT_79 = " = zip_";
  protected final String TEXT_80 = ".getNextEntry()) != null) {" + NL + "                boolean isDirectory_";
  protected final String TEXT_81 = " = entry_";
  protected final String TEXT_82 = ".isDirectory();" + NL + "    \t\t\tif (!isDirectory_";
  protected final String TEXT_83 = ") {" + NL + "                    is_";
  protected final String TEXT_84 = " = zip_";
  protected final String TEXT_85 = ";" + NL + "    \t\t\t}" + NL + "                String filename_";
  protected final String TEXT_86 = " =  entry_";
  protected final String TEXT_87 = ".getName();" + NL + "                util_";
  protected final String TEXT_88 = ".output(outputPath_";
  protected final String TEXT_89 = ", filename_";
  protected final String TEXT_90 = ", isDirectory_";
  protected final String TEXT_91 = ", is_";
  protected final String TEXT_92 = ");\t\t\t" + NL + "    ";
  protected final String TEXT_93 = "  " + NL + "                java.io.File f = new java.io.File(outputPath_";
  protected final String TEXT_94 = "+\"/\"+ filename_";
  protected final String TEXT_95 = ");  " + NL + "                f.setLastModified(entry_";
  protected final String TEXT_96 = ".getModTime().getTime());  ";
  protected final String TEXT_97 = "  " + NL + "                java.io.File unzippedFile = new java.io.File(outputPath_";
  protected final String TEXT_98 = " + util_";
  protected final String TEXT_99 = ".getEntryName(filename_";
  protected final String TEXT_100 = "));  " + NL + "                unzippedFile.setLastModified(entry_";
  protected final String TEXT_101 = ".getModTime().getTime());  ";
  protected final String TEXT_102 = " " + NL + "            }" + NL + "        } finally {" + NL + "        \tif(zip_";
  protected final String TEXT_103 = " != null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_104 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_105 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_106 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} else if (tmpFileURL_";
  protected final String TEXT_107 = ".endsWith(\".tar\")){ " + NL + "\t\tif(";
  protected final String TEXT_108 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_109 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_110 = " + \" is corrupted, process terminated...\" );" + NL + "" + NL + "\t\t}" + NL + "\t\torg.apache.tools.tar.TarInputStream zip_";
  protected final String TEXT_111 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_112 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_113 = " = new java.io.FileInputStream(zipFileURL_";
  protected final String TEXT_114 = ");" + NL + "           \tzip_";
  protected final String TEXT_115 = " = new org.apache.tools.tar.TarInputStream(inputStream_";
  protected final String TEXT_116 = ");" + NL + "           \t" + NL + "            org.apache.tools.tar.TarEntry entry_";
  protected final String TEXT_117 = " = null;" + NL + "            java.io.InputStream is_";
  protected final String TEXT_118 = " = null;" + NL + "            while ((entry_";
  protected final String TEXT_119 = " = zip_";
  protected final String TEXT_120 = ".getNextEntry()) != null) {" + NL + "                boolean isDirectory_";
  protected final String TEXT_121 = " = entry_";
  protected final String TEXT_122 = ".isDirectory(); " + NL + "                if (!isDirectory_";
  protected final String TEXT_123 = ") {" + NL + "                    is_";
  protected final String TEXT_124 = " = zip_";
  protected final String TEXT_125 = ";" + NL + "    \t\t\t}" + NL + "                String filename_";
  protected final String TEXT_126 = " =  entry_";
  protected final String TEXT_127 = ".getName();" + NL + "                util_";
  protected final String TEXT_128 = ".output(outputPath_";
  protected final String TEXT_129 = ", filename_";
  protected final String TEXT_130 = ", isDirectory_";
  protected final String TEXT_131 = ", is_";
  protected final String TEXT_132 = ");            " + NL + "             ";
  protected final String TEXT_133 = "  " + NL + "                       java.io.File f = new java.io.File(outputPath_";
  protected final String TEXT_134 = "+\"/\"+ filename_";
  protected final String TEXT_135 = ");  " + NL + "                       f.setLastModified(entry_";
  protected final String TEXT_136 = ".getModTime().getTime());  ";
  protected final String TEXT_137 = "  " + NL + "                       java.io.File unzippedFile = new java.io.File(outputPath_";
  protected final String TEXT_138 = " + util_";
  protected final String TEXT_139 = ".getEntryName(filename_";
  protected final String TEXT_140 = "));  " + NL + "                       unzippedFile.setLastModified(entry_";
  protected final String TEXT_141 = ".getModTime().getTime());  ";
  protected final String TEXT_142 = " " + NL + "    " + NL + "            }" + NL + "        } finally {" + NL + "        \tif(zip_";
  protected final String TEXT_143 = "!=null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_144 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_145 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_146 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "  \t}else if (tmpFileURL_";
  protected final String TEXT_147 = ".endsWith(\".gz\")){ " + NL + "  \t\tif(";
  protected final String TEXT_148 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_149 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_150 = " + \" is corrupted, process terminated...\" );" + NL + "" + NL + "\t\t}" + NL + "\t\tjava.util.zip.GZIPInputStream zip_";
  protected final String TEXT_151 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_152 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_153 = " = new java.io.FileInputStream(new java.io.File(zipFileURL_";
  protected final String TEXT_154 = "));" + NL + "           \tzip_";
  protected final String TEXT_155 = " = new java.util.zip.GZIPInputStream(inputStream_";
  protected final String TEXT_156 = ");" + NL + "           \t" + NL + "            java.io.InputStream is_";
  protected final String TEXT_157 = " = zip_";
  protected final String TEXT_158 = ";" + NL + "            String fullName_";
  protected final String TEXT_159 = " = new java.io.File(zipFileURL_";
  protected final String TEXT_160 = ").getName();  " + NL + "    \t\tString filename_";
  protected final String TEXT_161 = " =  fullName_";
  protected final String TEXT_162 = ".substring(0, fullName_";
  protected final String TEXT_163 = ".length()-3);  " + NL + "    \t\tutil_";
  protected final String TEXT_164 = ".output(outputPath_";
  protected final String TEXT_165 = ", filename_";
  protected final String TEXT_166 = ",is_";
  protected final String TEXT_167 = ");" + NL + "\t\t} finally {" + NL + "\t\t\tif(zip_";
  protected final String TEXT_168 = " != null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_169 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_170 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_171 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}else {" + NL + "\t\t//the others all use the ZIP to decompression" + NL + "\t\tcom.talend.compress.zip.Unzip unzip_";
  protected final String TEXT_172 = " = new com.talend.compress.zip.Unzip(zipFileURL_";
  protected final String TEXT_173 = ", outputPath_";
  protected final String TEXT_174 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_175 = ".setNeedPassword(";
  protected final String TEXT_176 = ");" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_178 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_179 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = "; ";
  protected final String TEXT_184 = NL + "\t   \t" + NL + "\t\tunzip_";
  protected final String TEXT_185 = ".setPassword(decryptedPassword_";
  protected final String TEXT_186 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_187 = ".setCheckArchive(";
  protected final String TEXT_188 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_189 = ".setVerbose(";
  protected final String TEXT_190 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_191 = ".setExtractPath(";
  protected final String TEXT_192 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_193 = ".setUtil(util_";
  protected final String TEXT_194 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_195 = ".setUseAesDecryption(";
  protected final String TEXT_196 = ");" + NL + "\t\t" + NL + "\t\tunzip_";
  protected final String TEXT_197 = ".doUnzip();" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\tfor (com.talend.compress.zip.UnzippedFile uf";
  protected final String TEXT_198 = " : util_";
  protected final String TEXT_199 = ".unzippedFiles) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_200 = "_CURRENT_FILE\", uf";
  protected final String TEXT_201 = ".fileName);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_202 = "_CURRENT_FILEPATH\", uf";
  protected final String TEXT_203 = ".filePath);" + NL + "\t";
  protected final String TEXT_204 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
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
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	

	String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
	String zipFile = ElementParameterParser.getValue(node, "__ZIPFILE__");
	boolean rootName = ("true").equals(ElementParameterParser.getValue(node, "__ROOTNAME__"));
	boolean extractPath = ("true").equals(ElementParameterParser.getValue(node, "__EXTRACTPATH__"));
	
	boolean isArchiveValid = ("true").equals(ElementParameterParser.getValue(node, "__INTEGRITY__"));
	boolean isPasswordNeeded = ("true").equals(ElementParameterParser.getValue(node, "__CHECKPASSWORD__"));
	boolean needPrintout = ("true").equals(ElementParameterParser.getValue(node, "__PRINTOUT__"));
	
	String decryptMethod = ElementParameterParser.getValue(node, "__DECRYPT_METHOD__");

	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(extractPath);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_39);
    
	if (rootName==true) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
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
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
     if (extractPath == true) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    } else {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
     }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
     if (extractPath == true) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    } else {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
     }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(isPasswordNeeded);
    stringBuffer.append(TEXT_176);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_177);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_180);
    } else {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(needPrintout);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(extractPath);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append("AES256".equals(decryptMethod));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    return stringBuffer.toString();
  }
}
