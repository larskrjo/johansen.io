<%@include file="lib/lib.jsp" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Lars K. Johansen</title>

  <link href="/resources/css/bootstrap.css" rel="stylesheet">
  <link href="/resources/css/bootstrap-theme.css" rel="stylesheet">
  <link href="/resources/css/bootstrap-social.css" rel="stylesheet">
  <link href="/resources/css/animate.css" rel="stylesheet">
  <link href="/resources/css/larskristian.css" rel="stylesheet">
  <link rel="icon" href="data:;base64,iVBORw0KGgo=">
  <script src="/resources/js/libs/spin.js"></script>
</head>
<body>

<div id="loading">
</div>
<script src="/resources/js/helper/InitSpinner.js"></script>

<div class="body-color">
  <header id="header">
  </header>

  <main id="body">
  </main>

  <footer id="footer">
  </footer>
</div>

<div id="error" style="display: none">
  <div id="error-status-code">${fn:escapeXml(errorStatusCode)}</div>
  <div id="error-code">${fn:escapeXml(errorCode)}</div>
  <div id="error-message">${fn:escapeXml(errorMessage)}</div>
</div>
<div id="locale" style="display: none">${fn:escapeXml(locale)}</div>

<script data-main="/resources/js/Bootstrap" src="/resources/js/libs/require.js"></script>
</body>
</html>