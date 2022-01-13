<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>


<rapid:override name="title">
    <title>用户搜索结果</title>
</rapid:override>


<rapid:override name="left">
    <%--博客主体 start--%>
    <section id="content" class="site-content shadow">
        <%--博客主体-左侧正文 start--%>
        <section id="primary" class="content-area">
            <main id="main" class="site-main" role="main">
                <ul class="search-page">
                    <c:choose>
                        <%--非空判断--%>
                        <c:when test="${not empty users}">
                            <c:forEach items="${users}" var="user">
                                <li class="entry-title">
                                    <a href="/userPage/${user.userId}" rel="bookmark">
                                            ${user.userName}
                                            邮箱地址：${user.userEmail}
                                    </a>
                                    <a href="/friend/addFriend/${user.userId}" style="color:white;">
                                        添加好友
                                    </a>
                                </li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <br>
                            很遗憾，没有查询到用户名称为 <font style="color: #f00a0a;"> ${errorName} </font> 的用户，换一个关键词再试试吧。
                            <br>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </main>

        </section>
    </section>
</rapid:override>

<%@ include file="../framework.jsp" %>