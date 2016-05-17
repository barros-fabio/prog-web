<%-- 
    Document   : index.jsp
    Created on : May 17, 2016, 2:53:51 PM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Verifying User Data</TITLE>
        <SCRIPT LANGUAGE="JavaScript">
            <!--
            function checker()
            {
                
                var regExp2 = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/
               
                var result2 = document.form1.text1.value.match(regExp2)
                if (result2 == null) {
                    alert("Sorry, that's not a valid date.")
                    document.form1.text1.value = ""
                    return false
                } else {
                    document.form1.submit()
                }
            }
            //-->
        </SCRIPT>
    </HEAD>
 
    <BODY>
        <H1>Verifying User Data</H1>
        <FORM NAME="form1" ACTION="basic.jsp" METHOD="POST" ONSUBMIT="return checker()">
            Please enter a date:
            <INPUT TYPE="TEXT" NAME="text1">
            <INPUT TYPE="SUBMIT" value="Submit">
        </FORM>
    </BODY>
<HTML>
