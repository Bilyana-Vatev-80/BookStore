$(document).ready(function () {
    $(".btn.btn-danger").on("click", function () {
        $("#deleteConfirmModal").modal("toggle");
    });
});

$(document).ready(function () {
    $(".btn-close").on("click", function () {
        $("#deleteConfirmModal").modal("toggle");
    });
});

