<%-- 
    Document   : statsYear
    Created on : Aug 14, 2024, 9:36:39 AM
    Author     : Thuy Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-primary mt-1">THỐNG KÊ </h1>

<nav class="navbar navbar-expand-sm bg-light">

  <div class="container-fluid">
    <!-- Links -->
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/StatsPost"/>">Thống kê bài đăng trong tháng</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/StatsYear"/>">Thống kê bài đăng trong năm </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Thống kê theo quý</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Thống kê bài viết của người dùng</a>
      </li>
    </ul>
  </div>

</nav>

<div class="row">
    <div class="col-md-5 col-12">
        <table class="table">
            <tr>
                <th>Tháng</th>
                <th>Bài vi?t</th>
                
            </tr>
            <c:forEach items="${revenues}" var="r">
                <tr>
                    <td>${r[1]}</td>
                    <td>${r[0]}</td>
                    
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    
    let labels = [];
    let data = [];
    <c:forEach items="${revenues}" var="r">
        labels.push('${r[1]}');
        data.push(${r[0]});
    </c:forEach>
    
    window.onload = function () {
        const ctx = document.getElementById('myChart');

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                        label: '# Bài viết',
                        data: data,
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });};

    
</script>
