<%--suppress HtmlUnknownTarget --%>
<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 mt-5">
            <table class="table w-100">
                <thead>
                <tr>
                    <th class="text-center" style="width: 60%; vertical-align: middle;">Column 1</th>
                    <th>Column 2</th>
                    <th>Column 3</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${catalogList}" var="movie">
                    <tr>
                        <td style="vertical-align: middle;"><div class="card border-info text-center">
                            <div class="card-header">${movie.title}</div>
                            <div class="card-body border-info text-center">
                                <h6 class="card-subtitle mb-2 text-muted">Genre : ${movie.genre}</h6>
                                <h6 class="card-subtitle mb-2 text-muted">Rating : ${movie.rating}</h6>
                                <div class="card-body">
                                    <p class="card-text ">Movie Description : ${movie.description}</p>
                                </div>
                            </div>
                        </div></td>
                        <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/updateMovie?title=${movie.title}" class="btn btn-outline-primary">Update</a></td>
                        <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/deleteMovie?title=${movie.title}" class="btn btn-outline-danger" methods="">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>