<%-- 
    Document   : index
    Created on : Aug 4, 2024, 1:39:43 PM
    Author     : Thuy Linh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>






<div class="row ">
    <c:forEach items="${notification}" var="n">

        <div class="card col-sm-3 mt-3 mb-3" style="width:420px; border-color: black; margin-left: 10px">
            <img class="card-img-top mt-2" style="width:395px; height:250px"src="${n.cover}" alt="Card image">
            <div class="card-body">
                <h6 class="card-title" id="abc123">Địa điểm: ${n.address}</h5>
                    <p class="card-text">${n.content}</p>
                    <c:url value="/Notification/${n.id}" var="no" />
                    <a href="${no}" class="btn btn-primary" style="margin-left: 17rem; width:100px">See more</a>
                     
            </div>
        </div>
    </c:forEach>
</div>












