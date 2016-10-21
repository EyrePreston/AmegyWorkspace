package routines;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class TACustom {
	
    /**
     * Cleans a string from double spaces and return characters
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} string("world") string
     * 
     * {example} cleanString(" hello   world!  ") # hello world!
     */
    public static String cleanString(String string) {
    	if (string == null) {
    		return null;
    	} else {
    		string = string.replaceAll("[\r\n]"," ");
    		string = string.replaceAll("\\b(?i)(null)+\\b","");
    		return string.replaceAll("[ ]+"," ").trim();
    	}
    }
    
    /**
     * Uses cleanString then returns null if string is empty or is single space
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} string("world") string
     * 
     * {example} emptyString(" ") # null
     */
    public static String emptyString(String string) {
    	string = cleanString(string);
    	if (string == null) {
    		return null;
    	}
    	else if (string.equals("") || string.equals(" ")) {
    		return null;
    	} else {
    		return string;
    	}
    }
    
    /**
     * Uses the second value if the first value is null
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} string(check) string
     * 
     * {param} string(elseUse) string
     * 
     * {example} coalesce(null,"Empty") # Empty
     */
    public static String coalesce(String check, String elseUse) {
    	return check != null ? check : elseUse;
    }
    
    /**
     * Uses the second value if the first value is null
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} Integer(check) Integer
     * 
     * {param} Integer(elseUse) Integer
     * 
     * {example} coalesce(context.Variable,0) # 0
     */
    public static Integer coalesce(Integer check, Integer elseUse) {
    	return check != null ? check : elseUse;
    }
    
    /**
     * Concats strings using separator between words, leaving empty strings as a blank value instead of changing it to "null"
     * 
     * {talendTypes} String
     * 
     * {Category} TAGeneral
     * 
     * {param} string("separate") separator: string used as a separator between words
     * 
     * {param} string("world") s: list of strings to be concatenated
     * 
     * {example} concatStringsSeparator(":","Thomas",null,"Arts") # Thomas:Arts
     */
    public static String concatStringsSeparator(String separator,String... s) {
    	if (s!=null) {
    		StringBuilder sb = new StringBuilder();
    		for (int i=0; i<s.length; i++) {
    			String sClean = emptyString(s[i]);
    			sb.append(sClean == null ? "" : sClean + separator);
    		}
    		String cleanString = sb.toString();
    		return cleanString.trim();
    	} else {
    		return "";
    	}
    }
    
    /**
     * Uses concatStrings, using a space as the default separator
     * {talendTypes} String
     * 
     * {Category} TAGeneral
     * 
     * {param} string("world") s: list of strings to be concatenated together
     * 
     * {example} concatStrings("Thomas",null,"Arts") # Thomas Arts
     */
    public static String concatStrings(String... s) {
    	return concatStringsSeparator(" ",s);
    }
    
    /**
     * Uses TalendDate.parseDate but checks for null values and cleans up double spaces first
     * If date is Jan 1 1900, returns null
     * 		y: year
     * 		M: month
     * 		d: day
     * 		h: hour (1-12)
     * 		H: hour (1-24)
     * 		m: minutes
     * 		s: seconds
     * 		a: AM/PM
     * 		z: timezone 
     * 
     * {talendTypes} Date
     * 
     * {Category} TACleanup
     * 
     * {param} string("yyyy-MM-dd hh:mm:ss a") pattern : the pattern to parse
     * 
     * {param} string("") stringDate : A <code>String</code> whose beginning should be parsed 
     */
    public static Date parseDate(String pattern, String stringDate) {
    	stringDate = emptyString(stringDate);
    	if (stringDate == null || pattern == null) {
    			return null;
    	} else {
    		Date returnDate = TalendDate.parseDate("yyyyMMdd","19000101");
    		try {
    			returnDate = TalendDate.parseDate(pattern, stringDate);
    		} catch (Exception e) {
    			returnDate = TalendDate.parseDate("yyyyMMdd","19000101");
    		} finally {
    			if (TalendDate.compareDate(TalendDate.parseDate("yyyyMMdd","19000101"),returnDate,"yyyyMMdd") >= 0) {
    				returnDate = null;
    			}
    		}
    		return returnDate;
    	}
    }
    
    /**
     * Adds number of day, month ... to a date (with Date given in String with a pattern)
     * 
     * {talendTypes} Date
     * 
     * {Category} TACleanup
     * 
     * {param} string(myDate) string : the date to update
     * 
     * {param} string(pattern) pattern : the pattern
     * 
     * {param} int(addValue) nb : the added value
     * 
     * {param} string("MM") dateType : the part to add
     * 
     * {examples}
     * 
     * ->> addDate("2008/11/24 12:15:25", "yyyy-MM-dd HH:mm:ss", 5,"dd") return "2008/11/29 12:15:25"
     * 
     * ->> addDate("2008/11/24 12:15:25", "yyyy/MM/DD HH:MM:SS", 5,"ss") return "2008/11/24 12:15:30" #
     * 
     */
    public static Date addDate(String string, String pattern, int nb, String dateType) {
        if (string == null || dateType == null) {
            return null;
        }
        java.util.Date date = null;

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
        try {
            date = sdf.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(pattern + " can't support the date!"); //$NON-NLS-1$
        }

        return TalendDate.addDate(date, nb, dateType);
    }
    
    /**
     * Uses TalendDate.formatDate but returns null value if date can't be formatted
     * 		y: year
     * 		M: month
     * 		d: day
     * 		h: hour (1-12)
     * 		H: hour (1-24)
     * 		m: minutes
     * 		s: seconds
     * 		a: AM/PM
     * 		z: timezone 
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} string("yyyy-MM-dd hh:mm:ss a") pattern : the pattern to parse
     * 
     * {param} Date() dateValue : a Java date value to be formatted 
     */
    public static String formatDate(String pattern, Date dateValue) {
    	String returnString = "";
    	try {
    		returnString = TalendDate.formatDate(pattern, dateValue);
    	} catch (Exception e) {
    		returnString = "";
    	}
    	if (returnString.equals("")) {
    		return null;
    	} else {
    		return returnString;
    	}
    }
    
    /**
     * Cleans string, removes common characters in number string (% or $), divides by 100 to turn it into a true percentage and converts it to a Float value
     *  
     * {talendTypes} Float
     * 
     * {Category} TACleanup
     * 
     * {param} string("30.25%") string
     * 
     * {example} percentageFloat("30.25%") # 0.3025
     */
    public static String excelNumberToString(String string) {
    	string = emptyString(string);
    	if (string == null) {
    		return null;
    	} else {
    		try {
    			return (string.replaceAll("[,]|[\\$]|[%]",""));
    		} catch (Exception e) {
    			return null;
    		}
    	} 
    }
    
    /**
     * Removes currency string characters ($) and converts value to float
     * 
     * {talendTypes} Float
     * 
     * {Category} TACleanup
     * 
     * {param} string("$1,352.25") string
     * 
     * {example} currencyFloat("$1,352.25") # 1352.25
     */
    public static Float currencyFloat(String string) {
    	string = emptyString(string);
    	if (string == null) {
    		return 0.00f;
    	} else {
    		try {
    			return Float.parseFloat(string.replaceAll("[,]|[\\$]",""));
    		} catch (Exception e) {
    			return 0.00f;
    		}
    	} 
    }
    
    /**
     * Cleans string, removes common characters in number string (% or $), divides by 100 to turn it into a true percentage and converts it to a Float value
     *  
     * {talendTypes} Float
     * 
     * {Category} TACleanup
     * 
     * {param} string("30.25%") string
     * 
     * {example} percentageFloat("30.25%") # 0.3025
     */
    public static Float percentageFloat(String string) {
    	string = emptyString(string);
    	if (string == null) {
    		return 0.00f;
    	} else {
    		try {
    			return (Float.parseFloat(string.replaceAll("[,]|[\\$]|[%]","")) / 100.00f);
    		} catch (Exception e) {
    			return 0.00f;
    		}
    	} 
    }
    
    /**
     * Removes spaces and commas and converts a string to an Integer
     * 
     * {talendTypes} Integer
     * 
     * {Category} TACleanup
     * 
     * {param} string("1,365.21") string
     * 
     * {example} numberInteger("1,365.21") # 1365
     */
    public static Integer parseInteger(String string) {
    	string = emptyString(string);
    	if (string == null) {
    		return null;
    	} else {
    		try {
    			return Integer.parseInt(string.replaceAll("[,]",""));
    		} catch (Exception e) {
    			return null;
    		}
    	}
    }
    
    /**
     * Formats a string into a desired phone format.  
     * 		Adding the prefix is optional
     * 			Example: prefix = "+1" number is +1 (111) 111-1111
     * 		The separator is what divides the 3 sections of a phone number
     * 			Entering "(" or ")" as separator put number into (111) 111-1111 format.  Otherwise value entered is used
     * 			Example: separator = "-"; number is 111-111-1111
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} String("-") separator: the value used between the sections of the number
     * 
     * {param} String("+1") prefix: placed at the beginning of the phone, can be used for international format
     * 
     * {param} String("801-555-1234") phone: the string phone number to be formatted
     * 
     * {example}
     */
    public static String phoneFormat(String separator,String prefix,String phone) {
    	phone = emptyString(phone);    	
    	if (phone == null || separator == null || prefix == null) {
    		return null;
    	} else {
    		phone = phone.replaceAll("[^0-9]", "");
    		
    		if ( phone.length() == 11 && phone.substring(0,1).equals("1")) {
    			phone = phone.substring(1);
    		} 
    		
    		if (phone.length() != 10) {
    			return null;
    		} else {
    			if (separator.contains("(") || separator.contains(")")){
    				return (prefix+" ("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6)).trim();
    			} else {
    				return ((prefix.equals("") ? "" : prefix+separator)+phone.substring(0,3)+separator+phone.substring(3,6)+separator+phone.substring(6)).trim();
    			}
    		}
    	}
    }
    
    /**
     * Formats a string into a desired phone format.
     * 		The separator is what divides the 3 sections of a phone number
     * 			Entering "(" or ")" as separator put number into (111) 111-1111 format.  Otherwise value entered is used
     * 			Example: separator = "-"; number is 111-111-1111
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} String("-") separator: the value used between the sections of the number
     * 
     * {param} String("801-555-1234") phone: the string phone number to be formatted
     * 
     * {example}
     */
    public static String phoneFormat(String separator,String phone) {
    	return phoneFormat(separator,"",phone);
    }
    
    /**
     * Formats a string into the desired zipcode format
     *		Valid formats include the integers 4 (plus 4 values), 5 (first 5 only), 9 (55555-4444)
     *
     * {talendTypes} String
     *
     * {Category} TACleanup
     *
     * {param} Integer(5) format: the format of the end result
     *
     * {param} String("84041-1234") zip: The zip code to be formatted
     *
     * {example}
     */
    public static String zipFormat(int format,String zip) {
    	zip = emptyString(zip);
    	if (zip == null) {
    		return null;
    	} else {
    		zip = zip.replaceAll(" ","");
    		if (zip.matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$")) {
    			return zip.trim();
    		} else {
    			String zip5 = "00000";
    			String zip4 = "0000";
    	    	
    			zip = zip.replaceAll("[^0-9-]", "");
    			if (zip.contains("-")) {
    				int i = zip.indexOf("-");
    				if (i<=2 || i>=6) {
    					return null;
    				} else {
	    				zip5 = zip.substring(0,i);
	    				zip4 = zip.substring(i+1);
	    				zip5 = ("00000"+zip5).substring(zip5.length());
	        			zip4 = zip4.length() < 4 ? "0000" : zip4.substring(zip4.length()-4);
    				}
    			} else {
    				int l = zip.length();
    				if (l <=2 || l >= 10) {
    					return null;
    				} else {
	    				if (l >= 7 && l <= 9) {
	    					zip5 = zip.substring(0,l-4);
	    					zip4 = zip.substring(l-4);
	    				} else {
	    					zip5 = l == 6 ? zip.substring(0,5) : zip;
	    					zip4 = "0000";
	    				}
	    				zip5 = ("00000"+zip5).substring(zip5.length());
    				}
    			}
				switch (format) {
				case 4:
					return zip4;
				case 5:
					return zip5;
				case 9:
					return zip5+"-"+zip4;
				default:
					return null;
				}
    		}
    	}
    }
    
    /**
     * Checks the provided email against an accepted pattern for valid e-mails.  If the given e-mail is not valid, it returns the error string
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} String("Invalid Email") errorReturn: the value that is returned if the e-mail proves to be invalid
     * 
     * {param} String("name@domain.com") email: the email to be checked against a regular expression
     * 
     * {example}
     */
    public static String validateEmail(String errorReturn, String email) {
    	email = emptyString(email);
    	if (email == null) {
    		return null;
    	} else {
        	if (email.matches("^[A-z0-9!#$%&''*+/=?^_`{|}~-]+(?:\\.[A-z0-9!#$%&''*+/=?^_`{|}~-]+)*@(?:[A-z0-9](?:[A-z0-9-]*[A-z0-9])?\\.)+[A-z0-9](?:[A-z0-9-]*[A-z0-9])$") == true) {
        		return email;
        	} else {
        		return errorReturn;
        	}	
    	}
    }
    
    /**
     * Checks the provided email against an accepted pattern for valid e-mails.  Returns null if the e-mail is invalid
     *      
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} String("name@domain.com") email: the email to be checked against a regular expression
     * 
     * {example}
     */
    public static String validateEmail(String email) {
    	return validateEmail(null,email);
    }
    
    /**
     * Strips an address of everything except the digits 0-9.  If the address starts as a PO Box, "PO" is placed in front of the digits
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} String("123 E Sample St") string: the address to be stripped
     * 
     * {example}
     */
    public static String addressDigits(String string) {
    	String address = emptyString(string);
    	if (address == null) {
    		return null;
    	} else {
    		address = address.replaceAll("[^0-9]","");
    		if (string.toUpperCase().matches("PO (.*)||P.O. (.*)||POBOX(.*)||P.O.BOX(.*)") == true ) {
    			address = "PO"+address;
    		}
    		return address;
    	}
    }
    
    /**
     * Strips a string of everything except the digits 0-9
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} String("g1s35sd5") string: the string to be be stripped
     * 
     * {example}
     */
    public static String digitsOnly(String string) {
    	string = emptyString(string);
    	return string == null ? null : string.replaceAll("[^0-9]","");
    }
    
    /**
     * Runs a name through a cleanup process to standardize and setup a front name
     * 
     * {talendTypes} String
     * 
     * {Category} TACleanup
     * 
     * {param} String("Joseph Sr.") string: the name to be cleaned and shortened
     * 
     * {param} String("Friend") defaultName: default name if the 
     * 
     * {example}
     */
    public static String frontName(String string, String defaultName) {
    	String returnString = emptyString(string);
    	if (returnString !=null) {
    		returnString = returnString.replaceAll("[`\";.]"," ").replaceAll("[(]","( ").replaceAll("[)]"," )").replaceAll("[&/+@]|( - )|( and )|( or )"," & ").trim();
    		returnString = returnString.replaceAll("((\\d+)(?:st|nd|rd|th))|([0-9])|(\\b((LtCol)|(LtGen)|(LTC)|(LTG)|(MajGen)|(MG)|(Gen)|(Maj)|(Lt)|(Col)|(Capt(ain)?)|(CPT)|(CDR)|(ADM)|(Officer)|(Ms)|(Mrs)|(Mr)|(D(octo)?r)|(J(unio)?r)|(S(enio)?r)|(Rev(erend)?)|(Father))\\b)"," ").trim();
    		returnString = returnString.replaceAll("[ ]+", " ").trim();
    		if (returnString.replaceAll("((?i)(?<=\\b[ART])([ ])(?=[J]\\b))|((?<=\\b[J])([ ])(?=[D]\\b))","").equals(returnString.replaceAll("[ ]+",""))) {
    			returnString = returnString.replaceAll("[ ]+","").trim();
    		}
    		returnString = returnString.replaceAll("(?i)(\\b)((AJ)|(RJ)|(TJ)|(JD)|(Ed)|(Ty)|(Jo)|(Al))(\\b)", "1$0").trim();
    		if (returnString.indexOf(")") - returnString.indexOf("(") - 1 > 2) {
    			returnString = returnString.substring(returnString.indexOf("("),returnString.indexOf(")")).trim();
    		}
    		if (returnString.indexOf("&")>1) {
    			returnString = returnString.substring(0,returnString.indexOf("&")).trim();
    		}
    		if (returnString.indexOf("(")>1) {
    			returnString = returnString.substring(0,returnString.indexOf("(")).trim();
    		}
    		returnString = returnString.replaceAll("(^([ -]+))|(([ -]+)$)","").trim();
    		returnString = returnString.replaceAll("\\b(?=\\w)[A-z]\\b(?!\\w)"," ").trim();
    		returnString = returnString.replaceAll("([^A-z1-])"," ").trim();
    		returnString = returnString.replaceAll("[ ]+"," ").trim();
    		if (returnString.indexOf(" ")>0) {
    			returnString = returnString.substring(0,returnString.indexOf(" ")).trim();
    		}
    		if (returnString.length() < 3) {
    			returnString = defaultName;
    		}
    		returnString = returnString.replaceAll("[1]","").trim();
    		if (checkEqualFirst(returnString,"Aj","Tj","Rj","Jd","aj","tj","rj","jd")) {
    				returnString = returnString.toUpperCase();
    		}
    		return returnString;
    	} else {
    		return defaultName;
    	}
    }
    
    /**
     * Cleans a name of prefixes, periods, and other punctuation in an attempt to standardize them.  The name is then shortened by the given integer
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} String("Joseph Sr.") string: the name to be cleaned and shortened
     * 
     * {param} Integer(3) len: the length of the final string to be returned
     * 
     * {example}
     */
    public static String cleanName(String string, Integer len) {
    	String name = cleanName(string);
    	if (name == null) {
    		return null;
    	} else {
	    	if (name.length() >= len) {
	    		return name.substring(0,len);
	    	} else {
	    		return name;
	    	}
    	}
    }
    
    /**
     * Cleans a name of prefixes, periods, and other punctuation in an attempt to standardize it.  Returns the full string
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} String("Joseph Sr.") string: the name to be cleaned
     * 
     * {example}
     */
    public static String cleanName(String string) {
    	String name = emptyString(string);
    	if (name == null) {
    		return null;
    	} else {
	    	name = name.replaceAll("((\\d+)(?:st|nd|rd|th))|([0-9])|(\\b((LtCol)|(LtGen)|(LTC)|(LTG)|(MajGen)|(MG)|(Gen)|(Maj)|(Lt)|(Col)|(Capt(ain)?)|(CPT)|(CDR)|(ADM)|(Officer)|(Ms)|(Mrs)|(Mr)|(D(octo)?r)|(MD)|(J(unio)?r)|(S(enio)?r)|(Rev(erend)?)|(Father))\\b)", "");
	    	name = name.replaceAll("[^A-z]","").trim();
	    	if(name.equals("")) {
	    		return null;
	    	} else {
	    		return name;
	    	}
    	}
    }
   
    /**
     * Cleans an address to be used in comparisons
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} String() removeComponents: Regex expression of components to be removed from the address
     * 
     * {param} ArrayList<String> replaceVariant: An array list of regex expressions of what to find in the provided strings
     * 
     * {param} ArrayList<String> replaceCorrected: An array list of values used when replacing those values in the replaceVariant list
     * 
     * {param} String() address: a list of strings that comprise the address being cleaned 
     * 
     * {example}
     */
    public static String cleanAddress(String removeComponents,ArrayList<String> replaceVariant, ArrayList<String> replaceCorrected, String... address) {
    	String combinedAddress = concatStrings(address).replaceAll("[^A-z0-9# ]","").toUpperCase();
    	
    	cleanArrayList(0,replaceVariant,replaceCorrected,combinedAddress);
    	
    	combinedAddress = combinedAddress.replaceAll(removeComponents,"");
    	
    	return combinedAddress.replaceAll("[ ]+"," ");
    }

    /**
     * Cleans a string using array lists of the strings to find and the value to be replaced with
     * Sets the default "type" to 0 and calls cleanArrayList(int,...)
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} ArrayList<String> replaceVariant: An array list of regex expressions of what to find in the provided strings
     * 
     * {param} ArrayList<String> replaceCorrected: An array list of values used when replacing those values in the replaceVariant list
     * 
     * {param} String() strings: a list of strings that comprise the address being cleaned 
     * 
     * {example}
     */
    public static String cleanArrayList(ArrayList<String> replaceVariant, ArrayList<String> replaceCorrected, String... strings) {
    	return cleanArrayList(0,replaceVariant,replaceCorrected,strings);
    }

    /**
     * Cleans a string using array lists of the strings to find and the value to be replaced with
     * Allows for a "type" which can run additional cleanup before comparing strings
     * 		0: no cleanup
     * 		1: remove all special characters except A-z, 0-9, and spaces
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} int(1) type: Indicates additional cleaning that needs to happen before running through array lists
     * 
     * {param} ArrayList<String> replaceVariant: An array list of regex expressions of what to find in the provided strings
     * 
     * {param} ArrayList<String> replaceCorrected: An array list of values used when replacing those values in the replaceVariant list
     * 
     * {param} String() strings: a list of strings that comprise the address being cleaned 
     * 
     * {example}
     */
    public static String cleanArrayList(int type, ArrayList<String> replaceVariant, ArrayList<String> replaceCorrected, String... strings) {
    	String combinedString = concatStrings(strings);
    	
    	if (type == 1) {
    		combinedString = combinedString.replaceAll("[^A-z0-9 ]","");
    	}
    	
    	for (int i=0; i<replaceVariant.size(); i++){
    		combinedString = combinedString.replaceAll(replaceVariant.get(i),replaceCorrected.get(i));
    	}
    	
    	return combinedString.replaceAll("[ ]+"," ");
    }
    
    /**
     * Converts a list of strings into a 32 character hash value
     * 		Uses concatStrings that cleans each separate string
     * 		Converts the string to upper case and removes all spaces prior to being hashed
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} string("value1","value2","value3") s: list of strings to be concatenated and then hashed
     * 
     * {example}
     */
    public static String createHashValue(String... s){
    	return createHashValue(0,s);
    }
    
    /**
     * Converts a list of strings into a 32 character hash value
     * 		Uses concatStrings that cleans each separate string
     * 		Converts the string to upper case and removes all spaces prior to being hashed
     * 
     * {talendTypes} String
     * 
     * {Category} TACompare
     * 
     * {param} int(1) hash: a 1 will return the concatenated string without being hashed
     * 
     * {param} string("value1","value2","value3") s: list of strings to be concatenated and then hashed
     * 
     * {example}
     */
    public static String createHashValue(int hash,String... s){
    	String returnString = concatStrings(s).toUpperCase().replaceAll("[ ]+","");
    	if (hash == 1) {
    		return returnString;
    	} else {
    		return MD5.getHashString(returnString);
    	}
    }
    
    /**
     * Checks a list of values against the first value, returning true if any match
     * 
     * {talendType} boolean
     * 
     * {Category} TACompare
     * 
     * {param} string("world") first: the string to check against all the others
     * 
     * {param} string("value1","valu2","value3") s: the list of strings to check against the first
     * 
     * {example} checkEqualFirst("123456","12345","12347","12348") # false 
     */
    public static boolean checkEqualFirst(String first,String... s){
		boolean Result = false;
		String s1 = emptyString(first);
		if (s!=null && first!=null) {
			int max = s.length;
			for (int i=0; i<max; i++) {
				String s2 = emptyString(s[i]);
				if (s1.equals(s2==null?"":s2)) {
					Result = true;
				}
			}
		}
		return Result;
	}
	
    /**
     * Checks a list of values against each other to determine if they all match
     * 
     * {talendType} boolean
     * 
     * {Category} TACompare
     * 
     * {param} string("value1","value2","value3") s: the list of strings to check against each other
     * 
     * {example} checkEqualAll("123456","123456","123456","12345") # false 
     */
	public static boolean checkEqualAll(String...s) {
		boolean Result = true;
		if (s!=null) {
			int max = s.length;
			for (int i=0; i<max; i++) {
				String s1 = emptyString(s[i]);
				for (int j=i+1; j<max; j++) {
					String s2 = emptyString(s[j]);
					if (!(s1==null?"":s1).equals(s2==null?"":s2)) {
						Result = false;
					}
				}
			}
		} else {
			Result = false;
		}
		return Result;
	}
    

    /**
     * Flips the case of the string; Upper case letters become lower case and lower case letters become upper case
     * 
     * {talendType} String
     * 
     * {Category} TAGeneral
     * 
     * {param} String("Flip this String") inputString
     * 
     * {example} toToggleCase("Flip this String") # fLIP THIS sTRING
     */
    public static String toToggleCase(String inputString) {
    	if (inputString!=null) {
	    	String result = "";
	        for (int i = 0; i < inputString.length(); i++) {
	            char currentChar = inputString.charAt(i);
	            if (Character.isUpperCase(currentChar)) {
	                char currentCharToLowerCase = Character.toLowerCase(currentChar);
	                result = result + currentCharToLowerCase;
	            } else {
	                char currentCharToUpperCase = Character.toUpperCase(currentChar);
	                result = result + currentCharToUpperCase;
	            }
	        }
	        return result;
    	} else {
        	return null;
        }
    }

    
    /**
     * Converts a string to camel or title case.  Every word in the string has the first letter capitalized
     * 
     * {talendType} String
     * 
     * {Category} TAGeneral
     * 
     * {param} String("capitalize this string") inputString
     * 
     * {example} toToggleCase("capitalize this string") # Capitalize This String
     */
    public static String toCamelCase(String inputString) {
        if (inputString!=null) {
	    	String result = "";
	        if (inputString.length() == 0) {
	            return result;
	        }
	        char firstChar = inputString.charAt(0);
	        char firstCharToUpperCase = Character.toUpperCase(firstChar);
	        result = result + firstCharToUpperCase;
	        for (int i = 1; i < inputString.length(); i++) {
	            char currentChar = inputString.charAt(i);
	            char previousChar = inputString.charAt(i - 1);
	            if (previousChar == ' ') {
	                char currentCharToUpperCase = Character.toUpperCase(currentChar);
	                result = result + currentCharToUpperCase;
	            } else {
	                char currentCharToLowerCase = Character.toLowerCase(currentChar);
	                result = result + currentCharToLowerCase;
	            }
	        }
	        return result;
        } else {
        	return null;
        }
    }
    

    /**
     * Converts a string to sentence case.  Only the first word or words after a ., ?, or ! are capitalized
     * 
     * {talendType} String
     * 
     * {Category} TAGeneral
     * 
     * {param} String("Capitalize This String") inputString
     * 
     * {example} toToggleCase("Capitalize This String") # Capitalize this string
     */
    public static String toSentenceCase(String inputString) {
    	 if (inputString!=null) {
    		String result = "";
	        if (inputString.length() == 0) {
	            return result;
	        }
	        char firstChar = inputString.charAt(0);
	        char firstCharToUpperCase = Character.toUpperCase(firstChar);
	        result = result + firstCharToUpperCase;
	        boolean terminalCharacterEncountered = false;
	        char[] terminalCharacters = {'.', '?', '!'};
	        for (int i = 1; i < inputString.length(); i++) {
	            char currentChar = inputString.charAt(i);
	            if (terminalCharacterEncountered) {
	                if (currentChar == ' ') {
	                    result = result + currentChar;
	                } else {
	                    char currentCharToUpperCase = Character.toUpperCase(currentChar);
	                    result = result + currentCharToUpperCase;
	                    terminalCharacterEncountered = false;
	                }
	            } else {
	                char currentCharToLowerCase = Character.toLowerCase(currentChar);
	                result = result + currentCharToLowerCase;
	            }
	            for (int j = 0; j < terminalCharacters.length; j++) {
	                if (currentChar == terminalCharacters[j]) {
	                    terminalCharacterEncountered = true;
	                    break;
	                }
	            }
	        }
	        return result;
	    } else {
	    	return null;
	    }
    }
    
    private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";

    private static final int splitLinesAt = 76;

    public static byte[] zeroPad(int length, byte[] bytes) {
    	byte[] padded = new byte[length]; // initialized to zero by JVM
    	System.arraycopy(bytes, 0, padded, 0, bytes.length);
    	return padded;
    }

    public static String base64encode(String string) {

    	String encoded = "";
    	byte[] stringArray;
    	try {
    		stringArray = string.getBytes("UTF-8");  // use appropriate encoding string!
    	} catch (Exception ignored) {
    		stringArray = string.getBytes();  // use locale default rather than croak
    	}
	    // determine how many padding bytes to add to the output
	    int paddingCount = (3 - (stringArray.length % 3)) % 3;
	    // add any necessary padding to the input
	    stringArray = zeroPad(stringArray.length + paddingCount, stringArray);
	    // process 3 bytes at a time, churning out 4 output bytes
	    // worry about CRLF insertions later
	    for (int i = 0; i < stringArray.length; i += 3) {
	        int j = ((stringArray[i] & 0xff) << 16) +
	            ((stringArray[i + 1] & 0xff) << 8) + 
	            (stringArray[i + 2] & 0xff);
	        encoded = encoded + base64code.charAt((j >> 18) & 0x3f) +
	            base64code.charAt((j >> 12) & 0x3f) +
	            base64code.charAt((j >> 6) & 0x3f) +
	            base64code.charAt(j & 0x3f);
	    }
	    // replace encoded padding nulls with "="
	    return (splitLines(encoded.substring(0, encoded.length() -
	        paddingCount) + "==".substring(0, paddingCount))).trim();
	
	}
	public static String splitLines(String string) {
	
	    String lines = "";
	    for (int i = 0; i < string.length(); i += splitLinesAt) {
	
	        lines += string.substring(i, Math.min(string.length(), i + splitLinesAt));
	        lines += "\r\n";
	
	    }
	    return lines;
	
	}
}