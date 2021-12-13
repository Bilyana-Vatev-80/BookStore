// $(document).ready(function () {
//     $('#sidebarCollapse').on('click', function () {
//         $('#sidebar').toggleClass('active');
//     });
// });

window.addEventListener('load', function () {
    document.getElementById('sidebarCollapse')
        .addEventListener('click', function () {
            document.getElementById('sidebar').classList.toggle('active');
        });
});


