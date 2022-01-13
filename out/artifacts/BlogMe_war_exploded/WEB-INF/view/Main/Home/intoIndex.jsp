<%--
  Created by IntelliJ IDEA.
  User: whai_luo
  Date: 2020/7/4
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="left">
    <div>
        <c:choose>
            <c:when test="${userInfo==null}">
                <c:choose>
                    <%--看自己的 并且不是空列表--%>
                    <c:when test="${not empty allArticleInfos}">
                        <%--看自己的--%>
                        <font color="white"> 以下是${sessionScope.user.userName}的文章列表 </font>
                    </c:when>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:choose>
                <%--看别人的--%>
                    <c:when test="${not empty allArticleInfos}">
                        <font color="white"> 以下是<font color="#d2691e">${userInfo.userName}的文章列表</font> <a href="/friend/addFriend/${userInfo.userId}">添加他为好友</a> </font>
                    </c:when>
                    <c:otherwise>
                        <font color="white">该用户没有发布过文章</font>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>

    </div>
    <div id="primary" class="content-area">

        <main id="main" class="site-main" role="main">
            <c:choose>
                    <%--非空判断--%>
                <c:when test="${not empty allArticleInfos}">
                    <c:forEach items="${allArticleInfos}" var="articleInfo">
                    <article  class="post type-post">

                        <figure class="thumbnail">
                            <a href="/article/articleDetail/${articleInfo.article.articleId}">
                                <img width="280" height="210"
                                     src="/img/thumbnail/random/img_${articleInfo.randomImage}.jpg"
                                     class="attachment-content size-content wp-post-image"
                                     alt="${articleInfo.article.articleTitle}">
                            </a>
                        </figure>
                        <header class="entry-header">
                            <h2 class="entry-title">
                                <a href="/article/articleDetail/${articleInfo.article.articleId}"
                                   rel="bookmark">
                                        ${articleInfo.article.articleTitle}
                                </a>
                            </h2>
                            <div class="clear"></div>
                        </header>

                        <div class="entry-content">
                            <span class="entry-meta">
                                <span class="date">
                                   <fmt:formatDate value="${articleInfo.article.articleDate}"
                                                   pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                </span>

                            </span>
                            <div class="clear"></div>
                        </div><!-- .entry-content -->

                        <span class="entry-more">
                            <a href="/article/articleDetail/${articleInfo.article.articleId}"
                               rel="bookmark">
                                阅读全文
                            </a>
                        </span>
                    </article>
                </c:forEach>
                </c:when>
                <c:otherwise>


                </c:otherwise>
            </c:choose>
        </main>
    </div>
</rapid:override>
<%--左侧区域 end--%>


<%@ include file="../framework.jsp" %>