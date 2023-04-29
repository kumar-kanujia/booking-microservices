<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container py-5 shadow-lg mt-5">
    <div class="card shadow-sm">
        <div class="card-header text-bg-dark text-white">
            <h2 class="mb-0">Movie Ticket</h2>
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <div class="col-md-4">
                    <strong>Ticket ID:</strong> #${ticket.id}
                </div>
                <div class="col-md-4">
                    <strong>Movie Name:</strong> ${ticket.title}
                </div>
                <div class="col-md-4">
                    <strong>Movie Date & Time:</strong> ${ticket.date} at ${ticket.slotTime}
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <strong>Seat Number:</strong> ${ticket.tier}:${ticket.seatNo}
                </div>
                <div class="col-md-4">
                    <strong>Price:</strong> $${ticket.price}
                </div>
                <div class="col-md-4">
                    <strong>Car Number:</strong> ${ticket.carNumber}
                </div>
            </div>
        </div>

        <div class="container text-center btn-outline-primary">
            <input value='Print' type='button' onclick='handlePrint()' class="btn btn-outline-danger"/>
            <a href="${pageContext.request.contextPath}/cancelTicket?id=${ticket.id}" class="btn btn-outline-danger" methods="">Cancel</a>
        <script type="text/javascript">
            const handlePrint = () => {
                var actContents = document.body.innerHTML;
                document.body.innerHTML = actContents;
                window.print();
            }
        </script>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>