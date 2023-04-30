<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container mt-4">
    <h1 class="text-center my-5">Sundown Form</h1>
    <form:form modelAttribute="slot" action="${pageContext.request.contextPath}/bookTicket"  method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <form:input path="title" type="text" class="form-control" id="title" name="title" readonly="true"/>
        </div>
        <div class="mb-3">
            <label for="date" class="form-label">Date</label>
            <form:input path="date" type="date" class="form-control" id="date" name="date" readonly="true"/>
        </div>
        <div class="mb-3">
            <label for="time" class="form-label">Time</label>
            <form:input path="slotTime" type="text" class="form-control" id="time" name="surname" readonly="true"/>
        </div>
        <div class="mb-3">
            <label for="carNumber" class="form-label">Car Number</label>
            <input type="text" class="form-control" id="carNumber" name="carNumber" required>
        </div>
        <div class="mb-3">
            <label for="tier" class="form-label">Tier</label>
            <select class="form-select" id="tier" name="tier" required>
                <option value="a">Supreme</option>
                <option value="b">General</option>
                <option value="c">Economy</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
<%@ include file="common/footer.jsp"%>