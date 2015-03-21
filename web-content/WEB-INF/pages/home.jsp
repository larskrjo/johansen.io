<%@include file="lib/lib.jsp" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <script data-main="/resources/js/Bootstrap" src="/resources/js/libs/require.js"></script>
    </head>
    <body id="body" class="body-alert">
    <c:if test="${not empty fn:escapeXml(hasError)}">
        <div id="hasError" style="display: none">
            <div id="statusCode">${fn:escapeXml(statusCode)}</div>
            <div id="errorCode">${fn:escapeXml(errorCode)}</div>
            <div id="errorMessage">${fn:escapeXml(errorMessage)}</div>
        </div>
    </c:if>
    </body>
</html>