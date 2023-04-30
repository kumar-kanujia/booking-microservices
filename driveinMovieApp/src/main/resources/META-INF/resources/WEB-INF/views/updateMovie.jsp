<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-lg-6 col-md-8 col-sm-10 col-12">
      <form:form class="border p-3" method="post" modelAttribute="movie" action="${pageContext.request.contextPath}/saveMovie" >
        <form:hidden path="id" />
        <div class="mb-3">
          <fieldset>
            <form:label path="title" for="title" class="form-label">Title</form:label>
            <form:input path="title" type="text" class="form-control" id="title" name="title" readonly="true"/>
            <form:errors path="title" cssClass="text-warning"/>
          </fieldset>
        </div>
        <div class="mb-3">
          <fieldset>
            <form:label path="genre" for="genre" class="form-label">Genre</form:label>
            <form:input path="genre" type="text" class="form-control" id="genre" name="genre" required="required"/>
            <form:errors path="genre" cssClass="text-warning"/>
          </fieldset>
        </div>
        <div class="mb-3">
          <fieldset>
            <form:label path="rating" for="rating" class="form-label">Rating</form:label>
            <form:input path="rating" type="number" class="form-control" id="rating" name="rating" min="1" max="10" required="required"/>
            <form:errors path="rating" cssClass="text-warning"/>
          </fieldset>
        </div>
        <div class="mb-3">
          <fieldset>
            <form:label path="description" for="description" class="form-label">Description</form:label>
            <form:textarea path="description" class="form-control" id="description" name="description" rows="3" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
          </fieldset>
        </div>
        <input type="submit" class="btn btn-primary">
      </form:form>
    </div>
  </div>
</div>
<%@ include file="common/footer.jsp"%>