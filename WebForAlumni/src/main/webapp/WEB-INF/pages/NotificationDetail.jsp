<%-- 
    Document   : NotificationDetail
    Created on : Aug 20, 2024, 11:55:20 PM
    Author     : Thuy Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/Notification" var="action" />
<f:form action="${action}" method="post" modelAttribute="noDetail">


    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh thông báo:</label>
        <f:input path="cover" type="file" accept=".jpg,.png" class="form-control" id="cover" name="cover" />
        <c:if test="${noDetail.cover != null}">
            <img class="mt-1" src="${noDetail.cover}" alt="${noDetail.cover}" width="120" />
        </c:if>
    </div>  
    <div class="mb-3 mt-3">
        <label for="content" class="form-label">Noi dung thong bao</label>
        <input type="text" class="form-control" id="content" value="${noDetail.content}" name="content">
    </div>
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">Dia diem</label>
        <input type="text" class="form-control" id="address" value="${noDetail.address}" name="address">
    </div>
    <div class="mb-3 mt-3">
        <label for="time" class="form-label">Thoi gian</label>
        <input type="text" class="form-control" id="time" value="${noDetail.time}" name="time">
    </div>

    <div class="mb-3 mt-3">
        <label for="time" class="form-label">Nguoi moi</label>
        <c:forEach items="${user}" var="u">
            <c:if test="${u.id==noDetail.userIdInvite.id}">
                <input type="text" class="form-control" id="time" value="${u.firstname} ${u.lastname} (${u.role})" name="time">
            </c:if>
        </c:forEach>
    </div>
   

    <div class="mb-3 mt-3">
        <f:hidden path="id" />
        <f:hidden path="cover" />
        <button class="btn btn-success" type="submit">



            <option value="${noDetail.id}" selected>Cập nhật sản phẩm</option>

    </div>


</f:form>

