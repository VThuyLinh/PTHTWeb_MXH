<%-- 
    Document   : index
    Created on : Aug 4, 2024, 1:39:43 PM
    Author     : Thuy Linh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<div class="col-md-12 col-12 ">
    <c:url value="/Notification" var="action" />
    <form action="${action}">
        <div class="row">
            <div class="mb-3 mt-3 col p-2" style="margin-left: 30px">
                <label for="content" class="form-label">Tìm kiếm nội dung</label>
                <input type="content" class="form-control" id="content" placeholder="Tìm kiếm nội dung..." name="content">
            </div>

            <div class="mb-3 col p-2">
                <button class="btn btn-info " style="width:150px; margin-top: 48px; margin-left: 30px" type="submit">Tìm kiếm </button>
            </div>
        </div>
    </form>
</div>



<div class="row ">
    <div>
         <a class="btn btn-info m-1" href="<c:url value="/AddNotification" />">Thêm bài</a>
    </div>
    <c:forEach items="${notification}" var="n">

        <div class="card col-sm-3 mt-3 mb-3" style="width:420px; border-color: black; margin-left: 10px">
            <img class="card-img-top mt-2" style="width:395px; height:250px"src="${n.cover}" alt="Card image">
            <div class="card-body">
                <h6 class="card-title" id="abc123">Địa điểm: ${n.address}</h5>
                    <p class="card-text">${n.content}</p>


                    <div class="input-group" style="margin-left: 14rem">
                        <nav>
                            <c:url value="/api/Notification/${n.id}" var="no" />
                            <button onclick="deleteNotification('${no}', ${n.id})" style="width:60px;font-size: 20px"class="btn btn-danger">&#128465;</button>
                        </nav>
                        <nav style=" margin-left:10px">
                            <c:url value="/Notification/${n.id}" var="no" />
                            <a  href="${no}" class="btn btn-warning" style=" width:60px; font-size: 20px">&#128394;</a>
                            <nav>
                                </div>




                                </div>
                                </div>
                            </c:forEach>
                            </div>












