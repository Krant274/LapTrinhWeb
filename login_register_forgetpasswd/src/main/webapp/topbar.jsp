<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .header-container {
            width: 100%;
            background-color: #f8f9fa;
            padding: 10px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: flex-end;
        }
        .header-buttons {
            display: inline-flex;
            align-items: center;
        }
        .header-buttons button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-left: 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .header-buttons button:hover {
            background-color: #0056b3;
        }
        .header-buttons .logout-button {
            background-color: #dc3545;
        }
        .header-buttons .logout-button:hover {
            background-color: #c82333;
        }
        .header-buttons i {
            margin-left: 10px;
            cursor: pointer;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div class="header-container">
        <c:choose>
            <c:when test="${sessionScope.account == null}">
                <div class="header-buttons">
                    <button onclick="window.location.href='${pageContext.request.contextPath }/login'">Đăng nhập</button>
                    <button onclick="window.location.href='${pageContext.request.contextPath }/register'">Đăng ký</button>
                    <i class="search fa fa-search"></i>
                </div>
            </c:when>
            <c:otherwise>
                <div class="header-buttons">
                    <button class="logout-button" onclick="window.location.href='${pageContext.request.contextPath }/logout'">
                        Đăng Xuất
                    </button>
                    <i class="search fa fa-search"></i>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
