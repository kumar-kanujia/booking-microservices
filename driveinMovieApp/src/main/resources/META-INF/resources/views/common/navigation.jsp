<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Movie Box</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ticket</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCatalog" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Catalog
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownCatalog">
                        <li><a class="dropdown-item" href="#">Add</a></li>
                        <li><a class="dropdown-item" href="#">Search</a></li>
                        <li><a class="dropdown-item" href="#">View</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownSchedule" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Schedule
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownSchedule">
                        <li><a class="dropdown-item" href="#">Add</a></li>
                        <li><a class="dropdown-item" href="#">Search</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex m-3">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <div class="d-flex">
                <button class="btn btn-outline-light me-2" type="button">Login</button>
            </div>
        </div>
    </div>
</nav>
