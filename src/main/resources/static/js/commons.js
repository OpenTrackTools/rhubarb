$(document).ready(function() {
    tinymce.init({
        selector: 'textarea.rt-editor',
        menubar: false,
        elementpath: false,
        plugins: 'link table'
      });
})