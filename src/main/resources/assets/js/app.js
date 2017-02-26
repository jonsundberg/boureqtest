


$( document ).ready(function() {

  var loader = {
    start : function () {
      $('#spin-me').addClass('fa-spin');
    },
    stop: function () {
      $('#spin-me').removeClass('fa-spin');
    }


  };

  var loadImages = function () {
    loader.start()
    ImageManager.loadImages(function (data) {
      if (data === undefined || data.length == 0) {
        loadImages();
      }
      else{
        var source = $('#image-template').html();
        var template = Handlebars.compile(source);
        $('#image-holder').html(template({images : data}));
        loader.stop();
      }

    });
  }


  var interval;;
  var timer = function () {
    interval = setInterval(function () {
        loadImages();
    },30000);
  }

  loadImages();
  timer();


  $('#image-loader').on('click', function (){
    clearInterval(interval);
    loadImages();
    timer();
  });

});
