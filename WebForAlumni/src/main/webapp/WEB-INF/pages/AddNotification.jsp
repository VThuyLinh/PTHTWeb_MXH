<%-- 
    Document   : AddPost
    Created on : Aug 22, 2024, 3:08:57 PM
    Author     : Thuy Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>


<c:url value="/AddNotification" var="action"></c:url>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<f:form action="${action}" method="post" enctype="multipart/form-data"  modelAttribute="addNotification">
    <h1>${ex}</h1>
   
    <div class="mb-3">
        <label for="content" class="form-label">Nội dung</label>
        <f:input path="content" onblur="getDate()" type="text" class="form-control" id="content" placeholder="${post.content}" name="content" />
    </div>
    
    <div class="mb-3">
        <label for="day" class="form-label">Ngày</label>
        <f:input path="day" type="date" class="form-control" id="day" name="day" />
    </div>
    <div class="mb-3">
        <label for="time" class="form-label">Giờ</label>
        <f:input path="time" type="time" class="form-control" id="time" name="time" />
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Địa chỉ</label>
        <f:input path="address" type="text" class="form-control" id="address" name="address" />
    </div>
    <div class="mb-3" hidden="true">
        <label for="image" class="form-label">Ảnh</label>
        <f:input path="image" type="text" class="form-control" id="image" name="image" />
    </div>

     <div class="mb-3">
        <label for="createdDate" class="form-label">Ngày tạo</label>
        <f:input path="createdDate" type="date" class="form-control" id="createdDate" name="createdDate" />
    </div>
       <f:hidden path="userId" id="userId" name="userId" value='1' />
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh</label>
        <f:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />

    </div>
        
    <button type="submit" class="btn btn-primary">Thêm bài</button>
</f:form>
