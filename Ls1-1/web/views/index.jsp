<%--
  Created by IntelliJ IDEA.
  User: Paltys
  Date: 12.03.2019
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Download</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div id="frame">
    <div id="header">
        <h1>Test Download/Load file</h1>
    </div>
    <div id="data">
        <div id="info">
            <p><h3>Download file ABC.pdf</h3></p>
            <p><h3>Download file ABC.zip</h3></p>

        </div>
        <div id="action">
            <form action="downloadServlet"   name="download">
                <p><input type="submit" id="download_pdf" name="download" value="Download_pdf"></p>
                <p><input type="submit" id="download_zip" name="download" value="Download_zip"></p>
            </form>

        </div>
        <div id="upload">
            <form action="loadServlet"  enctype="multipart/form-data" name="load">
                <h3>Load file on server</h3>
                <input type="file" name="Load">
                <input type="submit" id="uploadfile" name="uploadfile" value="Load">
            </form>
        </div>

    </div>
</div>
</body>
</html>
