package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class THTMLInputBeginJava
{
  protected static String nl;
  public static synchronized THTMLInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THTMLInputBeginJava result = new THTMLInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/*" + NL + " * Dynamic Settings." + NL + " */" + NL + "Boolean followRedirects_";
  protected final String TEXT_2 = " = false; " + NL + "Boolean debug_";
  protected final String TEXT_3 = " = false; " + NL + "Boolean die_";
  protected final String TEXT_4 = " = false; " + NL;
  protected final String TEXT_5 = NL + "\tfollowRedirects_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "\tfollowRedirects_";
  protected final String TEXT_9 = " = true;";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\tdebug_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "\tdebug_";
  protected final String TEXT_15 = " = true;";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\tdie_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "\tdie_";
  protected final String TEXT_21 = " = true;";
  protected final String TEXT_22 = NL + NL + "/*" + NL + " * Initialisation." + NL + " */" + NL + "int nb_line_";
  protected final String TEXT_23 = " = 0;" + NL + "" + NL + "/*" + NL + " * Process document." + NL + " */" + NL + "// System.out.println(\"PASSED\");" + NL + "int count_";
  protected final String TEXT_24 = " = 0;" + NL + "int maxReTries_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "; // get it from number field" + NL + "" + NL + "while(true)" + NL + "{" + NL + "try {" + NL + "\t" + NL + "org.jsoup.nodes.Document document_";
  protected final String TEXT_27 = " = null;" + NL + "org.jsoup.Connection connection_";
  protected final String TEXT_28 = " = null;" + NL + "" + NL + "String scheme_";
  protected final String TEXT_29 = " = null;" + NL + "String host_";
  protected final String TEXT_30 = " = null;" + NL + "Integer hTTPStatusCode_";
  protected final String TEXT_31 = " = null;" + NL + "int parseStatus_";
  protected final String TEXT_32 = " = 0;" + NL + "String parseErrorText_";
  protected final String TEXT_33 = " = null;" + NL + "Date getTimestamp_";
  protected final String TEXT_34 = " = null;" + NL + "Long getTime_";
  protected final String TEXT_35 = " = null;" + NL + "//System.out.println(\"PASSED-1\");" + NL + "" + NL + "try {" + NL + "\t/*" + NL + "\t * Get scheme & host." + NL + "\t */" + NL + "\tjava.net.URI uri = new java.net.URI(";
  protected final String TEXT_36 = ");" + NL + "\tscheme_";
  protected final String TEXT_37 = " = uri.getScheme();" + NL + "\thost_";
  protected final String TEXT_38 = " = uri.getHost();" + NL + "" + NL + "\t/*" + NL + "\t * Connect." + NL + "\t */" + NL + "\t//document_";
  protected final String TEXT_39 = " = org.jsoup.Jsoup.connect(";
  protected final String TEXT_40 = ").get();" + NL + "\tconnection_";
  protected final String TEXT_41 = " = org.jsoup.Jsoup.connect(";
  protected final String TEXT_42 = ");" + NL + "    " + NL + "\t/*" + NL + "\t * Set timeout." + NL + "\t */" + NL + "\tconnection_";
  protected final String TEXT_43 = ".timeout(";
  protected final String TEXT_44 = ");" + NL + "" + NL + "\t/*" + NL + "\t * Set userAgent." + NL + "\t */" + NL + "\tif(";
  protected final String TEXT_45 = " != null &&" + NL + "\t   ! \"null\".equalsIgnoreCase(";
  protected final String TEXT_46 = ".trim()) &&" + NL + "\t   ! \"\".equalsIgnoreCase(";
  protected final String TEXT_47 = ".trim())) connection_";
  protected final String TEXT_48 = ".userAgent(";
  protected final String TEXT_49 = ");" + NL + "" + NL + "\t/*" + NL + "\t * Set followRedirects" + NL + "\t */" + NL + "\tconnection_";
  protected final String TEXT_50 = ".followRedirects(followRedirects_";
  protected final String TEXT_51 = ");" + NL + " " + NL + "\t/*" + NL + "\t * Set maxBodySize" + NL + "\t */" + NL + "\t";
  protected final String TEXT_52 = NL + "\t\tconnection_";
  protected final String TEXT_53 = ".maxBodySize(";
  protected final String TEXT_54 = ");" + NL + "\t";
  protected final String TEXT_55 = NL + NL + "\t/*" + NL + "\t * Set HTTP header values." + NL + "\t " + NL + "\t";
  protected final String TEXT_56 = NL + "\t\tconnection_";
  protected final String TEXT_57 = ".header(";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ");" + NL + "\t";
  protected final String TEXT_60 = NL + " */" + NL + "" + NL + "\t/*" + NL + "\t * Get document." + NL + "\t */" + NL + "\tgetTimestamp_";
  protected final String TEXT_61 = " = TalendDate.getCurrentDate();" + NL + "\tif(debug_";
  protected final String TEXT_62 = ") System.err.println(\"";
  protected final String TEXT_63 = ": DEBUG: getting document \" + ";
  protected final String TEXT_64 = ");" + NL + "\tdocument_";
  protected final String TEXT_65 = " = connection_";
  protected final String TEXT_66 = ".get();" + NL + "\thTTPStatusCode_";
  protected final String TEXT_67 = " = connection_";
  protected final String TEXT_68 = ".response().statusCode();" + NL + "\tif(debug_";
  protected final String TEXT_69 = ") System.err.println(\"";
  protected final String TEXT_70 = ": DEBUG: request returned \" + connection_";
  protected final String TEXT_71 = ".response().statusCode());" + NL + "\tgetTime_";
  protected final String TEXT_72 = " = TalendDate.getCurrentDate().getTime() - getTimestamp_";
  protected final String TEXT_73 = ".getTime();" + NL + "    " + NL + "} " + NL + "catch (java.lang.NullPointerException e_e_p){" + NL + "\tSystem.out.println(\"connection_or_document_Null_point_exception_1\");" + NL + "}" + NL + "catch (IllegalArgumentException e_";
  protected final String TEXT_74 = ") {" + NL + "\t//e_";
  protected final String TEXT_75 = ".printStackTrace();" + NL + "\tgetTime_";
  protected final String TEXT_76 = " = TalendDate.getCurrentDate().getTime() - getTimestamp_";
  protected final String TEXT_77 = ".getTime();" + NL + "\tparseStatus_";
  protected final String TEXT_78 = " = 1;" + NL + "\tparseErrorText_";
  protected final String TEXT_79 = " = e_";
  protected final String TEXT_80 = ".toString();" + NL + "}" + NL + "catch (IOException e_";
  protected final String TEXT_81 = ") {" + NL + "\t//e_";
  protected final String TEXT_82 = ".printStackTrace();" + NL + "\tgetTime_";
  protected final String TEXT_83 = " = TalendDate.getCurrentDate().getTime() - getTimestamp_";
  protected final String TEXT_84 = ".getTime();" + NL + "" + NL + "" + NL + "\t// TODO Could this thow an Exception" + NL + "\t// JSoup appears to throw an exception for HTTP Status Code 304. This does not appear to be the documented outcome." + NL + "\t// Getting the stus here, after an exception appears to yield 0. We'll scan for 304s." + NL + "\tif(e_";
  protected final String TEXT_85 = ".toString().contains(\"Status=304\")) hTTPStatusCode_";
  protected final String TEXT_86 = " = 304;" + NL + "\telse hTTPStatusCode_";
  protected final String TEXT_87 = " = connection_";
  protected final String TEXT_88 = ".response().statusCode();" + NL + "" + NL + "\tparseStatus_";
  protected final String TEXT_89 = " = 1;" + NL + "\tparseErrorText_";
  protected final String TEXT_90 = " = e_";
  protected final String TEXT_91 = ".toString();" + NL + "}" + NL + "catch (java.net.URISyntaxException e_";
  protected final String TEXT_92 = ") {" + NL + "\tSystem.out.println(";
  protected final String TEXT_93 = ");" + NL + "\t//e_";
  protected final String TEXT_94 = ".printStackTrace();" + NL + "\t//getTime_";
  protected final String TEXT_95 = " = TalendDate.getCurrentDate().getTime() - getTimestamp_";
  protected final String TEXT_96 = ".getTime();" + NL + "\t//parseStatus_";
  protected final String TEXT_97 = " = 1;" + NL + "\t//parseErrorText_";
  protected final String TEXT_98 = " = e_";
  protected final String TEXT_99 = ".toString();" + NL + "}" + NL + "" + NL + "//System.out.println(\"PASSED-2\");\t" + NL + "String temp_";
  protected final String TEXT_100 = " = null;" + NL + "/*" + NL + " * Write data." + NL + " */" + NL + "" + NL + "org.jsoup.select.Elements elements_";
  protected final String TEXT_101 = " =null;";
  protected final String TEXT_102 = NL + "\telements_";
  protected final String TEXT_103 = " =document_";
  protected final String TEXT_104 = ".body().children().select(";
  protected final String TEXT_105 = ");" + NL + "\t//System.out.println(\"metadatas\"+elements_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\telements_";
  protected final String TEXT_108 = "=document_";
  protected final String TEXT_109 = ".select(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + NL + NL + "for (org.jsoup.nodes.Element element_";
  protected final String TEXT_112 = " : elements_";
  protected final String TEXT_113 = ") " + NL + "{ " + NL + " try{";
  protected final String TEXT_114 = NL + "\t";
  protected final String TEXT_115 = NL + "\t\t";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " =element_";
  protected final String TEXT_118 = ".select(";
  protected final String TEXT_119 = ");" + NL + "\t\t";
  protected final String TEXT_120 = " \t\t//";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " =parseErrorText_";
  protected final String TEXT_123 = ";" + NL;
  protected final String TEXT_124 = " \t\t";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " =element_";
  protected final String TEXT_127 = ".select(";
  protected final String TEXT_128 = ").hasText()?element_";
  protected final String TEXT_129 = ".select(";
  protected final String TEXT_130 = ").text():element_";
  protected final String TEXT_131 = ".text();";
  protected final String TEXT_132 = NL + "\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = element_";
  protected final String TEXT_135 = ".select(";
  protected final String TEXT_136 = ").text();";
  protected final String TEXT_137 = NL + "\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = element_";
  protected final String TEXT_140 = ".select(";
  protected final String TEXT_141 = ").text();";
  protected final String TEXT_142 = NL + "\t\t\t";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = element_";
  protected final String TEXT_145 = ".select(";
  protected final String TEXT_146 = ").text();";
  protected final String TEXT_147 = NL + "\t\t\t";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = element_";
  protected final String TEXT_150 = ".select(";
  protected final String TEXT_151 = ").text();";
  protected final String TEXT_152 = "\t\t\t" + NL + "\t\t\t/*" + NL + "\t\t\t* Data mapping." + NL + "\t\t\t*/" + NL + "" + NL + "\t\t\t" + NL + "" + NL + "\t";
  protected final String TEXT_153 = NL + "\t} catch (Exception e_";
  protected final String TEXT_154 = ") " + NL + "\t{                   " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_155 = "_PARSE_ERROR\", e_";
  protected final String TEXT_156 = ".getMessage());  " + NL + "\t\tparseErrorText_";
  protected final String TEXT_157 = " = e_";
  protected final String TEXT_158 = ".toString();" + NL + "\t    e_";
  protected final String TEXT_159 = ".printStackTrace();" + NL + "\t} ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	String uRL = ElementParameterParser.getValue(node, "__URL__");
	String userAgent = ElementParameterParser.getValue(node, "__USER_AGENT__");
	String maxBodySize = ElementParameterParser.getValue(node, "__MAX_BODY_SIZE__");
	String parentElement = ElementParameterParser.getValue(node, "__PARENT_ELE__");
	List<Map<String, String>> headerParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	String maxReTries = ElementParameterParser.getValue(node, "__RETRY_TIMES__");

	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();

	int metadatasSize = 0;

	if(metadatas != null && metadatas.size() > 0) {
		metadatasSize = metadatas.size();
		IMetadataTable metadata = metadatas.get(0);

		if(metadata != null) {
			columnList = metadata.getListColumns();
		}
	}

	List< ? extends IConnection> documentOutC = node.getOutgoingSortedConnections();

	int documentOutCSize = 0;

	if(documentOutC != null && documentOutC.size() > 0) {
                documentOutCSize = documentOutC.size();
        }   

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
if(node.getElementParameter("FOLLOW_REDIRECTS").isContextMode()) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FOLLOW_REDIRECTS__") );
    stringBuffer.append(TEXT_7);
    
}
else {
	if("true".equals(ElementParameterParser.getValue(node, "__FOLLOW_REDIRECTS__"))) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	}
}

    stringBuffer.append(TEXT_10);
    
