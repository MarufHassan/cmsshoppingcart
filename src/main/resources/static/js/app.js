$(function() {
    $("a.confirmDeletion").click(function() {
        if (!confirm("Confirm Deletion")) return false;
    });
});