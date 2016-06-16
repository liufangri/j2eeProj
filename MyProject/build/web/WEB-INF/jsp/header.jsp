<%-- 
    Document   : header
    Created on : 2016-5-25, 16:32:19
    Author     : Y400
--%>
<%
    String path = request.getContextPath();
%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="<%=path%>/dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<%=path%>/dist/css/flat-ui.css" rel="stylesheet">

<link rel="shortcut icon" href="<%=path%>/dist/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
  <script src="../../dist/js/vendor/html5shiv.js"></script>
  <script src="../../dist/js/vendor/respond.min.js"></script>
<![endif]-->



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=path%>/dist/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/dist/js/flat-ui.min.js"></script>
<script src="<%=path%>/dist/assets/js/application.js"></script>
<script src="<%=path%>/dist/js/jquery.base64.min.js"></script>
<script src="<%=path%>/dist/js/jquery.base64.js"></script>

<script>
    $('button:not([type="submit"])').on('click', function (e) {
        var $this = $(this);

        if (!!$this.attr('data-radiocheck-check')) {
            var el = $this.attr('data-radiocheck-check');
            $(el).radiocheck('check');
        } else if (!!$this.attr('data-radiocheck-uncheck')) {
            var el = $this.attr('data-radiocheck-uncheck');
            $(el).radiocheck('uncheck');
        } else if (!!$this.attr('data-radiocheck-toggle')) {
            var el = $this.attr('data-radiocheck-toggle');
            $(el).radiocheck('toggle');
        } else if (!!$this.attr('data-radiocheck-indeterminate')) {
            var el = $this.attr('data-radiocheck-indeterminate');
            $(el).radiocheck('indeterminate');
        } else if (!!$this.attr('data-radiocheck-determinate')) {
            var el = $this.attr('data-radiocheck-determinate');
            $(el).radiocheck('determinate');
        } else if (!!$this.attr('data-radiocheck-disable')) {
            var el = $this.attr('data-radiocheck-disable');
            $(el).radiocheck('disable');
        } else if (!!$this.attr('data-radiocheck-enable')) {
            var el = $this.attr('data-radiocheck-enable');
            $(el).radiocheck('enable');
        } else if (!!$this.attr('data-radiocheck-destroy')) {
            var el = $this.attr('data-radiocheck-destroy');
            $(el).radiocheck('destroy');
        } else if (!!$this.attr('data-radiocheck-init')) {
            var el = $this.attr('data-radiocheck-init');
            $(el).radiocheck();
        }

        e.preventDefault();
    });

</script>


