const btn = document.querySelector("button");
const result = document.querySelector(".result-box");
let list = [];
const input = document.querySelector("#input-box");

const debouncedSearch = debounce(search,300);
input.addEventListener("keyup",debouncedSearch);
db = new Trie()
getWords(db)

async function getWords(db){
  const res = await fetch("./words.txt");
  const data = await res.text();
  data.split("\n").forEach((item)=>{
    item = item.trim()
    db.insert(item);
  })
}

function debounce(fn,wait){
  let id = null;
  return function(...args){
    window.clearTimeout(id);
    return setTimeout(()=>fn(args),wait);
  }
}

function selectText(e){
  const text =e.innerHTML;
  list.push(text);
  input.value = list.join(' ');
  result.innerHTML = "";
  input.value+=" "
  input.focus()
}

function display(arr){
  const ul = document.createElement("ul");
  arr.forEach((item,index)=>{
    const node = document.createElement('li');
    node.setAttribute("onclick",'selectText(this)');
    node.setAttribute("onkeypress",'selectText(this)');
    node.setAttribute("tabindex",index+1);
    node.innerText = item;
    ul.appendChild(node);
  })
  result.appendChild(ul);
}


function search(e){
  const words = input.value.split(" ");
  if(!words.length) return;
  result.innerHTML = "";
  const word = words[words.length-1];
  if(!word.length) return;
  const res = db.search(word);
  list = [...words.slice(0,words.length-1)]
  display(res)
}


