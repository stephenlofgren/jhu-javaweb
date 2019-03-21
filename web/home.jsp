<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title></title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    </head>
  <body>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
      
      <%@ include file="/fragments/header.jspf" %>
      <%@ include file="/fragments/carousel.jspf" %>
      <%@ include file="/fragments/features.jspf" %>
      <%@ include file="/fragments/testimonials.jspf" %>
      <%@ include file="/fragments/footer.jspf" %>
      
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
      $(document).ready(function() {
        jQuery.fn.carousel.Constructor.TRANSITION_DURATION = 200000  // 2 seconds
      });
    </script>
  </body>
</html>

