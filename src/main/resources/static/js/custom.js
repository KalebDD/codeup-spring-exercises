
$('#editModal').on('show.bs.modal', function (e) {
    var button = $(e.relatedTarget); // Button that triggered the modal
    var postId = button.data('id'); // Extract info from data-* attributes

    // Update the modal's content.
    var modal = $(this);
    modal.find('.modal-content #editPostId').val(postId);
});


$('#deleteModal').on('show.bs.modal', function (e) {
    var button = $(e.relatedTarget); // Button that triggered the modal
    var postId = button.data('id'); // Extract info from data-* attributes

    // Update the modal's content.
    var modal = $(this);
    modal.find('.modal-content #deletePostId').val(postId);
});