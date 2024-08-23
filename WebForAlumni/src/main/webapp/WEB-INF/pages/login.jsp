<%-- 
    Document   : login
    Created on : Aug 16, 2024, 11:07:41 PM
    Author     : Thuy Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action"></c:url>

<c:if test="${param.error!=null}">
<div class="alert alert-danger">
    Đã có lỗi xảy ra vui lòng thử lại 
</div>
</c:if>
<h1 style="color:blue" class="text-center">ĐĂNG NHẬP</h1>
<form action="${action}" method="post">
    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Username:</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    
        <c:if test="${params.usernamewrong!=null}" >
            <div class="alert alert-danger">Không có username này, đăng ký hoặc kiểm tra lại thông tin</div>
        </c:if>
    
    <div class="mb-3">
        <label for="password" class="form-label">Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
        <c:if test="${params.passwordwrong!=null}" >
            <div class="alert alert-danger">Vui long kiểm tra lại mật khẩu</div>
        </c:if>
    <input type="submit" value="Đăng nhập" class="btn-primary"/>
</form>
