<%-- 
    Document   : post
    Created on : Aug 14, 2024, 10:53:16 AM
    Author     : Thuy Linh
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:url value="/Post" var="action" />

<h1>Chi tiet bài vi?t</h1>
<form:form method="get" action="${action}" modelAttribute="post">

    
    <div class="mb-3 mt-3">
        <label for="topic" class="form-label">Ch? d?</label>
        <c:forEach items="${topic}" var="t">
            <c:if test="${t.id==post.topicId.id}">
                <h6>${t.name}</h6>
            </c:if>
        </c:forEach>
    </div>


    <div class="mb-3 mt-3">
        <label for="content" class="form-label">N?i dung bài vi?t</label>
        <nav>${post.content}</nav>

    </div>

    <div class="mb-3 mt-3">
        <label for="majorId" class="form-label">Ngành liên quan bài vi?t</label>
        <c:forEach items="${major}" var="m">
            <c:if test="${m.id==post.majorId.id}">
                <h6>${m.name}</h6>
            </c:if>
        </c:forEach>
    </div>

   
        
            <img style="width:400px;" class="card-img-top m-10 " src="${post.image}" alt="Post image">
        


        <div class="mb-3 mt-3">
            <c:url value="/AddPost" var="a"></c:url>
            <a href="${a}">Chinh sua bài dang</a>
        </div>
    </form:form>

            
<!--            //Comment-->
<h1>Comment c?a bai dang</h1>
    <div class="row" style="align-items: center">
        <c:forEach items="${cmt}" var="c"> 
            <c:forEach items="${user}" var="u">
                <c:if test="${u.id == c.userId.id}">

                    <div class="col-sm-2"><img src="${u.avatar}" style=" border-radius: 50%; margin: 10px"width="80px"/></div>
                    <div class="col-sm-1"><h6>${u.username}</h6></div>
                        </c:if>
                    </c:forEach>
            <div class="col-sm-5">${c.content}</div>
            <div class="col-sm-3" id="date">${c.createdDate}</div>
            <div class="col-sm-1">
                <c:url value="/api/Comment/${c.id}" var="st" />
                <button onclick="deleteComment('${st}', ${c.id})" class="btn btn-danger">&times;</button>
            </div>

        </c:forEach>
    </div>
