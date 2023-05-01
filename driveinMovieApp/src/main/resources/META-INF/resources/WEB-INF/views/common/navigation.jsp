<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Cinematic</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/catalog">Movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/searchSlot?title=">Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/viewTicket">Ticket</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCatalog" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Catalog
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownCatalog">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addMovie">Add</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/adminCatalog">View</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownSchedule" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Schedule
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownSchedule">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addSchedule">Add</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/viewSchedule">Search</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="${pageContext.request.contextPath}/searchMovie" method="post">
                <input id="title" name="title" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" required="required">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
