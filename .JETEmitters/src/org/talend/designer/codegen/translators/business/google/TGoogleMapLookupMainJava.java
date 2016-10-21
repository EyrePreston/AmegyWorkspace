package org.talend.designer.codegen.translators.business.google;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class TGoogleMapLookupMainJava
{
  protected static String nl;
  public static synchronized TGoogleMapLookupMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleMapLookupMainJava result = new TGoogleMapLookupMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "" + NL + "" + NL + "" + NL + "String saddress_id  = ";
  protected final String TEXT_3 = ".address_id;" + NL + "String saddress  = ";
  protected final String TEXT_4 = ".address;" + NL + "String APIKey = ";
  protected final String TEXT_5 = ";" + NL + "String url = \"\";" + NL + "" + NL + "if (APIKey!=null&&!APIKey.equals(\"\")) {" + NL + "\turl =\"https://maps.google.com/maps/api/geocode/xml?address=\"+URLEncoder.encode(saddress , \"UTF-8\")+\"&sensor=false&key=\"+APIKey;" + NL + "} else {" + NL + "\turl =\"http://maps.google.com/maps/api/geocode/xml?address=\"+URLEncoder.encode(saddress , \"UTF-8\")+\"&sensor=false\";" + NL + "}" + NL + "/*String slat=\"\";*/" + NL + "" + NL + "/*String slng=\"\";*/" + NL + "" + NL + "" + NL + "// Send GET request" + NL + "URL client = new URL(url);" + NL + "URLConnection conn = client.openConnection();" + NL + "Thread.sleep((";
  protected final String TEXT_6 = ")*100);" + NL + "InputStream responseBody = conn.getInputStream();" + NL + " " + NL + "// XML Bufferization" + NL + "Document response = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(responseBody);" + NL + "responseBody.close();" + NL + " " + NL + "" + NL + "// Xpath expressions" + NL + "XPath xPath = XPathFactory.newInstance().newXPath();" + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = ".status=xPath.evaluate(\"/GeocodeResponse/status\", response);" + NL + "" + NL + "" + NL + "" + NL + "if(!(";
  protected final String TEXT_9 = ".status.equals(\"ZERO_RESULTS\"))&&(!";
  protected final String TEXT_10 = ".status.equals(\"OVER_QUERY_LIMIT\")))" + NL + "{";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = ".formatted_address=xPath.evaluate(\"/GeocodeResponse/result[1]/formatted_address\", response);";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = ".subpremise_short=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='subpremise']/short_name\", response);";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = ".street_number = xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='street_number']/short_name\", response);" + NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = ".route_short =xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='route']/short_name\", response);";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = ".route_long =xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='route']/long_name\", response);" + NL;
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = ".locality_short=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='locality']/short_name\", response);" + NL;
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = ".adm_area1_short=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='administrative_area_level_1']/short_name\", response);";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = ".adm_area1_long=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='administrative_area_level_1']/long_name\", response);" + NL;
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = ".adm_area2_short=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='administrative_area_level_2']/short_name\", response);" + NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = ".country_short=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='country']/short_name\", response);";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = ".country_long=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='country']/long_name\", response);" + NL;
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = ".postal_code=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='postal_code']/short_name\", response);";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = ".postal_code_suffix=xPath.evaluate(\"/GeocodeResponse/result[1]/address_component[type/text()='postal_code_suffix']/short_name\", response);" + NL;
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = ".location_type=xPath.evaluate(\"/GeocodeResponse/result[1]/geometry/location_type\", response);" + NL;
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = ".partial_match=xPath.evaluate(\"/GeocodeResponse/result[1]/partial_match\", response);" + NL;
  protected final String TEXT_41 = NL + " ";
  protected final String TEXT_42 = ".lat=Double.parseDouble(\"\" + xPath.evaluate(\"/GeocodeResponse/result[1]/geometry/location/lat\", response));";
  protected final String TEXT_43 = NL + " ";
  protected final String TEXT_44 = ".lng=Double.parseDouble(\"\" + xPath.evaluate(\"/GeocodeResponse/result[1]/geometry/location/lng\", response));" + NL + "" + NL + "}" + NL;
  protected final String TEXT_45 = NL + "\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String inConnName = null;
String outConnName = null;
String method = ElementParameterParser.getValue(node, "__METHODNAME__");

List<? extends IConnection> inConns = node.getIncomingConnections();
List<? extends IConnection> outConns = node.getOutgoingConnections();
IConnection inConn = null;
IConnection outConn = null;
if(inConns != null && inConns.size() > 0) {
    inConn = inConns.get(0);
    inConnName = inConn.getName();
}
if(outConns != null && outConns.size() > 0) {
    outConn = outConns.get(0);
    outConnName = outConn.getName();
}

List<IMetadataColumn> columnList = inConn.getMetadataTable().getListColumns();
String pause = ElementParameterParser.getValue(node, "__PAUSE__");
String APIKEY = ElementParameterParser.getValue(node,"__APIKey__");
if(inConnName != null && columnList != null && (columnList.size() > 0) ) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(APIKEY);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(pause);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_44);
      
if (outConnName!=null)  
{
for(IMetadataColumn metadataColumn : columnList) 
{    	

    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_49);
    
} 
}
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
