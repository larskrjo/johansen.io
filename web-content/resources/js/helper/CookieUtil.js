define({
  getSessionId: function () {
    var pairs = document.cookie.split(';');
    var cookies = {};
    for (var i=0; i<pairs.length; i++){
      var pair = pairs[i].split('=');
      cookies[pair[0]] = decodeURI(pair[1]);
    }
    return cookies['sessionId'];
  },
  deleteSession: function () {
    document.cookie = 'sessionId' + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  }
});

