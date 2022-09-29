<%-- 
    Document   : editnote
    Created on : 29-Sep-2022, 8:29:39 AM
    Author     : porte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form action="note" method="post">
            Title: <input type="text" name="title" value="test"><br />
            Content: <textarea name="contents" cols="20" rows="5"></textarea><br />
            
            <input type="submit" value="Save">
        </form>
    </body>
</html>
