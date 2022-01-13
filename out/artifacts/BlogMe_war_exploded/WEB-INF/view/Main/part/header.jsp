<%--
    博客顶部部分
    包括：退出登录 博客标题
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--导航 start--%>
<header id="masthead" class="site-header">
    <%--顶部菜单 start--%>
    <nav id="top-header">
        <div class="top-nav">
            <a href="/basic/logout"><font color="white">退出登录</font></a>
        </div>
    </nav><!-- #top-header -->
    <%--顶部菜单 end--%>

    <%--主要菜单 satrt--%>
    <div id="menu-box">
        <div id="top-menu">
                <span class="nav-search">
                    <i class="fa fa-search"></i>
                </span>
            <div class="logo-site"><h1 class="site-title">
                <a href="/home" title="create from whai">WHAI</a>
            </h1>
                <p class="site-description">HUMBLE&MODEST</p>
            </div>
            <!-- .logo-site -->
            <div id="site-nav-wrap">
                <div id="sidr-close">
                    <a href="#sidr-close" class="toggle-sidr-close">×</a>
                </div>
                <nav id="site-nav" class="main-nav">
                    <div class="menu-pcmenu-container">
                        <ul id="menu-pcmenu" class="down-menu nav-menu sf-js-enabled sf-arrows">

                            <li>
                                <a href="/article/toCreateArticle">
                                    <i class="fa fa-comment"></i>
                                    <span class="font-text">发布文章</span>
                                </a>
                            </li>
                            <li>
                                <a href="/FileList">
                                    <i class="fa-home fa"></i>
                                    <span class="font-text">文件列表</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>

        <div class="clear"/>
       <!-- #top-menu -->
    </div><!-- #menu-box -->
    <%--主要菜单 satrt--%>

</header><!-- #masthead -->
<%--导航 end start--%>

<%--搜索框 start--%>
<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="/user/search">
                <span>
                    <input type="text" value="" name="username" id="s" placeholder="输入搜索用户名"required="">
                    <button type="submit" id="searchsubmit">搜索</button>
                </span>
        </form>
    </div>
    <div class="clear"></div>
</div>
<%--搜索框 end--%>