$(function () {
    var url = window.location;
    App = {
      baseUrl: url,
      apiUrl: url + 'api/'
    }

    ImageManager = {
      loadImages : function (cb) {
        return $.get(App.apiUrl + 'image',function (data){cb(data)});
      }
    }
});
