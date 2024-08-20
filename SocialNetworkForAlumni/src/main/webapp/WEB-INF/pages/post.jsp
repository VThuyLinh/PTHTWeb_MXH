<%-- 
    Document   : post
    Created on : Aug 14, 2024, 10:53:16 AM
    Author     : Thuy Linh
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:url value="/Post" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<h1>Ch?nh s?a bài vi?t</h1>
<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="post">
    

    <div class="mb-3 mt-3">
        <label for="topic" class="form-label">Tên bài vi?t</label>
        <form:errors path="topic" element="div" cssClass="alert alert-danger" />
        <form:input path="topic" type="text" class="form-control" id="topic" placeholder="${post.topic}" name="topic" />

    </div>


    <div class="mb-3 mt-3">
        <label for="content" class="form-label">N?i dung bài vi?t</label>
        <form:errors path="content" element="div" cssClass="alert alert-danger" />
        <form:input path="content" type="text" class="form-control" id="content" placeholder="${post.content}" name="content" />

    </div>

    <div class="mb-3 mt-3">
        <label for="majorId" class="form-label">Ngành liên quan bài vi?t</label>
        <form:errors path="majorId" element="div" cssClass="alert alert-danger" />
        <form:select  class="form-select" path="majorId" id="majorId" name="majorId">
            <c:forEach items="${major}" var="m">
                <c:choose>
                    <c:when test="${m.id == post.majorId.id}">
                        <option value="${m.id}" selected>${m.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${m.id}">${m.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>



        </form:select>
    </div>

    <c:forEach items="${image}" var="i">
        <img style="width:400px;" class="card-img-top m-10 " src="${i.path}" alt="Post image">
    </c:forEach>


    <div class="mb-3 mt-3">
        <form:hidden path="id" />

        <button class="btn btn-success" type="submit">

            <option value="${m.id}" selected>Cập nhật bài dang</option>

        </button>
    </div>
</form:form>
