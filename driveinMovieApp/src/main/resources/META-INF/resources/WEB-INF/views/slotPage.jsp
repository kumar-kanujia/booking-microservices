<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container mt-5">
    <div class="container mt-4">
        <div class="container-fluid md-5 mt-4">
        <table class="table table-striped">
            <thead>
            <tr class="text-center">
                <th>Movie</th>
                <th>Date</th>
                <th>Time</th>
                <th>Seat</th>
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
                    <a href="${pageContext.request.contextPath}/bookTicket?slotId=${parking.id}" type="button"  class="btn btn-outline-primary">Book Now</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>