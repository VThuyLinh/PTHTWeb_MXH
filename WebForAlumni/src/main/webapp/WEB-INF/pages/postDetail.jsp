<%-- 
    Document   : post
    Created on : Aug 14, 2024, 10:53:16 AM
    Author     : Thuy Linh
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:url value="/Post" var="action"></c:url>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<f:form action="${action}" method="post" enctype="multipart/form-data"  modelAttribute="post" >
    <h1>${ex}</h1>
    <div class="mb-3 mt-3">
        <label for="topicidforPost" class="form-label">Topic</label>
        <f:select  class="form-select" path="topicidforPost" id="topicidforPost" name="topicidforPost">
            <c:forEach items="${topic}" var="t">
                <c:choose>
                    <c:when test="${t.id == post.topicidforPost.id}">
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
        <f:input path="content" type="text" class="form-control" id="content" placeholder="${post.content}" name="content" />
    </div>

   

    <div class="mb-3">
        <c:forEach items="${user}" var="u">
            <c:if test="${u.id==post.useridforPost.id}" >
                <f:input path="useridforPost" type="text" class="form-control" id="useridforPost" value="${u.id}" name="useridforPost" />
            </c:if>
        </c:forEach>

    </div>
    
    <div class="mb-3">
        <label class="form-check-label" >Số lượt yêu thích &#129505; của bài đăng</label>
        <input readonly="true"value="${like}"> </input>
    </div>

    <div class="form-check">
        <f:radiobutton class="form-check-input" id="active" name="active" path="active" value="true" checked="checked" />
        <label class="form-check-label" for="active">&#128275;</label>
    </div>
    <div class="form-check">
        <f:radiobutton class="form-check-input" id="active" name="active" path="active" value="false"/>
        <label class="form-check-label" for="active">&#128274;</label>
    </div>

    <div class="mb-3">
        <label for="createdDate">Start date:</label>
        <input type="date" id="createdDate" name="createdDate" value="2024-09-02" />
    </div>

    <div class="mb-3 mt-3">
        <label for="majoridforPost" class="form-label">Ngành để tìm bài viết</label>
        <f:select  class="form-select" path="majoridforPost" id="majoridforPost" name="majoridforPost">
            <c:forEach items="${major}" var="m">
                <c:choose>
                    <c:when test="${m.id == post.majoridforPost.id}">
                        <option value="${m.id}" selected>${m.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${m.id}">${m.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </f:select>
    </div>
    <f:hidden path="id" />



    <f:hidden path="image" />
    <f:hidden path="createdDate" />

<f:hidden path="useridforPost" id="useridforPost" name="useridforPost" />

    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh</label>
        <f:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        <c:if test="${post.image != null}">
            <img class="mt-1" src="${post.image}" alt="${post.image}" width="120" />
        </c:if>

    </div>
    <button type="submit" class="btn btn-primary">C?p nh?t</button>
</f:form>

    
<h1>Bình luận</h1>
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


