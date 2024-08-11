<%-- 
    Document   : index
    Created on : Aug 4, 2024, 1:39:43 PM
    Author     : Thuy Linh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div class="col-md-12 col-12 ">
            <c:url value="/" var="action" />
            <form action="${action}">
                <div class="row">
                    <div class="mb-3 mt-3 col p-2" style="margin-left: 30px">
                        <label for="q" class="form-label">Từ khóa chủ đề:</label>
                        <input type="text" class="form-control" id="q" placeholder="Từ khóa chủ đề..." name="q">
                    </div>
                    <div class="mb-3 mt-3 col p-2">

                        </select>
                        <label for="major" class="form-label">Theo nhóm ngành:</label>
                        <select name="major" id="major" class="form-control">
                            <option value="">Ngành</option>
                            <c:forEach items="${major}" var="m">
                                <option value="${m.id}">${m.name}</option>
                            </c:forEach>
                        </select>


                    </div>
                    <div class="mb-3 mt-3 col p-2">
                        <label for="fromDate" class="form-label">Từ ngày :</label>
                        <input type="date" class="form-control" id="fromDate" placeholder="Từ ngày..." name="fromDate">
                    </div>
                    <div class="mb-3 mt-3 col p-2">
                        <label for="toDate" class="form-label">Đến ngày:</label>
                        <input type="date" class="form-control" id="toDate" placeholder="Đến ngày..." name="toDate">
                    </div>

                    <div class="mb-3 col p-2">
                        <button class="btn btn-info " style="width:150px; margin-top: 48px; margin-left: 30px" type="submit">Tìm </button>
                    </div>
                </div>
            </form>
        </div>





                <div class="row">
                    <div class="col-lg-7">
                        <img src="https://i.pinimg.com/564x/c9/f5/06/c9f506f8c980eac0e168a3e2b2c1d584.jpg" width="300" />
                    </div>
                    <div class="col-lg-4" style="font-size: 25; margin-top: 200px;">
                        Mạng xã hội cho cựu sinh viên được thành lập nhằm tạo được 1 nơi để chia sẻ kiến thức, 
                        kinh nghiệm, trải nghiệm từ các cựu sinh viên. 
                    </div>
        
                </div>
                <hr style="color: black; opacity: 1; border-width: 10px; width:93%; margin-left: 60px"/>
                <div class="row">
                    <div class="col-lg-4" style="font-size: 25; margin-top: 200px; margin-left: 100px">
                        Bên cạnh đó mạng xã hội cho cựu sinh 
                        viên còn là nơi tin cậy để các sinh viên có thể tìm kiếm việc làm, tham khảo về nhu 
                        cầu thị trường về một số học thuật đang và sẽ phát triển
                    </div>
                    <div class="col-lg-7">
                        <img src="https://i.pinimg.com/564x/72/00/49/7200492d1274c0660ea991342e92ed9e.jpg" width="250" style="margin-left: 210px"/>
                    </div>
        
                </div>
        <div class="col-md-10 col-12 p-3">
            <table class="table table-striped">
                <tr>
                    <th>Mã bài đăng </th>
                    <th>Chủ đề</th>
                    <th>Nội dung</th>
                    <th>Ngày đăng</th>
                    <th>Người đăng</th>
                    <th></th>
                </tr>
                <c:forEach items="${post}" var="p">
                    <tr id="post${p.id}">
                        <td>${p.id}</td>                       
                        <td>${p.topic}</td>
                        <td>${p.content}</td>
                        <td>${p.createdDate}</td>
                        <td>${p.userPostId}</td>
                        <c:forEach items="${user}" var="u">
                            <td>${p.userPostId}</td>
                            <td>${u.username}</td>
                        </c:forEach>


                        <td>
                            <c:url value="/products/${p.id}" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>

                            <c:url value="/api/products/${p.id}" var="uD" />
                            <button onclick="deleteProduct('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
 