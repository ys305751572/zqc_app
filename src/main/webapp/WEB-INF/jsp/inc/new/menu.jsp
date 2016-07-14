<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside id="sidebar">
    <!-- Sidbar Widgets -->
    <div class="side-widgets overflow">
        <!-- Profile Menu -->
        <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
            <a href="" data-toggle="dropdown">
                <img class="profile-pic animated" src="${contextPath}/html/img/profile-pic.jpg" alt="">
            </a>
            <ul class="dropdown-menu profile-menu">
                <li><a href="${contextPath}/admin/logout">退&nbsp;&nbsp;&nbsp;出</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
            </ul>
        </div>
        
        <!-- Calendar -->
        <div class="s-widget m-b-25">
            <div id="sidebar-calendar"></div>
        </div>
        
        <!-- Feeds -->
        <div class="s-widget m-b-25">
            <h2 class="tile-title">
               热门新闻
            </h2>
            
            <div class="s-widget-body">
                <div id="news-feed"></div>
            </div>
        </div>
    </div>
    
    <!-- Side Menu -->
    <ul class="list-unstyled side-menu">
        <li class="dropdown">
            <a class="sa-side-form" href="">
                <span class="menu-item">用户管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/velocity/index">文件生成</a></li>
                <li><a href="${contextPath}/admin/velocity/ddIndex">数据字典</a></li>
            </ul>
        </li>
    </ul>
</aside>