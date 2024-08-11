<%-- 
    Document   : header
    Created on : Aug 10, 2024, 11:29:37 PM
    Author     : Thuy Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">Admin - SocialNetworkForAlumni</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Bài đăng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Thống kê</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Người dùng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/Notification"/>">Thông báo</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

