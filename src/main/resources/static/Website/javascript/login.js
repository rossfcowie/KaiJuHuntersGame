

const getUserName = document.querySelector("#uname");
const getPassword = document.querySelector("#pass");
const getConfirmationPassword = document.querySelector("#confpassword");
const loginBtn = document.querySelector("#login");
var status;

function sendHttpRequest(method, url, data) {
  console.log(data);
  return fetch(url, {
    method: method,
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      status = response.status;
      if (response.status >= 200 && response.status < 300) {
        return response.text();
      } else {
        return response.text().then((errData) => {
          console.log(errData);
          throw new Error("Something went wrong - server-side");
        });
      }
    })
    .catch((error) => {
      console.log(error);
      throw new Error("Something went wrong");
    });
}

async function Login(uname, pass) {
  const post = {
    uname: uname,
    pass: pass,
  };
  document.cookie =
    "Key =" +(await sendHttpRequest("POST", `/users/login`, post));
  console.log(status);
  if (status == 200) {
    document.cookie = document.cookie +"; expires=18 Dec 2030 12:00:00 UTC; path=/;";
    console.log("It works!");
    window.location.href = "/home";
  }
  status = 0;
}

loginBtn.addEventListener("click", (event) => {
  event.preventDefault();
  const enteredUserName = getUserName.value;
  const enteredPassword = getPassword.value;
  if (validatePassword) {
    Login(enteredUserName, enteredPassword);
  } else {
    console.log("Passwords do not match!");
  }
});

function validatePassword() {
  if (getPassword.value != getConfirmationPassword.value) {
    alert("Passwords do not match.");
    return false;
  }
  return true;
}
