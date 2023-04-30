<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 mt-5">
            <table class="table w-100">
                <thead>
                <tr>
                    <th class="text-center" style="width: 80%; vertical-align: middle;">Movies</th>
                    <th></th>
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
                        <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/searchSlot?title=${movie.title}" class="btn btn-outline-primary">Book</a></td>
                    </tr>
                </c:forEach>
                <p class="text-danger text-center"><strong>${error}</strong></p>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>