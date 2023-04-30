<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
    <div class="card p-4">
        <h1 class="mb-4">Booking Search</h1>
        <form action="${pageContext.request.contextPath}/viewTicket" method="post">
            <div class="form-group ui-autocomplete">
                <label for="id" class="text-center m-md-1">Booking ID:</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="Enter booking ID" required>
            </div>
            <div class="text-center mt-5">
            <button type="submit" class="btn btn-primary mt-2 text-center">Search</button>
            </div>
        </form>
    </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>