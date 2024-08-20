<%-- 
    Document   : user
    Created on : Aug 13, 2024, 12:49:27 AM
    Author     : Thuy Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mt-5 mb-5">
<table class="table table-striped">
    <tr>
        <th></th>
        <th>Mã người dùng</th>
        <th>Tên người dùng</th>
        <th>Họ tên</th>
        <th>Vai trò</th>
        <th></th>
        <th></th>
        
    </tr>
    <c:forEach items="${user}" var="u">
    
        <tr>
            <th><img src="${u.avatar}" alt="avatar" style="width:100px; border-radius: 50%"/></th>
            <th>${u.id}</th>
            <th>${u.username}</th>
            <th>${u.firstname} ${u.lastname}</th>
            <th>${u.role}</th>
            <td><c:url value="/Post/${p.id}" var="post" /><a href="${post}" class="btn btn-success">&orarr;</a></td>
            <td><c:url value="/api/Users/${u.id}" var="us" />
                    <button onclick="deleteUser('${us}', ${u.id})" class="btn btn-danger">&times;</button></td>
        </tr>
    </c:forEach>
  </table>
</div>
