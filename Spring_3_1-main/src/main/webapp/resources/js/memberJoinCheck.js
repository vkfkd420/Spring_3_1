/**
 * 
 */

function check() {
  let result = document.getElementById("all");
  let ch = document.getElementsByClassName("ch");

  for(let c of ch){
   c.checked = result.checked;
  }

}