<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>


<rapid:override name="title">
    <title>${articleDetailWithComment.article.articleTitle}</title>
</rapid:override>

<rapid:override name="header-style">
    <rapid:override name="header-style">
        <link rel="stylesheet" href="/css/highlight.css">
        <style>
            .entry-title {
                background: #f8f8f8;
            }
        </style>
    </rapid:override>
</rapid:override>

<rapid:override name="left">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post">
                <header class="entry-header">
                    <h1 class="entry-title">
                            ${articleDetailWithComment.article.articleTitle}
                    </h1>
                </header><!-- .entry-header -->
                <div class="entry-content">
                    <div class="single-content">
                            ${articleDetailWithComment.article.articleContent}
                    </div>
                    <div class="clear"></div>
                </div><!-- .entry-content -->
            </article><!-- #post -->

                <%--评论区域 start--%>
            <div class="scroll-comments"></div>
            <div id="comments" class="comments-area">
                <h3 iclass="comment-reply-title">
                        <span>
                            <font style="color:white;">评论列表</font>
                        </span>
                </h3>
                <ol class="comment-list">
                    <c:forEach items="${articleDetailWithComment.commentWithName}" var="comment">
                        <li class="comments-anchor">
                            <ul id="anchor-comment-${comment.commentId}"></ul>
                        </li>
                        <li class="comment">
                            <div id="div-comment-${comment.commentId}" class="comment-body">
                                <div class="comment-author vcard">
                                        <%--评论的人的名字--%>
                                    <strong>${comment.commentUserName} </strong>

                                    <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <br>
                                                <span class="comment-aux">
                                                    <fmt:formatDate value="${comment.commentDate}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                </span>
                                            </span>
                                        </span>
                                    <p>
                                            ${comment.commentContent}
                                    </p>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ol>
                <div id="respond" class="comment-respond">
                    <h3 id="reply-title" class="comment-reply-title">
                        <span id="reply-title-word">
                            发表评论
                        </span>
                    </h3>
                    <form id="comment_form" method="post">
                        <p class="comment-form-comment">
                             <textarea id="comment" name="commentContent" rows="4" tabindex="1" required></textarea>
                        </p>
                        <div class="clear"></div>
                        <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                                <%--文章id--%>
                            <input type="hidden" name="commentArticleId" value="${articleDetailWithComment.article.articleId}" id="article_id">
                                <%--评论的人的id--%>
                            <input type="hidden" name="commentPid"  value="${sessionScope.user.userId}">
                        </p>
                    </form>
                </div>
            </div>
                <%--评论框 end--%>

        </main>
        <!-- .site-main -->
    </div>
    <%--博客主体-左侧文章正文end--%>
</rapid:override>


<%--侧边栏 start--%>
<%--<rapid:override name="right">--%>
<%--    <%@include file="../part/sidebar-2.jsp" %>--%>
<%--</rapid:override>--%>
<%--侧边栏 end--%>


<%@ include file="../framework.jsp" %>

