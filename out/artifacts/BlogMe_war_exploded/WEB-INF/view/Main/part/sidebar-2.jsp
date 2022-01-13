<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: whai_luo
  Date: 2020/7/4
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%--
    一般用于首页侧边栏：博客概述
    我的好友 访问我的人

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--博客主体-右侧侧边栏 start--%>
<div id="sidebar" class="widget-area all-sidebar"
     style="position: relative; overflow: visible; box-sizing: border-box; min-height: 1px;">

    <%--关于本站 start--%>
    <aside class="widget about">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>关于本站
        </h3>
        <div id="feed_widget">
            <div class="feed-about">
                <div class="about-main">
                    <div class="about-img">
                        <img src="<%=request.getContextPath()%>/img/WeChat.jpg"
                             alt="QR Code">
                    </div>
                    <div class="about-name">From Whai</div>
                    <div class="about-the">
                        I am hero zero
                    </div>
                </div>
                <div class="clear"></div>
                <ul>
                    <li class="weixin">
                        <a title="微信" id="weixin_btn" rel="external nofollow">
                            <i class="fa fa-weixin"> </i>
                            <div id="weixin_code" class="hide" >
                                <img src="<%=request.getContextPath()%>/img/WeChat.jpg" alt="">
                            </div>
                        </a>
                    </li>
                    <li class="tqq">
                        <a target="blank" rel="external nofollow"
                           href="http://wpa.qq.com/msgrd?v=3&amp;uin=1756641723&amp;site=qq&amp;menu=yes"
                           title="QQ在线">
                            <i class="fa fa-qq"></i>
                        </a>
                    </li>
                    <li class="tsina">
                        <a title=""
                           href="https://weibo.com/u/3070756051"
                           target="_blank" rel="external nofollow">
                            <i class="fa fa-weibo"></i>
                        </a>
                    </li>
                    <li class="feed">
                        <a title="" href="https://github.com/lkwhai/" target="_blank"
                           rel="external nofollow">
                            <i class="fa fa-github"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--关于本站 start--%>


    <%--好友列表 start--%>
    <aside class="widget friend_list">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>好友列表
        </h3>
        <div id="friend_list">
            <ul>
                <c:forEach items="${sessionScope.allFriends}" var="friend">
                    <li>
                        <a href="/userPage/${friend.userId}" rel="bookmark">${friend.userName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--好友列表 end--%>


    <%--访问我文章的人 start--%>
    <aside id="look_me_users" class="widget look_me_users wow fadeInUp" data-wow-delay="0.3s">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>访问我文章的人
        </h3>
        <div id="look_me_users_list">
            <ul>
                <c:forEach items="${sessionScope.allLookMeUsers}" var="lookUserVo">

                    <li>
                        <a href="/userPage/${lookUserVo.user.userId}" rel="bookmark">
                                ${lookUserVo.user.userName}
                        </a>
                        <fmt:formatDate value="${lookUserVo.lookDate}"
                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>
                    </li>

                </c:forEach>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--访问我文章的人 end--%>


</div>



<%--博客主体-右侧侧边栏 end--%>

