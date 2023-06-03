function filterBooks() {
    var subject = document.getElementById("subject-filter").value.toLowerCase();
    var title = document.getElementById("title-filter").value.toLowerCase();
    var author = document.getElementById("author-filter").value.toLowerCase();
    var publishDate = document.getElementById("publish-date-filter").value.toLowerCase();

    var table = document.getElementById("books-table");
    var rows = table.getElementsByTagName("tr");

    for (var i = 1; i < rows.length; i++) {
        var row = rows[i];
        var cells = row.getElementsByTagName("td");

        var bookSubject = cells[1].textContent.toLowerCase(); 
        var bookTitle = cells[2].textContent.toLowerCase();
        var bookAuthor = cells[3].textContent.toLowerCase();
        var bookPublishDate = cells[4].textContent.toLowerCase();

        var shouldDisplay = true;

        if (title && !bookTitle.includes(title)) {
            shouldDisplay = false;
        }

        if (author && !bookAuthor.includes(author)) {
            shouldDisplay = false;
        }

        if (subject && !bookSubject.includes(subject)) {
            shouldDisplay = false;
        }

        if (publishDate && !bookPublishDate.includes(publishDate)) {
            shouldDisplay = false;
        }

        row.style.display = shouldDisplay ? "" : "none";
    }
}
