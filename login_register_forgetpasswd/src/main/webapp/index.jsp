<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Redirecting...</title>
    <script type="text/javascript">
        window.location.href = "<%= request.getContextPath() %>/login";
    </script>
</head>
<body>
    Redirecting to login...
</body>
</html>
