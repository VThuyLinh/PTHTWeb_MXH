<%-- 
    Document   : UserDetail
    Created on : Aug 24, 2024, 1:12:48 PM
    Author     : Thuy Linh
--%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:url value="/User" var="action"></c:url>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<f:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">

    <div class="mb-3 mt-3">
        <label for="firstname" class="form-label">Họ </label>
        <f:input class="form-control" path="firstname" id="firstname" name="firstname" value="${user.firstname}"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="lastname" class="form-label"> Tên</label>
        <f:input class="form-control" path="lastname" id="lastname" name="lastname" value="${user.lastname}"/>
    </div>
    <div class="mb-3">
        <label for="username" class="form-label">Tên người dùng</label>
        <f:input path="username" type="text" class="form-control" id="username" value="${post.username}" name="username" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email </label>
        <f:input class="form-control" path="email" id="email" name="email" value="${user.email}"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="phone" class="form-label">Phone </label>
        <f:input class="form-control" path="phone" id="phone" name="phone" value="${user.phone}"/>
    </div>

    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh đại diện</label>
        <f:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        <c:if test="${user.avatar != null}">
            <img class="mt-1" src="${user.avatar}" alt="${user.avatar}" width="120" />
        </c:if>

    </div>

    <div class="mb-3 mt-3">
        <label for="files" class="form-label">Ảnh bìa</label>
        <f:input path="files" type="file" accept=".jpg,.png" class="form-control" id="files" name="files" />
        <c:if test="${user.cover != null}">
            <img class="mt-1" src="${user.cover}" alt="${user.cover}" width="120" />
        </c:if>

    </div>


    <c:choose>
        <c:when test="${user.role=='ROLE_STUDENT'}">
            <div class="mb-3 mt-3" >
                <label for="studentId" class="form-label">MSSV</label>
                <f:input class="form-control" path="studentId" id="studentId" name="studentId" maxlength="10" value="${user.studentId}"/>
            </div>
             <f:hidden path="degree" />
        </c:when>    
        <c:otherwise>
            <div class="mb-3 mt-3" >
                <label for="degree" class="form-label">Degree</label>
                <f:input class="form-control" path="degree" id="degree" name="degree" maxlength="10" value="${user.degree}"/>
            </div> 
            <f:hidden path="MSSV" />
        </c:otherwise>
    </c:choose>




    








        <div class="mb-3">
        <label for="createdDate" class="form-label">Ngày sửa lại hồ sơ</label>
        <f:input path="createdDate" type="date" class="form-control" id="createdDate" placeholder="${post.createdDate}" name="createdDate" />
    </div>


    <f:hidden path="id" />



    <f:hidden path="avatar" />
    <f:hidden path="cover" />
    <f:hidden path="role" />
    <f:hidden path="password" />
    
    <div class="form-check">
        <f:radiobutton class="form-check-input" id="active" name="active" path="active" value="true" checked="checked" />
        <label style="font-size:50px" class="form-check-label" for="active">&#128275;</label>
    </div>
    <div class="form-check">
        <f:radiobutton class="form-check-input" id="active" name="active" path="active" value="false"/>
        <label style="font-size:50px" class="form-check-label" for="active">&#128274;</label>
    </div>




    <button type="submit" class="btn btn-primary">C?p nh?t</button>

</f:form>





