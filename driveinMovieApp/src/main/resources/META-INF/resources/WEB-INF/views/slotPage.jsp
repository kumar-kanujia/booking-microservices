<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container mt-5">
    <div class="container mt-4">
        <div class="container-fluid">
        <form class="d-flex" action="${pageContext.request.contextPath}/searchSlotByDate" method="post">
            <label for="date" class="d-inline">Search by date:</label>
            <input type="date" class="form-control mx-2" id="date" name="date">
            <label>
                <input type="text" hidden="hidden" id="title" name="title" value="${title}">
            </label>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        </div>
        <div class="container-fluid md-5 mt-4">
        <table class="table table-striped">
            <thead>
            <tr class="text-center">
                <th>Title</th>
                <th>Date</th>
                <th>Time</th>
                <th>Card</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfSlots}" var="parking">
            <tr class="text-center">
                <td>${parking.title}</td>
                <td>${parking.date}</td>
                <td>${parking.slotTime}</td>
                <td>
                    <h6>Supreme: ${parking.tier1}</h6>
                    <h6>Genral: ${parking.tier2}</h6>
                    <h6>Econmy: ${parking.tier3}</h6>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/bookTicket?slotId=${parking.id}" type="button"  class="btn btn-outline-primary">Book</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>