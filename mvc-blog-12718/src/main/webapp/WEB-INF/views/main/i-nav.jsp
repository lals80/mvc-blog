<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="../main/home">Blog 2012718</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <!-- <a class="nav-link" href="../blogs/all">Get Blogs</a> -->
            <a class="nav-link" href="../blogs/page?curPage=1">Get Blogs</a>
          </li>
          <li>
          	<form class="form-inline ml-3" action="../blogs/search" method="get">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search" name="keyword"
					placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>
          </li>
          <c:choose>
          <c:when test="${sessionScope.blogger == null }">
          <li class="nav-item">
            <a class="nav-link" href="../bloggers/login">Sign In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../bloggers/new">Register</a>
          </li>
          </c:when>
          <c:otherwise>
          <li class="nav-item">
            <a class="nav-link" href="../bloggers/${sessionScope.blogger.id}">Info</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../bloggers/logout">Sing Out</a>
          </li>
          <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Blog 관리</a>
	        <div class="dropdown-menu" aria-labelledby="dropdown04">
	          <a class="dropdown-item" href="../blogs/new">Create Blog</a>
	          <c:if test="${sessionScope.blogger.bid == 'admin12718'}">
	          	<a class="dropdown-item" href="../bloggers/all">회원 관리</a>
	          </c:if>
	        </div>
	      </li>
          </c:otherwise>
          </c:choose>          
        </ul>
      </div>
    </div>
  </nav>
