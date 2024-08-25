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
        <label for="file" class="form-label">Ảnh</label>
        <f:input path="cover" type="file" accept=".jpg,.png" class="form-control" id="cover" name="cover" />
        <c:if test="${noDetail.cover != null}">
            <img class="mt-1" src="${noDetail.cover}" alt="${noDetail.cover}" width="120" />
        </c:if>
    </div>  
    <div class="mb-3 mt-3">
        <label for="content" class="form-label">Nội dung thông báo</label>
        <input type="text" class="form-control" id="content" value="${noDetail.content}" name="content">
    </div>
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">Địa điểm</label>
        <input type="text" class="form-control" id="address" value="${noDetail.address}" name="address">
    </div>
    <div class="mb-3 mt-3">
        <label for="time" class="form-label"> Thời gian</label>
        <input type="text" class="form-control" id="time" value="${noDetail.time}" name="time">
    </div>

    <div class="mb-3 mt-3">
        <label for="time" class="form-label">Người mời</label>
        <c:forEach items="${user}" var="u">
            <c:if test="${u.id==noDetail.userIdInvite.id}">
                <input type="text" class="form-control" id="time" value="${u.firstname} ${u.lastname} (${u.role})" name="time">
            </c:if>
        </c:forEach>
    </div>




    <div class="mb-3 mt-3">
        <label for="time" class="form-label">Mời nhóm</label>
        <c:forEach items="${teamNoti}" var="tn">
            <c:if test="${tn.noId.id==noDetail.id}">
                <c:forEach items="${team}" var="t">
                    <c:if test="${t.id==noDetail.id}">
                        <input type="text" class="form-control" id="time" value="${t.name}" name="time"/></c:if>
                </c:forEach>
            </c:if>

        </c:forEach>
    </div>


    <div class="mb-3 mt-3">
        <f:hidden path="id" />
        <f:hidden path="cover" />
        <button class="btn btn-success" type="submit">Cập nhật bài đăng</button>

    </div>


</f:form>



<h1>Các thành viên nhóm được mời</h1>
<div class="row" style="align-items: center">
    <c:forEach items="${team}" var="t">
        <c:forEach items="${teamUser}" var="tu">
            <c:forEach items="${teamNoti}" var="tn">
                <c:if test="${tu.groupId.id==tn.groupId.id}">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${t.id==tn.groupId.id && tu.userId.id==u.id}">
                            <div class="col-sm-2"><img src="${u.avatar}" style=" border-radius: 50%; margin: 10px"width="80px"/></div>
                    <div class="col-sm-4"><h6>${u.username}(Nhóm : ${t.id} - ${t.name})</h6></div>

                            

                        </c:if>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </c:forEach>
    </c:forEach>

</div>



