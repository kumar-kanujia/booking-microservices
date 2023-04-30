<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12 col-12">
      <form class="border p-3" action="${pageContext.request.contextPath}/viewSchedule" method="post">
        <div class="m-md-5 text-center">
          <h5 class="card-title">Search Upcoming Showtime</h5>
        </div>
        <div class="mb-3">
          <label for="date" class="form-label">Date (Upcoming)</label>
          <input type="date" class="form-control" id="date" name="date" required="required">
        </div>
        <div class="text-center m-md-5">
          <input class="btn btn-outline-success " type="submit" value="Search">
        </div>
      </form>
    </div>
  </div>
</div>




<%@ include file="common/footer.jsp"%>