if(node.getElementParameter("DEBUG").isContextMode()) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DEBUG__") );
    stringBuffer.append(TEXT_13);
    
}
else {
	if("true".equals(ElementParameterParser.getValue(node, "__DEBUG__"))) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
	}
}

    stringBuffer.append(TEXT_16);
    
if(node.getElementParameter("DIE").isContextMode()) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIE__") );
    stringBuffer.append(TEXT_19);
    
}
else {
	if("true".equals(ElementParameterParser.getValue(node, "__DIE__"))) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
	}
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(maxReTries );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(uRL );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(uRL );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(uRL );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(timeout );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(userAgent );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(userAgent );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(userAgent );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(userAgent );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
	if(! "0".equals(maxBodySize)) {
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(maxBodySize );
    stringBuffer.append(TEXT_54);
    
	}
	
    stringBuffer.append(TEXT_55);
    for (Map<String, String> header : headerParams){ // set request properties
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(header.get("HEADER_NAME"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(header.get("HEADER_VALUE"));
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(uRL );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(uRL );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
if ("\"*\"".equalsIgnoreCase(parentElement))
{

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(parentElement );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    }
else 
{

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(parentElement );
    stringBuffer.append(TEXT_110);
    }

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
	if(documentOutC != null && documentOutC.size() > 0) 
	{

    stringBuffer.append(TEXT_114);
    
		for(IConnection documentOut : documentOutC) 
		{
       		if(documentOut.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) 
			{
				for (int valueN=0; valueN < columnList.size(); valueN++) 
				{//FIM_001
				    Map<String, String> header=headerParams.get(valueN);
					IMetadataColumn column = columnList.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					//String selectorstring =header.get(column.getLabel());
					
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT)
					{
						//if(valueN + 1 == columnList.size())
						if(javaType == JavaTypesManager.OBJECT)
						{

    stringBuffer.append(TEXT_115);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_119);
                                 
						}
						else 
						{
						   if(column.getLabel().equalsIgnoreCase("parseErrorText"))
						    {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    						
							}
							else 
							{

    stringBuffer.append(TEXT_124);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    							
							}
						}
					}
					else
					{ //FIM_006
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) 
							{

    stringBuffer.append(TEXT_132);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_136);
    							
							}
							else if(javaType == JavaTypesManager.BYTE_ARRAY)
							{ 

    stringBuffer.append(TEXT_137);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_141);
    
							}else if(javaType == JavaTypesManager.DATE) 
							{ 
								

    stringBuffer.append(TEXT_142);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_146);
    
								
							} 
							else 
							{

    stringBuffer.append(TEXT_147);
    stringBuffer.append(documentOut.getName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(header.get("QUERY"));
    stringBuffer.append(TEXT_151);
    
							}
					} //FIM_006
				}//FIM_001

    stringBuffer.append(TEXT_152);
    
		}
	}
	
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
}


    return stringBuffer.toString();
  }
}
