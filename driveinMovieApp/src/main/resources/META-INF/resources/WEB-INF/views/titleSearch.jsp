<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container-fluid mt-5">
<div class="container-fluid h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-6">
        <div class="card shadow-lg p-3 mb-5 bg-white rounded">
            <div class="card-body">
                <h1 class="card-title text-center">Open Air Box</h1>
                <form class="form-inline justify-content-center text-center" action="${pageContext.request.contextPath}/searchSlot" method="post">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="title" class="sr-only">Search Parking Slot By Title</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="${title}" required>
                    </div>
                    <button type="submit" class="btn btn-primary mb-2 ">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<%@ include file="common/footer.jsp"%>