
const threatbox = document.querySelector("#content");

function sendHttpRequest(method, url) {
    let headers = {
      "Content-Type": "application/json",
      "Key":document.cookie.split("=")[1]
    }
    console.log(headers);
      return fetch(url, {
        method: method,
        headers: headers,
      })
        .then((response) => {
          status = response.status;
          if (response.status >= 200 && response.status < 300) {
            
            return response.json();
          } else {
            if (response.status == 401) {
              alert("You are either not logged in or have an invalid User Key. Please log in to fix this.  If this issue persists, please contact support.");
            }
            return response.json().then((errData) => {
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

    async function SetupThreats(){
    
      let targets = (await sendHttpRequest("GET",`/threat/all`))
      let i= 0;
      if(targets.length>0){
        threatbox.innerHTML="";
      }
   
      targets.forEach(target => {
          if(i<8){
          let t = `
          <div id = "content" class="content">
          <a href="/threat?id=`+target.id +`">
            <div class="content-overlay"></div>
            <img class="content-image" src="`+target.image+`">
            <div class="content-details fadeIn-bottom">
              <h3 class="content-title">`+target.name+`</h3>
              <p class="content-text">Level:`+target.level+ "</br>" +target.species+ "</br>" +target.chp+ "/" +target.maxHp*target.level+`</p>
            </div>
          </a>
        </div>     
          </a>
      </div>`
      threatbox.innerHTML+= t;
      i++;
   }
      });
  }
  