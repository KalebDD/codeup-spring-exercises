
$('#editModal').on('show.bs.modal', function (e) {
    var button = $(e.relatedTarget); // Button that triggered the modal
    var postId = button.data('id'); // Extract info from data-* attributes
    var postTitle = button.data('title');
    var postDescription = button.data('description');

    // Update the modal's content
    var modal = $(this);
    modal.find('#editPostId').val(postId);
    modal.find('#editPostTitle').val(postTitle);
    modal.find('#editPostDescription').val(postDescription);
});


$('#deleteModal').on('show.bs.modal', function (e) {
    var button = $(e.relatedTarget); // Button that triggered the modal
    var postId = button.data('id'); // Extract info from data-* attributes

    // Update the modal's content
    var modal = $(this);
    modal.find('#deletePostId').val(postId);
});

$('.blog-category').click(function() {
   let category = $(this).text();
   let blogs = $('.selected-blogs');

    console.log(category);
    console.log(blogs);

    for (let i = 0; i < blogs.length; i++) {
        if (blogs[i].hasClass(category)) {
            blogs[i].css('display', 'show');
        } else {
            blogs[i].css('display', 'none');
        }
    }
});