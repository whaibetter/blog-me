<%--
  Created by IntelliJ IDEA.
  User: whai_luo
  Date: 2020/7/8
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<rapid:override name="left">

    <div id="primary" class="content-area">

        <main id="main" class="site-main" role="main">

            <ul class="search-page">
                <li>
                    <form name="uploadForm" id="uploadForm"  method="post">
                        <p>
                            <label for="button_file">上传文件<br />
                                <input type="file" name="file" id="button_file" class="input"/></label>
                        </p>
                        <p class="submit">
                            <input type="button" name="wp-submit" id="submit-btn" class="button button-primary button-large" value="上传" />
                        </p>
                    </form>
                </li>

                <li>
                    文件列表
                </li>
                <c:choose>
                    <%--非空判断--%>
                    <c:when test="${not empty files}">
                        <c:forEach items="${files}" var="file">
                            <li class="entry-title">
                                <form action="/download">
                                    <input type="hidden" name="videoTitle" value="${file.videoTitle}">
                                    文件名： ${file.videoTitle}
                                    文件位置：${file.videoLocation}
                                    <input type="submit" value="下载">
                                </form>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <br>
                        很遗憾，没有文件，请先上传
                        <br>
                    </c:otherwise>
                </c:choose>
            </ul>
        </main>
    </div>
</rapid:override>
<%--左侧区域 end--%>

<rapid:override name="footer-script">

    <script type="text/javascript">


        <%--上传--%>
        $("#submit-btn").click(function () {
            var formData = new FormData($('#uploadForm')[0]);

                $.ajax({
                    async: false,//同步，待请求完毕后再执行后面的代码
                    type: "POST",
                    url: '/uploadFile',
                    contentType: false,
                    data: formData,
                    dataType: "json",
                    cache: false,
                    processData: false,
                success: function (data) {
                    if(data.code==0) {
                        alert("错误");
                    } else {
                        window.location.href="/FileList";
                    }
                },
                error: function () {
                    window.location.href="/toError";
                }
            }
            )

        })

    </script>
</rapid:override>

<%@ include file="../framework.jsp" %>
