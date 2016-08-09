<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">
    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
    <title>Super Admin Responsive Template</title>
    <!-- CSS -->
    <%@ include file="../inc/new/css.jsp" %>
</head>
<body id="skin-cloth">
<div class="clearfix"></div>
<section id="main" class="p-relative" role="main">
    <%@ include file="../inc/new/menu.jsp" %>
    <section id="content" class="container">
        <!-- 查询条件 -->
        <br><br>
        <form id="importForm" target="_blank" action="${contextPath}/admin/test/excel/export" method="post" enctype="multipart/form-data">
            <div class="btn-group">
                <input type="file" name="file" id="file" title="选择EXCEL文件导入" class="btn btn-default required" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml">
            </div>
            <div class="btn-group">
                <button type="submit" id="exportBtn" class="btn btn-info" onclick="$test.fn.save()"> 导出新文件 </button>
            </div>
        </form>
    </section>
</section>
<!-- JS -->
<%@ include file="../inc/new/foot.jsp" %>
<script>
    $test = {
        v: {
            list: [],
            chart : null,
            dTable: null
        },
        fn: {
            save : function () {
                $("#importForm").submit();
            }
        }
    }

</script>
</body>
</html>

