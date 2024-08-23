<%-- 
    Document   : register
    Created on : Aug 21, 2024, 9:32:44 AM
    Author     : Thuy Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/Register" var="action"></c:url>
    <h1>Đăng ký</h1>
<f:form action="${action}" method="post">
    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Tên đăng nhập</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Mật khẩu</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>
    <div class="mb-3">
        <label for="firstname" class="form-label">Họ</label>
        <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname">
    </div>
    <div class="mb-3">
        <label for="lastname" class="form-label">Tên</label>
        <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Số điện thoại</label>
        <input type="number" max="10" class="form-control" id="phone" placeholder="Enter phone" name="phone">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="text"class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Bạn là</label>
        <f:select  class="form-select" path="role" id="role" name="role">
                        <option value="ROLE_STUDENT" selected>Sinh viên</option>
                        <option value="ROLE_LECTURER">Giảng viên</option>
        </f:select>
    </div>
</div>
<button type="submit" class="btn btn-primary">Đăng ký</button>
</f:form>
