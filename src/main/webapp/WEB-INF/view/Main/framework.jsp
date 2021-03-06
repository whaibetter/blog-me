<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="applicable-device" content="pc,mobile">
    <meta name="MobileOptimized" content="width"/>
    <meta name="HandheldFriendly" content="true"/>
    <link rel="shortcut icon" href="/img/logo.png">
    <rapid:block name="description">
        <meta name="description" content="whai is me" />
    </rapid:block>
    <rapid:block name="keywords">
        <meta name="keywords" content="whai is me" />
    </rapid:block>
    <rapid:block name="title">
        <title>
               whai is me
        </title>
    </rapid:block>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/plugin/font-awesome/css/font-awesome.min.css">


    <rapid:block name="header-style">

    </rapid:block>
</head>
<style type="text/css">
    body{
        font-family: "Microsoft YaHei", Helvetica, Arial, Lucida Grande, Tahoma, sans-serif;
        width:100%;
        height:100%;
        overflow:scroll;
        background-attachment:fixed;
        background-image:url(<%=request.getContextPath()%>/img/back.png)
    }
</style>
<body>
    <div id="page" class="site" style="transform: none;">
        <%@ include file="part/header.jsp" %>
        <div id="content" class="site-content" style="transform: none;">
            <rapid:block name="left">

            </rapid:block>
            <rapid:block name="right">
                <%@ include file="part/sidebar-2.jsp" %>
            </rapid:block>
        </div>

        <div class="clear"></div>

        <rapid:block name="link"></rapid:block>
    <%--    <%@ include file="part/footer.jsp"%>--%>

    </div>

    <script src="/js/jquery.min.js"></script>
    <script src="/js/superfish.js"></script>
    <script src="/js/script.js"></script>
    <script src="/plugin/layui/layui.all.js"></script>
    <rapid:block name="footer-script">

    </rapid:block>

</body>
</html>