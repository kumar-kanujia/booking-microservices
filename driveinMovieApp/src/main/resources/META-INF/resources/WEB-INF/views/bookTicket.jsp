<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container pt-5">
    <h1 class="text-center my-5">Sundown Form</h1>
    <form>
        <div class="mb-3">
            <label for="title" class="form-label">Title Date And Time</label>
            <input type="text" class="form-control" id="title" name="title" readonly>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="surname" class="form-label">Surname</label>
            <input type="text" class="form-control" id="surname" name="surname" required>
        </div>
        <div class="mb-3">
            <label for="carnumber" class="form-label">Car Number</label>
            <input type="text" class="form-control" id="carnumber" name="carnumber" required>
        </div>
        <div class="mb-3">
            <label for="dropdown" class="form-label">Tier</label>
            <select class="form-select" id="dropdown" name="dropdown" required>
                <option value="">Select an option</option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="common/footer.jsp"%>