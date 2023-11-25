document.addEventListener('DOMContentLoaded', function () {
    var scrollDownBtn = document.querySelector('.scroll-down-btn a');
  
    scrollDownBtn.addEventListener('click', function (e) {
      e.preventDefault();
      var targetSection = document.getElementById('services');
      var startPosition = window.pageYOffset;
      var targetPosition = targetSection.offsetTop;
      var distance = targetPosition - startPosition;
      var startTime;
      var duration = 1000; // temps en millisecondes
  
      function animation(currentTime) {
        if (startTime === undefined) startTime = currentTime;
        var timeElapsed = currentTime - startTime;
        var run = ease(timeElapsed, startPosition, distance, duration);
        window.scrollTo(0, run);
        if (timeElapsed < duration) requestAnimationFrame(animation);
      }
  
      function ease(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return (c / 2) * t * t + b;
        t--;
        return (-c / 2) * (t * (t - 2) - 1) + b;
      }
  
      requestAnimationFrame(animation);
    });
  });
  