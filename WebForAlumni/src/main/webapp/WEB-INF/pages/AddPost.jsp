<%-- 
    Document   : AddPost
    Created on : Aug 22, 2024, 3:08:57 PM
    Author     : Thuy Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>


<c:url value="/AddPost" var="action"></c:url>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<f:form action="${action}" method="post" enctype="multipart/form-data"  modelAttribute="addPost">
    <h1>${ex}</h1>
    <div class="mb-3 mt-3">
        <label for="topic" class="form-label">Topic</label>
        <f:select  class="form-select" path="topicId" id="topicId" name="topicId">
            <c:forEach items="${topic}" var="t">
                <c:choose>
                    <c:when test="${t.id == post.topicId.id}">
                        <option value="${t.id}" selected>${t.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.id}">${t.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </f:select>

    </div>
    <div class="mb-3">
        <label for="content" class="form-label">Nội dung</label>
        <f:input path="content" onblur="getDate()" type="text" class="form-control" id="content" placeholder="${post.content}" name="content" />
    </div>
    
    <div class="mb-3" hidden>
        <f:label path="createdDate" type="text" class="form-control" id="createdDate" name="createdDate"/>
    </div>


    <div class="mb-3 mt-3">
        <label for="majorId" class="form-label">Ngành để tìm bài viết</label>
        <f:select  class="form-select" path="majorId" id="majorId" name="majorId">
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
        </f:select>
    </div>
    


    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh</label>
        <f:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />

    </div>
    <button type="submit" class="btn btn-primary">Thêm bài</button>
</f:form>
