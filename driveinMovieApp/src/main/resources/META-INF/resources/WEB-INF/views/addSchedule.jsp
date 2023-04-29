<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12 col-12">
            <form:form modelAttribute="schedule" class="border p-3" action="${pageContext.request.contextPath}/updateSchedule" method="post">
                <div class="m-md-5 text-center">
                    <h5 class="card-title">Upcoming Showtime</h5>
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Date (Upcoming)</label>
                    <form:input path="date" type="date" class="form-control" id="date" name="date" readonly="false"/>
                </div>
                <div class="mb-3">
                    <h4>3AM</h4>
                    <div class="row">
                        <div class="col">
                            <label for="title1" class="form-label">Title</label>
                            <form:input path="slot1.title" type="text" class="form-control" id="title1" name="title1" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier1" class="form-label">Tier 1 Price</label>
                            <form:input path="slot1.tier1Price" type="number" class="form-control" id="tier1" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier2" class="form-label">Tier 2 Price</label>
                            <form:input path="slot1.tier2Price" type="number" class="form-control" id="tier2" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier3" class="form-label">Tier 3 Price</label>
                            <form:input path="slot1.tier3Price" type="number" class="form-control" id="tier3" name="tier1" min="0" readonly="false"/>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <h4>9PM</h4>
                    <div class="row">
                        <div class="col">
                            <label for="title1" class="form-label">Title</label>
                            <form:input path="slot2.title" type="text" class="form-control" id="title1" name="title1" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier1" class="form-label">Tier 1 Price</label>
                            <form:input path="slot2.tier1Price" type="number" class="form-control" id="tier1" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier2" class="form-label">Tier 2 Price</label>
                            <form:input path="slot2.tier2Price" type="number" class="form-control" id="tier2" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier3" class="form-label">Tier 3 Price</label>
                            <form:input path="slot2.tier3Price" type="number" class="form-control" id="tier3" name="tier1" min="0" readonly="false"/>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <h4>12AM</h4>
                    <div class="row">
                        <div class="col">
                            <label for="title1" class="form-label">Title</label>
                            <form:input path="slot3.title" type="text" class="form-control" id="title1" name="title1" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier1" class="form-label">Tier 1 Price</label>
                            <form:input path="slot3.tier1Price" type="number" class="form-control" id="tier1" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier2" class="form-label">Tier 2 Price</label>
                            <form:input path="slot3.tier2Price" type="number" class="form-control" id="tier2" name="tier1" min="0" readonly="false"/>
                        </div>
                        <div class="col">
                            <label for="tier3" class="form-label">Tier 3 Price</label>
                            <form:input path="slot3.tier3Price" type="number" class="form-control" id="tier3" name="tier1" min="0" readonly="false"/>
                        </div>
                    </div>
                </div>
                <div class="text-center m-md-5">
                    <input type="submit" class="btn btn-primary" value="Create">
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp"%>