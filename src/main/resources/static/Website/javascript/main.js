function loggedIn() {
    let logout = document.createElement('a');
    let x = document.querySelector('a');
    let div = document.querySelector('#logarea');
    logout.onclick = function () {
      document.cookie = 'Key=; max-age=0; path=/;';
      showguest();
    };
    logout.setAttribute('class', 'navbar-link');
  
    if (document.cookie) {
      logout.innerHTML = 'Logout';
      div.innerHTML = '';
      div.appendChild(logout);
    } else {
      showguest();
    }
  }
  
  function showguest() {
    let div = document.querySelector('#logarea');
    div.innerHTML = `<a class="navbar-link" href="/login">Log in</a> | <a class="navbar-link" href="/register">Sign Up</a>`;
  }
  