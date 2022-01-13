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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="/img/logo.png">
    <title>
        新建文章
    </title>
    <link rel="stylesheet" href="/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="/css/back.css">
    <link rel="stylesheet" href="/plugin/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">
         <span class="layui-breadcrumb" lay-separator="/">
              <a href="/home">首页</a>
              <a><cite>添加文章</cite></a>
        </span>
            </blockquote>



            <form class="layui-form"  method="post" id="myForm" action="/article/insertArticleSubmit">

                <div class="layui-form-item">
                    <label class="layui-form-label">标题 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="articleTitle" lay-verify="title" id="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">内容 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea layui-hide" name="articleContent" lay-verify="content" id="content"></textarea>
                    </div>

                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary" onclick="getCateIds()">重置</button>
                    </div>
                </div>
            </form>


        </div>
    </div>

</div>

<script src="/js/jquery.min.js"></script>
<script src="/plugin/layui/layui.all.js"></script>
<script src="/js/back.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;


        //上传图片,必须放在 创建一个编辑器前面
        layedit.set({
            uploadImage: {
                url: '/uploadImage' //接口url
                ,type: 'post' //默认post
            }
        });

        //创建一个编辑器
        var editIndex = layedit.build('content',{
                height:350,
            }
        );

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        layedit.build('content', {
            tool: [
                'strong' //加粗
                ,'italic' //斜体
                ,'underline' //下划线
                ,'del' //删除线

                ,'|' //分割线

                ,'left' //左对齐
                ,'center' //居中对齐
                ,'right' //右对齐
                ,'link' //超链接
                ,'unlink' //清除链接
                ,'face' //表情
                ,'image' //插入图片
                ,'code'
            ]
        });

        layui.use('code', function(){ //加载code模块
            layui.code();
        });
//end
    });
    //        window.onbeforeunload = function() {
    //            return "确认离开当前页面吗？未保存的数据将会丢失";
    //        }



</script>
<script>
    //给文本编辑器的iframe引入代码高亮的css
    $("iframe").contents().find("head").append("<link rel=\"stylesheet\" href=\"/css/highlight.css\">\n");

</script>

</body>
</html>