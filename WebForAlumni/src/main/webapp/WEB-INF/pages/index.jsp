<%-- 
    Document   : index
    Created on : Aug 4, 2024, 1:39:43 PM
    Author     : Thuy Linh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-12 col-12 ">
    <c:url value="/" var="action" />
    <form:form action="${action}">
        <div class="row">
            <div class="mb-3 mt-3 col p-2" style="margin-left: 30px">
                <label for="q" class="form-label">Tìm kiếm nội dung</label>
                <input type="text" class="form-control" id="q" placeholder="Tìm kiếm nội dung..." name="q">
            </div>
            <div class="mb-3 mt-3 col p-2">

                </select>
                <label for="major" class="form-label">Tìm kiếm theo ngành:</label>
                <select name="major" id="major" class="form-control">
                    <option value="">Ngành</option>
                    <c:forEach items="${major}" var="m">
                        <option value="${m.id}">${m.name}</option>
                    </c:forEach>
                </select>


            </div>
            <div class="mb-3 mt-3 col p-2">
                <label for="fromDate" class="form-label">Bài đăng từ ngày :</label>
                <input type="date" class="form-control" id="fromDate" placeholder="Từ ngày..." name="fromDate">
            </div>
            <div class="mb-3 mt-3 col p-2">
                <label for="toDate" class="form-label">Bài đăng dến ngày:</label>
                <input type="date" class="form-control" id="toDate" placeholder="Đến ngày..." name="toDate">
            </div>

            <div class="mb-3 col p-2">
                <button class="btn btn-info " style="width:150px; margin-top: 48px; margin-left: 30px" type="submit">Tìm kiếm </button>
            </div>
        </div>
    </form:form>
</div>






<h3>Bài dang</h3>
<div>
    <a class="btn btn-info m-1" href="<c:url value="/AddPost" />">Thêm bài</a>
    <div>
        <div class="col-md-10 col-12 p-3">
            <table class="table table-striped">
                <tr>

                    <th>Mã bài đăng </th>
                    <th>Chủ đề</th>
                    <th >Nội dung</th>
                    <th style="width:120px">Ngày đăng</th>
                    <th>Người đăng</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${post}" var="p">
                    <tr id="post${p.id}">
                        <td>${p.id}</td>  
                        <c:forEach items="${topic}" var="t">
                            <c:if test="${t.id==p.topicidforPost.id}">
                                <td>${t.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${p.content}</td>
                        <td>${p.createdDate}</td>
                        <c:forEach items="${user}" var="u">
                            <c:choose >
                                <c:when test="${u.id == p.useridforPost.id}">
                                    <td>${u.username}</td>
                                </c:when>
                            </c:choose>
                        </c:forEach>


                        <td><c:url value="/Post/${p.id}" var="post" />
                            <a href="${post}" class="btn btn-success">Chi ti?t</a></td>
                        <td>
                            <c:url value="/api/Post/${p.id}" var="st" />
                            <button onclick="deletePost('${st}', ${p.id})" class="btn btn-danger">&times;</button>
                        </td>
                        

                    </tr>
                </c:forEach>
            </table>
        </div>
        <nav>
